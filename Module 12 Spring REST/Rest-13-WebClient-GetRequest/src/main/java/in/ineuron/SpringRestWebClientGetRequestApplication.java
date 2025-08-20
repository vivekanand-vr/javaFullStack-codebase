package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ineuron.service.CurrencyService;

@SpringBootApplication
public class SpringRestWebClientGetRequestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRestWebClientGetRequestApplication.class, args);

		CurrencyService bean = context.getBean("service", CurrencyService.class);

		String to = "INR";
		String from = "USD";
		
		
		bean.invokeRestApiSync(from, to);

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		
		bean.invokeRestApiASync(from, to);
	}
}
