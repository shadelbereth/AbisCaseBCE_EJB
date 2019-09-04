package be.abis.casebce.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Activity")
@Named
@SessionScoped
public class Activity implements Serializable {

	// fields
	@Column(name = "id")
	private int activityId;
	@Column(name = "start")
	private LocalDateTime start;
	@Column(name = "end")
	private LocalDateTime end;
	@Column(name = "description")
	private String description;

	@Inject
	private Project project;
	private Worker performer;

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

}
