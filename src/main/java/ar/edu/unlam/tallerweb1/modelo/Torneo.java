package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Torneo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Time horario;
	private Date dia;
	@Enumerated(EnumType.ORDINAL)
	private Juego juego;
	@Enumerated(EnumType.ORDINAL)
	private Modalidad modalidad;
	@Column(length = 300)
	private String premios;
	@Column(length = 300)
	private String descripcion;
	@Enumerated(EnumType.ORDINAL)
	private Estado estado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario organizador;
	
	public void setPremios(String premios) {
		this.premios = premios;
	}
	
	public String getPremios() {
		return this.premios;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}
	
	public Usuario getOrganizador() {
		return this.organizador;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuegoIndividual(Juego juego) {
		this.juego = juego;
		this.modalidad = Modalidad.INDIVIDUAL;
	}
	
	public void setJuegoEnParejas(Juego juego) {
		this.juego = juego;
		this.modalidad = Modalidad.EN_PAREJAS;
	}
	
	public Modalidad getModalidad() {
		return this.modalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	

}
