import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class demonstrates the use of ArrayList in Java
 */
public class ArrayListExample {
    public static void main(String[] args) {
        System.out.println("=== ArrayList in Java ===\n");
        
        // Creating an ArrayList
        System.out.println("--- Creating an ArrayList ---");
        
        // Method 1: Empty ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        System.out.println("Empty ArrayList created: " + fruits);
        
        // Method 2: ArrayList with initial capacity
        ArrayList<Integer> numbers = new ArrayList<>(10);
        System.out.println("ArrayList with initial capacity: " + numbers);
        
        // Method 3: ArrayList from another collection
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue"));
        System.out.println("ArrayList from collection: " + colors);
        
        // Adding elements to ArrayList
        System.out.println("\n--- Adding Elements to ArrayList ---");
        
        // Using add() method to add elements at the end
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("After adding elements: " + fruits);
        
        // Adding an element at a specific index
        fruits.add(1, "Blueberry");
        System.out.println("After adding at index 1: " + fruits);
        
        // Adding multiple elements at once
        fruits.addAll(Arrays.asList("Date", "Elderberry", "Fig"));
        System.out.println("After adding multiple elements: " + fruits);
        
        // Adding multiple elements at a specific index
        fruits.addAll(2, Arrays.asList("Grape", "Honeydew"));
        System.out.println("After adding multiple elements at index 2: " + fruits);
        
        // Accessing elements
        System.out.println("\n--- Accessing Elements ---");
        
        // Using get() method
        String firstFruit = fruits.get(0);
        String thirdFruit = fruits.get(2);
        System.out.println("First fruit: " + firstFruit);
        System.out.println("Third fruit: " + thirdFruit);
        
        // Iterating using for loop with index
        System.out.println("\nIterating using for loop with index:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println("fruits[" + i + "] = " + fruits.get(i));
        }
        
        // Iterating using enhanced for loop
        System.out.println("\nIterating using enhanced for loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        // Iterating using forEach method (Java 8+)
        System.out.println("\nIterating using forEach method:");
        fruits.forEach(fruit -> System.out.println(fruit));
        
        // Updating elements
        System.out.println("\n--- Updating Elements ---");
        
        // Using set() method
        String oldValue = fruits.set(1, "Blackberry");
        System.out.println("Old value at index 1: " + oldValue);
        System.out.println("After updating index 1: " + fruits);
        
        // Removing elements
        System.out.println("\n--- Removing Elements ---");
        
        // Removing by index
        String removedFruit = fruits.remove(0);
        System.out.println("Removed fruit at index 0: " + removedFruit);
        System.out.println("After removing index 0: " + fruits);
        
        // Removing by object
        boolean removed = fruits.remove("Fig");
        System.out.println("Removed 'Fig': " + removed);
        System.out.println("After removing 'Fig': " + fruits);
        
        // Removing multiple elements
        List<String> toRemove = Arrays.asList("Grape", "Date");
        fruits.removeAll(toRemove);
        System.out.println("After removing multiple elements: " + fruits);
        
        // Clearing the ArrayList
        ArrayList<String> tempList = new ArrayList<>(fruits);
        tempList.clear();
        System.out.println("After clearing tempList: " + tempList);
        
        // Checking if an element exists
        System.out.println("\n--- Checking if an Element Exists ---");
        
        boolean containsCherry = fruits.contains("Cherry");
        boolean containsApple = fruits.contains("Apple");
        System.out.println("Contains 'Cherry': " + containsCherry);
        System.out.println("Contains 'Apple': " + containsApple);
        
        // Finding the index of an element
        int cherryIndex = fruits.indexOf("Cherry");
        int appleIndex = fruits.indexOf("Apple");
        System.out.println("Index of 'Cherry': " + cherryIndex);
        System.out.println("Index of 'Apple': " + appleIndex); // -1 if not found
        
        // Finding the last occurrence of an element
        fruits.add("Cherry"); // Add another Cherry
        int lastCherryIndex = fruits.lastIndexOf("Cherry");
        System.out.println("Last index of 'Cherry': " + lastCherryIndex);
        
        // Checking if the ArrayList is empty
        boolean isEmpty = fruits.isEmpty();
        boolean isTempEmpty = tempList.isEmpty();
        System.out.println("Is fruits empty? " + isEmpty);
        System.out.println("Is tempList empty? " + isTempEmpty);
        
        // Getting the size of the ArrayList
        int size = fruits.size();
        System.out.println("Size of fruits: " + size);
        
        // Sorting an ArrayList
        System.out.println("\n--- Sorting an ArrayList ---");
        
        System.out.println("Before sorting: " + fruits);
        Collections.sort(fruits);
        System.out.println("After sorting: " + fruits);
        
        // Sorting in reverse order
        Collections.sort(fruits, Collections.reverseOrder());
        System.out.println("After sorting in reverse: " + fruits);
        
        // Creating a subList
        System.out.println("\n--- Creating a SubList ---");
        
        List<String> subList = fruits.subList(1, 4); // From index 1 (inclusive) to 4 (exclusive)
        System.out.println("SubList from index 1 to 3: " + subList);
        
        // Note: Changes to the subList affect the original list and vice versa
        subList.set(0, "MODIFIED");
        System.out.println("After modifying subList: " + subList);
        System.out.println("Original list after subList modification: " + fruits);
        
        // Converting ArrayList to array
        System.out.println("\n--- Converting ArrayList to Array ---");
        
        // Method 1: Using toArray() with a new array
        String[] fruitArray = fruits.toArray(new String[0]);
        System.out.println("Array from ArrayList: " + Arrays.toString(fruitArray));
        
        // Method 2: Using toArray() with a predefined size
        String[] fruitArray2 = fruits.toArray(new String[fruits.size()]);
        System.out.println("Array from ArrayList (predefined size): " + Arrays.toString(fruitArray2));
        
        // Converting array to ArrayList
        System.out.println("\n--- Converting Array to ArrayList ---");
        
        Integer[] numberArray = {1, 2, 3, 4, 5};
        
        // Method 1: Using Arrays.asList() and new ArrayList constructor
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(numberArray));
        System.out.println("ArrayList from array: " + numberList);
        
        // Method 2: Using Collections.addAll()
        ArrayList<Integer> numberList2 = new ArrayList<>();
        Collections.addAll(numberList2, numberArray);
        System.out.println("ArrayList from array (using addAll): " + numberList2);
        
        // Using generics with different types
        System.out.println("\n--- Using Different Types with ArrayList ---");
        
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        System.out.println("ArrayList of Integers: " + intList);
        
        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);
        System.out.println("ArrayList of Doubles: " + doubleList);
        
