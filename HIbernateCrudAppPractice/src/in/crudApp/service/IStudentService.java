package in.crudApp.service;

import in.crudApp.dto.Student;

public interface IStudentService {
	public String addStudent(String sname,String saddress,Integer sage);
	public Student searchStudent(Integer sid);
	public String deleteStudent(Integer sid);
	public String updateStudent(Student student);
}
