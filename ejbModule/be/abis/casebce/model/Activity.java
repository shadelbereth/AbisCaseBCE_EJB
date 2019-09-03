package be.abis.casebce.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Activity implements Serializable {

	// fields
	private LocalDateTime start;
	private LocalDateTime end;
	@Inject
	private Project project;
	private Worker performer;
	private String description;

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

}
