package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value = "uiCourse")
public class UICourseMaterial implements ICourse {

	static {
		System.out.println("UICourseMaterial.class file is loading...");
	}

	public UICourseMaterial() {
		System.out.println("UICourseMaterial:: Zero param constructor...");
	}

	@Override
	public String courseContent() {
		System.out.println("UICourseMaterial.courseContent()");
		return "1.HTML 2.CSS 3.JavaScript";
	}

	@Override
	public float price() {
		return 500;
	}

}
