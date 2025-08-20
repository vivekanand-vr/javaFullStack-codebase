package in.ineuron.comp;

import java.util.Date;

public class Department {
	
	private int dno;
	private String dname;
	private Date doj;

	public Department(int dno, String dname, Date doj) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + ", doj=" + doj + "]";
	}

}
