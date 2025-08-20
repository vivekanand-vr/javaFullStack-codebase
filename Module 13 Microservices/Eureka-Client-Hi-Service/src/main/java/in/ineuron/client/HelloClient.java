package in.ineuron.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HELLO-SERVICE")
public interface HelloClient {
	/*
	 * 	The implementation will be given by Spring Boot at runtime as proxy class,
	 *  this method is same as that of Hello-Service rest controller's "sayHello"
	 */
	@GetMapping("/hello/{name}")
	public String invokeHelloService(@PathVariable String name);
}
