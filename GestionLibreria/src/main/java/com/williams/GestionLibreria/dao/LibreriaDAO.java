package com.williams.GestionLibreria.dao;

import java.util.List;

import com.williams.GestionLibreria.entities.Libreria;
import com.williams.GestionLibreria.entities.Libro;
import com.williams.GestionLibreria.entities.enums.Genero;

/**
 * 
 * Data Access Object
 *
 * Métodos CRUD - Create Retrive Update Delete
 * 
 */

public interface LibreriaDAO extends GeneralDAO<Libreria>{
	
	/**
	 * Busca una Libreria por su id
	 * 
	 * @param id
	 * @return Libreria
	 */
	public Libreria findById(Long id);
	
	/**
	 * Busca todos los libros con el mismo género dentro de la libreria
	 * 
	 * @param genero (ENUM)
	 * @return lista de libros
	 */
	public List<Libro> findByGenre(Genero genero);

}
