package in.ineuron;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.Customer;
import in.ineuron.service.ICustomerMgmtService;

@SpringBootApplication
public class DateInsertionApp {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DateInsertionApp.class, args);

		ICustomerMgmtService service = factory.getBean(ICustomerMgmtService.class);

		Customer customer = new Customer("dravid", "RCB", LocalDateTime.of(1973, 11, 1, 15, 0, 12),LocalTime.of(10, 45), LocalDate.now());
		String status = service.registerCustomer(customer);
		System.out.println(status);
		System.out.println();
		
		service.getAllCustomers().forEach(System.out::println);

		((ConfigurableApplicationContext) factory).close();
	}
}
