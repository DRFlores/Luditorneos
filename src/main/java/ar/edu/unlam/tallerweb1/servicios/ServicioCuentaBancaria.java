package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.CuentaBancaria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioCuentaBancaria {
	CuentaBancaria restarMontoALaCuenta(Usuario usuario, Long monto);
	CuentaBancaria agregarMontoALaCuenta(Usuario usuario, Long monto);
	
}
