package in.ineuron.TestApp;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.Util.HibernateUtil;

public class IdentityAlgJps {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		String id=null;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Student student = new Student();
				student.setSname("shashank");
				student.setSaddress("pune");
				student.setSage(24);
				 id = (String)session.save(student);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to the database with the id : "+id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the data base");
			}

			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}

	}

}
