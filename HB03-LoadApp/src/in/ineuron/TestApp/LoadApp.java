package in.ineuron.TestApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class LoadApp {
	private static Session session;
	private static Transaction transaction=null;
	static int id=13;
	public static void main(String[] args) {
		
		session = HibernateUtil.getSession();
		try {
			if(session!=null) {
				Student student = session.load(Student.class, id);
				if(student!=null) {
					System.out.println("studen id is : "+student.getSid());
					System.out.println("studen name is : "+student.getSname());
					System.out.println("studen address is : "+student.getSaddress());
					System.out.println("studen age is : "+student.getSage());

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
