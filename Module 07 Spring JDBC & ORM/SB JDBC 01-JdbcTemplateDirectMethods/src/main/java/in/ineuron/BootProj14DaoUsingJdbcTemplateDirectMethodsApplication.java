package in.ineuron;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IEmployeeMangementService;

@SpringBootApplication
public class BootProj14DaoUsingJdbcTemplateDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication
				.run(BootProj14DaoUsingJdbcTemplateDirectMethodsApplication.class, args);

		IEmployeeMangementService service = applicationContext.getBean(IEmployeeMangementService.class);
		List<Map<String, Object>> employeeDeatilsByDesignation = service.getEmployeeDeatilsByDesignation("SDE",
				"allrounder");
		employeeDeatilsByDesignation.forEach(System.out::println);

		((ConfigurableApplicationContext) applicationContext).close();
	}
}

