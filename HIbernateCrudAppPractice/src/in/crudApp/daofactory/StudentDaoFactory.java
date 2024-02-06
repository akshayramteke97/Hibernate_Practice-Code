package in.crudApp.daofactory;

import in.crudApp.dao.IStudentDao;
import in.crudApp.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static IStudentDao stdDao=null;

	private StudentDaoFactory() {}
	
	public static IStudentDao getStudentDao() {
		if(stdDao==null) {
			stdDao = new StudentDaoImpl();
		}
		return stdDao;
	}
}
