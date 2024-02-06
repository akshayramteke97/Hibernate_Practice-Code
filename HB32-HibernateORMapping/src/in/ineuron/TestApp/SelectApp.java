package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.EmployeeCollection;

public class SelectApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				Query<EmployeeCollection> query = session.createQuery("from in.ineuron.model.EmployeeCollection");
				List<EmployeeCollection> resultList = query.getResultList();
				resultList.forEach(System.out::println);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
