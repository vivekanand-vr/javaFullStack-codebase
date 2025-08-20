/*
 * Understanding Method Overloading in Java
 */

/*
 * Method Overloading (Compile-time Polymorphism):
 * Method overloading allows multiple methods with the same name but different parameters
 * in the same class. The compiler determines which method to call based on the method signature.
 * 
 * Rules for Method Overloading:
 * 1. Methods must have the same name
 * 2. Methods must have different parameter lists (number, type, or order of parameters)
 * 3. Return type alone is NOT sufficient for overloading
 * 4. Access modifiers can be different
 * 
 * Method Signature = Method Name + Parameter List (not including return type)
 * 
 * Benefits:
 * 1. Code reusability and readability
 * 2. Same functionality with different inputs
 * 3. API flexibility for users
 */

public class MethodOverloading {
    
    // 1. Overloading by Number of Parameters
    
    // Method with no parameters
    public void display() {
        System.out.println("Display method with no parameters");
    }
    
    // Method with one parameter
    public void display(String message) {
        System.out.println("Display method with String: " + message);
    }
    
    // Method with two parameters
    public void display(String message, int count) {
        System.out.println("Display method with String and int:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + message);
        }
    }
    
    // Method with three parameters
    public void display(String message, int count, boolean numbered) {
        System.out.println("Display method with String, int, and boolean:");
        for (int i = 0; i < count; i++) {
            if (numbered) {
                System.out.println((i + 1) + ". " + message);
            } else {
                System.out.println("- " + message);
            }
        }
    }
    
    // 2. Overloading by Parameter Types
    
    // Method with int parameter
    public int add(int a, int b) {
        System.out.println("Adding two integers: " + a + " + " + b);
        return a + b;
    }
    
    // Method with double parameters
    public double add(double a, double b) {
        System.out.println("Adding two doubles: " + a + " + " + b);
        return a + b;
    }
    
    // Method with float parameters
    public float add(float a, float b) {
        System.out.println("Adding two floats: " + a + " + " + b);
        return a + b;
    }
    
    // Method with String parameters (concatenation)
    public String add(String a, String b) {
        System.out.println("Concatenating two strings: " + a + " + " + b);
        return a + b;
    }
    
    // 3. Overloading by Parameter Order
    
    // Method with int then String
    public void process(int number, String text) {
        System.out.println("Processing int first: " + number + ", then String: " + text);
    }
    
    // Method with String then int
    public void process(String text, int number) {
        System.out.println("Processing String first: " + text + ", then int: " + number);
    }
    
    // Method with double then boolean
    public void process(double value, boolean flag) {
        System.out.println("Processing double: " + value + ", boolean: " + flag);
    }
    
    // Method with boolean then double
    public void process(boolean flag, double value) {
        System.out.println("Processing boolean: " + flag + ", double: " + value);
    }
    
    // 4. Overloading with Arrays
    
