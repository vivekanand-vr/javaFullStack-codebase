/*
 * Understanding Arrays in Java - Features and Built-in Methods
 */

/*
 * Arrays in Java:
 * - Arrays are objects that store multiple values of the same data type
 * - Fixed size once created (cannot be resized)
 * - Elements are stored in contiguous memory locations
 * - Zero-indexed (first element at index 0)
 * - All elements are initialized to default values
 * 
 * Types of Arrays:
 * 1. Single-dimensional arrays
 * 2. Multi-dimensional arrays (2D, 3D, etc.)
 * 3. Jagged arrays (arrays of arrays with different lengths)
 * 
 * Built-in Methods (java.util.Arrays class):
 * - sort(), binarySearch(), equals(), fill(), copyOf(), toString(), etc.
 */

import java.util.Arrays;
import java.util.Collections;

public class ArraysDemo {
    
    public static void main(String[] args) {
        
        // 1. Array Declaration and Initialization
        System.out.println("1. Array Declaration and Initialization:");
        
        // Different ways to declare arrays
        int[] numbers1;                    // Declaration
        int numbers2[];                    // Alternative syntax (C-style)
        int[] numbers3 = new int[5];       // Declaration with size
        int[] numbers4 = {1, 2, 3, 4, 5}; // Declaration with initialization
        int[] numbers5 = new int[]{6, 7, 8, 9, 10}; // Alternative initialization
        
        System.out.println("numbers3 length: " + numbers3.length);
        System.out.println("numbers4 elements: " + Arrays.toString(numbers4));
        System.out.println("numbers5 elements: " + Arrays.toString(numbers5));
        
        // 2. Array Elements and Default Values
        System.out.println("\n2. Array Elements and Default Values:");
        
        boolean[] boolArray = new boolean[3];     // Default: false
        int[] intArray = new int[3];              // Default: 0
        double[] doubleArray = new double[3];     // Default: 0.0
        String[] stringArray = new String[3];     // Default: null
        char[] charArray = new char[3];           // Default: '\u0000'
        
        System.out.println("boolean array defaults: " + Arrays.toString(boolArray));
        System.out.println("int array defaults: " + Arrays.toString(intArray));
        System.out.println("double array defaults: " + Arrays.toString(doubleArray));
        System.out.println("String array defaults: " + Arrays.toString(stringArray));
        System.out.println("char array defaults: " + Arrays.toString(charArray));
        
        // 3. Accessing and Modifying Array Elements
        System.out.println("\n3. Accessing and Modifying Array Elements:");
        
        String[] fruits = {"Apple", "Banana", "Orange", "Mango", "Grapes"};
        System.out.println("Original array: " + Arrays.toString(fruits));
        
        // Accessing elements
        System.out.println("First fruit: " + fruits[0]);
        System.out.println("Last fruit: " + fruits[fruits.length - 1]);
        
        // Modifying elements
        fruits[1] = "Strawberry";
        fruits[3] = "Pineapple";
        System.out.println("Modified array: " + Arrays.toString(fruits));
        
        // 4. Array Length and Iteration
        System.out.println("\n4. Array Length and Iteration:");
        
        int[] scores = {85, 92, 78, 96, 88, 75, 90};
        System.out.println("Array length: " + scores.length);
        
        // Traditional for loop
        System.out.print("Using traditional for loop: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();
        
        // Enhanced for loop (for-each)
        System.out.print("Using enhanced for loop: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
        
        // While loop
        System.out.print("Using while loop: ");
        int index = 0;
        while (index < scores.length) {
            System.out.print(scores[index] + " ");
            index++;
        }
        System.out.println();
        
        // 5. Built-in Methods from java.util.Arrays
        System.out.println("\n5. Built-in Methods from java.util.Arrays:");
        
        int[] originalArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(originalArray));
        
        // toString() - Convert array to string representation
        System.out.println("Using Arrays.toString(): " + Arrays.toString(originalArray));
        
        // sort() - Sort array in ascending order
        int[] sortedArray = originalArray.clone(); // Create copy to preserve original
        Arrays.sort(sortedArray);
        System.out.println("After Arrays.sort(): " + Arrays.toString(sortedArray));
        
        // binarySearch() - Search for element (array must be sorted)
        int searchElement = 25;
        int position = Arrays.binarySearch(sortedArray, searchElement);
        System.out.println("Arrays.binarySearch(" + searchElement + "): index " + position);
        
        // fill() - Fill array with specified value
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 100);
        System.out.println("Arrays.fill(array, 100): " + Arrays.toString(fillArray));
        
        // fill() with range
        int[] rangeArray = {1, 2, 3, 4, 5, 6, 7, 8};
        Arrays.fill(rangeArray, 2, 5, 0); // Fill from index 2 to 4 with 0
        System.out.println("Arrays.fill(array, 2, 5, 0): " + Arrays.toString(rangeArray));
        
        // equals() - Compare two arrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {3, 2, 1};
        System.out.println("Arrays.equals(array1, array2): " + Arrays.equals(array1, array2));
        System.out.println("Arrays.equals(array1, array3): " + Arrays.equals(array1, array3));
        
        // copyOf() - Copy array with specified length
        int[] copiedArray = Arrays.copyOf(originalArray, originalArray.length);
        System.out.println("Arrays.copyOf(): " + Arrays.toString(copiedArray));
        
        // copyOf() with different length
        int[] expandedArray = Arrays.copyOf(originalArray, 10);
        System.out.println("Arrays.copyOf() with length 10: " + Arrays.toString(expandedArray));
        
        // copyOfRange() - Copy specific range
        int[] rangeClone = Arrays.copyOfRange(originalArray, 2, 5);
        System.out.println("Arrays.copyOfRange(2, 5): " + Arrays.toString(rangeClone));
        
        // 6. String Array Methods
        System.out.println("\n6. String Array Methods:");
        
        String[] languages = {"java", "python", "javascript", "c++", "go"};
        System.out.println("Original string array: " + Arrays.toString(languages));
        
        // Sort string array
        Arrays.sort(languages);
        System.out.println("Sorted string array: " + Arrays.toString(languages));
        
        // Sort in reverse order using Collections.reverseOrder()
        String[] languagesCopy = {"java", "python", "javascript", "c++", "go"};
        Arrays.sort(languagesCopy, Collections.reverseOrder());
        System.out.println("Reverse sorted: " + Arrays.toString(languagesCopy));
        
        // 7. Multi-dimensional Arrays
        System.out.println("\n7. Multi-dimensional Arrays:");
        
        // 2D Array declaration and initialization
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("2D Array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Using Arrays.deepToString() for multi-dimensional arrays
        System.out.println("Using Arrays.deepToString(): " + Arrays.deepToString(matrix));
        
        // 3D Array example
        int[][][] cube = new int[2][2][2];
        int value = 1;
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    cube[i][j][k] = value++;
                }
            }
        }
        System.out.println("3D Array: " + Arrays.deepToString(cube));
        
        // 8. Jagged Arrays (Arrays of different lengths)
        System.out.println("\n8. Jagged Arrays:");
        
        int[][] jaggedArray = {
            {1, 2},
            {3, 4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Jagged array:");
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println("(length: " + jaggedArray[i].length + ")");
        }
        
        // 9. Array Utility Methods (Custom implementations)
        System.out.println("\n9. Array Utility Methods:");
        
        int[] testArray = {10, 5, 8, 3, 9, 1, 7};
        System.out.println("Test array: " + Arrays.toString(testArray));
        
        // Find maximum element
        int max = findMax(testArray);
        System.out.println("Maximum element: " + max);
        
        // Find minimum element
        int min = findMin(testArray);
        System.out.println("Minimum element: " + min);
        
        // Calculate sum
        int sum = calculateSum(testArray);
        System.out.println("Sum of elements: " + sum);
        
        // Calculate average
        double average = calculateAverage(testArray);
        System.out.println("Average: " + average);
        
        // Reverse array
        int[] reversed = reverseArray(testArray.clone());
        System.out.println("Reversed array: " + Arrays.toString(reversed));
        
        // Check if array contains element
        boolean contains = containsElement(testArray, 5);
        System.out.println("Contains 5: " + contains);
        
        // Find index of element
        int elementIndex = findIndex(testArray, 8);
        System.out.println("Index of 8: " + elementIndex);
        
        // 10. Array Performance and Memory
        System.out.println("\n10. Array Performance and Memory:");
        
        // Creating large array
        int[] largeArray = new int[1000000];
        Arrays.fill(largeArray, 42);
        
        // Time array operations
        long startTime = System.currentTimeMillis();
        Arrays.sort(largeArray);
        long endTime = System.currentTimeMillis();
        
        System.out.println("Time to sort 1M elements: " + (endTime - startTime) + "ms");
        System.out.println("First 5 elements: " + Arrays.toString(Arrays.copyOf(largeArray, 5)));
        
        // 11. Common Array Operations
        System.out.println("\n11. Common Array Operations:");
        
        int[] nums = {1, 2, 3, 4, 5};
        
        // Array concatenation
        int[] moreNums = {6, 7, 8};
        int[] combined = concatenateArrays(nums, moreNums);
        System.out.println("Concatenated arrays: " + Arrays.toString(combined));
        
        // Remove element at index
        int[] afterRemoval = removeElementAtIndex(nums, 2);
        System.out.println("After removing index 2: " + Arrays.toString(afterRemoval));
        
        // Insert element at index
        int[] afterInsertion = insertElementAtIndex(nums, 2, 99);
        System.out.println("After inserting 99 at index 2: " + Arrays.toString(afterInsertion));
        
        System.out.println("\n=== End of Arrays Demo ===");
    }
    
    // Custom utility methods for arrays
    
    // Find maximum element in array
    public static int findMax(int[] array) {
        if (array.length == 0) return 0;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    // Find minimum element in array
    public static int findMin(int[] array) {
        if (array.length == 0) return 0;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    
    // Calculate sum of array elements
    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
    
    // Calculate average of array elements
    public static double calculateAverage(int[] array) {
        if (array.length == 0) return 0;
        return (double) calculateSum(array) / array.length;
    }
    
    // Reverse array elements
    public static int[] reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return array;
    }
    
    // Check if array contains specific element
    public static boolean containsElement(int[] array, int element) {
        for (int num : array) {
            if (num == element) {
                return true;
            }
        }
        return false;
    }
    
    // Find index of element in array
    public static int findIndex(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1; // Not found
    }
    
    // Concatenate two arrays
    public static int[] concatenateArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }
    
    // Remove element at specific index
    public static int[] removeElementAtIndex(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            return array; // Invalid index
        }
        
        int[] result = new int[array.length - 1];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(array, index + 1, result, index, array.length - index - 1);
        return result;
    }
    
    // Insert element at specific index
    public static int[] insertElementAtIndex(int[] array, int index, int element) {
        if (index < 0 || index > array.length) {
            return array; // Invalid index
        }
        
        int[] result = new int[array.length + 1];
        System.arraycopy(array, 0, result, 0, index);
        result[index] = element;
        System.arraycopy(array, index, result, index + 1, array.length - index);
        return result;
    }
}

