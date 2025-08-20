package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/second")
public class SecondController 
{
	@GetMapping("/welcome")
	public String someWork(Model model)
	{
		model.addAttribute("message", "Second Controller");
		return "index";
		
	}
	
	@GetMapping("/java")
	public String someOtherWork(Model model)
	{
		model.addAttribute("message", "Second Controller 2nd message");
		return "index";
		
	}
	
	/*	
	 * 	run localhost:9090/second, no need to specify project name in url as it
	 *  an embedded server, 1 server for 1 app
	 *  mapping not added at method level then it will use class level 
	 *  mapping only if this is the only method which is not provided with 
	 *  mapping
	 */
	
	@GetMapping
	public String getNames(Model model)
	{
		model.addAttribute("message", "My name is Vicky");
		return "index";
		
	}
	
	/*
	 *  The below method is post method, and not have any mapping so not
	 *  ambiguous, as the above one is get
	 */
	
	@PostMapping
	public String getAddress(Model model)
	{
		model.addAttribute("message", "Bengaluru");
		return "index";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
