package be.abis.casebce.session;

import java.util.List;

import javax.ejb.Remote;

import be.abis.casebce.model.Project;

@Remote
public interface ProjectSessionRemote {
	public List<Project> getProjects();

}
