package com.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstApp 
{	
	/*	Method 1 - Creating object and adding objects and setting view name
	 * -----------
	 */
	@RequestMapping("/welcome")
	public ModelAndView displayMsg()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("message", "First Application...!");
		mv.setViewName("index");
		return mv;
	}
	
	/*
	 *  Method 2 - Shorter way of doing the same
	 * -----------
	 */
	@GetMapping("/java")
	public String display(Model model)
	{
		model.addAttribute("message", "Spring Boot is awsome");
		return "index";
		
	}

}
