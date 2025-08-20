package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value="dotNet")
public class DotNetCourseMaterial implements ICourse {
	

	static {
		System.out.println("DotNetCourseMaterial.class file is loading...");
	}
	public DotNetCourseMaterial() {
		System.out.println("DotNetCourseMaterial:: Zero param constructor...");
	}

	@Override
	public String courseContent() {
		System.out.println("DotNetCourseMaterial.courseContent()");
		return "1.C#oops 2.C#ExceptionHandling 3.C#Collection...";
	}

	@Override
	public float price() {
		return 500;
	}

}
