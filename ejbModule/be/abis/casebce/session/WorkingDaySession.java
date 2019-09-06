package be.abis.casebce.session;

import java.time.LocalDateTime;

import javax.ejb.Stateless;

import be.abis.casebce.model.ExternalWorker;
import be.abis.casebce.model.WorkingDay;

/**
 * Session Bean implementation class WorkingDaySession
 */
@Stateless
public class WorkingDaySession implements WorkingDaySessionRemote {

	/**
	 * Default constructor.
	 */
	public WorkingDaySession() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public WorkingDay getCurrentWorkingDay(ExternalWorker worker) {
		// get last working day from db
		// if it is open return it
		// else create new one
		WorkingDay day = new WorkingDay();
		day.setWorker(worker);
		return day;
	}

	@Override
	public WorkingDay startWorkingDay(WorkingDay workingDay) {
		workingDay.setStart(LocalDateTime.now());
		// persist into DB
		return workingDay;
	}

	@Override
	public WorkingDay closeWorkingDay(WorkingDay workingDay) {
		workingDay.setEnd(LocalDateTime.now());
		// merge into DB
		// create new one to fill front end
		WorkingDay day = new WorkingDay();
		day.setWorker(workingDay.getWorker());
		return day;
	}

}
