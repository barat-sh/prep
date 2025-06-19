/**
 * This class demonstrates the use of arithmetic operators in Java
 */
public class ArithmeticOperators {
    public static void main(String[] args) {
        System.out.println("=== Arithmetic Operators in Java ===\n");
        
        // Basic arithmetic operations with integers
        int a = 10;
        int b = 3;
        
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;
        int remainder = a % b;
        
        System.out.println("--- Basic Operations with Integers ---");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + sum);        // 13
        System.out.println("a - b = " + difference); // 7
        System.out.println("a * b = " + product);    // 30
        System.out.println("a / b = " + quotient);   // 3 (integer division truncates decimal part)
        System.out.println("a % b = " + remainder);  // 1
        
        // Integer division vs floating-point division
        System.out.println("\n--- Integer vs Floating-Point Division ---");
        System.out.println("10 / 3 = " + (10 / 3));         // 3 (integer division)
        System.out.println("10.0 / 3 = " + (10.0 / 3));     // 3.3333... (floating-point division)
        System.out.println("10 / 3.0 = " + (10 / 3.0));     // 3.3333... (floating-point division)
        
        // Operations with negative numbers
        System.out.println("\n--- Operations with Negative Numbers ---");
        int c = -5;
        System.out.println("a + c = " + (a + c));      // 5
        System.out.println("a * c = " + (a * c));      // -50
        
        // Modulus with negative numbers
        System.out.println("\n--- Modulus with Negative Numbers ---");
        System.out.println("10 % 3 = " + (10 % 3));    // 1
        System.out.println("-10 % 3 = " + (-10 % 3));  // -1
        System.out.println("10 % -3 = " + (10 % -3));  // 1
        System.out.println("-10 % -3 = " + (-10 % -3));// -1
        
        // Increment and decrement operators
        System.out.println("\n--- Increment and Decrement Operators ---");
        
        int x = 5;
        System.out.println("Initial x = " + x);  // 5
        
        // Post-increment: use the value, then increment
        int postIncrement = x++;
        System.out.println("postIncrement = " + postIncrement);  // 5
        System.out.println("After post-increment, x = " + x);   // 6
        
        // Pre-increment: increment, then use the value
        int y = 5;
        int preIncrement = ++y;
        System.out.println("preIncrement = " + preIncrement);   // 6
        System.out.println("After pre-increment, y = " + y);    // 6
        
        // Post-decrement: use the value, then decrement
        int z = 5;
        int postDecrement = z--;
        System.out.println("postDecrement = " + postDecrement); // 5
        System.out.println("After post-decrement, z = " + z);   // 4
        
        // Pre-decrement: decrement, then use the value
        int w = 5;
        int preDecrement = --w;
        System.out.println("preDecrement = " + preDecrement);   // 4
        System.out.println("After pre-decrement, w = " + w);    // 4
        
        // Increment/decrement in expressions
        System.out.println("\n--- Increment/Decrement in Expressions ---");
        
        int i = 5;
        int j = 10;
        int result = i++ + --j;  // 5 + 9 = 14
        System.out.println("i++ + --j = " + result);
        System.out.println("After expression, i = " + i + ", j = " + j);  // i = 6, j = 9
        
        // Overflow and underflow
        System.out.println("\n--- Overflow and Underflow ---");
        
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        
        System.out.println("Maximum int value: " + maxInt);       // 2147483647
        System.out.println("Minimum int value: " + minInt);       // -2147483648
        
        System.out.println("maxInt + 1 = " + (maxInt + 1));       // -2147483648 (overflow)
        System.out.println("minInt - 1 = " + (minInt - 1));       // 2147483647 (underflow)
        
        // Using Math class for common operations
        System.out.println("\n--- Using Math Class ---");
        
        System.out.println("Math.abs(-5) = " + Math.abs(-5));       // 5
        System.out.println("Math.pow(2, 3) = " + Math.pow(2, 3));   // 8.0
        System.out.println("Math.sqrt(25) = " + Math.sqrt(25));     // 5.0
        System.out.println("Math.max(10, 20) = " + Math.max(10, 20)); // 20
        System.out.println("Math.min(10, 20) = " + Math.min(10, 20)); // 10
        System.out.println("Math.round(3.7) = " + Math.round(3.7));  // 4
        System.out.println("Math.floor(3.7) = " + Math.floor(3.7));  // 3.0
        System.out.println("Math.ceil(3.2) = " + Math.ceil(3.2));    // 4.0
    }
}