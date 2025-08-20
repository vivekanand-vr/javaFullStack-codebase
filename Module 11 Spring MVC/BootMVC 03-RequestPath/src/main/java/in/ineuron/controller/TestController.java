package in.ineuron.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
		/*
		 * Normal Approach
		 * 
		 */
		 
		@GetMapping(value="/report")
		public String showReport(Map<String, Object> model) {
			System.out.println("TestController.showReport()");
			return "display";
		}
		
	
		/* 
		 * Default path is "/" only so no need to write for home page
	
		 * @RequestMapping public String showHome() { return "home"; }
		 */
	
	
	
		/*
		 *  Shorter way of @RequestMapping(value = "/report", method = RequestMethod.POST) is below
		 *  
		 
			@PostMapping(value = "/report")
			public String showReport(Map<String, Object> model) {
				System.out.println("TestController.showReport()");
				return "display";
			}
		 */

	
	
		/*
		 * Shorter way of writing get mapping instead of @RequestMapping(......GET)
		 * 
		@GetMapping(value = "/report")
		public String showReport1(Map<String, Object> model) {
			System.out.println("TestController.showReport1()");
			return "display1";
		}
		*/
	
	
	
		/*
		 * 	One handler can have multiple url patterns
		 * 
		 
		  @GetMapping(value = {"/report","/report1","/report2"}) 
		  public String showReport(Map<String, Object> model)
		  {
			  System.out.println("TestController.showReport()"); 
			  return "display"; 
		  }
		  
		 */
	 

		/*
		 * We can write same path but with different modes
		 * 
		 
		 @GetMapping(value = "report") public String showReport(Map<String, Object> model)
		 { System.out.println("TestController.showReport()"); return "display"; }
		  
		  @PostMapping(value="report") public String showReport1(Map<String, Object> model) 
		  { System.out.println("TestController.showReport1()"); return "display"; }
		  
		 */
	 


}
