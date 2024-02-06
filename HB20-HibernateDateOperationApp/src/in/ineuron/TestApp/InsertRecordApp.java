package in.ineuron.TestApp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.PersonInfo;

public class InsertRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Integer id1=null;
		Transaction transaction = null;
		boolean flag = false;
		

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				PersonInfo perInfo = new PersonInfo();
				perInfo.setpName("sachin");
				perInfo.setDob(LocalDate.of(1998, 12, 29));
				perInfo.setDom(LocalDateTime.of(1995, 5, 12, 8, 45));
				perInfo.setDoj(LocalTime.of(12, 5));
				
				 id1 = (Integer) session.save(perInfo);

				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to  the database with the id :: "+ id1 );
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
