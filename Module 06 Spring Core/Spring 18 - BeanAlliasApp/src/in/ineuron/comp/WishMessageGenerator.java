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
		System.out.println("WishMessageGenerator object is instantiated...");
	}

	public void setDate(Date date) {
		this.date = date;
		System.out.println("Setter method is called to perform Setter injection...");
	}

	// Business logic method====> using Dependent object in B.L
	@SuppressWarnings("deprecation")
	public String generateMessage(String userName) {
		int hour = date.getHours();// get hour in 24 hour format

		if (hour < 12) {
			return "Good Morning :: " + userName;
		} else if (hour < 16) {
			return "Good AfterNoon :: " + userName;
		} else if (hour < 20) {
			return "Good Evening ::  " + userName;
		} else {
			return "Good Night :: " + userName;
		}
	}

	public String toString() {
		return "WishMessageGenerator [date=" + date + "]";
	}

}
