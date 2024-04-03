package com.williams.GestionLibreria.services;

import com.williams.GestionLibreria.entities.Libro;
import com.williams.GestionLibreria.entities.enums.Genero;

/**
 * Servico que accede a LibroDAO
 * En el servicio se encuentra la lógica de negocio
 * 
 */
public interface LibroService {

	public String findAll();
	
	public String findById(Long id);
	
	public String findByGenre(Genero genero);
	
	public String addLibrary(Long id_libro, Long id_libreria);
	
	public String create(Libro libro);
	
	public String update(Long id, String isbn);
	
	public String delete(Long id);
}
