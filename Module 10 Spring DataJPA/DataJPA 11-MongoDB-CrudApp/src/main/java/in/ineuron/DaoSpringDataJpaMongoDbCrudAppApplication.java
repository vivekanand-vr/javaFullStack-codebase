package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgmtService;

@SpringBootApplication
public class DaoSpringDataJpaMongoDbCrudAppApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(DaoSpringDataJpaMongoDbCrudAppApplication.class, args);
		ICustomerMgmtService service = applicationContext.getBean(ICustomerMgmtService.class);
		
		/*	Before operations configure and connect the mongoDB
		 * 	Insert into mongo -> fsDB database -> customer collection
		 */
		System.out.println(service.registerCustomer(new CustomerDTO(18, "kohli", 110.0f, null, null)));
		System.out.println(service.registerCustomer(new CustomerDTO(3, "nitinmanjunath", 550.0f, null, null)));
		
		
		
		/*
		 * 	Fetch all customers
		 */
		service.findAllCustomers().forEach(System.out::println);
		
		
		
		/*
		 * 	Remove a record by it's id
		 */
		System.out.println(service.removeCustomer("aeab8d9668"));
		
		
		
		/*	Here the CustomerDTO is modified with 2 extra fields:caddress and mobile-no
		 * 	Add a record:
		 */
		service.registerCustomer(new CustomerDTO(18, "kohli", 450.05f, "RCB", 999555776L));
		
		
		
		/*
		 * 	Fetch customer by bill amount
		 */
		service.fetchCustomerByBillAmount(340.50f, 500.05f).forEach(System.out::println);
		
		
		
		/*
		 * 	Fetch customer by address and one having mobile no;
		 */
		service.fetchCustomerByUsingAddressAndHavingMobileNo("MI","RCB").forEach(System.out::println);
		
		
		((ConfigurableApplicationContext) applicationContext).close();		
	}
}
