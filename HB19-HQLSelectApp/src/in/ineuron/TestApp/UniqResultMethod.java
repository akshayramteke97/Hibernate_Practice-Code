package in.ineuron.TestApp;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.Util.HibernateUtil;

public class UniqResultMethod {
	private static Session session;

	public static void main(String[] args) {
		session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery("FROM in.ineuron.model.Student WHERE sid=:id");
			
			System.out.print("Enter the id to be fetched : ");
			int id=new Scanner(System.in).nextInt();
			query.setParameter("id",id);
			
			Object object = query.uniqueResult();
			if(object!=null) {
				System.out.println(object);
			}else {
				System.out.println("record not available for id");
			}
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
