/*
 * INTERFACES
 * ==========
 * 
 * An Interface in Java is a blueprint of a class that contains only abstract methods
 * and constants. It represents a contract that implementing classes must follow.
 * 
 * KEY CHARACTERISTICS:
 * ===================
 * 1. All methods are implicitly public and abstract (before Java 8)
 * 2. All variables are implicitly public, static, and final (constants)
 * 3. Cannot be instantiated directly
 * 4. Can be implemented by multiple classes (multiple inheritance support)
 * 5. A class can implement multiple interfaces
 * 6. Interfaces can extend other interfaces
 * 
 * EVOLUTION OF INTERFACES:
 * =======================
 * - Java 7 and earlier: Only abstract methods and constants
 * - Java 8: Added default and static methods
 * - Java 9: Added private methods
 * - Java 10+: Added private static methods
 * 
 * SYNTAX:
 * =======
 * interface InterfaceName {
 *     // Constants (implicitly public, static, final)
 *     dataType CONSTANT_NAME = value;
 *     
 *     // Abstract methods (implicitly public, abstract)
 *     returnType methodName(parameters);
 *     
 *     // Default methods (Java 8+)
 *     default returnType methodName(parameters) { ... }
 *     
 *     // Static methods (Java 8+)
 *     static returnType methodName(parameters) { ... }
 *     
 *     // Private methods (Java 9+)
 *     private returnType methodName(parameters) { ... }
 * }
 * 
 * BENEFITS:
 * =========
 * - Multiple inheritance support
 * - Loose coupling between classes
 * - Contract-based programming
 * - Code flexibility and maintainability
 * - Support for polymorphism
 * - API design and standardization
 */

import java.util.*;
import java.time.LocalDateTime;

// ========================================
// BASIC INTERFACE EXAMPLES
// ========================================

// Simple interface with constants and abstract methods
interface Drawable {
    // Constants (implicitly public, static, final)
    String DEFAULT_COLOR = "BLACK";
    int MAX_COORDINATES = 1000;
    
    // Abstract methods (implicitly public, abstract)
    void draw();
    void move(int x, int y);
    void resize(double factor);
    
    // Default method (Java 8+) - provides default implementation
    default void displayInfo() {
        System.out.println("This is a drawable object with default color: " + DEFAULT_COLOR);
    }
    
    // Static method (Java 8+) - utility method
    static boolean isValidCoordinate(int x, int y) {
        return x >= 0 && y >= 0 && x <= MAX_COORDINATES && y <= MAX_COORDINATES;
    }
}

// Interface for objects that can be colored
interface Colorable {
    void setColor(String color);
    String getColor();
    
    // Default method with implementation
    default void printColorInfo() {
        System.out.println("Current color: " + getColor());
    }
}

// Interface for resizable objects
interface Resizable {
    void resize(double widthFactor, double heightFactor);
    double getArea();
    
    // Default method that uses abstract method
    default void displayAreaInfo() {
        System.out.println("Current area: " + String.format("%.2f", getArea()));
    }
}

// ========================================
// MULTIPLE INTERFACE IMPLEMENTATION
// ========================================

// Class implementing multiple interfaces
class Rectangle implements Drawable, Colorable, Resizable {
    private double width;
    private double height;
    private String color;
    private int x, y; // position
    
    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.x = 0;
        this.y = 0;
    }
    
    // Implementing Drawable interface
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " rectangle at (" + x + ", " + y + 
                         ") with width=" + width + ", height=" + height);
    }
    
    @Override
    public void move(int x, int y) {
        if (Drawable.isValidCoordinate(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println("Rectangle moved to (" + x + ", " + y + ")");
        } else {
            System.out.println("Invalid coordinates: (" + x + ", " + y + ")");
        }
    }
    
    @Override
    public void resize(double factor) {
        this.width *= factor;
        this.height *= factor;
        System.out.println("Rectangle resized by factor: " + factor);
    }
    
    // Implementing Colorable interface
    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Rectangle color changed to: " + color);
    }
    
    @Override
    public String getColor() {
        return color;
    }
    
    // Implementing Resizable interface
    @Override
    public void resize(double widthFactor, double heightFactor) {
        this.width *= widthFactor;
        this.height *= heightFactor;
        System.out.println("Rectangle resized - width factor: " + widthFactor + 
                         ", height factor: " + heightFactor);
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    // Additional methods
    public void displayDimensions() {
        System.out.println("Width: " + width + ", Height: " + height);
    }
}

