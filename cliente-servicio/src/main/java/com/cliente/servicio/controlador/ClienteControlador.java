package com.cliente.servicio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.servicio.entidades.Cliente;
import com.cliente.servicio.modelo.Direccion;
import com.cliente.servicio.servicio.ClienteServicio;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/cliente")
public class ClienteControlador {

	@Autowired
	private ClienteServicio clienteServicio;

	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> clientes = clienteServicio.getAll();

		if (clientes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obtenerCliente(@PathVariable("id") int id) {
		Cliente cliente = clienteServicio.getClienteById(id);

		if (cliente == null) {
			ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(cliente);
	}

	@PostMapping
	public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente) {
		Cliente nuevoCliente = clienteServicio.save(cliente);
		return ResponseEntity.ok(nuevoCliente);
	}

	@CircuitBreaker(name = "direccionCB", fallbackMethod = "fallbackListarDirecciones")
	@GetMapping("/direccion/{clienteId}")
	public ResponseEntity<List<Direccion>> listarDirecciones(@PathVariable("clienteId") int id) {

		Cliente cliente = clienteServicio.getClienteById(id);

		if (cliente == null) {
			ResponseEntity.noContent().build();
		}

		List<Direccion> direcciones = clienteServicio.getDirecciones(id);
		return ResponseEntity.ok(direcciones);
	}

	@CircuitBreaker(name = "direccionCB", fallbackMethod = "fallbackGuardarDireccion")
	@PostMapping("/direccion/{clienteId}")
	public ResponseEntity<Direccion> guardarDireccion(@PathVariable("clienteId") int id,
			@RequestBody Direccion direccion) {

		Direccion nuevaDireccion = clienteServicio.save(id, direccion);
		return ResponseEntity.ok(nuevaDireccion);
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	private ResponseEntity<List<Direccion>> fallbackListarDirecciones(@PathVariable("clienteId") int id,
			RuntimeException ex) {
		return new ResponseEntity("Ha ocurrido un inconveniente al consultar las direcciones del Cliente: " + id,
				HttpStatus.OK);
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	private ResponseEntity<List<Direccion>> fallbackGuardarDireccion(@PathVariable("clienteId") int id,
			@RequestBody Direccion direccion, RuntimeException ex) {
		return new ResponseEntity("Ha ocurrido un inconveniente al guardar las direccion del Cliente: " + id,
				HttpStatus.OK);
	}

}
