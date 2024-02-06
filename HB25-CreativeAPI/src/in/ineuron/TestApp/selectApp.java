package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class selectApp {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			NativeQuery<Object[]> nativeQuery = session.getNamedNativeQuery("GET_ALL_STUDENT");
			
			nativeQuery.setParameter("id1", 25);

			
			List<Object[]> resultList = nativeQuery.getResultList();
			resultList.forEach(row->{
				for(Object obj:row) {
					System.out.print(obj);
				}
				System.out.println();
			});
			flag=true;
		
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
