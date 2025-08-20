/*
 * Understanding the Static Keyword in Java
 */

/*
 * The static keyword belongs to the class rather than any instance of the class.
 * Static members are shared among all instances of the class.
 * 
 * Static can be used with:
 * 1. Variables (Class variables)
 * 2. Methods (Class methods)
 * 3. Blocks (Static initialization blocks)
 * 4. Nested classes
 * 
 * Key Features:
 * - Memory allocated once when class is first loaded
 * - Can be accessed without creating object instance
 * - Accessed using ClassName.memberName
 * - Static methods can only directly access static variables and methods
 * - Cannot use 'this' or 'super' keywords in static context
 */

public class StaticKeyword {
    
    // 1. Static Variables (Class Variables)
    private static int totalStudents = 0;          // Static variable
    private static String schoolName = "ABC School"; // Static variable
    public static final String COUNTRY = "India";   // Static final variable (constant)
    
    // 2. Instance Variables (Non-static)
    private int rollNumber;
    private String studentName;
    private double marks;
    
    // 3. Static Block - executed when class is first loaded
    static {
        System.out.println("Static block executed - Class loaded for first time");
        System.out.println("School Name: " + schoolName);
        System.out.println("Initial total students: " + totalStudents);
        System.out.println("Country: " + COUNTRY);
        System.out.println("=".repeat(50));
    }
    
    // 4. Constructor
    public StaticKeyword(int rollNumber, String studentName, double marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
        totalStudents++; // Increment static variable for each object created
        System.out.println("Student created: " + studentName + " (Total students: " + totalStudents + ")");
    }
    
    // 5. Static Methods
    public static void displaySchoolInfo() {
        System.out.println("=== School Information ===");
        System.out.println("School Name: " + schoolName);
        System.out.println("Country: " + COUNTRY);
        System.out.println("Total Students: " + totalStudents);
        // Note: Cannot access non-static variables directly in static method
        // System.out.println(rollNumber); // This would cause compile error
    }
    
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    public static void setSchoolName(String name) {
        schoolName = name;
    }
    
    public static String getSchoolName() {
        return schoolName;
    }
    
    // 6. Static method to compare two students
    public static void compareMarks(StaticKeyword student1, StaticKeyword student2) {
        System.out.println("=== Comparing Students ===");
        System.out.println(student1.studentName + " has marks: " + student1.marks);
        System.out.println(student2.studentName + " has marks: " + student2.marks);
        
        if (student1.marks > student2.marks) {
            System.out.println(student1.studentName + " has higher marks");
        } else if (student2.marks > student1.marks) {
            System.out.println(student2.studentName + " has higher marks");
        } else {
            System.out.println("Both students have equal marks");
        }
    }
    
