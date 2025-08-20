/*
 * Understanding Import Statements in Java
 */

/*
 * Import statements in Java allow you to use classes and interfaces from other packages
 * without specifying their fully qualified names. They make code more readable and
 * easier to maintain by avoiding repetitive package names throughout the code.
 * 
 * Import statements must be placed after package declaration (if any) and before
 * class declarations. They don't actually include the code but tell the compiler
 * where to find the classes when they are used.
 */

// 1. Single Class Import - imports specific class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 2. Package Import (Wildcard) - imports all classes from package
import java.io.*;
import java.text.*;

// 3. Static Import - imports static members of a class
import static java.lang.Math.*;
import static java.lang.System.out;

// 4. Importing from sub-packages
import java.util.concurrent.ConcurrentHashMap;

public class ImportStatements {
    
    public static void main(String[] args) {
        System.out.println("1. Import Statements Examples:");
        
        // 1. Using imported classes without full package names
        System.out.println("\n1. Single Class Imports:");
        demonstrateSingleImports();
        
        // 2. Using wildcard imports
        System.out.println("\n2. Wildcard Imports:");
        demonstrateWildcardImports();
        
        // 3. Using static imports
        System.out.println("\n3. Static Imports:");
        demonstrateStaticImports();
        
        // 4. Fully qualified names (without import)
        System.out.println("\n4. Fully Qualified Names:");
        demonstrateFullyQualifiedNames();
        
        // 5. Import conflicts and resolution
        System.out.println("\n5. Handling Import Conflicts:");
        demonstrateImportConflicts();
    }
    
    // 1. Single Class Import Examples
    public static void demonstrateSingleImports() {
        // Using ArrayList (imported specifically)
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Programming");
        System.out.println("ArrayList: " + list);
        
        // Using HashMap (imported specifically)
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Java", 25);
        map.put("Python", 30);
        System.out.println("HashMap: " + map);
        
        // Using Scanner (imported specifically)
        Scanner scanner = new Scanner("Hello World");
        if (scanner.hasNext()) {
            System.out.println("Scanner input: " + scanner.next());
        }
        scanner.close();
    }
    
    // 2. Wildcard Import Examples
    public static void demonstrateWildcardImports() {
        try {
            // Using File from java.io.* import
            File tempFile = File.createTempFile("example", ".txt");
            System.out.println("Temp file created: " + tempFile.getName());
            
            // Using FileWriter from java.io.* import
            FileWriter writer = new FileWriter(tempFile);
            writer.write("Hello from ImportStatements!");
            writer.close();
            
            // Using BufferedReader from java.io.* import
            BufferedReader reader = new BufferedReader(new FileReader(tempFile));
            String content = reader.readLine();
            System.out.println("File content: " + content);
            reader.close();
            
            // Using SimpleDateFormat from java.text.* import
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Current time: " + sdf.format(new java.util.Date()));
            
            // Clean up
            tempFile.delete();
            
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }
    
    // 3. Static Import Examples
    public static void demonstrateStaticImports() {
        // Using Math methods without Math. prefix (static import)
        double angle = PI / 4; // PI imported from Math
        System.out.println("Sin(π/4) = " + sin(angle)); // sin() imported from Math
        System.out.println("Cos(π/4) = " + cos(angle)); // cos() imported from Math
        System.out.println("Square root of 16 = " + sqrt(16)); // sqrt() imported from Math
        
        // Using System.out without System. prefix (static import)
        out.println("This uses static import for System.out");
        
        // More static import examples
        System.out.println("Random number: " + random()); // random() from Math
        System.out.println("Maximum of 10, 20: " + max(10, 20)); // max() from Math
    }
    
    // 4. Fully Qualified Names (without imports)
    public static void demonstrateFullyQualifiedNames() {
        // Using full package names without imports
        java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        System.out.println("LinkedList (fully qualified): " + linkedList);
        
        // Using java.sql.Date (different from java.util.Date)
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        System.out.println("SQL Date: " + sqlDate);
        
        // Using BigDecimal without import
        java.math.BigDecimal decimal = new java.math.BigDecimal("123.456");
        System.out.println("BigDecimal: " + decimal);
    }
    
    // 5. Import Conflicts and Resolution
    public static void demonstrateImportConflicts() {
        // When two classes have same name from different packages
        
        // java.util.Date (commonly used)
        java.util.Date utilDate = new java.util.Date();
        System.out.println("util.Date: " + utilDate);
        
        // java.sql.Date (extends util.Date but different purpose)
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        System.out.println("sql.Date: " + sqlDate);
        
        // If we imported both, we'd need to use fully qualified names
        // or import one and use fully qualified name for the other
        
        // Example with List (interface)
        java.util.List<String> list1 = new ArrayList<>(); // ArrayList already imported
        list1.add("Using util.List");
        System.out.println("List example: " + list1);
    }
}

// Demonstration class for package concepts
class PackageExample {
    // This class is in default package
    // In real applications, always use named packages like:
    // package com.company.project.utils;
    
    public void demonstratePackageConcepts() {
        System.out.println("This class is in default package");
        System.out.println("In production code, use proper package structure");
        
        // Example of what package declaration would look like:
        System.out.println("Example package: com.company.project.utils");
    }
}

/*
 * Key Points:
 * 1. Import statements go after package declaration but before class declaration
 * 2. Single class imports are preferred over wildcard imports for clarity
 * 3. Static imports allow direct use of static members without class name
 * 4. Wildcard imports (*) import all classes from a package, not sub-packages
 * 5. Import statements don't include the actual code, just help compiler locate classes
 * 6. Default imports: java.lang.* is automatically imported
 * 7. Fully qualified names can be used without imports to resolve conflicts
 * 8. Import conflicts occur when classes have same name from different packages
 * 9. java.util.Date vs java.sql.Date is a common conflict example
 * 10. Use meaningful package names following reverse domain convention
 * 11. Avoid wildcard imports in production code for better maintainability
 * 12. Static imports should be used sparingly to avoid confusion
 * 
 * Best Practices:
 * - Use specific imports rather than wildcards
 * - Group imports logically (standard library, third-party, local)
 * - Remove unused imports regularly
 * - Use static imports only for frequently used constants/methods
 */