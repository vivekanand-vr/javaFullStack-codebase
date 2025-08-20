/*
 * Understanding Data Types in Java
 */

/*
 * Java has two categories of data types:
 * 
 * 1. Primitive Data Types (8 types):
 *    - boolean: true/false (1 bit)
 *    - byte: -128 to 127 (8 bits)
 *    - short: -32,768 to 32,767 (16 bits)
 *    - int: -2,147,483,648 to 2,147,483,647 (32 bits)
 *    - long: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 (64 bits)
 *    - float: Single precision floating point (32 bits)
 *    - double: Double precision floating point (64 bits)
 *    - char: Single Unicode character (16 bits)
 * 
 * 2. Non-Primitive (Reference) Data Types:
 *    - String, Arrays, Classes, Interfaces
 *    - These store references to memory locations
 */

public class DataTypes {
    
    public static void main(String[] args) {
        
        // 1. Boolean Data Type
        System.out.println("1. Boolean Data Type:");
        boolean isJavaFun = true;
        boolean isHard = false;
        boolean result = isJavaFun && !isHard;
        
        System.out.println("Is Java fun? " + isJavaFun);
        System.out.println("Is Java hard? " + isHard);
        System.out.println("Java is fun and not hard: " + result);
        
        // 2. Integer Data Types
        System.out.println("\n2. Integer Data Types:");
        
        // byte: smallest integer type
        byte byteMin = -128;
        byte byteMax = 127;
        byte byteExample = 100;
        System.out.println("byte range: " + byteMin + " to " + byteMax);
        System.out.println("byte example: " + byteExample);
        
        // short: 16-bit integer
        short shortMin = -32768;
        short shortMax = 32767;
        short shortExample = 1000;
        System.out.println("short range: " + shortMin + " to " + shortMax);
        System.out.println("short example: " + shortExample);
        
        // int: most commonly used integer type
        int intMin = -2147483648;
        int intMax = 2147483647;
        int intExample = 100000;
        System.out.println("int range: " + intMin + " to " + intMax);
        System.out.println("int example: " + intExample);
        
        // long: largest integer type (needs L suffix)
        long longMin = -9223372036854775808L;
        long longMax = 9223372036854775807L;
        long longExample = 10000000000L; // Note the L suffix
        System.out.println("long range: " + longMin + " to " + longMax);
        System.out.println("long example: " + longExample);
        
        // 3. Floating Point Data Types
        System.out.println("\n3. Floating Point Data Types:");
        
        // float: single precision (needs f suffix)
        float floatExample = 3.14159f; // Note the f suffix
        float floatScientific = 1.23e-4f; // Scientific notation
        System.out.println("float example: " + floatExample);
        System.out.println("float scientific: " + floatScientific);
        
        // double: double precision (default for decimals)
        double doubleExample = 3.14159265359;
        double doubleScientific = 1.23e-10; // No suffix needed
        System.out.println("double example: " + doubleExample);
        System.out.println("double scientific: " + doubleScientific);
        
        // 4. Character Data Type
        System.out.println("\n4. Character Data Type:");
        
        char charLetter = 'A';
        char charDigit = '5';
        char charSymbol = '@';
        char charUnicode = '\u0041'; // Unicode for 'A'
        char charAscii = 65; // ASCII value for 'A'
        
        System.out.println("char letter: " + charLetter);
        System.out.println("char digit: " + charDigit);
        System.out.println("char symbol: " + charSymbol);
        System.out.println("char unicode: " + charUnicode);
        System.out.println("char ASCII: " + charAscii);
        
        // 5. Type Conversion and Casting
        System.out.println("\n5. Type Conversion and Casting:");
        
        // Implicit conversion (widening)
        int intValue = 100;
        long longFromInt = intValue; // Automatic conversion
        float floatFromInt = intValue; // Automatic conversion
        
        System.out.println("Original int: " + intValue);
        System.out.println("Converted to long: " + longFromInt);
        System.out.println("Converted to float: " + floatFromInt);
        
        // Explicit casting (narrowing)
        double doubleValue = 9.78;
        int intFromDouble = (int) doubleValue; // Explicit cast (loses decimal)
        float floatValue = 10.5f;
        byte byteFromFloat = (byte) floatValue; // Explicit cast
        
        System.out.println("Original double: " + doubleValue);
        System.out.println("Cast to int: " + intFromDouble);
        System.out.println("Original float: " + floatValue);
        System.out.println("Cast to byte: " + byteFromFloat);
        
        // 6. Non-Primitive Data Types
        System.out.println("\n6. Non-Primitive Data Types:");
        
        // String
        String greeting = "Hello, World!";
        String name = new String("Java");
        System.out.println("String greeting: " + greeting);
        System.out.println("String name: " + name);
        
        // Arrays
        int[] numbers = {1, 2, 3, 4, 5};
        String[] languages = {"Java", "Python", "C++", "JavaScript"};
        
        System.out.println("Integer array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        System.out.println("String array:");
        for (String lang : languages) {
            System.out.print(lang + " ");
        }
        System.out.println();
        
        // 7. Default Values
        System.out.println("\n7. Default Values for Instance Variables:");
        DefaultValuesDemo demo = new DefaultValuesDemo();
        demo.printDefaults();
        
        // 8. Overflow and Underflow Examples
        System.out.println("\n8. Overflow and Underflow:");
        
        // Integer overflow
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Max int: " + maxInt);
        System.out.println("Max int + 1: " + (maxInt + 1)); // Wraps to minimum
        
        // Integer underflow
        int minInt = Integer.MIN_VALUE;
        System.out.println("Min int: " + minInt);
        System.out.println("Min int - 1: " + (minInt - 1)); // Wraps to maximum
        
        // 9. Special Values
        System.out.println("\n9. Special Floating Point Values:");
        
        double positiveInfinity = Double.POSITIVE_INFINITY;
        double negativeInfinity = Double.NEGATIVE_INFINITY;
        double notANumber = Double.NaN;
        
        System.out.println("Positive infinity: " + positiveInfinity);
        System.out.println("Negative infinity: " + negativeInfinity);
        System.out.println("Not a Number: " + notANumber);
        
        // Creating these values
        double divideByZero = 1.0 / 0.0; // Positive infinity
        double zeroByZero = 0.0 / 0.0; // NaN
        
        System.out.println("1.0 / 0.0 = " + divideByZero);
        System.out.println("0.0 / 0.0 = " + zeroByZero);
    }
}

// Helper class to demonstrate default values
class DefaultValuesDemo {
    // Instance variables get default values automatically
    boolean defaultBoolean;    // false
    byte defaultByte;         // 0
    short defaultShort;       // 0
    int defaultInt;           // 0
    long defaultLong;         // 0L
    float defaultFloat;       // 0.0f
    double defaultDouble;     // 0.0
    char defaultChar;         // '\u0000' (null character)
    String defaultString;     // null
    
