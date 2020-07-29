package chung.crud.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnection {
	private static final SessionFactory SESSION_FACTORY=buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
