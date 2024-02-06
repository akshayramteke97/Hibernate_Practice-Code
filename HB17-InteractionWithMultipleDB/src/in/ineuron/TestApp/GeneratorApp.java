package in.ineuron.TestApp;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.TrasaferApp.ITransferApp;
import in.ineuron.TrasaferApp.TransferAppImpl;
import in.ineuron.Util.HibernateUtil;
import in.ineuron.Util.HibernateUtilNew;

public class GeneratorApp {

	public static void main(String[] args) throws Exception {
		ITransferApp transferAppImpl = new TransferAppImpl();
		String status = transferAppImpl.tranferData();
		System.out.println(status);
		
		HibernateUtil.closeSession();
		HibernateUtilNew.closeSession();
	}
}
