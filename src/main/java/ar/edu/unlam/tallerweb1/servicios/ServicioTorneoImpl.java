package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TorneoDao;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioTorneo")
@Transactional
public class ServicioTorneoImpl implements ServicioTorneo {

	@Inject
	private TorneoDao servicioTorneoDao;

	@Override
	public Torneo consultarTorneoPorId (Long id) {
		return servicioTorneoDao.consultarTorneoPorId(id);
	}

}
