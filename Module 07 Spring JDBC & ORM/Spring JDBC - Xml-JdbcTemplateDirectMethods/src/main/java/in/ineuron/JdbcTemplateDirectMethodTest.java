package in.ineuron;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.service.IEmployeeMangementService;

public class JdbcTemplateDirectMethodTest {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");

		IEmployeeMangementService service = applicationContext.getBean(IEmployeeMangementService.class);

		try {
			int recordCount = service.fetchEmpsCount();
			System.out.println("No of records are :: " + recordCount);

			String name = service.getEmployeeNameByNo(1);
			System.out.println("Employee name is :: " + name);

			Map<String, Object> empDetails = service.getEmployeeDetailsByNo(1);
			System.out.println("Employee Details are :: " + empDetails);

			service.getEmployeeDeatilsByDesignation("batsman", "allrounder").forEach(System.out::println);

			int rowAffected = service.insertEmp("Mayers", 24, "LSG", "allrounder", 3000);
			System.out.println("No of records affected are :: " + rowAffected);

			int rowForUpdation = service.addBonusToEmpByDesg("batsman", 1000);
			System.out.println("No of rows affected is ::" + rowForUpdation);

		} catch (Exception e) {
			System.out.println("The exception msg is ::" + e.getMessage());
		}
		((ConfigurableApplicationContext) applicationContext).close();

	}
}
