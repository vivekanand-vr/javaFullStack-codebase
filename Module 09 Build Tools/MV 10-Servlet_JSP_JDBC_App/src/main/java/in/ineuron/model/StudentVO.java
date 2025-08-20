package in.ineuron.model;

import java.io.Serializable;

public class StudentVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sid;
	private String sname;
	private String sage;
	private String saddress;

	@Override
	public String toString() {
		return "StudentVO [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSage() {
		return sage;
	}

	public void setSage(String sage) {
		this.sage = sage;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

}
