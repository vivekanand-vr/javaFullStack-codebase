package in.ineuron.service;

import in.ineuron.bo.CustomerBO;
import in.ineuron.dao.ICustomerDAO;
import in.ineuron.dto.CustomerDTO;

public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	private ICustomerDAO dao;

	static {
		System.out.println("CustomerMgmtServiceImpl.class file is loading...");
	}

	public CustomerMgmtServiceImpl(ICustomerDAO dao) {
		System.out.println("CustomerMgmtServiceImpl:: One param constructor..");
		this.dao = dao;
	}

	@Override
	public String calculateSimpleInterest(CustomerDTO dto) {

		float intrAmt = 0.0f;

		intrAmt = (dto.getPamt() * dto.getTime() * dto.getRate()) / 100.0f;

		CustomerBO bo = new CustomerBO();

		bo.setCustomerAddress(dto.getCustomerAddress());
		bo.setCustomerName(dto.getCustomerName());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setInterestAmt(intrAmt);

		int count = dao.insert(bo);

		// process the result
		if (count == 0)
			return "Customer Registration failed :: " + dto.getPamt() + " Interest :: " + intrAmt;
		else
			return "Customer Registration Successful :: " + dto.getPamt() + " Interest :: " + intrAmt;

	}

}
