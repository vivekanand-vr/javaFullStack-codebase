package in.ineuron.comp;

public class Car {

	private String regNo;
	private String engineNo;
	private String model;
	private String company;
	private String type;
	private int engineCC;
	private String color;
	private String owner;
	private String fuelType;
	
	static{
		System.out.println("Car.class file is loading...");
	}
	
	public Car() {
		System.out.println("Car object is instantiated.....");
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setEngineCC(int engineCC) {
		this.engineCC = engineCC;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", engineNo=" + engineNo + ", model=" + model + ", company=" + company
				+ ", type=" + type + ", engineCC=" + engineCC + ", color=" + color + ", owner=" + owner + ", fuelType="
				+ fuelType + "]";
	}

}