    public void printDefaults() {
        System.out.println("Default boolean: " + defaultBoolean);
        System.out.println("Default byte: " + defaultByte);
        System.out.println("Default short: " + defaultShort);
        System.out.println("Default int: " + defaultInt);
        System.out.println("Default long: " + defaultLong);
        System.out.println("Default float: " + defaultFloat);
        System.out.println("Default double: " + defaultDouble);
        System.out.println("Default char ASCII: " + (int) defaultChar);
        System.out.println("Default String: " + defaultString);
    }
}

/*
 * Key Points about Java Data Types:
 * 
 * 1. Primitive types store actual values, reference types store addresses
 * 2. All primitive types have wrapper classes (Boolean, Byte, Short, Integer, etc.)
 * 3. Local variables don't get default values - must be initialized before use
 * 4. Instance and static variables get default values automatically
 * 5. Use appropriate data types to save memory and avoid overflow
 * 6. float needs 'f' suffix, long needs 'L' suffix for literals
 * 7. char can store Unicode characters (0 to 65,535)
 * 8. String is not primitive - it's a class
 * 
 * Memory Usage:
 * boolean: 1 bit, byte: 1 byte, short: 2 bytes, int: 4 bytes
 * long: 8 bytes, float: 4 bytes, double: 8 bytes, char: 2 bytes
 */