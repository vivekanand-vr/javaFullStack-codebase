package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	/*
	 * 	We need the model object for bi-directional binding
	 * 	list -> this URL pattern is linked with list-customers.jsp to display all the customers in the table
	 */
	@GetMapping("/list")
	public String listCustomers(Map<String, Object> model) {
		
		System.out.println("Implementation class is :: " + service.getClass().getName());
		/*
		 *  Get all the customers and store in list object, and then list object is sent to view part
		 *  (DataBinding) and can be used with the help of <c:for> tags of jstl-library
		 */
		List<Customer> customers = service.getCustomers();
		customers.forEach(System.out::println);
		model.put("customers", customers);
		return "list-customers";
	}
	
   /*
	* 	Mapping for form page to take the inputs through customer-form.jsp
	*/
	@GetMapping("/showForm")
	public String showFormForAdd(Map<String, Object> model) {
		/*
		 *  We are creating empty customer object that maps with the attributes in the customer-form.jsp
		 *  and then when we get inputs, the setter and getter methods are called to set the data
		 *  that is all done by the spring automatically <form:form> and then sent to further layer.
		 */
		Customer customer = new Customer();
		model.put("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println(customer);
		service.saveCustomer(customer);
		
		/* 
		 * 	after doing the save process we need to load the list, so for that we can use "redirect:" + our
		 * 	required path 
		 */
		
		return "redirect:/customer/list";
	}
	
	/*
	 * 	Maps to the page when we select --> update from the list of customers, 
	 * 	which record you click update on, that id customer object should be created and data
	 * 	should be fetched from the database and entered into the form inputs space.
	 */
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam Integer customerId, Map<String, Object> model) {
		Customer customer = service.getCustomer(customerId);
		System.out.println(customer);

		model.put("customer", customer);
		return "customer-form";
	}
	
   /*
	* 	when we select --> delete from the list of customers, the object is fetched and then deleted 
	* 	and then redirects to the default "customer/list" page
	*/
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam Integer customerId) {
		service.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}

}
