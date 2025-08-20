package in.ineuron.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.ineuron.service.IWishMessageService;

@Controller
public class WishMessageController {

	@Autowired
	private IWishMessageService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome() {
		return "home"; // String---> LVN
	}

	/*
	 *  Approach one: generating wish message and adding it to the ModelAndView Object
	 
	 @RequestMapping(value = "/wish", method = RequestMethod.GET) 
	 public ModelAndView showWishMessage(){
	  
		 //call service to get the information 
		 String msg = service.generateWishMessage();
	  
		 //Send the data from controller to View 
		 ModelAndView mav = new ModelAndView(); 
		 mav.addObject("msg", msg); 
		 mav.setViewName("display");
	  
		 return mav; //ViewName -> LVN 
	  }
	 */
	 
	
	
	 /*
	  *  Same method in different style, using "addAttribute" 
	  
	
	 @RequestMapping(value = "/wish", method = RequestMethod.GET) 
	 public String showWishMessage(Model model) 
	 {
		 System.out.println("Implemenation class name is :: " + model.getClass().getName()); 
		 String msg = service.generateWishMessage();
		 model.addAttribute("msg", msg); 
		 return "display"; 
	 }
	 */

	
	 
	 /*
	  *  Same method in different style, as data in model is in key value pair, we can use "put" method
	  
	  @RequestMapping(value = "/wish", method = RequestMethod.GET) 
	  public String showWishMessage(Map<String,Object> model) 
	  {
		  System.out.println("Implemenation class name is :: " +model.getClass().getName()); 
		  String msg = service.generateWishMessage();
		  model.put("msg", msg); return "display"; 
	  }
	  */
	  
	 
	  /*
	   * 	Same method that dosen't return or void
	   
	  @RequestMapping(value = "/wish", method = RequestMethod.GET) 
	  public void showWishMessage(Map<String,Object> model)
	  {
		  System.out.println("Implemenation class name is :: " + model.getClass().getName());
		  String msg = service.generateWishMessage();
		  model.put("msg", msg); 
		  return ;
	  }
	  */

	
	 /*
	  *  Void method that directly displays the view part without going to view object
	  *  Disclaimer: not a good practice
	  *  ----------
	  
	 @RequestMapping(value="/wish",method = RequestMethod.GET) 
	 public void generateMessage(HttpServletResponse response) throws Exception
	 { 
		String wmg = service.generateWishMessage(); response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<b>WishMessage :: "+wmg+"</b>"); 
	 }
	 */
	 
	
	
	 /*	 Best Approach:
	  * ----------------
	  *  Method with Map object as return type
	  */
	 @RequestMapping(value = "/wish", method = RequestMethod.GET)
	 	public Map<String, Object> generateMessage() throws Exception 
	 {
		String wmg = service.generateWishMessage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", wmg);
		return map;
	 }
	 
}
