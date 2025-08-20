package in.ineuron.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Flipkart;

public class ClientApp {

	public static void main(String[] args) throws Exception {

		ApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");

		Flipkart flipkart = factory.getBean(Flipkart.class);
		System.out.println(
				flipkart.doShopping(new String[] { "tissot", "omegha" }, new float[] { 35000.46f, 600000.50f }));

		((AbstractApplicationContext) factory).close();
	}
}
