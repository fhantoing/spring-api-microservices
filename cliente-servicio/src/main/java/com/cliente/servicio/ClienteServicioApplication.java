package com.cliente.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClienteServicioApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ClienteServicioApplication.class);

		//app.setDefaultProperties(Collections.singletonMap("server.port", "7071"));
		app.run(args);
	}

}
