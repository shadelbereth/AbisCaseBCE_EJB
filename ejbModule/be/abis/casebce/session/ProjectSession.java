package be.abis.casebce.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import be.abis.casebce.model.Address;
import be.abis.casebce.model.Company;
import be.abis.casebce.model.Project;

@Stateless
public class ProjectSession implements ProjectSessionRemote {
	private ArrayList<Project> projects = new ArrayList<Project>();

	public ProjectSession() {

		// Uno
		Project projectUno = new Project();
		Company companyUno = new Company();
		companyUno.setName("Company Uno");
		projectUno.setClient(companyUno);
		projectUno.setName("Project Uno");
		projectUno.setDescription("THIS IS THE UNO PROJECT");

		// Dos
		Project projectDos = new Project();
		Company companyDos = new Company();
		companyDos.setName("Company Dos");
		projectDos.setClient(companyDos);
		projectDos.setName("Project Dos");
		projectDos.setDescription("THIS IS THE DOS PROJECT");

		// Tres
		Project projectTres = new Project();
		Company companyTres = new Company();
		companyTres.setName("Company Tres");
		projectTres.setClient(companyTres);
		projectTres.setName("Project Tres");
		projectTres.setDescription("THIS IS THE TRES PROJECT");

		// Uno dos tres
		projects.add(projectUno);
		projects.add(projectDos);
		projects.add(projectTres);
		System.out.println("Session created");
	}

	//Get all the projects
	@Override
	public List<Project> getProjects() {

		return projects;
	}

}
