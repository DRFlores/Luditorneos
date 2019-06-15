package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en él
@Entity
public class Usuario {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// para el resto de los atributo no se usan anotaciones entonces se usa el default de hibernate: la columna se llama igual que
	// el atributo, la misma admite nulos, y el tipo de dato se deduce del tipo de dato de java.
	private String email;
	private String nick;
	private String password;
	@Enumerated(EnumType.ORDINAL)
	private Rol rol;
	private Long monedas;
	
	public Usuario(){
		this.monedas = 0L;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getNick() {
		return this.nick;
	}
	public void setNombre(String nick) {
		this.nick = nick;
	}
	public Long getMonedas() {
		return monedas;
	}
	
	public void sumarMonedas(Long monedasASumar) {
		this.monedas = this.monedas + monedasASumar;
	}
	
	public boolean restarMonedas(Long monedasARestar) {
		if (this.monedas >= monedasARestar) {
			this.monedas = this.monedas - monedasARestar;
			return true;
		}
		else {
			return false;
		}
	}
	
}
