package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Sala;
import ar.edu.unlam.tallerweb1.modelo.Torneo;


public interface ServicioTorneo {
	
	Torneo consultarTorneoPorId(Long id);
	Sala consultarSala(Torneo torneo);

}
