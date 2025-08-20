package in.ineuron.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Person;
import in.ineuron.model.PhoneNumber;
import in.ineuron.repo.IPersonRepo;
import in.ineuron.repo.IPhoneNumberRepository;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private IPersonRepo personRepo;

	@Autowired
	private IPhoneNumberRepository phoneRepo;

	@Override
	public String savePerson(Person person) {
		Integer idValue = personRepo.save(person).getPid();
		return "Person and his phoneNumber are saved with id value :: " + idValue;
	}

	@Override
	public String savePhoneNumbers(Iterable<PhoneNumber> numbers) {

		for (PhoneNumber phoneNumber : numbers) {
			phoneRepo.save(phoneNumber);
		}
		return ((Set<PhoneNumber>) numbers).size()+"no of phoneNumbers are saved";
	}
	
	@Override
	public Iterable<Person> fetchByPerson(){
		return personRepo.findAll();
	}
	
	@Override
	public Iterable<PhoneNumber> fetchByPhoneNumber(){
		return phoneRepo.findAll();
	}
	
	@Override
	public String deleteByPerson(int personId) {
		java.util.Optional<Person> optional = personRepo.findById(personId);
		if(optional.isPresent()) {
			personRepo.delete(optional.get());
			return "Person and his phone number is deleted";
		}
		return "Person not found";
	}
	
	@Override
	public String deleteAllPhoneNumbersOfPerson(int personId) {
		java.util.Optional<Person> optional =  personRepo.findById(personId);
		if(optional.isPresent()) {
			Set<PhoneNumber> childs = optional.get().getContactDetails();
			
			/* delete all childs */
			childs.forEach(child -> {
				child.setPerson(null);
			});
			
			phoneRepo.deleteAll(childs);
			return childs.size() + " Person's phone numbers deleted";
		}
		
		return "Person not found";
	}
}
