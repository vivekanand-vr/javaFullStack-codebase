package ai.ineuron.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMain 
{
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		ApplicationContext context=new  ClassPathXmlApplicationContext("Beans.xml");
		CourseSelection select=context.getBean("courseS", CourseSelection.class);
		select.selectCourse();
	}

}
