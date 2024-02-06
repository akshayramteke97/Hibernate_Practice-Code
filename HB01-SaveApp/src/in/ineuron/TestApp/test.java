package in.ineuron.TestApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class test {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setSid(10);
		student.setSname("golu");
		student.setSaddress("nagpur");
		student.setSage(24);
		
		session.save(student);
		transaction.commit();
		
	}
}
