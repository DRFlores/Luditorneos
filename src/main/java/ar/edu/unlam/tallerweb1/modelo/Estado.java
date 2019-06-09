package ar.edu.unlam.tallerweb1.modelo;

public enum Estado {
	PROGRAMADO("Programado","-success"),
	EN_CURSO("En curso","-warning"),
	CERRADO("Cerrado","-info"),
	CANCELADO("Cancelado", "-danger");
	
    private final String descripcion;
    private final String color;
	
    Estado(String descripcion, String color){
		this.descripcion = descripcion;
		this.color = color;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public String getColor() {
		return this.color;
	}
	
	
	
}
