package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class GetApp {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			NativeQuery<Object[]> nativeQuery = session.createSQLQuery("SELECT * FROM STUDENT WHERE sage>=:id1 and sage<=:id2");
			
			nativeQuery.setParameter("id1",25);
			nativeQuery.setParameter("id2",30);
			
			
			List<Object[]> result = nativeQuery.getResultList();
			System.out.println("SID\tSADDRESS\tSAGE\tSNAME\t");
			result.forEach(row->{
				for(Object std:row) {
					System.out.print(std+"\t");
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
