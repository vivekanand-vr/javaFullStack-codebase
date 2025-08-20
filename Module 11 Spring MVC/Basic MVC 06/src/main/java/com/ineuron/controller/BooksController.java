package com.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BooksController 
{
	@GetMapping(value ="/book/{bname}/{authorname}")
	public String getBooksDetail(@PathVariable("bname")String bname, 
			@PathVariable("authorname")String authorname, Model model)
	{
		
		String message=authorname+ " is the author of " + bname + " Which is famous";
		
		model.addAttribute("book", message);
		return "index";
	}

}
