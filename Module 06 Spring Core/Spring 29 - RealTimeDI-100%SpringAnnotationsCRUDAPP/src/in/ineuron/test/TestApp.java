package in.ineuron.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.ineuron.cfg.AppConfig;
import in.ineuron.controller.MainController;
import in.ineuron.vo.EmployeeVO;

public class TestApp {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the ename:: ");
		String ename = scanner.next();

		System.out.print("Enter the eage:: ");
		String eage = scanner.next();

		System.out.print("Enter the eaddress:: ");
		String eaddress = scanner.next();

		System.out.print("Enter the esalary:: ");
		String esalary = scanner.next();

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MainController controller = context.getBean(MainController.class);
		EmployeeVO vo = new EmployeeVO();
		vo.setEadress(eaddress);
		vo.setEage(eage);
		vo.setEname(ename);
		vo.setEsalary(esalary);
		EmployeeVO voResult = controller.getHike(vo);
		System.out.println(voResult);

		((AbstractApplicationContext) context).close();
		scanner.close();

	}
}
