package in.ineuron.model;

import lombok.Data;

@Data
public class Employee {
	private Integer eno;
	private String ename="sachin";
	private String edesg;
	private Double salary;
	
	public Employee(){
		System.out.println("ZERO PARAM CONSTRUCTOR IS USED BY DispatcherServlet");
	}
}
