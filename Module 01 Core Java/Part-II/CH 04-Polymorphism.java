/*
 * POLYMORPHISM
 * ============
 * Polymorphism means "many forms" and allows objects of different types to be treated as
 * objects of a common base type. The actual method that gets called is determined at runtime.
 * 
 * Types of Polymorphism:
 * 1. Runtime Polymorphism (Dynamic Polymorphism):
 *    - Achieved through method overriding and inheritance
 *    - Method resolution happens at runtime
 *    - Uses virtual method invocation
 * 
 * 2. Compile-time Polymorphism (Static Polymorphism):
 *    - Achieved through method overloading
 *    - Method resolution happens at compile time
 *    - Same method name with different parameters
 * 
 * Key Concepts:
 * - Method Overriding: Child class provides specific implementation of parent method
 * - Method Overloading: Multiple methods with same name but different parameters
 * - Dynamic Method Dispatch: JVM determines which method to call at runtime
 * - Virtual Methods: All non-static, non-final, non-private methods in Java are virtual
 * 
 * Benefits of Polymorphism:
 * - Code flexibility and extensibility
 * - Ability to write generic code that works with multiple types
 * - Easier maintenance and updates
 * - Supports the Open/Closed Principle (open for extension, closed for modification)
 * - Enables loose coupling between components
 */

// Base class for demonstrating polymorphism
abstract class Shape {
    protected String color;
    protected boolean filled;
    
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    // Abstract methods for polymorphic behavior
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract void draw();
    
    // Concrete method
    public void displayInfo() {
        System.out.println("Shape Color: " + color);
        System.out.println("Filled: " + (filled ? "Yes" : "No"));
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Perimeter: " + String.format("%.2f", calculatePerimeter()));
    }
    
    // Method overloading examples (Compile-time polymorphism)
    public void resize(double factor) {
        System.out.println("Resizing shape by factor: " + factor);
    }
    
    public void resize(double widthFactor, double heightFactor) {
        System.out.println("Resizing shape - Width factor: " + widthFactor + ", Height factor: " + heightFactor);
    }
    
    public void resize(int percentage) {
        System.out.println("Resizing shape by " + percentage + "%");
    }
    
    // Getters and setters
    public String getColor() { return color; }
    public boolean isFilled() { return filled; }
    public void setColor(String color) { this.color = color; }
    public void setFilled(boolean filled) { this.filled = filled; }
}

// Concrete implementation 1
class Circle extends Shape {
    private double radius;
    
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle with radius " + radius);
        if (filled) {
            System.out.println("Circle is filled with " + color + " color.");
        } else {
            System.out.println("Circle is just an outline.");
        }
    }
    
    // Method overloading specific to Circle
    public void draw(boolean showCenter) {
        draw(); // Call the original draw method
        if (showCenter) {
            System.out.println("Marking the center of the circle.");
        }
    }
    
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }
}

// Concrete implementation 2
class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " rectangle with width " + width + " and height " + height);
        if (filled) {
            System.out.println("Rectangle is filled with " + color + " color.");
        } else {
            System.out.println("Rectangle is just an outline.");
        }
    }
    
    // Method overloading specific to Rectangle
    public void draw(String pattern) {
        draw();
        System.out.println("Rectangle is drawn with pattern: " + pattern);
    }
    
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }
}

// Concrete implementation 3
class Triangle extends Shape {
    private double side1, side2, side3;
    
    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    @Override
    public double calculateArea() {
        // Using Heron's formula
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " triangle with sides " + side1 + ", " + side2 + ", " + side3);
        if (filled) {
            System.out.println("Triangle is filled with " + color + " color.");
        } else {
            System.out.println("Triangle is just an outline.");
        }
    }
    
    // Method overloading examples
    public void draw(boolean showAngles) {
        draw();
        if (showAngles) {
            System.out.println("Showing triangle angles for better visualization.");
        }
    }
    
    public void draw(String style, boolean showAngles) {
        System.out.println("Drawing triangle in " + style + " style");
        draw(showAngles);
    }
}

// Utility class demonstrating method overloading (compile-time polymorphism)
class Calculator {
    
    // Method overloading - same name, different parameters
    public int add(int a, int b) {
        System.out.println("Adding two integers: " + a + " + " + b);
        return a + b;
    }
    
    public double add(double a, double b) {
        System.out.println("Adding two doubles: " + a + " + " + b);
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        System.out.println("Adding three integers: " + a + " + " + b + " + " + c);
        return a + b + c;
    }
    
    public String add(String a, String b) {
        System.out.println("Concatenating two strings: " + a + " + " + b);
        return a + b;
    }
    
    // Method with variable arguments (varargs)
    public int add(int... numbers) {
        System.out.print("Adding multiple integers: ");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            System.out.print(numbers[i] + (i < numbers.length - 1 ? " + " : ""));
        }
        System.out.println(" = " + sum);
        return sum;
    }
}

