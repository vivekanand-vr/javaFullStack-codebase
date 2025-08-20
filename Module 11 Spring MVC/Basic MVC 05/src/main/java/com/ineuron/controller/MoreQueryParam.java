package com.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoreQueryParam 
{
	@GetMapping("/booksinfo")
	public String getMoreInfo(@RequestParam("bookname")String fname,@RequestParam("bookauthor")String lname,Model model)
	{
		
		String message="Book name :" + fname + " Book author :"+ lname;
		model.addAttribute("query", message);
		return "index";
		
	}

}
