/*
 * Understanding Exception Handling in Java
 */

/*
 * Exception handling in Java is a powerful mechanism to handle runtime errors
 * and maintain normal application flow. Exceptions are events that disrupt the
 * normal flow of program execution.
 * 
 * Java exception hierarchy:
 * - Throwable (top-level class)
 *   - Error (system-level errors, usually not handled)
 *   - Exception
 *     - RuntimeException (unchecked exceptions)
 *     - Other exceptions (checked exceptions)
 * 
 * Key concepts:
 * - try-catch-finally blocks
 * - throw and throws keywords
 * - Custom exceptions
 * - Exception propagation
 */

import java.io.*;
import java.util.*;

public class ExceptionHandling {
    
    public static void main(String[] args) {
        System.out.println("1. Exception Handling Examples:");
        
        // 1. Basic try-catch
        System.out.println("\n1. Basic Try-Catch:");
        basicTryCatch();
        
        // 2. Multiple catch blocks
        System.out.println("\n2. Multiple Catch Blocks:");
        multipleCatchBlocks();
        
        // 3. Finally block
        System.out.println("\n3. Finally Block:");
        finallyBlockExample();
        
        // 4. Try with resources
        System.out.println("\n4. Try-with-Resources:");
        tryWithResources();
        
        // 5. Throwing exceptions
        System.out.println("\n5. Throwing Exceptions:");
        throwingExceptions();
        
        // 6. Custom exceptions
        System.out.println("\n6. Custom Exceptions:");
        customExceptions();
        
        // 7. Exception propagation
        System.out.println("\n7. Exception Propagation:");
        exceptionPropagation();
        
        // 8. Best practices
        System.out.println("\n8. Best Practices:");
        bestPractices();
    }
    
    // 1. Basic Try-Catch
    public static void basicTryCatch() {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing index 2: " + numbers[2]); // Valid
            System.out.println("Accessing index 5: " + numbers[5]); // This will throw exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
            System.out.println("Array index is out of bounds!");
        }
        
