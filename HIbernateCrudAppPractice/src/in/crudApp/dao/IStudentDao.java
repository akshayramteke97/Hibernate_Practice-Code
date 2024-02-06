package in.crudApp.dao;

import in.crudApp.dto.Student;

public interface IStudentDao {
	public String save(String sname,String saddress,Integer sage);
	public Student getById(Integer sid);
	public String deleteStudent(Integer sid);
	public String updateStudent(Student student);
}
