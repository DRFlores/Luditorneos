package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String linkDeLaSala;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Juego juego;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario organizador;
	
	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}

	public String getLinkDeLaSala() {
		return this.linkDeLaSala;
	}

	public void setLinkDeLaSala(String linkDeLaSala) {
		this.linkDeLaSala = linkDeLaSala;
	}

	public Juego getJuego() {
		return this.juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

}