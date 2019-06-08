package ar.edu.unlam.tallerweb1.modelo;

public enum Estado {
	PROGRAMADO("Programado"),
	EN_CURSO("En curso"),
	CERRADO("Cerrado"),
	CANCELADO("Cancelado");
	
    private final String descripcion;
	
    Estado(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
}
