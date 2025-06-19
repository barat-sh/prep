# Arrays in Java

Arrays are used to store multiple values of the same type in a single variable. They provide a way to work with a collection of related data items as a single unit.

## 1. Array Basics

An array in Java is a collection of variables of the same type, referred to by a common name. Each data item is called an element of the array, and each element is accessed by its numerical index.

### Array Declaration

```java
// Method 1: Declaration without initialization
dataType[] arrayName;
// or
dataType arrayName[];

// Method 2: Declaration with initialization
dataType[] arrayName = new dataType[arraySize];

// Method 3: Declaration and initialization with values
dataType[] arrayName = {value1, value2, ..., valueN};
```

### Examples:

```java
// Declaring an array of integers
int[] numbers;

// Allocating memory for 5 integers
numbers = new int[5];

// Initializing elements
numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;

// Declaration, memory allocation, and initialization in one statement
int[] primes = {2, 3, 5, 7, 11, 13};

// Declaration and memory allocation in one statement
String[] names = new String[3];
names[0] = "Alice";
names[1] = "Bob";
names[2] = "Charlie";
```

## 2. Accessing Array Elements

Array elements are accessed using their index number. Array indices start at 0 for the first element.

```java
int[] numbers = {10, 20, 30, 40, 50};

// Accessing elements
int firstElement = numbers[0];   // 10
int thirdElement = numbers[2];   // 30

// Modifying elements
numbers[4] = 99;  // Changes 50 to 99

// Accessing an element outside the array bounds will throw ArrayIndexOutOfBoundsException
// int invalid = numbers[5];  // Error: Index 5 out of bounds for length 5
```

## 3. Array Properties and Methods

### Length Property

The `length` property gives the number of elements in the array.

```java
int[] numbers = {10, 20, 30, 40, 50};
int arrayLength = numbers.length;  // 5
```

### Arrays Class Utility Methods

The `java.util.Arrays` class provides various methods for working with arrays:

```java
import java.util.Arrays;

int[] numbers = {5, 2, 9, 1, 7};

// Sorting an array
Arrays.sort(numbers);  // numbers becomes {1, 2, 5, 7, 9}

// Binary search (array must be sorted)
int index = Arrays.binarySearch(numbers, 5);  // Returns 2

// Filling an array
int[] newArray = new int[5];
Arrays.fill(newArray, 10);  // newArray becomes {10, 10, 10, 10, 10}

// Comparing arrays
int[] array1 = {1, 2, 3};
int[] array2 = {1, 2, 3};
boolean areEqual = Arrays.equals(array1, array2);  // true

// Converting array to string
String arrayString = Arrays.toString(numbers);  // "[1, 2, 5, 7, 9]"

// Copying arrays
int[] copy = Arrays.copyOf(numbers, numbers.length);  // Full copy
int[] partial = Arrays.copyOfRange(numbers, 1, 4);    // Partial copy: {2, 5, 7}
```

## 4. Iterating Through Arrays

### Using for Loop

```java
int[] numbers = {10, 20, 30, 40, 50};

// Using regular for loop with index
for (int i = 0; i < numbers.length; i++) {
    System.out.println("Element at index " + i + ": " + numbers[i]);
}
```

### Using Enhanced for Loop (for-each)

```java
int[] numbers = {10, 20, 30, 40, 50};

// Using enhanced for loop (for-each)
for (int number : numbers) {
    System.out.println("Element: " + number);
}
```

## 5. Multi-dimensional Arrays

Java supports multi-dimensional arrays, which are essentially arrays of arrays.

### Two-dimensional Arrays

```java
// Declaration and initialization of a 2D array
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Accessing elements
int value = matrix[1][2];  // 6 (row 1, column 2)

// Getting the number of rows and columns
int rows = matrix.length;        // 3
int columns = matrix[0].length;  // 3

// Iterating through a 2D array
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}

// Using enhanced for loop
for (int[] row : matrix) {
    for (int value : row) {
        System.out.print(value + " ");
    }
    System.out.println();
}
```

### Three-dimensional Arrays

```java
// 3D array (array of 2D arrays)
int[][][] threeDArray = new int[3][3][3];

// Assignment
threeDArray[0][0][0] = 1;

// Iterating through a 3D array
for (int i = 0; i < threeDArray.length; i++) {
    for (int j = 0; j < threeDArray[i].length; j++) {
        for (int k = 0; k < threeDArray[i][j].length; k++) {
            System.out.println("threeDArray[" + i + "][" + j + "][" + k + "] = " + threeDArray[i][j][k]);
        }
    }
}
```

## 6. Jagged Arrays

