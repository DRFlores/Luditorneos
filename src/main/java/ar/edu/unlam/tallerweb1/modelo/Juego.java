package ar.edu.unlam.tallerweb1.modelo;


public enum Juego {
	PARCHIS("Parch�s"),
	CHINCHON("Chinch�n"),
	BURACO("Buraco"),
	DOMINO("Domin�"),
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