    // Method with int array
    public void printArray(int[] array) {
        System.out.print("Integer array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // Method with String array
    public void printArray(String[] array) {
        System.out.print("String array: ");
        for (String str : array) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
    
    // Method with double array
    public void printArray(double[] array) {
        System.out.print("Double array: ");
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // 5. Overloading with Variable Arguments (Varargs)
    
    // Method with int varargs
    public int sum(int... numbers) {
        System.out.print("Sum of integers using varargs: ");
        int total = 0;
        for (int num : numbers) {
            total += num;
            System.out.print(num + " ");
        }
        System.out.println("= " + total);
        return total;
    }
    
    // Method with double varargs
    public double sum(double... numbers) {
        System.out.print("Sum of doubles using varargs: ");
        double total = 0.0;
        for (double num : numbers) {
            total += num;
            System.out.print(num + " ");
        }
        System.out.println("= " + total);
        return total;
    }
    
    // 6. Constructor Overloading
    
    private String name;
    private int age;
    private String email;
    
    // Default constructor
    public MethodOverloading() {
        this.name = "Unknown";
        this.age = 0;
        this.email = "not provided";
        System.out.println("Default constructor called");
    }
    
    // Constructor with name only
    public MethodOverloading(String name) {
        this.name = name;
        this.age = 0;
        this.email = "not provided";
        System.out.println("Constructor with name called: " + name);
    }
    
    // Constructor with name and age
    public MethodOverloading(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "not provided";
        System.out.println("Constructor with name and age called: " + name + ", " + age);
    }
    
    // Constructor with all parameters
    public MethodOverloading(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        System.out.println("Constructor with all parameters called: " + name + ", " + age + ", " + email);
    }
    
    // Method to display object information
    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Email: " + email);
    }
    
    // 7. Static Method Overloading
    
    // Static method with int
    public static void calculate(int value) {
        System.out.println("Static calculate with int: " + value * value);
    }
    
    // Static method with double
    public static void calculate(double value) {
        System.out.println("Static calculate with double: " + value * value);
    }
    
    // Static method with two parameters
    public static void calculate(int a, int b) {
        System.out.println("Static calculate with two ints: " + (a * b));
    }
    
    // Main method to demonstrate all overloading examples
    public static void main(String[] args) {
        
        // Create object using default constructor
        MethodOverloading demo = new MethodOverloading();
        
        System.out.println("=== Method Overloading Demonstrations ===\n");
        
        // 1. Overloading by Number of Parameters
        System.out.println("1. Overloading by Number of Parameters:");
        demo.display();
        demo.display("Hello World");
        demo.display("Java Programming", 3);
        demo.display("Learning", 2, false);
        
        // 2. Overloading by Parameter Types
        System.out.println("\n2. Overloading by Parameter Types:");
        System.out.println("Result: " + demo.add(5, 10));
        System.out.println("Result: " + demo.add(3.5, 2.7));
        System.out.println("Result: " + demo.add(1.5f, 2.3f));
        System.out.println("Result: " + demo.add("Hello", "World"));
        
        // 3. Overloading by Parameter Order
        System.out.println("\n3. Overloading by Parameter Order:");
        demo.process(100, "Processing");
        demo.process("Data", 200);
        demo.process(3.14, true);
        demo.process(false, 2.718);
        
        // 4. Overloading with Arrays
        System.out.println("\n4. Overloading with Arrays:");
        int[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Java", "Python", "C++"};
        double[] doubleArray = {1.1, 2.2, 3.3};
        
        demo.printArray(intArray);
        demo.printArray(stringArray);
        demo.printArray(doubleArray);
        
        // 5. Overloading with Variable Arguments
        System.out.println("\n5. Overloading with Variable Arguments:");
        demo.sum(1, 2, 3);
        demo.sum(1, 2, 3, 4, 5);
        demo.sum(1.5, 2.5, 3.5);
        demo.sum(1.1, 2.2, 3.3, 4.4);
        
        // 6. Constructor Overloading
        System.out.println("\n6. Constructor Overloading:");
        MethodOverloading person1 = new MethodOverloading("Alice");
        MethodOverloading person2 = new MethodOverloading("Bob", 25);
        MethodOverloading person3 = new MethodOverloading("Charlie", 30, "charlie@email.com");
        
        person1.showInfo();
        person2.showInfo();
        person3.showInfo();
        
        // 7. Static Method Overloading
        System.out.println("\n7. Static Method Overloading:");
        MethodOverloading.calculate(5);
        MethodOverloading.calculate(3.14);
        MethodOverloading.calculate(4, 7);
        
        // 8. Method Resolution Examples
        System.out.println("\n8. Method Resolution Examples:");
        
        // Exact match
        demo.add(5, 10);           // Calls add(int, int)
        demo.add(5.0, 10.0);       // Calls add(double, double)
        
        // Automatic promotion
        demo.add(5, 10.0);         // int promoted to double, calls add(double, double)
        
        // Widening conversion
        byte b1 = 5, b2 = 10;
        demo.add(b1, b2);          // byte promoted to int, calls add(int, int)
        
        System.out.println("\n=== End of Method Overloading Demo ===");
    }
}

/*
 * Method Resolution Priority (when multiple methods match):
 * 1. Exact match
 * 2. Primitive widening conversion (byte->short->int->long->float->double)
 * 3. Autoboxing/Unboxing (int <-> Integer)
 * 4. Varargs
 * 
 * Key Points:
 * 1. Overloading is resolved at compile time (static binding)
 * 2. Return type is not considered for overloading
 * 3. Access modifiers can be different in overloaded methods
 * 4. Exceptions thrown can be different
 * 5. Static and non-static methods can be overloaded
 * 
 * Common Mistakes:
 * 1. Trying to overload based on return type only
 * 2. Creating ambiguous method calls
 * 3. Forgetting about automatic type promotion
 * 4. Confusion between overloading and overriding
 * 
 * Benefits:
 * 1. Improved code readability
 * 2. Flexibility for method users
 * 3. Logical grouping of related functionality
 * 4. API consistency
 */