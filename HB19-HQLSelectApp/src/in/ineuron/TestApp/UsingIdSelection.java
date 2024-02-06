package in.ineuron.TestApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class UsingIdSelection {
	private static Session session;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery("FROM in.ineuron.model.Student WHERE sid=:id");
			System.out.print("Enter the id to be fetched: ");
			int id=new Scanner(System.in).nextInt();
			query.setParameter("id", id);
			
			List<Student> student = query.list();
			System.out.println(student.size());
			if(!student.isEmpty()) {
				Student students = student.get(0);
				System.out.println(students);
			}else {
				System.out.println("Record not available for required id "+id);
			}
			
		
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
