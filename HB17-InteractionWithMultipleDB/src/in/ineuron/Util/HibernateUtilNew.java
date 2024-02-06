package in.ineuron.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class HibernateUtilNew {
	private static SessionFactory sessionFactory=null;
	private static Session session;
	
	private HibernateUtilNew() {	
	}
	
	static {
		 sessionFactory = new Configuration().configure("in/ineuron/cfg/MySql2Hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	}
	public static Session getSession() {
		if(session==null) 
			 session = sessionFactory.openSession();
		 return session;
	}
	public static void closeSessionFactory() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
	public static void closeSession() {
		if(session!=null) {
			session.close();
		}
	}
}