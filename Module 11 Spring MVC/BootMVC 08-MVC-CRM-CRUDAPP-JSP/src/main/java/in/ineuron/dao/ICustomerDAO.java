package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.model.Customer;

public interface ICustomerDAO extends CrudRepository<Customer, Integer> {
	/*
	 * 	All the implementation is given by spring framework when we extend CrudRepository
	 * 	See all the method's in the outline view in eclipse ide
	 */
}
