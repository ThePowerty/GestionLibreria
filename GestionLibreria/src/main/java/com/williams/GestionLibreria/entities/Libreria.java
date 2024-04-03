package com.williams.GestionLibreria.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "hib_libreria")
public class Libreria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique = true, nullable = false)
	private String nombre;
	
	@OneToOne
	@JoinColumn(name = "direccion_pk", 
		foreignKey = @ForeignKey(name = "fk_libreria_direccion"))
	private Direccion direccion;
	
	@ManyToMany(mappedBy = "librerias")
	private List<Libro> libros = new ArrayList<Libro>();

	public Libreria() {
	}

	public Libreria(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Libreria: [id= " + id + ", nombre= " + nombre + "]\n";
	}
		
}
