package in.ineuron;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class CusotmQueryApp {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(CusotmQueryApp.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);
		
		/*
		 * 	Select based on company name and based on a particular price condition
		 */
		 service.fetchVaccineByCompany("serum").forEach(System.out::println);
		 service.fetchVaccineByPricesLessThan(450.5).forEach(System.out::println);

		/*
		 * 	Fetch countries provided through list and filter vaccines within price range
		 */
		List<String> countries = new ArrayList<String>();
		countries.add("USA");
		countries.add("Russia");
		service.searchVaccineByCountriesAndPriceRange(countries, 200.0,500.0).forEach(System.out::println);

		/*
		 *  Fetch vaccines that are not in the country list
		 */
		service.fetchVaccineNotByCountry(countries).forEach(System.out::println);;
		
		
		((ConfigurableApplicationContext) factory).close();
	}
}
