/*
 * INHERITANCE
 * ===========
 * Inheritance is a fundamental principle of Object-Oriented Programming (OOP) that allows
 * a new class to inherit properties and methods from an existing class.
 * 
 * Key Concepts:
 * - Parent Class (Superclass/Base Class): The class being inherited from
 * - Child Class (Subclass/Derived Class): The class that inherits from parent
 * - 'extends' keyword: Used to establish inheritance relationship
 * - 'super' keyword: Used to access parent class members
 * - Method Overriding: Child class provides specific implementation of parent method
 * 
 * Types of Inheritance in Java:
 * 1. Single Inheritance: One child class inherits from one parent class
 * 2. Multilevel Inheritance: Chain of inheritance (A -> B -> C)
 * 3. Hierarchical Inheritance: Multiple child classes inherit from same parent
 * 
 * Note: Java doesn't support multiple inheritance of classes (but supports it through interfaces)
 * 
 * Benefits:
 * - Code Reusability: Reuse existing code without rewriting
 * - Method Overriding: Customize behavior in child classes
 * - Polymorphism: Treat objects of different types uniformly
 * - Extensibility: Add new features while maintaining existing functionality
 */

// Parent Class (Superclass)
class Animal {
    // Protected fields - accessible to subclasses
    protected String name;
    protected String species;
    protected int age;
    protected double weight;
    
    // Private field - not directly accessible to subclasses
    private String habitat;
    
    // Default constructor
    public Animal() {
        this.name = "Unknown";
        this.species = "Unknown";
        this.age = 0;
        this.weight = 0.0;
        this.habitat = "Unknown";
        System.out.println("Animal default constructor called");
    }
    
    // Parameterized constructor
    public Animal(String name, String species, int age, double weight, String habitat) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.habitat = habitat;
        System.out.println("Animal parameterized constructor called for: " + name);
    }
    
    // Methods that can be inherited
    public void eat() {
        System.out.println(name + " is eating.");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
    
    public void makeSound() {
        System.out.println(name + " makes a generic animal sound.");
    }
    
    public void displayInfo() {
        System.out.println("=== Animal Information ===");
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age + " years");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Habitat: " + habitat);
    }
    
    // Method that child classes can override
    public void move() {
        System.out.println(name + " is moving.");
    }
    
    // Final method - cannot be overridden
    public final void breathe() {
        System.out.println(name + " is breathing.");
    }
    
    // Getter and setter for private field
    public String getHabitat() { return habitat; }
    public void setHabitat(String habitat) { this.habitat = habitat; }
    
    // Other getters and setters
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }
    
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setWeight(double weight) { this.weight = weight; }
}

// Child Class 1: Single Inheritance
class Dog extends Animal {
    // Additional fields specific to Dog
    private String breed;
    private boolean isVaccinated;
    
    // Default constructor
    public Dog() {
        super(); // Calls parent default constructor
        this.breed = "Mixed";
        this.isVaccinated = false;
        System.out.println("Dog default constructor called");
    }
    
    // Constructor using super()
    public Dog(String name, int age, double weight, String breed, boolean isVaccinated) {
        super(name, "Canis lupus", age, weight, "Domestic"); // Calls parent constructor
        this.breed = breed;
        this.isVaccinated = isVaccinated;
        System.out.println("Dog parameterized constructor called for: " + name);
    }
    
    // Method Overriding - providing specific implementation
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " runs on four legs.");
    }
    
    // Additional methods specific to Dog
    public void wagTail() {
        System.out.println(name + " is wagging its tail happily!");
    }
    
    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
    
    public void guard() {
        System.out.println(name + " is guarding the house!");
    }
    
    // Overriding displayInfo to include dog-specific information
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Breed: " + breed);
        System.out.println("Vaccinated: " + (isVaccinated ? "Yes" : "No"));
    }
    
    // Getters and setters for dog-specific fields
    public String getBreed() { return breed; }
    public boolean isVaccinated() { return isVaccinated; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setVaccinated(boolean vaccinated) { this.isVaccinated = vaccinated; }
}

// Child Class 2: Single Inheritance
class Cat extends Animal {
    private boolean isIndoor;
    private int livesRemaining;
    
    public Cat() {
        super();
        this.isIndoor = true;
        this.livesRemaining = 9;
        System.out.println("Cat default constructor called");
    }
    
    public Cat(String name, int age, double weight, boolean isIndoor) {
        super(name, "Felis catus", age, weight, "Domestic");
        this.isIndoor = isIndoor;
        this.livesRemaining = 9;
        System.out.println("Cat parameterized constructor called for: " + name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " gracefully walks and can climb.");
    }
    
    public void purr() {
        System.out.println(name + " is purring contentedly.");
    }
    
    public void scratch() {
        System.out.println(name + " is scratching the scratching post.");
    }
    
    public void climb() {
        System.out.println(name + " is climbing up high!");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Indoor cat: " + (isIndoor ? "Yes" : "No"));
        System.out.println("Lives remaining: " + livesRemaining);
    }
    
    public boolean isIndoor() { return isIndoor; }
    public int getLivesRemaining() { return livesRemaining; }
    public void setIndoor(boolean indoor) { this.isIndoor = indoor; }
}

// Multilevel Inheritance: GermanShepherd extends Dog extends Animal
class GermanShepherd extends Dog {
    private String trainingLevel;
    private boolean isServiceDog;
    
