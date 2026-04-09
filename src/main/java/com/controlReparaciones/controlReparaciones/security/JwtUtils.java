/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controlReparaciones.controlReparaciones.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author gramirez25
 */

@Component
public class JwtUtils {
    
    private String SECRET_KEY = "backPr";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * *****RASTREO DE TOKENS EXPIRADOS CUANDO SE RECOMPILA EL PROYECTO (CARGA
     * AL SERVIDOR)****** Invalidar los tokens al arrancar la aplicación, para
     * que cuando se cargue al servidor el proyecto requiera a los usuarios
     * logeados su generación de token nuevamente
     */
    
    @PostConstruct
    public void invalidateTokensOnStartup() {
        String query = "UPDATE jwt_tokens SET expired = true";
        jdbcTemplate.update(query);
    }
    
    // Programa la limpieza de tokens expirados. Ejecución diaria a las 2 AM
    @Scheduled(cron = "0 0 2 * * ?")
    public void removeExpiredTokens() {
        String query = "DELETE FROM jwt_tokens WHERE expired = true";
        int deletedRows = jdbcTemplate.update(query);
        System.out.println("Tokens eliminados: " + deletedRows);
    }
    
    // Verifica si el token tiene estatus uno en la base de datos
    private Boolean isTokenExpiredInDatabase(String token) {
        String query = "SELECT expired FROM jwt_tokens WHERE token = ?";
        try {
            Boolean expired = jdbcTemplate.queryForObject(query, Boolean.class, token);
            return expired != null && expired;
        } catch (Exception e) {
            // Si no se encuentra el token, se considera como expirado
            return true;
        }
    }
    
    // Método para guardar el token en la base de datos
    private void saveToken(String token) {
        String query = "INSERT INTO jwt_tokens (token) VALUES (?)";
        jdbcTemplate.update(query, token);
    }
    
    //********************MÉTODOS JWT********************
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        String token = createToken(claims, userDetails.getUsername());
        // Guardar el token en la base de datos (tabla jwt_tokens)
        saveToken(token);
        return token;
    }
    
    private String createToken(Map<String, Object> claims, String subject) {
        long expirationTimeInMillis = 1000 * 60 * 60 * 6; // 6 horas en milisegundos
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTimeInMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        //Se valida si el token está expirado en la base de datos, que no esté expirado y que corresponda el nombre de usuario
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token) && !isTokenExpiredInDatabase(token));
    }

    public String refreshToken(String token) {
        Claims claims = extractAllClaims(token);
        String username = claims.getSubject();
        return createToken(new HashMap<>(), username);
    }
    
}
