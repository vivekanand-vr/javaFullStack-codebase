/*
 * ABSTRACTION
 * ===========
 * Abstraction is the process of hiding implementation details while showing only 
 * essential features of an object. It focuses on what an object does rather than how it does it.
 * 
 * Types of Abstraction in Java:
 * 1. Abstract Classes: Classes that cannot be instantiated and may contain abstract methods
 * 2. Interfaces: Pure abstraction with all methods abstract (before Java 8)
 * 
 * Abstract Class Features:
 * - Cannot be instantiated directly
 * - Can have abstract methods (without implementation) and concrete methods (with implementation)
 * - Can have constructors, instance variables, and static methods
 * - Child classes must implement all abstract methods
 * - Use 'abstract' keyword for class and methods
 * 
 * Interface Features:
 * - Pure abstraction (traditionally)
 * - All methods are implicitly public and abstract (before Java 8)
 * - All variables are implicitly public, static, and final
 * - A class can implement multiple interfaces (multiple inheritance support)
 * - Use 'implements' keyword
 * - Since Java 8: Can have default and static methods
 * - Since Java 9: Can have private methods
 * 
 * Benefits of Abstraction:
 * - Reduces complexity by hiding implementation details
 * - Provides a clear contract for classes
 * - Enables code flexibility and maintainability
 * - Supports multiple inheritance through interfaces
 * - Encourages modular design
 */

// Abstract Class Example
abstract class Vehicle {
    // Instance variables
    protected String brand;
    protected String model;
    protected int year;
    protected double price;
    
    // Constructor - abstract classes can have constructors
    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        System.out.println("Vehicle constructor called for: " + brand + " " + model);
    }
    
    // Concrete methods - implemented in abstract class
    public void displayBasicInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
    }
    
    public void start() {
        System.out.println(brand + " " + model + " is starting...");
    }
    
    public void stop() {
        System.out.println(brand + " " + model + " has stopped.");
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract void accelerate();
    public abstract void brake();
    public abstract void displaySpecifications();
    public abstract double calculateFuelEfficiency();
    
    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
}

// Concrete class extending abstract class
class Car extends Vehicle {
    private int numberOfDoors;
    private String transmissionType;
    private double engineSize;
    
    public Car(String brand, String model, int year, double price, 
               int numberOfDoors, String transmissionType, double engineSize) {
        super(brand, model, year, price); // Call abstract class constructor
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
        this.engineSize = engineSize;
        System.out.println("Car constructor completed");
    }
    
    // Must implement all abstract methods from Vehicle
    @Override
    public void accelerate() {
        System.out.println(brand + " " + model + " is accelerating smoothly on the road.");
    }
    
    @Override
    public void brake() {
        System.out.println(brand + " " + model + " is braking with ABS system.");
    }
    
    @Override
    public void displaySpecifications() {
        displayBasicInfo(); // Call inherited method
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Transmission: " + transmissionType);
        System.out.println("Engine Size: " + engineSize + "L");
        System.out.println("Fuel Efficiency: " + calculateFuelEfficiency() + " km/l");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        // Simple calculation based on engine size
        return Math.max(5.0, 25.0 - (engineSize * 3));
    }
    
    // Car-specific methods
    public void openTrunk() {
        System.out.println(brand + " " + model + "'s trunk is opened.");
    }
    
    public void turnOnAC() {
        System.out.println(brand + " " + model + "'s air conditioning is on.");
    }
}

// Another concrete class extending abstract class
class Motorcycle extends Vehicle {
    private String bikeType;
    private boolean hasSidecar;
    
    public Motorcycle(String brand, String model, int year, double price, 
                     String bikeType, boolean hasSidecar) {
        super(brand, model, year, price);
        this.bikeType = bikeType;
        this.hasSidecar = hasSidecar;
        System.out.println("Motorcycle constructor completed");
    }
    
    @Override
    public void accelerate() {
        System.out.println(brand + " " + model + " is accelerating rapidly with engine roaring!");
    }
    
    @Override
    public void brake() {
        System.out.println(brand + " " + model + " is braking with disc brakes.");
    }
    
