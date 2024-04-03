package com.williams.GestionLibreria.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.williams.GestionLibreria.dao.LibreriaDAO;
import com.williams.GestionLibreria.entities.Libreria;
import com.williams.GestionLibreria.entities.Libro;
import com.williams.GestionLibreria.entities.enums.Genero;

public class LibreriaDAOImpl extends GeneralDAOImpl<Libreria> implements LibreriaDAO{

	public LibreriaDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory, Libreria.class);
	}

	public Libreria findById(Long id) {
		
		Session session = sessionFactory.openSession();
		
		Libreria libreria = session.find(Libreria.class, id);
		
		session.close();
		
		return libreria;
	}

	public List<Libro> findByGenre(Genero genero) {
		
		Session session = sessionFactory.openSession();
		
		Query<Libreria> query = session.createQuery("select distinct libreria.libros from Libreria libreria join fetch libreria.libros libros where libros.genero = :genero",Libreria.class);
		query.setParameter("genero", genero);
		Libreria libreria = query.getSingleResult();
		List<Libro> libros = libreria.getLibros();
		
		session.close();
		
		return libros;
	}

}
