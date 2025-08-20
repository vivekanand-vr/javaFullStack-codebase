/*
 * Varargs
 * -------
 * Varargs allow methods to accept variable number of arguments of the same type
 * Introduced in Java 5, provides flexibility in method calls
 */

import java.util.*;

public class VarargsNotes {
    
    public static void main(String[] args) {
        System.out.println("=== VARARGS DEMONSTRATION ===\n");
        
        // 1. BASIC VARARGS USAGE
        demonstrateBasicVarargs();
        
        // 2. VARARGS WITH OTHER PARAMETERS
        demonstrateVarargsWithOtherParams();
        
        // 3. VARARGS INTERNALLY (Array behavior)
        demonstrateVarargsInternals();
        
        // 4. COMMON USE CASES
        demonstrateCommonUseCases();
    }
    
    /**
     * 1. Basic Varargs Usage
     */
    private static void demonstrateBasicVarargs() {
        System.out.println("1. BASIC VARARGS:");
        
        // Method calls with different number of arguments
        printNumbers();                    // No arguments
        printNumbers(1);                   // One argument
        printNumbers(1, 2, 3);            // Multiple arguments
        printNumbers(1, 2, 3, 4, 5);      // Even more arguments
        
        // String varargs
        printStrings("Hello");
        printStrings("Java", "Varargs", "Example");
        System.out.println();
    }
    
    // Varargs method for integers
    public static void printNumbers(int... numbers) {
        System.out.print("Numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("(Total: " + numbers.length + ")");
    }
    
    // Varargs method for strings
    public static void printStrings(String... strings) {
        System.out.print("Strings: ");
        for (String str : strings) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
    
    /**
     * 2. Varargs with Other Parameters
     */
    private static void demonstrateVarargsWithOtherParams() {
        System.out.println("2. VARARGS WITH OTHER PARAMETERS:");
        
        // Varargs must be the last parameter
        calculateSum("Addition", 1, 2, 3, 4, 5);
        calculateSum("Quick Sum", 10, 20);
        
        formatMessage("User %s logged in at %s", "John", "10:30 AM");
        System.out.println();
    }
    
    // Method with regular parameter + varargs
    public static void calculateSum(String operation, int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println(operation + " result: " + sum);
    }
    
    // String formatting with varargs
    public static void formatMessage(String template, Object... args) {
        String result = String.format(template, args);
        System.out.println("Formatted: " + result);
    }
    
    /**
     * 3. Varargs Internals - Understanding Array Behavior
     */
    private static void demonstrateVarargsInternals() {
        System.out.println("3. VARARGS INTERNALS:");
        
        // Varargs are actually arrays internally
        showVarargsAsArray(1, 2, 3, 4);
        
        // Can pass array directly
        int[] array = {10, 20, 30};
        showVarargsAsArray(array);
        
        // Empty varargs
        showVarargsAsArray();
        System.out.println();
    }
    
    public static void showVarargsAsArray(int... numbers) {
        System.out.println("Varargs is array: " + (numbers instanceof int[]));
        System.out.println("Array length: " + numbers.length);
        System.out.println("Array contents: " + Arrays.toString(numbers));
        System.out.println();
    }
    
    /**
     * 4. Common Use Cases
     */
    private static void demonstrateCommonUseCases() {
        System.out.println("4. COMMON USE CASES:");
        
        // Math operations
        System.out.println("Max of (5,2,8,1): " + findMax(5, 2, 8, 1));
        System.out.println("Min of (5,2,8,1): " + findMin(5, 2, 8, 1));
        
        // Collection creation
        List<String> colors = createList("Red", "Green", "Blue");
        System.out.println("Created list: " + colors);
        
        // Logger-style methods
        log("INFO", "Application started successfully");
        log("ERROR", "Database connection failed", "Retrying in 5 seconds");
        System.out.println();
    }
    
    // Find maximum using varargs
    public static int findMax(int first, int... rest) {
        int max = first;
        for (int num : rest) {
            if (num > max) max = num;
        }
        return max;
    }
    
    // Find minimum using varargs
    public static int findMin(int first, int... rest) {
        int min = first;
        for (int num : rest) {
            if (num < min) min = num;
        }
        return min;
    }
    
    // Create list using varargs
    @SafeVarargs
    public static <T> List<T> createList(T... elements) {
        return Arrays.asList(elements);
    }
    
    // Logger method using varargs
    public static void log(String level, String... messages) {
        System.out.print("[" + level + "] ");
        for (String message : messages) {
            System.out.print(message + " ");
        }
        System.out.println();
    }
}

/*
 * ==================== VARARGS KEY POINTS ====================
 * 
 * 1. SYNTAX:
 *    - dataType... parameterName
 *    - Must be the last parameter in method signature
 *    - Only one varargs parameter per method
 * 
 * 2. RULES:
 *    - Varargs must be the final parameter
 *    - Can have 0 or more arguments
 *    - Internally treated as array
 *    - Can pass array directly to varargs method
 * 
 * 3. BENEFITS:
 *    - Method flexibility (different number of arguments)
 *    - Cleaner method calls
 *    - Backward compatibility
 *    - Reduces method overloading
 * 
 * 4. LIMITATIONS:
 *    - Only one varargs per method
 *    - Must be last parameter
 *    - Type safety issues with generics (use @SafeVarargs)
 *    - Potential performance overhead (array creation)
 * 
 * 5. BEST PRACTICES:
 *    - Use when you need flexible number of same-type parameters
 *    - Validate arguments inside method
 *    - Use @SafeVarargs for generic varargs methods
 *    - Consider overloading for better performance in critical code
 *    - Document the expected parameter behavior
 */