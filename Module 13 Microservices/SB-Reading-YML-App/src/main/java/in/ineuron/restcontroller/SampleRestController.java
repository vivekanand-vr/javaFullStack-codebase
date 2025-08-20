package in.ineuron.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.constants.AppConstants;
import in.ineuron.props.DemoConfigProps;

@RestController
@RequestMapping("/api/test")
public class SampleRestController {
	
	@Autowired
	private DemoConfigProps props;
	
	@GetMapping("/wish")
	public String welcomeMsg() {
			return props.getProperties().get(AppConstants.WELCOME_MSG);
		}
	
	@GetMapping("/greet")
	public String greetMsg() {
			Map<String, String> properties = props.getProperties();
			for(Map.Entry<String, String> entry:properties.entrySet()) {
				System.out.println("Key :: " + entry.getKey());
				System.out.println("Value :: " + entry.getValue());
			}
			
			return props.getProperties().get(AppConstants.GREET_MSG);
		}
	
	@GetMapping("/test")
	public String testMsg() {
			return props.getProperties().get(AppConstants.TEST_MSG);
		}
}
