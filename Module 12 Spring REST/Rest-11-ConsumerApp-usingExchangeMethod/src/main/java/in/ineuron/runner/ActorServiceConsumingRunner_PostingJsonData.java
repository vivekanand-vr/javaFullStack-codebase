
package in.ineuron.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_PostingJsonData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("ActorServiceConsumingRunner_PostingJsonData.run()");

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:9999/Rest-09-ProviderApp/api/actor/register";

		// Sending the information to @RequestBody(JSON data)
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String json_body = "{\r\n" + "    \"aid\":45,\r\n" + "\"name\":\"rohith\",\r\n" + "    \"age\":36,\r\n"
				+ "    \"type\":\"crickter\"\r\n" + "}";

		HttpEntity<String> entity = new HttpEntity<String>(json_body, headers);

		ResponseEntity<String> responseEntity = template.exchange(
														serviceUrl, //the url 
														HttpMethod.POST, // method type
														entity, // sending the entity
														String.class); // getting the response in this type

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		System.out.println("********************************************************");

	}
}
