package be.abis.casebce.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.abis.casebce.model.Project;

@Stateless
public class ProjectSession implements ProjectSessionRemote {
	@PersistenceContext(unitName = "CaseBCE")
	private EntityManager em;

	//Get all the projects
	@Override
	public List<Project> getProjects() {
		List<Project> projects = em.createQuery("Select p From Project p", Project.class).getResultList();
		return projects;
	}

}
