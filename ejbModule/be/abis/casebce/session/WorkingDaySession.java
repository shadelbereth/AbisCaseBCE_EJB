package be.abis.casebce.session;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.abis.casebce.model.ExternalWorker;
import be.abis.casebce.model.WorkingDay;

/**
 * Session Bean implementation class WorkingDaySession
 */
@Stateless
public class WorkingDaySession implements WorkingDaySessionRemote {

	@PersistenceContext(unitName = "CaseBCE")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public WorkingDaySession() {
	}

	@Override

	public WorkingDay getCurrentWorkingDay(int workerId) {

		// get last working day from db
		WorkingDay day = null;
		try {
			day = em
					.createQuery("SELECT w FROM WorkingDay w Where w.worker.id = :workerId order by w.start desc",
							WorkingDay.class)
					.setParameter("workerId", workerId).setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			return this.generateNewWorkingDay(workerId);
		}
		// if it is open return it
		if (day.getEnd() == null) {
			return day;
		}
		// else create new one
		return this.generateNewWorkingDay(workerId);
	}

	@Override
	public WorkingDay startWorkingDay(WorkingDay workingDay) {
		workingDay.setStart(LocalDateTime.now());
		em.persist(workingDay);
		return workingDay;
	}

	@Override
	public WorkingDay closeWorkingDay(WorkingDay workingDay) {
		workingDay.setEnd(LocalDateTime.now());
		// merge into DB
		em.merge(workingDay);
		// create new one to fill front end
		return this.generateNewWorkingDay(workingDay.getWorker().getId());
	}

	private WorkingDay generateNewWorkingDay(int workerId) {
		WorkingDay day = new WorkingDay();
		ExternalWorker worker = em.find(ExternalWorker.class, workerId);
		day.setWorker(worker);
		return day;
	}

}
