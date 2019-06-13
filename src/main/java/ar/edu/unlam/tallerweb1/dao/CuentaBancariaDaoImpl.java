package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.CuentaBancaria;

public class CuentaBancariaDaoImpl implements CuentaBancariaDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public CuentaBancaria guardarCuenta (CuentaBancaria cuenta) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cuenta);
		return cuenta;
	}
	

}
