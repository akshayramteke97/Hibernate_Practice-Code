package in.ineuron.TrasaferApp;


import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.Util.HibernateUtil;
import in.ineuron.Util.HibernateUtilNew;
import in.ineuron.model.Student;

public class TransferAppImpl implements ITransferApp {

	private Session oldSession;
	private Session newSession;
	Transaction transaction;
	private Student student;
	Integer id=null;
	boolean flag=false;

	@Override
	public String tranferData() {
		oldSession = HibernateUtil.getSession();
		newSession = HibernateUtilNew.getSession();
		student = oldSession.get(Student.class,1);
		
		if(student==null) {
			return "record not available";
		}else {
			try {
				transaction=newSession.beginTransaction();
				 id = (Integer) newSession.save(student);
				 flag=true;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(flag) {
					transaction.commit();
					return "Record has been transfer to new database with id "+id;
				}else {
					transaction.rollback();
					return "Record not trasnfer to new database with id "+id;
				}
			}
		}
	}

}
