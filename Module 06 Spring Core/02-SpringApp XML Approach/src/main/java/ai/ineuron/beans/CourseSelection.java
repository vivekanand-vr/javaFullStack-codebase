package ai.ineuron.beans;

public class CourseSelection 
{
	
	private Courses course;
	
	public void setCourse(Courses course)
	{
		this.course=course;
	}
	
	public void selectCourse()
	{
		boolean status=course.courseSelection();
		if(status)
		{
			System.out.println("Course selected successfully");
		}
		else
		{
			System.out.println("Failed to select");
		}
	}

}
