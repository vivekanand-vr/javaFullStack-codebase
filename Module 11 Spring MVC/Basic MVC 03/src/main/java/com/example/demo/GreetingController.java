package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController 
{
	@GetMapping("/greeting")
	public String dispGreeting(Model model)
	{
		String greet="All the best for jobs";
		model.addAttribute("text", greet);
		return "index";
		
	}
	

}
