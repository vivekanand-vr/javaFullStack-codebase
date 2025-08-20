package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.StudentDTO;

public interface IStudentMgmtService {
	public StudentDTO fetchStudentByNo(int no);

	public List<StudentDTO> fetchStudentByName(String name1, String name2);

	public List<StudentDTO> fetchStudentByCitites(String city1, String city2, String city3);
}
