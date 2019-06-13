package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.dao.CuentaBancariaDao;
import ar.edu.unlam.tallerweb1.modelo.CuentaBancaria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class ServicioCuentaBancariaImpl implements ServicioCuentaBancaria{
	
	@Inject
	CuentaBancariaDao cuentaBancariaDao;
	
	@Override
	public CuentaBancaria restarMontoALaCuenta(Usuario usuario, Long monto) {
		CuentaBancaria cuenta = usuario.getCuentaBancaria();
		cuenta.setSaldo(cuenta.getSaldo() - monto);
		cuentaBancariaDao.guardarCuenta(cuenta);
		return cuenta;
	}

	@Override
	public CuentaBancaria agregarMontoALaCuenta(Usuario usuario, Long monto) {
		CuentaBancaria cuenta = usuario.getCuentaBancaria();
		cuenta.setSaldo(cuenta.getSaldo() + monto);
		cuentaBancariaDao.guardarCuenta(cuenta);
		return cuenta;
	}

}
