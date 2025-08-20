package in.ineuron;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.StudentDTO;
import in.ineuron.service.IStudentMgmtService;

@SpringBootApplication
public class BootProj14DaoUsingJdbcTemplateDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication
				.run(BootProj14DaoUsingJdbcTemplateDirectMethodsApplication.class, args);

		IStudentMgmtService service = applicationContext.getBean(IStudentMgmtService.class);

		StudentDTO student = service.fetchStudentByNo(3);
		System.out.println(student);

		System.out.println();

		List<StudentDTO> list = service.fetchStudentByName("sachin", "kohli");
		list.forEach(System.out::println);
		System.out.println();

		service.fetchStudentByCitites("CSK", "LSG", "MI").forEach(System.out::println);

		((ConfigurableApplicationContext) applicationContext).close();
	}
}
