package ec.edu.ups.api.dao;

import java.util.List;

import ec.edu.ups.api.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UsuarioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Usuario Usuario) {
		em.persist(Usuario);
	}
	
	public void update(Usuario Usuario) {
		em.merge(Usuario);
	}
	
	public void remove(int codigo) {
		Usuario Usuario = em.find(Usuario.class, codigo);
		em.remove(Usuario);
	}
	
	public Usuario read(int codigo) {
		Usuario Usuario = em.find(Usuario.class, codigo);
		return Usuario;
	}
	
	public List<Usuario> getAll(){
		String jpql = "SELECT u FROM Usuario u";
		Query q = em.createQuery(jpql, Usuario.class);
		return q.getResultList();
	}
}
