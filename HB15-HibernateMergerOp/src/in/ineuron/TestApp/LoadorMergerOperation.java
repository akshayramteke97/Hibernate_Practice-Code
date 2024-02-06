package in.ineuron.TestApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class LoadorMergerOperation {
	private static Session session;
	private static Transaction transaction=null;
	
	public static void main(String[] args) {
		boolean flag=false;
		Student std;
		Student std1;
		Student std2;
		
		session = HibernateUtil.getSession();
		try {
			std=session.get(Student.class, 4);
			System.out.println("after loading the data into L1-cache"+std);
			
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null) {
				std1 = new Student();
				std1.setSid(4);
				std1.setSname("sharma");
				std1.setSaddress("mumbai");
				std1.setSage(34);

				std2 = (Student) session.merge(std1);
				System.out.println("after merging into L1-cache"+std2);
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
