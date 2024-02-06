package in.ineuron.TestApp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.BankAccount;

public class GetRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction=null;
		BankAccount bankAccount=null;
		boolean flag=false;
		long id=1L;
		try {
			session = HibernateUtil.getSession();
			bankAccount = session.get(BankAccount.class, id);
			System.out.println("before modification "+bankAccount);

			if (bankAccount != null) {
				transaction=session.beginTransaction();
				bankAccount.setBalance(bankAccount.getBalance()+10000);	
				flag=true;
			}
			else {
				System.out.println("record not available for the id "+id);
				System.exit(0);
			}
			
			
		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("object updated to database");
				System.out.println("opening date : "+bankAccount.getOpeningDate());
				System.out.println("updated date : "+bankAccount.getLastUpdated());
			}else {
				transaction.rollback();
				System.out.println("object does not updated");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}	
}
