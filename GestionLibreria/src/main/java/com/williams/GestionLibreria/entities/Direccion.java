package com.williams.GestionLibreria.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "hib_direccion")
public class Direccion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String calle;
	
	@Column(nullable = false)
	private String ciudad;
	
	@Column(nullable = false)
	private String pais;

	public Direccion() {
	}

	public Direccion(String calle, String ciudad, String pais) {
		this.calle = calle;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Direccion: [id= " + id + ", calle= " + calle + ", ciudad= " + ciudad + ", pais= " + pais + "]\n";
	}
	
}
