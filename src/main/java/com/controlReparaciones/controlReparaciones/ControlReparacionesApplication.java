package com.controlReparaciones.controlReparaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ControlReparacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlReparacionesApplication.class, args);
                
//                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//                String password = encoder.encode("admin");
//                System.out.println(password);
	}

}
