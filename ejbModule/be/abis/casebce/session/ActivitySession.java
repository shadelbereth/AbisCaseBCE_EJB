package be.abis.casebce.session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.abis.casebce.model.Activity;
import be.abis.casebce.model.Company;
import be.abis.casebce.model.ExternalWorker;
import be.abis.casebce.model.Project;
import be.abis.casebce.model.Worker;
import be.abis.casebce.model.WorkingDay;

/**
 * Session Bean implementation class ActivitySession
 */
@Stateless
public class ActivitySession implements ActivitySessionRemote {

	private List<Activity> activities;
	@PersistenceContext(unitName = "CaseBCE")
	private EntityManager em;

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
		List<Activity> performerActivities = em
				.createQuery("Select a From Activity a Where a.performer = :performer", Activity.class)
				.setParameter("performer", performer).getResultList();
		return performerActivities;
	}

	@Override
	public Activity updateActivity(Activity activity) {
		if (activity.getStart().isAfter(activity.getEnd())) {
			return null;
		}
		em.merge(activity);
		return activity;
	}

	@Override
	public Activity createActivity(Activity activity) {
		try {
			if (activity.getStart().isAfter(activity.getEnd())) {
				return null;
			}
			em.merge(activity.getPerformer());
			em.merge(activity.getProject());
			em.persist(activity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return activity;
	}

	@Override
	public Activity reuploadActivity(Activity activity) {
		activity = em.find(Activity.class, activity.getActivityId());
		return activity;
	}

}
