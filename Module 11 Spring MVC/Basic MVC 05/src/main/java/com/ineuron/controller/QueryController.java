package com.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryController 
{
	@GetMapping("/service")
	public String displayQueryParam(@RequestParam("name")String str, Model model)
	{
		/*
		 *   Url request to send : http://localhost:8080/service?name=vicky
		 */
		String message=str.concat(" Welcome to iNeuron!");
		model.addAttribute("query", message);
		return "index";
		
	}

}
