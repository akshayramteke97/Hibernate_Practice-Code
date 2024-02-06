package in.ineuron.TestApp;

import java.util.Optional;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class UniqResultOptional {
	private static Session session;

	public static void main(String[] args) {
		session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery("FROM in.ineuron.model.Student WHERE sid=:id");
			
			System.out.print("Enter the id to be fetched : ");
			int id=new Scanner(System.in).nextInt();
			query.setParameter("id",id);
			
			Optional<Student> optional = query.uniqueResultOptional();
			
			if(optional.isPresent()) {
				Student student = optional.get();
				System.out.println(student);
			}else {
				System.out.println("Record not available");
			}
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
