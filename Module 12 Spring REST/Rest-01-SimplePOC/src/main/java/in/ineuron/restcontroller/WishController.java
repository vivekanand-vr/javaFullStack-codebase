package in.ineuron.restcontroller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*	
 * 	@RequestMapping("/wish") 
 * 	to make sure the response entity dosen't send the response to view but it should be sent as a
 * 	HTTP response to whom it called.
 */
@RestController
@RequestMapping("/wish") 
public class WishController {

	@GetMapping("/msg")
	public ResponseEntity<String> generateWishMessage() {

		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();

		String body = null;
		if (hour < 12)
			body = "Good Morning";
		else if (hour < 16)
			body = "Good Afternoon";
		else if (hour < 20)
			body = "Good Evening";
		else
			body = "Good night";

		ResponseEntity<String> entity = new ResponseEntity<>(body, HttpStatus.OK);
		return entity;
	}
}
