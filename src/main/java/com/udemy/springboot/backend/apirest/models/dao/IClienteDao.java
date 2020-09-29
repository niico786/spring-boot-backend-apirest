package com.udemy.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.udemy.springboot.backend.apirest.models.entity.Cliente;
import com.udemy.springboot.backend.apirest.models.entity.Region;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
	
	@Query("FROM Region")
	public List<Region> findAllRegiones();
	
}
