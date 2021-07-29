package ec.edu.ups.EX_Vintimilla_Domenica_Cliente.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.EX_Vintimilla_Domenica_Cliente.modelo.Carrera;

@Stateless
public class CarreraDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Carrera car) {
		em.persist(car);
	}

	public void update(Carrera car) {
		em.merge(car);
	}

	public Carrera read(int codigo) {
		Carrera c = em.find(Carrera.class, codigo);
		return c;
	}

	public void delete(int codigo) {
		Carrera c = em.find(Carrera.class, codigo);
		em.remove(c);
	}

	public List<Carrera> getCarreras() {

		String jpq2 = "SELECT c FROM Carrera c ";

		Query query = em.createQuery(jpq2, Carrera.class);

		List<Carrera> unis = query.getResultList();
		return unis;

	}

	public List<Carrera> getCarrs(int codigo) {

		String jpq2 = "SELECT c FROM Carrera c WHERE uni = codigo";

		Query query = em.createQuery(jpq2, Carrera.class);
		//query.setParameter(1, codigo);

		List<Carrera> cars = query.getResultList();
		return cars;

	}

}
