/*
 * Understanding Strings in Java
 */

/*
 * String in Java is a sequence of characters and is one of the most commonly used classes.
 * 
 * Key Features:
 * - Strings are immutable (cannot be changed after creation)
 * - Stored in String Pool in heap memory for efficiency
 * - String class provides many built-in methods
 * - String literals are automatically interned
 * 
 * String Classes in Java:
 * 1. String - Immutable, thread-safe
 * 2. StringBuilder - Mutable, not thread-safe, better performance
 * 3. StringBuffer - Mutable, thread-safe, synchronized methods
 * 
 * String Creation:
 * - String literal: String str = "Hello";
 * - Using new keyword: String str = new String("Hello");
 * - Character array: String str = new String(charArray);
 */

public class Strings {
    
    public static void main(String[] args) {
        System.out.println("=== String Examples in Java ===\n");
        
        // 1. String Creation and Basic Operations
        System.out.println("1. String Creation and Basic Operations:");
        String str1 = "Hello"; // String literal
        String str2 = new String("Hello"); // Using new keyword
        String str3 = "Hello"; // Another string literal
        
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        
        System.out.println("str1 == str2: " + (str1 == str2)); // false (different objects)
        System.out.println("str1 == str3: " + (str1 == str3)); // true (same reference from pool)
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true (same content)
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 2. String Immutability Demonstration
        System.out.println("2. String Immutability:");
        String original = "Java";
        String modified = original.concat(" Programming");
        
        System.out.println("Original string: " + original); // Still "Java"
        System.out.println("Modified string: " + modified); // "Java Programming"
        System.out.println("Original unchanged: " + original.equals("Java"));
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 3. String Methods - Length and Character Access
        System.out.println("3. String Methods - Length and Character Access:");
        String text = "Java Programming Language";
        
        System.out.println("Text: " + text);
        System.out.println("Length: " + text.length());
        System.out.println("Character at index 5: " + text.charAt(5));
        System.out.println("First character: " + text.charAt(0));
        System.out.println("Last character: " + text.charAt(text.length() - 1));
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 4. String Methods - Case Conversion
        System.out.println("4. Case Conversion Methods:");
        String mixedCase = "Java Programming";
        
        System.out.println("Original: " + mixedCase);
        System.out.println("Uppercase: " + mixedCase.toUpperCase());
        System.out.println("Lowercase: " + mixedCase.toLowerCase());
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 5. String Methods - Substring and Searching
        System.out.println("5. Substring and Searching Methods:");
        String sentence = "Learning Java is fun and exciting";
        
        System.out.println("Original: " + sentence);
        System.out.println("Substring(9): " + sentence.substring(9));
        System.out.println("Substring(9,13): " + sentence.substring(9, 13));
        System.out.println("Index of 'Java': " + sentence.indexOf("Java"));
        System.out.println("Index of 'Python': " + sentence.indexOf("Python"));
        System.out.println("Last index of 'a': " + sentence.lastIndexOf("a"));
        System.out.println("Contains 'fun': " + sentence.contains("fun"));
        System.out.println("Starts with 'Learning': " + sentence.startsWith("Learning"));
        System.out.println("Ends with 'exciting': " + sentence.endsWith("exciting"));
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 6. String Methods - Replacement and Trimming
        System.out.println("6. Replacement and Trimming Methods:");
        String messyText = "  Hello World, Hello Java, Hello Programming  ";
        
        System.out.println("Original: '" + messyText + "'");
        System.out.println("Trimmed: '" + messyText.trim() + "'");
        System.out.println("Replace 'Hello' with 'Hi': " + messyText.replace("Hello", "Hi"));
        System.out.println("Replace first 'Hello' with 'Hi': " + messyText.replaceFirst("Hello", "Hi"));
        System.out.println("Replace all digits: " + "abc123def456".replaceAll("\\d", "X"));
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 7. String Comparison Methods
        System.out.println("7. String Comparison Methods:");
        String s1 = "Apple";
        String s2 = "apple";
        String s3 = "Banana";
        String s4 = "Apple";
        
        System.out.println("s1: " + s1 + ", s2: " + s2 + ", s3: " + s3 + ", s4: " + s4);
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equalsIgnoreCase(s2): " + s1.equalsIgnoreCase(s2));
        System.out.println("s1.equals(s4): " + s1.equals(s4));
        System.out.println("s1.compareTo(s3): " + s1.compareTo(s3)); // Negative (Apple < Banana)
        System.out.println("s3.compareTo(s1): " + s3.compareTo(s1)); // Positive (Banana > Apple)
        System.out.println("s1.compareTo(s4): " + s1.compareTo(s4)); // Zero (equal)
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 8. String Split and Join
        System.out.println("8. String Split and Join:");
        String csvData = "apple,banana,orange,grape,mango";
        String[] fruits = csvData.split(",");
        
        System.out.println("Original CSV: " + csvData);
        System.out.println("Split result:");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("  [" + i + "] = " + fruits[i]);
        }
        
