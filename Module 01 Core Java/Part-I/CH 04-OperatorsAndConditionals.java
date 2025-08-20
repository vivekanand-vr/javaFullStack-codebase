/*
 * Understanding Operators and Conditional Statements in Java
 */

/*
 * Java Operators are classified into several categories:
 * 
 * 1. Arithmetic Operators: +, -, *, /, %, ++, --
 * 2. Relational Operators: ==, !=, >, <, >=, <=
 * 3. Logical Operators: &&, ||, !
 * 4. Assignment Operators: =, +=, -=, *=, /=, %=
 * 5. Bitwise Operators: &, |, ^, ~, <<, >>, >>>
 * 6. Ternary Operator: ? :
 * 7. instanceof Operator
 * 
 * Conditional Statements:
 * 1. if statement
 * 2. if-else statement
 * 3. if-else-if ladder
 * 4. switch statement
 * 5. Ternary operator (conditional operator)
 */

public class OperatorsAndConditionals {
    
    public static void main(String[] args) {
        
        // 1. Arithmetic Operators
        System.out.println("1. Arithmetic Operators:");
        
        int a = 15;
        int b = 4;
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Addition (a + b): " + (a + b));
        System.out.println("Subtraction (a - b): " + (a - b));
        System.out.println("Multiplication (a * b): " + (a * b));
        System.out.println("Division (a / b): " + (a / b)); // Integer division
        System.out.println("Modulus (a % b): " + (a % b)); // Remainder
        
        // Floating point division
        double c = 15.0;
        double d = 4.0;
        System.out.println("Float Division (15.0 / 4.0): " + (c / d));
        
        // Increment and Decrement operators
        System.out.println("\nIncrement/Decrement Operators:");
        int x = 10;
        System.out.println("Original x: " + x);
        System.out.println("x++ (post-increment): " + (x++)); // Uses value then increments
        System.out.println("After post-increment, x: " + x);
        System.out.println("++x (pre-increment): " + (++x)); // Increments then uses value
        System.out.println("x-- (post-decrement): " + (x--));
        System.out.println("--x (pre-decrement): " + (--x));
        
        // 2. Relational (Comparison) Operators
        System.out.println("\n2. Relational Operators:");
        
        int num1 = 10;
        int num2 = 20;
        
        System.out.println("num1 = " + num1 + ", num2 = " + num2);
        System.out.println("num1 == num2: " + (num1 == num2));
        System.out.println("num1 != num2: " + (num1 != num2));
        System.out.println("num1 > num2: " + (num1 > num2));
        System.out.println("num1 < num2: " + (num1 < num2));
        System.out.println("num1 >= num2: " + (num1 >= num2));
        System.out.println("num1 <= num2: " + (num1 <= num2));
        
        // 3. Logical Operators
        System.out.println("\n3. Logical Operators:");
        
        boolean p = true;
        boolean q = false;
        
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("p && q (AND): " + (p && q)); // Both must be true
        System.out.println("p || q (OR): " + (p || q));  // At least one must be true
        System.out.println("!p (NOT): " + (!p));         // Negation
        System.out.println("!q (NOT): " + (!q));
        
        // Short-circuit evaluation
        System.out.println("\nShort-circuit Evaluation:");
        int y = 5;
        // In this expression, second condition won't be evaluated if first is false
        boolean result = (y > 10) && (++y > 0);
        System.out.println("Result: " + result + ", y after: " + y); // y remains 5
        
        // 4. Assignment Operators
        System.out.println("\n4. Assignment Operators:");
        
        int value = 10;
        System.out.println("Original value: " + value);
        
        value += 5; // value = value + 5
        System.out.println("After value += 5: " + value);
        
        value -= 3; // value = value - 3
        System.out.println("After value -= 3: " + value);
        
        value *= 2; // value = value * 2
        System.out.println("After value *= 2: " + value);
        
        value /= 4; // value = value / 4
        System.out.println("After value /= 4: " + value);
        
        value %= 3; // value = value % 3
        System.out.println("After value %= 3: " + value);
        
        // 5. Ternary Operator
        System.out.println("\n5. Ternary Operator:");
        
        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Age: " + age + ", Status: " + status);
        
        // Nested ternary
        int score = 85;
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : (score >= 70) ? "C" : "F";
        System.out.println("Score: " + score + ", Grade: " + grade);
        
        // 6. Conditional Statements - if, if-else
        System.out.println("\n6. if and if-else Statements:");
        
        int temperature = 25;
        
        // Simple if
        if (temperature > 30) {
            System.out.println("It's hot today!");
        }
        
        // if-else
        if (temperature > 25) {
            System.out.println("Weather is warm");
        } else {
            System.out.println("Weather is cool");
        }
        
        // if-else-if ladder
        if (temperature > 35) {
            System.out.println("Extremely hot");
        } else if (temperature > 25) {
            System.out.println("Hot");
        } else if (temperature > 15) {
            System.out.println("Pleasant");
        } else {
            System.out.println("Cold");
        }
        
        // 7. Switch Statement
        System.out.println("\n7. Switch Statement:");
        
        int dayOfWeek = 3;
        String dayName;
        
        switch (dayOfWeek) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }
        System.out.println("Day " + dayOfWeek + " is " + dayName);
        
