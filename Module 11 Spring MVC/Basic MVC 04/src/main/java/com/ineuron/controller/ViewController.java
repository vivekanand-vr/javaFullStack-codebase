package com.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController 
{
	@GetMapping("/viewDisplay")
	public String displayViewMessage(Model model)
	{
		String viewMsg="Welcome to iNeuron.ai --! java";
		model.addAttribute("msg", viewMsg);
		return "index";
		
	}

}
