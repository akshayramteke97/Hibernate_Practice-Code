package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.SbiAccount;

public class FilterCriteriaAPI {
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		Session session=null;
	
		try {
			session = HibernateUtil.getSession();
			
			Filter filter = session.enableFilter("FILTER_SBIACCOUNT_STATUS");
			filter.setParameter("id2", "blocked");
			filter.setParameter("id3", "disabled");
			
			Criteria criteria = session.createCriteria(SbiAccount.class);
			Criterion criterion = Restrictions.ge("balance", 25000.0f);
			List<SbiAccount> list = criteria.list();
			list.forEach(System.out::println);
			
			System.out.println();
			session.disableFilter("FILTER_SBIACCOUNT_STATUS");
			
			Criteria criteria1 = session.createCriteria(SbiAccount.class);
			Criterion criterion1 = Restrictions.ge("balance", 25000.0f);
			List<SbiAccount> list1 = criteria1.list();
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
