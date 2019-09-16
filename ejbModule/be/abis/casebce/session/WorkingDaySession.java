package be.abis.casebce.session;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.abis.casebce.model.ExternalWorker;
import be.abis.casebce.model.Worker;
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
		List<WorkingDay> days = em
				.createQuery("SELECT w FROM WorkingDay w Where w.worker.id = :workerId order by w.end desc",
						WorkingDay.class)
				.setParameter("workerId", workerId).setMaxResults(1).getResultList();

		WorkingDay day = days.get(0);

		// if it is open return it
		if (day.getEnd() == null) {
			return day;

		} else {

			// else create new one
			Worker worker = day.getWorker();
			day = new WorkingDay();
			day.setWorker((ExternalWorker)worker);
			return day;
		}
	}

	@Override
	public WorkingDay startWorkingDay(WorkingDay workingDay) {
		workingDay.setStart(LocalDateTime.now());
		return workingDay;
	}

	@Override
	public WorkingDay closeWorkingDay(WorkingDay workingDay) {
		workingDay.setEnd(LocalDateTime.now());
		// merge into DB
		em.merge(workingDay.getWorker());
		em.persist(workingDay);
		// create new one to fill front end
		WorkingDay day = new WorkingDay();
		day.setWorker(workingDay.getWorker());
		return day;
	}

}
