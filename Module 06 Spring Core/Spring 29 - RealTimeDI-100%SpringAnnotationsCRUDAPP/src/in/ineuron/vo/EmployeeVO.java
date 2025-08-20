package in.ineuron.vo;

public class EmployeeVO {
	
	private String eid;
	private String ename;
	private String eage;
	private String eadress;
	private String esalary;
	private String hikeAmt;

	public String getEsalary() {
		return esalary;
	}

	public void setEsalary(String esalary) {
		this.esalary = esalary;
	}

	public String getHikeAmt() {
		return hikeAmt;
	}

	public void setHikeAmt(String hikeAmt) {
		this.hikeAmt = hikeAmt;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEage() {
		return eage;
	}

	public void setEage(String eage) {
		this.eage = eage;
	}

	public String getEadress() {
		return eadress;
	}

	public void setEadress(String eadress) {
		this.eadress = eadress;
	}

	@Override
	public String toString() {
		return "EmployeeVO [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", eadress=" + eadress + ", esalary="
				+ esalary + ", hikeAmt=" + hikeAmt + "]";
	}

}
