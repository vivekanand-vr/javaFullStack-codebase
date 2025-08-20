package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.WishMessageGenerator;

public class SetterInjectionUsingApplicationContext {

	public static void main(String[] args) throws Exception {

		System.out.println("***********ApplicationContext container starting************");
		//Eager Loading happens
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");

		System.out.println("No of beans is :: " + factory.getBeanDefinitionCount());
		System.out.println("Bean id  is :: " + Arrays.toString(factory.getBeanDefinitionNames()));

		System.out.println("\n***********ApplicationContext container started*************");

		System.in.read();

		WishMessageGenerator wmg = factory.getBean("wmg", WishMessageGenerator.class);
		System.out.println("Hashcode value of wmg is :: " + wmg.hashCode());
		System.out.println(wmg);
		String result = wmg.generateMessage("sachin");
		System.out.println(result + "\n");

		WishMessageGenerator wmg1 = factory.getBean("wmg", WishMessageGenerator.class);
		System.out.println("HashCode value of wmg1 is :: " + wmg1.hashCode());
		System.out.println(wmg1);
		String result1 = wmg1.generateMessage("kohli");
		System.out.println(result1);

		System.out.println();

		System.out.println("*******Container is closing**********");
		factory.close();
	}
}
