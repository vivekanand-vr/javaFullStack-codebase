package in.ineuron.bo;

public class StudentBO {
	private int sid;
	private String sname;
	private String saddress;
	private float avg;

	@Override
	public String toString() {
		return "StudentBO [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", avg=" + avg + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

}
