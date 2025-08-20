/*
 * Understanding Functional Interfaces in Java
 */

/*
 * A Functional Interface is an interface that contains exactly one abstract method.
 * They can have multiple default or static methods, but only one abstract method.
 * Also known as Single Abstract Method (SAM) interfaces.
 * 
 * Key Features:
 * - Can be used with lambda expressions
 * - Can be used with method references
 * - @FunctionalInterface annotation for compile-time validation
 * - Foundation for Java 8+ functional programming features
 * 
 * Built-in Functional Interfaces (java.util.function):
 * - Function<T,R>: Takes T, returns R
 * - Consumer<T>: Takes T, returns void
 * - Supplier<T>: Takes nothing, returns T  
 * - Predicate<T>: Takes T, returns boolean
 * - UnaryOperator<T>: Function<T,T>
 * - BinaryOperator<T>: BiFunction<T,T,T>
 * - BiFunction<T,U,R>: Takes T and U, returns R
 * 
 * Benefits:
 * - Enables functional programming
 * - Lambda expression support
 * - Cleaner, more readable code
 * - Better support for parallel processing
 */

import java.util.function.*;
import java.util.*;
import java.util.stream.Collectors;

// 1. Custom Functional Interfaces

@FunctionalInterface
interface Calculator {
    double calculate(double a, double b);
    
    // Default methods are allowed
    default void printResult(double a, double b) {
        System.out.printf("Result: %.2f%n", calculate(a, b));
    }
    
    // Static methods are allowed
    static void info() {
        System.out.println("Calculator functional interface");
    }
}

@FunctionalInterface
interface StringProcessor {
    String process(String input);
}

@FunctionalInterface
interface NumberValidator {
    boolean validate(int number);
}

// 2. Generic Functional Interface
@FunctionalInterface
interface Converter<T, R> {
    R convert(T input);
}

// 3. Functional Interface with Exception
@FunctionalInterface
interface RiskyOperation<T> {
    T execute() throws Exception;
}

// 4. Example classes for demonstrations
class Person {
    private String name;
    private int age;
    private double salary;
    
    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, salary=%.2f}", name, age, salary);
    }
}

public class FunctionalInterfaceExample {
    
    public static void main(String[] args) {
        System.out.println("1. Custom Functional Interfaces:");
        customFunctionalInterfaces();
        
        System.out.println("\n2. Built-in Functional Interfaces:");
        builtInFunctionalInterfaces();
        
        System.out.println("\n3. Function Interface Examples:");
        functionExamples();
        
        System.out.println("\n4. Consumer Interface Examples:");
        consumerExamples();
        
        System.out.println("\n5. Supplier Interface Examples:");
        supplierExamples();
        
        System.out.println("\n6. Predicate Interface Examples:");
        predicateExamples();
        
        System.out.println("\n7. Advanced Functional Interface Usage:");
        advancedExamples();
        
        System.out.println("\n8. Method References:");
        methodReferenceExamples();
        
        System.out.println("\n9. Chaining Functional Interfaces:");
        chainingExamples();
    }
    
    public static void customFunctionalInterfaces() {
        // Using custom Calculator interface with lambda
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> b != 0 ? a / b : 0;
        
        System.out.println("Custom Calculator implementations:");
        add.printResult(10, 5);
        multiply.printResult(10, 5);
        divide.printResult(10, 5);
        
        Calculator.info(); // Static method call
        
        // StringProcessor example
        StringProcessor toUpperCase = str -> str.toUpperCase();
        StringProcessor reverse = str -> new StringBuilder(str).reverse().toString();
        StringProcessor removeSpaces = str -> str.replaceAll("\\s+", "");
        
        String input = "Hello World";
        System.out.println("\nString processing:");
        System.out.println("Original: " + input);
        System.out.println("Upper case: " + toUpperCase.process(input));
        System.out.println("Reversed: " + reverse.process(input));
        System.out.println("No spaces: " + removeSpaces.process(input));
        
        // NumberValidator example
        NumberValidator isEven = num -> num % 2 == 0;
        NumberValidator isPositive = num -> num > 0;
        NumberValidator isPrime = num -> {
            if (num < 2) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        };
        
        int testNumber = 17;
        System.out.println("\nValidating number " + testNumber + ":");
        System.out.println("Is even: " + isEven.validate(testNumber));
        System.out.println("Is positive: " + isPositive.validate(testNumber));
        System.out.println("Is prime: " + isPrime.validate(testNumber));
    }
    
