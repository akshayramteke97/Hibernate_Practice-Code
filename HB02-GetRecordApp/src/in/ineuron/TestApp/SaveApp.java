package in.ineuron.TestApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class SaveApp {
	private static Session session;
	private static Transaction transaction=null;
	static int id=10;
	public static void main(String[] args) {
		
		session = HibernateUtil.getSession();
		try {
			if(session!=null) {
				Student student = session.get(Student.class, id);
				if(student!=null) {
					System.out.println(student);
				}else
					System.out.println("record not found for given id : "+id);
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
