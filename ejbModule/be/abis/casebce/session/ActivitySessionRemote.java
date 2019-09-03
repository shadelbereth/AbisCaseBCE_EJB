package be.abis.casebce.session;

import java.util.List;

import javax.ejb.Remote;

import be.abis.casebce.model.Activity;
import be.abis.casebce.model.Worker;

@Remote
public interface ActivitySessionRemote {
	public List<Activity> getActivities(Worker performer);
	public boolean updateActivity(Activity activity);
	public boolean createActivity(Activity activity);
}
