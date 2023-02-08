package com.cliente.servicio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/direccion/{clienteId}")
	public ResponseEntity<List<Direccion>> listarDirecciones(@PathVariable("clienteId") int id) {

		Cliente cliente = clienteServicio.getClienteById(id);

		if (cliente == null) {
			ResponseEntity.noContent().build();
		}

		List<Direccion> direcciones = clienteServicio.getDirecciones(id);
		return ResponseEntity.ok(direcciones);
	}

	@PostMapping("/direccion/{clienteId}")
	public ResponseEntity<Direccion> guardarDireccion(@PathVariable("clienteId") int id,
			@RequestBody Direccion direccion) {

		Direccion nuevaDireccion = clienteServicio.save(id, direccion);
		return ResponseEntity.ok(nuevaDireccion);
	}

}
