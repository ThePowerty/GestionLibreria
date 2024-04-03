package com.williams.GestionLibreria.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.williams.GestionLibreria.dao.DireccionDAO;
import com.williams.GestionLibreria.entities.Direccion;
import com.williams.GestionLibreria.util.HibernateUtil;

public class DireccionDAOImpl extends GeneralDAOImpl<Direccion> implements DireccionDAO {

	public DireccionDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory, Direccion.class);
	}

	public Direccion findById(Long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Direccion direccion = session.find(Direccion.class, id);
		
		return direccion;
	}
	
}
