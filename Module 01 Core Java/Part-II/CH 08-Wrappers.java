/*
 * Wrapper Classes
 * ----------------
 * Wrapper classes provide a way to use primitive data types as objects
 * They "wrap" primitive values in objects and provide utility methods
 */

import java.util.*;

public class WrapperClassesNotes {
    
    public static void main(String[] args) {
        
        System.out.println("=== WRAPPER CLASSES DEMONSTRATION ===\n");
        
        // 1. BASIC WRAPPER CLASS CREATION
        demonstrateBasicWrapping();
        
        // 2. AUTOBOXING AND UNBOXING
        demonstrateAutoboxingUnboxing();
        
        // 3. UTILITY METHODS
        demonstrateUtilityMethods();
        
        // 4. COLLECTIONS USAGE
        demonstrateCollectionsUsage();
        
        // 5. NULL VALUES AND COMPARISONS
        demonstrateNullAndComparisons();
        
        // 6. PERFORMANCE CONSIDERATIONS
        demonstratePerformanceConsiderations();
    }
    
    /**
     * 1. Basic Wrapper Class Creation and Usage
     */
    private static void demonstrateBasicWrapping() {
        System.out.println("1. BASIC WRAPPER CLASS CREATION:");
        
        // Creating wrapper objects from primitives
        Integer intObj = new Integer(42);           // Deprecated since Java 9
        Integer intObj2 = Integer.valueOf(42);      // Preferred way
        
        Double doubleObj = Double.valueOf(3.14);
        Boolean boolObj = Boolean.valueOf(true);
        Character charObj = Character.valueOf('A');
        
        // Converting back to primitives
        int primitiveInt = intObj.intValue();
        double primitiveDouble = doubleObj.doubleValue();
        boolean primitiveBool = boolObj.booleanValue();
        char primitiveChar = charObj.charValue();
        
        System.out.println("Integer object: " + intObj + ", primitive: " + primitiveInt);
        System.out.println("Double object: " + doubleObj + ", primitive: " + primitiveDouble);
        System.out.println("Boolean object: " + boolObj + ", primitive: " + primitiveBool);
        System.out.println("Character object: " + charObj + ", primitive: " + primitiveChar);
        System.out.println();
    }
    
    /**
     * 2. Autoboxing and Unboxing (Automatic conversion)
     */
    private static void demonstrateAutoboxingUnboxing() {
        System.out.println("2. AUTOBOXING AND UNBOXING:");
        
        // AUTOBOXING: Automatic conversion from primitive to wrapper
        Integer autoBoxed = 100;        // Compiler converts: Integer.valueOf(100)
        Double autoBoxedDouble = 2.5;   // Compiler converts: Double.valueOf(2.5)
        Boolean autoBoxedBool = true;   // Compiler converts: Boolean.valueOf(true)
        
        // UNBOXING: Automatic conversion from wrapper to primitive
        int autoUnboxed = autoBoxed;           // Compiler converts: autoBoxed.intValue()
        double autoUnboxedDouble = autoBoxedDouble;  // autoBoxedDouble.doubleValue()
        boolean autoUnboxedBool = autoBoxedBool;     // autoBoxedBool.booleanValue()
        
        // Mixed operations (autoboxing/unboxing happens automatically)
        Integer result = autoBoxed + 50;  // Unboxing → calculation → autoboxing
        
        System.out.println("Autoboxed Integer: " + autoBoxed);
        System.out.println("Auto-unboxed int: " + autoUnboxed);
        System.out.println("Mixed operation result: " + result);
        
        // In collections (autoboxing is essential here)
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);    // Autoboxing: int → Integer
        numbers.add(20);    // Autoboxing: int → Integer
        