// Demonstration class for polymorphism
class PolymorphismDemo {
    
    // Method accepting Shape reference (polymorphic parameter)
    public static void processShape(Shape shape) {
        System.out.println("\n=== Processing Shape Polymorphically ===");
        shape.displayInfo();
        shape.draw();
        
        // Runtime polymorphism - actual method called depends on object type
        System.out.println("Calculated area: " + shape.calculateArea());
        System.out.println("Calculated perimeter: " + shape.calculatePerimeter());
    }
    
    // Method demonstrating polymorphic behavior with arrays
    public static void processShapeArray(Shape[] shapes) {
        System.out.println("\n=== Processing Array of Shapes ===");
        double totalArea = 0;
        
        for (Shape shape : shapes) {
            System.out.println("\nProcessing: " + shape.getClass().getSimpleName());
            shape.draw();
            double area = shape.calculateArea();
            totalArea += area;
            System.out.println("Area: " + String.format("%.2f", area));
        }
        
        System.out.println("\nTotal area of all shapes: " + String.format("%.2f", totalArea));
    }
}

public class JavaOOPComplete {
    
    public static void main(String[] args) {
        System.out.println("=== COMPLETE JAVA OOP CONCEPTS DEMONSTRATION ===\n");
        
        // =====================================
        // INHERITANCE DEMONSTRATION
        // =====================================
        System.out.println("█".repeat(50));
        System.out.println("INHERITANCE EXAMPLES");
        System.out.println("█".repeat(50));
        
        // Creating objects and demonstrating constructor chaining
        System.out.println("\n1. Constructor Chaining Demonstration:");
        Animal genericAnimal = new Animal("Generic", "Unknown Species", 5, 10.0, "Wild");
        Dog myDog = new Dog("Buddy", 3, 25.0, "Golden Retriever", true);
        Cat myCat = new Cat("Whiskers", 2, 4.5, true);
        GermanShepherd policeDog = new GermanShepherd("Rex", 4, 35.0, true, "Advanced", true);
        
        System.out.println("\n2. Method Overriding:");
        genericAnimal.makeSound();
        myDog.makeSound();
        myCat.makeSound();
        policeDog.makeSound();
        
        System.out.println("\n3. Multilevel Inheritance:");
        policeDog.eat();           // From Animal
        policeDog.wagTail();       // From Dog
        policeDog.patrol();        // From GermanShepherd
        
        // =====================================
        // ABSTRACTION DEMONSTRATION
        // =====================================
        System.out.println("\n" + "█".repeat(50));
        System.out.println("ABSTRACTION EXAMPLES");
        System.out.println("█".repeat(50));
        
        System.out.println("\n1. Abstract Class Usage:");
        // Vehicle vehicle = new Vehicle(); // Error! Cannot instantiate abstract class
        
        Car myCar = new Car("Toyota", "Camry", 2023, 25000, 4, "Automatic", 2.5);
        Motorcycle myBike = new Motorcycle("Harley Davidson", "Street 750", 2023, 15000, "Cruiser", false);
        
        System.out.println("\n--- Car Specifications ---");
        myCar.displaySpecifications();
        myCar.accelerate();
        myCar.brake();
        myCar.openTrunk();
        
        System.out.println("\n--- Motorcycle Specifications ---");
        myBike.displaySpecifications();
        myBike.accelerate();
        myBike.wheelie();
        
        System.out.println("\n2. Interface Implementation:");
        Airplane airplane = new Airplane("Emirates", "Boeing 777", 350);
        airplane.performPreFlightCheck(); // Default method
        airplane.takeOff();
        airplane.fly();
        airplane.land();
        
        System.out.println("\n3. Multiple Interface Implementation:");
        Seaplane seaplane = new Seaplane("Sea Eagle");
        seaplane.swim();        // From Swimmable
        seaplane.takeOff();     // From Flyable
        seaplane.fly();         // From Flyable
        seaplane.land();        // From Flyable
        seaplane.floatOnWater(); // Default method from Swimmable
        
        System.out.println("\n4. Electric Vehicle (Abstract Class + Interface):");
        ElectricCar tesla = new ElectricCar("Tesla", "Model S", 2023, 80000, 100, 500);
        tesla.displaySpecifications();
        tesla.displayEcoFriendlyMessage(); // Interface default method
        tesla.accelerate();
        tesla.brake();
        tesla.displayBatteryInfo();
        tesla.chargeBattery();
        
        // =====================================
        // POLYMORPHISM DEMONSTRATION
        // =====================================
        System.out.println("\n" + "█".repeat(50));
        System.out.println("POLYMORPHISM EXAMPLES");
        System.out.println("█".repeat(50));
        
        System.out.println("\n1. Runtime Polymorphism (Method Overriding):");
        
        // Creating different shapes
        Shape circle = new Circle("Red", true, 5.0);
        Shape rectangle = new Rectangle("Blue", false, 4.0, 6.0);
        Shape triangle = new Triangle("Green", true, 3.0, 4.0, 5.0);
        
        // Polymorphic method calls
        PolymorphismDemo.processShape(circle);
        PolymorphismDemo.processShape(rectangle);
        PolymorphismDemo.processShape(triangle);
        
        System.out.println("\n2. Polymorphic Arrays:");
        Shape[] shapes = {
            new Circle("Yellow", true, 3.0),
            new Rectangle("Purple", false, 2.0, 8.0),
            new Triangle("Orange", true, 6.0, 8.0, 10.0),
            new Circle("Pink", false, 7.0)
        };
        
        PolymorphismDemo.processShapeArray(shapes);
        
        System.out.println("\n3. Compile-time Polymorphism (Method Overloading):");
        Calculator calc = new Calculator();
        
        calc.add(5, 10);                    // int, int
        calc.add(3.5, 2.8);                // double, double
        calc.add(1, 2, 3);                  // three ints
        calc.add("Hello", " World");        // String concatenation
        calc.add(1, 2, 3, 4, 5);           // varargs
        
        System.out.println("\n4. Method Overloading in Shape Classes:");
        Circle myCircle = new Circle("Cyan", true, 4.0);
        myCircle.draw();                    // Basic draw
        myCircle.draw(true);               // With center
        
        Rectangle myRect = new Rectangle("Magenta", false, 3.0, 5.0);
        myRect.draw();                     // Basic draw
        myRect.draw("Striped");            // With pattern
        
        Triangle myTriangle = new Triangle("Brown", true, 5.0, 6.0, 7.0);
        myTriangle.draw();                              // Basic draw
        myTriangle.draw(true);                         // With angles
        myTriangle.draw("Dotted", false);              // With style and angles
        
        System.out.println("\n5. Polymorphism with Vehicles:");
        Vehicle[] vehicles = {myCar, myBike, tesla};
        
        System.out.println("\n--- Polymorphic Vehicle Operations ---");
        for (Vehicle vehicle : vehicles) {
            System.out.println("\nVehicle: " + vehicle.getBrand() + " " + vehicle.getModel());
            vehicle.start();
            vehicle.accelerate();  // Polymorphic call
            vehicle.brake();       // Polymorphic call
            vehicle.stop();
            System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency());
        }
        
