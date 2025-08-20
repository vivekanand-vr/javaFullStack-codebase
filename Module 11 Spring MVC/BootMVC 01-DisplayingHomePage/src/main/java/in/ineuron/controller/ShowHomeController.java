package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowHomeController {

	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}
}
