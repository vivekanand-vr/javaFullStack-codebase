package ai.ineuron.beans;

public class SQLCourse implements Courses {

	public SQLCourse()
	{
		System.out.println("SQL obj is created");
	}
	public boolean courseSelection() {
		
		System.out.println("SQL - MySql selected");
		return true;
		

	}

}
