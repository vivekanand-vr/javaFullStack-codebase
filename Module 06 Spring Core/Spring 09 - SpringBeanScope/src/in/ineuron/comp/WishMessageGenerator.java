package in.ineuron.comp;

import java.util.Date;

//Target class(userDefined=>WishMessageGenerator)
public class WishMessageGenerator {

	// Defendant class(PreDefined=> java.util.Date)
	private Date date;

	static {
		System.out.println("WishMessageGenerator.class file is loading...");
	}

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator object is instantiated using :: Zero param constructor");
	}

	public void setDate(Date date) {
		this.date = date;
		System.out.println("Setter method is called to perform Setter injection...");
		System.out.println(this);
	}

	public String toString() {
		return "WishMessageGenerator [date=" + date + "]";
	}

}
