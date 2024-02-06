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

public class GetRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				int id=1;
				PersonInfo personInfo = session.get(PersonInfo.class, id);
				if(personInfo!=null) {
					System.out.println("record got as "+personInfo);
				}else {
					System.out.println("record not found");
				}
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
