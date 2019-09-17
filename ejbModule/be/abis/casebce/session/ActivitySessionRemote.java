package be.abis.casebce.session;

import java.util.List;

import javax.ejb.Remote;

import be.abis.casebce.model.Activity;

@Remote
public interface ActivitySessionRemote {
	public List<Activity> getActivities(int performerId);

	public void updateActivity(Activity activity) throws Exception;

	public void createActivity(Activity activity) throws Exception;

	public Activity reuploadActivity(int activityId);

}
