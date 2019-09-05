package be.abis.casebce.model;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Named
@SessionScoped
public class Company implements Serializable {

	// fields
	@Id
	@SequenceGenerator(name = "Company_Gen", sequenceName = "Company_Seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "Company_Gen")
	private int id;
	@Column(columnDefinition = "VARCHAR(50)")
	private String name;

	// getter and setters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
