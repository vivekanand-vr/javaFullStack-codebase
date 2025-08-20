package in.ineuron.comp;

import org.springframework.beans.factory.annotation.Required;

public class PersonInfo {
	private Integer pid;
	private String pname;
	private String paddress;

	static {
		System.out.println("Person.class file is loading...");
	}

	public PersonInfo() {
		System.out.println("Person :: Zero param constructor");
	}

	public Integer getPid() {
		return pid;
	}

	@Required
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	@Required
	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + "]";
	}

}
