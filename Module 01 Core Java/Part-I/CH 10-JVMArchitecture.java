/*
 * Understanding JVM (Java Virtual Machine) Architecture
 */

/*
 * JVM ARCHITECTURE OVERVIEW:
 * ========================
 * 
 * The Java Virtual Machine (JVM) is the runtime environment that executes Java bytecode.
 * It provides platform independence by abstracting the underlying operating system.
 * 
 * JVM ARCHITECTURE COMPONENTS:
 * ===========================
 * 
 * 1. CLASS LOADER SUBSYSTEM
 * -------------------------
 * Responsible for loading .class files into memory.
 * 
 * Three Types of Class Loaders:
 * a) Bootstrap Class Loader (Primordial Class Loader)
 *    - Loads core Java API classes (java.lang.*, java.util.*, etc.)
 *    - Located in JRE/lib/rt.jar
 *    - Written in native code (C/C++)
 *    - Parent of all other class loaders
 * 
 * b) Extension Class Loader (Platform Class Loader in Java 9+)
 *    - Loads classes from JRE/lib/ext directory
 *    - Child of Bootstrap class loader
 *    - Loads optional packages and extensions
 * 
 * c) Application Class Loader (System Class Loader)
 *    - Loads classes from application classpath
 *    - Child of Extension class loader
 *    - Loads user-defined classes
 * 
 * Class Loading Process:
 * 1. Loading: Reading .class file and creating Class object
 * 2. Linking: Verification, Preparation, Resolution
 *    - Verification: Checks bytecode validity
 *    - Preparation: Allocates memory for static variables
 *    - Resolution: Converts symbolic references to direct references
 * 3. Initialization: Executes static blocks and initializes static variables
 * 
 * 2. JVM MEMORY AREAS
 * ===================
 * 
 * A) HEAP MEMORY (Runtime Data Area)
 * ----------------------------------
 * - Stores objects and instance variables
 * - Shared among all threads
 * - Garbage collected
 * - Divided into generations:
 *   * Young Generation:
 *     - Eden Space: Where new objects are allocated
 *     - Survivor Spaces (S0, S1): Objects that survived first GC
 *   * Old Generation (Tenured Space):
 *     - Long-lived objects promoted from Young Generation
 *   * Metaspace (Java 8+) / Permanent Generation (Java 7-)
 *     - Stores class metadata, constant pool
 * 
 * B) NON-HEAP MEMORY
 * ------------------
 * - Method Area (Metaspace in Java 8+)
 *   * Stores class-level data: class metadata, constant pool, static variables
 *   * Shared among all threads
 *   * Logically part of heap but treated separately
 * 
 * - PC (Program Counter) Register
 *   * Stores address of currently executing instruction
 *   * Each thread has its own PC register
 *   * Points to method area for Java methods
 * 
 * - JVM Stack
 *   * Stores method call frames
 *   * Each thread has its own stack
 *   * Contains local variables, partial results, method parameters
 *   * LIFO (Last In First Out) structure
 * 
 * - Native Method Stack
 *   * Used for native method calls (JNI - Java Native Interface)
 *   * Each thread has its own native method stack
 *   * Stores native method information
 * 
 * - Direct Memory
 *   * Off-heap memory used by NIO operations
 *   * Not part of JVM heap but limited by available system memory
 * 
 * 3. EXECUTION ENGINE
 * ===================
 * 
 * A) INTERPRETER
 * --------------
 * - Reads and executes bytecode line by line
 * - Slower execution but faster startup
 * - No compilation overhead initially
 * 
 * B) JUST-IN-TIME (JIT) COMPILER
 * -------------------------------
 * - Compiles frequently executed bytecode to native machine code
 * - Improves performance through optimization
 * - Two types:
 *   * C1 Compiler (Client): Fast compilation, basic optimization
 *   * C2 Compiler (Server): Slower compilation, advanced optimization
 * - Tiered Compilation: Uses both C1 and C2 based on method usage
 * 
 * C) GARBAGE COLLECTOR (GC)
 * --------------------------
 * - Automatically manages memory by removing unused objects
 * - Various algorithms:
 *   * Serial GC: Single-threaded, suitable for small applications
 *   * Parallel GC: Multi-threaded, default for server applications
 *   * G1 GC: Low-latency collector for large heaps
 *   * ZGC, Shenandoah: Ultra-low latency collectors
 * 
 * 4. NATIVE METHOD INTERFACE (JNI)
 * =================================
 * - Bridge between Java and native code (C/C++)
 * - Allows Java to call native methods
 * - Enables integration with system-level functionality
 * 
 * 5. NATIVE METHOD LIBRARIES
 * ===========================
 * - Collection of native libraries (.so, .dll, .dylib files)
 * - Provides platform-specific functionality
 * - Examples: file I/O, network operations, GUI operations
 * 
 * JAVA COMPILATION AND EXECUTION PROCESS:
 * =======================================
 * 
 * 1. Source Code (.java files)
 *    ↓
 * 2. Java Compiler (javac) → Bytecode (.class files)
 *    ↓
 * 3. Class Loader → Loads classes into JVM memory
 *    ↓
 * 4. Bytecode Verifier → Verifies code safety
 *    ↓
 * 5. Execution Engine → Interprets/Compiles bytecode
 *    ↓
 * 6. Runtime → Executes the program
 * 
 * MEMORY MANAGEMENT:
 * ==================
 * 
 * OBJECT CREATION FLOW:
 * 1. New objects allocated in Eden space (Young Generation)
 * 2. When Eden fills up, minor GC triggered
 * 3. Surviving objects moved to Survivor space (S0 or S1)
 * 4. Objects that survive multiple GC cycles promoted to Old Generation
 * 5. When Old Generation fills up, major GC triggered
 * 6. Full GC cleans both Young and Old generations
 * 
 * GARBAGE COLLECTION TYPES:
 * - Minor GC: Cleans Young Generation only
 * - Major GC: Cleans Old Generation only
 * - Full GC: Cleans entire heap (expensive operation)
 * 
 * JVM TUNING PARAMETERS:
 * ======================
 * 
 * Heap Size:
 * -Xms<size>    : Initial heap size
 * -Xmx<size>    : Maximum heap size
 * -Xmn<size>    : Young generation size
 * 
 * Garbage Collection:
 * -XX:+UseG1GC              : Use G1 garbage collector
 * -XX:+UseParallelGC        : Use parallel garbage collector
 * -XX:MaxGCPauseMillis=<n>  : Target max GC pause time
 * 
 * Memory Areas:
 * -XX:MetaspaceSize=<size>  : Initial metaspace size
 * -XX:MaxMetaspaceSize=<size> : Maximum metaspace size
 * -Xss<size>                : Thread stack size
 * 
 * JIT Compilation:
 * -XX:+TieredCompilation    : Enable tiered compilation
 * -XX:CompileThreshold=<n>  : Number of invocations before JIT compilation
 * 
 * PLATFORM INDEPENDENCE:
 * ======================
 * 
 * "Write Once, Run Anywhere" (WORA) is achieved through:
 * 1. Bytecode: Platform-neutral intermediate representation
 * 2. JVM: Platform-specific virtual machine
 * 3. Standard APIs: Consistent interface across platforms
 * 
 * Each platform has its own JVM implementation:
 * - Windows: JVM compiled for Windows
 * - Linux: JVM compiled for Linux
 * - macOS: JVM compiled for macOS
 * - Same bytecode runs on all platforms
 * 
 * JVM vs JRE vs JDK:
 * ==================
 * 
 * JVM (Java Virtual Machine):
 * - Runtime environment for executing Java bytecode
 * - Platform-specific implementation
 * - Core component for running Java applications
 * 
 * JRE (Java Runtime Environment):
 * - JVM + Core Libraries + Other Components
 * - Required to run Java applications
 * - Does not include development tools
 * 
 * JDK (Java Development Kit):
 * - JRE + Development Tools (javac, debugger, etc.)
 * - Required for Java development
 * - Includes everything needed to develop and run Java applications
 * 
 * PERFORMANCE OPTIMIZATIONS:
 * ==========================
 * 
 * 1. Method Inlining: JIT replaces method calls with method body
 * 2. Dead Code Elimination: Removes unused code
 * 3. Loop Optimization: Unrolls small loops
 * 4. Escape Analysis: Allocates objects on stack if they don't escape method
 * 5. Branch Prediction: Optimizes conditional statements
 * 6. Constant Folding: Computes constants at compile time
 * 
 * MONITORING AND PROFILING:
 * =========================
 * 
 * Tools for JVM monitoring:
 * - jps: List Java processes
 * - jstat: JVM statistics
 * - jmap: Memory map and histogram
 * - jstack: Thread dump
 * - jcmd: Diagnostic commands
 * - jvisualvm: Visual profiling tool
 * - Java Flight Recorder (JFR): Low-overhead profiling
 * 
 * SECURITY FEATURES:
 * ==================
 * 
 * 1. Bytecode Verification: Ensures code safety before execution
 * 2. Security Manager: Controls access to system resources
 * 3. Classloader Security: Prevents malicious class loading
 * 4. Sandbox Model: Restricts applet capabilities
 * 5. Cryptographic APIs: Built-in security libraries
 */

