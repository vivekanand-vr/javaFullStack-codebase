package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.dto.EmployeeDTO;
import in.ineuron.service.IEmployeeService;
import in.ineuron.vo.EmployeeVO;

@Component(value = "controller")
public class MainController {

	static {
		System.out.println("MainController.class file is loading...");
	}

	public MainController() {
		System.out.println("MainController :: Zero param constructor...");
	}

	@Autowired
	private IEmployeeService service;

	public EmployeeVO getHike(EmployeeVO vo) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEaddress(vo.getEadress());
		dto.setEname(vo.getEname());
		dto.setEage(Integer.parseInt(vo.getEage()));
		dto.setEsalary(Float.parseFloat(vo.getEsalary()));

		EmployeeDTO empDTO = service.calculateHike(dto);

		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEid(empDTO.getEid().toString());
		employeeVO.setEadress(empDTO.getEaddress());
		employeeVO.setEage(empDTO.getEage().toString());
		employeeVO.setEname(empDTO.getEname());
		employeeVO.setEsalary(empDTO.getEsalary().toString());
		employeeVO.setHikeAmt(empDTO.getHikeAmount().toString());
		
		return employeeVO;
	}

	@Override
	public String toString() {
		return "MainController [service=" + service + "]";
	}

}
