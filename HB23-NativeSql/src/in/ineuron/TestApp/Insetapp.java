package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class Insetapp {
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		int rowAffected=0;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			NativeQuery nativeQuery = session.createSQLQuery("INSERT INTO student(saddress,sage,sname)values(?,?,?)");
			
			//setting the parameter
			nativeQuery.setParameter(1,"nagpur");
			nativeQuery.setParameter(2,25);
			nativeQuery.setParameter(3,"akshay");
			
			nativeQuery.addEntity(Student.class);

			rowAffected = nativeQuery.executeUpdate();
			flag=true;
		
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("record inserted successfully with row "+rowAffected);
			} else {
				transaction.rollback();
				System.out.println("record insertion failed with row"+rowAffected);
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