        // Switch with String (Java 7+)
        String month = "January";
        int daysInMonth;
        
        switch (month) {
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
                daysInMonth = 31;
                break;
            case "April":
            case "June":
            case "September":
            case "November":
                daysInMonth = 30;
                break;
            case "February":
                daysInMonth = 28; // Not considering leap year
                break;
            default:
                daysInMonth = 0;
                break;
        }
        System.out.println(month + " has " + daysInMonth + " days");
        
        // 8. Bitwise Operators (Bonus)
        System.out.println("\n8. Bitwise Operators:");
        
        int m = 12; // Binary: 1100
        int n = 10; // Binary: 1010
        
        System.out.println("m = " + m + " (binary: " + Integer.toBinaryString(m) + ")");
        System.out.println("n = " + n + " (binary: " + Integer.toBinaryString(n) + ")");
        System.out.println("m & n (AND): " + (m & n)); // 1000 = 8
        System.out.println("m | n (OR): " + (m | n));  // 1110 = 14
        System.out.println("m ^ n (XOR): " + (m ^ n)); // 0110 = 6
        System.out.println("~m (NOT): " + (~m));       // Bitwise complement
        System.out.println("m << 1 (Left Shift): " + (m << 1)); // 11000 = 24
        System.out.println("m >> 1 (Right Shift): " + (m >> 1)); // 110 = 6
        
        // 9. instanceof Operator
        System.out.println("\n9. instanceof Operator:");
        
        String text = "Hello World";
        Object obj = text;
        
        System.out.println("text instanceof String: " + (text instanceof String));
        System.out.println("obj instanceof String: " + (obj instanceof String));
        System.out.println("obj instanceof Object: " + (obj instanceof Object));
        
        // 10. Operator Precedence Example
        System.out.println("\n10. Operator Precedence:");
        
        int result1 = 5 + 3 * 2;        // Multiplication first: 5 + 6 = 11
        int result2 = (5 + 3) * 2;      // Parentheses first: 8 * 2 = 16
        boolean bool = 5 > 3 && 2 < 4;  // Relational then logical
        
        System.out.println("5 + 3 * 2 = " + result1);
        System.out.println("(5 + 3) * 2 = " + result2);
        System.out.println("5 > 3 && 2 < 4 = " + bool);
    }
}

/*
 * Operator Precedence (Highest to Lowest):
 * 1. Postfix: ++, --
 * 2. Unary: ++, --, +, -, !, ~
 * 3. Multiplicative: *, /, %
 * 4. Additive: +, -
 * 5. Shift: <<, >>, >>>
 * 6. Relational: <, >, <=, >=, instanceof
 * 7. Equality: ==, !=
 * 8. Bitwise AND: &
 * 9. Bitwise XOR: ^
 * 10. Bitwise OR: |
 * 11. Logical AND: &&
 * 12. Logical OR: ||
 * 13. Ternary: ? :
 * 14. Assignment: =, +=, -=, *=, /=, %=
 * 
 * Key Points:
 * 1. Use parentheses to make expressions clear
 * 2. Logical operators use short-circuit evaluation
 * 3. == compares references for objects, use .equals() for content
 * 4. Switch statements require break to avoid fall-through
 * 5. Ternary operator is useful for simple conditional assignments
 */