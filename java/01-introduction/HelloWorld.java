/**
 * This is a simple Hello World program in Java.
 * It demonstrates the basic structure of a Java application.
 */
public class HelloWorld {
    /**
     * The main method is the entry point for all Java applications.
     * The JVM looks for this method to start the program execution.
     * 
     * @param args Command line arguments passed to the program
     */
    public static void main(String[] args) {
        // Print a message to the console
        System.out.println("Hello, World!");
        
        // Print information about Java version
        System.out.println("\nJava Version Information:");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Runtime Version: " + System.getProperty("java.runtime.version"));
        System.out.println("Java Home: " + System.getProperty("java.home"));
        System.out.println("Java Vendor: " + System.getProperty("java.vendor"));
        
        // If command line arguments were provided, print them
        if (args.length > 0) {
            System.out.println("\nCommand line arguments:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("Argument " + (i + 1) + ": " + args[i]);
            }
        }
    }
}