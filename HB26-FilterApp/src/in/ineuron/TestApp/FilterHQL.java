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
import in.ineuron.model.SbiAccount;

public class FilterHQL {
	public static void main(String[] args) {
		Session session=null;
	
		try {
			session = HibernateUtil.getSession();
			
			Filter filter = session.enableFilter("FILTER_SBIACCOUNT_STATUS");
			filter.setParameter("id2", "blocked");
			filter.setParameter("id3", "disabled");
			Query<SbiAccount> query = session.createQuery("FROM in.ineuron.model.SbiAccount WHERE balance>:id1");
			query.setParameter("id1", 25000.0f);
			
			List<SbiAccount> list = query.list();
			list.forEach(System.out::println);
			System.out.println();
			
			session.disableFilter("FILTER_SBIACCOUNT_STATUS");
			
			Query<SbiAccount> query1 = session.createQuery("FROM in.ineuron.model.SbiAccount WHERE balance>:id1");
			query1.setParameter("id1", 25000.0f);
			
			List<SbiAccount> list1 = query.list();
			list1.forEach(System.out::println);
		
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
