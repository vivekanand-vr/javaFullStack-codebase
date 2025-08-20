package in.ineuron.dao;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

	public void saveEmployee() {
		System.out.println("Employee Object is saved...");
	}
	
	public void getEmployee() {
		System.out.println("Employee Retreived from Database");
	}
	
	public String deleteEmployee() {
		System.out.println("Record deleted...");
		return "Employee got deleted...";
	}
	
}
