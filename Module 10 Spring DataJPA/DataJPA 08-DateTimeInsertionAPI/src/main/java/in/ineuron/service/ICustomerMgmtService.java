package in.ineuron.service;

import java.util.List;

import in.ineuron.bo.Customer;

public interface ICustomerMgmtService {
	public String registerCustomer(Customer customer);
	public List<Customer> getAllCustomers();
}
