package in.ineuron.test;

import in.ineuron.dao.InsurancePolicyDao;
import in.ineuron.dao.InsurancePolicyDaoImpl;

public class InsertApp {
	public static void main(String[] args) {
		InsurancePolicyDao daoImpl = new InsurancePolicyDaoImpl();
		String result = daoImpl.transferPolicies(15);
		System.out.println(result);	
	}
}
