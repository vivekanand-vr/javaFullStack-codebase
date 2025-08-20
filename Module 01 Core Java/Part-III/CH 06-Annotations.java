/*
 * Understanding Annotations in Java
 */

/*
 * Annotations provide metadata about the program that is not part of the program itself.
 * They have no direct effect on the operation of the code they annotate, but can be
 * processed by annotation processors during compilation or at runtime using reflection.
 * 
 * Types of Annotations:
 * 1. Built-in Annotations: @Override, @Deprecated, @SuppressWarnings, etc.
 * 2. Meta-Annotations: @Target, @Retention, @Documented, @Inherited
 * 3. Custom Annotations: User-defined annotations
 * 
 * Usage:
 * - Documentation and code generation
 * - Compile-time checking
 * - Runtime processing
 * - Framework configuration (Spring, JPA, etc.)
 */

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Arrays;

// 1. Built-in Annotations Example
class Vehicle {
    public void start() {
        System.out.println("Vehicle is starting...");
    }
    
    @Deprecated(since = "1.5", forRemoval = true)
    public void oldMethod() {
        System.out.println("This method is deprecated");
    }
}

class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting with ignition...");
    }
    
    @SuppressWarnings({"unused", "deprecation"})
    public void someMethod() {
        String unusedVariable = "This will not show unused warning";
        oldMethod(); // This will not show deprecation warning
    }
}

// 2. Custom Annotations

// Meta-annotations for custom annotation
@Target({ElementType.METHOD, ElementType.TYPE}) // Can be applied to methods and classes
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Documented // Include in JavaDoc
@interface Author {
    String name();
    String date();
    int version() default 1; // Default value
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TestMethod {
    String description() default "No description";
    boolean enabled() default true;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Validate {
    String type() default "string";
    int min() default 0;
    int max() default 100;
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Performance {
    String unit() default "ms";
}

// 3. Marker Annotation (no elements)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Entity {
}

// 4. Single Value Annotation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Column {
    String value(); // Single element named 'value'
}

// 5. Repeatable Annotation (Java 8+)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Schedules.class)
@interface Schedule {
    String day();
    String time();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Schedules {
    Schedule[] value();
}

// Example classes using custom annotations
@Entity
@Author(name = "John Doe", date = "2024-01-15", version = 2)
class User {
    @Column("user_id")
    @Validate(type = "number", min = 1, max = 999999)
    private int id;
    
    @Column("username")
    @Validate(type = "string", min = 3, max = 20)
    private String username;
    
    @Column("email")
    private String email;
    
    // Constructor
    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
    
    @TestMethod(description = "Test user validation", enabled = true)
    @Performance
    public boolean validateUser() {
        return id > 0 && username != null && username.length() >= 3;
    }
    
    @Schedule(day = "Monday", time = "9:00 AM")
    @Schedule(day = "Wednesday", time = "2:00 PM")
    @Schedule(day = "Friday", time = "4:00 PM")
    public void scheduledTask() {
        System.out.println("Executing scheduled task...");
    }
    
    // Getters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
}

public class AnnotationsExample {
    
    public static void main(String[] args) {
        System.out.println("1. Built-in Annotations:");
        builtInAnnotationsExample();
        
        System.out.println("\n2. Processing Custom Annotations:");
        processAnnotations();
        
        System.out.println("\n3. Field Annotations:");
        processFieldAnnotations();
        
        System.out.println("\n4. Method Annotations:");
        processMethodAnnotations();
        
        System.out.println("\n5. Repeatable Annotations:");
        processRepeatableAnnotations();
    }
    
    public static void builtInAnnotationsExample() {
        Car car = new Car();
        car.start(); // Overridden method
        car.someMethod(); // Method with @SuppressWarnings
    }
    
