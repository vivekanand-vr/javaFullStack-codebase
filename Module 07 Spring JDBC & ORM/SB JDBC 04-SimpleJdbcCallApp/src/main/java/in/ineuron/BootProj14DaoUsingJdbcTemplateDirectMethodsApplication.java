package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IProductServiceMgmt;

@SpringBootApplication
public class BootProj14DaoUsingJdbcTemplateDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication
				.run(BootProj14DaoUsingJdbcTemplateDirectMethodsApplication.class, args);

		
		IProductServiceMgmt service = applicationContext.getBean(IProductServiceMgmt.class);
		service.getProductByNames("fossil", "tissot").forEach(System.out::println);

		((ConfigurableApplicationContext) applicationContext).close();
	}
}
