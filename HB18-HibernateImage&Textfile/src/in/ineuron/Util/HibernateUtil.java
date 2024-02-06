package in.ineuron.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.JobSeeker;

public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	private static Session session;
	
	private HibernateUtil() {	
	}
	
	static {
		 sessionFactory = new Configuration().configure().addAnnotatedClass(JobSeeker.class).buildSessionFactory();
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