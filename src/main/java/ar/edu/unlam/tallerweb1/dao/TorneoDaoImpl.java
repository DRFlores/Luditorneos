package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Juego;
import ar.edu.unlam.tallerweb1.modelo.Sala;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Repository("torneoDao")
public class TorneoDaoImpl implements TorneoDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Torneo consultarTorneoPorId(Long id) {
		
		final Session session = sessionFactory.getCurrentSession();
		return (Torneo) session.createCriteria(Torneo.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}
	
	@Override
	public Sala consultarSala(Torneo torneo) {
		final Session session = sessionFactory.getCurrentSession();
		return (Sala) session.createCriteria(Sala.class)
				.add(Restrictions.eq("organizador", torneo.getOrganizador()))
				.add(Restrictions.eq("juego", torneo.getJuego()))
				.uniqueResult();
	}

}
