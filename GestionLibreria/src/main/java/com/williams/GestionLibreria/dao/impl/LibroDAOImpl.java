package com.williams.GestionLibreria.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.williams.GestionLibreria.dao.LibroDAO;
import com.williams.GestionLibreria.entities.Libro;
import com.williams.GestionLibreria.entities.enums.Genero;

public class LibroDAOImpl extends GeneralDAOImpl<Libro> implements LibroDAO {

	public LibroDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory, Libro.class);
	}

	public Libro findById(Long id) {

		Session session = sessionFactory.openSession();

		Libro libro = session.find(Libro.class, id);
		
		session.close();

		return libro;
	}

	public List<Libro> findByGenre(Genero genero) {

		Session session = sessionFactory.openSession();

		Query<Libro> query = session.createQuery("from Libro where gen =: gen", Libro.class);
		query.setParameter("gen", genero);
		List<Libro> libros = query.list();
		
		session.close();

		return libros;
	}

}
