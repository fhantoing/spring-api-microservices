package com.direccion.servicio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.direccion.servicio.entidades.Direccion;

@Repository
public interface DireccionRepositorio extends JpaRepository<Direccion, Integer>{
	
	List<Direccion> findByClienteId(int id);
}