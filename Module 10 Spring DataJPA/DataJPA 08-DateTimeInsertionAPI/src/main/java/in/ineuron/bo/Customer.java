package in.ineuron.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String cname;
	private String caddress;

	private LocalDateTime dob;
	private LocalTime dom;
	private LocalDate doj;

	public Customer() {
	}

	public Customer(String cname, String caddress, LocalDateTime dob, LocalTime dom, LocalDate doj) {
		super();
		this.cname = cname;
		this.caddress = caddress;
		this.dob = dob;
		this.dom = dom;
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", caddress=" + caddress + ", dob=" + dob + ", dom=" + dom
				+ ", doj=" + doj + "]";
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public LocalTime getDom() {
		return dom;
	}

	public void setDom(LocalTime dom) {
		this.dom = dom;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

}
