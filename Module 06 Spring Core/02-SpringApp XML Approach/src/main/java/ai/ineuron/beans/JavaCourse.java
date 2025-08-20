package ai.ineuron.beans;

public class JavaCourse implements Courses {

	public JavaCourse()
	{
		System.out.println("Java obj created by IOC");
	}
	public boolean courseSelection() {
		System.out.println("Java is selected");
		return true;

	}

}
