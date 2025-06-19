/**
 * This class demonstrates the use of loop statements in Java
 */
public class LoopStatements {
    public static void main(String[] args) {
        System.out.println("=== Loop Statements in Java ===\n");
        
        // for loop
        System.out.println("--- for Loop ---");
        System.out.println("Counting from 1 to 5:");
        
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // New line
        
        // for loop with multiple variables
        System.out.println("\n--- for Loop with Multiple Variables ---");
        System.out.println("Counting up and down simultaneously:");
        
        for (int i = 1, j = 10; i <= 5; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }
        
        // for loop with custom increment
        System.out.println("\n--- for Loop with Custom Increment ---");
        System.out.println("Counting by 2s:");
        
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Nested for loops
        System.out.println("\n--- Nested for Loops ---");
        System.out.println("Multiplication table (1-5):");
        
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
        
        // Enhanced for loop (for-each)
        System.out.println("\n--- Enhanced for Loop (for-each) ---");
        
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Array elements:");
        
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Enhanced for loop with an array of strings
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Elderberry"};
        System.out.println("\nFruit list:");
        
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
        
        // while loop
        System.out.println("\n--- while Loop ---");
        
        int count = 1;
        System.out.println("Counting from 1 to 5 using while:");
        
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();
        
        // while loop for input validation (simulated)
        System.out.println("\n--- while Loop for Input Validation (simulated) ---");
        
        int userInput = -5; // Simulated invalid input
        
        System.out.println("Validating input: " + userInput);
        while (userInput < 0) {
            System.out.println("Invalid input. Must be non-negative.");
            userInput = 10; // Simulated valid input
            System.out.println("New input: " + userInput);
        }
        System.out.println("Valid input: " + userInput);
        
        // do-while loop
        System.out.println("\n--- do-while Loop ---");
        
        int doWhileCount = 1;
        System.out.println("Counting from 1 to 5 using do-while:");
        
        do {
            System.out.print(doWhileCount + " ");
            doWhileCount++;
        } while (doWhileCount <= 5);
        System.out.println();
        
        // do-while loop that executes at least once
        System.out.println("\n--- do-while Loop Executing at Least Once ---");
        
        int number = 10;
        
        do {
            System.out.println("This will execute once even though the condition is false");
        } while (number < 10);
        
        // Infinite loop with break
        System.out.println("\n--- Infinite Loop with break ---");
        
        int i = 1;
        System.out.println("Counting until 5 with an infinite loop and break:");
        
        while (true) {
            System.out.print(i + " ");
            i++;
            
            if (i > 5) {
                break; // Exit the loop when i is greater than 5
            }
        }
        System.out.println();
        
        // Using continue to skip iterations
        System.out.println("\n--- Using continue to Skip Iterations ---");
        System.out.println("Printing odd numbers from 1 to 10:");
        
        for (int j = 1; j <= 10; j++) {
            if (j % 2 == 0) {
                continue; // Skip even numbers
            }
            System.out.print(j + " ");
        }
        System.out.println();
        
        // Labeled break
        System.out.println("\n--- Labeled break ---");
        
        System.out.println("Using labeled break to exit nested loops:");
        
        outerLoop: 
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                System.out.println("Row: " + row + ", Column: " + col);
                
                if (row == 2 && col == 2) {
                    System.out.println("Found target! Breaking out of both loops.");
                    break outerLoop; // Break out of both loops
                }
            }
        }
        
        // Labeled continue
        System.out.println("\n--- Labeled continue ---");
        
        System.out.println("Using labeled continue to skip iterations of the outer loop:");
        
        outerLoop2: 
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                if (a == 2) {
                    System.out.println("Skipping row 2");
                    continue outerLoop2; // Skip to the next iteration of the outer loop
                }
                System.out.println("Row: " + a + ", Column: " + b);
            }
        }
        
        // Loop performance considerations
        System.out.println("\n--- Loop Performance Example ---");
        
        int size = 1000000;
        long[] bigArray = new long[size];
        
        // Initialize array
        for (int idx = 0; idx < size; idx++) {
            bigArray[idx] = idx;
        }
        
        // Time performance of different loops
        System.out.println("Timing different loop types for summing array elements:");
        
        // Standard for loop
        long startTime = System.currentTimeMillis();
        long sum1 = 0;
        for (int idx = 0; idx < bigArray.length; idx++) {
            sum1 += bigArray[idx];
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Standard for loop: " + (endTime - startTime) + "ms, Sum: " + sum1);
        
        // Enhanced for loop
        startTime = System.currentTimeMillis();
        long sum2 = 0;
        for (long value : bigArray) {
            sum2 += value;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Enhanced for loop: " + (endTime - startTime) + "ms, Sum: " + sum2);
        
        // While loop
        startTime = System.currentTimeMillis();
        long sum3 = 0;
        int index = 0;
        while (index < bigArray.length) {
            sum3 += bigArray[index];
            index++;
        }
        endTime = System.currentTimeMillis();
        System.out.println("While loop: " + (endTime - startTime) + "ms, Sum: " + sum3);
    }
}