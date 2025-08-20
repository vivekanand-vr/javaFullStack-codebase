/*
 * Understanding File Handling in Java
 */

/*
 * File handling in Java allows you to work with files and directories.
 * Java provides several classes for file operations:
 * 
 * Main Classes:
 * - File: Represents file and directory pathnames
 * - FileInputStream/FileOutputStream: For reading/writing bytes
 * - FileReader/FileWriter: For reading/writing characters
 * - BufferedReader/BufferedWriter: For efficient reading/writing
 * - Scanner: For reading formatted input
 * - PrintWriter: For formatted output
 * - Files (java.nio.file): Modern approach with utility methods
 * 
 * Common Operations:
 * - Creating, reading, writing, deleting files
 * - Checking file properties (exists, readable, writable)
 * - Working with directories
 */

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FileHandling {
    
    public static void main(String[] args) {
        System.out.println("=== Java File Handling Examples ===\n");
        
        // 1. File Class - Basic Operations
        System.out.println("1. File Class - Basic Operations:");
        demonstrateFileClass();
        
        // 2. Writing to Files
        System.out.println("\n2. Writing to Files:");
        writeToFileExample();
        
        // 3. Reading from Files
        System.out.println("\n3. Reading from Files:");
        readFromFileExample();
        
        // 4. Buffered Operations
        System.out.println("\n4. Buffered File Operations:");
        bufferedFileOperations();
        
        // 5. Scanner for File Reading
        System.out.println("\n5. Using Scanner for File Reading:");
        scannerFileReading();
        
        // 6. Modern NIO.2 Approach
        System.out.println("\n6. Modern NIO.2 File Operations:");
        nioFileOperations();
        
        // 7. Exception Handling
        System.out.println("\n7. Proper Exception Handling:");
        properExceptionHandling();
    }
    
    // 1. File Class Demonstrations
    public static void demonstrateFileClass() {
        try {
            // Creating File objects
            File file = new File("example.txt");
            File directory = new File("testDir");
            
            System.out.println("File name: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Parent directory: " + file.getParent());
            System.out.println("File exists: " + file.exists());
            System.out.println("Is file: " + file.isFile());
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Can read: " + file.canRead());
            System.out.println("Can write: " + file.canWrite());
            
            // Create directory if it doesn't exist
            if (!directory.exists()) {
                boolean created = directory.mkdir();
                System.out.println("Directory created: " + created);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // 2. Writing to Files - Different Methods
    public static void writeToFileExample() {
        // Method 1: FileWriter
        try (FileWriter writer = new FileWriter("output1.txt")) {
            writer.write("Hello, World!\n");
            writer.write("Writing with FileWriter\n");
            System.out.println("✓ File written using FileWriter");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
        
        // Method 2: PrintWriter
        try (PrintWriter pw = new PrintWriter("output2.txt")) {
            pw.println("Hello, World!");
            pw.println("Writing with PrintWriter");
            pw.printf("Formatted number: %.2f%n", 123.456);
            System.out.println("✓ File written using PrintWriter");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Method 3: FileOutputStream
        try (FileOutputStream fos = new FileOutputStream("output3.txt")) {
            String content = "Hello from FileOutputStream\n";
            fos.write(content.getBytes());
            System.out.println("✓ File written using FileOutputStream");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // 3. Reading from Files - Different Methods
    public static void readFromFileExample() {
        // Create a sample file first
        createSampleFile();
        
        // Method 1: FileReader
        try (FileReader reader = new FileReader("sample.txt")) {
            int character;
            System.out.print("FileReader output: ");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        // Method 2: FileInputStream
        try (FileInputStream fis = new FileInputStream("sample.txt")) {
            int byteData;
            System.out.print("FileInputStream output: ");
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // 4. Buffered File Operations for Better Performance
    public static void bufferedFileOperations() {
        String fileName = "buffered_example.txt";
        
        // Writing with BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Line 1: Buffered writing is efficient");
            bw.newLine();
            bw.write("Line 2: For large files");
            bw.newLine();
            bw.write("Line 3: Multiple lines example");
            System.out.println("✓ File written using BufferedWriter");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Reading with BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("BufferedReader output:");
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // 5. Using Scanner for File Reading
    public static void scannerFileReading() {
        createSampleDataFile();
        
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            System.out.println("Scanner file reading:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("  " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
        // Reading structured data
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            scanner.useDelimiter(",|\\n");
            System.out.println("Parsing structured data:");
            while (scanner.hasNext()) {
                String token = scanner.next().trim();
                if (!token.isEmpty()) {
                    System.out.println("  Token: " + token);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // 6. Modern NIO.2 File Operations (Java 7+)
    public static void nioFileOperations() {
        try {
            Path path = Paths.get("nio_example.txt");
            
            // Writing with Files class
            List<String> lines = new ArrayList<>();
            lines.add("Modern NIO.2 approach");
            lines.add("More efficient and feature-rich");
            lines.add("Supports atomic operations");
            
            Files.write(path, lines, StandardOpenOption.CREATE);
            System.out.println("✓ File written using NIO.2");
            
            // Reading with Files class
            List<String> readLines = Files.readAllLines(path);
            System.out.println("NIO.2 file content:");
            for (String line : readLines) {
                System.out.println("  " + line);
            }
            
            // File properties
            System.out.println("File size: " + Files.size(path) + " bytes");
            System.out.println("Is readable: " + Files.isReadable(path));
            System.out.println("Is writable: " + Files.isWritable(path));
            
        } catch (IOException e) {
            System.out.println("NIO Error: " + e.getMessage());
        }
    }
    
    // 7. Proper Exception Handling Example
    public static void properExceptionHandling() {
        String fileName = "exception_example.txt";
        
        // Try-with-resources for automatic resource management
        try (FileWriter writer = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(writer)) {
            
            bw.write("Proper exception handling example");
            bw.newLine();
            bw.write("Resources are automatically closed");
            System.out.println("✓ File operations completed successfully");
            
        } catch (IOException e) {
            System.err.println("I/O Error occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        
        // Reading with proper exception handling
        try (FileReader reader = new FileReader(fileName);
             BufferedReader br = new BufferedReader(reader)) {
            
            String line;
            System.out.println("Reading with proper exception handling:");
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    // Helper method to create sample file
    private static void createSampleFile() {
        try (PrintWriter pw = new PrintWriter("sample.txt")) {
            pw.println("This is line 1");
            pw.println("This is line 2");
            pw.println("This is line 3");
        } catch (FileNotFoundException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }
    
    // Helper method to create sample data file
    private static void createSampleDataFile() {
        try (PrintWriter pw = new PrintWriter("data.txt")) {
            pw.println("John,25,Engineer");
            pw.println("Alice,30,Doctor");
            pw.println("Bob,28,Teacher");
        } catch (FileNotFoundException e) {
            System.out.println("Error creating data file: " + e.getMessage());
        }
    }
}

/*
 * Key Points about File Handling in Java:
 * 
 * 1. CLASSES AND INTERFACES:
 *    - File: Abstract representation of file/directory paths
 *    - InputStream/OutputStream: For byte-oriented I/O
 *    - Reader/Writer: For character-oriented I/O
 *    - BufferedReader/BufferedWriter: For efficient I/O operations
 *    - Scanner: For parsing and reading formatted input
 *    - PrintWriter: For formatted output
 *    - Files (NIO.2): Modern utility class for file operations
 * 
 * 2. EXCEPTION HANDLING:
 *    - Always use try-with-resources for automatic resource management
 *    - Handle FileNotFoundException for file reading operations
 *    - Handle IOException for general I/O operations
 *    - Close streams properly to prevent resource leaks
 * 
 * 3. BEST PRACTICES:
 *    - Use BufferedReader/BufferedWriter for better performance
 *    - Prefer NIO.2 (Files class) for modern applications
 *    - Always handle exceptions appropriately
 *    - Use try-with-resources to ensure streams are closed
 *    - Check file existence before operations when necessary
 * 
 * 4. COMMON FILE OPERATIONS:
 *    - Reading: FileReader, BufferedReader, Scanner, Files.readAllLines()
 *    - Writing: FileWriter, BufferedWriter, PrintWriter, Files.write()
 *    - Byte operations: FileInputStream, FileOutputStream
 *    - File properties: exists(), isFile(), isDirectory(), length()
 *    - Directory operations: mkdir(), mkdirs(), list(), listFiles()
 * 
 * 5. NIO.2 ADVANTAGES (Java 7+):
 *    - Better performance and more features
 *    - Atomic file operations
 *    - Better exception handling
 *    - Support for file attributes and permissions
 *    - More intuitive API design
 * 
 * To compile and run:
 * javac FileHandling.java
 * java FileHandling
 */