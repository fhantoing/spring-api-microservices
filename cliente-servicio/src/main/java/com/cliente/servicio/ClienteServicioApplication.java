package com.cliente.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ClienteServicioApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ClienteServicioApplication.class);

		app.run(args);
	}

}
