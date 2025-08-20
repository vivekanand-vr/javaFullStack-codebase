package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDAO;
import in.ineuron.dto.StudentDTO;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDAO dao;

	@Override
	public int insert(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		return dao.insert(bo);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void delete(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		dao.delete(bo);

	}

	@Override
	public void update(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		dao.update(bo);

	}

	@Override
	public StudentDTO getStudent(int id) {
		StudentBO studentBO = dao.getStudent(id);
		StudentDTO dto = null;
		if (studentBO != null) {
			dto = new StudentDTO();
			BeanUtils.copyProperties(studentBO, dto);
		}
		return dto;
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<StudentBO> studentBO = dao.getAllStudents();
		List<StudentDTO> studentDTO = new ArrayList<StudentDTO>();
		studentBO.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			studentDTO.add(dto);
		});
		return studentDTO;
	}

}
