package ar.edu.unlam.tallerweb1.modelo;

public enum Modalidad {
	INDIVIDUAL("individual"),
	EN_PAREJAS("en parejas");
	
    private final String descripcion;
	
	Modalidad(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

}
