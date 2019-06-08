package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Sala;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

public interface TorneoDao {
	
	Torneo consultarTorneoPorId(Long id);
	Sala consultarSala(Torneo torneo);

}
