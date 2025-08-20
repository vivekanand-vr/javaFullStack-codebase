/*
 * Understanding Method Overriding in Java
 */

/*
 * Method Overriding is a feature that allows a subclass to provide a specific
 * implementation of a method that is already defined in its parent class.
 * 
 * Key Concepts:
 * - Runtime Polymorphism: Method to be executed is determined at runtime
 * - Dynamic Method Dispatch: JVM calls overridden method based on object type
 * - IS-A Relationship: Inheritance must exist between classes
 * 
 * Rules for Method Overriding:
 * 1. Method name, return type, and parameters must be exactly the same
 * 2. Access modifier cannot be more restrictive than parent class
 * 3. Cannot override static, final, or private methods
 * 4. Cannot override constructors
 * 5. Exception handling: Cannot throw broader exceptions than parent method
 * 
 * Annotations:
 * - @Override: Ensures compile-time checking for proper overriding
 * 
 * Difference from Method Overloading:
 * - Overloading: Same class, different parameters (compile-time)
 * - Overriding: Parent-child classes, same signature (runtime)
 */

// Parent class (Super class)
class Animal {
    protected String name;
    protected String species;
    
    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }
    
    // Method to be overridden
    public void makeSound() {
        System.out.println(name + " makes a generic animal sound");
    }
    
    // Method to be overridden
    public void move() {
        System.out.println(name + " moves in some way");
    }
    
    // Method to be overridden with return type
    public String getDescription() {
        return name + " is a " + species;
    }
    
    // Method that demonstrates access modifier rules
    protected void sleep() {
        System.out.println(name + " is sleeping");
    }
    
    // Final method - cannot be overridden
    public final void breathe() {
        System.out.println(name + " is breathing");
    }
    
    // Static method - cannot be overridden (but can be hidden)
    public static void staticMethod() {
        System.out.println("Static method from Animal class");
    }
    
    // Method with exception
    public void eat() throws Exception {
        System.out.println(name + " is eating");
    }
}

// Child class 1
class Dog extends Animal {
    private String breed;
    
    public Dog(String name, String breed) {
        super(name, "Canine");
        this.breed = breed;
    }
    
    // Overriding makeSound method
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    // Overriding move method
    @Override
    public void move() {
        System.out.println(name + " runs on four legs");
    }
    
    // Overriding getDescription method
    @Override
    public String getDescription() {
        return name + " is a " + breed + " dog";
    }
    
    // Overriding sleep method with same access level
    @Override
    protected void sleep() {
        System.out.println(name + " sleeps in a dog bed");
    }
    
    // Method hiding (not overriding) for static method
    public static void staticMethod() {
        System.out.println("Static method from Dog class");
    }
    
    // Overriding eat method with same or more specific exception
    @Override
    public void eat() throws Exception {
        System.out.println(name + " eats dog food");
    }
    
    // Dog-specific method
    public void fetch() {
        System.out.println(name + " fetches the ball");
    }
}

// Child class 2
class Cat extends Animal {
    private boolean isIndoor;
    
    public Cat(String name, boolean isIndoor) {
        super(name, "Feline");
        this.isIndoor = isIndoor;
    }
    
    // Overriding makeSound method
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
    
    // Overriding move method
    @Override
    public void move() {
        System.out.println(name + " gracefully walks and can climb");
    }
    
    // Overriding getDescription method
    @Override
    public String getDescription() {
        return name + " is an " + (isIndoor ? "indoor" : "outdoor") + " cat";
    }
    
    // Overriding sleep method with wider access (protected to public is allowed)
    @Override
    public void sleep() {
        System.out.println(name + " sleeps 16 hours a day");
    }
    
    // Cat-specific method
    public void purr() {
        System.out.println(name + " purrs contentedly");
    }
}

// Child class 3
class Bird extends Animal {
    private boolean canFly;
    
    public Bird(String name, boolean canFly) {
        super(name, "Avian");
        this.canFly = canFly;
    }
    
    // Overriding makeSound method
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    // Overriding move method
    @Override
    public void move() {
        if (canFly) {
            System.out.println(name + " flies through the air");
        } else {
            System.out.println(name + " hops and walks");
        }
    }
    
    // Overriding getDescription method
    @Override
    public String getDescription() {
        return name + " is a " + (canFly ? "flying" : "flightless") + " bird";
    }
    
    // Bird-specific method
    public void buildNest() {
        System.out.println(name + " builds a nest");
    }
}

// Abstract class demonstrating abstract method overriding
abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Abstract method - must be overridden
    public abstract double calculateArea();
    
    // Abstract method - must be overridden
    public abstract double calculatePerimeter();
    
    // Concrete method that can be overridden
    public void displayInfo() {
        System.out.println("This is a " + color + " shape");
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    // Must override abstract method
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    // Must override abstract method
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    // Overriding concrete method
    @Override
    public void displayInfo() {
        System.out.println("This is a " + color + " circle with radius " + radius);
    }
}

