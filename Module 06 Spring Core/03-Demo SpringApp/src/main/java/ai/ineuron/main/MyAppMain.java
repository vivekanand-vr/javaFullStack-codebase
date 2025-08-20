package ai.ineuron.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ai.ineuron.service.UserService;

public class MyAppMain {

	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		UserService service=context.getBean(UserService.class);
		service.storeInDb();

	}

}
