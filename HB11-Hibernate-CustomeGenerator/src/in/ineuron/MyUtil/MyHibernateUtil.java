package in.ineuron.MyUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class MyHibernateUtil {
	private static SessionFactory sessionFactory=null;
	private static Session session;
	
	private MyHibernateUtil() {	
	}
	
	static {
		 sessionFactory = new Configuration().configure("in/ineuron/Customxlfile/Mysql-Hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
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