package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.bo.Customer;

public interface ICustomerRepo extends CrudRepository<Customer, Integer>{

}
