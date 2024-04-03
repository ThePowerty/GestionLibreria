package com.williams.GestionLibreria.services.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.williams.GestionLibreria.dao.LibreriaDAO;
import com.williams.GestionLibreria.dao.LibroDAO;
import com.williams.GestionLibreria.dao.impl.LibreriaDAOImpl;
import com.williams.GestionLibreria.dao.impl.LibroDAOImpl;
import com.williams.GestionLibreria.entities.Direccion;
import com.williams.GestionLibreria.entities.Libreria;
import com.williams.GestionLibreria.entities.Libro;
import com.williams.GestionLibreria.services.LibreriaService;
import com.williams.GestionLibreria.util.HibernateUtil;

public class LibreriaServiceImpl implements LibreriaService{

	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static LibreriaDAO libreriaDAO = new LibreriaDAOImpl(sessionFactory);
	static LibroDAO libroDAO = new LibroDAOImpl(sessionFactory);

	public String findAll() {
		String cadena = "";
		try {
			List<Libreria> librerias = libreriaDAO.findAll();
			for (Libreria libreria : librerias) {
				cadena += libreria.toString();
			}
		} catch (Exception e) {
			return "..::ERROR en el listado de librerias::..";
		}		
		return cadena;
	}
	
	public String findById(Long id) {

		Libreria libreria;
		try {
			libreria = libreriaDAO.findById(id);
		} catch (Exception e) {
			return "..::ERROR, libreria no encontrada::..";
		}
		return libreria.toString();
	}
	
	public void addBook(Long id_libreria, Long id_libro) {
		try {
			Libreria libreria = libreriaDAO.findById(id_libreria);
			Libro libro = libroDAO.findById(id_libro);
			libreria.getLibros().add(libro);
			libreriaDAO.update(libreria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addDirection(Long id, Direccion direccion) {
		try {
			Libreria libreria = libreriaDAO.findById(id);
			libreria.setDireccion(direccion);
			libreriaDAO.update(libreria);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
