/*
 * Understanding the Final Keyword in Java
 */

/*
 * The 'final' keyword is used to restrict modification in Java.
 * It can be applied to variables, methods, and classes.
 * 
 * Final can be used with:
 * 1. Variables - makes them constants (cannot be reassigned)
 * 2. Methods - prevents method overriding
 * 3. Classes - prevents class inheritance
 * 4. Parameters - makes method parameters constants
 * 
 * Key Features:
 * - final variables must be initialized (either at declaration or in constructor)
 * - final methods cannot be overridden by subclasses
 * - final classes cannot be extended
 * - Improves performance and enables certain optimizations
 */

// Example of non-final class
class Vehicle {
    final String ENGINE_TYPE = "Internal Combustion"; // final variable
    private String brand;
    
    public Vehicle(String brand) {
        this.brand = brand;
    }
    
    // final method - cannot be overridden
    public final void startEngine() {
        System.out.println("Engine started for " + brand);
        System.out.println("Engine type: " + ENGINE_TYPE);
    }
    
    // Non-final method - can be overridden
    public void displayInfo() {
        System.out.println("Vehicle brand: " + brand);
    }
    
    public String getBrand() { return brand; }
}

// Class extending Vehicle
class Car extends Vehicle {
    private final int WHEELS = 4; // final variable
    private String model;
    
    public Car(String brand, String model) {
        super(brand);
        this.model = model;
        // WHEELS = 6; // This would cause compilation error
    }
    
    // Cannot override final method startEngine()
    // public void startEngine() { } // This would cause compilation error
    
    // Can override non-final method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Car model: " + model);
        System.out.println("Number of wheels: " + WHEELS);
    }
    
    public String getModel() { return model; }
}

// Example of final class - cannot be extended
final class MathUtility {
    public static final double PI = 3.14159; // final static variable
    public static final int MAX_VALUE = 100;
    
    // final method in final class
    public final double calculateArea(final double radius) { // final parameter
        // radius = 10; // This would cause compilation error
        return PI * radius * radius;
    }
    
    public final int multiply(final int a, final int b) {
        return a * b;
    }
}

// This would cause compilation error - cannot extend final class
// class ExtendedMath extends MathUtility { }

public class FinalKeyword {
    
    // 1. Final instance variables
    private final String COMPANY_NAME; // final variable - must be initialized
    private final int EMPLOYEE_ID;
    
    // 2. Final static variables (constants)
    public static final String COUNTRY = "India";
    public static final double TAX_RATE = 0.18;
    private static final int MAX_EMPLOYEES = 1000;
    
    // 3. Non-final variables
    private String employeeName;
    private double salary;
    
    // 4. Final array and collection
    private final int[] scores = {85, 90, 78, 92, 88};
    
    // Constructor to initialize final variables
    public FinalKeyword(String companyName, int employeeId, String employeeName, double salary) {
        this.COMPANY_NAME = companyName; // final variable initialization
        this.EMPLOYEE_ID = employeeId;   // final variable initialization
        this.employeeName = employeeName;
        this.salary = salary;
    }
    
    // 5. Final method - cannot be overridden
    public final void displayEmployeeId() {
        System.out.println("Employee ID: " + EMPLOYEE_ID + " (Cannot be changed)");
    }
    
    // 6. Method with final parameters
    public void updateSalary(final double increment) {
        // increment = 5000; // This would cause compilation error
        this.salary += increment;
        System.out.println("Salary updated by: " + increment);
    }
    
    // 7. Method demonstrating final array behavior
    public void modifyScores() {
        System.out.println("=== Final Array Demonstration ===");
        System.out.print("Original scores: ");
        printArray(scores);
        
        // Can modify elements of final array
        scores[0] = 95;
        scores[2] = 82;
        
        System.out.print("Modified scores: ");
        printArray(scores);
        
        // Cannot reassign final array
        // scores = new int[]{100, 100, 100}; // This would cause compilation error
    }
    
    // 8. Static final method
    public static final void displayCompanyConstants() {
        System.out.println("=== Company Constants ===");
        System.out.println("Country: " + COUNTRY);
        System.out.println("Tax Rate: " + (TAX_RATE * 100) + "%");
        System.out.println("Max Employees: " + MAX_EMPLOYEES);
    }
    
    // Regular methods
    public void displayEmployeeInfo() {
        System.out.println("=== Employee Information ===");
        System.out.println("Company: " + COMPANY_NAME);
        System.out.println("Employee ID: " + EMPLOYEE_ID);
        System.out.println("Name: " + employeeName);
        System.out.println("Salary: " + salary);
    }
    
