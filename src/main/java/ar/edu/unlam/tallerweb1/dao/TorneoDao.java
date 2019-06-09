package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Sala;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

public interface TorneoDao {
	
	Torneo consultarTorneoPorId(Long id);
	Sala consultarSala(Torneo torneo);
	List<Torneo> consultarProximosTorneos();
	void actualizarEstadosDeLosTorneos();
	void actualizarEstadoDeTorneoPorId(Long id);

}
