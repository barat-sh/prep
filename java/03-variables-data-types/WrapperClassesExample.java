import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates the use of wrapper classes in Java
 */
public class WrapperClassesExample {
    public static void main(String[] args) {
        System.out.println("=== Wrapper Classes in Java ===\n");
        
        // Creating wrapper objects
        System.out.println("--- Creating Wrapper Objects ---");
        
        // Using constructors (deprecated since Java 9)
        Integer intObj1 = new Integer(42);  // Deprecated
        Double doubleObj1 = new Double(3.14);  // Deprecated
        
        // Using static factory methods (preferred)
        Integer intObj2 = Integer.valueOf(42);
        Double doubleObj2 = Double.valueOf(3.14);
        
        // Autoboxing (automatic conversion from primitive to wrapper)
        Integer intObj3 = 42;  // Autoboxing
        Double doubleObj3 = 3.14;  // Autoboxing
        Character charObj = 'A';  // Autoboxing
        Boolean boolObj = true;  // Autoboxing
        
        System.out.println("Integer object: " + intObj3);
        System.out.println("Double object: " + doubleObj3);
        System.out.println("Character object: " + charObj);
        System.out.println("Boolean object: " + boolObj);
        
        // Unboxing (automatic conversion from wrapper to primitive)
        System.out.println("\n--- Unboxing Examples ---");
        
        int primitiveInt = intObj3;  // Unboxing
        double primitiveDouble = doubleObj3;  // Unboxing
        char primitiveChar = charObj;  // Unboxing
        boolean primitiveBoolean = boolObj;  // Unboxing
        
        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Primitive double: " + primitiveDouble);
        System.out.println("Primitive char: " + primitiveChar);
        System.out.println("Primitive boolean: " + primitiveBoolean);
        
        // Autoboxing and unboxing in expressions
        Integer sum = intObj1 + intObj2;  // Unboxing, addition, then autoboxing
        System.out.println("Sum of two Integer objects: " + sum);
        
        // Utility methods in wrapper classes
        System.out.println("\n--- Wrapper Class Utility Methods ---");
        
        // Parsing strings to primitive types
        int parsedInt = Integer.parseInt("123");
        double parsedDouble = Double.parseDouble("123.456");
        boolean parsedBoolean = Boolean.parseBoolean("true");
        
        System.out.println("Parsed int: " + parsedInt);
        System.out.println("Parsed double: " + parsedDouble);
        System.out.println("Parsed boolean: " + parsedBoolean);
        
        // Converting primitive to different bases
        System.out.println("\nInteger representations:");
        System.out.println("Decimal (10): " + Integer.toString(42));
        System.out.println("Binary (2): " + Integer.toBinaryString(42));
        System.out.println("Octal (8): " + Integer.toOctalString(42));
        System.out.println("Hexadecimal (16): " + Integer.toHexString(42));
        
        // Min and Max values
        System.out.println("\nMin and Max values:");
        System.out.println("Integer MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Integer MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Double MIN_VALUE: " + Double.MIN_VALUE);
        System.out.println("Double MAX_VALUE: " + Double.MAX_VALUE);
        
        // Character methods
        System.out.println("\nCharacter methods:");
        System.out.println("Is digit: " + Character.isDigit('5'));
        System.out.println("Is letter: " + Character.isLetter('A'));
        System.out.println("Is letter or digit: " + Character.isLetterOrDigit('A'));
        System.out.println("Is uppercase: " + Character.isUpperCase('A'));
        System.out.println("To uppercase: " + Character.toUpperCase('a'));
        System.out.println("To lowercase: " + Character.toLowerCase('A'));
        
        // Using wrappers with collections
        System.out.println("\n--- Wrappers with Collections ---");
        
        // Collections can only store objects, not primitive types
        List<Integer> numbers = new ArrayList<>();
        
        // Autoboxing makes adding primitives easy
        numbers.add(10);  // Autoboxing int to Integer
        numbers.add(20);  // Autoboxing int to Integer
        numbers.add(30);  // Autoboxing int to Integer
        
        // Automatic unboxing when using in calculations
        int sum2 = 0;
        for (Integer number : numbers) {
            sum2 += number;  // Unboxing Integer to int
        }
        
        System.out.println("List of Integers: " + numbers);
        System.out.println("Sum of elements: " + sum2);
        
        // Null considerations
        System.out.println("\n--- Null Considerations ---");
        
        // Wrapper objects can be null
        Integer nullInteger = null;
        System.out.println("Null Integer: " + nullInteger);
        
        // This would cause a NullPointerException (uncommenting will crash the program)
        // int nullUnboxed = nullInteger;  // Attempting to unbox null
        
        // Safe unboxing
        if (nullInteger != null) {
            int safeUnboxed = nullInteger;
            System.out.println("Safely unboxed: " + safeUnboxed);
        } else {
            System.out.println("Cannot unbox null");
        }
        
        // Comparing wrapper objects
        System.out.println("\n--- Comparing Wrapper Objects ---");
        
        Integer int1 = 127;
        Integer int2 = 127;
        Integer int3 = 128;
        Integer int4 = 128;
        
        // == compares object references
        // For small values (-128 to 127), Java caches Integer objects
        System.out.println("int1 == int2 (127): " + (int1 == int2));  // true (cached)
        System.out.println("int3 == int4 (128): " + (int3 == int4));  // false (not cached)
        
        // equals() compares the values
        System.out.println("int1.equals(int2): " + int1.equals(int2));  // true
        System.out.println("int3.equals(int4): " + int3.equals(int4));  // true
        
        // Always use equals() for comparing wrapper objects
        Integer a = 1000;
        Integer b = 1000;
        System.out.println("a == b: " + (a == b));  // false (different objects)
        System.out.println("a.equals(b): " + a.equals(b));  // true (same value)
    }
}