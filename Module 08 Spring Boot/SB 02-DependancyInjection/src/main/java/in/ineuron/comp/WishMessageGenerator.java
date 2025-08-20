package in.ineuron.comp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishMessageGenerator {

	@Autowired(required = true)
	private LocalDateTime date;

	static {
		System.out.println("WishMessageGenerator.class file is loading...");
	}

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:: Zero param constructor...");
	}

	// Business Logic method
	public String greetUser(String userName) {
		int hour = date.getHour();
		if (hour < 12)
			return "Good Morning :: " + userName;
		else if (hour < 16)
			return "Good Afternoon :: " + userName;
		else if (hour < 20)
			return "Good Evening :: " + userName;
		else
			return "Good Night :: " + userName;

	}

	@Override
	public String toString() {
		return "WishMessageGenerator [date=" + date + "]";
	}

}
