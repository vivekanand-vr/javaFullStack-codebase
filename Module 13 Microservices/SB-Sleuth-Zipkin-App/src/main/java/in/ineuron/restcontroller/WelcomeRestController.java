package in.ineuron.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

	/*
	 * 	Note: 	Download zipkin server (it is a jar file)
	   ------	run the zipkin server jar file from the command prompt
					--> syntax: java -jar <zipkin-jar-filname.jar>
			  	run the zipkin server using the following url : http://localhost:9411/
	 */

@RestController
public class WelcomeRestController {

	Logger logger = LoggerFactory.getLogger(WelcomeRestController.class);

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		logger.info("***** getWelcomeMsg() started******");
		String msg = "Welcome to ineuron";
		logger.info("**** getWelcomeMsg() ended *****");
		return msg;
	}	
}
