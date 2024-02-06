package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class SelectOperation2 {
	private static Session session;

	public static void main(String[] args) {
		session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery("FROM in.ineuron.model.Student WHERE sname IN(:name1,:name2)");
			
			query.setParameter("name1","akshay");
			query.setParameter("name2","sahil");
			List<Student> student = query.list();
			student.forEach(System.out::println);
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
