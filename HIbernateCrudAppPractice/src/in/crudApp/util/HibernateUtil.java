package in.crudApp.util;

import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import in.crudApp.dto.Student;

public class HibernateUtil {
	
	private HibernateUtil() {}
	
	public static Session session=null;
	public static SessionFactory sessionfactory=null;
	
	static {
			 sessionfactory = new Configuration().configure().addAnnotatedClass(Student.class)
					 .buildSessionFactory();
	}
	public static Session getSession() {
		if(session!=null) {
			session=sessionfactory.openSession();
		}
		return session;
	}
	public static void closeSession(Session session) {
		if(session!=null) {
			session.close();
		}
	}
	public static void closeSessionFactory() {
		if(sessionfactory!=null) {
			sessionfactory.close();
		}
	}
	public static void startUp() {
		System.out.println("*****Hibernate has been started*******");
	}
}
