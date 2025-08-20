package ai.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ai.ineuron.dao.UserDao;

@Service
public class UserService 
{
	@Autowired
	private UserDao userDao ;
	
	public UserService()
	{
		System.out.println("User service obj created");
	}
	
	public void storeInDb()
	{
		boolean status=userDao.save();
		if(status)
		{
			System.out.println("Storing sucess");
		}
		else
		{
			System.out.println("Failed");
		}
	}

}
