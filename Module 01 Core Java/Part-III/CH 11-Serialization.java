/*
 * Understanding Serialization and Deserialization in Java
 */

/*
 * Serialization is the process of converting an object's state into a byte stream
 * so it can be stored in a file, database, or transmitted over a network.
 * Deserialization is the reverse process - converting byte stream back to object.
 * 
 * Key Concepts:
 * - Serializable Interface: Marker interface that classes must implement
 * - ObjectOutputStream: Used for serialization (writing objects)
 * - ObjectInputStream: Used for deserialization (reading objects)
 * - serialVersionUID: Version control for serialized classes
 * 
 * Requirements for Serialization:
 * 1. Class must implement Serializable interface
 * 2. All non-transient instance variables must be serializable
 * 3. Static variables are not serialized (belong to class, not instance)
 * 4. Transient variables are not serialized
 * 
 * Use Cases:
 * - Saving object state to files
 * - Sending objects over network
 * - Caching objects
 * - Deep copying objects
 * - Storing objects in databases
 */

import java.io.*;
import java.util.*;

// Basic serializable class
class Student implements Serializable {
    // serialVersionUID for version control
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;
    private String studentId;
    private double gpa;
    
    // Static variable - not serialized
    private static int totalStudents = 0;
    
    // Transient variable - not serialized
    private transient String temporaryData;
    
    public Student(String name, int age, String studentId, double gpa) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.gpa = gpa;
        this.temporaryData = "This won't be serialized";
        totalStudents++;
    }
    
    // Getters and setters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getStudentId() { return studentId; }
    public double getGpa() { return gpa; }
    public String getTemporaryData() { return temporaryData; }
    public static int getTotalStudents() { return totalStudents; }
    
    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d, studentId='%s', gpa=%.2f, temporaryData='%s'}",
                name, age, studentId, gpa, temporaryData);
    }
}

// Class with custom serialization
class BankAccount implements Serializable {
    private static final long serialVersionUID = 2L;
    
    private String accountNumber;
    private String holderName;
    private double balance;
    private transient String pin; // Sensitive data - not serialized
    
    public BankAccount(String accountNumber, String holderName, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
    }
    
    // Custom serialization method
    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Custom writeObject called for " + holderName);
        out.defaultWriteObject(); // Serialize non-transient fields
        
        // Custom logic - encrypt sensitive data before serialization
        String encryptedData = "encrypted_" + pin;
        out.writeObject(encryptedData);
    }
    
    // Custom deserialization method
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("Custom readObject called");
        in.defaultReadObject(); // Deserialize non-transient fields
        
        // Custom logic - decrypt sensitive data after deserialization
        String encryptedData = (String) in.readObject();
        this.pin = encryptedData.replace("encrypted_", "");
    }
    
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public String getPin() { return pin; }
    
    @Override
    public String toString() {
        return String.format("BankAccount{accountNumber='%s', holderName='%s', balance=%.2f, pin='%s'}",
                accountNumber, holderName, balance, pin);
    }
}

// Class demonstrating inheritance with serialization
class Person implements Serializable {
    private static final long serialVersionUID = 3L;
    
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d}", name, age);
    }
}

class Employee extends Person {
    private static final long serialVersionUID = 4L;
    
    private String employeeId;
    private String department;
    private double salary;
    
    public Employee(String name, int age, String employeeId, String department, double salary) {
        super(name, age);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return String.format("Employee{name='%s', age=%d, employeeId='%s', department='%s', salary=%.2f}",
                name, age, employeeId, department, salary);
    }
}

// Non-serializable class for demonstration
class NonSerializableClass {
    private String data;
    
    public NonSerializableClass(String data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "NonSerializableClass{data='" + data + "'}";
    }
}

// Class containing non-serializable object
class Container implements Serializable {
    private static final long serialVersionUID = 5L;
    
    private String name;
    private transient NonSerializableClass nonSerializable; // Must be transient
    
    public Container(String name, NonSerializableClass nonSerializable) {
        this.name = name;
        this.nonSerializable = nonSerializable;
    }
    
