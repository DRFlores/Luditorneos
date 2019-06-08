package ar.edu.unlam.tallerweb1.modelo;


public enum Juego {
	PARCHIS("Parchís"),
	CHINCHON("Chinchón"),
	BURACO("Buraco"),
	DOMINO("Dominó"),
	TRUCO_ARGENTINO("Truco argentino"),
	ESCOBAS("Escobas");
	
	private final String descripcion;
	
	Juego(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
}
