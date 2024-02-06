package in.ineuron.TestApp;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class UpdateApp2 {
	private static Session session;
	private static Transaction transaction=null;
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		
		session = HibernateUtil.getSession();
		Student student = session.get(Student.class, 10);
		try {
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null) {
				if(student!=null) {
				System.out.println(student);
				System.out.println();
				
				student.setSaddress("RCB");
				session.update(student);
				flag=true;
				}else {
					System.out.println("record not available for updation...");
				}
			}
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				System.in.read();
				transaction.commit();
				System.out.println("object updated to database");
			}			else {
				transaction.rollback();
				System.out.println("object does no updated to database");

			}
			HibernateUtil.closeSessionFactory();
			HibernateUtil.closeSession();
			
		}
	}
}
