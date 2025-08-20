/*
 * Understanding Comparable and Comparator in Java
 */

/*
 * Comparable and Comparator are interfaces used for sorting objects in Java.
 * 
 * Comparable Interface:
 * - Part of java.lang package
 * - Contains single method: compareTo(T o)
 * - Provides natural ordering for objects
 * - Object compares itself with another object
 * - Implemented by the class whose objects need to be sorted
 * 
 * Comparator Interface:
 * - Part of java.util package  
 * - Contains method: compare(T o1, T o2)
 * - Provides custom ordering logic
 * - External comparison logic
 * - Separate class implements Comparator
 * - Multiple sorting orders possible
 * 
 * When to use:
 * - Comparable: Single, natural way to sort objects
 * - Comparator: Multiple ways to sort, or when you can't modify the class
 */

import java.util.*;
import java.util.stream.Collectors;

// 1. Class implementing Comparable
class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double gpa;
    private int age;
    
    public Student(int id, String name, double gpa, int age) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    
    // Natural ordering by GPA (descending)
    @Override
    public int compareTo(Student other) {
        // Compare by GPA in descending order
        return Double.compare(other.gpa, this.gpa);
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }
    
    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', gpa=%.2f, age=%d}", 
                           id, name, gpa, age);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// 2. Separate Comparator classes
class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}

class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}

// 3. Class without Comparable (for Comparator examples)
class Employee {
    private int empId;
    private String name;
    private double salary;
    private String department;
    
    public Employee(int empId, String name, double salary, String department) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    
    // Getters
    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return String.format("Employee{empId=%d, name='%s', salary=%.2f, dept='%s'}", 
                           empId, name, salary, department);
    }
}

public class ComparableComparatorExample {
    
    public static void main(String[] args) {
        System.out.println("1. Comparable Interface Examples:");
        comparableExamples();
        
        System.out.println("\n2. Comparator Interface Examples:");
        comparatorExamples();
        
        System.out.println("\n3. Lambda Expressions with Comparator:");
        lambdaComparatorExamples();
        
        System.out.println("\n4. Method References with Comparator:");
        methodReferenceExamples();
        
        System.out.println("\n5. Complex Comparator Examples:");
        complexComparatorExamples();
        
        System.out.println("\n6. Comparator Utility Methods:");
        comparatorUtilityMethods();
    }
    
    public static void comparableExamples() {
        // Create list of students
        List<Student> students = Arrays.asList(
            new Student(1, "Alice", 3.8, 20),
            new Student(2, "Bob", 3.5, 22),
            new Student(3, "Charlie", 3.9, 19),
            new Student(4, "Diana", 3.7, 21)
        );
        
        System.out.println("Before sorting:");
        students.forEach(System.out::println);
        
        // Sort using natural ordering (Comparable)
        Collections.sort(students);
        // Or students.sort(null); // null means natural ordering
        
        System.out.println("\nAfter sorting by GPA (natural ordering):");
        students.forEach(System.out::println);
        
        // Binary search (requires sorted list)
        Student searchStudent = new Student(0, "", 3.7, 0);
        int index = Collections.binarySearch(students, searchStudent);
        System.out.println("\nBinary search for GPA 3.7: " + 
                         (index >= 0 ? "Found at index " + index : "Not found"));
    }
    
    public static void comparatorExamples() {
        List<Student> students = Arrays.asList(
            new Student(1, "Alice", 3.8, 20),
            new Student(2, "Bob", 3.5, 22),
            new Student(3, "Charlie", 3.9, 19),
            new Student(4, "Diana", 3.7, 21)
        );
        
        // Sort by name using custom Comparator
        Collections.sort(students, new StudentNameComparator());
        System.out.println("Sorted by name:");
        students.forEach(System.out::println);
        
        // Sort by age using custom Comparator
        Collections.sort(students, new StudentAgeComparator());
        System.out.println("\nSorted by age:");
        students.forEach(System.out::println);
        
        // Reverse order
        Collections.sort(students, Collections.reverseOrder(new StudentNameComparator()));
        System.out.println("\nSorted by name (reverse):");
        students.forEach(System.out::println);
    }
    