        System.out.println("\n" + "█".repeat(50));
        System.out.println("DEMONSTRATION COMPLETED");
        System.out.println("█".repeat(50));
    }
}

/*
 * Key Points About Polymorphism:
 * 
 * 1. DEFINITION & PURPOSE:
 *    - "Many forms" - same interface, different implementations
 *    - Allows objects of different types to be treated uniformly
 *    - Method resolution happens at runtime (dynamic binding)
 * 
 * 2. TYPES OF POLYMORPHISM:
 *    - Runtime (Dynamic): Method overriding, resolved at runtime
 *    - Compile-time (Static): Method overloading, resolved at compile time
 * 
 * 3. RUNTIME POLYMORPHISM REQUIREMENTS:
 *    - Inheritance relationship must exist
 *    - Method overriding in child classes
 *    - Reference variable of parent type
 *    - Object of child type
 * 
 * 4. METHOD OVERRIDING RULES:
 *    - Same method signature (name, parameters, return type)
 *    - Cannot reduce access modifier visibility
 *    - Cannot override static, final, or private methods
 *    - Use @Override annotation for clarity
 * 
 * 5. METHOD OVERLOADING CHARACTERISTICS:
 *    - Same method name, different parameters
 *    - Can have different return types
 *    - Can have different access modifiers
 *    - Resolved at compile time based on arguments
 * 
 * 6. DYNAMIC METHOD DISPATCH:
 *    - JVM determines actual method to call at runtime
 *    - Based on actual object type, not reference type
 *    - All non-static, non-final, non-private methods are virtual
 * 
 * 7. POLYMORPHIC VARIABLES:
 *    - Reference variable can hold objects of its type or subtype
 *    - Actual method called depends on object type
 *    - Can only call methods available in reference type
 * 
 * 8. BENEFITS:
 *    - Code flexibility and extensibility
 *    - Easier maintenance and updates
 *    - Generic programming capabilities
 *    - Loose coupling between components
 *    - Supports Open/Closed Principle
 * 
 * 9. REAL-WORLD APPLICATIONS:
 *    - GUI event handling
 *    - Database connectivity (JDBC)
 *    - Collection framework
 *    - Design patterns (Strategy, Factory, Observer)
 * 
 * 10. BEST PRACTICES:
 *     - Use polymorphism to write generic, flexible code
 *     - Prefer interfaces over concrete classes for parameters
 *     - Use method overloading sparingly and meaningfully
 *     - Always use @Override annotation when overriding
 *     - Design for polymorphic usage from the beginning
 */