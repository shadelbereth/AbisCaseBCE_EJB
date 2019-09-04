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
		Address addressUno = new Address();
		addressUno.setCountry("Uno country");
		addressUno.setNumber(1);
		addressUno.setStreet("Uno street");
		addressUno.setTown("Uno town");
		addressUno.setZipCode("Uno zip");
		companyUno.setAddress(addressUno);
		companyUno.setName("Company Uno");
		projectUno.setClient(companyUno);
		projectUno.setHourRate(100);
		projectUno.setName("Project Uno");
		projectUno.setDescription("THIS IS THE UNO PROJECT");

		// Dos
		Project projectDos = new Project();
		Company companyDos = new Company();
		Address addressDos = new Address();
		addressDos.setCountry("Dos country");
		addressDos.setNumber(2);
		addressDos.setStreet("Dos street");
		addressDos.setTown("Dos town");
		addressDos.setZipCode("Dos zip");
		companyDos.setAddress(addressDos);
		companyDos.setName("Company Dos");
		projectDos.setClient(companyDos);
		projectDos.setHourRate(200);
		projectDos.setName("Project Dos");
		projectDos.setDescription("THIS IS THE DOS PROJECT");

		// Tres
		Project projectTres = new Project();
		Company companyTres = new Company();
		Address addressTres = new Address();
		addressTres.setCountry("Tres country");
		addressTres.setNumber(3);
		addressTres.setStreet("Tres street");
		addressTres.setTown("Tres town");
		addressTres.setZipCode("Tres");
		companyTres.setAddress(addressTres);
		companyTres.setName("Company Tres");
		projectTres.setClient(companyTres);
		projectTres.setHourRate(300);
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
