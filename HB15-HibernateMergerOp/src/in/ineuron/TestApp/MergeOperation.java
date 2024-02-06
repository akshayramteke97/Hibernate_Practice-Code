package in.ineuron.TestApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class MergeOperation {
	private static Session session;
	private static Transaction transaction=null;
	static boolean flag=false;
	private static Student std;
	public static void main(String[] args) {
		Student stude = new Student();
		stude.setSid(1);
		stude.setSname("kohli");
		stude.setSaddress("banglore");
		stude.setSage(34);
		
		session = HibernateUtil.getSession();
		try {
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null) {

				std = (Student) session.merge(stude);
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
