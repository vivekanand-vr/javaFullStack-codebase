/*
 * Understanding Enums in Java
 */

/*
 * Enums (Enumerations) are a special data type that represents a fixed set of constants.
 * They are type-safe and provide better readability compared to using constant integers.
 * Enums are implicitly final and extend java.lang.Enum class.
 * 
 * Benefits:
 * - Type safety: Cannot assign invalid values
 * - Namespace: Constants are grouped together
 * - Readability: More meaningful than magic numbers
 * - Switch support: Can be used in switch statements
 * - Built-in methods: values(), valueOf(), ordinal(), name()
 */

// 1. Basic Enum
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

// 2. Enum with Constructor and Methods
enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6);
    
    private final double mass;   // in kilograms
    private final double radius; // in meters
    
    // Constructor
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    
    // Methods
    public double getMass() { return mass; }
    public double getRadius() { return radius; }
    
    // Calculate surface gravity
    public double surfaceGravity() {
        double G = 6.67300E-11;
        return G * mass / (radius * radius);
    }
    
    public double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
}

// 3. Enum implementing interface
interface Processable {
    void process();
}

enum Status implements Processable {
    PENDING {
        @Override
        public void process() {
            System.out.println("Processing pending item...");
        }
    },
    APPROVED {
        @Override
        public void process() {
            System.out.println("Item approved, sending notification...");
        }
    },
    REJECTED {
        @Override
        public void process() {
            System.out.println("Item rejected, logging reason...");
        }
    }
}

// 4. Enum with abstract methods
enum Operation {
    PLUS {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };
    
    // Abstract method that each constant must implement
    public abstract double apply(double x, double y);
}

public class EnumsExample {
    
    public static void main(String[] args) {
        System.out.println("1. Basic Enum Usage:");
        
        // Basic enum usage
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today);
        System.out.println("Ordinal value: " + today.ordinal());
        System.out.println("Name: " + today.name());
        
        // 2. Enum in switch statement
        System.out.println("\n2. Enum in Switch Statement:");
        switchExample(today);
        
        // 3. Enum methods
        System.out.println("\n3. Built-in Enum Methods:");
        enumMethodsExample();
        
        // 4. Enum with constructor and methods
        System.out.println("\n4. Enum with Constructor and Methods:");
        planetExample();
        
        // 5. Enum implementing interface
        System.out.println("\n5. Enum Implementing Interface:");
        interfaceExample();
        
        // 6. Enum with abstract methods
        System.out.println("\n6. Enum with Abstract Methods:");
        operationExample();
        
        // 7. Enum comparison
        System.out.println("\n7. Enum Comparison:");
        comparisonExample();
    }
    
    // Switch statement with enum
    public static void switchExample(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are tough!");
                break;
            case FRIDAY:
                System.out.println("TGIF!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Midweek day");
        }
    }
    
    // Built-in enum methods
    public static void enumMethodsExample() {
        // values() - returns array of all enum constants
        System.out.println("All days:");
        for (Day day : Day.values()) {
            System.out.println(day + " (ordinal: " + day.ordinal() + ")");
        }
        
        // valueOf() - converts string to enum
        try {
            Day day = Day.valueOf("FRIDAY");
            System.out.println("Parsed day: " + day);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid day name");
        }
    }
    
    // Enum with constructor example
    public static void planetExample() {
        double earthWeight = 75.0; // kg
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        
        System.out.println("Weight on different planets:");
        for (Planet planet : Planet.values()) {
            System.out.printf("Weight on %-8s: %6.2f kg%n",
                            planet, planet.surfaceWeight(mass));
        }
    }
    
    // Enum implementing interface
    public static void interfaceExample() {
        for (Status status : Status.values()) {
            System.out.print(status + ": ");
            status.process();
        }
    }
    
    // Enum with abstract methods
    public static void operationExample() {
        double x = 10.0;
        double y = 3.0;
        
        System.out.println("Mathematical operations:");
        for (Operation op : Operation.values()) {
            System.out.printf("%.1f %s %.1f = %.2f%n", 
                            x, op, y, op.apply(x, y));
        }
    }
    
    // Enum comparison
    public static void comparisonExample() {
        Day day1 = Day.MONDAY;
        Day day2 = Day.FRIDAY;
        Day day3 = Day.MONDAY;
        
        // Enum comparison using ==
        System.out.println("day1 == day3: " + (day1 == day3));
        System.out.println("day1 == day2: " + (day1 == day2));
        
        // Enum comparison using equals()
        System.out.println("day1.equals(day3): " + day1.equals(day3));
        
        // Enum comparison using compareTo()
        System.out.println("day1.compareTo(day2): " + day1.compareTo(day2));
        System.out.println("day2.compareTo(day1): " + day2.compareTo(day1));
    }
}

/*
 * Key Points:
 * 1. Enums are type-safe constants that extend java.lang.Enum
 * 2. Cannot be instantiated using new keyword
 * 3. Can have constructors, methods, and fields
 * 4. Can implement interfaces but cannot extend classes
 * 5. Each enum constant is a singleton instance
 * 6. Comparison using == is safe and efficient
 * 7. Built-in methods: values(), valueOf(), ordinal(), name(), compareTo()
 * 8. Can be used in switch statements
 * 9. Can have abstract methods that constants must implement
 * 10. Ordinal values start from 0 and follow declaration order
 * 
 * Best Practices:
 * - Use enums instead of constants for fixed sets of values
 * - Add methods to enums to encapsulate behavior
 * - Use enum constructor for associated data
 * - Consider using EnumSet and EnumMap for collections
 */