    public static void builtInFunctionalInterfaces() {
        // Function<T, R> - transforms input to output
        Function<String, Integer> stringLength = str -> str.length();
        Function<Integer, String> intToString = num -> "Number: " + num;
        
        System.out.println("Function examples:");
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        System.out.println("Convert 42: " + intToString.apply(42));
        
        // Consumer<T> - accepts input, returns nothing
        Consumer<String> printer = str -> System.out.println("Printing: " + str);
        Consumer<List<Integer>> listPrinter = list -> {
            System.out.print("List contents: ");
            list.forEach(System.out::print);
            System.out.println();
        };
        
        System.out.println("\nConsumer examples:");
        printer.accept("Hello Consumer");
        listPrinter.accept(Arrays.asList(1, 2, 3, 4, 5));
        
        // Supplier<T> - supplies a value
        Supplier<Double> randomNumber = () -> Math.random();
        Supplier<List<String>> emptyList = ArrayList::new;
        
        System.out.println("\nSupplier examples:");
        System.out.println("Random number: " + randomNumber.get());
        System.out.println("Empty list: " + emptyList.get());
        
        // Predicate<T> - tests a condition
        Predicate<String> isEmpty = str -> str.isEmpty();
        Predicate<Integer> isGreaterThan10 = num -> num > 10;
        
        System.out.println("\nPredicate examples:");
        System.out.println("'' is empty: " + isEmpty.test(""));
        System.out.println("'Hello' is empty: " + isEmpty.test("Hello"));
        System.out.println("15 > 10: " + isGreaterThan10.test(15));
        System.out.println("5 > 10: " + isGreaterThan10.test(5));
    }
    
