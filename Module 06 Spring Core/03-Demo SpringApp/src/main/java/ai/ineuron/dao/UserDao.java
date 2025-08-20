package ai.ineuron.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao 
{
	public UserDao()
	{
		System.out.println("User Dao obj created");
	}
	
	public boolean save()
	{
		System.out.println("able to save in db");
		return true;
	}

}