        int first = numbers.get(0);  // Unboxing: Integer → int
        System.out.println("First number from list: " + first);
        System.out.println();
    }
    
    /**
     * 3. Utility Methods provided by Wrapper Classes
     */
    private static void demonstrateUtilityMethods() {
        System.out.println("3. UTILITY METHODS:");
        
        // INTEGER UTILITIES
        System.out.println("Integer Utilities:");
        System.out.println("parseInt('123'): " + Integer.parseInt("123"));
        System.out.println("valueOf('456'): " + Integer.valueOf("456"));
        System.out.println("toString(789): " + Integer.toString(789));
        System.out.println("toBinaryString(8): " + Integer.toBinaryString(8));
        System.out.println("toHexString(255): " + Integer.toHexString(255));
        System.out.println("max(10, 20): " + Integer.max(10, 20));
        System.out.println("min(10, 20): " + Integer.min(10, 20));
        System.out.println();
        
        // DOUBLE UTILITIES
        System.out.println("Double Utilities:");
        System.out.println("parseDouble('3.14'): " + Double.parseDouble("3.14"));
        System.out.println("isNaN(0.0/0.0): " + Double.isNaN(0.0/0.0));
        System.out.println("isInfinite(1.0/0.0): " + Double.isInfinite(1.0/0.0));
        System.out.println("MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("MIN_VALUE: " + Double.MIN_VALUE);
        System.out.println();
        
        // BOOLEAN UTILITIES
        System.out.println("Boolean Utilities:");
        System.out.println("parseBoolean('true'): " + Boolean.parseBoolean("true"));
        System.out.println("parseBoolean('false'): " + Boolean.parseBoolean("false"));
        System.out.println("parseBoolean('yes'): " + Boolean.parseBoolean("yes")); // false
        System.out.println();
        
        // CHARACTER UTILITIES
        System.out.println("Character Utilities:");
        System.out.println("isDigit('5'): " + Character.isDigit('5'));
        System.out.println("isLetter('A'): " + Character.isLetter('A'));
        System.out.println("isWhitespace(' '): " + Character.isWhitespace(' '));
        System.out.println("toUpperCase('a'): " + Character.toUpperCase('a'));
        System.out.println("toLowerCase('Z'): " + Character.toLowerCase('Z'));
        System.out.println();
    }
    
    /**
     * 4. Usage with Collections (Why Wrapper Classes are Important)
     */
    private static void demonstrateCollectionsUsage() {
        System.out.println("4. COLLECTIONS USAGE:");
        
        // Collections can only store objects, not primitives
        // That's why wrapper classes are essential
        
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);  // Autoboxing
        Set<Double> doubleSet = new HashSet<>(Arrays.asList(1.1, 2.2, 3.3));
        Map<String, Boolean> booleanMap = new HashMap<>();
        booleanMap.put("active", true);    // Autoboxing
        booleanMap.put("deleted", false);  // Autoboxing
        
        System.out.println("Integer List: " + integerList);
        System.out.println("Double Set: " + doubleSet);
        System.out.println("Boolean Map: " + booleanMap);
        
        // Stream operations with wrapper classes
        int sum = integerList.stream()
                .mapToInt(Integer::intValue)  // or just .mapToInt(i -> i) due to unboxing
                .sum();
        System.out.println("Sum using streams: " + sum);
        System.out.println();
    }
    
    /**
     * 5. Null Values and Comparisons
     */
    private static void demonstrateNullAndComparisons() {
        System.out.println("5. NULL VALUES AND COMPARISONS:");
        
        // Wrapper classes can be null (primitives cannot)
        Integer nullInteger = null;
        int primitive = 10;
        
        System.out.println("Null wrapper: " + nullInteger);
        // System.out.println("Primitive: " + primitive); // Can't be null
        
        // Comparison considerations
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        
        // Integer caching: -128 to 127 are cached
        System.out.println("a == b (127): " + (a == b));           // true (cached)
        System.out.println("c == d (128): " + (c == d));           // false (not cached)
        System.out.println("c.equals(d): " + c.equals(d));         // true (value comparison)
        
        // Safe comparison with null
        Integer x = null;
        Integer y = 5;
        
        System.out.println("Safe comparison using Objects.equals:");
        System.out.println("Objects.equals(x, y): " + Objects.equals(x, y));  // false
        System.out.println("Objects.equals(x, null): " + Objects.equals(x, null));  // true
        
        // Null pointer exception risk
        try {
            Integer nullValue = null;
            int result = nullValue + 10;  // NullPointerException during unboxing
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
        System.out.println();
    }
    
    /**
     * 6. Performance Considerations
     */
    private static void demonstratePerformanceConsiderations() {
        System.out.println("6. PERFORMANCE CONSIDERATIONS:");
        
        // Primitive vs Wrapper performance comparison
        long startTime, endTime;
        
        // Using primitives (faster)
        startTime = System.nanoTime();
        long sum1 = 0;
        for (int i = 0; i < 1000000; i++) {
            sum1 += i;  // No boxing/unboxing
        }
        endTime = System.nanoTime();
        long primitiveTime = endTime - startTime;
        
        // Using wrappers (slower due to boxing/unboxing)
        startTime = System.nanoTime();
        Long sum2 = 0L;
        for (Integer i = 0; i < 1000000; i++) {
            sum2 += i;  // Boxing and unboxing overhead
        }
        endTime = System.nanoTime();
        long wrapperTime = endTime - startTime;
        
        System.out.println("Primitive operation time: " + primitiveTime + " nanoseconds");
        System.out.println("Wrapper operation time: " + wrapperTime + " nanoseconds");
        System.out.println("Wrapper is ~" + (wrapperTime / primitiveTime) + "x slower");
        
        // Memory usage
        System.out.println("\nMemory Usage:");
        System.out.println("int primitive: 4 bytes");
        System.out.println("Integer wrapper: ~16 bytes (object overhead + value)");
        System.out.println();
    }
}