class Rectangle extends Shape {
    private double length, width;
    
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    // Must override abstract method
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    // Must override abstract method
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    // Overriding concrete method
    @Override
    public void displayInfo() {
        System.out.println("This is a " + color + " rectangle " + length + "x" + width);
    }
}

public class MethodOverriding {
    
    public static void main(String[] args) {
        System.out.println("=== Method Overriding Examples ===\n");
        
        // 1. Basic Method Overriding
        System.out.println("1. Basic Method Overriding:");
        demonstrateBasicOverriding();
        
        // 2. Runtime Polymorphism
        System.out.println("\n2. Runtime Polymorphism:");
        demonstrateRuntimePolymorphism();
        
        // 3. Method Overriding vs Method Hiding
        System.out.println("\n3. Method Overriding vs Method Hiding:");
        demonstrateMethodHiding();
        
        // 4. Abstract Method Overriding
        System.out.println("\n4. Abstract Method Overriding:");
        demonstrateAbstractMethodOverriding();
        
        // 5. Super Keyword Usage
        System.out.println("\n5. Super Keyword Usage:");
        demonstrateSuperKeyword();
        
        // 6. Access Modifier Rules
        System.out.println("\n6. Access Modifier Rules:");
        demonstrateAccessModifierRules();
        
        // 7. Exception Handling in Overriding
        System.out.println("\n7. Exception Handling in Overriding:");
        demonstrateExceptionHandling();
        
        // 8. Practical Example - Template Method Pattern
        System.out.println("\n8. Template Method Pattern:");
        demonstrateTemplateMethodPattern();
    }
    
    // 1. Basic Method Overriding
    public static void demonstrateBasicOverriding() {
        Dog dog = new Dog("Buddy", "Golden Retriever");
        Cat cat = new Cat("Whiskers", true);
        Bird bird = new Bird("Tweety", true);
        
        // Each animal makes its own sound
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
        
        System.out.println();
        
        // Each animal moves differently
        dog.move();
        cat.move();
        bird.move();
        
        System.out.println();
        
        // Each animal has its own description
        System.out.println(dog.getDescription());
        System.out.println(cat.getDescription());
        System.out.println(bird.getDescription());
    }
    
    // 2. Runtime Polymorphism
    public static void demonstrateRuntimePolymorphism() {
        // Array of Animal references pointing to different objects
        Animal[] animals = {
            new Dog("Max", "Labrador"),
            new Cat("Luna", false),
            new Bird("Robin", true),
            new Dog("Rex", "German Shepherd")
        };
        
        System.out.println("Demonstrating runtime polymorphism:");
        for (Animal animal : animals) {
            // Method called depends on actual object type, not reference type
            animal.makeSound();
            animal.move();
            System.out.println(animal.getDescription());
            System.out.println("---");
        }
    }
    
    // 3. Method Overriding vs Method Hiding (Static methods)
    public static void demonstrateMethodHiding() {
        Animal animal = new Dog("Spot", "Beagle");
        Dog dog = new Dog("Rover", "Bulldog");
        
        System.out.println("Method Overriding (instance methods):");
        animal.makeSound(); // Calls Dog's overridden method
        
        System.out.println("\nMethod Hiding (static methods):");
        Animal.staticMethod(); // Calls Animal's static method
        Dog.staticMethod();    // Calls Dog's static method
        
        // Reference type determines which static method is called
        animal.staticMethod(); // Still calls Animal's static method!
    }
    
    // 4. Abstract Method Overriding
    public static void demonstrateAbstractMethodOverriding() {
        Shape[] shapes = {
            new Circle("Red", 5.0),
            new Rectangle("Blue", 4.0, 6.0),
            new Circle("Green", 3.0)
        };
        
        for (Shape shape : shapes) {
            shape.displayInfo();
            System.out.printf("Area: %.2f%n", shape.calculateArea());
            System.out.printf("Perimeter: %.2f%n", shape.calculatePerimeter());
            System.out.println("---");
        }
    }
    
    // 5. Super Keyword Usage
    public static void demonstrateSuperKeyword() {
        // Creating an enhanced dog class
        class EnhancedDog extends Dog {
            public EnhancedDog(String name, String breed) {
                super(name, breed);
            }
            
            @Override
            public void makeSound() {
                // Call parent method first
                super.makeSound();
                System.out.println(name + " also whimpers when excited");
            }
            
            @Override
            public String getDescription() {
                // Enhance parent's description
                return super.getDescription() + " and is very friendly";
            }
        }
        
        EnhancedDog enhancedDog = new EnhancedDog("Charlie", "Poodle");
        enhancedDog.makeSound();
        System.out.println(enhancedDog.getDescription());
    }
    