/*
 * Key Features of Java Arrays:
 * 
 * 1. Fixed Size: Cannot be resized after creation
 * 2. Homogeneous: All elements must be of same type
 * 3. Zero-indexed: First element at index 0
 * 4. Reference Type: Arrays are objects
 * 5. Default Values: Elements get default values when created
 * 6. Length Property: .length gives array size
 * 7. Memory Efficient: Elements stored in contiguous memory
 * 8. Random Access: O(1) time to access any element
 * 
 * Important java.util.Arrays Methods:
 * - toString(array): String representation
 * - deepToString(array): For multi-dimensional arrays
 * - sort(array): Sort in ascending order
 * - binarySearch(array, key): Search in sorted array
 * - equals(array1, array2): Compare arrays
 * - fill(array, value): Fill with value
 * - copyOf(array, length): Create copy
 * - copyOfRange(array, from, to): Copy range
 * 
 * Performance Characteristics:
 * - Access: O(1)
 * - Search: O(n) linear, O(log n) if sorted
 * - Insertion/Deletion: O(n) (requires shifting)
 * - Sorting: O(n log n)
 * 
 * Best Practices:
 * 1. Use enhanced for loop when index is not needed
 * 2. Always check array bounds to avoid exceptions
 * 3. Initialize arrays with meaningful default values
 * 4. Use Arrays utility methods instead of writing custom code
 * 5. Consider using ArrayList for dynamic sizing needs
 * 6. Cache array length in loops for better performance
 * 
 * Common Pitfalls:
 * 1. ArrayIndexOutOfBoundsException
 * 2. Forgetting arrays are reference types (shallow copying)
 * 3. Comparing arrays with == instead of Arrays.equals()
 * 4. Not handling null arrays in utility methods
 * 5. Modifying array during iteration
 */