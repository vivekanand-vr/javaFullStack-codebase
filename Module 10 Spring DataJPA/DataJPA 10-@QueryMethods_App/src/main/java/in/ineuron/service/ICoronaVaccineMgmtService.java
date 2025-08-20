package in.ineuron.service;

import java.util.Date;
import java.util.List;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	public List<CoronaVaccine> fetchVaccinesByCompany(String company);
	public List<CoronaVaccine> fetchVaccinesByCompanies(String comp1,String comp2);
	public List<String> fetchVaccinesByPriceRange(double min,double max);
	public List<Object[]> fetchVaccinesByName(String name1,String name2);
	public int modifyingPriceByCountry(double newPrice,String country);
	public int removeVacinesByPrice(double startPrice,double endPrice);
	public int registerVaccine(String company,String country,String name,Double price,Integer required_dose_count);
	public Date fetchSystemDate();
}
