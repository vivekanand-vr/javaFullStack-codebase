package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 * Using Lombok-API for reducing the boiler plate code
 */
@Entity
@Table(name="customer")
@Data
public class Customer {
	
	/*
	 *  Customer Object definition, all inputs are mapped with this class object
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
}
