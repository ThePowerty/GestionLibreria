package com.williams.GestionLibreria.services;

import com.williams.GestionLibreria.entities.Direccion;

/**
 * Servico que accede a LibreriaDAO
 * En el servicio se encuentra la lógica de negocio
 * 
 */
public interface LibreriaService {

	public String findAll();
	
	public String findById(Long id);
	
	public void addBook(Long id_libreria, Long id_libro);
	
	public void addDirection(Long id, Direccion direccion);
}
