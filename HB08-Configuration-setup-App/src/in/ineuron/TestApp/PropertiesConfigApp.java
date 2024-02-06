package in.ineuron.TestApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import in.ineuron.model.Student;

public class PropertiesConfigApp {
	public static void main(String[] args) throws IOException {
		
		Configuration configuration = new Configuration();//configuration object automatically check for properties file
	
//		FileInputStream file = new FileInputStream("D:\\JAVA LEARNING\\HIBERNAE\\HB08-Configuration-setup-App\\src\\proper.properties");
//		Properties proper = new Properties();
//		proper.load(file);
//		configuration.setProperties(proper);
		configuration.addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		int id=10;
		try {
			Student student = session.get(Student.class, id);
			System.out.println("data before the updation "+student);
			
			if(student!=null) {
				System.in.read();
				System.out.println("data after the updation "+student);
			}
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		sessionFactory.close();
		session.close();
			
		}
	}
}
