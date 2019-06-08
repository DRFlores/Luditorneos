package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Juego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public Long getId() {
		return  this.id;
	}
}
