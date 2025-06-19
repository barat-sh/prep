/**
 * This class demonstrates the use of assignment and ternary operators in Java
 */
public class AssignmentAndTernaryOperators {
    public static void main(String[] args) {
        System.out.println("=== Assignment Operators in Java ===\n");
        
        // Simple assignment operator (=)
        int a = 10;
        System.out.println("a = " + a);
        
        // Compound assignment operators
        System.out.println("\n--- Compound Assignment Operators ---");
        
        // Addition assignment (+=)
        int b = 5;
        b += 3;  // equivalent to b = b + 3
        System.out.println("After b += 3: " + b);  // 8
        
        // Subtraction assignment (-=)
        int c = 10;
        c -= 4;  // equivalent to c = c - 4
        System.out.println("After c -= 4: " + c);  // 6
        
        // Multiplication assignment (*=)
        int d = 3;
        d *= 5;  // equivalent to d = d * 5
        System.out.println("After d *= 5: " + d);  // 15
        
        // Division assignment (/=)
        int e = 20;
        e /= 4;  // equivalent to e = e / 4
        System.out.println("After e /= 4: " + e);  // 5
        
        // Modulus assignment (%=)
        int f = 17;
        f %= 5;  // equivalent to f = f % 5
        System.out.println("After f %= 5: " + f);  // 2
        
        // Bitwise assignment operators
        System.out.println("\n--- Bitwise Assignment Operators ---");
        
        // Bitwise AND assignment (&=)
        int g = 12;  // binary: 1100
        g &= 5;     // binary: 0101, result: 0100 (4 in decimal)
        System.out.println("After g &= 5: " + g);  // 4
        
        // Bitwise OR assignment (|=)
        int h = 12;  // binary: 1100
        h |= 5;     // binary: 0101, result: 1101 (13 in decimal)
        System.out.println("After h |= 5: " + h);  // 13
        
        // Bitwise XOR assignment (^=)
        int i = 12;  // binary: 1100
        i ^= 5;     // binary: 0101, result: 1001 (9 in decimal)
        System.out.println("After i ^= 5: " + i);  // 9
        
        // Left shift assignment (<<=)
        int j = 8;  // binary: 1000
        j <<= 2;    // binary: 100000 (32 in decimal)
        System.out.println("After j <<= 2: " + j);  // 32
        
        // Right shift assignment (>>=)
        int k = 32;  // binary: 100000
        k >>= 3;     // binary: 100 (4 in decimal)
        System.out.println("After k >>= 3: " + k);  // 4
        
        // Unsigned right shift assignment (>>>=)
        int l = -10;  // binary representation with sign bit
        l >>>= 1;     // shifts bits right, filling with 0
        System.out.println("After l >>>= 1: " + l);
        
        // Chaining assignments
        System.out.println("\n--- Chaining Assignments ---");
        
        int x, y, z;
        x = y = z = 100;  // All three variables get the value 100
        System.out.println("x = " + x + ", y = " + y + ", z = " + z);
        
        // Assignment expressions return a value
        int m = 5;
        int n = (m = 10);  // n gets the value of the assignment expression (m = 10), which is 10
        System.out.println("m = " + m + ", n = " + n);
        
        // Ternary Operator (? :)
        System.out.println("\n=== Ternary Operator in Java ===\n");
        
        // Basic usage
        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Age: " + age + ", Status: " + status);
        
        // Comparing values
        int num1 = 15;
        int num2 = 10;
        int max = (num1 > num2) ? num1 : num2;
        System.out.println("num1: " + num1 + ", num2: " + num2 + ", Max: " + max);
        
        // Using ternary with expressions
        int score = 85;
        String result = (score >= 60) ? "Pass" : "Fail";
        System.out.println("Score: " + score + ", Result: " + result);
        
        // Ternary with String operations
        String name = "John";
        String greeting = (name.length() > 0) ? "Hello, " + name : "Hello, Guest";
        System.out.println(greeting);
        
        // Nested ternary operators (use with caution, can reduce readability)
        System.out.println("\n--- Nested Ternary Operators ---");
        
        int num = 75;
        
        // Determine grade (A, B, C, D, or F)
        String grade = (num >= 90) ? "A" : 
                       (num >= 80) ? "B" : 
                       (num >= 70) ? "C" : 
                       (num >= 60) ? "D" : "F";
        
        System.out.println("Score: " + num + ", Grade: " + grade);
        
        // The same logic with if-else for comparison
        String gradeWithIf;
        if (num >= 90) {
            gradeWithIf = "A";
        } else if (num >= 80) {
            gradeWithIf = "B";
        } else if (num >= 70) {
            gradeWithIf = "C";
        } else if (num >= 60) {
            gradeWithIf = "D";
        } else {
            gradeWithIf = "F";
        }
        
        System.out.println("Grade with if-else: " + gradeWithIf);
        
        // Using ternary operators to avoid null checks
        String text = null;
        String message = (text != null) ? text : "No text provided";
        System.out.println("Message: " + message);
        
        // Ternary operator for conditional assignment
        boolean isHot = true;
        String weather = isHot ? "It's hot outside" : "It's cold outside";
        System.out.println(weather);
        
        // Ternary operator in method arguments
        printMessage(true, "Good", "Bad");
        printMessage(false, "Good", "Bad");
        
        // Using ternary with numeric expressions
        int value = 7;
        int adjustedValue = (value % 2 == 0) ? value : value + 1;
        System.out.println("Original value: " + value + ", Adjusted to even: " + adjustedValue);
    }
    
    /**
     * Example of using ternary operator in method arguments
     */
    public static void printMessage(boolean condition, String trueMessage, String falseMessage) {
        System.out.println("The result is: " + (condition ? trueMessage : falseMessage));
    }
}