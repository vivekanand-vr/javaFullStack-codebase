/*
 * Understanding Methods in Java
 */

/*
 * Methods in Java are blocks of code that perform specific tasks.
 * They promote code reusability, modularity, and organization.
 * 
 * Method Syntax:
 * [access_modifier] [static] [return_type] methodName([parameters]) {
 *     // method body
 *     return value; // if return_type is not void
 * }
 * 
 * Components:
 * - Access Modifier: public, private, protected, or default
 * - Static: Optional keyword - method belongs to class, not instance
 * - Return Type: Data type of value returned (void if no return)
 * - Method Name: Identifier following naming conventions
 * - Parameters: Input values (optional)
 * - Method Body: Code to be executed
 * 
 * Types of Methods:
 * - Instance methods: Require object creation
 * - Static methods: Can be called without object creation
 * - Constructor: Special method for object initialization
 */

public class Methods {
    
    // Instance variables for demonstration
    private String name;
    private int age;
    
    // Constructor
    public Methods(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Default constructor
    public Methods() {
        this.name = "Unknown";
        this.age = 0;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Java Methods Examples ===\n");
        
        // 1. Static Methods (can be called without object)
        System.out.println("1. Static Methods:");
        demonstrateStaticMethods();
        
        // 2. Instance Methods (require object)
        System.out.println("\n2. Instance Methods:");
        Methods obj = new Methods("Alice", 25);
        obj.demonstrateInstanceMethods();
        
        // 3. Method Parameters and Arguments
        System.out.println("\n3. Method Parameters:");
        demonstrateParameters();
        
        // 4. Method Overloading
        System.out.println("\n4. Method Overloading:");
        demonstrateOverloading();
        
        // 5. Return Types and Values
        System.out.println("\n5. Return Types:");
        demonstrateReturnTypes();
        
        // 6. Variable Arguments (Varargs)
        System.out.println("\n6. Variable Arguments (Varargs):");
        demonstrateVarargs();
        
        // 7. Method Chaining
        System.out.println("\n7. Method Chaining:");
        demonstrateMethodChaining();
        
        // 8. Recursive Methods
        System.out.println("\n8. Recursive Methods:");
        demonstrateRecursion();
    }
    
    // 1. Static Methods Examples
    public static void demonstrateStaticMethods() {
        // Simple static method
        printMessage("Hello from static method!");
        
        // Static method with calculation
        double area = calculateCircleArea(5.0);
        System.out.println("Circle area (radius=5): " + area);
        
        // Static method calling another static method
        displayCurrentTime();
    }
    
    public static void printMessage(String message) {
        System.out.println("Message: " + message);
    }
    
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
    
    public static void displayCurrentTime() {
        System.out.println("Current time: " + java.time.LocalTime.now());
    }
    
    // 2. Instance Methods Examples
    public void demonstrateInstanceMethods() {
        // Instance method accessing instance variables
        displayPersonInfo();
        
        // Instance method modifying instance variables
        celebrateBirthday();
        displayPersonInfo();
        
        // Instance method with parameters
        updateName("Bob");
        displayPersonInfo();
    }
    
    public void displayPersonInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public void celebrateBirthday() {
        age++;
        System.out.println("Happy Birthday! Age incremented.");
    }
    
    public void updateName(String newName) {
        this.name = newName;
        System.out.println("Name updated to: " + newName);
    }
    
    // 3. Method Parameters Examples
    public static void demonstrateParameters() {
        // Method with no parameters
        greetUser();
        
        // Method with single parameter
        greetUserByName("Charlie");
        
        // Method with multiple parameters
        displayPersonDetails("Diana", 28, "Engineer");
        
        // Method with different parameter types
        calculateBMI(70.5, 1.75);
        
        // Pass by value demonstration
        demonstratePassByValue();
    }
    
    public static void greetUser() {
        System.out.println("Hello, User!");
    }
    
    public static void greetUserByName(String name) {
        System.out.println("Hello, " + name + "!");
    }
    
    public static void displayPersonDetails(String name, int age, String profession) {
        System.out.println("Person: " + name + ", Age: " + age + ", Profession: " + profession);
    }
    
    public static void calculateBMI(double weight, double height) {
        double bmi = weight / (height * height);
        System.out.printf("BMI: %.2f%n", bmi);
    }
    
    public static void demonstratePassByValue() {
        int number = 10;
        System.out.println("Before method call: " + number);
        modifyNumber(number);
        System.out.println("After method call: " + number); // Still 10 (pass by value)
    }
    
    public static void modifyNumber(int num) {
        num = num + 5;
        System.out.println("Inside method: " + num);
    }
    
    // 4. Method Overloading Examples
    public static void demonstrateOverloading() {
        // Same method name, different parameters
        System.out.println("Addition results:");
        System.out.println("add(5, 3) = " + add(5, 3));
        System.out.println("add(5.5, 3.2) = " + add(5.5, 3.2));
        System.out.println("add(1, 2, 3) = " + add(1, 2, 3));
        System.out.println("add(\"Hello\", \"World\") = " + add("Hello", "World"));
        
        // Overloaded print methods
        print(42);
        print(3.14159);
        print("Java Programming");
        print(true);
    }
    
    // Overloaded add methods
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public static String add(String a, String b) {
        return a + " " + b;
    }
    
    // Overloaded print methods
    public static void print(int value) {
        System.out.println("Integer: " + value);
    }
    
    public static void print(double value) {
        System.out.println("Double: " + value);
    }
    
    public static void print(String value) {
        System.out.println("String: " + value);
    }
    
    public static void print(boolean value) {
        System.out.println("Boolean: " + value);
    }
    
    // 5. Return Types Examples
    public static void demonstrateReturnTypes() {
        // Methods returning different types
        int intResult = getRandomNumber();
        System.out.println("Random number: " + intResult);
        
        String stringResult = formatName("john", "doe");
        System.out.println("Formatted name: " + stringResult);
        
        boolean boolResult = isEven(8);
        System.out.println("Is 8 even? " + boolResult);
        
        double[] arrayResult = getCoordinates();
        System.out.println("Coordinates: (" + arrayResult[0] + ", " + arrayResult[1] + ")");
        
        // Method returning object
        Methods personResult = createPerson("Eva", 30);
        System.out.println("Created person: " + personResult.name + ", " + personResult.age);
    }
    
    public static int getRandomNumber() {
        return (int) (Math.random() * 100);
    }
    
    public static String formatName(String firstName, String lastName) {
        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase() + 
               " " + lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    }
    
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public static double[] getCoordinates() {
        return new double[]{Math.random() * 10, Math.random() * 10};
    }
    
    public static Methods createPerson(String name, int age) {
        return new Methods(name, age);
    }
    
    // 6. Variable Arguments (Varargs) Examples
    public static void demonstrateVarargs() {
        // Calling methods with variable number of arguments
        System.out.println("Sum of 1, 2, 3: " + sum(1, 2, 3));
        System.out.println("Sum of 1, 2, 3, 4, 5: " + sum(1, 2, 3, 4, 5));
        System.out.println("Sum of 10, 20: " + sum(10, 20));
        
        printNames("Alice");
        printNames("Bob", "Charlie", "Diana");
        printNames("Eve", "Frank", "Grace", "Henry", "Ivy");
    }
    
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    
    public static void printNames(String... names) {
        System.out.print("Names: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
    
    // 7. Method Chaining Examples
    public static void demonstrateMethodChaining() {
        // Creating a chainable calculator
        Calculator calc = new Calculator();
        double result = calc.add(10).multiply(2).subtract(5).divide(3).getResult();
        System.out.println("Chained calculation result: " + result);
        
        // String method chaining example
        String processed = "  hello world  "
                .trim()
                .toUpperCase()
                .replace("WORLD", "JAVA");
        System.out.println("Processed string: " + processed);
    }
    
    // Helper class for method chaining demonstration
    static class Calculator {
        private double value = 0;
        
        public Calculator add(double n) {
            value += n;
            return this;
        }
        
        public Calculator multiply(double n) {
            value *= n;
            return this;
        }
        
        public Calculator subtract(double n) {
            value -= n;
            return this;
        }
        
        public Calculator divide(double n) {
            value /= n;
            return this;
        }
        
        public double getResult() {
            return value;
        }
    }
    
    // 8. Recursive Methods Examples
    public static void demonstrateRecursion() {
        // Factorial calculation
        System.out.println("Factorial of 5: " + factorial(5));
        
        // Fibonacci sequence
        System.out.print("Fibonacci sequence (10 terms): ");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        
        // Power calculation
        System.out.println("2^8 = " + power(2, 8));
        
        // String reversal
        System.out.println("Reverse of 'hello': " + reverseString("hello"));
    }
    
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static long power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
    
    public static String reverseString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}

/*
 * Key Points about Methods in Java:
 * 
 * 1. METHOD STRUCTURE:
 *    - Access modifier: Controls visibility (public, private, protected, default)
 *    - Static keyword: Method belongs to class, not instance
 *    - Return type: Specifies what the method returns (void for no return)
 *    - Method name: Should be descriptive and follow camelCase convention
 *    - Parameters: Input values (optional)
 * 
 * 2. TYPES OF METHODS:
 *    - Static methods: Called using ClassName.methodName()
 *    - Instance methods: Called using objectName.methodName()
 *    - Constructor methods: Special methods for object initialization
 * 
 * 3. METHOD OVERLOADING:
 *    - Same method name with different parameter lists
 *    - Different number of parameters OR different parameter types
 *    - Return type alone cannot differentiate overloaded methods
 *    - Compile-time polymorphism
 * 
 * 4. PARAMETER PASSING:
 *    - Java uses pass-by-value for all parameters
 *    - Primitive types: Copy of value is passed
 *    - Object references: Copy of reference is passed (not the object itself)
 *    - Changes to primitives inside method don't affect original
 *    - Changes to object state through reference affect original object
 * 
 * 5. VARIABLE ARGUMENTS (VARARGS):
 *    - Syntax: dataType... parameterName
 *    - Allows method to accept variable number of arguments
 *    - Treated as array inside method
 *    - Must be the last parameter if multiple parameters exist
 * 
 * 6. RECURSION:
 *    - Method calling itself
 *    - Must have base case to prevent infinite recursion
 *    - Each recursive call creates new stack frame
 *    - Can be memory-intensive for deep recursion
 * 
 * 7. BEST PRACTICES:
 *    - Use descriptive method names
 *    - Keep methods focused on single responsibility
 *    - Limit method length (generally under 20-30 lines)
 *    - Use appropriate access modifiers
 *    - Document complex methods with comments
 *    - Handle exceptions appropriately
 *    - Prefer composition over deep inheritance
 * 
 * 8. METHOD CHAINING:
 *    - Methods return 'this' to enable chaining
 *    - Creates fluent interfaces
 *    - Improves code readability
 *    - Common in builder patterns
 * 
 * To compile and run:
 * javac Methods.java
 * java Methods
 */