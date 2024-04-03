package com.williams.GestionLibreria.dao;

import java.util.List;

public interface GeneralDAO<T> {
	/**
	 * Recuperar todos los libros de base de datos
	 * 
	 * @return lista de libros
	 */
	public List<T> findAll();
	
	/**
	 * Inserta un nuevo registro en la tabla libros
	 * 
	 * @param entity
	 * @return Libro
	 */
	public T create(T entity);
	
	/**
	 * Actualiza un registro existente en la tabla libros
	 * 
	 * @param entity
	 * @return Libro
	 */
	public T update(T entity);
	
	/**
	 * Borrar un libro de la base de datos
	 * 
	 * @param entity
	 * @return boolean
	 */
	public boolean delete(T entity);
}