    // 6. Access Modifier Rules
    public static void demonstrateAccessModifierRules() {
        Dog dog = new Dog("Buddy", "Retriever");
        Cat cat = new Cat("Mittens", true);
        
        // Protected method overridden with protected access
        // dog.sleep(); // Would need to be in same package or subclass
        
        // Protected method overridden with public access (allowed - widening)
        cat.sleep(); // Now public, so accessible
        
        // Final method cannot be overridden
        dog.breathe(); // Same implementation as parent
        cat.breathe(); // Same implementation as parent
    }
    
    // 7. Exception Handling in Overriding
    public static void demonstrateExceptionHandling() {
        Animal animal = new Dog("Exception Demo", "Test Breed");
        
        try {
            animal.eat(); // Can throw Exception
        } catch (Exception e) {
            System.out.println("Handled exception: " + e.getMessage());
        }
        
        // Demonstrating exception rule compliance
        System.out.println("Exception handling rules followed in overriding");
    }
    
    // 8. Template Method Pattern
    public static void demonstrateTemplateMethodPattern() {
        // Template method pattern using method overriding
        abstract class GameTemplate {
            // Template method - defines the algorithm structure
            public final void playGame() {
                initialize();
                startPlay();
                endPlay();
            }
            
            protected abstract void initialize();
            protected abstract void startPlay();
            protected abstract void endPlay();
        }
        
        class Cricket extends GameTemplate {
            @Override
            protected void initialize() {
                System.out.println("Cricket Game Initialized! Start playing.");
            }
            
            @Override
            protected void startPlay() {
                System.out.println("Cricket Game Started. Enjoy the game!");
            }
            
            @Override
            protected void endPlay() {
                System.out.println("Cricket Game Finished!");
            }
        }
        
        class Football extends GameTemplate {
            @Override
            protected void initialize() {
                System.out.println("Football Game Initialized! Start playing.");
            }
            
            @Override
            protected void startPlay() {
                System.out.println("Football Game Started. Enjoy the game!");
            }
            
            @Override
            protected void endPlay() {
                System.out.println("Football Game Finished!");
            }
        }
        
        System.out.println("Template Method Pattern:");
        GameTemplate cricket = new Cricket();
        cricket.playGame();
        
        System.out.println();
        
        GameTemplate football = new Football();
        football.playGame();
    }
}

/*
 * Key Points about Method Overriding in Java:
 * 
 * 1. BASIC REQUIREMENTS:
 *    - Must have IS-A relationship (inheritance)
 *    - Method signature must be identical (name, parameters, return type)
 *    - Use @Override annotation for compile-time verification
 *    - Provides runtime polymorphism (dynamic method dispatch)
 * 
 * 2. ACCESS MODIFIER RULES:
 *    - Cannot make overridden method more restrictive
 *    - Can make it less restrictive (widening is allowed)
 *    - private -> protected/public ❌ (private methods can't be overridden)
 *    - protected -> public ✅
 *    - public -> protected/private ❌
 * 
 * 3. METHODS THAT CANNOT BE OVERRIDDEN:
 *    - Static methods (can be hidden, not overridden)
 *    - Final methods (marked as final)
 *    - Private methods (not inherited)
 *    - Constructor methods (not inherited)
 * 
 * 4. RETURN TYPE RULES:
 *    - Must be the same type or covariant (subtype)
 *    - Primitive types must be exactly the same
 *    - Object types can be more specific (covariant return types)
 * 
 * 5. EXCEPTION HANDLING RULES:
 *    - Can throw same exceptions as parent method
 *    - Can throw more specific (subclass) exceptions
 *    - Cannot throw broader (superclass) exceptions
 *    - Can choose not to throw any exceptions
 * 
 * 6. RUNTIME POLYMORPHISM:
 *    - JVM determines which method to call at runtime
 *    - Based on actual object type, not reference type
 *    - Enables "one interface, multiple implementations"
 *    - Foundation for many design patterns
 * 
 * 7. SUPER KEYWORD USAGE:
 *    - super.methodName() calls parent class method
 *    - Useful for extending rather than completely replacing functionality
 *    - Can be used in constructors with super()
 *    - Must be first statement in constructor if used
 * 
 * 8. METHOD OVERRIDING VS OVERLOADING:
 *    Overriding:
 *    - Same signature, different classes (parent-child)
 *    - Runtime polymorphism
 *    - IS-A relationship required
 *    
 *    Overloading:
 *    - Same name, different parameters, same class
 *    - Compile-time polymorphism
 *    - No inheritance required
 * 
 * 9. ABSTRACT METHODS:
 *    - Must be overridden in concrete subclasses
 *    - Cannot have implementation in abstract class
 *    - Forces subclasses to provide specific implementation
 *    - Used for enforcing contracts
 * 
 * 10. BEST PRACTICES:
 *     - Always use @Override annotation
 *     - Call super.method() when extending functionality
 *     - Keep overridden methods focused and cohesive
 *     - Document behavior changes in overridden methods
 *     - Follow Liskov Substitution Principle
 *     - Use meaningful method names and maintain contracts
 * 
 * To compile and run:
 * javac MethodOverriding.java
 * java MethodOverriding
 */