package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Student {

	/*
	 * @GenericGenerator(name = "gen1",strategy = "increment") 
	 * @GeneratedValue(generator = "gen1")
	 */
	/*
	 * @Id
	 * 
	 * @GenericGenerator(name = "gen1", strategy = "sequence", parameters = {
	 					@Parameter(value = "sid_seq", name = "sequence_name") })
	   @GeneratedValue(generator = "gen1")
	 */
	@Id
	@GenericGenerator(name="gen1",strategy = "identity")
	@GeneratedValue(generator = "gen1")
	private Integer sid;
	private String sname;
	private String saddress;
	private Integer sage;

	public Student() {
		System.out.println("Hibernate uses Zero argument constructor internally");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
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

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}

}