Jagged arrays are multi-dimensional arrays where the member arrays can have different lengths.

```java
// Creating a jagged array
int[][] jaggedArray = new int[3][];
jaggedArray[0] = new int[2];
jaggedArray[1] = new int[3];
jaggedArray[2] = new int[4];

// Initializing a jagged array
jaggedArray[0][0] = 1;
jaggedArray[0][1] = 2;
jaggedArray[1][0] = 3;
jaggedArray[1][1] = 4;
jaggedArray[1][2] = 5;
jaggedArray[2][0] = 6;
jaggedArray[2][1] = 7;
jaggedArray[2][2] = 8;
jaggedArray[2][3] = 9;

// Alternative initialization
int[][] jaggedArray2 = {
    {1, 2},
    {3, 4, 5},
    {6, 7, 8, 9}
};

// Iterating through a jagged array
for (int i = 0; i < jaggedArray.length; i++) {
    for (int j = 0; j < jaggedArray[i].length; j++) {
        System.out.print(jaggedArray[i][j] + " ");
    }
    System.out.println();
}
```

## 7. Arrays of Objects

Arrays can hold primitive data types or objects.

```java
// Array of Strings (Strings are objects)
String[] names = {"Alice", "Bob", "Charlie"};

// Array of custom objects
class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

// Creating and using an array of Person objects
Person[] people = new Person[3];
people[0] = new Person("Alice", 25);
people[1] = new Person("Bob", 30);
people[2] = new Person("Charlie", 35);

// Iterating through an array of objects
for (Person person : people) {
    System.out.println(person);  // Uses toString() method
}
```

## 8. ArrayList

While arrays have a fixed size, `ArrayList` provides a resizable array implementation:

```java
import java.util.ArrayList;

// Creating an ArrayList of Integers
ArrayList<Integer> numbers = new ArrayList<>();

// Adding elements
numbers.add(10);
numbers.add(20);
numbers.add(30);

// Accessing elements
int firstElement = numbers.get(0);  // 10

// Updating elements
numbers.set(1, 25);  // Changes 20 to 25

// Removing elements
numbers.remove(0);  // Removes 10

// Size of ArrayList
int size = numbers.size();  // 2

// Checking if an element exists
boolean contains = numbers.contains(25);  // true

// Iterating through ArrayList
for (Integer number : numbers) {
    System.out.println(number);
}
```

## 9. Common Array Operations

### Searching an Array

```java
int[] numbers = {10, 20, 30, 40, 50};
int target = 30;
int index = -1;

// Linear search
for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] == target) {
        index = i;
        break;
    }
}

if (index != -1) {
    System.out.println("Found " + target + " at index " + index);
} else {
    System.out.println(target + " not found in the array");
}
```

### Finding Minimum and Maximum

```java
int[] numbers = {5, 2, 9, 1, 7};
int min = numbers[0];
int max = numbers[0];

for (int i = 1; i < numbers.length; i++) {
    if (numbers[i] < min) {
        min = numbers[i];
    }
    if (numbers[i] > max) {
        max = numbers[i];
    }
}

System.out.println("Minimum: " + min);  // 1
System.out.println("Maximum: " + max);  // 9
```

### Summing and Averaging

```java
int[] numbers = {10, 20, 30, 40, 50};
int sum = 0;

for (int number : numbers) {
    sum += number;
}

double average = (double) sum / numbers.length;

System.out.println("Sum: " + sum);           // 150
System.out.println("Average: " + average);   // 30.0
```

### Reversing an Array

```java
int[] original = {1, 2, 3, 4, 5};
int[] reversed = new int[original.length];

for (int i = 0; i < original.length; i++) {
    reversed[i] = original[original.length - 1 - i];
}

// Alternatively, reverse in-place
for (int i = 0; i < original.length / 2; i++) {
    int temp = original[i];
    original[i] = original[original.length - 1 - i];
    original[original.length - 1 - i] = temp;
}
```

## 10. Array Performance Considerations

1. **Access Time**: Accessing elements in an array is very fast (O(1)) because array elements are stored in contiguous memory locations.

2. **Size Limitation**: Arrays have a fixed size, which must be specified at the time of declaration. If you need a dynamic size, consider using `ArrayList` or other Collection classes.

3. **Memory Allocation**: When declaring large arrays, ensure that sufficient memory is available, or use dynamic data structures for more flexibility.

4. **Insertion and Deletion**: Inserting or deleting elements in the middle of an array requires shifting elements, which can be inefficient for large arrays (O(n)). Consider using `LinkedList` for frequent insertions/deletions.

5. **Memory Wastage**: If you allocate a large array but use only a small portion, it can lead to memory wastage.