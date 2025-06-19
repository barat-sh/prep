import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class demonstrates common operations with arrays in Java
 */
public class ArrayOperations {
    public static void main(String[] args) {
        System.out.println("=== Common Array Operations in Java ===\n");
        
        // Creating a sample array
        int[] numbers = {5, 2, 9, 1, 7, 3, 8, 4, 6};
        
        System.out.println("Original array: " + Arrays.toString(numbers));
        
        // 1. Searching in an array
        System.out.println("\n--- Searching in an Array ---");
        
        // Linear search
        int target = 7;
        int linearIndex = linearSearch(numbers, target);
        System.out.println("Linear search for " + target + ": index = " + linearIndex);
        
        // Using Arrays.binarySearch (array must be sorted)
        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);
        
        System.out.println("Sorted array: " + Arrays.toString(sortedNumbers));
        int binaryIndex = Arrays.binarySearch(sortedNumbers, target);
        System.out.println("Binary search for " + target + ": index = " + binaryIndex);
        
        // 2. Sorting arrays
        System.out.println("\n--- Sorting Arrays ---");
        
        // Using Arrays.sort()
        int[] unsortedArray = {5, 2, 9, 1, 7, 3, 8, 4, 6};
        System.out.println("Before sorting: " + Arrays.toString(unsortedArray));
        
        Arrays.sort(unsortedArray);
        System.out.println("After sorting (ascending): " + Arrays.toString(unsortedArray));
        
        // Sorting in descending order (using Integer array and Collections)
        Integer[] boxedArray = {5, 2, 9, 1, 7, 3, 8, 4, 6};
        System.out.println("\nBefore sorting (Integer array): " + Arrays.toString(boxedArray));
        
        Arrays.sort(boxedArray, Collections.reverseOrder());
        System.out.println("After sorting (descending): " + Arrays.toString(boxedArray));
        
        // Partial sorting
        int[] partialSort = {5, 2, 9, 1, 7, 3, 8, 4, 6};
        System.out.println("\nBefore partial sorting: " + Arrays.toString(partialSort));
        
        Arrays.sort(partialSort, 2, 6); // Sort from index 2 (inclusive) to 6 (exclusive)
        System.out.println("After partial sorting (indexes 2-5): " + Arrays.toString(partialSort));
        
        // 3. Copying arrays
        System.out.println("\n--- Copying Arrays ---");
        
        // Using Arrays.copyOf()
        int[] original = {1, 2, 3, 4, 5};
        int[] copy1 = Arrays.copyOf(original, original.length);
        int[] shorterCopy = Arrays.copyOf(original, 3);
        int[] longerCopy = Arrays.copyOf(original, 8);
        
        System.out.println("Original array: " + Arrays.toString(original));
        System.out.println("Full copy: " + Arrays.toString(copy1));
        System.out.println("Shorter copy (first 3 elements): " + Arrays.toString(shorterCopy));
        System.out.println("Longer copy (with default values): " + Arrays.toString(longerCopy));
        
        // Using Arrays.copyOfRange()
        int[] partialCopy = Arrays.copyOfRange(original, 1, 4); // From index 1 (inclusive) to 4 (exclusive)
        System.out.println("Partial copy (indexes 1-3): " + Arrays.toString(partialCopy));
        
        // Using System.arraycopy()
        int[] destination = new int[original.length];
        System.arraycopy(original, 0, destination, 0, original.length);
        System.out.println("Copy using System.arraycopy(): " + Arrays.toString(destination));
        
        // Using clone()
        int[] clonedArray = original.clone();
        System.out.println("Copy using clone(): " + Arrays.toString(clonedArray));
        
