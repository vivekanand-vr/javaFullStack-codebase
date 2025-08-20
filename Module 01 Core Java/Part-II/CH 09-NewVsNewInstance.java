/*
 * new vs newInstance()
 * --------------------
 * 
 *  'new' KEYWORD:
 *    - Compile-time object creation
 *    - Direct constructor invocation
 *    - Type-safe at compile time
 *    - Faster execution
 *    - Syntax: new ClassName(args)
 *    - No exception handling required for object creation
 * 
 *  newInstance() METHOD:
 *    - Runtime object creation using reflection
 *    - Dynamic constructor invocation
 *    - Type checking at runtime
 *    - Slower execution (reflection overhead)
 *    - Syntax: clazz.getDeclaredConstructor(params).newInstance(args)
 *    - Requires exception handling
 */

import java.lang.reflect.Constructor;

public class NewVsNewInstanceNotes {
    
    public static void main(String[] args) {
        System.out.println("=== NEW vs NEWINSTANCE COMPARISON ===\n");
        
        // 1. BASIC COMPARISON
        demonstrateBasicDifference();
        
        // 2. REFLECTION USAGE
        demonstrateReflectionUsage();
        
        // 3. EXCEPTION HANDLING
        demonstrateExceptionHandling();
        
        // 4. PRACTICAL USE CASES
        demonstratePracticalUseCases();
    }
    
    /**
     * 1. Basic Difference between new and newInstance()
     */
    private static void demonstrateBasicDifference() {
        System.out.println("1. BASIC DIFFERENCE:");
        
        // Using 'new' keyword (compile-time)
        Person person1 = new Person("John", 25);
        System.out.println("Created using 'new': " + person1);
        
        try {
            // Using Class.newInstance() (runtime) - Deprecated since Java 9
            Class<?> clazz = Person.class;
            Person person2 = (Person) clazz.getDeclaredConstructor().newInstance();
            person2.setName("Jane");
            person2.setAge(30);
            System.out.println("Created using newInstance(): " + person2);
            
        } catch (Exception e) {
            System.err.println("Error with newInstance(): " + e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * 2. Reflection Usage Examples
     */
    private static void demonstrateReflectionUsage() {
        System.out.println("2. REFLECTION USAGE:");
        
        try {
            // Dynamic class loading and instantiation
            String className = "NewVsNewInstanceNotes$Person";
            Class<?> clazz = Class.forName(className);
            
            // Get constructor with parameters
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            Object person = constructor.newInstance("Dynamic Person", 35);
            
            System.out.println("Dynamically created: " + person);
            
            // Create multiple instances dynamically
            String[] names = {"Alice", "Bob", "Charlie"};
            for (String name : names) {
                Person p = (Person) constructor.newInstance(name, 25);
                System.out.println("Created: " + p);
            }
            
        } catch (Exception e) {
            System.err.println("Reflection error: " + e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * 3. Exception Handling Differences
     */
    private static void demonstrateExceptionHandling() {
        System.out.println("3. EXCEPTION HANDLING:");
        
        // 'new' keyword - compile-time error checking
        // Person p1 = new Person(); // Would cause compile-time error if no default constructor
        
        try {
            // newInstance() - runtime error checking
            Class<?> clazz = Person.class;
            Constructor<?> constructor = clazz.getConstructor(); // No-arg constructor
            Person person = (Person) constructor.newInstance();
            System.out.println("Created with default constructor: " + person);
            
        } catch (NoSuchMethodException e) {
            System.err.println("No default constructor found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Other exception: " + e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * 4. Practical Use Cases
     */
    private static void demonstratePracticalUseCases() {
        System.out.println("4. PRACTICAL USE CASES:");
        
        // Factory pattern using reflection
        ObjectFactory factory = new ObjectFactory();
        
        Person person = factory.createObject("person", "Factory Person", 40);
        Student student = factory.createObject("student", "Factory Student", 20);
        
        System.out.println("Factory created person: " + person);
        System.out.println("Factory created student: " + student);
        System.out.println();
    }
    
    // Sample classes for demonstration
    public static class Person {
        private String name;
        private int age;
        
        // Default constructor
        public Person() {
            this("Unknown", 0);
        }
        
        // Parameterized constructor
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        // Getters and setters
        public void setName(String name) { this.name = name; }
        public void setAge(int age) { this.age = age; }
        public String getName() { return name; }
        public int getAge() { return age; }
        
        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
    
    public static class Student extends Person {
        private String course;
        
        public Student() {
            super();
            this.course = "General";
        }
        
        public Student(String name, int age) {
            super(name, age);
            this.course = "Computer Science";
        }
        
        @Override
        public String toString() {
            return "Student{name='" + getName() + "', age=" + getAge() + ", course='" + course + "'}";
        }
    }
    
    // Simple factory using reflection
    public static class ObjectFactory {
        @SuppressWarnings("unchecked")
        public <T> T createObject(String type, String name, int age) {
            try {
                Class<?> clazz;
                switch (type.toLowerCase()) {
                    case "person":
                        clazz = Person.class;
                        break;
                    case "student":
                        clazz = Student.class;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown type: " + type);
                }
                
                Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
                return (T) constructor.newInstance(name, age);
                
            } catch (Exception e) {
                throw new RuntimeException("Failed to create object: " + e.getMessage(), e);
            }
        }
    }
}

/*
 * Key Points:
 * 
 * KEY DIFFERENCES:
 * ---------------
 *    ASPECT              | new                  | newInstance()
 *    --------------------|----------------------|--------------------
 *    Time                | Compile-time         | Runtime
 *    Performance         | Faster               | Slower
 *    Type Safety         | Compile-time         | Runtime
 *    Exception Handling  | Not required         | Required
 *    Flexibility         | Less flexible        | More flexible
 *    Use Case            | Known classes        | Dynamic classes
 * 
 * WHEN TO USE 'new':
 *   - Class is known at compile time
 *   - Performance is critical
 *   - Simple object creation
 *   - No dynamic behavior needed
 * 
 * WHEN TO USE newInstance():
 *   - Dynamic class loading
 *   - Factory patterns
 *   - Frameworks and libraries
 *   - Configuration-driven object creation
 *   - Plugin architectures
 * 
 * DEPRECATED METHODS:
 *   - Class.newInstance() is deprecated since Java 9
 *   - Use Class.getDeclaredConstructor().newInstance() instead
 *   - Provides better exception handling and security
 * 
 * BEST PRACTICES:
 *   - Prefer 'new' for known classes
 *   - Use Constructor.newInstance() for reflection
 *   - Handle all checked exceptions properly
 *   - Cache Constructor objects for better performance
 *   - Validate parameters before using reflection
 * 
 * COMMON EXCEPTIONS:
 *   - ClassNotFoundException: Class not found
 *   - NoSuchMethodException: Constructor not found
 *   - InstantiationException: Abstract class or interface
 *   - IllegalAccessException: Constructor not accessible
 *   - InvocationTargetException: Constructor throws exception
 */