    @Override
    public String toString() {
        return String.format("Container{name='%s', nonSerializable=%s}", name, nonSerializable);
    }
}

public class Serialization {
    
    public static void main(String[] args) {
        System.out.println("=== Serialization and Deserialization Examples ===\n");
        
        // 1. Basic Serialization and Deserialization
        System.out.println("1. Basic Serialization and Deserialization:");
        demonstrateBasicSerialization();
        
        // 2. Transient Fields
        System.out.println("\n2. Transient Fields:");
        demonstrateTransientFields();
        
        // 3. Custom Serialization
        System.out.println("\n3. Custom Serialization:");
        demonstrateCustomSerialization();
        
        // 4. Serialization with Inheritance
        System.out.println("\n4. Serialization with Inheritance:");
        demonstrateInheritanceSerialization();
        
        // 5. Collection Serialization
        System.out.println("\n5. Collection Serialization:");
        demonstrateCollectionSerialization();
        
        // 6. Non-serializable Objects
        System.out.println("\n6. Non-serializable Objects:");
        demonstrateNonSerializableObjects();
        
        // 7. serialVersionUID Importance
        System.out.println("\n7. serialVersionUID Importance:");
        demonstrateSerialVersionUID();
        
        // 8. Best Practices and Common Pitfalls
        System.out.println("\n8. Best Practices:");
        demonstrateBestPractices();
    }
    
