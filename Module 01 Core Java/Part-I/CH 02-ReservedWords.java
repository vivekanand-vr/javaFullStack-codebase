/*
 * Understanding Reserved Words (Keywords) in Java
 */

/*
 * Reserved words are predefined words in Java that have special meanings
 * and cannot be used as identifiers (variable names, method names, class names).
 * 
 * Java has 50 reserved words divided into different categories:
 * 1. Access Modifiers: public, private, protected
 * 2. Class/Method/Variable Modifiers: static, final, abstract, synchronized, etc.
 * 3. Control Flow: if, else, switch, case, default, for, while, do, break, continue
 * 4. Data Types: boolean, byte, char, short, int, long, float, double, void
 * 5. Exception Handling: try, catch, finally, throw, throws
 * 6. Object-Oriented: class, interface, extends, implements, super, this
 * 7. Package/Import: package, import
 * 8. Others: new, return, instanceof, native, strictfp, transient, volatile
 * 
 * Reserved literals: true, false, null
 * Unused reserved words: const, goto
 */

public class ReservedWords {
    
    // Class-level variables demonstrating access modifiers
    public String publicVar = "Accessible everywhere";
    private String privateVar = "Only within this class";
    protected String protectedVar = "Within package and subclasses";
    
    // Static and final modifiers
    public static final String CONSTANT = "This is a constant";
    public static int staticCounter = 0;
    
    public static void main(String[] args) {
        System.out.println("1. Access Modifiers and Variable Modifiers:");
        
        ReservedWords obj = new ReservedWords();
        System.out.println("Public variable: " + obj.publicVar);
        // System.out.println(obj.privateVar); // This would cause compilation error
        System.out.println("Protected variable: " + obj.protectedVar);
        System.out.println("Static constant: " + CONSTANT);
        
        // 2. Data Type Keywords
        System.out.println("\n2. Data Type Keywords:");
        
        boolean booleanVar = true;
        byte byteVar = 127;
        char charVar = 'A';
        short shortVar = 32767;
        int intVar = 2147483647;
        long longVar = 9223372036854775807L;
        float floatVar = 3.14f;
        double doubleVar = 3.14159265359;
        
        System.out.println("boolean: " + booleanVar);
        System.out.println("byte: " + byteVar);
        System.out.println("char: " + charVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);
        
        // 3. Control Flow Keywords
        System.out.println("\n3. Control Flow Keywords:");
        
        // if-else
        if (intVar > 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is not positive");
        }
        
        // switch-case-default
        switch (charVar) {
            case 'A':
                System.out.println("Character is A");
                break;
            case 'B':
                System.out.println("Character is B");
                break;
            default:
                System.out.println("Character is something else");
                break;
        }
        
        // for loop
        System.out.println("For loop with break and continue:");
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                continue; // Skip iteration when i = 3
            }
            if (i == 7) {
                break; // Exit loop when i = 7
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // while loop
        System.out.println("While loop:");
        int count = 0;
        while (count < 3) {
            System.out.println("Count: " + count);
            count++;
        }
        
        // do-while loop
        System.out.println("Do-while loop:");
        int num = 0;
        do {
            System.out.println("Number: " + num);
            num++;
        } while (num < 2);
        
        // 4. Object-Oriented Keywords
        System.out.println("\n4. Object-Oriented Keywords:");
        
        // new keyword
        String str = new String("Created using new keyword");
        System.out.println(str);
        
        // instanceof keyword
        if (str instanceof String) {
            System.out.println("str is an instance of String");
        }
        
        // this keyword (demonstrated in method)
        obj.demonstrateThis();
        
        // 5. Exception Handling Keywords
        System.out.println("\n5. Exception Handling Keywords:");
        
        try {
            int result = 10 / 2; // This won't throw exception
            System.out.println("Division result: " + result);
            
            // This would throw an exception
            // int error = 10 / 0;
            
        } catch (ArithmeticException e) {
            System.out.println("Caught arithmetic exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }
        
        // 6. Return keyword
        System.out.println("\n6. Return keyword:");
        int sum = calculateSum(5, 10);
        System.out.println("Sum: " + sum);
        
        // 7. Reserved Literals
        System.out.println("\n7. Reserved Literals:");
        System.out.println("true: " + true);
        System.out.println("false: " + false);
        System.out.println("null: " + null);
    }
    
    // Method demonstrating 'this' keyword
    public void demonstrateThis() {
        String privateVar = "Local variable"; // Same name as instance variable
        System.out.println("Local variable: " + privateVar);
        System.out.println("Instance variable using 'this': " + this.privateVar);
    }
    
    // Method demonstrating 'return' keyword
    public static int calculateSum(int a, int b) {
        return a + b; // return keyword sends value back to caller
    }
}

/*
 * Important Notes about Reserved Words:
 * 
 * 1. Case-sensitive: 'if' is reserved, but 'If' or 'IF' are not
 * 2. Cannot be used as:
 *    - Variable names
 *    - Method names
 *    - Class names
 *    - Package names
 * 3. 'const' and 'goto' are reserved but not used in Java
 * 4. Some words like 'String' are not reserved words but are predefined classes
 * 5. Always use meaningful names that don't conflict with reserved words
 * 
 * Common Mistakes:
 * - Using 'class' as variable name: int class = 10; // ERROR
 * - Using 'public' as method name: void public() {} // ERROR
 * - Case matters: int If = 10; // This is valid (capital I)
 */