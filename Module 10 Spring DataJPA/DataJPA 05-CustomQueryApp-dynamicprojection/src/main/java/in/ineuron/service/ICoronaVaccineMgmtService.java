package in.ineuron.service;

import java.util.List;

import in.ineuron.type.View;

public interface ICoronaVaccineMgmtService {	
	public <T extends View> List<T> searchVaccineByCompany(String company,Class<T> clazz);	
}
