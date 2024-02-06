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

public class FilterNativeSQL {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session=null;
	
		try {
			session = HibernateUtil.getSession();
			
			Filter filter = session.enableFilter("FILTER_SBIACCOUNT_STATUS");
			filter.setParameter("id2", "blocked");
			filter.setParameter("id3", "disabled");
			NativeQuery<SbiAccount> query = session.createSQLQuery("select * from sbiaccount where balance>:id1");
			query.setParameter("id1", 25000.0f);
			
			query.addEntity(SbiAccount.class);
			List<SbiAccount> list = query.list();
			list.forEach(System.out::println);
			System.out.println();
			
			session.disableFilter("FILTER_SBIACCOUNT_STATUS");
			
			NativeQuery<SbiAccount> query1 = session.createSQLQuery("select * from sbiaccount where balance>:id1");
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
