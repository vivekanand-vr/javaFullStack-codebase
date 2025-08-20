package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dao.IEmployeeDao;
import in.ineuron.dto.EmployeeDTO;

@Component("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;

	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String[] desgs) throws Exception {
		StringBuilder buffer = new StringBuilder("(");
		
		for (int i = 0; i < desgs.length; ++i) {
			if (i == desgs.length - 1) // for the last element of the array
				buffer.append("'" + desgs[i] + "')");
			else
				buffer.append("'" + desgs[i] + "',"); // for other than last element
		} 

		// convert StringBuffer/StringBuidler object into String
		String cond = buffer.toString();

		// use DAO
		List<EmployeeBO> listBO = dao.getEmpsByDesg(cond);

		// convert ListBO to ListDTO
		List<EmployeeDTO> listDTO = new ArrayList<EmployeeDTO>();
		listBO.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			
			// copy each BO class object to each DTO class object
			BeanUtils.copyProperties(bo, dto); // property names and type must match in both java beans
			dto.setSrNo(listDTO.size() + 1);
			
			// add each object of DTO class to ListDTO
			listDTO.add(dto);
		});

		return listDTO;
	}// for

}
