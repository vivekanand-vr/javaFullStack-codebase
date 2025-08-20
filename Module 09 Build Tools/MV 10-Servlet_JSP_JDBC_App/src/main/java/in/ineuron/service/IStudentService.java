package in.ineuron.service;

import java.util.List;

import in.ineuron.model.StudentDTO;

public interface IStudentService {

	public List<StudentDTO> findAllStudents();

}