    // 1. Basic Serialization and Deserialization
    public static void demonstrateBasicSerialization() {
        Student student = new Student("Alice Johnson", 20, "STU001", 3.75);
        String filename = "student.ser";
        
        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(student);
            System.out.println("✓ Student object serialized to " + filename);
            System.out.println("Original: " + student);
        } catch (IOException e) {
            System.err.println("Serialization error: " + e.getMessage());
        }
        
        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("✓ Student object deserialized from " + filename);
            System.out.println("Deserialized: " + deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization error: " + e.getMessage());
        }
    }
    
    // 2. Transient Fields Demonstration
    public static void demonstrateTransientFields() {
        Student student = new Student("Bob Smith", 22, "STU002", 3.50);
        String filename = "student_transient.ser";
        
        System.out.println("Before serialization:");
        System.out.println("Student: " + student);
        System.out.println("Total students (static): " + Student.getTotalStudents());
        
        // Serialize and deserialize
        serializeObject(student, filename);
        Student deserializedStudent = (Student) deserializeObject(filename);
        
        System.out.println("After deserialization:");
        System.out.println("Student: " + deserializedStudent);
        System.out.println("Total students (static): " + Student.getTotalStudents());
        System.out.println("Note: temporaryData is null (transient field)");
        System.out.println("Note: totalStudents remains unchanged (static field)");
    }
    
    // 3. Custom Serialization
    public static void demonstrateCustomSerialization() {
        BankAccount account = new BankAccount("ACC123", "John Doe", 5000.50, "1234");
        String filename = "account.ser";
        
        System.out.println("Before serialization:");
        System.out.println("Account: " + account);
        
        // Serialize with custom logic
        serializeObject(account, filename);
        
        // Deserialize with custom logic
        BankAccount deserializedAccount = (BankAccount) deserializeObject(filename);
        
        System.out.println("After deserialization:");
        System.out.println("Account: " + deserializedAccount);
        System.out.println("Note: PIN was encrypted during serialization and decrypted during deserialization");
    }
    
    // 4. Serialization with Inheritance
    public static void demonstrateInheritanceSerialization() {
        Employee emp = new Employee("Carol Wilson", 35, "EMP001", "Engineering", 75000.0);
        String filename = "employee.ser";
        
        System.out.println("Before serialization:");
        System.out.println("Employee: " + emp);
        
        serializeObject(emp, filename);
        Employee deserializedEmp = (Employee) deserializeObject(filename);
        
        System.out.println("After deserialization:");
        System.out.println("Employee: " + deserializedEmp);
        System.out.println("Note: Both parent (Person) and child (Employee) fields are preserved");
    }
    
    // 5. Collection Serialization
    public static void demonstrateCollectionSerialization() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("David Brown", 21, "STU003", 3.25));
        students.add(new Student("Emma Davis", 19, "STU004", 3.90));
        students.add(new Student("Frank Miller", 23, "STU005", 2.85));
        
        String filename = "student_list.ser";
        
        System.out.println("Before serialization:");
        students.forEach(System.out::println);
        
        // Serialize collection
        serializeObject(students, filename);
        
        // Deserialize collection
        @SuppressWarnings("unchecked")
        List<Student> deserializedStudents = (List<Student>) deserializeObject(filename);
        
        System.out.println("After deserialization:");
        deserializedStudents.forEach(System.out::println);
        System.out.println("Collection size: " + deserializedStudents.size());
    }
    
    // 6. Non-serializable Objects
    public static void demonstrateNonSerializableObjects() {
        NonSerializableClass nonSerial = new NonSerializableClass("Important data");
        Container container = new Container("MyContainer", nonSerial);
        String filename = "container.ser";
        
        System.out.println("Before serialization:");
        System.out.println("Container: " + container);
        
        serializeObject(container, filename);
        Container deserializedContainer = (Container) deserializeObject(filename);
        
        System.out.println("After deserialization:");
        System.out.println("Container: " + deserializedContainer);
        System.out.println("Note: Non-serializable field is null (was marked transient)");
        
        // Demonstrate what happens without transient
        System.out.println("\nTrying to serialize non-serializable object directly:");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fail.ser"))) {
            oos.writeObject(nonSerial); // This will throw NotSerializableException
        } catch (Exception e) {
            System.out.println("✗ Exception caught: " + e.getClass().getSimpleName());
            System.out.println("  Message: " + e.getMessage());
        }
    }
    
    // 7. serialVersionUID Importance
    public static void demonstrateSerialVersionUID() {
        System.out.println("serialVersionUID is crucial for version control:");
        System.out.println("- Used to verify sender and receiver have compatible classes");
        System.out.println("- If not declared, JVM generates one based on class details");
        System.out.println("- Class changes can break deserialization without proper serialVersionUID");
        System.out.println("- Always declare it explicitly for production code");
        
        Student student = new Student("Version Test", 25, "VER001", 3.0);
        System.out.println("Current Student serialVersionUID: " + getSerialVersionUID(Student.class));
        
        // Show different serialVersionUIDs in our classes
        System.out.println("Student serialVersionUID: " + getSerialVersionUID(Student.class));
        System.out.println("BankAccount serialVersionUID: " + getSerialVersionUID(BankAccount.class));
        System.out.println("Employee serialVersionUID: " + getSerialVersionUID(Employee.class));
    }
    
    // 8. Best Practices
    public static void demonstrateBestPractices() {
        System.out.println("Serialization Best Practices:");
        System.out.println("1. Always implement serialVersionUID explicitly");
        System.out.println("2. Mark sensitive fields as transient");
        System.out.println("3. Be careful with static fields (not serialized)");
        System.out.println("4. Handle custom serialization with writeObject/readObject");
        System.out.println("5. Consider using Externalizable for more control");
        System.out.println("6. Test serialization with different class versions");
        System.out.println("7. Be aware of security implications");
        System.out.println("8. Use try-with-resources for proper stream handling");
        
        // Demonstrate deep copy using serialization
        System.out.println("\nDeep copy using serialization:");
        Student original = new Student("Original Student", 22, "ORIG001", 3.5);
        Student copy = deepCopy(original);
        
        System.out.println("Original: " + original);
        System.out.println("Deep copy: " + copy);
        System.out.println("Are they the same object? " + (original == copy));
        System.out.println("Are they equal content? " + (original.getName().equals(copy.getName())));
    }
    
    // Helper method for serialization
    public static void serializeObject(Object obj, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
            System.out.println("✓ Object serialized to " + filename);
        } catch (IOException e) {
            System.err.println("✗ Serialization error: " + e.getMessage());
        }
    }
    
    // Helper method for deserialization
    public static Object deserializeObject(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();
            System.out.println("✓ Object deserialized from " + filename);
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("✗ Deserialization error: " + e.getMessage());
            return null;
        }
    }
    
    // Helper method to get serialVersionUID using reflection
    private static long getSerialVersionUID(Class<?> clazz) {
        try {
            return clazz.getDeclaredField("serialVersionUID").getLong(null);
        } catch (Exception e) {
            return 0L; // Default if not found
        }
    }
    
    // Deep copy using serialization
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deepCopy(T original) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(original);
            
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("Deep copy failed", e);
        }
    }
}

