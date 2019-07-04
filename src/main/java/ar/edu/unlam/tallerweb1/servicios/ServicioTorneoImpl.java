package ar.edu.unlam.tallerweb1.servicios;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TorneoDao;
import ar.edu.unlam.tallerweb1.modelo.Sala;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Service("servicioTorneo")
@Transactional
public class ServicioTorneoImpl implements ServicioTorneo {

	@Inject
	private TorneoDao servicioTorneoDao;

	@Override
	public Torneo consultarTorneoPorId (Long id) {
		return servicioTorneoDao.consultarTorneoPorId(id);
	}
	
	@Override
	public Sala consultarSala(Torneo torneo) {
		return servicioTorneoDao.consultarSala(torneo);
		
	}
	
	@Override
	public List<Torneo> consultarProximosTorneos() {
		/*
		 * Descontamos 15 minutos a la fecha actual porque las inscripciones siguen abiertas
		 * hasta 15 minutos despu�s del inicio del torneo.
		 * */
		Calendar fechayHora = Calendar.getInstance();
		fechayHora.add(Calendar.MINUTE, -15);		
		return servicioTorneoDao.consultarProximosTorneos(fechayHora);
	}

    @Override
    public void update(Torneo torneo) {
		servicioTorneoDao.update(torneo);
	}

}
