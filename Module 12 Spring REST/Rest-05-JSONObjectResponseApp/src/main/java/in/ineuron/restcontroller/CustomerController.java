package in.ineuron.restcontroller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Company;
import in.ineuron.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	/*
	 * 	 GET: http://localhost:8080/api/customer/report/5
	 * 	 check port number before shooting request
	 */
	@GetMapping("/report/{id}")
	public ResponseEntity<Customer> showAllCustomer(@PathVariable Integer id) {

		// get from database
		System.out.println("Customer data for the id :: " + id);

		Customer customer = new Customer();
		customer.setCno(id);
		customer.setCname("sachin");
		customer.setBillAmount(54.5f);
		customer.setTeamNames(new String[] { "IND", "MI", "AsiaXI", "Mumbai" });
		customer.setStudies(List.of("10th", "12th", "Engineering"));
		customer.setPhoneNumbers(Set.of(9994445556L, 994349845L, 98765678L));
		customer.setIdDetails(Map.of("adhar", 99453123432L, "panNo", "DOOPQRCL12"));
		customer.setCompany(new Company("MI", "IPL", "Mumbai", 45));

		ResponseEntity<Customer> entity = new ResponseEntity<Customer>(customer, HttpStatus.OK);

		return entity;
	}
	
	/*
	 * 	Sending POST request with customer details through JSON object
	 * 	http://localhost:8080/api/customer/save
	 * 	In body section --> select raw --> select --> JSON --> copy the json data recieved from
	 * 	the above GET request and send, the customer details will be captured in the java object below
	 */
	@PostMapping(value= "/save")
	public ResponseEntity<String> saveCustomer(@RequestBody  Customer customer) {
		System.out.println(customer);
		Integer id = 10;
		String body = "customer registered with the id :: " + id;
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
	
	
}
