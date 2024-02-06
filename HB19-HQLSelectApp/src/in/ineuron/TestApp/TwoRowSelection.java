package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class TwoRowSelection {
	private static Session session;

	public static void main(String[] args) {
		session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery("SELECT sage,saddress FROM in.ineuron.model.Student WHERE sname IN(:name1,:name2)");
			query.setParameter("name1", "akshay");
			query.setParameter("name2", "sahil");
			List<Object[]> student = query.list();
			
			System.out.println("sage\tsaddress");
			student.forEach(row->{
				for(Object object : row) {
					System.out.print(object+"\t");
				}
				System.out.println();
			});
			
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