// ========================================
// INTERFACE INHERITANCE
// ========================================

// Base interface
interface Vehicle {
    void start();
    void stop();
    double getMaxSpeed();
    
    // Default method
    default void displayBasicInfo() {
        System.out.println("This is a vehicle with max speed: " + getMaxSpeed() + " km/h");
    }
}

// Interface extending another interface
interface ElectricVehicle extends Vehicle {
    void chargeBattery();
    double getBatteryLevel();
    double getRange();
    
    // Default method specific to electric vehicles
    default void displayEcoInfo() {
        System.out.println("This is an eco-friendly electric vehicle!");
        System.out.println("Range: " + getRange() + " km");
        System.out.println("Battery Level: " + getBatteryLevel() + "%");
    }
}

// Interface for autonomous features
interface AutonomousVehicle extends Vehicle {
    void enableAutopilot();
    void disableAutopilot();
    boolean isAutopilotActive();
    
    default void displayAutonomousFeatures() {
        System.out.println("Autonomous features available");
        System.out.println("Autopilot status: " + (isAutopilotActive() ? "Active" : "Inactive"));
    }
}

// Class implementing multiple inherited interfaces
class TeslaModelS implements ElectricVehicle, AutonomousVehicle {
    private boolean isRunning;
    private double batteryLevel;
    private boolean autopilotActive;
    private final double MAX_SPEED = 250.0;
    private final double RANGE = 500.0;
    
    public TeslaModelS() {
        this.isRunning = false;
        this.batteryLevel = 80.0;
        this.autopilotActive = false;
    }
    
    // Implementing Vehicle interface methods
    @Override
    public void start() {
        isRunning = true;
        System.out.println("Tesla Model S started silently (electric motor)");
    }
    
    @Override
    public void stop() {
        isRunning = false;
        autopilotActive = false;
        System.out.println("Tesla Model S stopped");
    }
    
    @Override
    public double getMaxSpeed() {
        return MAX_SPEED;
    }
    
    // Implementing ElectricVehicle interface methods
    @Override
    public void chargeBattery() {
        batteryLevel = 100.0;
        System.out.println("Tesla Model S battery charged to 100%");
    }
    
    @Override
    public double getBatteryLevel() {
        return batteryLevel;
    }
    
    @Override
    public double getRange() {
        return (batteryLevel / 100.0) * RANGE;
    }
    
    // Implementing AutonomousVehicle interface methods
    @Override
    public void enableAutopilot() {
        if (isRunning) {
            autopilotActive = true;
            System.out.println("Tesla Autopilot enabled");
        } else {
            System.out.println("Cannot enable autopilot. Vehicle is not running.");
        }
    }
    
    @Override
    public void disableAutopilot() {
        autopilotActive = false;
        System.out.println("Tesla Autopilot disabled");
    }
    
    @Override
    public boolean isAutopilotActive() {
        return autopilotActive;
    }
    
    public void displayFullInfo() {
        displayBasicInfo();     // From Vehicle
        displayEcoInfo();       // From ElectricVehicle
        displayAutonomousFeatures(); // From AutonomousVehicle
    }
}

// ========================================
// FUNCTIONAL INTERFACES (Java 8+)
// ========================================

// Functional interface - interface with exactly one abstract method
@FunctionalInterface
interface Calculator {
    double calculate(double a, double b);
    
    // Default and static methods don't count toward the single abstract method rule
    default void printResult(double a, double b) {
        System.out.println("Result of " + a + " and " + b + " is: " + calculate(a, b));
    }
    
    static void displayCalculatorInfo() {
        System.out.println("This is a functional calculator interface");
    }
}

// Another functional interface
@FunctionalInterface
interface StringProcessor {
    String process(String input);
    
