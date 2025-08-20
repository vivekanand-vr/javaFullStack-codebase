package in.ineuron.comp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "emp.info")
public class Employee {
	private String name;
	private long id;
	private String[] skills;
	private List<String> teamMembers;
	private Set<Long> phoneNumbers;
	private Map<String, Object> idDetails;
	private Company company;

	public void setCompany(Company company) {
		this.company = company;
		System.out.println("Employee.setCompany()");
	}

	public void setIdDetails(Map<String, Object> idDetails) {
		this.idDetails = idDetails;
		System.out.println("Employee.setIdDetails()");
	}

	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
		System.out.println("Employee.setPhoneNumbers()");
	}

	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
		System.out.println("Employee.setTeamMembers()");
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Employee.setName()");
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
		System.out.println("Employee.setSkills()");
	}

	public void setId(long id) {
		this.id = id;
		System.out.println("Employee.setId()");
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", skills=" + Arrays.toString(skills) + ", teamMembers="
				+ teamMembers + ", phoneNumbers=" + phoneNumbers + ", idDetails=" + idDetails + ", company=" + company
				+ "]";
	}

}
