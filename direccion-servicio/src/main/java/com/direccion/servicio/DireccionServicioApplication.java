package com.direccion.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DireccionServicioApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DireccionServicioApplication.class);

		//app.setDefaultProperties(Collections.singletonMap("server.port", "7072"));
		app.run(args);
	}

}
