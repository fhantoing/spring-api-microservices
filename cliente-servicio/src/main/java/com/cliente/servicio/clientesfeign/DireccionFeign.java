package com.cliente.servicio.clientesfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.servicio.modelo.Direccion;

@FeignClient(name = "direccion-service", url = "http://localhost:7052")
@RequestMapping("/direccion")
public interface DireccionFeign {

	@PostMapping()
	Direccion save(@RequestBody Direccion direccion);
	
	@GetMapping("/direccion/{clienteId}")
	List<Direccion> getDirecciones(@PathVariable("clienteId") int id);
}
