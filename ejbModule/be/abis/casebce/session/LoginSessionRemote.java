package be.abis.casebce.session;

import be.abis.casebce.model.Worker;

public interface LoginSessionRemote {

	public Worker login(String login, String password);
}
