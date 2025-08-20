package in.ineuron.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.dto.EmployeeDTO;
import in.ineuron.service.IEmployeeService;
import in.ineuron.vo.EmployeeVO;

@Component("empController")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;

	public List<EmployeeVO> showEmpsByDesgs(String degs[]) throws Exception {
		// use service
		List<EmployeeDTO> listDTO = service.fetchEmpsByDesgs(degs);
		
		// convert listDTO to listVO
		List<EmployeeVO> listVO = new ArrayList<EmployeeVO>();
		listDTO.forEach(dto -> {
			EmployeeVO vo = new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSrNo(String.valueOf(dto.getSrNo()));
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setMgrNo(String.valueOf(dto.getMgrNo()));
			listVO.add(vo);
		});
		return listVO;
	}
}