public class JVMArchitecture {
    
    // Static block to demonstrate class loading process
    static {
        System.out.println("Static block executed during class loading/initialization");
    }
    
    public static void main(String[] args) {
        System.out.println("=== JVM Architecture Demonstration ===\n");
        
        // 1. Demonstrate Class Loading
        demonstrateClassLoading();
        
        // 2. Demonstrate Memory Areas
        demonstrateMemoryAreas();
        
        // 3. Demonstrate JVM Information
        demonstrateJVMInfo();
        
        // 4. Demonstrate Garbage Collection
        demonstrateGarbageCollection();
        
        // 5. Demonstrate JIT Compilation (Conceptual)
        demonstrateJITCompilation();
        
        System.out.println("\n=== JVM Architecture Demo Complete ===");
    }
    
    // Demonstrate class loading hierarchy
    private static void demonstrateClassLoading() {
        System.out.println("1. Class Loading Demonstration:");
        
        // Get current class loader
        ClassLoader appClassLoader = JVMArchitecture.class.getClassLoader();
        System.out.println("Application Class Loader: " + appClassLoader);
        
        // Get parent class loaders
        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println("Extension Class Loader: " + extClassLoader);
        
        // Bootstrap class loader returns null (implemented in native code)
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println("Bootstrap Class Loader: " + bootstrapClassLoader);
        
        // Class loaders for system classes
        System.out.println("String class loader: " + String.class.getClassLoader());
        System.out.println("ArrayList class loader: " + java.util.ArrayList.class.getClassLoader());
    }
    
