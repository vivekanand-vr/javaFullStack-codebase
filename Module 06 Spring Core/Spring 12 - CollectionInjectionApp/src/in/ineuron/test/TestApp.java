package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.College;
import in.ineuron.comp.ContactsInfo;
import in.ineuron.comp.MarksInfo;
import in.ineuron.comp.UniversityInfo;

public class TestApp {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("*********Container started**********");
		System.out.println("Bean id is :: " + Arrays.toString(factory.getBeanDefinitionNames()));

		System.in.read();
		
		System.out.println();

		MarksInfo info = factory.getBean("marks", MarksInfo.class);
		System.out.println(info);

		College clg = factory.getBean("clg", College.class);
		System.out.println(clg);

		ContactsInfo contactsInfo = factory.getBean("contact", ContactsInfo.class);
		System.out.println(contactsInfo);

		UniversityInfo universityInfo = factory.getBean("uInfo", UniversityInfo.class);
		System.out.println(universityInfo);

		factory.close();

		System.out.println("\n*********Container stopped**********");
	}

}
