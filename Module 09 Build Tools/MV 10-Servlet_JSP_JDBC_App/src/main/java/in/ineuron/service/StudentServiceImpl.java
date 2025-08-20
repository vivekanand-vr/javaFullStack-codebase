package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import in.ineuron.dao.IStudentDao;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.model.StudentBO;
import in.ineuron.model.StudentDTO;

//service layer logic
public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao;

	@Override
	public List<StudentDTO> findAllStudents() {
		stdDao = StudentDaoFactory.getStudentDao();

		List<StudentBO> students = stdDao.getAllStudents();
		List<StudentDTO> studentDTO = new ArrayList<StudentDTO>();
		for (StudentBO studentBO : students) {
			StudentDTO student = new StudentDTO();
			student.setSid(studentBO.getSid());
			student.setSname(studentBO.getSname());
			student.setSage(studentBO.getSage());
			student.setSaddress(studentBO.getSaddress());
			studentDTO.add(student);
		}
		return studentDTO;
	}
}
