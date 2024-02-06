package in.ineuron.TestApp;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Util.HibernateUtil;
import in.ineuron.model.JobSeeker;

public class GetOperation {
	private static Session session;
	private static Transaction transaction=null;
	static boolean flag=false;
	static JobSeeker job;
	public static void main(String[] args) {
		
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				job = session.get(JobSeeker.class, 2);
			}
			if(job!=null) {
				System.out.println("person id is :"+job.getpNo());
				System.out.println("person name is : "+job.getpName());
				System.out.println("person address is : "+job.getpAddress());
				try (FileOutputStream fos = new FileOutputStream("./store/nitin.jpg");
						FileWriter writer = new FileWriter("./store/resume.txt")) {
					fos.write(job.getpImage());
					writer.write(job.getpResume());
					System.out.println("Photo and resume got downloaded to :: ./store/****");
				}
				
			}
			else {
				System.out.println("record not available");
			}
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
			HibernateUtil.closeSession();
			
		}
	}
}
