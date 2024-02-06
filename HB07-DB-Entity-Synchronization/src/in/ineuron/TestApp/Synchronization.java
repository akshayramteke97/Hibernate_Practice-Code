package in.ineuron.TestApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class Synchronization {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		int id=10;
		try {
			Student student = session.get(Student.class, id);
			System.out.println("data before the updation "+student);
			
			if(student!=null) {
				System.in.read();
				session.refresh(student);
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
		
			
			HibernateUtil.closeSessionFactory();
			HibernateUtil.closeSession();
			
		}
	}
}
