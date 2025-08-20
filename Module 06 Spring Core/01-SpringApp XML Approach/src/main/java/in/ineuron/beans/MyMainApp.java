package in.ineuron.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyMainApp {

	public static void main(String[] args) 
	{
//		Resource resource=new ClassPathResource("Beans.xml");		
//		BeanFactory factory=new XmlBeanFactory(resource);
		
		@SuppressWarnings("resource")
		ApplicationContext factory=new ClassPathXmlApplicationContext("Beans.xml");
		
		factory.getBean("credit", CreditCardPay.class);
		factory.getBean("debit", DebitCardPay.class);
		
		PaymentProcess process=factory.getBean("paying", PaymentProcess.class);
		System.out.println("able to get the object");
		process.doPayment(100.0);
	}

}
