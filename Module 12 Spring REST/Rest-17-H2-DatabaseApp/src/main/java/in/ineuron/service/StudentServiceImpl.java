package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.exception.StudentRecordNotFoundException;
import in.ineuron.model.Student;

@Service("service")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;

	@Override
	public String saveStudent(Student student) {
		Student dbStudent = dao.save(student);
		return "Student record saved with the id :: " + dbStudent.getSid();
	}

	@Override
	public List<Student> findAllStudents() {
		return dao.findAll();
	}

	@Override
	public Student findById(Integer id) {
		Student student = dao.findById(id)
				.orElseThrow(() -> new StudentRecordNotFoundException("Student Record not found"));

		return student;
	}

	@Override
	public String updateStudent(Student student) {
		Student dbStudent = dao.save(student);
		return "Student record updated with the id :: " + dbStudent.getSid();
	}

	@Override
	public String deleteById(Integer id) {
		Student student = dao.findById(id)
				.orElseThrow(() -> new StudentRecordNotFoundException("Student Record not found"));
		dao.delete(student);
		return "Deleted succesfully";
	}
}
