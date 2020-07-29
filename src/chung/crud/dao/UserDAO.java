package chung.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import chung.crud.model.User;

public class UserDAO {
	private SessionFactory sessionFactory = DBConnection.getSessionFactory();
	private static final UserDAO INSTANCE=new UserDAO();

	public static UserDAO getInstance() {
		return INSTANCE;
	}
	public List<User> getAllUsers() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("from User", User.class).list();
		}
	}

	public User getUser(String email) {
		try (Session session = sessionFactory.openSession()) {
			return session.find(User.class, email);
		}
	}

	public void deleteUser(User u) {
		Transaction t=null;
		try (Session session = sessionFactory.openSession()) {
			t=session.beginTransaction();
			session.delete(u);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
	public void addUser(User u) {
		Transaction t=null;
		try(Session session=sessionFactory.openSession()){
			t=session.beginTransaction();
			session.save(u);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
	public void updateUser(User u) {
		Transaction t=null;
		try(Session session=sessionFactory.openSession()){
			t=session.beginTransaction();
			session.update(u);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}
}
