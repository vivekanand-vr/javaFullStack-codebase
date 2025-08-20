package in.ineuron.service;

import in.ineuron.bo.CustomerBO;
import in.ineuron.dao.ICustomerDAO;
import in.ineuron.dto.CustomerDTO;

public class CustomerMgmtServiceImpl implements ICustomerMgmntService {

	private ICustomerDAO dao;

	public CustomerMgmtServiceImpl(ICustomerDAO dao) {
		this.dao = dao;
		System.out.println("CustomerMgmtServiceImpl:: 1 param constructor----> " + dao.getClass().getName());
	}

	@Override
	public String calcuateSimpleInterest(CustomerDTO dto) throws Exception {

		float intrAmount = (dto.getPamt() * dto.getTime() * dto.getRate()) / 100.0f;

		CustomerBO customerBO = new CustomerBO();
		customerBO.setCustomerAddress(dto.getCustomerAddress());
		customerBO.setCustomerName(dto.getCustomerName());
		customerBO.setPamt(dto.getPamt());
		customerBO.setTime(dto.getTime());
		customerBO.setRate(dto.getRate());
		customerBO.setIntrAmount(intrAmount);
		int count = dao.save(customerBO);

		return count == 0 ? "customer registration failed"
				: "customer registration succesfull---->SimpleInterestAmount::" + intrAmount;
	}

}
