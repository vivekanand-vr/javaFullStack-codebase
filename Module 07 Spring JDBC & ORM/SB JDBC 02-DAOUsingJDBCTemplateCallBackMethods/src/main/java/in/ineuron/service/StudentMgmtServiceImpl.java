package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.StudentDTO;

@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService {

	@Autowired
	private IStudentDao dao;

	@Override
	public StudentDTO fetchStudentByNo(int no) {
		StudentBO bo = dao.getStudentByNo(no);

		StudentDTO dto = null;
		dto = new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		dto.setSrNo(1);
		if (bo.getAvg() > 40) {
			dto.setGrade("A");
		}
		return dto;
	}

	@Override
	public List<StudentDTO> fetchStudentByName(String name1, String name2) {

		List<StudentBO> studentBO = dao.getStudentByName(name1, name2);

		List<StudentDTO> studentDTO = new ArrayList<StudentDTO>();

		studentBO.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			if (bo.getAvg() >= 40) {
				dto.setGrade("A");
			} else if (bo.getAvg() >= 35) {
				dto.setGrade("B");
			} else if (bo.getAvg() >= 25) {
				dto.setGrade("C");
			} else {
				dto.setGrade("D");
			}
			dto.setSrNo(studentDTO.size() + 1);
			studentDTO.add(dto);
		});

		return studentDTO;
	}

	@Override
	public List<StudentDTO> fetchStudentByCitites(String city1, String city2, String city3) {

		List<StudentBO> studentBO = dao.fetchStudentByCitites(city1, city2, city3);
		List<StudentDTO> studentDTO = new ArrayList<StudentDTO>();

		studentBO.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			if (bo.getAvg() >= 40) {
				dto.setGrade("A");
			} else if (bo.getAvg() >= 35) {
				dto.setGrade("B");
			} else if (bo.getAvg() >= 25) {
				dto.setGrade("C");
			} else {
				dto.setGrade("D");
			}
			dto.setSrNo(studentDTO.size() + 1);
			studentDTO.add(dto);
		});

		return studentDTO;

	}

}
