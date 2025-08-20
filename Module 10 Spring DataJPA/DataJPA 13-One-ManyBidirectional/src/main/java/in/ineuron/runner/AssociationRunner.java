package in.ineuron.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.service.IPersonMgmtService;

@Component
public class AssociationRunner implements CommandLineRunner {
	
	/*
	 *  NOTE: Do proper configurations before running each snippet
	 *  ----
	 */
	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		  /*
		   * Save Operation --> Parent to child
		   * ----------------------------------
		   
		  Person person = new Person("vicky", "mysore");
		  
		  PhoneNumber p1 = new PhoneNumber(7738339993L, "airtel", "office");
		  PhoneNumber p2 = new PhoneNumber(8837383738L, "jio", "residence");
		  
		  Set<PhoneNumber> phoneSet = Set.of(p1, p2);
		  person.setContactDetails(phoneSet);
	
		  System.out.println(service.savePerson(person));
		  
		  */
		
			System.out.println();
		
		  /*
		   *  Save Operation --> child to parent 
			  ----------------------------------
		  PhoneNumber p3 = new PhoneNumber(7738339993L, "airtel", "office");
		  PhoneNumber p4 = new PhoneNumber(8837383738L, "jio", "residence");
		  
		  Person person = new Person("nitin", "RCB");
		  p3.setPerson(person);
		  p4.setPerson(person);
		  
		  Set<PhoneNumber> phoneSet = Set.of(p3, p4);
		  person.setContactDetails(phoneSet);
		  
		  //check database because this only saves numbers 
		  System.out.println(service.savePhoneNumbers(phoneSet));
		  
		  */
		
			System.out.println();
			
		  /*
		   * load operation from parent to child [One to Many] 
		     -------------------------------------------------
		   service.fetchByPerson().forEach(person -> { 
			  System.out.println("Parent :: " + person);
			  Set<PhoneNumber> childs = person.getContactDetails();
			  childs.forEach(contact -> {
				 System.out.println("child :: " + contact); 
			  });
		   });
		   
		   */
		   
		   System.out.println();
		
		   /*
			* load operation from child to parent [Many to One] 
			  -------------------------------------------------
			service.fetchByPhoneNumber().forEach(phone -> { 
				System.out.println("Child :: " + phone);
				Person person = phone.getPerson();
				System.out.println(person);
				
			});
			*/
		   
		   System.out.println();
		   
		   /*
		    *  Delete by person id
		    *  ---------------------
		    *  System.out.println(service.deleteByPerson(1));
		    */
		   
		   System.out.println();
		   
		   /*
		    *  Delete by person's phone numbers 
		    *  --------------------------------
		    *  System.out.println(service.deleteAllPhoneNumbersOfPerson(1));
		    */
		   
	}                         

}
