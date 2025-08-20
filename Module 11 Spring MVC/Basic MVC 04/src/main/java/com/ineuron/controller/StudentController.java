package com.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ineuron.model.Student;

@Controller
public class StudentController 
{
	@GetMapping("/studentinfo")
	public String getData(Model m)
	{
		Student st=new Student();
		st.setId(01);
		st.setFirstName("Hyder");
		st.setLastName("Abbas");
		st.setGender("Male");
		st.setCity("Bengaluru");
		st.setDob("08/03/2005");
		
		m.addAttribute("std", st);
		return "student";
	}

}
