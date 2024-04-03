package com.williams.GestionLibreria.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.williams.GestionLibreria.entities.enums.Genero;

/**
 * @author Williams
 * 
 * @version 1.0
 *
 */
@Entity
@Table(name = "hib_libro")
public class Libro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique = true, nullable = false)
	private String isbn;
	
	@Column(length = 30)
	private String titulo;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@ManyToMany
	@JoinTable(name = "hib_libros_libreria",
    	joinColumns = @JoinColumn(name="libro_id"),
    	inverseJoinColumns = @JoinColumn(name="libreria_id") )
	private List<Libreria> librerias = new ArrayList<Libreria>();

	public Libro() {}

	public Libro(String isbn, String titulo, Genero genero) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Libreria> getLibrerias() {
		return librerias;
	}

	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}

	@Override
	public String toString() {
		return "Libro: [id= " + id + ", isbn= " + isbn + ", titulo= " + titulo + ", genero= " + genero + "]\n";
	}
	
}
