package in.ineuron.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Flipkart;

public class TestAppUsingApplicationContextContainer {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("*****CONTAINER STARTED****\n");

		System.in.read();

		Flipkart flipkart = factory.getBean("fpkt", Flipkart.class);
		System.out.println(flipkart);
		System.out.println();
		String result = flipkart.doShopping(new String[] { "fossil", "tissot" }, new float[] { 23456.5f, 12345.5f });
		System.out.println(result);

		System.out.println("\n*****CONTAINER STOPPED****");
		factory.close();

	}
}