    // Default method
    default String processAndLog(String input) {
        String result = process(input);
        System.out.println("Processed '" + input + "' to '" + result + "'");
        return result;
    }
}

// ========================================
// ADVANCED INTERFACE FEATURES
// ========================================

// Interface with private methods (Java 9+)
interface AdvancedLogger {
    // Abstract method
    void log(String message);
    
    // Default methods
    default void logInfo(String message) {
        logWithLevel("INFO", message);
    }
    
    default void logWarning(String message) {
        logWithLevel("WARNING", message);
    }
    
    default void logError(String message) {
        logWithLevel("ERROR", message);
    }
    
    // Private method (Java 9+) - helper method for default methods
    private void logWithLevel(String level, String message) {
        String timestamp = getCurrentTimestamp();
        System.out.println("[" + timestamp + "] " + level + ": " + message);
    }
    
    // Private static method (Java 9+)
    private static String getCurrentTimestamp() {
        return LocalDateTime.now().toString();
    }
    
    // Static method
    static void printLoggerInfo() {
        System.out.println("Advanced Logger Interface - Supports multiple log levels");
    }
}

// Implementation of advanced logger
class DatabaseLogger implements AdvancedLogger {
    private String databaseName;
    
    public DatabaseLogger(String databaseName) {
        this.databaseName = databaseName;
    }
    
    @Override
    public void log(String message) {
        System.out.println("Logging to database '" + databaseName + "': " + message);
    }
}

class FileLogger implements AdvancedLogger {
    private String fileName;
    
    public FileLogger(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public void log(String message) {
        System.out.println("Logging to file '" + fileName + "': " + message);
    }
}

// ========================================
// INTERFACE SEGREGATION EXAMPLE
// ========================================

// Large interface (violates Interface Segregation Principle)
interface BadMediaPlayer {
    void playAudio();
    void playVideo();
    void recordAudio();
    void recordVideo();
    void editAudio();
    void editVideo();
}

// Better approach - segregated interfaces
interface AudioPlayer {
    void playAudio();
    void stopAudio();
}

interface VideoPlayer {
    void playVideo();
    void stopVideo();
}

interface AudioRecorder {
    void startRecording();
    void stopRecording();
    void saveRecording(String filename);
}

interface VideoRecorder {
    void startVideoRecording();
    void stopVideoRecording();
    void saveVideo(String filename);
}

// Implementations can choose which interfaces to implement
class SimpleAudioPlayer implements AudioPlayer {
    private boolean isPlaying = false;
    
    @Override
    public void playAudio() {
        isPlaying = true;
        System.out.println("Playing audio...");
    }
    
    @Override
    public void stopAudio() {
        isPlaying = false;
        System.out.println("Audio stopped");
    }
}

class AdvancedMediaPlayer implements AudioPlayer, VideoPlayer, AudioRecorder {
    private boolean audioPlaying = false;
    private boolean videoPlaying = false;
    private boolean recording = false;
    
    // AudioPlayer implementation
    @Override
    public void playAudio() {
        audioPlaying = true;
        System.out.println("Advanced player: Playing audio with enhanced sound");
    }
    
    @Override
    public void stopAudio() {
        audioPlaying = false;
        System.out.println("Advanced player: Audio stopped");
    }
    
    // VideoPlayer implementation
    @Override
    public void playVideo() {
        videoPlaying = true;
        System.out.println("Advanced player: Playing video in HD quality");
    }
    
    @Override
    public void stopVideo() {
        videoPlaying = false;
        System.out.println("Advanced player: Video stopped");
    }
    
    // AudioRecorder implementation
    @Override
    public void startRecording() {
        recording = true;
        System.out.println("Advanced player: Started audio recording");
    }
    
    @Override
    public void stopRecording() {
        recording = false;
        System.out.println("Advanced player: Stopped audio recording");
    }
    
