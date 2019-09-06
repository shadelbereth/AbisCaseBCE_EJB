package be.abis.casebce.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EX")
public class ExternalWorker extends Worker {
	private double hourRate;

	public double getHourRate() {
		return hourRate;
	}

	public void setHourRate(double hourRate) {
		this.hourRate = hourRate;
	}
}
