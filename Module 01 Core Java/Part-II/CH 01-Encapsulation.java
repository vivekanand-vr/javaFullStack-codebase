/*
 * ENCAPSULATION
 * ==============
 * Encapsulation is one of the four fundamental principles of Object-Oriented Programming (OOP).
 * It refers to bundling data (variables) and methods that operate on that data into a single unit (class),
 * and restricting direct access to some of the object's components.
 * 
 * Key Concepts:
 * - Data Hiding: Making instance variables private
 * - Access Control: Using access modifiers (private, protected, public)
 * - Getter and Setter Methods: Controlled access to private variables
 * - Validation: Adding checks in setter methods
 * 
 * Benefits:
 * - Data Security: Prevents unauthorized access and modification
 * - Code Maintainability: Changes to internal implementation don't affect external code
 * - Flexibility: Can add validation, logging, or other logic in getter/setter methods
 * - Control: Can make properties read-only, write-only, or read-write
 */

// Example 1: Basic Encapsulation - Bank Account
class BankAccount {
    // Private instance variables (data hiding)
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        // Validation in constructor
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Warning: Negative initial balance not allowed. Set to 0.");
        }
    }
    
    // Getter methods (Accessors) - Controlled read access
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    // Setter methods (Mutators) - Controlled write access with validation
    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName != null && !accountHolderName.trim().isEmpty()) {
            this.accountHolderName = accountHolderName;
        } else {
            System.out.println("Error: Account holder name cannot be empty.");
        }
    }
    
    public void setAccountType(String accountType) {
        if (accountType != null && (accountType.equals("Savings") || 
            accountType.equals("Current") || accountType.equals("Fixed"))) {
            this.accountType = accountType;
        } else {
            System.out.println("Error: Invalid account type. Allowed: Savings, Current, Fixed");
        }
    }
    
    // Note: No direct setter for balance and accountNumber (they should be modified through specific operations)
    
    // Business methods with validation
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ". New balance: $" + balance);
            return true;
        } else {
            System.out.println("Error: Deposit amount must be positive.");
            return false;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount + ". New balance: $" + balance);
                return true;
            } else {
                System.out.println("Error: Insufficient funds. Current balance: $" + balance);
                return false;
            }
        } else {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        }
    }
    
    public void displayAccountInfo() {
        System.out.println("=== Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
    }
}

// Example 2: Advanced Encapsulation - Student with Grade Management
class Student {
    // Private fields
    private int studentId;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private double[] grades;
    private int gradeCount;
    private static final int MAX_GRADES = 10;
    
    // Constructor
    public Student(int studentId, String firstName, String lastName, int age, String email) {
        this.studentId = studentId;
        setFirstName(firstName); // Using setter for validation
        setLastName(lastName);
        setAge(age);
        setEmail(email);
        this.grades = new double[MAX_GRADES];
        this.gradeCount = 0;
    }
    
    // Getters
    public int getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public int getGradeCount() { return gradeCount; }
    
    // Derived property (computed from other data)
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    // Setters with validation
    public void setFirstName(String firstName) {
        if (firstName != null && firstName.trim().length() >= 2) {
            this.firstName = firstName.trim();
        } else {
            System.out.println("Error: First name must be at least 2 characters long.");
        }
    }
    
    public void setLastName(String lastName) {
        if (lastName != null && lastName.trim().length() >= 2) {
            this.lastName = lastName.trim();
        } else {
            System.out.println("Error: Last name must be at least 2 characters long.");
        }
    }
    
    public void setAge(int age) {
        if (age >= 16 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Error: Age must be between 16 and 100.");
        }
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email.toLowerCase();
        } else {
            System.out.println("Error: Invalid email format.");
        }
    }
    
    // Methods to manage grades
    public boolean addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            if (gradeCount < MAX_GRADES) {
                grades[gradeCount] = grade;
                gradeCount++;
                System.out.println("Grade " + grade + " added successfully.");
                return true;
            } else {
                System.out.println("Error: Maximum number of grades reached.");
                return false;
            }
        } else {
            System.out.println("Error: Grade must be between 0 and 100.");
            return false;
        }
    }
    
    // Read-only access to grades (returning copy to prevent modification)
    public double[] getGrades() {
        double[] gradeCopy = new double[gradeCount];
        System.arraycopy(grades, 0, gradeCopy, 0, gradeCount);
        return gradeCopy;
    }
    
    public double getAverageGrade() {
        if (gradeCount == 0) return 0.0;
        
        double sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return sum / gradeCount;
    }
    
    public char getLetterGrade() {
        double avg = getAverageGrade();
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }
    
    public void displayStudentInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + getFullName());
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Number of grades: " + gradeCount);
        System.out.println("Average grade: " + String.format("%.2f", getAverageGrade()));
        System.out.println("Letter grade: " + getLetterGrade());
    }
}

// Example 3: Encapsulation with different access levels
class Employee {
    // Different access modifiers demonstration
    public String department;           // Public - accessible everywhere
    protected String position;          // Protected - accessible in same package and subclasses
    String projectName;                 // Package-private - accessible in same package
    private double salary;              // Private - accessible only within this class
    private final int employeeId;       // Final field - cannot be changed after initialization
    
