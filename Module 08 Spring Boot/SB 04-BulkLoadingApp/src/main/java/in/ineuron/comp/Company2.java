package in.ineuron.comp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my.info")
public class Company2 {
	
	/*
	 * 	Trying to inject two different values with both approaches @Value and 
	 * 	@ConfigurationProperties, the configuration properties will perform setter injection
	 * 	and it will override @Value
	 */
	
	
	@Value("${user.info.name}")
	private String name;
	
	@Value("${user.info.location}")
	private String location;
	
	@Value("${user.info.size}")
	private Integer size;

	static {
		System.out.println("Company2.class file is loading...");
	}

	public Company2() {
		System.out.println("Company2:: Zero param constructor...");
	}

	public void setName(String name) {
		System.out.println("Company2.setName()");
		this.name = name;
	}

	public void setLocation(String location) {
		System.out.println("Company2.setLocation()");
		this.location = location;
	}

	public void setSize(Integer size) {
		System.out.println("Company2.setSize()");
		this.size = size;
	}

	@Override
	public String toString() {
		return "Company2 [name=" + name + ", location=" + location + ", size=" + size + "]";
	}

}