/*
 * Key Points about Serialization and Deserialization in Java:
 * 
 * 1. BASIC REQUIREMENTS:
 *    - Class must implement Serializable interface (marker interface)
 *    - All non-transient fields must be serializable
 *    - JVM handles the serialization process automatically
 *    - Use ObjectOutputStream for serialization, ObjectInputStream for deserialization
 * 
 * 2. FIELDS THAT ARE NOT SERIALIZED:
 *    - Static fields (belong to class, not instance)
 *    - Transient fields (explicitly marked to skip serialization)
 *    - Fields of non-serializable types (unless marked transient)
 * 
 * 3. SERIALIZATION PROCESS:
 *    - Object → Byte Stream (Serialization)
 *    - Byte Stream → Object (Deserialization)
 *    - Preserves object state and relationships
 *    - Handles object graphs and circular references
 * 
 * 4. CUSTOM SERIALIZATION:
 *    - writeObject(ObjectOutputStream): Custom serialization logic
 *    - readObject(ObjectInputStream): Custom deserialization logic
 *    - writeReplace(): Return different object for serialization
 *    - readResolve(): Control object creation during deserialization
 * 
 * 5. SERIALVERSIONUID:
 *    - Unique identifier for each serializable class
 *    - Used for version control during deserialization
 *    - If not declared, JVM generates based on class structure
 *    - Class changes can break deserialization without proper management
 * 
 * 6. INHERITANCE AND SERIALIZATION:
 *    - If parent class is serializable, child classes are automatically serializable
 *    - If parent is not serializable, it must have no-arg constructor
 *    - Child class can be serializable even if parent is not
 * 
 * 7. COLLECTIONS AND SERIALIZATION:
 *    - Most Java collections implement Serializable
 *    - All elements in collection must be serializable
 *    - HashMap, ArrayList, LinkedList etc. can be serialized
 *    - TreeMap, TreeSet require elements to be Comparable or have Comparator
 * 
 * 8. SECURITY CONSIDERATIONS:
 *    - Serialized data can be modified externally
 *    - Sensitive information should be marked transient
 *    - Consider encryption for sensitive serialized data
 *    - Validate deserialized objects for integrity
 * 
 * 9. PERFORMANCE CONSIDERATIONS:
 *    - Serialization is relatively slow
 *    - Creates overhead for object graphs
 *    - Consider alternatives (JSON, Protocol Buffers) for performance-critical apps
 *    - Use transient for fields that can be recalculated
 * 
 * 10. ALTERNATIVES TO JAVA SERIALIZATION:
 *     - JSON (Jackson, Gson)
 *     - XML
 *     - Protocol Buffers
 *     - Apache Avro
 *     - Kryo
 * 
 * 11. COMMON USE CASES:
 *     - Saving object state to files
 *     - Sending objects over network (RMI, etc.)
 *     - Caching objects
 *     - Deep copying objects
 *     - Session persistence in web applications
 * 
 * 12. BEST PRACTICES:
 *     - Always declare serialVersionUID explicitly
 *     - Mark sensitive/temporary fields as transient
 *     - Test with different class versions
 *     - Use try-with-resources for stream management
 *     - Consider custom serialization for complex objects
 *     - Document serialization behavior
 *     - Be careful with singleton patterns
 * 
 * To compile and run:
 * javac Serialization.java
 * java Serialization
 */