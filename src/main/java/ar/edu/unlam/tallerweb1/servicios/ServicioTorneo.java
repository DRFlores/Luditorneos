package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Sala;
import ar.edu.unlam.tallerweb1.modelo.Torneo;


public interface ServicioTorneo {
	
	Torneo consultarTorneoPorId(Long id);
	Sala consultarSala(Torneo torneo);
	List<Torneo> consultarProximosTorneos();
	void update(Torneo torneo);
}
