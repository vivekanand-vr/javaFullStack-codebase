package in.ineuron.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.comp.Student;

@SuppressWarnings("deprecation")
public class TestApp {

	public static void main(String[] args) {
		FileSystemResource resource = new FileSystemResource("src/in/ineuron/cfg/applicationContext.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);

		Student std1 = factory.getBean("std1", Student.class);
		System.out.println(std1);

		System.out.println();

		Student std2 = factory.getBean("std2", Student.class);
		System.out.println(std2);

		System.out.println();  

		Student std3 = factory.getBean("std3", Student.class);
		System.out.println(std3);
		
		System.out.println();
		
		Student std4 = factory.getBean("std4", Student.class);
		System.out.println(std4);

	}

}
