package com.williams.GestionLibreria.services.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.williams.GestionLibreria.dao.LibreriaDAO;
import com.williams.GestionLibreria.dao.LibroDAO;
import com.williams.GestionLibreria.dao.impl.LibreriaDAOImpl;
import com.williams.GestionLibreria.dao.impl.LibroDAOImpl;
import com.williams.GestionLibreria.entities.Libreria;
import com.williams.GestionLibreria.entities.Libro;
import com.williams.GestionLibreria.entities.enums.Genero;
import com.williams.GestionLibreria.services.LibroService;
import com.williams.GestionLibreria.util.HibernateUtil;

public class LibroServiceImpl implements LibroService{

	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	static LibroDAO libroDAO = new LibroDAOImpl(sessionFactory);
	static LibreriaDAO libreriaDAO = new LibreriaDAOImpl(sessionFactory);

	public String findAll() {
		String cadena = "";
		try {
			List<Libro> libros = libroDAO.findAll();
			for (Libro libro : libros) {
				cadena += libro.toString();
			}
		} catch (Exception e) {
			return "..::ERROR en el listado de libros::..";
		}		
		return cadena;
	}

	public String findById(Long id) {
		Libro libro;
		try {
			libro = libroDAO.findById(id);
		} catch (Exception e) {
			return "..::ERROR, libro no encontrado::..";
		}
		return libro.toString();
	}

	public String findByGenre(Genero genero) {
		String cadena = "";
		try {
			List<Libro> libros = libroDAO.findByGenre(genero);
			for (Libro libro : libros) {
				cadena += libro.toString();
			}
		} catch (Exception e) {
			return "..::ERROR, libro no encontrado::..";
		}
		return cadena;
	}

	public String addLibrary(Long id_libro, Long id_libreria) {
		Libro libro;
		try {
			libro = libroDAO.findById(id_libro);
			Libreria libreria = libreriaDAO.findById(id_libreria);
			libro.getLibrerias().add(libreria);
			libroDAO.update(libro);
			
		} catch (Exception e) {
			return "..::ERROR en la asignacion de libreria::..";
		}
		return "Libreria asignada correctamente";
	}
	
	public String create(Libro libro) {
		Long id;
		try {
			id = libroDAO.create(libro).getId();
		} catch (Exception e) {
			return "..::ERROR en la creacion del libro::..";
		}
		return "Libro creado correctamente con id: " + id;
	}

	public String update(Long id, String isbn) {
		Libro libro_update;
		try {
			libro_update = libroDAO.findById(id);
			libro_update.setIsbn(isbn);
			libro_update = libroDAO.update(libro_update);
		} catch (Exception e) {
			return "..::ERROR en la actualizacion del libro::..";
		}
		return libro_update.toString();
	}

	public String delete(Long id) {
		Libro libro = libroDAO.findById(id);
		if (libroDAO.delete(libro)) {
			return "Exito en el borrado del libro";
		} else {
			return "..::ERROR en el borrado del libro::..";			
		}
	}

}
