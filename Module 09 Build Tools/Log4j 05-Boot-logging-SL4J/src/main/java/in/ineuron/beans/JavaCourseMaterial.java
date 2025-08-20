package in.ineuron.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "java")
public class JavaCourseMaterial implements ICourse {
	
	private Logger logger = LoggerFactory.getLogger(JavaCourseMaterial.class);

	static {
		System.out.println("JavaCourseMaterial.class file is loading...");
	}
	public JavaCourseMaterial() {
		System.out.println("JavaCourseMaterial:: Zero param constructor...");
	}
	
	@Override
	public String courseContent() {
		logger.debug("control entering into JavaCourseMaterial :: courseContent()");
		System.out.println("JavaCourseMaterial.courseContent()");
		return "1.oops 2.ExcpetionHandling 3.Collection....";
	}

	@Override
	public float price() {
		return 400;
	}

}
