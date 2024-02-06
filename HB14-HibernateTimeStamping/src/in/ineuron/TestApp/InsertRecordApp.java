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

public class InsertRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Integer id1=null;
		Transaction transaction = null;
		boolean flag = false;
		int id = 0;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				BankAccount bankAccount = new BankAccount();
				bankAccount.setaName("akshay ramteke");
				bankAccount.setBalance(8000.00);
				bankAccount.setType("saving");

				 id = (Integer) session.save(bankAccount);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to  the database with the id :: "+id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
