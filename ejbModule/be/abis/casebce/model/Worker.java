package be.abis.casebce.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
@Named
@SessionScoped
public class Worker implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int performerId;
	@Column(name = "login")
	private String login;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	/*
	private String bankAcount;
	@Inject
	private Address address;
	private String password;
*/
	public int getPerformerId() {
		return performerId;
	}
	public void setPerformerId(int performerId) {
		this.performerId = performerId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
