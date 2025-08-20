package in.ineuron.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.comp.WishMessageGenerator;

public class ConstructorInjectionApp {

	public static void main(String[] args) throws Exception {

		FileSystemResource resource = new FileSystemResource("src/in/ineuron/cfg/applicationContext.xml");

		System.out.println("***********BeanFactory container starting************");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		System.out.println("***********BeanFactory container started*************");

		WishMessageGenerator wishMessage = factory.getBean("wmg", WishMessageGenerator.class);
		System.out.println(wishMessage);
		
		String result = wishMessage.generateMessage("kohli");
		System.out.println(result);
		
		System.out.println("\n*******BeanFactory is closing***********");
		
	}
}