    // Private static variable - shared among all instances but not directly accessible
    private static int totalEmployees = 0;
    
    public Employee(int employeeId, String department, String position, String projectName, double salary) {
        this.employeeId = employeeId;
        this.department = department;
        this.position = position;
        this.projectName = projectName;
        setSalary(salary);
        totalEmployees++;
    }
    
    // Getter for private final field (read-only)
    public int getEmployeeId() {
        return employeeId;
    }
    
    // Getter and setter for salary with business logic
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        if (salary >= 30000 && salary <= 200000) {
            this.salary = salary;
            System.out.println("Salary updated to: $" + salary);
        } else {
            System.out.println("Error: Salary must be between $30,000 and $200,000");
        }
    }
    
    // Method to give raise with percentage validation
    public void giveRaise(double percentage) {
        if (percentage > 0 && percentage <= 50) {
            double increase = salary * (percentage / 100);
            salary += increase;
            System.out.println("Raise of " + percentage + "% granted. New salary: $" + salary);
        } else {
            System.out.println("Error: Raise percentage must be between 0% and 50%");
        }
    }
    
    // Static method to access private static variable
    public static int getTotalEmployees() {
        return totalEmployees;
    }
    
    // Method with different access levels for internal operations
    private void calculateTax() {
        // Private method - internal business logic
        double tax = salary * 0.25;
        System.out.println("Calculated tax: $" + tax);
    }
    
    protected void generatePayslip() {
        // Protected method - can be used by subclasses
        System.out.println("=== Payslip for Employee " + employeeId + " ===");
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        System.out.println("Gross Salary: $" + salary);
        calculateTax(); // Calling private method
    }
    
    public void displayPublicInfo() {
        System.out.println("=== Public Employee Information ===");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        // Note: Not displaying salary (private information)
    }
}

public class Encapsulation {
    
