package in.ineuron.repo.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.config.model.customer.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
