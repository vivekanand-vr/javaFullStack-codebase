package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristMgmtService;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private ITouristMgmtService service;
	
   /*
    *  http://localhost:9999/RestMiniProject/api/tourist/register
	*  Body: {
			    "city": 5,
			    "name": "sachin",
			    "packageType": "single",
			    "budget": 9934.5    
			 }
	*/
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		try {
			String resultMsg = service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg, 
					HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<String>("Problem in tourist enrollment",
					HttpStatus.INTERNAL_SERVER_ERROR);																											
		}
	}
	
   /*
	*  Fetch all tourists from the database 
	*/
	@GetMapping("/findAll")
	public ResponseEntity<?> displayTouristDetails() {
		try {
			List<Tourist> list = service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<String>("Problem in fetching tourist", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
   /*
	*  Fetch tourist by id given from the UI
	*/
	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {
		try {
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
   /*
	*  Request to modify the tourist details, object is passed to the request
	*/
	@PutMapping("/modify")
	public ResponseEntity<String> modifytourist(@RequestBody Tourist tourist) {
		try {
			String msg = service.updateTouristByDetails(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping("/budgetModify/{id}/{hike}")
	public ResponseEntity<String> modifytouristBudgetById(@PathVariable("id") Integer id,
			@PathVariable("hike") Float hikeAmt) {
		try {
			String msg = service.updateTouristById(id, hikeAmt);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * 	 DELETE Request: delete the tourist by id
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTouristById(@PathVariable("id") Integer id) {
		try {
			String msg = service.deleteTouristById(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