    public static void lambdaComparatorExamples() {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "John", 75000, "IT"),
            new Employee(102, "Sarah", 80000, "Finance"),
            new Employee(103, "Mike", 70000, "IT"),
            new Employee(104, "Anna", 85000, "HR")
        );
        
        System.out.println("Original list:");
        employees.forEach(System.out::println);
        
        // Lambda expressions for different sorting criteria
        
        // Sort by salary
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("\nSorted by salary:");
        employees.forEach(System.out::println);
        
        // Sort by name (case-insensitive)
        employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        System.out.println("\nSorted by name:");
        employees.forEach(System.out::println);
        
        // Sort by department, then by salary
        employees.sort((e1, e2) -> {
            int deptComparison = e1.getDepartment().compareTo(e2.getDepartment());
            if (deptComparison != 0) {
                return deptComparison;
            }
            return Double.compare(e2.getSalary(), e1.getSalary()); // Desc salary
        });
        System.out.println("\nSorted by department, then by salary (desc):");
        employees.forEach(System.out::println);
    }
    
    public static void methodReferenceExamples() {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "John", 75000, "IT"),
            new Employee(102, "Sarah", 80000, "Finance"),
            new Employee(103, "Mike", 70000, "IT"),
            new Employee(104, "Anna", 85000, "HR")
        );
        
        // Using Comparator.comparing() with method references
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("Sorted by name (method reference):");
        employees.forEach(System.out::println);
        
        // Sort by salary in descending order
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        System.out.println("\nSorted by salary (descending):");
        employees.forEach(System.out::println);
        
        // Sort by department, then by name
        employees.sort(Comparator.comparing(Employee::getDepartment)
                                .thenComparing(Employee::getName));
        System.out.println("\nSorted by department, then by name:");
        employees.forEach(System.out::println);
    }
    
    public static void complexComparatorExamples() {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "John", 75000, "IT"),
            new Employee(102, "Sarah", 80000, "Finance"),
            new Employee(103, "Mike", 70000, "IT"),
            new Employee(104, "Anna", 85000, "HR"),
            new Employee(105, "David", 75000, "IT")
        );
        
        // Complex sorting: Department (asc), Salary (desc), Name (asc)
        Comparator<Employee> complexComparator = 
            Comparator.comparing(Employee::getDepartment)
                     .thenComparing(Employee::getSalary, Comparator.reverseOrder())
                     .thenComparing(Employee::getName);
        
        employees.sort(complexComparator);
        System.out.println("Complex sorting (Dept asc, Salary desc, Name asc):");
        employees.forEach(System.out::println);
        
        // Null-safe comparator
        List<Employee> employeesWithNull = new ArrayList<>(employees);
        employeesWithNull.add(new Employee(106, null, 60000, "IT"));
        
        Comparator<Employee> nullSafeComparator = 
            Comparator.comparing(Employee::getName, 
                               Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER));
        
        employeesWithNull.sort(nullSafeComparator);
        System.out.println("\nNull-safe sorting by name:");
        employeesWithNull.forEach(System.out::println);
    }
    
    public static void comparatorUtilityMethods() {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "John", 75000, "IT"),
            new Employee(102, "Sarah", 80000, "Finance"),
            new Employee(103, "Mike", 70000, "IT"),
            new Employee(104, "Anna", 85000, "HR")
        );
        
        // naturalOrder() and reverseOrder()
        List<String> names = employees.stream()
                                    .map(Employee::getName)
                                    .sorted(Comparator.naturalOrder())
                                    .collect(Collectors.toList());
        System.out.println("Names in natural order: " + names);
        
        names.sort(Comparator.reverseOrder());
        System.out.println("Names in reverse order: " + names);
        
        // nullsFirst() and nullsLast()
        List<String> namesWithNull = Arrays.asList("Alice", null, "Bob", "Charlie", null);
        
        namesWithNull.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("With nulls first: " + namesWithNull);
        
        namesWithNull.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("With nulls last: " + namesWithNull);
        
        // comparing() with key extractor
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("\nSorted by salary using comparingDouble:");
        employees.forEach(System.out::println);
        
        // comparingInt() example
        employees.sort(Comparator.comparingInt(Employee::getEmpId).reversed());
        System.out.println("\nSorted by employee ID (reversed):");
        employees.forEach(System.out::println);
    }
}

/*
 * Key Points:
 *  1. Comparable provides natural ordering (single way to sort)
 *  2. Comparator provides custom ordering (multiple ways to sort)
 *  3. Comparable.compareTo() returns: negative (less), zero (equal), positive (greater)
 *  4. Comparator.compare() follows same return value convention
 *  5. Always override equals() when implementing Comparable
 *  6. Use Comparator when you can't modify the class or need multiple sorting orders
 *  7. Lambda expressions make Comparator implementations more concise
 *  8. Comparator provides utility methods: comparing(), thenComparing(), reversed()
 *  9. Method references work well with Comparator.comparing()
 *  10. Null-safe comparators: nullsFirst(), nullsLast()
 * 
 * Comparable vs Comparator:
 *  ┌─────────────────┬──────────────────┬───────────────────┐
 *  │     Aspect      │   Comparable     │    Comparator     │
 *  ├─────────────────┼──────────────────┼───────────────────┤
 *  │ Package         │ java.lang        │ java.util         │
 *  │ Method          │ compareTo()      │ compare()         │
 *  │ Sorting logic   │ In same class    │ Separate class    │
 *  │ Modification    │ Modify class     │ No class change   │
 *  │ Multiple sorts  │ Single way       │ Multiple ways     │
 *  │ Collections API │ sort(list)       │ sort(list, comp)  │
 *  └─────────────────┴──────────────────┴───────────────────┘
 * 
 * Best Practices:
 *  - Use Comparable for natural/default ordering
 *  - Use Comparator for custom or multiple orderings
 *  - Prefer lambda expressions over anonymous classes
 *  - Chain comparators using thenComparing() for complex sorting
 *  - Handle null values appropriately
 *  - Be consistent with equals() when implementing Comparable
 *  - Use specific comparing methods: comparingInt(), comparingDouble(), etc.
 *  - Consider performance for frequently used comparators
 */