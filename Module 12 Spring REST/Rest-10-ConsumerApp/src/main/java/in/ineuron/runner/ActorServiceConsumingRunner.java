package in.ineuron.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumingRunner.run()");
		
		/*
		 *  Run producer application on tomcat server and note the url pattern and port number
		 *  give the same in the serviceUrl
		 */
		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:9999/Rest-09-ProviderApp/api/actor/wish";

		ResponseEntity<String> responseEntity = template.getForEntity(serviceUrl, String.class);

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		System.out.println("********************************************************");

	}
}
