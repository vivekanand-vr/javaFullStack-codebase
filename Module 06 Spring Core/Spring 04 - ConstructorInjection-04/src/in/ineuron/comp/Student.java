package in.ineuron.comp;

public class Student {
	private Integer sno;
	private String sname;
	private String saddr;
	private Float avg;

	static {
		System.out.println("Student.class file is loading...\n");
	}

	public Student(Integer sno, String sname, String saddr, Float avg) {
		this.sno = sno;
		this.sname = sname;
		this.saddr = saddr;
		this.avg = avg;
		System.out.println("Student:: 4 param constructor");
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", saddr=" + saddr + ", avg=" + avg + "]";
	}

}
