package ec.edu.ups.api.business;

import java.util.List;

import ec.edu.ups.api.dao.CuentaDAO;
import ec.edu.ups.api.model.Cuenta;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCuentas {

	@Inject
	private CuentaDAO daoCuenta;

	public void guardarCuentas(Cuenta Cuenta) {
		Cuenta men = daoCuenta.read(Cuenta.getId());
		if (men != null) {
			daoCuenta.update(Cuenta);
		} else {
			System.out.println("Llego a la Gestion el Cuenta: " + Cuenta);
			daoCuenta.insert(Cuenta);
			
		}
	}

	public void actualizarCuenta(Cuenta Cuenta) throws Exception {
		Cuenta men = daoCuenta.read(Cuenta.getId());
		if (men != null) {
			daoCuenta.update(Cuenta);
		} else {
			throw new Exception("Cuenta no existe");
		}
	}
	
	public void borrarCliente(int codigo) {

		daoCuenta.remove(codigo);
	}

	public List<Cuenta> getMensajes() {
		return daoCuenta.getAll();
	}
}
