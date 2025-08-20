
package in.ineuron.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_pathVariable implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ActorServiceConsumingRunner_pathVariable.run()");

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:9999/Rest-09-ProviderApp/api/actor/wish/{id}/{name}";

		ResponseEntity<String> responseEntity = template.exchange(
															serviceUrl, 
															HttpMethod.GET, 
															null, 
															String.class, 
															7,"dhoni");

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		System.out.println("********************************************************");

	}
}
