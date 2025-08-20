package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	/*
	 * 	GET: http://localhost:9999/employee/read?id=7&name=dhoni
	 */
	@GetMapping("/read")
	public ResponseEntity<String> getEmployee(
			@RequestParam(defaultValue = "10", required = false) Integer id,
			@RequestParam(defaultValue = "sachin", required = false) String name) 
	{
		System.out.println("Id is :: " + id);
		System.out.println("Name is :: " + name);
		String body = null;

		if (id == 7 && name.equalsIgnoreCase("dhoni")) {
			body = "CSK TEAM";
		} else if (id == 18 && name.equals("kohli")) {
			body = "RCB TEAM";
		} else if (id == 10 && name.equalsIgnoreCase("sachin")) {
			body = id + name + "MI TEAM";
		} else {
			body = "Other TEAM";
		}

		return new ResponseEntity<String>(body, HttpStatus.OK);
	}

	
}
