package be.abis.casebce.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.WebApplicationException;

import be.abis.casebce.model.Worker;

/**
 * Session Bean implementation class Worker
 */
@Stateless
public class WorkerSession implements WorkerSessionRemote {

	@PersistenceContext(unitName = "CaseBCE")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public WorkerSession() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public Worker getUser(int id) {

		return em.find(Worker.class, id);
	}

	@Override
	public Worker login(String login, String password) {
		Worker worker = em
				.createQuery("Select p From Worker p Where p.login = :login AND p.password = :password", Worker.class)
				.setParameter("password", password).setParameter("login", login).getSingleResult();
		return worker;
	}

}
