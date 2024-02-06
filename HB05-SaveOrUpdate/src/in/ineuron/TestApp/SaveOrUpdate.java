package in.ineuron.TestApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class SaveOrUpdate {
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
				student.setSid(18);
				student.setSname("virat");
				student.setSaddress("mumbai");
				student.setSage(34);
				
				session.saveOrUpdate(student);
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
