package ec.edu.ups.api.business;

import java.util.List;

import ec.edu.ups.api.dao.UsuarioDAO;
import ec.edu.ups.api.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUsuario {
	@Inject
	private UsuarioDAO daoUsuario;

	public void guardarUsuarios(Usuario Usuario) {
		Usuario men = daoUsuario.read(Usuario.getId());
		if (men != null) {
			daoUsuario.update(Usuario);
		} else {
			System.out.println("Llego a la Gestion el Usuario: " + Usuario);
			daoUsuario.insert(Usuario);
			
		}
	}

	public void actualizarUsuario(Usuario Usuario) throws Exception {
		Usuario men = daoUsuario.read(Usuario.getId());
		if (men != null) {
			daoUsuario.update(Usuario);
		} else {
			throw new Exception("Usuario no existe");
		}
	}
	
	public void borrarCliente(int codigo) {

		daoUsuario.remove(codigo);
	}

	public List<Usuario> getMensajes() {
		return daoUsuario.getAll();
	}
}
