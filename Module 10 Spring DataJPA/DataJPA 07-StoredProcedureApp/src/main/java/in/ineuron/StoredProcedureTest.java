package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IProductMgmtService;

@SpringBootApplication
public class StoredProcedureTest {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(StoredProcedureTest.class, args);

		IProductMgmtService service = factory.getBean(IProductMgmtService.class);
		service.fetchProductsByName("fossil", "tissot").forEach(System.out::println);
		((ConfigurableApplicationContext) factory).close();
	}
}