    @Override
    public void displaySpecifications() {
        displayBasicInfo();
        System.out.println("Bike Type: " + bikeType);
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Fuel Efficiency: " + calculateFuelEfficiency() + " km/l");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        // Motorcycles are generally more fuel efficient
        return hasSidecar ? 35.0 : 45.0;
    }
    
    // Motorcycle-specific methods
    public void wheelie() {
        if (!hasSidecar) {
            System.out.println(brand + " " + model + " is doing a wheelie!");
        } else {
            System.out.println("Cannot do wheelie with a sidecar attached.");
        }
    }
}

// Interface Examples - demonstrating pure abstraction
interface Flyable {
    // All variables in interface are implicitly public, static, and final
    double MAX_ALTITUDE = 50000.0; // Constant
    
    // Abstract methods (implicitly public and abstract)
    void takeOff();
    void land();
    void fly();
    
    // Default method (since Java 8)
    default void performPreFlightCheck() {
        System.out.println("Performing standard pre-flight safety check...");
    }
    
    // Static method (since Java 8)
    static void displayFlightRegulations() {
        System.out.println("Flight Regulations: Follow all aviation safety protocols.");
    }
}

interface Swimmable {
    void swim();
    void dive();
    
    // Default method
    default void floatOnWater() {
        System.out.println("Floating peacefully on the water surface.");
    }
}

// Interface for electric vehicles
interface ElectricVehicle {
    void chargeBattery();
    double getBatteryLevel();
    void displayBatteryInfo();
    
    // Default method for eco-friendly message
    default void displayEcoFriendlyMessage() {
        System.out.println("This is an eco-friendly electric vehicle!");
    }
}

// Class implementing single interface
class Airplane implements Flyable {
    private String airline;
    private String model;
    private int passengerCapacity;
    private double currentAltitude;
    
    public Airplane(String airline, String model, int passengerCapacity) {
        this.airline = airline;
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.currentAltitude = 0.0;
    }
    
    @Override
    public void takeOff() {
        System.out.println(airline + " " + model + " is taking off from the runway.");
        currentAltitude = 1000.0;
    }
    
    @Override
    public void land() {
        System.out.println(airline + " " + model + " is landing safely.");
        currentAltitude = 0.0;
    }
    
    @Override
    public void fly() {
        if (currentAltitude > 0) {
            System.out.println(airline + " " + model + " is flying at " + currentAltitude + " meters.");
        } else {
            System.out.println(airline + " " + model + " is not airborne. Please take off first.");
        }
    }
    
    public void boardPassengers() {
        System.out.println("Boarding " + passengerCapacity + " passengers on " + airline + " " + model);
    }
}

// Class implementing multiple interfaces
class Seaplane implements Flyable, Swimmable {
    private String name;
    private boolean isOnWater;
    private boolean isInAir;
    
    public Seaplane(String name) {
        this.name = name;
        this.isOnWater = true;
        this.isInAir = false;
    }
    
    // Implementing Flyable interface
    @Override
    public void takeOff() {
        if (isOnWater) {
            System.out.println(name + " is taking off from the water surface.");
            isOnWater = false;
            isInAir = true;
        } else {
            System.out.println(name + " is already airborne.");
        }
    }
    
    @Override
    public void land() {
        if (isInAir) {
            System.out.println(name + " is landing on the water.");
            isInAir = false;
            isOnWater = true;
        } else {
            System.out.println(name + " is already on water.");
        }
    }
    
    @Override
    public void fly() {
        if (isInAir) {
            System.out.println(name + " is flying over the ocean.");
        } else {
            System.out.println(name + " needs to take off first.");
        }
    }
    
    // Implementing Swimmable interface
    @Override
    public void swim() {
        if (isOnWater) {
            System.out.println(name + " is moving through the water like a boat.");
        } else {
            System.out.println(name + " needs to land on water first.");
        }
    }
    
    @Override
    public void dive() {
        System.out.println(name + " cannot dive underwater - it's a seaplane, not a submarine!");
    }
}

// Electric car implementing both Vehicle abstraction and ElectricVehicle interface
class ElectricCar extends Vehicle implements ElectricVehicle {
    private double batteryLevel;
    private double batteryCapacity;
    private double rangePerCharge;
    
