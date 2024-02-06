package in.ineuron.TestApp;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.EmployeeCollection;

public class InsertionApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				EmployeeCollection empl = new EmployeeCollection();
				empl.seteId(10);
				empl.seteAddress("nagpur");
				empl.seteName("akshay");
				
				empl.setFriendList(List.of("bhavesh","sahil","shashank"));
				empl.setPhone(Set.of(11223354L,44115324L,45484132L));
				empl.setBankAccount(Map.of("SBI",51442215L,"HDFC",24584113L,"KOTAK",2245685L));
				
				session.save(empl);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to database");
			} else {
				transaction.rollback();
				System.out.println("Object not saved to the database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
