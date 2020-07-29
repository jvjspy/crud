package chung.crud.dao;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import chung.crud.model.User;

public class DBConnection {
	private static final SessionFactory SESSION_FACTORY=buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		Properties props=new Properties();
		props.setProperty("hibernate.connection.url", "jdbc:postgresql://ec2-52-22-216-69.compute-1.amazonaws.com:5432/de3aql1ma9l1iv");
    props.setProperty("hibernate.connection.username", "jxbhanusupzlzb");
    props.setProperty("hibernate.connection.password", "a165841a0631fc92691008308f0f95a8f7c593c56c36a4cbfd27e7d8d9f09834");
    props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    props.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
		return new Configuration().addProperties(props).addAnnotatedClass(User.class).buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