    // 7. Instance Methods (Non-static)
    public void displayStudentInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + studentName);
        System.out.println("Marks: " + marks);
        System.out.println("School: " + schoolName); // Can access static variable
        System.out.println("Total Students in School: " + totalStudents); // Can access static variable
    }
    
    public void callStaticMethod() {
        // Instance method can call static method
        displaySchoolInfo();
    }
    
    // Getters and Setters
    public int getRollNumber() { return rollNumber; }
    public String getStudentName() { return studentName; }
    public double getMarks() { return marks; }
    
    public void setMarks(double marks) { this.marks = marks; }
    
    // 8. Static nested class example
    static class SchoolUtility {
        public static void printSeparator() {
            System.out.println("*".repeat(60));
        }
        
        public static double calculatePercentage(double marks, double totalMarks) {
            return (marks / totalMarks) * 100;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Static Keyword Examples ===\n");
        
        // 1. Accessing static variables and methods without creating objects
        System.out.println("1. Accessing static members without objects:");
        System.out.println("Initial school name: " + StaticKeyword.getSchoolName());
        System.out.println("Initial total students: " + StaticKeyword.getTotalStudents());
        StaticKeyword.displaySchoolInfo();
        
        StaticKeyword.SchoolUtility.printSeparator();
        
        // 2. Creating objects and observing static variable changes
        System.out.println("\n2. Creating objects and observing static variable changes:");
        StaticKeyword student1 = new StaticKeyword(101, "Alice", 85.5);
        StaticKeyword student2 = new StaticKeyword(102, "Bob", 78.0);
        StaticKeyword student3 = new StaticKeyword(103, "Charlie", 92.3);
        
        StaticKeyword.SchoolUtility.printSeparator();
        
        // 3. Displaying individual student information
        System.out.println("\n3. Individual Student Information:");
        student1.displayStudentInfo();
        System.out.println();
        student2.displayStudentInfo();
        System.out.println();
        student3.displayStudentInfo();
        
        StaticKeyword.SchoolUtility.printSeparator();
        
        // 4. Static method calls
        System.out.println("\n4. Static Method Calls:");
        StaticKeyword.displaySchoolInfo();
        StaticKeyword.compareMarks(student1, student3);
        
        StaticKeyword.SchoolUtility.printSeparator();
        
        // 5. Modifying static variable affects all objects
        System.out.println("\n5. Modifying static variable affects all objects:");
        System.out.println("Before changing school name:");
        student1.displayStudentInfo();
        
        StaticKeyword.setSchoolName("XYZ International School");
        System.out.println("\nAfter changing school name:");
        student1.displayStudentInfo();
        student2.displayStudentInfo();
        
        StaticKeyword.SchoolUtility.printSeparator();
        
        // 6. Using static nested class
        System.out.println("\n6. Using Static Nested Class:");
        double percentage1 = StaticKeyword.SchoolUtility.calculatePercentage(student1.getMarks(), 100);
        double percentage2 = StaticKeyword.SchoolUtility.calculatePercentage(student2.getMarks(), 100);
        double percentage3 = StaticKeyword.SchoolUtility.calculatePercentage(student3.getMarks(), 100);
        
        System.out.println(student1.getStudentName() + " percentage: " + percentage1 + "%");
        System.out.println(student2.getStudentName() + " percentage: " + percentage2 + "%");
        System.out.println(student3.getStudentName() + " percentage: " + percentage3 + "%");
        
        StaticKeyword.SchoolUtility.printSeparator();
        
        // 7. Demonstrating static variable shared nature
        System.out.println("\n7. Demonstrating shared nature of static variables:");
        System.out.println("Total students from different objects:");
        System.out.println("From student1 object: " + StaticKeyword.getTotalStudents());
        System.out.println("From student2 object: " + StaticKeyword.getTotalStudents());
        System.out.println("From class directly: " + StaticKeyword.getTotalStudents());
        
        // 8. Creating more objects to see static variable increment
        System.out.println("\n8. Creating more objects:");
        StaticKeyword student4 = new StaticKeyword(104, "David", 88.7);
        StaticKeyword student5 = new StaticKeyword(105, "Emma", 94.2);
        
        System.out.println("Final total students: " + StaticKeyword.getTotalStudents());
        StaticKeyword.displaySchoolInfo();
    }
}

/*
 * Key Points about Static Keyword:
 * 
 * 1. Memory Management:
 *    - Static members loaded when class is first referenced
 *    - Stored in method area (not heap)
 *    - Single copy shared by all instances
 * 
 * 2. Static Variables:
 *    - Also called class variables
 *    - Initialized only once when class is loaded
 *    - Common to all objects of the class
 * 
 * 3. Static Methods:
 *    - Can be called without creating object
 *    - Cannot access non-static variables directly
 *    - Cannot use 'this' or 'super' keywords
 *    - Can only call other static methods directly
 * 
 * 4. Static Blocks:
 *    - Executed when class is first loaded
 *    - Used for complex static variable initialization
 *    - Executed before main method
 * 
 * 5. Usage Guidelines:
 *    - Use static for utility methods that don't depend on object state
 *    - Use static variables for constants or counters
 *    - Avoid overusing static as it can make code less flexible
 *    - Static methods are good for factory methods and utility functions
 * 
 * 6. Common Examples:
 *    - Math.sqrt(), Math.max() - utility methods
 *    - System.out.println() - static variable out in System class
 *    - String.valueOf() - static method for conversion
 */