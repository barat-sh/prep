/**
 * This class demonstrates basic exception handling in Java
 */
public class BasicExceptionHandling {
    public static void main(String[] args) {
        System.out.println("=== Basic Exception Handling in Java ===\n");
        
        // 1. Try-catch with a single exception
        System.out.println("1. Try-catch with ArithmeticException:");
        try {
            int result = 10 / 0; // This will throw ArithmeticException
            System.out.println("Result: " + result); // This line will not be executed
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
            System.out.println("Cannot divide by zero!");
        }
        System.out.println("Continuing after the exception...\n");
        
        // 2. Try-catch with multiple catch blocks
        System.out.println("2. Try-catch with multiple catch blocks:");
        try {
            String str = null;
            // The following line will throw NullPointerException
            System.out.println("String length: " + str.length());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception: " + e.getMessage());
            System.out.println("You tried to use a null object reference");
        } catch (Exception e) {
            System.out.println("Generic exception: " + e.getMessage());
        }
        System.out.println("Continuing after multiple catch blocks...\n");
        
        // 3. Try-catch-finally block
        System.out.println("3. Try-catch-finally block:");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing element at index 5: " + numbers[5]);
            // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index exception: " + e.getMessage());
            System.out.println("You tried to access an index that doesn't exist");
        } finally {
            System.out.println("This finally block always executes, regardless of exception");
        }
        System.out.println("Continuing after try-catch-finally...\n");
        
        // 4. Multiple exceptions in one catch block (Java 7+)
        System.out.println("4. Multiple exceptions in one catch block (Java 7+):");
        try {
            String str = args[0]; // Might throw ArrayIndexOutOfBoundsException
            int num = Integer.parseInt(str); // Might throw NumberFormatException
            System.out.println("Parsed number: " + num);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Caught either ArrayIndexOutOfBoundsException or NumberFormatException");
            System.out.println("Exception: " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        System.out.println("Continuing after multi-catch...\n");
        
        // 5. Nested try-catch blocks
        System.out.println("5. Nested try-catch blocks:");
        try {
            System.out.println("Outer try block");
            try {
                System.out.println("Inner try block");
                int result = 10 / 0; // This will throw ArithmeticException
                System.out.println("This won't be printed");
            } catch (NullPointerException e) {
                System.out.println("Inner catch: NullPointerException");
            }
            System.out.println("This won't be printed either");
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: ArithmeticException: " + e.getMessage());
        }
        System.out.println("Continuing after nested try-catch...\n");
        
        // 6. Catching the parent exception class
        System.out.println("6. Catching the parent exception class:");
        try {
            String str = "abc";
            int num = Integer.parseInt(str); // This will throw NumberFormatException
            System.out.println("Parsed number: " + num);
        } catch (Exception e) {
            System.out.println("Caught exception type: " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
        }
        System.out.println("Continuing after catching parent exception...\n");
        
        // 7. Getting detailed exception information
        System.out.println("7. Getting detailed exception information:");
        try {
            methodThatThrowsException();
        } catch (Exception e) {
            System.out.println("Exception type: " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Stack trace:");
            e.printStackTrace();
        }
        System.out.println("\nContinuing after getting detailed exception info...\n");
        
        // 8. Using exception for control flow (not recommended in general)
        System.out.println("8. Using exceptions for control flow (demonstration only):");
        try {
            findNeedle("haystack haystack needle haystack");
        } catch (Exception e) {
            // This approach is generally not recommended for normal control flow
            System.out.println("Demonstration only: " + e.getMessage());
        }
        
        // 9. Try-with-resources (Java 7+)
        System.out.println("\n9. Try-with-resources (Java 7+):");
        try (AutoCloseable resource = new MyResource()) {
            System.out.println("Using resource in try-with-resources");
            // Resource will be automatically closed after this block
        } catch (Exception e) {
            System.out.println("Exception while using resource: " + e.getMessage());
        }
        
        System.out.println("\nEnd of main method. Program completed successfully.");
    }
    
    /**
     * Method that throws an exception to demonstrate stack trace
     */
    public static void methodThatThrowsException() throws Exception {
        anotherMethod();
    }
    
    /**
     * Helper method to create a deeper stack trace
     */
    public static void anotherMethod() throws Exception {
        throw new Exception("This is a demonstration exception with stack trace");
    }
    
    /**
     * Method that uses exception for control flow (not recommended practice)
     */
    public static void findNeedle(String haystack) throws Exception {
        if (!haystack.contains("needle")) {
            throw new Exception("Needle not found in haystack");
        }
        System.out.println("Found needle at position: " + haystack.indexOf("needle"));
    }
}

/**
 * A simple class that implements AutoCloseable for try-with-resources demonstration
 */
class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("Resource created");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("Resource closed automatically");
    }
}