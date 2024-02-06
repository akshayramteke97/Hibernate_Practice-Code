package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.EmployeePolicy;

public class SelectionApp {
	public static void main(String[] args) {
		Session session=null;

		try {
			session = HibernateUtil.getSession();
			Query<EmployeePolicy> query = session.createQuery("FROM in.ineuron.model.EmployeePolicy");
			query.setFirstResult(3);
			query.setMaxResults(4);
			
			List<EmployeePolicy> list = query.list();
			list.forEach(System.out::println);
		
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
