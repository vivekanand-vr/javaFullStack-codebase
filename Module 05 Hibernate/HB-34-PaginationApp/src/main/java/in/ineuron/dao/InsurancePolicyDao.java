package in.ineuron.dao;

import java.util.List;

import in.ineuron.model.InsurancePolicy;

public interface InsurancePolicyDao {
	public List<InsurancePolicy> getPageData(int pageSize,int startPos);
	public Long getTotalRecordsCount();
}
