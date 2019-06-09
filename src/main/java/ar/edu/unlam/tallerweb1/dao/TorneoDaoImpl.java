package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Sala;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

import java.util.Date;
import java.util.List;

@Repository("torneoDao")
public class TorneoDaoImpl implements TorneoDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Torneo consultarTorneoPorId(Long id) {
		this.actualizarEstadoDeTorneoPorId(id);
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
	
	@Override
	public void actualizarEstadoDeTorneoPorId(Long id) {
		Timestamp ts = new Timestamp(new Date().getTime());
		final Session session = sessionFactory.getCurrentSession();
		Criterion enCurso = Restrictions.eq("estado", Estado.EN_CURSO);
		Criterion programado = Restrictions.eq("estado", Estado.PROGRAMADO);
		
		Torneo torneoSinActualizar = (Torneo) session.createCriteria(Torneo.class)
				.add(Restrictions.eq("id",id))				
				.add(Restrictions.or(enCurso,programado))
				.add(Restrictions.le("diaYHorario",ts))	
				.uniqueResult();
		Long limite;
		//Los torneos tienen 15 minutos extras desde su inicio antes del cierre de las inscripciones
		Long tiempoExtra = 900000L; //15minutos en milisegundos
		
		if(torneoSinActualizar != null) {
			
		    limite = torneoSinActualizar.getDiaYHorario().getTime()+tiempoExtra;
		    if( limite >= ts.getTime() )
		    {
		    	torneoSinActualizar.setEstado(Estado.EN_CURSO);
		    }
		    else {
		    	torneoSinActualizar.setEstado(Estado.CERRADO);			    	
		    }			    
		    session.update(torneoSinActualizar);			
		}		
		return;
	}
	
	@Override
	public void actualizarEstadosDeLosTorneos() {
		
		Timestamp ts = new Timestamp(new Date().getTime());
		final Session session = sessionFactory.getCurrentSession();
		Criterion enCurso = Restrictions.eq("estado", Estado.EN_CURSO);
		Criterion programado = Restrictions.eq("estado", Estado.PROGRAMADO);
		
		List<Torneo> torneosSinActualizar = session.createCriteria(Torneo.class)
				.add(Restrictions.le("diaYHorario",ts))				
				.add(Restrictions.or(enCurso,programado))
				.list();
		Long limite;
		//Los torneos tienen 15 minutos extras desde su inicio antes del cierre de las inscripciones
		Long tiempoExtra = 900000L; //15minutos en milisegundos
		
		if(!torneosSinActualizar.isEmpty()) {
			for (Torneo var : torneosSinActualizar) 
			{ 
			    limite = var.getDiaYHorario().getTime()+tiempoExtra;
			    if( limite >= ts.getTime() )
			    {
			    	var.setEstado(Estado.EN_CURSO);
			    }
			    else {
			    	var.setEstado(Estado.CERRADO);			    	
			    }			    
			    session.update(var);
			}
		}		
		return;
	}
	
	@Override
	public List<Torneo> consultarProximosTorneos() {
		this.actualizarEstadosDeLosTorneos();
		final Session session = sessionFactory.getCurrentSession();
		Criterion enCurso = Restrictions.eq("estado", Estado.EN_CURSO);
		Criterion programado = Restrictions.eq("estado", Estado.PROGRAMADO);
		return (List<Torneo>) session.createCriteria(Torneo.class)
				.add(Restrictions.or(enCurso,programado))
				 .addOrder( Order.asc("diaYHorario") )
				.list();
	}

}