        // ArrayList of custom objects
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 35));
        
        System.out.println("\nArrayList of custom objects:");
        for (Person person : people) {
            System.out.println(person);
        }
        
        // ArrayList vs. Arrays performance
        System.out.println("\n--- ArrayList vs. Arrays Performance ---");
        
        // Creating a large array and ArrayList
        final int SIZE = 1000000;
        int[] largeArray = new int[SIZE];
        ArrayList<Integer> largeList = new ArrayList<>(SIZE);
        
        // Filling the array and ArrayList
        for (int i = 0; i < SIZE; i++) {
            largeArray[i] = i;
            largeList.add(i);
        }
        
        // Measuring access time
        System.out.println("Measuring random access time...");
        
        // Array access
        long startTime = System.currentTimeMillis();
        int sum1 = 0;
        for (int i = 0; i < 1000000; i++) {
            int randomIndex = (int) (Math.random() * SIZE);
            sum1 += largeArray[randomIndex];
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Array random access: " + (endTime - startTime) + "ms");
        
        // ArrayList access
        startTime = System.currentTimeMillis();
        int sum2 = 0;
        for (int i = 0; i < 1000000; i++) {
            int randomIndex = (int) (Math.random() * SIZE);
            sum2 += largeList.get(randomIndex);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList random access: " + (endTime - startTime) + "ms");
    }
}

/**
 * A simple Person class for demonstrating ArrayList with custom objects
 */
class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}