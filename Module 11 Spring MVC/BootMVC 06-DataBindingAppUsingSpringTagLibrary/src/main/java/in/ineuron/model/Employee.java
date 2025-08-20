package in.ineuron.model;

import lombok.Data;

@Data
public class Employee {
	private Integer eno;
	/* 
	 * 	Automatically "sachin" comes in the form ename: input tab, bi-directional data binding happened
	 * 	done by spring framework behind using jstl tags
	 */
	private String ename="sachin";
	private String edesg;
	private Double salary;	
	public Employee(){
		System.out.println("ZERO PARAM CONSTRUCTOR IS USED BY DS");
	}
}
