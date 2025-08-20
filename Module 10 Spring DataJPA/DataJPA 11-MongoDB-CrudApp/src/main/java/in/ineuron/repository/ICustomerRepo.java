package in.ineuron.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.ineuron.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {
		public List<Customer>  findByBillAmtBetween(float start,float end);
		public List<Customer>  findByCaddrInAndMobileNoIsNotNull(String ...address);
}
