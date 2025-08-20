package ai.ineuron.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config 
{
	public Config()
	{
		System.out.println("Config bean");
	}
	
	@Bean
	public EncPassword getInstance()
	{
		EncPassword pw=new EncPassword("SHA-01");
		return pw;
	}
	

}
