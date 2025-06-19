/**
 * This class demonstrates the basics of arrays in Java
 */
public class ArrayBasics {
    public static void main(String[] args) {
        System.out.println("=== Array Basics in Java ===\n");
        
        // Array declaration and initialization methods
        System.out.println("--- Array Declaration and Initialization ---");
        
        // Method 1: Declaration and allocation separately
        int[] numbers;       // Declare array
        numbers = new int[5]; // Allocate memory for 5 integers
        
        // Initializing elements one by one
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        
        System.out.println("Method 1 - numbers array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
        
        // Method 2: Declaration, allocation, and initialization in one step
        int[] primes = new int[] {2, 3, 5, 7, 11, 13};
        
        System.out.println("\nMethod 2 - primes array:");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
        System.out.println();
        
        // Method 3: Shorthand initialization (compiler infers the size)
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Elderberry"};
        
        System.out.println("\nMethod 3 - fruits array:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        // Array of different data types
        System.out.println("\n--- Arrays of Different Data Types ---");
        
        // Character array
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        System.out.println("Vowels:");
        for (char vowel : vowels) {
            System.out.print(vowel + " ");
        }
        System.out.println();
        
        // Boolean array
        boolean[] flags = {true, false, true, false, true};
        System.out.println("\nFlags:");
        for (int i = 0; i < flags.length; i++) {
            System.out.println("flags[" + i + "] = " + flags[i]);
        }
        
        // Double array
        double[] measurements = {1.2, 3.4, 5.6, 7.8, 9.0};
        System.out.println("\nMeasurements:");
        for (double measurement : measurements) {
            System.out.print(measurement + " ");
        }
        System.out.println();
        
        // Default values of array elements
        System.out.println("\n--- Default Values of Array Elements ---");
        
        int[] intArray = new int[3];
        double[] doubleArray = new double[3];
        boolean[] booleanArray = new boolean[3];
        String[] stringArray = new String[3];
        
        System.out.println("Default values for int array: " + intArray[0] + ", " + intArray[1] + ", " + intArray[2]);
        System.out.println("Default values for double array: " + doubleArray[0] + ", " + doubleArray[1] + ", " + doubleArray[2]);
        System.out.println("Default values for boolean array: " + booleanArray[0] + ", " + booleanArray[1] + ", " + booleanArray[2]);
        System.out.println("Default values for String array: " + stringArray[0] + ", " + stringArray[1] + ", " + stringArray[2]);
        
        // Array properties
        System.out.println("\n--- Array Properties ---");
        
        System.out.println("Length of numbers array: " + numbers.length);
        System.out.println("Length of fruits array: " + fruits.length);
        
        // Accessing elements and boundary checking
        System.out.println("\n--- Array Access and Boundaries ---");
        
        System.out.println("First element of numbers: " + numbers[0]);
        System.out.println("Last element of numbers: " + numbers[numbers.length - 1]);
        
        // Trying to access elements outside of bounds causes ArrayIndexOutOfBoundsException
        try {
            System.out.println("Trying to access an element outside of bounds...");
            int value = numbers[10]; // This will throw an exception
            System.out.println("This line will not be executed");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // Modifying array elements
        System.out.println("\n--- Modifying Array Elements ---");
        
        System.out.println("Original value at numbers[2]: " + numbers[2]);
        numbers[2] = 300; // Change the value
        System.out.println("Modified value at numbers[2]: " + numbers[2]);
        
        // Array references
        System.out.println("\n--- Array References ---");
        
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = array1; // array2 references the same array as array1
        
        System.out.println("array1[0] before modification: " + array1[0]);
        array2[0] = 100; // This modifies the same array that array1 points to
        System.out.println("array1[0] after modification through array2: " + array1[0]);
        
        // Creating a copy of an array
        System.out.println("\n--- Creating a Copy of an Array ---");
        
        int[] original = {1, 2, 3, 4, 5};
        int[] copy = new int[original.length];
        
        // Copy elements from original to copy
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        
        // Modify the copy
        copy[0] = 100;
        
        System.out.println("original[0] after modifying copy: " + original[0]);
        System.out.println("copy[0]: " + copy[0]);
        
        // Using System.arraycopy()
        System.out.println("\n--- Using System.arraycopy() ---");
        
        int[] source = {10, 20, 30, 40, 50};
        int[] destination = new int[source.length];
        
        // Parameters: source array, source position, destination array, destination position, length
        System.arraycopy(source, 0, destination, 0, source.length);
        
        System.out.println("Source array: ");
        for (int value : source) {
            System.out.print(value + " ");
        }
        
        System.out.println("\nDestination array after System.arraycopy(): ");
        for (int value : destination) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        // Partial copy with System.arraycopy()
        int[] partialDest = new int[3];
        System.arraycopy(source, 1, partialDest, 0, 3);
        
        System.out.println("\nPartial destination array: ");
        for (int value : partialDest) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        // Memory considerations with arrays
        System.out.println("\n--- Memory Considerations ---");
        
        System.out.println("Each int takes 4 bytes of memory");
        System.out.println("An array of 5 integers takes approximately: " + (5 * 4) + " bytes (plus overhead)");
        
        // Creating a large array (be careful with very large arrays)
        try {
            System.out.println("Creating an array of 10 million integers...");
            int[] largeArray = new int[10_000_000]; // This allocates about 40MB of memory
            System.out.println("Large array created successfully with length: " + largeArray.length);
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError: " + e.getMessage());
        }
        
        System.out.println("\nArray basics demonstration complete.");
    }
}