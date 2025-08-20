package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.HelloClient;

@RestController
public class HiRestController {
	
	/*
	 *  Getting the HelloClient object which is proxy class implementation  given by Spring Boot
	 *  also when this service is on server then Hi-Service will also get the service of Hello-Service
	 */
	@Autowired
	private HelloClient client;

	@GetMapping("/hi/{name}")
	public String sayHiee(@PathVariable("name") String name) {
		
		System.out.println("Implementation classname is :: " + client.getClass().getName());

		String hieeMsg = "hiee";
		 
		/* Getting the service from Hello-Client */
		String helloMsg = client.invokeHelloService(name);

		return hieeMsg + "---- " + helloMsg + " " + name + " how r u ?";
	}
}
