package in.crudApp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.crudApp.dao.IStudentDao;
import in.crudApp.daofactory.StudentDaoFactory;
import in.crudApp.dto.Student;
import in.crudApp.service.IStudentService;
import in.crudApp.servicefactory.StudentServiceFactory;
import in.crudApp.util.HibernateUtil;

public class MainCrudApp {
	static {
		HibernateUtil.startUp();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("1: CREATE");
			System.out.println("2: UPDATE");
			System.out.println("3: DELETE");
			System.out.println("4: SEARCH");
			System.out.println("5: EXIT");
			System.out.print("Enter your choice [1/2/3/4/5] :: ");
			String option=br.readLine();
			
			switch(option) {
			case "1":
				insertOperation();
				break;
			case "2":
				updateOperation();
				break;
			case "3":
				deleteOperation();
				break;
			case "4":
				searchOperation();
				break;
			case "5":
				System.out.println("*****Thanks for using the application*****");
				System.exit(0);
			default:
				System.out.println("Invalid option please enter valid option");
				break;
			}
		}
	}
	private static void insertOperation() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Name : ");
		String name=scan.nextLine();
		System.out.print("Ener the address : ");
		String address=scan.nextLine();
		System.out.print("Enter the age : ");
		int age=scan.nextInt();
		
		IStudentService stdService = StudentServiceFactory.getStudentService();
		String status = stdService.addStudent(name, address, age);
		if(status.equalsIgnoreCase("success")) {
			System.out.println("record has been inserted successfully");
		}else {
			System.out.println("record does not insreted");
		}
		
	}
	private static void updateOperation() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the student id to be updated : ");
		String id=br.readLine();
		
		IStudentService stdService = StudentServiceFactory.getStudentService();
		Student student = stdService.searchStudent(Integer.parseInt(id));
		if(student!=null) {
			Student newstd=new Student();
			System.out.println("student id is : "+id);
			newstd.setSid(student.getSid());
			
			System.out.print("student old name is "+student.getsName()+" Enter new Name : ");
			String name=br.readLine();
			if(name.equals("") || name=="") {
				newstd.setsName(student.getsName());
			}else {
				newstd.setsName(name);
			}
			System.out.println("student old address is "+student.getsAddress()+" Enter new address :");
			String address=br.readLine();
			if(address.equals("") || address=="") {
				newstd.setsAddress(student.getsAddress());
			}else {
				newstd.setsAddress(address);
			}
			System.out.println("Student old age is "+student.getsAge()+" Enter new Age :");
			String age=br.readLine();
			if(age.equals("") || age=="") {
				newstd.setsAge(student.getsAge());
			}else{
				newstd.setsAge(Integer.parseInt(age));
			}
			
			System.out.println("new Record data is "+newstd);
			System.out.println();
			
			String status = stdService.updateStudent(newstd);
			if(status.equalsIgnoreCase("success")) {
				System.out.println("record updated successfully");
			}else {
				System.out.println("record not updated");
			}
		}
		else {
			System.out.println("record not available of required id "+id+" Try another");
		}
	}
	private static void deleteOperation() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id");
		int id=scan.nextInt();
		IStudentService stdService = StudentServiceFactory.getStudentService();
		String delstd = stdService.deleteStudent(id);
		if(delstd.equalsIgnoreCase("success")) {
			System.out.println("Record deleted successfully");
		}else if(delstd.equalsIgnoreCase("null")){
			System.out.println("Record not available");
		}
		else {
			System.out.println("Record does not deleted");
		}
		
		
	}
	private static void searchOperation() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the id : ");
		int id=scan.nextInt();
		IStudentService stdService=StudentServiceFactory.getStudentService();
		Student student = stdService.searchStudent(id);
		System.out.println(student);
		
	}
}
