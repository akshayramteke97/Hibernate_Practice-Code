package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class MyChoice {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			NativeQuery<Object[]> nativeQuery = session.createSQLQuery("SELECT sname,saddress FROM STUDENT WHERE sage>=:id1 and sage<=:id2");
			
			//setting the parameter
			nativeQuery.setParameter("id1",25);
			nativeQuery.setParameter("id2",30);
			
			nativeQuery.addScalar("sname",StandardBasicTypes.STRING);
			nativeQuery.addScalar("saddress",StandardBasicTypes.STRING);

			
			//executing to get the result
			List<Object[]> result = nativeQuery.getResultList();
			
			//processing the result
			result.forEach(row->{
				for(Object obj:row) {
					System.out.print(obj+"\t");
				}
				System.out.println();
			});
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
