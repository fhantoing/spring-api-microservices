package com.direccion.servicio.DireccionServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direccion.servicio.entidades.Direccion;
import com.direccion.servicio.repositorio.DireccionRepositorio;

@Service
public class DireccionServicio {

	@Autowired
	private DireccionRepositorio direccionRepositorio;

	public List<Direccion> getAll() {
		return direccionRepositorio.findAll();
	}

	public Direccion getDireccionById(int id) {
		return direccionRepositorio.findById(id).orElse(null);
	}

	public Direccion save(Direccion direccion) {
		Direccion nuevaDireccion = direccionRepositorio.save(direccion);
		return nuevaDireccion;
	}

	public List<Direccion> findByClienteId(int id) {
		return direccionRepositorio.findByClienteId(id);
	}
}
