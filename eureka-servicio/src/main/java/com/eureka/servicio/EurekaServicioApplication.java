package com.eureka.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableEurekaServer
public class EurekaServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServicioApplication.class, args);
	}

}