        // Join array elements
        String joined = String.join(" | ", fruits);
        System.out.println("Joined with ' | ': " + joined);
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 9. String Conversion Methods
        System.out.println("9. String Conversion Methods:");
        int number = 12345;
        double decimal = 123.456;
        boolean flag = true;
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        
        System.out.println("Number to String: " + String.valueOf(number));
        System.out.println("Decimal to String: " + String.valueOf(decimal));
        System.out.println("Boolean to String: " + String.valueOf(flag));
        System.out.println("Char array to String: " + String.valueOf(charArray));
        System.out.println("String to char array: " + java.util.Arrays.toString("Hello".toCharArray()));
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 10. StringBuilder Examples
        System.out.println("10. StringBuilder Examples:");
        demonstrateStringBuilder();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 11. StringBuffer Examples
        System.out.println("11. StringBuffer Examples:");
        demonstrateStringBuffer();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 12. Performance Comparison
        System.out.println("12. Performance Comparison:");
        compareStringPerformance();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 13. String Pool Demonstration
        System.out.println("13. String Pool Demonstration:");
        demonstrateStringPool();
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // 14. String Formatting
        System.out.println("14. String Formatting:");
        demonstrateStringFormatting();
    }
    
    // StringBuilder demonstration
    public static void demonstrateStringBuilder() {
        StringBuilder sb = new StringBuilder();
        
        // Appending different types
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.append(" ");
        sb.append(2024);
        
        System.out.println("StringBuilder result: " + sb.toString());
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
        
        // Insert at specific position
        sb.insert(6, "Beautiful ");
        System.out.println("After insert: " + sb.toString());
        
        // Replace part of string
        sb.replace(6, 15, "Amazing");
        System.out.println("After replace: " + sb.toString());
        
        // Delete characters
        sb.delete(6, 13);
        System.out.println("After delete: " + sb.toString());
        
        // Reverse string
        sb.reverse();
        System.out.println("After reverse: " + sb.toString());
        sb.reverse(); // Reverse back
        
        // Convert to String
        String finalString = sb.toString();
        System.out.println("Final String: " + finalString);
    }
    
    // StringBuffer demonstration
    public static void demonstrateStringBuffer() {
        StringBuffer sbf = new StringBuffer("Java");
        
        System.out.println("Initial StringBuffer: " + sbf);
        
        // Append operations
        sbf.append(" is");
        sbf.append(" awesome!");
        System.out.println("After appends: " + sbf);
        
        // Insert operation
        sbf.insert(4, " Programming");
        System.out.println("After insert: " + sbf);
        
        // Replace operation
        sbf.replace(17, 24, "great");
        System.out.println("After replace: " + sbf);
        
        // Delete operation
        sbf.delete(4, 16);
        System.out.println("After delete: " + sbf);
        
        System.out.println("Length: " + sbf.length());
        System.out.println("Capacity: " + sbf.capacity());
        
        // StringBuffer is synchronized (thread-safe)
        System.out.println("StringBuffer is thread-safe and synchronized");
    }
    
    // Performance comparison
    public static void compareStringPerformance() {
        int iterations = 10000;
        
        // String concatenation (slow)
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a";
        }
        long stringTime = System.currentTimeMillis() - startTime;
        
        // StringBuilder (fast)
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        String sbResult = sb.toString();
        long sbTime = System.currentTimeMillis() - startTime;
        
        // StringBuffer (moderate - due to synchronization)
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("a");
        }
        String sbfResult = sbf.toString();
        long sbfTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Performance for " + iterations + " concatenations:");
        System.out.println("String concatenation: " + stringTime + " ms");
        System.out.println("StringBuilder: " + sbTime + " ms");
        System.out.println("StringBuffer: " + sbfTime + " ms");
        System.out.println("Result lengths - String: " + str.length() + 
                          ", StringBuilder: " + sbResult.length() + 
                          ", StringBuffer: " + sbfResult.length());
    }
    
    // String pool demonstration
    public static void demonstrateStringPool() {
        // String literals go to string pool
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = new String("Hello").intern(); // Force to string pool
        
        System.out.println("String Pool Analysis:");
        System.out.println("s1 == s2 (both literals): " + (s1 == s2)); // true
        System.out.println("s1 == s3 (literal vs new): " + (s1 == s3)); // false
        System.out.println("s1 == s4 (literal vs interned): " + (s1 == s4)); // true
        System.out.println("s1.equals(s3) (content comparison): " + s1.equals(s3)); // true
        
        // Memory locations
        System.out.println("\nMemory Analysis:");
        System.out.println("s1 hashCode: " + System.identityHashCode(s1));
        System.out.println("s2 hashCode: " + System.identityHashCode(s2));
        System.out.println("s3 hashCode: " + System.identityHashCode(s3));
        System.out.println("s4 hashCode: " + System.identityHashCode(s4));
    }
    
    // String formatting demonstration
    public static void demonstrateStringFormatting() {
        String name = "Alice";
        int age = 25;
        double salary = 75000.50;
        
        // Using String.format()
        String formatted1 = String.format("Name: %s, Age: %d, Salary: $%.2f", name, age, salary);
        System.out.println("String.format(): " + formatted1);
        
        // Using printf
        System.out.print("System.printf(): ");
        System.out.printf("Name: %s, Age: %d, Salary: $%.2f%n", name, age, salary);
        
        // Different format specifiers
        System.out.println("\nFormat Specifiers Examples:");
        System.out.printf("Integer: %d%n", 42);
        System.out.printf("Float: %.2f%n", 3.14159);
        System.out.printf("String: %s%n", "Hello");
        System.out.printf("Character: %c%n", 'A');
        System.out.printf("Boolean: %b%n", true);
        System.out.printf("Hexadecimal: %x%n", 255);
        System.out.printf("Scientific notation: %e%n", 1234.567);
        
        // Width and alignment
        System.out.println("\nWidth and Alignment:");
        System.out.printf("Right aligned: '%10s'%n", "Java");
        System.out.printf("Left aligned: '%-10s'%n", "Java");
        System.out.printf("Zero padded: '%08d'%n", 42);
    }
}