    // Method to demonstrate final local variables
    public void demonstrateFinalLocalVariables() {
        final int localConstant = 100; // final local variable
        final String message = "This cannot be changed";
        
        System.out.println("=== Final Local Variables ===");
        System.out.println("Local constant: " + localConstant);
        System.out.println("Message: " + message);
        
        // localConstant = 200; // This would cause compilation error
        // message = "New message"; // This would cause compilation error
        
        // Final variable in loop
        for (final int i : scores) {
            // i = i + 10; // This would cause compilation error
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    // Utility method
    private void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    // Getters (no setters for final variables)
    public String getCompanyName() { return COMPANY_NAME; }
    public int getEmployeeId() { return EMPLOYEE_ID; }
    public String getEmployeeName() { return employeeName; }
    public double getSalary() { return salary; }
    
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public void setSalary(double salary) { this.salary = salary; }
    
    public static void main(String[] args) {
        System.out.println("=== Final Keyword Examples ===\n");
        
        // 1. Creating objects and demonstrating final variables
        System.out.println("1. Final Variables Demonstration:");
        FinalKeyword emp1 = new FinalKeyword("TechCorp", 1001, "Alice", 50000);
        FinalKeyword emp2 = new FinalKeyword("InnovateInc", 1002, "Bob", 60000);
        
        emp1.displayEmployeeInfo();
        System.out.println();
        emp2.displayEmployeeInfo();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 2. Demonstrating final methods
        System.out.println("2. Final Methods:");
        emp1.displayEmployeeId();
        emp2.displayEmployeeId();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 3. Final parameters demonstration
        System.out.println("3. Final Parameters:");
        emp1.updateSalary(5000);
        System.out.println("Updated salary: " + emp1.getSalary());
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 4. Final array demonstration
        System.out.println("4. Final Array:");
        emp1.modifyScores();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 5. Static final variables
        System.out.println("5. Static Final Variables:");
        FinalKeyword.displayCompanyConstants();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 6. Final local variables
        System.out.println("6. Final Local Variables:");
        emp1.demonstrateFinalLocalVariables();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 7. Vehicle and Car classes demonstration
        System.out.println("7. Final Methods in Inheritance:");
        Vehicle vehicle = new Vehicle("Generic");
        Car car = new Car("Toyota", "Camry");
        
        vehicle.displayInfo();
        vehicle.startEngine(); // final method
        
        System.out.println();
        car.displayInfo(); // overridden method
        car.startEngine(); // inherited final method
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 8. Final class demonstration
        System.out.println("8. Final Class Usage:");
        MathUtility math = new MathUtility();
        double area = math.calculateArea(5.0);
        int product = math.multiply(10, 20);
        
        System.out.println("Circle area with radius 5: " + area);
        System.out.println("Product of 10 and 20: " + product);
        System.out.println("Using PI constant: " + MathUtility.PI);
        System.out.println("Max value constant: " + MathUtility.MAX_VALUE);
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 9. Attempting to modify final variables (commented out to avoid errors)
        System.out.println("9. Final Variable Modification Restrictions:");
        System.out.println("The following operations would cause compilation errors:");
        System.out.println("- emp1.COMPANY_NAME = \"New Company\"; // Cannot modify final variable");
        System.out.println("- emp1.EMPLOYEE_ID = 2001; // Cannot modify final variable");
        System.out.println("- FinalKeyword.COUNTRY = \"USA\"; // Cannot modify final static variable");
        
        // However, we can modify non-final variables
        emp1.setEmployeeName("Alice Johnson");
        emp1.setSalary(55000);
        System.out.println("\nAfter modifying non-final variables:");
        emp1.displayEmployeeInfo();
    }
}

/*
 * Key Points about Final Keyword:
 * 
 * 1. Final Variables:
 *    - Must be initialized either at declaration or in constructor
 *    - Cannot be reassigned after initialization
 *    - For objects, reference cannot change but object state can be modified
 *    - Arrays can have elements modified but cannot be reassigned
 * 
 * 2. Final Methods:
 *    - Cannot be overridden by subclasses
 *    - Useful for methods that should not be changed in inheritance
 *    - Can be inherited but not modified
 * 
 * 3. Final Classes:
 *    - Cannot be extended (no subclasses allowed)
 *    - Examples: String, Integer, Double, etc.
 *    - All methods in final class are implicitly final
 * 
 * 4. Final Parameters:
 *    - Method parameters marked as final cannot be modified inside method
 *    - Useful for preventing accidental parameter modification
 * 
 * 5. Performance Benefits:
 *    - Compiler optimizations possible with final variables
 *    - Final methods can be inlined for better performance
 *    - Enables certain JVM optimizations
 * 
 * 6. Best Practices:
 *    - Use final for constants (with static)
 *    - Use final for variables that shouldn't be reassigned
 *    - Consider final for methods that shouldn't be overridden
 *    - Use final classes for utility classes
 * 
 * 7. Common Use Cases:
 *    - Constants: public static final
 *    - Immutable object references
 *    - Template method pattern (final methods)
 *    - Utility classes (final classes)
 */