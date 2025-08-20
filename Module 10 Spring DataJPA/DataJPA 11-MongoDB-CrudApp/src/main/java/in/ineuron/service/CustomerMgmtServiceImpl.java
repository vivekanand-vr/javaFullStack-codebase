package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.generator.IdGenerator;
import in.ineuron.repository.ICustomerRepo;

@Service("service")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	private ICustomerRepo repo;

	@Override
	public String registerCustomer(CustomerDTO dto) {
		Customer document = new Customer();
		document.setId(IdGenerator.generateId());
		BeanUtils.copyProperties(dto, document);

		return "Document is saved/updated with the id :: " + repo.save(document).getId();
	}

	@Override
	public List<Customer> findAllCustomers() {
		return repo.findAll();
	}

	@Override
	public String removeCustomer(String id) {
		Optional<Customer> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.delete(optional.get());
			return "Document is deleted...";
		}
		return "Document not found";
	}

	@Override
	public List<Customer> fetchCustomerByBillAmount(float min, float max) {
		return repo.findByBillAmtBetween(min, max);
	}

	@Override
	public List<Customer> fetchCustomerByUsingAddressAndHavingMobileNo(String... address) {
		return repo.findByCaddrInAndMobileNoIsNotNull(address);
	}

}
