package be.abis.casebce.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Activity")
@Named
@SessionScoped
public class Activity implements Serializable {

	@Id
	@SequenceGenerator(name = "Activity_Gen", sequenceName = "Activity_Seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Activity_Gen")
	@Column(name = "id")
	private int activityId;
	@Column(name = "start_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime start;
	@Column(name = "end_time" ,columnDefinition = "TIMESTAMP")
	private LocalDateTime end;
	@Column(name = "description")
	private String description;

	@Inject
	@ManyToOne 
	@JoinColumn(name = "projectid")
	private Project project;
	@Inject
	@ManyToOne
	@JoinColumn(name = "performerid")
	private Worker performer;
	
	// constructor 
	
	
	public Activity() {
		super();
	}
	
	public Activity(LocalDateTime start, LocalDateTime end, String description, Project project, Worker performer) {
		super();
		this.start = start;
		this.end = end;
		this.description = description;
		this.project = project;
		this.performer = performer;
	}

	

	// getter and setters

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Worker getPerformer() {
		return performer;
	}

	public void setPerformer(Worker performer) {
		this.performer = performer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
	}

}
