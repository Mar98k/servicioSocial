package com.ss.siase.modelos;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.ss.siase.modelos.Administrador.VistaPerfil;

/**
 * Estatus generated by hbm2java
 */
@Entity
@Table(name = "estatus", catalog = "sql9353038")
public class Estatus implements java.io.Serializable {

	private Integer idEstatus;
	@JsonView(VistaPerfil.class) private String nombre;
	private String clave;
	private Set<Administrador> administradors = new HashSet<Administrador>(0);
	private Set<Alumno> alumnos = new HashSet<Alumno>(0);
	private Set<Maestro> maestros = new HashSet<Maestro>(0);

	public Estatus() {
	}

	public Estatus(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}

	public Estatus(String nombre, String clave, Set<Administrador> administradors, Set<Alumno> alumnos,
			Set<Maestro> maestros) {
		this.nombre = nombre;
		this.clave = clave;
		this.administradors = administradors;
		this.alumnos = alumnos;
		this.maestros = maestros;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idEstatus", unique = true, nullable = false)
	public Integer getIdEstatus() {
		return this.idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "clave", nullable = false, length = 1)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estatus")
	public Set<Administrador> getAdministradors() {
		return this.administradors;
	}

	public void setAdministradors(Set<Administrador> administradors) {
		this.administradors = administradors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estatus")
	public Set<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estatus")
	public Set<Maestro> getMaestros() {
		return this.maestros;
	}

	public void setMaestros(Set<Maestro> maestros) {
		this.maestros = maestros;
	}

}