    public ElectricCar(String brand, String model, int year, double price, 
                      double batteryCapacity, double rangePerCharge) {
        super(brand, model, year, price);
        this.batteryCapacity = batteryCapacity;
        this.rangePerCharge = rangePerCharge;
        this.batteryLevel = 100.0; // Start with full battery
        System.out.println("ElectricCar constructor completed");
    }
    
    // Implementing abstract methods from Vehicle
    @Override
    public void accelerate() {
        if (batteryLevel > 0) {
            System.out.println(brand + " " + model + " is accelerating silently with electric power.");
            batteryLevel -= 0.5; // Reduce battery slightly
        } else {
            System.out.println(brand + " " + model + " needs charging. Battery is empty!");
        }
    }
    
    @Override
    public void brake() {
        System.out.println(brand + " " + model + " is braking with regenerative braking system.");
        batteryLevel += 0.1; // Regenerative braking adds small charge
        if (batteryLevel > 100.0) batteryLevel = 100.0;
    }
    
    @Override
    public void displaySpecifications() {
        displayBasicInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Range per Charge: " + rangePerCharge + " km");
        displayBatteryInfo();
    }
    
    @Override
    public double calculateFuelEfficiency() {
        // For electric cars, return range per kWh
        return rangePerCharge / batteryCapacity;
    }
    
    // Implementing ElectricVehicle interface methods
    @Override
    public void chargeBattery() {
        System.out.println("Charging " + brand + " " + model + "...");
        batteryLevel = 100.0;
        System.out.println("Battery fully charged!");
    }
    
    @Override
    public double getBatteryLevel() {
        return batteryLevel;
    }
    
    @Override
    public void displayBatteryInfo() {
        System.out.println("Current Battery Level: " + String.format("%.1f", batteryLevel) + "%");
        double estimatedRange = (batteryLevel / 100.0) * rangePerCharge;
        System.out.println("Estimated Range: " + String.format("%.1f", estimatedRange) + " km");
    }
}

/*
 * Key Points About Abstraction:
 * 
 * 1. DEFINITION & PURPOSE:
 *    - Hides implementation details, shows only essential features
 *    - Focuses on WHAT an object does, not HOW it does it
 *    - Provides a contract for implementing classes
 * 
 * 2. ABSTRACT CLASSES:
 *    - Declared with 'abstract' keyword
 *    - Cannot be instantiated directly
 *    - Can have both abstract and concrete methods
 *    - Can have constructors, instance variables, static methods
 *    - Child classes must implement all abstract methods
 * 
 * 3. INTERFACES:
 *    - Pure abstraction (traditionally)
 *    - All methods implicitly public and abstract (before Java 8)
 *    - All variables implicitly public, static, and final
 *    - Support multiple inheritance
 *    - Use 'implements' keyword
 * 
 * 4. MODERN INTERFACE FEATURES (Java 8+):
 *    - default methods: Provide default implementation
 *    - static methods: Utility methods in interfaces
 *    - private methods (Java 9+): Helper methods for default methods
 * 
 * 5. ABSTRACT VS INTERFACE:
 *    - Abstract class: Partial abstraction, single inheritance
 *    - Interface: Complete abstraction (traditionally), multiple inheritance
 *    - Use abstract class for IS-A relationships with shared code
 *    - Use interface for CAN-DO capabilities
 * 
 * 6. WHEN TO USE ABSTRACTION:
 *    - When you want to provide a template for subclasses
 *    - When you need to enforce certain methods in subclasses
 *    - When you want to achieve loose coupling
 *    - When you need to support multiple inheritance of type
 * 
 * 7. BENEFITS:
 *    - Reduces code complexity
 *    - Provides clear contracts
 *    - Enables flexible and maintainable code
 *    - Supports multiple inheritance through interfaces
 *    - Encourages modular design
 * 
 * 8. BEST PRACTICES:
 *    - Use meaningful names for abstract classes and interfaces
 *    - Keep interfaces focused and cohesive
 *    - Prefer composition with interfaces over abstract classes
 *    - Document abstract contracts thoroughly
 *    - Use default methods judiciously in interfaces
 */