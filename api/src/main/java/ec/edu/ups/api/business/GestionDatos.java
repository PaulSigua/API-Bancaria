package ec.edu.ups.api.business;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.api.model.Cuenta;
import ec.edu.ups.api.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	GestionUsuario gUsuario;
	
	@Inject
	GestionCuentas gCuentas;

	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Usuario u = new Usuario();
		
		u.setNombres("Paul Mateo");
		u.setApellidos("Sigua Calle");
		u.setCedula("0106764830");
		u.setFechaNacimiento("02/08/2002");
		u.setTelefono("0963501941");
		u.setCorreo("mateosigua2002@gmail.com");
		
		Cuenta c = new Cuenta();
		
		c.setNumeroCuenta("454545");
		c.setSaldo(20.00);
		c.setUsuario(u);
		
		gCuentas.guardarCuentas(c);
		
		u.addCuenta(c);
		
		gUsuario.guardarUsuarios(u);

	}
}