    @Override
    public void saveRecording(String filename) {
        System.out.println("Advanced player: Audio saved as " + filename);
    }
}

// ========================================
// MARKER INTERFACES
// ========================================

// Marker interface - no methods, just marks a class
interface Serializable {
    // Empty interface - just marks that objects can be serialized
}

interface Cloneable {
    // Marker interface for objects that can be cloned
}

// Class using marker interfaces
class Document implements Serializable, Cloneable {
    private String content;
    private String author;
    
    public Document(String content, String author) {
        this.content = content;
        this.author = author;
    }
    
    // Implementation of cloning (not automatic, needs to be implemented)
    public Document clone() {
        return new Document(this.content, this.author);
    }
    
    public void displayInfo() {
        System.out.println("Document by " + author + ": " + content);
    }
    
    // Getters and setters
    public String getContent() { return content; }
    public String getAuthor() { return author; }
}

// ========================================
// INTERFACE WITH GENERIC TYPES
// ========================================

interface Repository<T> {
    void save(T entity);
    T findById(int id);
    List<T> findAll();
    void delete(int id);
    
    // Default method with generics
    default void saveAll(List<T> entities) {
        entities.forEach(this::save);
        System.out.println("Saved " + entities.size() + " entities");
    }
}

// Generic implementation
class UserRepository implements Repository<User> {
    private Map<Integer, User> users = new HashMap<>();
    private int nextId = 1;
    
    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(nextId++);
        }
        users.put(user.getId(), user);
        System.out.println("User saved: " + user.getName());
    }
    
    @Override
    public User findById(int id) {
        return users.get(id);
    }
    
    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
    
    @Override
    public void delete(int id) {
        User removed = users.remove(id);
        if (removed != null) {
            System.out.println("User deleted: " + removed.getName());
        }
    }
}

// User class for repository example
class User {
    private int id;
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}

// ========================================
// MAIN CLASS DEMONSTRATING ALL CONCEPTS
// ========================================

public class JavaInterfacesComplete {
    
