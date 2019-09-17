package be.abis.casebce.session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.abis.casebce.model.Worker;

/**
 * Session Bean implementation class Worker
 */
@Stateless
public class WorkerSession implements WorkerSessionRemote {

	@PersistenceContext(unitName = "CaseBCE")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public WorkerSession() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public Worker getUser(int id) {

		return em.find(Worker.class, id);
	}

	@Override
	public Worker login(String login, String password) {
		Worker worker = em
				.createQuery("Select p From Worker p Where p.login = :login AND p.password = :password", Worker.class)
				.setParameter("password", hash(password)).setParameter("login", login).getSingleResult();
		return worker;
	}

	private static String hash(String text) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(text.getBytes());
		byte[] digest = md.digest();
		String myHash = "";
		for (byte b : digest) {
			myHash += String.format("%02X", b);
		}

		return myHash.toLowerCase();
	}

}
