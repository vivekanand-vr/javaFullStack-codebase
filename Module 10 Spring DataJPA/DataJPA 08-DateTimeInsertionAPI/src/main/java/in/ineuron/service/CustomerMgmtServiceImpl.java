package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.Customer;
import in.ineuron.dao.ICustomerRepo;

@Service("service")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo repo;

	@Override
	public String registerCustomer(Customer customer) {
		Integer cid = repo.save(customer).getCid();
		return "customer saved with the id :: " + cid;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = (List<Customer>) repo.findAll();
		return customers;
	}
}