    public static void main(String[] args) {
        System.out.println("=== JAVA INTERFACES COMPLETE DEMONSTRATION ===\n");
        
        // =====================================
        // BASIC INTERFACE IMPLEMENTATION
        // =====================================
        System.out.println("█".repeat(60));
        System.out.println("1. BASIC INTERFACE IMPLEMENTATION");
        System.out.println("█".repeat(60));
        
        Rectangle rectangle = new Rectangle(10, 20, "Blue");
        
        // Using methods from different interfaces
        rectangle.draw();                    // Drawable
        rectangle.setColor("Red");          // Colorable
        rectangle.printColorInfo();         // Colorable default method
        rectangle.resize(1.5);              // Drawable
        rectangle.resize(0.8, 1.2);        // Resizable
        rectangle.displayAreaInfo();        // Resizable default method
        rectangle.displayInfo();            // Drawable default method
        
        // Using static method from interface
        System.out.println("Is coordinate (50, 75) valid? " + 
                         Drawable.isValidCoordinate(50, 75));
        
        // =====================================
        // INTERFACE INHERITANCE
        // =====================================
        System.out.println("\n" + "█".repeat(60));
        System.out.println("2. INTERFACE INHERITANCE");
        System.out.println("█".repeat(60));
        
        TeslaModelS tesla = new TeslaModelS();
        
        tesla.start();                      // Vehicle
        tesla.enableAutopilot();           // AutonomousVehicle
        tesla.chargeBattery();             // ElectricVehicle
        
        System.out.println("\n--- Full Tesla Info ---");
        tesla.displayFullInfo();           // Uses default methods from all interfaces
        
        tesla.disableAutopilot();
        tesla.stop();
        
        // =====================================
        // FUNCTIONAL INTERFACES
        // =====================================
        System.out.println("\n" + "█".repeat(60));
        System.out.println("3. FUNCTIONAL INTERFACES");
        System.out.println("█".repeat(60));
        
        // Using lambda expressions with functional interfaces
        Calculator addition = (a, b) -> a + b;
        Calculator multiplication = (a, b) -> a * b;
        Calculator division = (a, b) -> b != 0 ? a / b : 0;
        
        System.out.println("--- Calculator Operations ---");
        addition.printResult(10, 5);       // Uses default method
        multiplication.printResult(10, 5);
        division.printResult(10, 5);
        
        Calculator.displayCalculatorInfo(); // Static method
        
        // String processor examples
        StringProcessor toUpperCase = input -> input.toUpperCase();
        StringProcessor addPrefix = input -> "Processed: " + input;
        StringProcessor reverse = input -> new StringBuilder(input).reverse().toString();
        
        System.out.println("\n--- String Processing ---");
        toUpperCase.processAndLog("hello world");
        addPrefix.processAndLog("important data");
        reverse.processAndLog("Java");
        
        // =====================================
        // ADVANCED LOGGER INTERFACE
        // =====================================
        System.out.println("\n" + "█".repeat(60));
        System.out.println("4. ADVANCED INTERFACE FEATURES");
        System.out.println("█".repeat(60));
        
        AdvancedLogger.printLoggerInfo();   // Static method
        
        DatabaseLogger dbLogger = new DatabaseLogger("ProductionDB");
        FileLogger fileLogger = new FileLogger("application.log");
        
        System.out.println("\n--- Database Logger ---");
        dbLogger.log("Direct log message");
        dbLogger.logInfo("Application started");
        dbLogger.logWarning("Memory usage is high");
        dbLogger.logError("Database connection failed");
        
        System.out.println("\n--- File Logger ---");
        fileLogger.logInfo("User logged in");
        fileLogger.logError("File not found");
        
        // =====================================
        // INTERFACE SEGREGATION
        // =====================================
        System.out.println("\n" + "█".repeat(60));
        System.out.println("5. INTERFACE SEGREGATION");
        System.out.println("█".repeat(60));
        
        SimpleAudioPlayer simplePlayer = new SimpleAudioPlayer();
        simplePlayer.playAudio();
        simplePlayer.stopAudio();
        
        AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();
        advancedPlayer.playAudio();
        advancedPlayer.playVideo();
        advancedPlayer.startRecording();
        advancedPlayer.saveRecording("meeting_recording.mp3");
        advancedPlayer.stopRecording();
        advancedPlayer.stopVideo();
        advancedPlayer.stopAudio();
        
        // =====================================
        // MARKER INTERFACES
        // =====================================
        System.out.println("\n" + "█".repeat(60));
        System.out.println("6. MARKER INTERFACES");
        System.out.println("█".repeat(60));
        
        Document original = new Document("Important contract", "John Doe");
        original.displayInfo();
        
        // Using marker interface behavior
        if (original instanceof Serializable) {
            System.out.println("Document can be serialized");
        }
        
        if (original instanceof Cloneable) {
            Document copy = original.clone();
            System.out.println("Document cloned successfully");
            copy.displayInfo();
        }
        
        // =====================================
        // GENERIC INTERFACES
        // =====================================
        System.out.println("\n" + "█".repeat(60));
        System.out.println("7. GENERIC INTERFACES");
        System.out.println("█".repeat(60));
        
        UserRepository userRepo = new UserRepository();
        
        // Creating and saving users
        List<User> users = Arrays.asList(
            new User("Alice Johnson", "alice@email.com"),
            new User("Bob Smith", "bob@email.com"),
            new User("Charlie Brown", "charlie@email.com")
        );
        
        userRepo.saveAll(users);           // Uses default method
        
        System.out.println("\n--- All Users ---");
        userRepo.findAll().forEach(System.out::println);
        
        System.out.println("\n--- Finding specific user ---");
        User foundUser = userRepo.findById(2);
        if (foundUser != null) {
            System.out.println("Found: " + foundUser);
        }
        
        System.out.println("\n--- Deleting user ---");
        userRepo.delete(1);
        
        System.out.println("\n--- Remaining users ---");
        userRepo.findAll().forEach(System.out::println);
        
        // =====================================
        // POLYMORPHISM WITH INTERFACES
        // =====================================
        System.out.println("\n" + "█".repeat(60));
        System.out.println("8. POLYMORPHISM WITH INTERFACES");
        System.out.println("█".repeat(60));
        
        // Array of different objects implementing same interface
        AudioPlayer[] players = {
            new SimpleAudioPlayer(),
            new AdvancedMediaPlayer()
        };
        
        System.out.println("--- Polymorphic Audio Playing ---");
        for (AudioPlayer player : players) {
            System.out.println("Player type: " + player.getClass().getSimpleName());
            player.playAudio();
            player.stopAudio();
            System.out.println();
        }
        
        // Different loggers implementing same interface
        AdvancedLogger[] loggers = {
            new DatabaseLogger("TestDB"),
            new FileLogger("test.log")
        };
        
        System.out.println("--- Polymorphic Logging ---");
        for (AdvancedLogger logger : loggers) {
            System.out.println("Logger type: " + logger.getClass().getSimpleName());
            logger.logInfo("Polymorphic logging test");
        }
        
        System.out.println("\n" + "█".repeat(60));
        System.out.println("JAVA INTERFACES DEMONSTRATION COMPLETED");
        System.out.println("█".repeat(60));
    }
}