    public static void main(String[] args) {
        System.out.println("=== Encapsulation Examples in Java ===\n");
        
        // 1. Bank Account Example
        System.out.println("1. Bank Account Encapsulation:");
        BankAccount account = new BankAccount("ACC001", "John Doe", 1000.0, "Savings");
        account.displayAccountInfo();
        
        System.out.println("\n--- Account Operations ---");
        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(2000.0); // Should fail
        account.deposit(-100.0);  // Should fail
        
        System.out.println("\n--- Attempting to modify account details ---");
        account.setAccountHolderName("John Smith");
        account.setAccountType("Current");
        account.setAccountType("Invalid"); // Should fail
        account.displayAccountInfo();
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // 2. Student Example
        System.out.println("2. Student Encapsulation:");
        Student student = new Student(12345, "Alice", "Johnson", 20, "alice.johnson@email.com");
        student.displayStudentInfo();
        
        System.out.println("\n--- Adding grades ---");
        student.addGrade(85.5);
        student.addGrade(92.0);
        student.addGrade(78.5);
        student.addGrade(88.0);
        student.addGrade(95.5);
        student.addGrade(105.0); // Should fail
        student.addGrade(-10.0); // Should fail
        
        System.out.println("\n--- Updated student information ---");
        student.displayStudentInfo();
        
        // Accessing grades safely (getting a copy)
        double[] grades = student.getGrades();
        System.out.print("Individual grades: ");
        for (double grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
        
        System.out.println("\n--- Attempting to modify student details ---");
        student.setAge(22);
        student.setEmail("alice.smith@newemail.com");
        student.setFirstName("A"); // Should fail
        student.setAge(150); // Should fail
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // 3. Employee Example - Access Modifiers
        System.out.println("3. Employee Encapsulation - Access Modifiers:");
        Employee emp1 = new Employee(1001, "Engineering", "Software Developer", "ProjectX", 75000);
        Employee emp2 = new Employee(1002, "Marketing", "Marketing Manager", "ProjectY", 65000);
        
        System.out.println("Total employees: " + Employee.getTotalEmployees());
        
        // Accessing public field directly
        System.out.println("Employee 1 department (public): " + emp1.department);
        emp1.department = "Research & Development"; // Can modify public field
        System.out.println("Modified department: " + emp1.department);
        
        // Accessing protected field (within same package)
        System.out.println("Employee 1 position (protected): " + emp1.position);
        
        // Accessing package-private field
        System.out.println("Employee 1 project (package-private): " + emp1.projectName);
        
        // Cannot access private field directly
        // System.out.println(emp1.salary); // This would cause compilation error
        
        // Must use getter for private field
        System.out.println("Employee 1 salary (via getter): $" + emp1.getSalary());
        
        System.out.println("\n--- Employee operations ---");
        emp1.setSalary(80000);
        emp1.giveRaise(10);
        emp1.setSalary(250000); // Should fail
        emp1.giveRaise(60); // Should fail
        
        emp1.displayPublicInfo();
        emp1.generatePayslip(); // Protected method accessible in same package
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // 4. Demonstrating data protection
        System.out.println("4. Data Protection Demonstration:");
        
        // Creating another student to show encapsulation benefits
        Student student2 = new Student(12346, "Bob", "Wilson", 19, "bob@email.com");
        
        // Direct access to private fields is not possible
        // student2.studentId = 99999; // Compilation error
        // student2.grades[0] = 100; // Compilation error
        
        // Must use public methods to interact with object
        System.out.println("Student ID (via getter): " + student2.getStudentId());
        System.out.println("Full name (computed property): " + student2.getFullName());
        
        // Adding grades through controlled method
        student2.addGrade(88.0);
        student2.addGrade(91.5);
        student2.addGrade(87.0);
        
        System.out.println("Average grade: " + student2.getAverageGrade());
        System.out.println("Letter grade: " + student2.getLetterGrade());
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // 5. Demonstrating immutable-like behavior for certain fields
        System.out.println("5. Read-Only Properties:");
        
        // Employee ID is final and cannot be changed
        System.out.println("Employee ID: " + emp1.getEmployeeId());
        // emp1.employeeId = 2000; // Compilation error - final field
        
        // Account number should not be changeable after creation
        System.out.println("Account number: " + account.getAccountNumber());
        // No setter provided for account number - design decision
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // 6. Validation in action
        System.out.println("6. Validation Examples:");
        
        // Creating objects with invalid data
        System.out.println("--- Creating bank account with negative balance ---");
        BankAccount invalidAccount = new BankAccount("ACC002", "Jane Doe", -500.0, "Savings");
        invalidAccount.displayAccountInfo();
        
        System.out.println("\n--- Creating student with invalid data ---");
        Student invalidStudent = new Student(12347, "X", "Y", 15, "invalid-email");
        invalidStudent.displayStudentInfo();
        
        System.out.println("\n--- Employee with invalid salary ---");
        Employee invalidEmployee = new Employee(1003, "HR", "HR Manager", "ProjectZ", 25000);
        invalidEmployee.displayPublicInfo();
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // 7. Benefits of encapsulation demonstration
        System.out.println("7. Benefits of Encapsulation:");
        
        System.out.println("a) Data Security: Private fields cannot be accessed directly");
        System.out.println("b) Validation: Invalid data is rejected by setter methods");
        System.out.println("c) Controlled Access: Can make properties read-only or write-only");
        System.out.println("d) Business Logic: Can add complex logic in getter/setter methods");
        System.out.println("e) Flexibility: Can change internal implementation without affecting external code");
        System.out.println("f) Debugging: Easier to track where data is modified");
        
        // Demonstrating controlled access
        System.out.println("\n--- Controlled Access Examples ---");
        
        // Read-only property example
        System.out.println("Student ID (read-only): " + student.getStudentId());
        
        // Computed property example
        System.out.println("Full name (computed): " + student.getFullName());
        
        // Validated modification example
        System.out.println("Current balance: $" + account.getBalance());
        account.deposit(100); // Goes through validation
        System.out.println("New balance: $" + account.getBalance());
        
        System.out.println("\n--- Final Summary ---");
        System.out.println("Total employees created: " + Employee.getTotalEmployees());
        System.out.println("All operations completed successfully with proper encapsulation!");
    }
}

/*
 * Key Points about Encapsulation:
 * 
 * 1. Data Hiding:
 *    - Make instance variables private
 *    - Prevents direct access from outside the class
 *    - Protects data integrity and maintains object state
 * 
 * 2. Access Modifiers:
 *    - private: Accessible only within the same class
 *    - protected: Accessible within same package and subclasses
 *    - package-private (default): Accessible within same package
 *    - public: Accessible from anywhere
 * 
 * 3. Getter and Setter Methods:
 *    - Getters (accessors): Provide read access to private fields
 *    - Setters (mutators): Provide controlled write access with validation
 *    - Can implement business logic, validation, and logging
 * 
 * 4. Benefits:
 *    - Security: Prevents unauthorized access and modification
 *    - Maintainability: Internal changes don't affect external code
 *    - Flexibility: Can add validation, logging, computation
 *    - Control: Can make fields read-only, write-only, or computed
 *    - Debugging: Easier to track data modifications
 * 
 * 5. Best Practices:
 *    - Keep fields private unless there's a specific reason not to
 *    - Provide public getter/setter methods for controlled access
 *    - Add validation in setter methods
 *    - Use meaningful names for getter/setter methods
 *    - Don't provide setters for fields that shouldn't change
 *    - Return copies of mutable objects to prevent external modification
 * 
 * 6. Common Patterns:
 *    - Read-only properties: Getter only, no setter
 *    - Write-only properties: Setter only, no getter (rare)
 *    - Computed properties: Getter calculates value from other fields
 *    - Validated properties: Setter includes business rule validation
 *    - Immutable objects: No setters, all fields final
 * 
 * 7. Real-world Applications:
 *    - Banking systems: Account balance protection
 *    - User management: Password and email validation
 *    - Configuration objects: Preventing invalid settings
 *    - Data models: Maintaining referential integrity
 *    - APIs: Controlling how data is accessed and modified
 */