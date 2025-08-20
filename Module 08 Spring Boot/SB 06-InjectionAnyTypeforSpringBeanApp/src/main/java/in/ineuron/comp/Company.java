package in.ineuron.comp;

import org.springframework.stereotype.Component;

@Component(value = "company")
public class Company {
	private String title;
	private String location;
	private int size;

	public void setTitle(String title) {
		this.title = title;
		System.out.println("Company.setTitle()");
	}

	public void setLocation(String location) {
		this.location = location;
		System.out.println("Company.setLocation()");
	}

	public void setSize(int size) {
		this.size = size;
		System.out.println("Company.setSize()");
	}

	@Override
	public String toString() {
		return "Company [title=" + title + ", location=" + location + ", size=" + size + "]";
	}

}
