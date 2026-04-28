package com.controlReparaciones.controlReparaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ControlReparacionesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ControlReparacionesApplication.class, args);
                
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      String password = encoder.encode("euni");
      System.out.println(password);
    }
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper;
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
