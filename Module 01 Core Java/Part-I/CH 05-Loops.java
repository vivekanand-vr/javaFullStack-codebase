/*
 * Understanding Loops in Java
 */

/*
 * Loops allow you to execute a block of code repeatedly.
 * Java provides four types of loops:
 * 
 * 1. for loop: Used when number of iterations is known
 * 2. enhanced for loop (for-each): Used for iterating over arrays/collections
 * 3. while loop: Used when condition is checked before execution
 * 4. do-while loop: Used when condition is checked after execution (executes at least once)
 * 
 * Loop Control Statements:
 * - break: Exits the loop completely
 * - continue: Skips current iteration and moves to next
 * - return: Exits the method (and loop)
 * 
 * Nested loops: Loops inside other loops
 */

public class Loops {
    
    public static void main(String[] args) {
        
        // 1. Basic for Loop
        System.out.println("1. Basic for Loop:");
        
        // Standard for loop syntax: for(initialization; condition; increment/decrement)
        System.out.println("Numbers from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Counting backwards
        System.out.println("Countdown from 5 to 1:");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Different increment values
        System.out.println("Even numbers from 0 to 10:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 2. Enhanced for Loop (for-each)
        System.out.println("\n2. Enhanced for Loop (for-each):");
        
        // With arrays
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Array elements:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // With String array
        String[] fruits = {"Apple", "Banana", "Orange", "Mango"};
        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
        
        // 3. While Loop
        System.out.println("\n3. While Loop:");
        
        // Basic while loop
        int count = 1;
        System.out.println("While loop counting to 5:");
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();
        
        // While loop with different condition
        int factorial = 5;
        int result = 1;
        int temp = factorial;
        System.out.println("Calculating factorial of " + factorial + ":");
        while (temp > 0) {
            result *= temp;
            System.out.println(temp + "! step: " + result);
            temp--;
        }
        System.out.println("Final result: " + factorial + "! = " + result);
        
        // 4. Do-While Loop
        System.out.println("\n4. Do-While Loop:");
        
        // Basic do-while (executes at least once)
        int num = 10;
        System.out.println("Do-while loop (condition false from start):");
        do {
            System.out.println("This will print at least once, num = " + num);
            num++;
        } while (num < 10); // Condition is false, but loop runs once
        
        // Practical do-while example
        int choice = 1;
        System.out.println("Menu simulation with do-while:");
        do {
            System.out.println("Menu option " + choice + " selected");
            choice++;
        } while (choice <= 3);
        
        // 5. Loop Control Statements
        System.out.println("\n5. Loop Control Statements:");
        
        // break statement
        System.out.println("Using break statement:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("Breaking at " + i);
                break; // Exit the loop when i equals 6
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // continue statement
        System.out.println("Using continue statement (skip even numbers):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Skip even numbers
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 6. Nested Loops
        System.out.println("\n6. Nested Loops:");
        
        // Multiplication table
        System.out.println("Multiplication table (3x3):");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print((i * j) + "\t");
            }
            System.out.println(); // New line after each row
        }
        
        // Pattern printing
        System.out.println("Star pattern:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        // 7. Infinite Loops (with break condition)
        System.out.println("\n7. Controlled Infinite Loop:");
        
        int counter = 0;
        while (true) { // Infinite loop
            counter++;
            System.out.println("Iteration: " + counter);
            
            if (counter >= 3) {
                System.out.println("Breaking out of infinite loop");
                break; // Exit condition
            }
        }
        
        // 8. Complex Loop Examples
        System.out.println("\n8. Complex Loop Examples:");
        
        // Finding prime numbers
        System.out.println("Prime numbers between 1 and 20:");
        for (int i = 2; i <= 20; i++) {
            boolean isPrime = true;
            
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break; // Not prime, no need to check further
                }
            }
            
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Sum of digits
        int number = 12345;
        int sum = 0;
        int originalNumber = number;
        
        System.out.println("Sum of digits in " + originalNumber + ":");
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            System.out.println("Digit: " + digit + ", Running sum: " + sum);
            number /= 10;
        }
        System.out.println("Total sum: " + sum);
        
        // 9. Loop with Arrays
        System.out.println("\n9. Loops with Arrays:");
        
        int[] scores = {85, 92, 78, 96, 88};
        
        // Forward iteration
        System.out.println("Scores (forward):");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + scores[i]);
        }
        
        // Backward iteration
        System.out.println("Scores (backward):");
        for (int i = scores.length - 1; i >= 0; i--) {
            System.out.println("Student " + (i + 1) + ": " + scores[i]);
        }
        
        // Finding maximum and minimum
        int max = scores[0];
        int min = scores[0];
        
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
            if (score < min) {
                min = score;
            }
        }
        
        System.out.println("Highest score: " + max);
        System.out.println("Lowest score: " + min);
        
        // 10. Labeled Loops (Breaking out of nested loops)
        System.out.println("\n10. Labeled Loops:");
        
        outerLoop: // Label for outer loop
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.println("i=" + i + ", j=" + j);
                if (i == 2 && j == 2) {
                    System.out.println("Breaking out of both loops");
                    break outerLoop; // Breaks out of the labeled outer loop
                }
            }
        }
        
        System.out.println("Program continues after labeled break");
    }
}

/*
 * Key Points about Loops:
 * 
 * 1. for loop: Best when you know the number of iterations
 * 2. while loop: Best when condition-dependent iteration
 * 3. do-while: Best when you need at least one execution
 * 4. Enhanced for: Best for iterating collections/arrays
 * 
 * Performance Tips:
 * 1. Minimize work inside loops
 * 2. Avoid creating objects inside loops if possible
 * 3. Use enhanced for loop for simple iterations
 * 4. Cache array length in variables for better performance
 * 
 * Common Mistakes:
 * 1. Infinite loops without proper exit conditions
 * 2. Off-by-one errors in loop conditions
 * 3. Modifying loop variable inside the loop body
 * 4. Using wrong loop type for the task
 * 
 * Best Practices:
 * 1. Use meaningful variable names
 * 2. Keep loop bodies simple and focused
 * 3. Use break and continue judiciously
 * 4. Consider using methods to reduce nested loop complexity
 */