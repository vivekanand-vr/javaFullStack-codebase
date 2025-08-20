package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Car;

public class TestApp {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/applicationContext.xml");
		System.out.println("*********Container started**********");
		System.out.println("Bean id is :: " + Arrays.toString(factory.getBeanDefinitionNames()));
		System.out.println();

		Car c1 = factory.getBean("car1", Car.class);
		System.out.println(c1);

		Car c2 = factory.getBean("car2", Car.class);
		System.out.println(c2);

		Car baseCar = factory.getBean("baseCar", Car.class);
		System.out.println(baseCar);

		factory.close();

		System.out.println("\n*********Container stopped**********");
	}

}
