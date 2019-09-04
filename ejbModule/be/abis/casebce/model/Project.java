package be.abis.casebce.model;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
@Named
@SessionScoped
public class Project implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int projectId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@JoinColumn(name = "CompanyId")
	private int companyId;

	@Inject
	private Company client;
	@Inject
	private Manager manager;
	private double hourRate;

	// getters and setters
	public Company getClient() {
		return client;
	}

	public void setClient(Company client) {
		this.client = client;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public double getHourRate() {
		return hourRate;
	}

	public void setHourRate(double hourRate) {
		this.hourRate = hourRate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public int hashCode() {
		return 100 + (this.getName() + " " + (this.getClient() != null ? this.getClient().getName() : "")).hashCode();
	}

}
