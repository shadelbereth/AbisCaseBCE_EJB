package be.abis.casebce.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public Worker getUser() {

		return em.find(Worker.class, 1);
	}

}
