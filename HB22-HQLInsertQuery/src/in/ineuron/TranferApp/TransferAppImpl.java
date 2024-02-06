package in.ineuron.TranferApp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.Util.HibernateUtil;

public class TransferAppImpl implements ITransferapp {

	

	@SuppressWarnings("finally")
	@Override
	public String getTranferApp(int age) {
		Session session=null;
		Transaction transaction=null;
		@SuppressWarnings("rawtypes")
		Query query;
		int count=0;
		boolean flag=false;
		
		try {
			session = HibernateUtil.getSession();
			transaction=session.beginTransaction();
			
			query = session.getNamedQuery("HQL_TRANSFER_POLICIES");
			query.setParameter("age", age);
			count = query.executeUpdate();
			flag=true;
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				return "record has been inserted successfully with row : "+count;
			}
			else {
				transaction.rollback();
				return "record not inserted with row : "+count;
			}
		}
		
	}
	
}
