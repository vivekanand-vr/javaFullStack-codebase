package in.ineuron.dao;

import in.ineuron.bo.CustomerBO;

public interface ICustomerDAO {
	public int save(CustomerBO bo) throws Exception;
}	
