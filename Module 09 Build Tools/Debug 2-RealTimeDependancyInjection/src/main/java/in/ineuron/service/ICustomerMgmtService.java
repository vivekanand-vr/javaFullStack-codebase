package in.ineuron.service;

import in.ineuron.dto.CustomerDTO;

public interface ICustomerMgmtService {
	public abstract String calculateSimpleInterest(CustomerDTO dto);
}
