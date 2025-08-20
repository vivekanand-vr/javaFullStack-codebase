package in.ineuron.service;

import java.util.List;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;

public interface ICustomerMgmtService {
	public String registerCustomer(CustomerDTO dto);
	public List<Customer> findAllCustomers();
	public String removeCustomer(String id);
	public List<Customer> fetchCustomerByBillAmount(float min,float max);
	public List<Customer> fetchCustomerByUsingAddressAndHavingMobileNo(String...address);
}