/*
 * ==================== WRAPPER CLASSES SUMMARY ====================
 * 
 * 1. PRIMITIVE TO WRAPPER MAPPING:
 *    byte    → Byte
 *    short   → Short
 *    int     → Integer
 *    long    → Long
 *    float   → Float
 *    double  → Double
 *    boolean → Boolean
 *    char    → Character
 * 
 * 2. WHY USE WRAPPER CLASSES:
 *    - Collections can only store objects, not primitives
 *    - Provide utility methods (parsing, conversion, validation)
 *    - Can represent null values
 *    - Required for generics (List<Integer>, not List<int>)
 *    - Object-oriented programming benefits
 * 
 * 3. AUTOBOXING/UNBOXING (Java 5+):
 *    - Autoboxing: Automatic conversion from primitive to wrapper
 *    - Unboxing: Automatic conversion from wrapper to primitive
 *    - Happens automatically in assignments, method calls, expressions
 * 
 * 4. INTEGER CACHING:
 *    - Integer values from -128 to 127 are cached
 *    - Same object reference returned for same value in this range
 *    - Use .equals() for value comparison, not ==
 * 
 * 5. COMMON UTILITY METHODS:
 *    - parseXxx(String): Convert string to primitive
 *    - valueOf(): Create wrapper from primitive or string
 *    - toString(): Convert to string representation
 *    - xxxValue(): Convert wrapper to primitive
 *    - compareTo(): Compare wrapper objects
 * 
 * 6. BEST PRACTICES:
 *    - Use primitives when possible for better performance
 *    - Use wrappers for collections and when null values are needed
 *    - Always use .equals() for value comparison of wrappers
 *    - Be careful with null values when unboxing
 *    - Use valueOf() instead of new WrapperClass() (deprecated)
 * 
 * 7. PERFORMANCE NOTES:
 *    - Primitives are faster and use less memory
 *    - Wrappers have object creation and garbage collection overhead
 *    - Autoboxing/unboxing can impact performance in loops
 *    - Consider using primitive collections (e.g., TIntList from Trove)
 * 
 * 8. NULL SAFETY:
 *    - Wrapper classes can be null, primitives cannot
 *    - Unboxing null wrapper throws NullPointerException
 *    - Use Objects.equals() for null-safe comparison
 *    - Consider Optional<T> for potentially null values
 */