package com.williams.GestionLibreria.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.williams.GestionLibreria.dao.GeneralDAO;

public abstract class GeneralDAOImpl<T> implements GeneralDAO<T>{
	
	protected Session session;
	protected SessionFactory sessionFactory;
	private Class<T> type;
	
	public GeneralDAOImpl (SessionFactory sessionFactory, Class<T> type) {
		this.sessionFactory = sessionFactory;
		this.type = type;
	}
	
	public T create(T entity) {
		this.session = sessionFactory.openSession();
		try {

			this.session.beginTransaction();
			this.session.save(entity);
			this.session.getTransaction().commit();

		} catch (PersistenceException e) {

			e.printStackTrace();
			this.session.getTransaction().rollback();
			
		} finally {
			this.session.close();
		}

		return entity;
	}
	
	public T update (T entity) {
		this.session = sessionFactory.openSession();
		try {

			this.session.beginTransaction();
			this.session.update(entity);
			this.session.getTransaction().commit();

		} catch (PersistenceException e) {

			e.printStackTrace();
			this.session.getTransaction().rollback();

		} finally {
			this.session.close();
		}

		return entity;
	}
	
	public boolean delete (T entity) {
		this.session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			session.delete(entity);

			session.getTransaction().commit();

		} catch (PersistenceException e) {

			e.printStackTrace();
			session.getTransaction().rollback();

			return false;
		} finally {
			session.close();
		}

		return true;
	}
	
	public List<T> findAll() {
		this.session = sessionFactory.openSession();
		
		Query<T> query = session.createQuery("from Libro", type);
		List<T> types = query.list();

		session.close();

		return types;
	}
}
