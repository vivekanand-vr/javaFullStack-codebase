/*
 * Understanding Constructors in Java
 */

/*
 * A constructor is a special method that is automatically called when an object is created.
 * It's used to initialize the object's state (instance variables).
 * 
 * Key Features:
 * - Same name as the class
 * - No return type (not even void)
 * - Automatically called when object is created using 'new' keyword
 * - Can be overloaded (multiple constructors with different parameters)
 * - If no constructor is defined, Java provides a default no-argument constructor
 */

public class Constructors {
    
    // Instance variables
    private String name;
    private int age;
    private String city;
    private double salary;
    
    // 1. Default Constructor (No arguments)
    public Constructors() {
        System.out.println("Default constructor called");
        this.name = "Unknown";
        this.age = 0;
        this.city = "Not specified";
        this.salary = 0.0;
    }
    
    // 2. Parameterized Constructor with 2 parameters
    public Constructors(String name, int age) {
        System.out.println("Parameterized constructor (2 params) called");
        this.name = name;
        this.age = age;
        this.city = "Not specified";
        this.salary = 0.0;
    }
    
    // 3. Parameterized Constructor with 4 parameters
    public Constructors(String name, int age, String city, double salary) {
        System.out.println("Parameterized constructor (4 params) called");
        this.name = name;
        this.age = age;
        this.city = city;
        this.salary = salary;
    }
    
    // 4. Constructor with 'this' keyword calling another constructor
    public Constructors(String name) {
        this(name, 25); // Calls the constructor with 2 parameters
        System.out.println("Constructor with 'this' called");
    }
    
    // Method to display object information
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + 
                          ", City: " + city + ", Salary: " + salary);
    }
    
    // Getter methods
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }
    public double getSalary() { return salary; }
    
    // Setter methods
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCity(String city) { this.city = city; }
    public void setSalary(double salary) { this.salary = salary; }
    
    public static void main(String[] args) {
        System.out.println("=== Constructor Examples ===\n");
        
        // 1. Using Default Constructor
        System.out.println("1. Default Constructor:");
        Constructors person1 = new Constructors();
        person1.displayInfo();
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // 2. Using Parameterized Constructor (2 params)
        System.out.println("2. Parameterized Constructor (2 params):");
        Constructors person2 = new Constructors("Alice", 28);
        person2.displayInfo();
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // 3. Using Parameterized Constructor (4 params)
        System.out.println("3. Parameterized Constructor (4 params):");
        Constructors person3 = new Constructors("Bob", 35, "New York", 75000.50);
        person3.displayInfo();
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // 4. Using Constructor with 'this' keyword
        System.out.println("4. Constructor with 'this' keyword:");
        Constructors person4 = new Constructors("Charlie");
        person4.displayInfo();
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // 5. Modifying object after creation
        System.out.println("5. Modifying object after creation:");
        person1.setName("Modified Person");
        person1.setAge(30);
        person1.setCity("Los Angeles");
        person1.setSalary(60000.00);
        System.out.println("After modification:");
        person1.displayInfo();
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // 6. Constructor Chaining Example
        System.out.println("6. Constructor Chaining Demonstration:");
        System.out.println("Creating object with single parameter constructor...");
        Constructors person5 = new Constructors("David");
        person5.displayInfo();
        
        // 7. Array of objects using different constructors
        System.out.println("\n7. Array of Objects with Different Constructors:");
        Constructors[] people = {
            new Constructors(),
            new Constructors("Emma", 26),
            new Constructors("Frank", 40, "Chicago", 85000.00),
            new Constructors("Grace")
        };
        
        for (int i = 0; i < people.length; i++) {
            System.out.print("Person " + (i + 1) + " - ");
            people[i].displayInfo();
        }
    }
}

/*
 * Key Points about Constructors:
 * 
 * 1. Constructor Overloading:
 *    - Multiple constructors with different parameter lists
 *    - Compiler determines which constructor to call based on arguments
 * 
 * 2. 'this' keyword:
 *    - Used to refer to current object instance
 *    - this() calls another constructor in the same class
 *    - Must be the first statement in constructor
 * 
 * 3. Default Constructor:
 *    - If no constructor is defined, Java provides default no-arg constructor
 *    - If any constructor is defined, default constructor is not provided
 * 
 * 4. Constructor vs Method:
 *    - Constructor: Same name as class, no return type, called automatically
 *    - Method: Different name, has return type, called explicitly
 * 
 * 5. Best Practices:
 *    - Initialize all instance variables in constructors
 *    - Use 'this' keyword to avoid confusion between parameters and instance variables
 *    - Provide meaningful default values in default constructor
 *    - Use constructor chaining to avoid code duplication
 */