package com.cliente.servicio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cliente.servicio.clientesfeign.DireccionFeign;
import com.cliente.servicio.entidades.Cliente;
import com.cliente.servicio.modelo.Direccion;
import com.cliente.servicio.repositorio.ClienteRepositorio;

@Service
public class ClienteServicio {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Autowired
	private DireccionFeign direccionFeign;

	public List<Direccion> getDirecciones(int clienteId) {
		List<Direccion> direcciones = restTemplate.getForObject("http://direccion-service/direccion/cliente/" + clienteId,
				List.class);
		return direcciones;
	}

	public Direccion save(int clienteId, Direccion direccion) {
		direccion.setClienteId(clienteId);

		Direccion nuevaDireccion = direccionFeign.save(direccion);

		return nuevaDireccion;
	}

	public List<Cliente> getAll() {
		return clienteRepositorio.findAll();
	}

	public Cliente getClienteById(int id) {
		return clienteRepositorio.findById(id).orElse(null);
	}

	public Cliente save(Cliente cliente) {
		Cliente nuevoCliente = clienteRepositorio.save(cliente);
		return nuevoCliente;
	}
}
