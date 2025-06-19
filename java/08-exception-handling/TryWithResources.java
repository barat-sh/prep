import java.io.*;
import java.util.Scanner;

/**
 * This class demonstrates the try-with-resources feature in Java 7+
 */
public class TryWithResources {
    public static void main(String[] args) {
        System.out.println("=== Try-with-resources in Java ===\n");
        
        // 1. Basic try-with-resources
        System.out.println("1. Basic try-with-resources with AutoCloseable:");
        
        try (MyAutoCloseable resource = new MyAutoCloseable("Resource 1")) {
            System.out.println("Using resource in try block");
            resource.doSomething();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        // 2. Multiple resources in try-with-resources
        System.out.println("\n2. Multiple resources in try-with-resources:");
        
        try (MyAutoCloseable resource1 = new MyAutoCloseable("Resource 1");
             MyAutoCloseable resource2 = new MyAutoCloseable("Resource 2")) {
            
            System.out.println("Using multiple resources in try block");
            resource1.doSomething();
            resource2.doSomething();
            
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        // 3. Resource that throws exception during close
        System.out.println("\n3. Resource that throws exception during close:");
        
        try (ExceptionalResource resource = new ExceptionalResource()) {
            System.out.println("Using exceptional resource");
            // No exception in try block
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        // 4. Exception in try block with exception during close
        System.out.println("\n4. Exception in try block with exception during close:");
        
        try (ExceptionalResource resource = new ExceptionalResource()) {
            System.out.println("Using exceptional resource");
            throw new Exception("Exception in try block");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            
            // Get suppressed exceptions (exceptions from closing resources)
            Throwable[] suppressedExceptions = e.getSuppressed();
            System.out.println("Number of suppressed exceptions: " + suppressedExceptions.length);
            
            for (Throwable suppressed : suppressedExceptions) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
        
        // 5. Working with files using try-with-resources
        System.out.println("\n5. File I/O with try-with-resources:");
        
        // Create a temporary file for demonstration
        File tempFile = createTempFile();
        
        if (tempFile != null) {
            // Write to file using try-with-resources
            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write("Hello, World!\n");
                writer.write("This is a demonstration of try-with-resources with files.\n");
                System.out.println("Successfully wrote to file: " + tempFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
            
            // Read from file using try-with-resources
            try (FileReader fr = new FileReader(tempFile);
                 BufferedReader reader = new BufferedReader(fr)) {
                
                System.out.println("\nReading file contents:");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
            
            // Clean up
            tempFile.delete();
        }
        
        // 6. Scanner with try-with-resources (useful for reading from System.in)
        System.out.println("\n6. Scanner with try-with-resources (demonstration):");
        
        // Using a string input instead of System.in for this example
        String input = "Line 1\nLine 2\nLine 3";
        
        try (Scanner scanner = new Scanner(new StringReader(input))) {
            System.out.println("Reading lines from input:");
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Read: " + line);
            }
        }
        
        // 7. Database connection example (simulated)
        System.out.println("\n7. Database connection example (simulated):");
        
        try (DatabaseConnection connection = new DatabaseConnection("jdbc:sample:database")) {
            System.out.println("Connected to database");
            connection.executeQuery("SELECT * FROM users");
        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
        
        // 8. Try-with-resources compared to traditional try-finally
        System.out.println("\n8. Comparison with traditional try-finally:");
        
        // Using try-with-resources
        System.out.println("\nUsing try-with-resources:");
        try (MyAutoCloseable resource = new MyAutoCloseable("Clean Resource")) {
            resource.doSomething();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
        // Using traditional try-finally
        System.out.println("\nUsing traditional try-finally:");
        MyAutoCloseable traditionalResource = null;
        try {
            traditionalResource = new MyAutoCloseable("Traditional Resource");
            traditionalResource.doSomething();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            if (traditionalResource != null) {
                try {
                    traditionalResource.close();
                } catch (Exception e) {
                    System.out.println("Exception during close: " + e.getMessage());
                }
            }
        }
        
        System.out.println("\nEnd of try-with-resources demonstration.");
    }
    
    /**
     * Creates a temporary file for demonstration purposes
     */
    private static File createTempFile() {
        try {
            File tempFile = File.createTempFile("demo", ".txt");
            tempFile.deleteOnExit(); // Will be deleted when JVM exits
            return tempFile;
        } catch (IOException e) {
            System.out.println("Could not create temporary file: " + e.getMessage());
            return null;
        }
    }
}

/**
 * A simple class that implements AutoCloseable
 */
class MyAutoCloseable implements AutoCloseable {
    private String name;
    
    public MyAutoCloseable(String name) {
        this.name = name;
        System.out.println(name + " created");
    }
    
    public void doSomething() throws Exception {
        System.out.println(name + " doing something");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println(name + " closed");
    }
}

/**
 * A resource that throws an exception during close
 */
class ExceptionalResource implements AutoCloseable {
    public ExceptionalResource() {
        System.out.println("ExceptionalResource created");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("ExceptionalResource about to throw exception during close");
        throw new Exception("Exception during resource closing");
    }
}

/**
 * A simulated database connection class
 */
class DatabaseConnection implements AutoCloseable {
    private String url;
    private boolean connected;
    
    public DatabaseConnection(String url) throws Exception {
        this.url = url;
        
        // Simulate connection process
        System.out.println("Connecting to database: " + url);
        
        // Simulate connection success
        this.connected = true;
    }
    
    public void executeQuery(String query) throws Exception {
        if (!connected) {
            throw new Exception("Not connected to database");
        }
        
        System.out.println("Executing query: " + query);
        // Simulate query execution
        System.out.println("Query executed successfully");
    }
    
    @Override
    public void close() throws Exception {
        if (connected) {
            System.out.println("Closing database connection to: " + url);
            connected = false;
        }
    }
}