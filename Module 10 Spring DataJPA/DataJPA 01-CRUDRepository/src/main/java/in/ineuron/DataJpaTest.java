package in.ineuron;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineMgmtService;

@SpringBootApplication
public class DataJpaTest {

	public static void main(String[] args) {
		
	ApplicationContext factory = SpringApplication.run(DataJpaTest.class, args);
	ICoronaVaccineMgmtService service = factory.getBean(ICoronaVaccineMgmtService.class);
		
	/*
	 * 	All operations are listed below don't run all operations in single go
	 */
	
	
		/*
		 * 	Insert Single record
		 */
		CoronaVaccine vaccine = new CoronaVaccine(null, "covidshield", "serum","IND", 750.0, 2); 
		System.out.println(service.registerVacine(vaccine));
		
		
		/*
		 * Inserting records
		 */
		List<CoronaVaccine> vaccines = new ArrayList<CoronaVaccine>();
		vaccines.add(new CoronaVaccine(null, "jung", "shivu", "Uk mandi", 53.5, 1)); 
		vaccines.add(new CoronaVaccine(null, "blade", "basya", "hosayellapur", 33.8, 1)); 
		Iterable<CoronaVaccine> listVaccines = service.registerInBatch(vaccines); 
		listVaccines.forEach(vaxine1-> System.out.println(vaxine1.getRegNo()));
	
	
		/*
		 * 	Select operation based on regNo
		 */
		System.out.println("Checking for availability for the id::5 is =>  "+service.checkAvailablityByRegNo(5L));
		System.out.println("Total no of vaccine count is :: "+service.getVaccineCount());
	
		
		/*
		 * 	Fetches all records
		 */
		service.fetchAllDetails().forEach(System.out::println);
		
		
		
		/*
		 * 	Select records by id
		 */
		 List<Long> ids = new ArrayList<Long>(); 
		 ids.add(4L); 
		 ids.add(5L);
		 ids.add(6L); 
		 Iterable<CoronaVaccine> records = service.fetchAllDetailsByID(ids);
		 records.forEach( vaxine -> System.out.println(vaxine));
		 
		 
		/*
		 * 	Fetches the record based on id, if not it returns null, 
		 * 	optional is used to handle in-case of null values returned from database
		 */
		Optional<CoronaVaccine> optional = service.fecthVaccineById(5L); 
		if(optional.isPresent()) System.out.println(optional.get());
		optional.orElseThrow(() -> new IllegalArgumentException("record not found"));
			 
			 
		/*
		 * 	Another style of handling records if not available creates new object
		 * 	with null values
		 */
		System.out.println(service.fecthVaccineById(3L).orElse(new CoronaVaccine()));
		System.out.println(service.fecthVaccineById(6L).orElseGet(()->new CoronaVaccine()));
		
		 
		 
		/*
		 * 	Remove vaccine by id
		 */
		System.out.println(service.removeVaccineById(3L));

		/*
		 * 	Remove vaccine by object
		 */
		CoronaVaccine vaccine2 = new CoronaVaccine(3L, "pyzer", "pyzwer", "USA",678.8, 2); 
		System.out.println(service.removeVaccineByObject(vaccine2));
		
		
		/*
		 *  Deleting Records by id
		 */
			List<Long> list = new ArrayList<Long>();
			list.add(1L);
			list.add(2L);
			list.add(3L);
			System.out.println(service.removeVaccinesById(list));
		 
		
			
		
		((ConfigurableApplicationContext) factory).close();
	}
}
