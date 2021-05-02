package com.udemy.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "no puede ser vacio")
	@Size(min=4, max=12, message = "debe tener entre 4 y 12 caracteres")
	@Column(nullable=false)
	private String nombre;
	
	@NotEmpty(message = "no puede ser vacio")
	@Column(nullable=false)
	private String apellido;
	
	@NotEmpty(message = "no puede ser vacio")
	@Email(message = "debe tener un formato de mail valido")
	@Column(nullable=false, unique=true)
	private String email;
	
	@NotNull(message = "no puede ser vacio")
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	private String foto;

	@NotNull(message = "La region no puede ser vacia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Region region;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	/*
	 * @PrePersist public void prePersist() { createAt = new Date(); }
	 */
	
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	private static final long serialVersionUID = 1L;
	
}
