package in.ineuron.TestApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.Util.HibernateUtil;

public class DelectOperation {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		int count=0;
		
		
		try {
			session = HibernateUtil.getSession();
			transaction=session.beginTransaction();
			Query query = session.createQuery("DELETE FROM in.ineuron.model.Student WHERE sid=:id");
			query.setParameter("id", 3);

			count = query.executeUpdate();
			flag=true;
		
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("row affected is : "+count);
			}else {
				transaction.rollback();
				System.out.println("row affected are : "+count);
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
