package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetController {
	
	/*
	 * 	http://localhost:9999/greet/msg
	 */
	@GetMapping("/msg")
	public ResponseEntity<String> wishMessage() {
		String msg = "Good Evening";

		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