/*
 * Key Points About Interfaces: 
 * 
 * 1. DEFINITION & SYNTAX:
 *    - Blueprint of a class containing abstract methods and constants
 *    - Use 'interface' keyword to declare
 *    - Use 'implements' keyword in classes
 *    - Cannot be instantiated directly
 * 
 * 2. CHARACTERISTICS:
 *    - All methods implicitly public and abstract (before Java 8)
 *    - All variables implicitly public, static, and final
 *    - Support multiple inheritance
 *    - Can extend other interfaces
 * 
 * 3. MODERN FEATURES (Java 8+):
 *    - Default methods: Provide implementation in interface
 *    - Static methods: Utility methods in interface
 *    - Private methods (Java 9+): Helper methods for default methods
 *    - Private static methods (Java 9+): Helper methods for static methods
 * 
 * 4. FUNCTIONAL INTERFACES:
 *    - Interface with exactly one abstract method
 *    - Can be used with lambda expressions
 *    - @FunctionalInterface annotation for clarity
 *    - Foundation for Java 8's functional programming features
 * 
 * 5. INTERFACE INHERITANCE:
 *    - Interfaces can extend other interfaces
 *    - Implementing class must implement all methods from hierarchy
 *    - Multiple interface inheritance is allowed
 *    - Diamond problem doesn't exist (no state inheritance)
 * 
 * 6. MARKER INTERFACES:
 *    - Interfaces with no methods
 *    - Just mark or tag classes with certain capability
 *    - Examples: Serializable, Cloneable, RandomAccess
 * 
 * 7. INTERFACE SEGREGATION PRINCIPLE:
 *    - Clients shouldn't depend on interfaces they don't use
 *    - Create smaller, focused interfaces
 *    - Better than one large interface with many methods
 * 
 * 8. GENERIC INTERFACES:
 *    - Interfaces can use generic types
 *    - Provide type safety and reusability
 *    - Common in collections and repository patterns
 * 
 * 9. DEFAULT METHOD RESOLUTION:
 *    - If class implements multiple interfaces with same default method:
 *      a) Class implementation wins over interface default
 *      b) More specific interface wins
 *      c) Must override if ambiguous
 * 
 * 10. BEST PRACTICES:
 *     - Use interfaces to define contracts
 *     - Prefer interfaces over abstract classes for type definition
 *     - Keep interfaces focused and cohesive
 *     - Use default methods to evolve interfaces without breaking changes
 *     - Name interfaces with adjectives (-able, -ible) or nouns
 *     - Document interface contracts clearly
 * 
 * 11. WHEN TO USE INTERFACES:
 *     - Define contracts between components
 *     - Enable multiple inheritance of type
 *     - Support polymorphism
 *     - Create loosely coupled systems
 *     - Design APIs and frameworks
 * 
 * 12. INTERFACE VS ABSTRACT CLASS:
 *     - Interface: Multiple inheritance, no state, contract-focused
 *     - Abstract class: Single inheritance, can have state, IS-A relationship
 *     - Use interface for CAN-DO capabilities
 *     - Use abstract class for IS-A relationships with shared implementation
 */