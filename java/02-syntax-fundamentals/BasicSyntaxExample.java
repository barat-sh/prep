/**
 * This class demonstrates the basic syntax elements of Java
 */
public class BasicSyntaxExample {
    // Class variable (static field)
    private static int counter = 0;
    
    // Instance variable (non-static field)
    private String message;
    
    // Constant (static final field)
    public static final double PI = 3.14159;
    
    /**
     * Constructor for the class
     * @param message Initial message for this instance
     */
    public BasicSyntaxExample(String message) {
        this.message = message;
        counter++; // Increment the counter each time an object is created
    }
    
    /**
     * Main method - entry point of the program
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Local variable
        int localVar = 10;
        
        // Create objects of the class
        BasicSyntaxExample example1 = new BasicSyntaxExample("Hello");
        BasicSyntaxExample example2 = new BasicSyntaxExample("World");
        
        // Print messages
        example1.printMessage();
        example2.printMessage();
        
        // Print the counter value
        System.out.println("Number of objects created: " + counter);
        
        // Using the constant
        System.out.println("Value of PI: " + PI);
        
        // Demonstrate if-else statement
        if (localVar > 5) {
            System.out.println("Local variable is greater than 5");
        } else {
            System.out.println("Local variable is not greater than 5");
        }
        
        // Demonstrate for loop
        System.out.println("Counting from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // Print a new line
    }
    
    /**
     * Method to print the message stored in this object
     */
    public void printMessage() {
        System.out.println("Message: " + message);
    }
    
    /**
     * Method to change the message
     * @param newMessage The new message to set
     */
    public void setMessage(String newMessage) {
        this.message = newMessage;
    }
    
    /**
     * Method to get the message
     * @return The current message
     */
    public String getMessage() {
        return this.message;
    }
}