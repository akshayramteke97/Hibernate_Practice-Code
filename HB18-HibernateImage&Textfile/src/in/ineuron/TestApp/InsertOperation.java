package in.ineuron.TestApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.JobSeeker;

public class InsertOperation {
	private static Session session;
	private static Transaction transaction=null;
	static boolean flag=false;
	
	public static void main(String[] args) {
		byte image[]=null;
		char resume[]=null;
		
		try(FileInputStream fis = new FileInputStream("D:/JAVA LEARNING/HIBERNAE/MyData/myphoto.jpg")){
			image=new byte[fis.available()];
			fis.read(image);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			File fi=new File("D:/JAVA LEARNING/HIBERNAE/MyData/LogIn & password.txt");
			FileReader fr=new FileReader(fi);
			resume=new char[(int)fi.length()];
			fr.read(resume);
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		session = HibernateUtil.getSession();
		try {
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null) {
			JobSeeker job = new JobSeeker();
			job.setpName("akshay");
			job.setpAddress("nagpur");
			job.setpImage(image);
			job.setpResume(resume);
				
			session.save(job);
				flag=true;
			}
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("record inserted successfully");
			}else {
				transaction.rollback();
				System.out.println("record not inserted ");
			}
			HibernateUtil.closeSessionFactory();
			HibernateUtil.closeSession();
			
		}
	}
}
