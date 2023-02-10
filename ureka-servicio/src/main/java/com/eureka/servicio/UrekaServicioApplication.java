package com.eureka.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UrekaServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrekaServicioApplication.class, args);
	}

}
