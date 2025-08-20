package in.ineuron;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class JpaRepositorTest {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(JpaRepositorTest.class, args);
		ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);

		 /*
		  *   Searches vaccine records based on data, and properties are passed to give reference for sorting
		  */
			 CoronaVaccine vaccine2 = new CoronaVaccine(); 
			 vaccine2.setPrice(455.8);
			 service.searchVaccinesByGivenData(vaccine2, false,"price","name").forEach(System.out::println);
		 
		 
		 
		 /*
		  *  Search vaccine by id, in case of not available catch exception
		  */
			 try { CoronaVaccine vaccine = service.getVaccineById(6L);
				 	if (vaccine !=null) 
				 	{ System.out.println("vaccine details are :: " + vaccine); } 
				 	else 
				 	{ System.out.println("Record not available for the given id"); } 
				 }
				 catch(DataAccessException e) { System.out.println(e.getMessage()); }
		 

		/*
		 *  Delete multiple records based on reg_no
		 */
			List<Long> list = new ArrayList<Long>();
			list.add(6L);
			list.add(7L);
			list.add(8L);
			System.out.println(service.removeVaccinesByRegNo(list));
	
			((ConfigurableApplicationContext) factory).close();
	}
}
