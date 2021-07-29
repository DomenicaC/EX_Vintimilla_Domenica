package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Universidad;

@Stateless
public class UniversidadDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Universidad uni) {
		em.persist(uni);
	}

	public void update(Universidad uni) {
		em.merge(uni);
	}

	public Universidad read(int codigo) {
		Universidad u = em.find(Universidad.class, codigo);
		return u;
	}

	public void delete(int codigo) {
		Universidad u = em.find(Universidad.class, codigo);
		em.remove(u);
	}

	public List<Universidad> getFacturas() {

		String jpq2 = "SELECT c FROM Universidad c ";

		Query query = em.createQuery(jpq2, Universidad.class);

		List<Universidad> unis = query.getResultList();
		return unis;

	}

}
