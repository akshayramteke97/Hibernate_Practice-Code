package in.crudApp.dao;

import java.io.PrintWriter;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransientObjectException;

import in.crudApp.dto.Student;
import in.crudApp.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {

	Session session = HibernateUtil.getSession();
	

	public String save(String sname, String saddress, Integer sage) {
		Transaction transaction=session.beginTransaction();
		boolean flag=false;
		String status="";
		try{
			if(transaction!=null) {
				Student student = new Student();
				student.setsName(sname);
				student.setsAddress(saddress);
				student.setsAge(sage);
				
				session.save(student);
				flag=true;	
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				status="success";
			}else {
				transaction.rollback();
				status="failure";
			}
		}
		return status;
	}

	public Student getById(Integer sid) {
		Student student = session.get(Student.class, sid);
		if(student!=null) {
			return student;
		}
		return student;
	}

	public String deleteStudent(Integer sid) {
		Transaction transaction = session.beginTransaction();
		boolean flag=false;
		String status="";
		Student student = session.get(Student.class, sid);
		
		System.out.println(student);
		try {
			if(transaction!=null) {
				session.delete(student);
				flag=true;
			}
		}
		catch(IllegalArgumentException e) {
			e.getMessage();
			System.out.println("Record not Available");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				status= "success";
			}else {
				transaction.rollback();
				status="failure";
			}
		}
		return status;
	}

	public String updateStudent(Student student) {
		Transaction transaction = session.beginTransaction();
		boolean flag=false;
		String status="";
		try {
			if(transaction!=null) {
				session.merge(student);
				flag=true;
				
			}
		}catch(TransientObjectException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				status="success";
			}else {
				transaction.rollback();
				status="failure";
			}
		}
		
		return status;
	}

	
}
