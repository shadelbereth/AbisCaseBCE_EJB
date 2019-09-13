package be.abis.casebce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project implements Serializable {

	@Id
	@SequenceGenerator(name = "Project_Gen", sequenceName = "Project_Seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Project_Gen")
	@Column(name = "id")
	private int projectId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "CompanyId")
	private Company client;

	// getters and setters
	public Company getClient() {
		return client;
	}

	public void setClient(Company client) {
		this.client = client;
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

	@Override
	public int hashCode() {
		return 100 + (this.getName() + " " + (this.getClient() != null ? this.getClient().getName() : "")).hashCode();
	}

}
