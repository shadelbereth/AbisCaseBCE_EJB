package be.abis.casebce.session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import be.abis.casebce.model.Activity;
import be.abis.casebce.model.Company;
import be.abis.casebce.model.Project;
import be.abis.casebce.model.Worker;

/**
 * Session Bean implementation class ActivitySession
 */
@Stateful
public class ActivitySession implements ActivitySessionRemote {

	private List<Activity> activities;

	/**
	 * Default constructor.
	 */
	public ActivitySession() {
		activities = new ArrayList<Activity>();
		Activity activity = new Activity();
		activity.setPerformer(new Worker());
		activity.getPerformer().setLogin("AwesomeWorker");
		activity.setProject(new Project());
		activity.getProject().setName("Awesome Project");
		activity.getProject().setDescription("This project is awesome!");
		activity.getProject().setClient(new Company());
		activity.getProject().getClient().setName("Awesome Company SA");
		activity.setDescription("I did something awesome");
		activity.setStart(LocalDateTime.now().minusDays(1));
		activity.setEnd(LocalDateTime.now().minusDays(1).plusHours(1));
		activities.add(activity);
		activity = new Activity();
		activity.setPerformer(new Worker());
		activity.getPerformer().setLogin("AwesomeWorker");
		activity.setProject(new Project());
		activity.getProject().setName("Another awesome Project");
		activity.getProject().setDescription("This project is also awesome!");
		activity.getProject().setClient(new Company());
		activity.getProject().getClient().setName("Another Awesome Company SA");
		activity.setDescription("I did another thing awesome");
		activity.setStart(LocalDateTime.now().minusHours(1));
		activity.setEnd(LocalDateTime.now());
		activities.add(activity);
	}

	@Override
	public List<Activity> getActivities(Worker performer) {
		List<Activity> performerActivities = new ArrayList<Activity>();
		activities.forEach(a -> {
			if (a.getPerformer().getLogin().equals(performer.getLogin())) {
				performerActivities.add(a);
			}
		});
		return performerActivities;
	}

	@Override
	public Activity updateActivity(Activity activity) {
		for (int i = 0; i < activities.size(); i++) {
			if (activities.get(i).hashCode() == activity.hashCode()) {
				activities.set(i, activity);
				System.out.println("Activity updated");
				return activity;
			}
		}
		System.out.println("Activity update failed");
		return null;
	}

	@Override
	public Activity createActivity(Activity activity) {
		activities.add(activity);
		return activity;
	}

}
