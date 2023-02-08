package com.configuracion.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfiguracionServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfiguracionServicioApplication.class, args);
	}

}
