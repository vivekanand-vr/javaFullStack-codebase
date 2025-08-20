package in.ineuron.comp;

import java.util.Date;

public class PersonInfo {
	private Integer pid;
	private String pname;
	private String paddress;
	private Date dob;
	private Date dom;
	private Date doj;

	public PersonInfo(Integer pid, String pname, String paddress, Date dob, Date dom, Date doj) {
		System.out.println("PersonInfo:: 6 param constructor...");
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
		this.dob = dob;
		this.dom = dom;
		this.doj = doj;
	}


	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", dob=" + dob + ", dom="
				+ dom + ", doj=" + doj + "]";
	}

}