    public static void processAnnotations() {
        Class<User> userClass = User.class;
        
        // Check if class has annotation
        if (userClass.isAnnotationPresent(Author.class)) {
            Author author = userClass.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
            System.out.println("Date: " + author.date());
            System.out.println("Version: " + author.version());
        }
        
        // Check for marker annotation
        if (userClass.isAnnotationPresent(Entity.class)) {
            System.out.println("User class is an Entity");
        }
        
        // Get all annotations
        Annotation[] annotations = userClass.getAnnotations();
        System.out.println("All annotations on User class: " + 
                         Arrays.toString(annotations));
    }
    
    public static void processFieldAnnotations() {
        Class<User> userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        
        System.out.println("Field annotations:");
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
            
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                System.out.println("  Column name: " + column.value());
            }
            
            if (field.isAnnotationPresent(Validate.class)) {
                Validate validate = field.getAnnotation(Validate.class);
                System.out.println("  Validation - Type: " + validate.type() + 
                                 ", Min: " + validate.min() + 
                                 ", Max: " + validate.max());
            }
            System.out.println();
        }
    }
    
    public static void processMethodAnnotations() {
        Class<User> userClass = User.class;
        Method[] methods = userClass.getDeclaredMethods();
        
        System.out.println("Method annotations:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(TestMethod.class)) {
                TestMethod testMethod = method.getAnnotation(TestMethod.class);
                System.out.println("Test Method: " + method.getName());
                System.out.println("  Description: " + testMethod.description());
                System.out.println("  Enabled: " + testMethod.enabled());
            }
            
            if (method.isAnnotationPresent(Performance.class)) {
                Performance perf = method.getAnnotation(Performance.class);
                System.out.println("Performance tracking for " + method.getName() + 
                                 " in " + perf.unit());
            }
        }
    }
    
    public static void processRepeatableAnnotations() {
        try {
            Method scheduledMethod = User.class.getMethod("scheduledTask");
            
            // Get repeatable annotations
            Schedule[] schedules = scheduledMethod.getAnnotationsByType(Schedule.class);
            
            System.out.println("Scheduled tasks for scheduledTask method:");
            for (Schedule schedule : schedules) {
                System.out.println("  " + schedule.day() + " at " + schedule.time());
            }
            
            // Alternative way - get container annotation
            if (scheduledMethod.isAnnotationPresent(Schedules.class)) {
                Schedules schedulesContainer = scheduledMethod.getAnnotation(Schedules.class);
                System.out.println("Number of schedules: " + 
                                 schedulesContainer.value().length);
            }
            
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Key Points:
 * 1. Annotations provide metadata that doesn't affect program execution directly
 * 2. Three categories: Built-in, Meta-annotations, and Custom annotations
 * 3. @Target specifies where annotation can be applied
 * 4. @Retention specifies how long annotation is retained
 * 5. @Documented includes annotation in JavaDoc
 * 6. @Inherited allows subclasses to inherit annotations
 * 7. Annotations can have elements with default values
 * 8. Single element named 'value' allows shorthand syntax
 * 9. Marker annotations have no elements
 * 10. @Repeatable allows multiple annotations of same type (Java 8+)
 * 
 * Retention Policies:
 * - SOURCE: Discarded by compiler (e.g., @Override)
 * - CLASS: Recorded in class file, not available at runtime
 * - RUNTIME: Available at runtime via reflection
 * 
 * Target Elements:
 * - TYPE: Class, interface, enum
 * - METHOD: Method
 * - FIELD: Field/property
 * - PARAMETER: Method parameter
 * - CONSTRUCTOR: Constructor
 * - LOCAL_VARIABLE: Local variable
 * - ANNOTATION_TYPE: Annotation type
 * - PACKAGE: Package
 * 
 * Best Practices:
 * - Use appropriate retention policy based on usage
 * - Provide meaningful default values
 * - Document custom annotations thoroughly
 * - Consider using existing annotations before creating custom ones
 * - Use marker annotations for simple flags
 * - Process annotations consistently in your framework/application
 */