    public GermanShepherd() {
        super();
        this.trainingLevel = "Basic";
        this.isServiceDog = false;
        System.out.println("GermanShepherd default constructor called");
    }
    
    public GermanShepherd(String name, int age, double weight, boolean isVaccinated, 
                         String trainingLevel, boolean isServiceDog) {
        super(name, age, weight, "German Shepherd", isVaccinated);
        this.trainingLevel = trainingLevel;
        this.isServiceDog = isServiceDog;
        System.out.println("GermanShepherd parameterized constructor called for: " + name);
    }
    
    // Override makeSound with more specific implementation
    @Override
    public void makeSound() {
        System.out.println(name + " barks authoritatively: WOOF! WOOF!");
    }
    
    // Additional methods specific to German Shepherd
    public void patrol() {
        System.out.println(name + " is patrolling the area with discipline.");
    }
    
    public void performDuty() {
        if (isServiceDog) {
            System.out.println(name + " is performing service dog duties.");
        } else {
            System.out.println(name + " is ready for duty assignment.");
        }
    }
    
    public void followCommand(String command) {
        System.out.println(name + " follows the command: " + command);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); // Calls Dog's displayInfo, which calls Animal's displayInfo
        System.out.println("Training Level: " + trainingLevel);
        System.out.println("Service Dog: " + (isServiceDog ? "Yes" : "No"));
    }
    
    public String getTrainingLevel() { return trainingLevel; }
    public boolean isServiceDog() { return isServiceDog; }
    public void setTrainingLevel(String trainingLevel) { this.trainingLevel = trainingLevel; }
    public void setServiceDog(boolean serviceDog) { this.isServiceDog = serviceDog; }
}

// Another example of single inheritance
class Bird extends Animal {
    private double wingSpan;
    private boolean canFly;
    
    public Bird() {
        super();
        this.wingSpan = 0.0;
        this.canFly = true;
        System.out.println("Bird default constructor called");
    }
    
    public Bird(String name, String species, int age, double weight, String habitat, 
               double wingSpan, boolean canFly) {
        super(name, species, age, weight, habitat);
        this.wingSpan = wingSpan;
        this.canFly = canFly;
        System.out.println("Bird parameterized constructor called for: " + name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    @Override
    public void move() {
        if (canFly) {
            System.out.println(name + " is flying through the air.");
        } else {
            System.out.println(name + " is walking/running on the ground.");
        }
    }
    
    public void fly() {
        if (canFly) {
            System.out.println(name + " is soaring through the sky!");
        } else {
            System.out.println(name + " cannot fly.");
        }
    }
    
    public void buildNest() {
        System.out.println(name + " is building a nest.");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Wing Span: " + wingSpan + " meters");
        System.out.println("Can Fly: " + (canFly ? "Yes" : "No"));
    }
    
    public double getWingSpan() { return wingSpan; }
    public boolean canFly() { return canFly; }
    public void setWingSpan(double wingSpan) { this.wingSpan = wingSpan; }
    public void setCanFly(boolean canFly) { this.canFly = canFly; }
}

// Additional class to demonstrate super keyword usage
class CustomDog extends Animal {
    private String breed;
    
    public CustomDog(String name, int age, double weight, String breed, boolean isVaccinated) {
        super(name, "Canis lupus", age, weight, "Domestic");
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks loudly: BOW WOW!");
    }
    
    // Method to call parent's makeSound method using super
    public void makeAnimalSound() {
        super.makeSound(); // Calls Animal's makeSound method
    }
}

/*
 * Key Points About Inheritance: 
 * 
 * 1. DEFINITION & PURPOSE:
 *    - Allows a class to inherit properties and methods from another class
 *    - Promotes code reusability and establishes IS-A relationships
 *    - Supports hierarchical classification of objects
 * 
 * 2. KEY KEYWORDS:
 *    - extends: Establishes inheritance relationship
 *    - super: Refers to parent class members
 *    - @Override: Indicates method overriding
 *    - final: Prevents inheritance or method overriding
 * 
 * 3. TYPES OF INHERITANCE:
 *    - Single: Child inherits from one parent
 *    - Multilevel: Chain of inheritance (A->B->C)
 *    - Hierarchical: Multiple children from same parent
 *    - Multiple: Not supported for classes (use interfaces)
 * 
 * 4. CONSTRUCTOR CHAINING:
 *    - Child constructor must call parent constructor
 *    - Use super() to call parent constructor
 *    - Parent constructor executes before child constructor
 * 
 * 5. METHOD OVERRIDING RULES:
 *    - Method signature must be identical
 *    - Access modifier cannot be more restrictive
 *    - Cannot override static, final, or private methods
 *    - Return type must be same or covariant
 * 
 * 6. ACCESS MODIFIERS IN INHERITANCE:
 *    - private: Not inherited
 *    - protected: Inherited and accessible in subclasses
 *    - public: Inherited and accessible everywhere
 *    - default: Inherited within same package
 * 
 * 7. BENEFITS:
 *    - Code reusability and maintenance
 *    - Extensibility and modularity
 *    - Polymorphic behavior support
 *    - Natural modeling of real-world relationships
 * 
 * 8. BEST PRACTICES:
 *    - Use inheritance for IS-A relationships
 *    - Prefer composition over inheritance when possible
 *    - Keep inheritance hierarchies shallow
 *    - Document inheritance contracts clearly
 */