/*
 * Key Points about Strings in Java:
 * 
 * 1. String Immutability:
 *    - Once created, String objects cannot be modified
 *    - String methods return new String objects
 *    - Provides thread safety and enables string pool optimization
 * 
 * 2. String Pool:
 *    - Special memory area in heap for string literals
 *    - Identical string literals share the same memory location
 *    - Use intern() method to add strings to pool
 * 
 * 3. String vs StringBuilder vs StringBuffer:
 *    - String: Immutable, thread-safe, slower for multiple operations
 *    - StringBuilder: Mutable, not thread-safe, faster performance
 *    - StringBuffer: Mutable, thread-safe, moderate performance
 * 
 * 4. String Comparison:
 *    - Use equals() for content comparison
 *    - Use == for reference comparison
 *    - Use equalsIgnoreCase() for case-insensitive comparison
 *    - Use compareTo() for lexicographical comparison
 * 
 * 5. Common String Methods:
 *    - length(), charAt(), substring()
 *    - toUpperCase(), toLowerCase(), trim()
 *    - indexOf(), contains(), startsWith(), endsWith()
 *    - replace(), split(), join()
 * 
 * 6. Performance Tips:
 *    - Use StringBuilder for multiple concatenations
 *    - Use string literals instead of new String()
 *    - Consider StringBuffer for thread-safe operations
 *    - Use intern() judiciously to manage memory
 * 
 * 7. Best Practices:
 *    - Always use equals() for string comparison
 *    - Handle null strings properly
 *    - Use StringBuilder for building strings in loops
 *    - Consider memory implications of large strings
 */