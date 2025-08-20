/**
 * Lambda Expressions
 * ------------------
 * Lambda expressions provide a concise way to represent anonymous functions
 * Introduced in Java 8, they enable functional programming concepts
 */

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaExpressionsNotes {
    
    public static void main(String[] args) {
        System.out.println("=== LAMBDA EXPRESSIONS DEMONSTRATION ===\n");
        
        // 1. BASIC SYNTAX
        demonstrateBasicSyntax();
        
        // 2. FUNCTIONAL INTERFACES
        demonstrateFunctionalInterfaces();
        
        // 3. COLLECTIONS AND STREAMS
        demonstrateCollectionsAndStreams();
        
        // 4. METHOD REFERENCES
        demonstrateMethodReferences();
    }
    
    /**
     * 1. Basic Lambda Syntax
     */
    private static void demonstrateBasicSyntax() {
        System.out.println("1. BASIC LAMBDA SYNTAX:");
        
        // Traditional anonymous inner class
        Runnable traditionalRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Traditional anonymous class");
            }
        };
        
        // Lambda expression (concise)
        Runnable lambdaRunnable = () -> System.out.println("Lambda expression");
        
        traditionalRunnable.run();
        lambdaRunnable.run();
        
        // Lambda with parameters
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator subtract = (a, b) -> {
            System.out.println("Subtracting " + b + " from " + a);
            return a - b;
        };
        
        System.out.println("Add: " + add.calculate(5, 3));
        System.out.println("Multiply: " + multiply.calculate(5, 3));
        System.out.println("Subtract: " + subtract.calculate(5, 3));
        System.out.println();
    }
    
    // Functional interface for calculator
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }
    
    /**
     * 2. Built-in Functional Interfaces
     */
    private static void demonstrateFunctionalInterfaces() {
        System.out.println("2. FUNCTIONAL INTERFACES:");
        
        // Predicate<T> - takes T, returns boolean
        Predicate<String> isEmpty = s -> s.isEmpty();
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is empty string: " + isEmpty.test(""));
        System.out.println("Is 4 even: " + isEven.test(4));
        
        // Function<T, R> - takes T, returns R
        Function<String, Integer> stringLength = s -> s.length();
        Function<Integer, String> numberToString = n -> "Number: " + n;
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        System.out.println(numberToString.apply(42));
        
        // Consumer<T> - takes T, returns void
        Consumer<String> printer = s -> System.out.println("Printing: " + s);
        printer.accept("Lambda Consumer");
        
        // Supplier<T> - takes nothing, returns T
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get());
        System.out.println();
    }
    
    /**
     * 3. Collections and Streams with Lambdas
     */
    private static void demonstrateCollectionsAndStreams() {
        System.out.println("3. COLLECTIONS AND STREAMS:");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Eve");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // forEach with lambda
        System.out.print("Names: ");
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();
        
        // Filter with lambda
        List<String> shortNames = names.stream()
                .filter(name -> name.length() <= 3)
                .collect(Collectors.toList());
        System.out.println("Short names: " + shortNames);
        
        // Map with lambda
        List<Integer> nameLengths = names.stream()
                .map(name -> name.length())
                .collect(Collectors.toList());
        System.out.println("Name lengths: " + nameLengths);
        
        // Complex stream operations
        int sumOfEvenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of even squares: " + sumOfEvenSquares);
        
        // Sort with lambda
        List<String> sortedNames = names.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
        System.out.println("Sorted by length: " + sortedNames);
        System.out.println();
    }
    
    /**
     * 4. Method References
     */
    private static void demonstrateMethodReferences() {
        System.out.println("4. METHOD REFERENCES:");
        
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        
        // Lambda vs Method Reference
        System.out.println("Lambda version:");
        words.forEach(word -> System.out.println(word));
        
        System.out.println("Method reference version:");
        words.forEach(System.out::println);  // Method reference
        
        // Static method reference
        List<Integer> nums = Arrays.asList(-3, -1, 2, 4);
        List<Integer> absolute = nums.stream()
                .map(Math::abs)  // Static method reference
                .collect(Collectors.toList());
        System.out.println("Absolute values: " + absolute);
        
        // Instance method reference
        String prefix = "Item: ";
        List<String> prefixed = words.stream()
                .map(prefix::concat)  // Instance method reference
                .collect(Collectors.toList());
        System.out.println("Prefixed: " + prefixed);
        
        // Constructor reference
        Supplier<List<String>> listSupplier = ArrayList::new;  // Constructor reference
        List<String> newList = listSupplier.get();
        System.out.println("New list created: " + newList);
        System.out.println();
    }
}

/*
 * Key Points On Lambda Expressions: 
 * 
 * 1. SYNTAX:
 *    - (parameters) -> expression
 *    - (parameters) -> { statements }
 *    - parameter -> expression (single parameter, no parentheses needed)
 *    - () -> expression (no parameters)
 * 
 * 2. FUNCTIONAL INTERFACES (Built-in):
 *    - Predicate<T>: T -> boolean
 *    - Function<T,R>: T -> R
 *    - Consumer<T>: T -> void
 *    - Supplier<T>: () -> T
 *    - UnaryOperator<T>: T -> T
 *    - BinaryOperator<T>: (T,T) -> T
 * 
 * 3. METHOD REFERENCES:
 *    - Static: ClassName::methodName
 *    - Instance: instance::methodName
 *    - Constructor: ClassName::new
 *    - Instance method of arbitrary object: ClassName::methodName
 * 
 * 4. BENEFITS:
 *    - Concise code (less boilerplate)
 *    - Functional programming support
 *    - Better readability
 *    - Efficient with streams
 *    - Type inference
 * 
 * 5. LIMITATIONS:
 *    - Can only be used with functional interfaces
 *    - Limited debugging support
 *    - Can make code harder to understand if overused
 *    - No support for checked exceptions without handling
 * 
 * 6. BEST PRACTICES:
 *    - Keep lambdas short and simple
 *    - Use method references when possible
 *    - Prefer existing functional interfaces over custom ones
 *    - Use meaningful variable names in lambda parameters
 *    - Don't overuse - traditional methods are fine too
 */