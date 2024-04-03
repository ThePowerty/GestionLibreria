package com.williams.GestionLibreria.dao;

import com.williams.GestionLibreria.entities.Direccion;

/**
 * 
 * Data Access Object
 *
 * Métodos CRUD - Create Retrive Update Delete
 * 
 */

public interface DireccionDAO extends GeneralDAO<Direccion>{
	
	/**
	 * Buscar una direccion por su id
	 * 
	 * @param id
	 * @return Direccion
	 */
	public Direccion findById(Long id);


}
