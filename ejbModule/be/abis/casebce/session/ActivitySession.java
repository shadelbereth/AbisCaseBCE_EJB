package be.abis.casebce.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.abis.casebce.model.Activity;
import be.abis.casebce.model.Worker;

/**
 * Session Bean implementation class ActivitySession
 */
@Stateless
public class ActivitySession implements ActivitySessionRemote {

	@PersistenceContext(unitName = "CaseBCE")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ActivitySession() {

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
