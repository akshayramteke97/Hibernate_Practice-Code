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

public class DeletionApp {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
				
			SbiAccount sbiAccount = new SbiAccount();
			sbiAccount.setAcno(1234);
			
			session.delete(sbiAccount);
			flag=true;
		
		}catch(HibernateException he) {
			he.printStackTrace();
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("account has been updated as closed");
			} else {
				transaction.rollback();
				System.out.println("account not updated as closed");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
