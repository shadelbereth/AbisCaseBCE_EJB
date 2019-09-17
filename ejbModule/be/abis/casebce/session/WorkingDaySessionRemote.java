package be.abis.casebce.session;

import javax.ejb.Remote;

import be.abis.casebce.model.WorkingDay;

@Remote
public interface WorkingDaySessionRemote {
	public WorkingDay getCurrentWorkingDay(int workerId);

	public WorkingDay startWorkingDay(WorkingDay workingDay);

	public WorkingDay closeWorkingDay(WorkingDay workingDay);
}
