package in.ineuron;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ineuron.config.model.customer.Customer;
import in.ineuron.config.model.product.Product;
import in.ineuron.repo.customer.ICustomerRepository;
import in.ineuron.repo.product.IProductRepository;

@SpringBootApplication
public class SpringDataJpaMultipleDbConfigurationApplication implements CommandLineRunner {

	@Autowired
	private IProductRepository productRepo;

	@Autowired
	private ICustomerRepository customerRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaMultipleDbConfigurationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		productRepo.saveAll(Arrays.asList(
				new Product(10, "C-001", "Fossil"), 
				new Product(11, "C-002", "Armani"),
				new Product(12, "C-003", "Tissot")

		));
		
		customerRepo.saveAll(
				Arrays.asList(
						new Customer(10,"sachin","sachin@gmail.com"),
						new Customer(18, "kohli", "kohli@gmail.com"),
						new Customer(7,"dhoni","dhoni@gmail.com")	
					)
				);
	}

}
