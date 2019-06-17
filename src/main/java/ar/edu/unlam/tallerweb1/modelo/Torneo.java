package ar.edu.unlam.tallerweb1.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

	private Calendar diaYHorario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Juego juego;
	
	@Enumerated(EnumType.ORDINAL)
	private Modalidad modalidad;
	
	private Long primerPremio;
	private Long segundoPremio;
	private Long tercerPremio;
	
	@Column(length = 300)
	private String descripcion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario organizador;
	
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
	
	public String getHorarioHHss() {
		return new SimpleDateFormat("HH:mm").format(this.diaYHorario.getTime());		
	}
	
	public String getFechaDDMMAAAA() {
		return new SimpleDateFormat("dd/MM/yyyy").format(this.diaYHorario.getTime());
	}
	
	public void setDiaYHorario(Calendar diaYHorario) {
		this.diaYHorario = diaYHorario;
	}
	
	public Calendar getDiaYHorario() {
		return this.diaYHorario;
	}

	public Long getPrimerPremio() {
		return primerPremio;
	}

	public boolean setPrimerPremio(Long primerPremio) {
		if(this.modalidad == Modalidad.EN_PAREJAS && primerPremio%2!=0)
		{
			return false;
		}
		else {
			this.primerPremio = primerPremio;
			return true;			
		}		
	}

	public Long getSegundoPremio() {
		return segundoPremio;
	}

	public boolean setSegundoPremio(Long segundoPremio) {
		if(this.modalidad == Modalidad.EN_PAREJAS && segundoPremio%2!=0)
		{
			return false;
		}
		else {
			this.segundoPremio = segundoPremio;
			return true;			
		}
	}

	public Long getTercerPremio() {
		return tercerPremio;
	}

	public boolean setTercerPremio(Long tercerPremio) {
		if(this.modalidad == Modalidad.EN_PAREJAS && tercerPremio%2!=0)
		{
			return false;
		}
		else {
			this.tercerPremio = tercerPremio;
			return true;			
		}
	}
	
	public Long getPremiosTotalesARepartir() {
		return this.getPrimerPremio()+this.getSegundoPremio()+this.getTercerPremio();		
	}
	

}
