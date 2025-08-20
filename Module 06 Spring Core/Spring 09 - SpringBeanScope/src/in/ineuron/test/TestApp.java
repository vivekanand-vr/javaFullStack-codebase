package in.ineuron.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.WishMessageGenerator;

public class TestApp {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		
		System.in.read();
		
		WishMessageGenerator wmg1 = factory.getBean("wmg1", WishMessageGenerator.class);
		System.out.println(wmg1+" available at :: "+wmg1.hashCode());
		
		WishMessageGenerator wmg2 = factory.getBean("wmg2", WishMessageGenerator.class);
		System.out.println(wmg2+" available at :: "+wmg2.hashCode());

		factory.close();
	}

}
