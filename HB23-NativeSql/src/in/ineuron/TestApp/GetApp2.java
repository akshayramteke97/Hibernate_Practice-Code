package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class GetApp2 {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			NativeQuery<Student> nativeQuery = session.createSQLQuery("SELECT * FROM STUDENT WHERE sage>=:id1 and sage<=:id2");
			
			//setting the parameter
			nativeQuery.setParameter("id1",25);
			nativeQuery.setParameter("id2",30);
			
			//mapping result with entity class
			nativeQuery.addEntity(Student.class);
			
			//executing to get the result
			List<Student> result = nativeQuery.getResultList();
			
			//processing the result
			result.forEach(System.out::println);
			flag=true;
		
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
