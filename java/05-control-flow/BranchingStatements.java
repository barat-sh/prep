import java.util.Scanner;

/**
 * This class demonstrates the use of branching statements in Java
 */
public class BranchingStatements {
    public static void main(String[] args) {
        System.out.println("=== Branching Statements in Java ===\n");
        
        // break statement in a loop
        System.out.println("--- break in a for Loop ---");
        System.out.println("Counting from 1 to 10, but stop at 5:");
        
        for (int i = 1; i <= 10; i++) {
            if (i > 5) {
                System.out.println("Breaking the loop at i = " + i);
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println("\nLoop is finished.");
        
        // break in a while loop
        System.out.println("\n--- break in a while Loop ---");
        System.out.println("Processing numbers until we find a multiple of 7:");
        
        int num = 1;
        while (true) {
            System.out.print(num + " ");
            
            if (num % 7 == 0) {
                System.out.println("\nFound a multiple of 7: " + num);
                break;
            }
            
            num++;
        }
        
        // break in a switch statement
        System.out.println("\n--- break in a switch Statement ---");
        
        int day = 3;
        String dayName;
        
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }
        
        System.out.println("Day " + day + " is " + dayName);
        
        // Missing break in switch (fall-through)
        System.out.println("\n--- Fall-Through in switch (Missing break) ---");
        
        char grade = 'B';
        
        switch (grade) {
            case 'A':
                System.out.println("Excellent!");
                break;
            case 'B':
                System.out.println("Good!");
                // Missing break statement - will fall through to case 'C'
            case 'C':
                System.out.println("OK.");
                break;
            case 'D':
                System.out.println("Need to improve.");
                break;
            case 'F':
                System.out.println("Fail.");
                break;
            default:
                System.out.println("Invalid grade.");
        }
        
        // continue statement
        System.out.println("\n--- continue Statement ---");
        System.out.println("Printing only even numbers from 1 to 10:");
        
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue; // Skip odd numbers
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // continue in a while loop
        System.out.println("\n--- continue in a while Loop ---");
        System.out.println("Printing multiples of 3 from 1 to 20:");
        
        int counter = 0;
        while (counter < 20) {
            counter++;
            
            if (counter % 3 != 0) {
                continue; // Skip non-multiples of 3
            }
            
            System.out.print(counter + " ");
        }
        System.out.println();
        
        // Labeled break
        System.out.println("\n--- Labeled break ---");
        
        outerLoop:
        for (int i = 1; i <= 3; i++) {
            System.out.println("Outer loop iteration: " + i);
            
            for (int j = 1; j <= 5; j++) {
                System.out.println("  Inner loop iteration: " + j);
                
                if (i == 2 && j == 3) {
                    System.out.println("  Breaking out of both loops when i=" + i + " and j=" + j);
                    break outerLoop;
                }
            }
        }
        System.out.println("After both loops");
        
        // Labeled continue
        System.out.println("\n--- Labeled continue ---");
        
        outerLoop:
        for (int i = 1; i <= 3; i++) {
            System.out.println("Outer loop iteration: " + i);
            
            for (int j = 1; j <= 5; j++) {
                if (j == 3) {
                    System.out.println("  Skipping to next outer loop iteration when j=" + j);
                    continue outerLoop;
                }
                System.out.println("  Inner loop iteration: " + j);
            }
            System.out.println("End of outer loop iteration: " + i);
        }
        
        // return statement in a method
        System.out.println("\n--- return Statement ---");
        int result = add(5, 3);
        System.out.println("5 + 3 = " + result);
        
        // Early return based on condition
        System.out.println("\nChecking if 7 is prime: " + isPrime(7));
        System.out.println("Checking if 4 is prime: " + isPrime(4));
        
        // Using return to exit the program
        if (false) { // Changed to false to allow the program to continue
            System.out.println("Exiting the program...");
            return; // Exit the main method (and the program)
        }
        
        // Finding first occurrence in an array
        System.out.println("\n--- Finding First Occurrence ---");
        int[] numbers = {10, 20, 30, 40, 50, 30, 60};
        int target = 30;
        
        int index = findFirstOccurrence(numbers, target);
        if (index != -1) {
            System.out.println("First occurrence of " + target + " is at index: " + index);
        } else {
            System.out.println(target + " not found in the array.");
        }
        
        // Simulating a menu system
        System.out.println("\n--- Menu System Simulation ---");
        simulateMenu();
        
        System.out.println("\nProgram execution complete.");
    }
    
    /**
     * Adds two numbers and returns the result
     */
    public static int add(int a, int b) {
        return a + b; // Return the sum immediately
    }
    
    /**
     * Checks if a number is prime
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // Early return for non-positive numbers
        }
        
        if (number <= 3) {
            return true; // Early return for 2 and 3
        }
        
        if (number % 2 == 0 || number % 3 == 0) {
            return false; // Early return for numbers divisible by 2 or 3
        }
        
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false; // Early return if divisible
            }
        }
        
        return true; // If we reach here, the number is prime
    }
    
    /**
     * Finds the first occurrence of a value in an array
     */
    public static int findFirstOccurrence(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return the index when found
            }
        }
        return -1; // Return -1 if not found
    }
    
    /**
     * Simulates a menu system using branching statements
     */
    public static void simulateMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\nMenu Options:");
            System.out.println("1. Option One");
            System.out.println("2. Option Two");
            System.out.println("3. Option Three");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            
            // Use a predefined choice for simulation
            int choice = 4; // Simulating user input of 4 to exit
            System.out.println(choice);
            
            switch (choice) {
                case 1:
                    System.out.println("You selected Option One");
                    break;
                case 2:
                    System.out.println("You selected Option Two");
                    break;
                case 3:
                    System.out.println("You selected Option Three");
                    break;
                case 4:
                    System.out.println("Exiting the menu...");
                    running = false; // Set flag to exit the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        System.out.println("Menu system closed.");
    }
}