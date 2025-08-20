/*
 * Understanding Inner Classes in Java
 */

/*
 * Inner classes are classes defined within another class. They provide a way
 * to logically group classes that are only used in one place and increase
 * encapsulation. Inner classes have access to members of the outer class,
 * including private members.
 * 
 * Types of Inner Classes:
 * 1. Non-static nested class (Inner class)
 * 2. Static nested class
 * 3. Local inner class (defined inside a method)
 * 4. Anonymous inner class
 */

import java.util.*;

public class InnerClasses {
    
    private String outerField = "Outer class field";
    private static String staticOuterField = "Static outer field";
    
    public static void main(String[] args) {
        System.out.println("1. Inner Classes Examples:");
        
        // 1. Non-static Inner Class
        System.out.println("\n1. Non-static Inner Class:");
        InnerClasses outer = new InnerClasses();
        InnerClasses.InnerClass inner = outer.new InnerClass();
        inner.displayInnerData();
        
        // 2. Static Nested Class
        System.out.println("\n2. Static Nested Class:");
        InnerClasses.StaticNestedClass staticNested = new InnerClasses.StaticNestedClass();
        staticNested.displayStaticData();
        
        // 3. Local Inner Class
        System.out.println("\n3. Local Inner Class:");
        outer.methodWithLocalInnerClass();
        
        // 4. Anonymous Inner Class
        System.out.println("\n4. Anonymous Inner Class:");
        outer.demonstrateAnonymousClass();
        
        // 5. Practical Example - Event Handling Style
        System.out.println("\n5. Practical Example:");
        outer.practicalExample();
    }
    
    // 1. Non-static Inner Class (Regular Inner Class)
    class InnerClass {
        private String innerField = "Inner class field";
        
        public void displayInnerData() {
            System.out.println("Accessing outer field: " + outerField);
            System.out.println("Accessing static outer field: " + staticOuterField);
            System.out.println("Inner field: " + innerField);
            
            // Can access outer class methods
            outerMethod();
        }
        
        // Inner class cannot have static members (except static final constants)
        // static int x = 10; // This would cause compilation error
        static final int CONSTANT = 100; // This is allowed
    }
    
    // 2. Static Nested Class
    static class StaticNestedClass {
        private String staticNestedField = "Static nested field";
        
        public void displayStaticData() {
            // Can access static members of outer class
            System.out.println("Accessing static outer field: " + staticOuterField);
            
            // Cannot access non-static members directly
            // System.out.println(outerField); // Compilation error
            
            // Must create instance of outer class to access non-static members
            InnerClasses outer = new InnerClasses();
            System.out.println("Accessing outer field through instance: " + outer.outerField);
            
            System.out.println("Static nested field: " + staticNestedField);
        }
        
        // Can have static members
        static void staticMethod() {
            System.out.println("Static method in static nested class");
        }
    }
    
    // 3. Local Inner Class (inside a method)
    public void methodWithLocalInnerClass() {
        final String localVariable = "Local variable";
        int localNumber = 42;
        
        // Local inner class
        class LocalInnerClass {
            public void display() {
                System.out.println("In local inner class");
                System.out.println("Accessing outer field: " + outerField);
                System.out.println("Accessing local variable: " + localVariable);
                System.out.println("Accessing local number: " + localNumber);
            }
        }
        
        // Create and use local inner class
        LocalInnerClass localInner = new LocalInnerClass();
        localInner.display();
    }
    
    // 4. Anonymous Inner Class
    public void demonstrateAnonymousClass() {
        // Anonymous inner class implementing Runnable
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in anonymous inner class");
                System.out.println("Can access outer field: " + outerField);
            }
        };
        
        task.run();
        
        // Anonymous inner class with List
        List<String> list = new ArrayList<String>() {
            {
                add("Item 1");
                add("Item 2");
                add("Item 3");
            }
            
            @Override
            public boolean add(String item) {
                System.out.println("Adding: " + item);
                return super.add(item);
            }
        };
        
        System.out.println("List contents: " + list);
    }
    
    // 5. Practical Example
    public void practicalExample() {
        Calculator calc = new Calculator();
        
        // Using different operation strategies
        calc.setOperation(calc.new Addition());
        System.out.println("5 + 3 = " + calc.calculate(5, 3));
        
        calc.setOperation(calc.new Multiplication());
        System.out.println("5 * 3 = " + calc.calculate(5, 3));
    }
    
    // Helper method for outer class
    private void outerMethod() {
        System.out.println("Method from outer class");
    }
    
    // Inner class for practical example
    class Calculator {
        private Operation operation;
        
        interface Operation {
            int perform(int a, int b);
        }
        
        // Inner classes implementing the operation
        class Addition implements Operation {
            public int perform(int a, int b) {
                return a + b;
            }
        }
        
        class Multiplication implements Operation {
            public int perform(int a, int b) {
                return a * b;
            }
        }
        
        public void setOperation(Operation operation) {
            this.operation = operation;
        }
        
        public int calculate(int a, int b) {
            return operation.perform(a, b);
        }
    }
}

/*
 * Key Points:
 * 1. Inner classes have access to all members of outer class, including private ones
 * 2. Non-static inner classes cannot have static members (except static final constants)
 * 3. Static nested classes can only access static members of outer class directly
 * 4. Local inner classes can access final or effectively final local variables
 * 5. Anonymous inner classes are useful for implementing interfaces or extending classes inline
 * 6. Inner classes increase encapsulation and logical grouping
 * 7. Use static nested classes when you don't need access to outer instance
 * 8. Inner classes can implement interfaces and extend other classes
 * 
 * Memory consideration: Non-static inner classes hold implicit reference to outer instance
 */