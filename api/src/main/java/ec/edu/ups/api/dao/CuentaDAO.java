package ec.edu.ups.api.dao;

import java.util.List;

import ec.edu.ups.api.model.Cuenta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CuentaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cuenta Cuenta) {
		em.persist(Cuenta);
	}
	
	public void update(Cuenta Cuenta) {
		em.merge(Cuenta);
	}
	
	public void remove(int codigo) {
		Cuenta Cuenta = em.find(Cuenta.class, codigo);
		em.remove(Cuenta);
	}
	
	public Cuenta read(int codigo) {
		Cuenta Cuenta = em.find(Cuenta.class, codigo);
		return Cuenta;
	}
	
	public List<Cuenta> getAll(){
		String jpql = "SELECT c FROM Cuenta c";
		Query q = em.createQuery(jpql, Cuenta.class);
		return q.getResultList();
	}
}