    public static void functionExamples() {
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, 50000),
            new Person("Bob", 30, 60000),
            new Person("Charlie", 35, 70000)
        );
        
        // Function to extract name
        Function<Person, String> getName = Person::getName;
        
        // Function to calculate tax
        Function<Double, Double> calculateTax = salary -> salary * 0.2;
        
        // BiFunction for salary increase
        BiFunction<Double, Double, Double> increaseSalary = (current, percentage) -> 
            current * (1 + percentage / 100);
        
        System.out.println("Function examples with Person objects:");
        for (Person person : people) {
            String name = getName.apply(person);
            double tax = calculateTax.apply(person.getSalary());
            double newSalary = increaseSalary.apply(person.getSalary(), 10.0);
            
            System.out.printf("%s: Tax=%.2f, New Salary=%.2f%n", name, tax, newSalary);
        }
        
        // Function composition
        Function<String, String> addPrefix = str -> "Mr. " + str;
        Function<String, String> addSuffix = str -> str + " Jr.";
        Function<String, String> fullTransform = addPrefix.andThen(addSuffix);
        
        System.out.println("\nFunction composition:");
        System.out.println("Transform 'John': " + fullTransform.apply("John"));
    }
    
    public static void consumerExamples() {
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, 50000),
            new Person("Bob", 30, 60000),
            new Person("Charlie", 35, 70000)
        );
        
        // Simple consumer
        Consumer<Person> printPerson = person -> System.out.println(person);
        
        // Consumer that modifies (conceptually - in real scenario you'd modify mutable objects)
        Consumer<String> logger = message -> System.out.println("[LOG] " + message);
        
        // BiConsumer example
        BiConsumer<String, Integer> personInfo = (name, age) -> 
            System.out.printf("Person: %s, Age: %d%n", name, age);
        
        System.out.println("Consumer examples:");
        people.forEach(printPerson);
        
        System.out.println("\nBiConsumer example:");
        people.forEach(person -> personInfo.accept(person.getName(), person.getAge()));
        
        // Consumer chaining
        Consumer<String> upperCase = str -> System.out.print(str.toUpperCase());
        Consumer<String> addNewLine = str -> System.out.println();
        Consumer<String> processString = upperCase.andThen(addNewLine);
        
        System.out.println("\nConsumer chaining:");
        processString.accept("hello world");
    }
    
    public static void supplierExamples() {
        // Basic suppliers
        Supplier<String> stringSupplier = () -> "Hello from Supplier";
        Supplier<Integer> randomInt = () -> new Random().nextInt(100);
        Supplier<Date> currentTime = Date::new;
        
        System.out.println("Supplier examples:");
        System.out.println(stringSupplier.get());
        System.out.println("Random number: " + randomInt.get());
        System.out.println("Current time: " + currentTime.get());
        
        // Supplier for lazy initialization
        Supplier<List<String>> expensiveOperation = () -> {
            System.out.println("Performing expensive operation...");
            return Arrays.asList("Data1", "Data2", "Data3");
        };
        
        System.out.println("\nLazy initialization with Supplier:");
        // Operation is not performed until get() is called
        System.out.println("Supplier created");
        List<String> result = expensiveOperation.get(); // Now the operation runs
        System.out.println("Result: " + result);
        
        // Supplier factory pattern
        Supplier<Person> personFactory = () -> new Person("Default", 0, 0.0);
        System.out.println("\nFactory pattern:");
        System.out.println("New person: " + personFactory.get());
    }
    
    public static void predicateExamples() {
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, 50000),
            new Person("Bob", 30, 60000),
            new Person("Charlie", 35, 70000),
            new Person("Diana", 28, 55000)
        );
        
        // Basic predicates
        Predicate<Person> isAdult = person -> person.getAge() >= 18;
        Predicate<Person> highSalary = person -> person.getSalary() > 55000;
        Predicate<Person> nameStartsWithA = person -> person.getName().startsWith("A");
        
        System.out.println("Basic predicate examples:");
        System.out.println("Adults: " + 
            people.stream().filter(isAdult).map(Person::getName).collect(Collectors.toList()));
        System.out.println("High salary: " + 
            people.stream().filter(highSalary).map(Person::getName).collect(Collectors.toList()));
        
        // Predicate composition
        Predicate<Person> youngAndRich = person -> person.getAge() < 30 && person.getSalary() > 55000;
        
        // Using and(), or(), negate()
        Predicate<Person> adultWithHighSalary = isAdult.and(highSalary);
        Predicate<Person> notAdult = isAdult.negate();
        Predicate<Person> richOrNameA = highSalary.or(nameStartsWithA);
        
        System.out.println("\nPredicate composition:");
        System.out.println("Adult with high salary: " + 
            people.stream().filter(adultWithHighSalary).map(Person::getName).collect(Collectors.toList()));
        System.out.println("Rich or name starts with A: " + 
            people.stream().filter(richOrNameA).map(Person::getName).collect(Collectors.toList()));
        
        // BiPredicate example
        BiPredicate<String, Integer> nameAndAge = (name, age) -> 
            name.length() > 3 && age > 25;
        
        System.out.println("\nBiPredicate example:");
        people.forEach(person -> {
            boolean result = nameAndAge.test(person.getName(), person.getAge());
            System.out.printf("%s (age %d): %s%n", person.getName(), person.getAge(), result);
        });
    }
    
    public static void advancedExamples() {
        // UnaryOperator<T> - Function<T,T>
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        UnaryOperator<Integer> square = x -> x * x;
        
        System.out.println("UnaryOperator examples:");
        System.out.println("Upper case: " + toUpperCase.apply("hello"));
        System.out.println("Square of 5: " + square.apply(5));
        
        // BinaryOperator<T> - BiFunction<T,T,T>
        BinaryOperator<Integer> add = (a, b) -> a + b;
        BinaryOperator<String> concat = (s1, s2) -> s1 + " " + s2;
        
        System.out.println("\nBinaryOperator examples:");
        System.out.println("Add 10 + 20: " + add.apply(10, 20));
        System.out.println("Concat: " + concat.apply("Hello", "World"));
        
        // IntFunction, ToIntFunction, etc.
        IntFunction<String> intToString = num -> "Number: " + num;
        ToIntFunction<String> stringToInt = str -> str.length();
        
        System.out.println("\nSpecialized function interfaces:");
        System.out.println("Int to string: " + intToString.apply(42));
        System.out.println("String to int: " + stringToInt.applyAsInt("Hello"));
        
        // Custom generic converter
        Converter<String, Integer> stringLength = String::length;
        Converter<Integer, String> numberToWords = num -> {
            String[] words = {"zero", "one", "two", "three", "four", "five"};
            return num >= 0 && num < words.length ? words[num] : "unknown";
        };
        
        System.out.println("\nCustom generic converter:");
        System.out.println("Length of 'Functional': " + stringLength.convert("Functional"));
        System.out.println("3 in words: " + numberToWords.convert(3));
    }
    
    public static void methodReferenceExamples() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, 50000),
            new Person("Bob", 30, 60000),
            new Person("Charlie", 35, 70000)
        );
        
        System.out.println("Method reference examples:");
        
        // Static method reference
        Function<String, Integer> parseInt = Integer::parseInt;
        System.out.println("Parse '123': " + parseInt.apply("123"));
        
        // Instance method reference on particular instance
        String prefix = "Hello, ";
        Function<String, String> greeter = prefix::concat;
        System.out.println("Greeting: " + greeter.apply("World"));
        
        // Instance method reference on arbitrary instance
        Function<String, String> toUpper = String::toUpperCase;
        List<String> upperNames = names.stream()
                                      .map(String::toUpperCase)
                                      .collect(Collectors.toList());
        System.out.println("Upper case names: " + upperNames);
        
        // Constructor reference
        Supplier<ArrayList<String>> listSupplier = ArrayList::new;
        Function<String, StringBuilder> sbFunction = StringBuilder::new;
        
        System.out.println("Constructor references:");
        System.out.println("New list: " + listSupplier.get());
        System.out.println("New StringBuilder: " + sbFunction.apply("Hello"));
        
        // Method reference with streams
        List<String> personNames = people.stream()
                                        .map(Person::getName)
                                        .collect(Collectors.toList());
        System.out.println("Person names: " + personNames);
    }
    
    public static void chainingExamples() {
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, 50000),
            new Person("Bob", 30, 60000),
            new Person("Charlie", 35, 70000),
            new Person("Diana", 28, 45000)
        );
        
        System.out.println("Functional interface chaining:");
        
        // Function chaining
        Function<Person, String> getName = Person::getName;
        Function<String, String> addTitle = name -> "Mr./Ms. " + name;
        Function<String, String> addSuffix = name -> name + " (Employee)";
        
        Function<Person, String> fullTransform = getName.andThen(addTitle).andThen(addSuffix);
        
        people.forEach(person -> 
            System.out.println("Transformed: " + fullTransform.apply(person)));
        
        // Predicate chaining
        Predicate<Person> isYoung = person -> person.getAge() < 30;
        Predicate<Person> hasGoodSalary = person -> person.getSalary() >= 50000;
        
        Predicate<Person> youngAndRich = isYoung.and(hasGoodSalary);
        Predicate<Person> youngOrRich = isYoung.or(hasGoodSalary);
        Predicate<Person> notYoung = isYoung.negate();
        
        System.out.println("\nPredicate chaining results:");
        System.out.println("Young and rich: " + 
            people.stream().filter(youngAndRich).map(Person::getName).collect(Collectors.toList()));
        System.out.println("Young or rich: " + 
            people.stream().filter(youngOrRich).map(Person::getName).collect(Collectors.toList()));
        System.out.println("Not young: " + 
            people.stream().filter(notYoung).map(Person::getName).collect(Collectors.toList()));
        
        // Consumer chaining
        Consumer<Person> printName = person -> System.out.print("Name: " + person.getName());
        Consumer<Person> printAge = person -> System.out.print(", Age: " + person.getAge());
        Consumer<Person> printSalary = person -> System.out.println(", Salary: $" + person.getSalary());
        
        Consumer<Person> printAll = printName.andThen(printAge).andThen(printSalary);
        
        System.out.println("\nConsumer chaining:");
        people.forEach(printAll);
    }
}

