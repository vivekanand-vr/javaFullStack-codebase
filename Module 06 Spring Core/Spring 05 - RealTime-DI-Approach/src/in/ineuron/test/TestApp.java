package in.ineuron.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.ineuron.comp.Flipkart;

public class TestApp {

	public static void main(String[] args) throws Exception {

		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("in/ineuron/cfg/applicationContext.xml");
		System.out.println("*****CONTAINER STARTED****\n");

		System.in.read();

		Flipkart flipkart = factory.getBean("fpkt", Flipkart.class);
		System.out.println(flipkart);
		System.out.println();
		String result = flipkart.doShopping(new String[] { "fossil", "tissot" }, new float[] { 23456.5f, 12345.5f });
		System.out.println(result);

		System.out.println("\n*****CONTAINER STOPPED****");

	}
}
