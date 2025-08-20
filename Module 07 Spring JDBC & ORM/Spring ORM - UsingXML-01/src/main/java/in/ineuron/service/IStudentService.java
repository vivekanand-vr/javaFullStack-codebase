package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.StudentDTO;

public interface IStudentService {
	public int insert(StudentDTO s);

	public void delete(int id);

	public void delete(StudentDTO s);

	public void update(StudentDTO s);

	public StudentDTO getStudent(int id);

	public List<StudentDTO> getAllStudents();
}