/*
 * Key Points:
 *  1. Functional Interface has exactly one abstract method (SAM)
 *  2. Can have multiple default and static methods
 *  3. @FunctionalInterface annotation provides compile-time validation
 *  4. Enables lambda expressions and method references
 *  5. Built-in functional interfaces in java.util.function package
 *  6. Function<T,R>: Transformation (T → R)
 *  7. Consumer<T>: Side effects (T → void)
 *  8. Supplier<T>: Factory/Generation (void → T)
 *  9. Predicate<T>: Testing (T → boolean)
 *  10. UnaryOperator<T>: Same type transformation (T → T)
 * 
 * Common Built-in Functional Interfaces:
 * ┌─────────────────────┬─────────────────┬──────────────────┐
 * │    Interface        │   Method        │   Description    │
 * ├─────────────────────┼─────────────────┼──────────────────┤
 * │ Function<T,R>       │ R apply(T)      │ T → R            │
 * │ Consumer<T>         │ void accept(T)  │ T → void         │
 * │ Supplier<T>         │ T get()         │ void → T         │
 * │ Predicate<T>        │ boolean test(T) │ T → boolean      │
 * │ UnaryOperator<T>    │ T apply(T)      │ T → T            │
 * │ BinaryOperator<T>   │ T apply(T,T)    │ (T,T) → T        │
 * │ BiFunction<T,U,R>   │ R apply(T,U)    │ (T,U) → R        │
 * │ BiConsumer<T,U>     │ void accept(T,U)│ (T,U) → void     │
 * │ BiPredicate<T,U>    │ boolean test(T,U)│ (T,U) → boolean │
 * └─────────────────────┴─────────────────┴──────────────────┘
 * 
 * Method Reference Types:
 *  - Static method: ClassName::methodName
 *  - Instance method (specific): instance::methodName
 *  - Instance method (arbitrary): ClassName::methodName
 *  - Constructor: ClassName::new
 * 
 * Best Practices:
 *  - Use @FunctionalInterface for custom functional interfaces
 *  - Prefer method references over lambda expressions when possible
 *  - Use built-in functional interfaces instead of creating custom ones
 *  - Chain functional interfaces for complex operations
 *  - Consider exception handling with functional interfaces
 *  - Use appropriate specialized interfaces (IntFunction, ToIntFunction, etc.)
 *  - Keep lambda expressions short and readable
 *  - Avoid side effects in pure functions
 */