package com.williams.GestionLibreria.dao;

import java.util.List;

import com.williams.GestionLibreria.entities.Libro;
import com.williams.GestionLibreria.entities.enums.Genero;

/**
 * 
 * Data Access Object
 *
 * Métodos CRUD - Create Retrive Update Delete
 * 
 */

public abstract interface LibroDAO extends GeneralDAO<Libro>{
	
	/**
	 * Busca un libro por su id
	 * 
	 * @param id
	 * @return Libro
	 */
	public Libro findById(Long id);
	
	/**
	 * Busca todos los libros con el mismo género 
	 * 
	 * @param genero (ENUM)
	 * @return lista de libros
	 */
	public List<Libro> findByGenre(Genero genero);
	
}
