package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DataJpaTestApp {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DataJpaTestApp.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);
		
		/*
		 * 	Fetches details by ascending order if first parameter is "true, and sending the parameters 
		 * 	according to which it should be sorted
		 */
		 service.fetchDetails(false, "price", "name").forEach((vaccine) ->
		 System.out.println(vaccine.getPrice() + " == " + vaccine.getCountry()));
		 
		 
		 /*
		  *   Fetches details by page number and page size
		  *   when you say page size the number of records are divided by page size and 
		  *   and you get records accordingly when specifying page no.
		  */
		 service.fetchDetailsByPageNo(1, 3, true, "price", "name") .forEach((vaccine) -> 
		 System.out.println(vaccine.getName()+" "+vaccine.getPrice() + " " + vaccine.getCountry()));
		 
		/*
		 *  Fetches details by pagination
		 */
		 service.fetchDetailsByPagination(3);
		
		
		((ConfigurableApplicationContext) factory).close();
	}
}
