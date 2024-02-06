package in.crudApp.servicefactory;

import in.crudApp.service.IStudentService;
import in.crudApp.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static IStudentService stdService=null;

	private StudentServiceFactory() {}
	
	public static IStudentService getStudentService() {
		if(stdService==null) {
			stdService = new StudentServiceImpl();
		}
		return stdService;
	}
}
