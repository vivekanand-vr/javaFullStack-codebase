package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.PersonInfo;

public class TestApp {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("*********Container started**********");
		System.out.println("Bean id is :: " + Arrays.toString(factory.getBeanDefinitionNames()));

		System.in.read();

		System.out.println();

		PersonInfo personInfo = factory.getBean("pinfo", PersonInfo.class);
		System.out.println(personInfo);

		factory.close();

		System.out.println("\n*********Container stopped**********");
	}

}
