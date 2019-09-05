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

		Worker worker = new Worker();
		worker.setFirstName("Mister");
		worker.setLastName("Awesome");
		worker.setLogin("Awesome");

	}

	@Override
	public void test() {
		try {
			Worker wok = em.find(Worker.class, 1);
			System.out.println("From DB Worker: " + wok.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Worker getUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
