package in.ineuron.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ineuron.model.Customer;

public class TestApp {

	public static void main(String[] args) {

		try {
			// Create Object Mapper
			ObjectMapper mapper = new ObjectMapper();

			// using that Object read the data from json file and convert into pojo object
			Customer customer = mapper.readValue(new File("data/sample-full.json"), Customer.class);

			// printing simple values
			System.out.println("Id is :: " + customer.getId());
			System.out.println("FirstName is :: " + customer.getFirstName());
			System.out.println("LastName  is :: " + customer.getLastName());
			System.out.println("IsActive     :: " + customer.getActive());

			// Printing HAS-Property data
			System.out.println("Customer Addres is :: " + customer.getAddress());

			// Printing Languages[] information
			for (String language : customer.getLanguages()) {
				System.out.println(language);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
