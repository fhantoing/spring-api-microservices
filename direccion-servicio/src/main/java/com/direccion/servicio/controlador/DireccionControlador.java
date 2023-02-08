package com.direccion.servicio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.direccion.servicio.DireccionServicio.DireccionServicio;
import com.direccion.servicio.entidades.Direccion;

@RestController
@RequestMapping("/direccion")
public class DireccionControlador {
 
	@Autowired
	private DireccionServicio direccionServicio;
	
	@GetMapping
	public ResponseEntity<List<Direccion>> listarDirecciones() {
		List<Direccion> direcciones = direccionServicio.getAll();

		if (direcciones.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(direcciones);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Direccion> obtenerDireccion(@PathVariable("id") int id) {
		Direccion direccion = direccionServicio.getDireccionById(id);

		if (direccion == null) {
			ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(direccion);
	}

	@PostMapping
	public ResponseEntity<Direccion> guardarDireccion(@RequestBody Direccion direccion) {
		Direccion nuevaDireccion = direccionServicio.save(direccion);
		return ResponseEntity.ok(nuevaDireccion);
	}
	
	@GetMapping("/cliente/{clienteId}")
	public ResponseEntity<List<Direccion>> obtenerDireccionPorCalle(@PathVariable("clienteId") int id){
		List<Direccion> direcciones = direccionServicio.findByClienteId(id);
		
		if (direcciones.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(direcciones);
	}
}
