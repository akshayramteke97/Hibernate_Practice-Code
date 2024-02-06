package in.crudApp.service;

import in.crudApp.dao.IStudentDao;
import in.crudApp.daofactory.StudentDaoFactory;
import in.crudApp.dto.Student;

public class StudentServiceImpl implements IStudentService{

	private IStudentDao studentDao=null;

	public String addStudent(String sname, String saddress, Integer sage) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.save(sname, saddress, sage);
	}

	@Override
	public Student searchStudent(Integer sid) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.getById(sid);
	}

	@Override
	public String deleteStudent(Integer sid) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {
		studentDao=StudentDaoFactory.getStudentDao();
		return studentDao.updateStudent(student);
	}

}
