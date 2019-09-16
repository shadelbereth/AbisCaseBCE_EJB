package be.abis.casebce.session;

import java.util.List;

import javax.ejb.Remote;

import be.abis.casebce.model.Activity;
import be.abis.casebce.model.Worker;

@Remote
public interface ActivitySessionRemote {
	public List<Activity> getActivities(int performerId);

	public Activity updateActivity(Activity activity);

	public void createActivity(Activity activity);

	public Activity reuploadActivity(int activityId);

}
