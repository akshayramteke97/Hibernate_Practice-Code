package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class selectApp {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
	
		
		try {
			session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(Student.class);
			
			
			List<Student> std = criteria.list();
			std.forEach(System.out::println);
		
		}catch(HibernateException he) {
			he.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
