package be.abis.casebce.model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ExternalWorker extends Worker {
	private double hourRate;

	public double getHourRate() {
		return hourRate;
	}

	public void setHourRate(double hourRate) {
		this.hourRate = hourRate;
	}
}
