package in.ineuron.TestApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class UpdateApp {
	private static Session session;
	private static Transaction transaction=null;
	static boolean flag=false;
	public static void main(String[] args) {
		
		session = HibernateUtil.getSession();
		try {
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null) {
				Student student = new Student();
				student.setSid(10);//programmer should know record with id exist
				student.setSname("sahil");
				student.setSaddress("mumbai");
				student.setSage(24);
				session.update(student);
				flag=true;
			}
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag)
				transaction.commit();
			else
				transaction.rollback();
			
			HibernateUtil.closeSessionFactory();
			HibernateUtil.closeSession();
			
		}
	}
}
