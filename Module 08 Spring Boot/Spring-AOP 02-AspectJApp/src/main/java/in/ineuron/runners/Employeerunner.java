package in.ineuron.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.dao.EmployeeDao;

@Component
public class Employeerunner implements CommandLineRunner {

	@Autowired
	private EmployeeDao dao;
	
	/*
	 * 	 main----> run() -----> continue with buisness logic
	 * 	 this is the starting point.
	 */
	@Override 
	public void run(String... args) throws Exception {
		dao.saveEmployee();
		
	}

}
