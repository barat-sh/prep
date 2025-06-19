import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class demonstrates the use of reference data types in Java
 */
public class ReferenceDataTypes {
    public static void main(String[] args) {
        System.out.println("=== Reference Data Types in Java ===\n");
        
        // String - The most commonly used reference type
        System.out.println("--- String Examples ---");
        String message = "Hello, World!";
        System.out.println("String: " + message);
        System.out.println("Length: " + message.length());
        System.out.println("Uppercase: " + message.toUpperCase());
        System.out.println("Substring: " + message.substring(0, 5));
        System.out.println("Contains 'World': " + message.contains("World"));
        
        // Arrays - Fixed-size collection of elements of the same type
        System.out.println("\n--- Array Examples ---");
        int[] numbers = {1, 2, 3, 4, 5};
        String[] fruits = {"Apple", "Banana", "Orange"};
        
        System.out.println("Integer array: " + Arrays.toString(numbers));
        System.out.println("String array: " + Arrays.toString(fruits));
        
        // Accessing array elements
        System.out.println("First number: " + numbers[0]);
        System.out.println("Last fruit: " + fruits[fruits.length - 1]);
        
        // 2D array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("2D array element at [1][2]: " + matrix[1][2]); // Outputs 6
        
        // Collections - Dynamic-size collections (ArrayList example)
        System.out.println("\n--- Collections Examples ---");
        List<String> namesList = new ArrayList<>();
        namesList.add("Alice");
        namesList.add("Bob");
        namesList.add("Charlie");
        
        System.out.println("ArrayList: " + namesList);
        System.out.println("Size: " + namesList.size());
        System.out.println("Second name: " + namesList.get(1));
        namesList.remove("Bob");
        System.out.println("After removing Bob: " + namesList);
        
        // Custom Class Objects
        System.out.println("\n--- Custom Class Examples ---");
        Person person1 = new Person("John", 30);
        Person person2 = new Person("Jane", 25);
        
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        
        person1.setAge(31);
        System.out.println("After birthday: " + person1.toString());
        
        // Enum type
        System.out.println("\n--- Enum Examples ---");
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today);
        
        // Check if today is a weekend
        if (today == Day.SATURDAY || today == Day.SUNDAY) {
            System.out.println("It's the weekend!");
        } else {
            System.out.println("It's a weekday.");
        }
        
        // Enum methods
        System.out.println("Day value: " + today.getValue());
        System.out.println("Is working day: " + today.isWorkingDay());
        
        // Null reference
        System.out.println("\n--- Null Reference Example ---");
        String nullString = null;
        System.out.println("Null reference: " + nullString);
        
        // This would cause a NullPointerException if uncommented
        // System.out.println("Length: " + nullString.length());
        
        // Safe way to check for null
        if (nullString != null) {
            System.out.println("Length: " + nullString.length());
        } else {
            System.out.println("The string is null");
        }
    }
}

/**
 * Custom class representing a Person
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

/**
 * Enum representing days of the week
 */
enum Day {
    MONDAY(1, true),
    TUESDAY(2, true),
    WEDNESDAY(3, true),
    THURSDAY(4, true),
    FRIDAY(5, true),
    SATURDAY(6, false),
    SUNDAY(7, false);
    
    private final int value;
    private final boolean workingDay;
    
    Day(int value, boolean workingDay) {
        this.value = value;
        this.workingDay = workingDay;
    }
    
    public int getValue() {
        return value;
    }
    
    public boolean isWorkingDay() {
        return workingDay;
    }
}