    // Demonstrate memory areas with runtime information
    private static void demonstrateMemoryAreas() {
        System.out.println("\n2. Memory Areas Demonstration:");
        
        Runtime runtime = Runtime.getRuntime();
        
        // Heap memory information
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        
        System.out.println("Heap Memory Information:");
        System.out.println("Max Memory (Xmx): " + formatBytes(maxMemory));
        System.out.println("Total Memory: " + formatBytes(totalMemory));
        System.out.println("Used Memory: " + formatBytes(usedMemory));
        System.out.println("Free Memory: " + formatBytes(freeMemory));
        
        // Available processors (affects GC and compilation)
        System.out.println("Available Processors: " + runtime.availableProcessors());
        
        // Stack memory demonstration (each method call creates a stack frame)
        System.out.println("\nStack Frame Demonstration:");
        stackFrameDemo(1);
    }
    
    // Recursive method to demonstrate stack frames
    private static void stackFrameDemo(int level) {
        if (level <= 3) {
            System.out.println("Stack Level " + level + " - Local variable in stack frame");
            stackFrameDemo(level + 1);
        }
    }
    
    // Demonstrate JVM system properties and information
    private static void demonstrateJVMInfo() {
        System.out.println("\n3. JVM Information:");
        
        // JVM version and vendor
        System.out.println("JVM Name: " + System.getProperty("java.vm.name"));
        System.out.println("JVM Version: " + System.getProperty("java.vm.version"));
        System.out.println("JVM Vendor: " + System.getProperty("java.vm.vendor"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Home: " + System.getProperty("java.home"));
        
        // Platform information
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Architecture: " + System.getProperty("os.arch"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        
        // Classpath information
        System.out.println("Class Path: " + System.getProperty("java.class.path"));
        System.out.println("Library Path: " + System.getProperty("java.library.path"));
    }
    
    // Demonstrate garbage collection concepts
    private static void demonstrateGarbageCollection() {
        System.out.println("\n4. Garbage Collection Demonstration:");
        
        Runtime runtime = Runtime.getRuntime();
        
        // Memory before object creation
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory before object creation: " + formatBytes(memoryBefore));
        
        // Create many objects to trigger garbage collection
        createTemporaryObjects();
        
        // Memory after object creation
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory after object creation: " + formatBytes(memoryAfter));
        
        // Suggest garbage collection
        System.out.println("Requesting Garbage Collection...");
        System.gc();
        
        // Memory after GC
        long memoryAfterGC = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory after GC: " + formatBytes(memoryAfterGC));
    }
    
    // Helper method to create temporary objects
    private static void createTemporaryObjects() {
        for (int i = 0; i < 100000; i++) {
            String temp = new String("Object " + i);
        }
    }
    
    // Demonstrate JIT compilation conceptually
    private static void demonstrateJITCompilation() {
        System.out.println("\n5. JIT Compilation Demonstration:");
        
        System.out.println("JIT (Just-In-Time) Compilation converts bytecode into native machine code");
        System.out.println("to improve runtime performance. Let's run a loop-heavy method to give JIT");
        System.out.println("an opportunity to optimize it at runtime.\n");
        
        long start = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += Math.sqrt(i);
        }
        long end = System.nanoTime();
        
        System.out.println("Computation result: " + sum);
        System.out.println("Execution time (nanoseconds): " + (end - start));
    }
    
    // Utility method to format bytes
    private static String formatBytes(long bytes) {
        double kb = bytes / 1024.0;
        double mb = kb / 1024.0;
        return String.format("%d bytes (%.2f KB, %.2f MB)", bytes, kb, mb);
    }
}