        System.out.println("Program continues after exception handling");
    }
    
    // 2. Multiple Catch Blocks
    public static void multipleCatchBlocks() {
        String[] data = {"10", "20", "abc", "40"};
        
        for (String item : data) {
            try {
                int number = Integer.parseInt(item);
                int result = 100 / number;
                System.out.println("100 / " + number + " = " + result);
            } catch (NumberFormatException e) {
                System.out.println("'" + item + "' is not a valid number");
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero");
            } catch (Exception e) {
                // Generic catch block (should be last)
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
    
    // 3. Finally Block
    public static void finallyBlockExample() {
        FileWriter writer = null;
        
        try {
            writer = new FileWriter("temp.txt");
            writer.write("Hello, Exception Handling!");
            System.out.println("File written successfully");
            
            // Simulate an exception
            int result = 10 / 0; // This will throw ArithmeticException
            
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        } finally {
            // This block always executes
            System.out.println("Finally block executed - cleaning up resources");
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing writer: " + e.getMessage());
            }
        }
        
        System.out.println("Method completed");
    }
    
    // 4. Try-with-Resources (Java 7+)
    public static void tryWithResources() {
        // Resources are automatically closed
        try (FileWriter writer = new FileWriter("temp2.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            
            bufferedWriter.write("Try-with-resources example");
            bufferedWriter.newLine();
            bufferedWriter.write("Resources are auto-closed");
            System.out.println("File written using try-with-resources");
            
        } catch (IOException e) {
            System.out.println("IO Exception in try-with-resources: " + e.getMessage());
        }
        // No need for finally block - resources auto-closed
    }
    
    // 5. Throwing Exceptions
    public static void throwingExceptions() {
        try {
            validateAge(15);
            validateAge(25);
            validateAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
    
    public static void validateAge(int age) {
        System.out.println("Validating age: " + age);
        
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older");
        }
        
        System.out.println("Age " + age + " is valid");
    }
    
    // 6. Custom Exceptions
    public static void customExceptions() {
        BankAccount account = new BankAccount(1000.0);
        
        try {
            account.withdraw(500.0);  // Valid withdrawal
            account.withdraw(600.0);  // This will throw custom exception
        } catch (InsufficientFundsException e) {
            System.out.println("Banking error: " + e.getMessage());
            System.out.println("Available balance: $" + e.getAvailableBalance());
        }
    }
    
    // 7. Exception Propagation
    public static void exceptionPropagation() {
        try {
            methodA();
        } catch (IOException e) {
            System.out.println("Caught propagated exception: " + e.getMessage());
        }
    }
    
    public static void methodA() throws IOException {
        System.out.println("In methodA - calling methodB");
        methodB();
    }
    
    public static void methodB() throws IOException {
        System.out.println("In methodB - calling methodC");
        methodC();
    }
    
    public static void methodC() throws IOException {
        System.out.println("In methodC - throwing exception");
        throw new IOException("Exception from methodC - propagated up the call stack");
    }
    
    // 8. Best Practices
    public static void bestPractices() {
        // Good practice: Specific exception handling
        try {
            List<String> list = new ArrayList<>();
            String item = list.get(0); // IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("List is empty - cannot get item at index 0");
            // Log the exception for debugging
            // logger.error("List access error", e);
        }
        
        // Good practice: Resource management
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            props.load(input);
            System.out.println("Properties loaded successfully");
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found - using defaults");
            // Set default properties
            props.setProperty("default.setting", "value");
        } catch (IOException e) {
            System.out.println("Error reading config file: " + e.getMessage());
        }
        
        // Demonstrate exception chaining
        try {
            demonstrateExceptionChaining();
        } catch (ProcessingException e) {
            System.out.println("Processing failed: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Root cause: " + e.getCause().getMessage());
            }
        }
    }
    
    public static void demonstrateExceptionChaining() throws ProcessingException {
        try {
            // Simulate some operation that fails
            throw new NumberFormatException("Invalid number format");
        } catch (NumberFormatException e) {
            // Wrap the original exception
            throw new ProcessingException("Failed to process data", e);
        }
    }
}

// Custom Exception Classes
class InsufficientFundsException extends Exception {
    private double availableBalance;
    
    public InsufficientFundsException(String message, double availableBalance) {
        super(message);
        this.availableBalance = availableBalance;
    }
    
    public double getAvailableBalance() {
        return availableBalance;
    }
}

class ProcessingException extends Exception {
    public ProcessingException(String message) {
        super(message);
    }
    
    public ProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Helper class for custom exception example
class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        System.out.println("Attempting to withdraw: $" + amount);
        
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds: Cannot withdraw $" + amount, balance);
        }
        
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: $" + balance);
    }
    
    public double getBalance() {
        return balance;
    }
}

/*
 * Key Points:
 * 1. Checked exceptions must be caught or declared with throws
 * 2. Unchecked exceptions (RuntimeException) don't require explicit handling
 * 3. finally block always executes, regardless of whether exception occurs
 * 4. try-with-resources automatically closes resources implementing AutoCloseable
 * 5. Multiple catch blocks are evaluated in order - specific exceptions first
 * 6. throw keyword is used to explicitly throw an exception
 * 7. throws keyword declares that a method may throw certain exceptions
 * 8. Custom exceptions should extend Exception (checked) or RuntimeException (unchecked)
 * 9. Exception chaining preserves original exception information
 * 10. Never catch Exception or Throwable unless you have a specific reason
 * 
 * Exception Types:
 * - Checked: IOException, SQLException, ClassNotFoundException
 * - Unchecked: NullPointerException, ArrayIndexOutOfBoundsException, IllegalArgumentException
 * 
 * Best Practices:
 * - Handle exceptions at appropriate level
 * - Don't suppress exceptions without good reason
 * - Use specific exception types rather than generic Exception
 * - Clean up resources properly (use try-with-resources when possible)
 * - Log exceptions for debugging
 * - Don't use exceptions for control flow
 * - Provide meaningful error messages
 * - Consider exception chaining when rethrowing
 */