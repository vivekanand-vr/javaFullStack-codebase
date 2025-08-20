package in.ineuron.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "uiCourse")
public class UICourseMaterial implements ICourse {

	private Logger logger = LoggerFactory.getLogger(UICourseMaterial.class);
	
	static {
		System.out.println("UICourseMaterial.class file is loading...");
	}

	public UICourseMaterial() {
		System.out.println("UICourseMaterial:: Zero param constructor...");
	}

	@Override
	public String courseContent() {
		logger.debug("control entering inside UICourseMaterial :: courseContent");
		System.out.println("UICourseMaterial.courseContent()");
		return "1.HTML 2.CSS 3.JavaScript";
	}

	@Override
	public float price() {
		return 500;
	}

}
