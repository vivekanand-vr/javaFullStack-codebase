package in.ineuron.service;

import in.ineuron.dto.CustomerDTO;

public interface ICustomerMgmntService {
	public String calcuateSimpleInterest(CustomerDTO dto) throws Exception;
}