        // 4. Filling arrays
        System.out.println("\n--- Filling Arrays ---");
        
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 10);
        System.out.println("Array filled with 10: " + Arrays.toString(filledArray));
        
        // Partial filling
        int[] partialFill = new int[10];
        Arrays.fill(partialFill, 3, 7, 42); // Fill from index 3 (inclusive) to 7 (exclusive)
        System.out.println("Partially filled array: " + Arrays.toString(partialFill));
        
        // 5. Comparing arrays
        System.out.println("\n--- Comparing Arrays ---");
        
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 2, 3, 5, 4};
        
        boolean isEqual1 = Arrays.equals(array1, array2);
        boolean isEqual2 = Arrays.equals(array1, array3);
        
        System.out.println("array1 equals array2: " + isEqual1);
        System.out.println("array1 equals array3: " + isEqual2);
        
        // Comparing multi-dimensional arrays
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        int[][] matrix3 = {{1, 2}, {3, 5}};
        
        boolean deepEqual1 = Arrays.deepEquals(matrix1, matrix2);
        boolean deepEqual2 = Arrays.deepEquals(matrix1, matrix3);
        
        System.out.println("matrix1 deep equals matrix2: " + deepEqual1);
        System.out.println("matrix1 deep equals matrix3: " + deepEqual2);
        
        // 6. Finding min/max values
        System.out.println("\n--- Finding Min/Max Values ---");
        
        int[] values = {5, 2, 9, 1, 7, 3, 8, 4, 6};
        
        int min = findMin(values);
        int max = findMax(values);
        
        System.out.println("Array: " + Arrays.toString(values));
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        
        // Using Collections
        Integer[] boxedValues = {5, 2, 9, 1, 7, 3, 8, 4, 6};
        
        int minValue = Collections.min(Arrays.asList(boxedValues));
        int maxValue = Collections.max(Arrays.asList(boxedValues));
        
        System.out.println("Min using Collections: " + minValue);
        System.out.println("Max using Collections: " + maxValue);
        
        // 7. Calculating sum and average
        System.out.println("\n--- Calculating Sum and Average ---");
        
        int[] data = {10, 20, 30, 40, 50};
        
        int sum = calculateSum(data);
        double average = calculateAverage(data);
        
        System.out.println("Array: " + Arrays.toString(data));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        
        // 8. Reversing an array
        System.out.println("\n--- Reversing an Array ---");
        
        int[] originalArray = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(originalArray));
        
        int[] reversedArray = reverseArray(originalArray);
        System.out.println("Reversed array (new array): " + Arrays.toString(reversedArray));
        
        reverseArrayInPlace(originalArray);
        System.out.println("Reversed array (in-place): " + Arrays.toString(originalArray));
        
        // 9. Converting between arrays and lists
        System.out.println("\n--- Converting Between Arrays and Lists ---");
        
        // Array to List
        String[] colorArray = {"Red", "Green", "Blue", "Yellow"};
        List<String> colorList = Arrays.asList(colorArray);
        
        System.out.println("Array: " + Arrays.toString(colorArray));
        System.out.println("List from array: " + colorList);
        
        // Note: The list from Arrays.asList() is backed by the original array
        colorArray[0] = "Purple";
        System.out.println("After changing array element, list: " + colorList);
        
        // To create an independent ArrayList
        ArrayList<String> independentList = new ArrayList<>(Arrays.asList(colorArray));
        colorArray[1] = "Orange";
        System.out.println("Array after another change: " + Arrays.toString(colorArray));
        System.out.println("Independent list: " + independentList);
        
        // List to Array
        List<Integer> numberList = new ArrayList<>();
        numberList.add(100);
        numberList.add(200);
        numberList.add(300);
        
        Integer[] numberArray = numberList.toArray(new Integer[0]);
        System.out.println("List: " + numberList);
        System.out.println("Array from list: " + Arrays.toString(numberArray));
        
        // 10. Shuffling an array
        System.out.println("\n--- Shuffling an Array ---");
        
        Integer[] orderedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Original array: " + Arrays.toString(orderedArray));
        
        // Convert to list, shuffle, then convert back to array
        List<Integer> list = Arrays.asList(orderedArray);
        Collections.shuffle(list);
        list.toArray(orderedArray);
        
        System.out.println("Shuffled array: " + Arrays.toString(orderedArray));
        
        // 11. Checking if an array contains a value
        System.out.println("\n--- Checking if an Array Contains a Value ---");
        
        int[] testArray = {10, 20, 30, 40, 50};
        int testValue1 = 30;
        int testValue2 = 60;
        
        boolean contains1 = containsValue(testArray, testValue1);
        boolean contains2 = containsValue(testArray, testValue2);
        
        System.out.println("Array: " + Arrays.toString(testArray));
        System.out.println("Contains " + testValue1 + ": " + contains1);
        System.out.println("Contains " + testValue2 + ": " + contains2);
        
        // Using List for primitive arrays
        Integer[] boxedTestArray = {10, 20, 30, 40, 50};
        boolean listContains1 = Arrays.asList(boxedTestArray).contains(testValue1);
        boolean listContains2 = Arrays.asList(boxedTestArray).contains(testValue2);
        
        System.out.println("Contains " + testValue1 + " (using List): " + listContains1);
        System.out.println("Contains " + testValue2 + " (using List): " + listContains2);
    }
    
    /**
     * Performs a linear search in the array
     */
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }
    
    /**
     * Finds the minimum value in the array
     */
    public static int findMin(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    
    /**
     * Finds the maximum value in the array
     */
    public static int findMax(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    /**
     * Calculates the sum of array elements
     */
    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
    
    /**
     * Calculates the average of array elements
     */
    public static double calculateAverage(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        
        int sum = calculateSum(array);
        return (double) sum / array.length;
    }
    
    /**
     * Creates a new array with elements in reverse order
     */
    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        
        return reversed;
    }
    
    /**
     * Reverses an array in-place
     */
    public static void reverseArrayInPlace(int[] array) {
        int start = 0;
        int end = array.length - 1;
        
        while (start < end) {
            // Swap elements
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            
            // Move towards the center
            start++;
            end--;
        }
    }
    
    /**
     * Checks if an array contains a specific value
     */
    public static boolean containsValue(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }
}