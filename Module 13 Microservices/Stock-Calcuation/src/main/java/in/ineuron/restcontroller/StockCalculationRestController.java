package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.StockClient;

@RestController
@RequestMapping("/calc")
public class StockCalculationRestController {

	@Autowired
	private StockClient client;

	@GetMapping("/calculate/{companyName}/{quantity}")
	public ResponseEntity<?> calculate(@PathVariable String companyName, @PathVariable Integer quantity) {

		ResponseEntity<?> responseEntity = null;
		Double totalPrice = null;
		/* Debug */
		System.out.println(companyName);
		System.out.println(quantity);

		try {
			
			/* fetch stock price by company name */
			responseEntity = client.getStockPrice(companyName);
			System.out.println(responseEntity);

			int statusCode = responseEntity.getStatusCode().value();
			
			/* if request is successful, calculate the price overall */
			if (statusCode == 200) {
				Double companyStockPrice = (Double) responseEntity.getBody();
				totalPrice = quantity * companyStockPrice;
				String response = "Total cost :: " + totalPrice;
				responseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
			}

		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("company not found", HttpStatus.BAD_REQUEST);
		}

		return responseEntity;

	}

}
