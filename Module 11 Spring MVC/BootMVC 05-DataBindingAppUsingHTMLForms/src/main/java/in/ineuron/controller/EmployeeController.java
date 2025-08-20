package in.ineuron.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ineuron.model.Employee;

@Controller
public class EmployeeController {

	@GetMapping("/register_emp")
	public String showHome() {
		return "home";
	}
	
	@PostMapping("/register_emp")
	public String registerEmployee(Map<String, Object> model, @ModelAttribute("emp") Employee employee) {
		System.out.println("EmployeeController.registerEmployee()");
		System.out.println(employee);
		model.put("employee", employee);
		return "result";
	}
}
