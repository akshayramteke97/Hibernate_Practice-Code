package in.ineuron.TestApp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.MobileCustomer;

public class GetRecordApp {

	private static Transaction beginTransaction;

	public static void main(String[] args) throws Exception {

		Session session = null;
		MobileCustomer mobileCustomer=null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				int id=1;
				if(session!=null) {
					mobileCustomer = session.get(MobileCustomer.class,id);
					System.out.println("object is loading "+mobileCustomer);
					
					beginTransaction = session.beginTransaction();
					if(beginTransaction!=null) {
						mobileCustomer.setcCallertune("hello i am busy thoda der lgega");
						session.update(mobileCustomer);
						flag=true;
					}

				}
				
				
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				beginTransaction.commit();
				System.out.println("object updated to database");
				System.out.println("after modification of object : "+mobileCustomer);
			}else {
				beginTransaction.rollback();
				System.out.println("object does not updated to databases");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
