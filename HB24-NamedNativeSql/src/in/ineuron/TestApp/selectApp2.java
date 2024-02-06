package in.ineuron.TestApp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.Student;

public class selectApp2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Session session=null;
		
		try {
			session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(Student.class);
			
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("sname"));
			projectionList.add(Projections.property("saddress"));
			criteria.setProjection(projectionList);
			
			Criterion cond1 = Restrictions.ge("sage", 25);
			Criterion cond2 = Restrictions.le("sage", 28);

			criteria.add(cond1);
			criteria.add(cond2);
			
			Order order = Order.asc("sname");
			criteria.addOrder(order);
			
			
			List<Object[]> std = criteria.list();
			System.out.println("SNAME\tSADDRESS");
			std.forEach(row->{
				for(Object obj:row) {
					System.out.print(obj+"\t");
				}
				System.out.println();
			});
		
		}catch(HibernateException he) {
			he.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
