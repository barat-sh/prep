/**
 * This class demonstrates the use of relational and logical operators in Java
 */
public class RelationalAndLogicalOperators {
    public static void main(String[] args) {
        System.out.println("=== Relational and Logical Operators in Java ===\n");
        
        // Relational Operators
        System.out.println("--- Relational Operators ---");
        
        int a = 10;
        int b = 20;
        int c = 10;
        
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        
        // Equal to (==)
        System.out.println("a == b: " + (a == b));  // false
        System.out.println("a == c: " + (a == c));  // true
        
        // Not equal to (!=)
        System.out.println("a != b: " + (a != b));  // true
        System.out.println("a != c: " + (a != c));  // false
        
        // Greater than (>)
        System.out.println("a > b: " + (a > b));    // false
        System.out.println("b > a: " + (b > a));    // true
        
        // Less than (<)
        System.out.println("a < b: " + (a < b));    // true
        System.out.println("b < a: " + (b < a));    // false
        
        // Greater than or equal to (>=)
        System.out.println("a >= c: " + (a >= c));  // true
        System.out.println("a >= b: " + (a >= b));  // false
        
        // Less than or equal to (<=)
        System.out.println("a <= c: " + (a <= c));  // true
        System.out.println("b <= a: " + (b <= a));  // false
        
        // Comparing different data types
        System.out.println("\n--- Comparing Different Data Types ---");
        
        double d = 10.0;
        System.out.println("a (int) = " + a + ", d (double) = " + d);
        System.out.println("a == d: " + (a == d));  // true (int is promoted to double before comparison)
        
        // Comparing objects with == vs equals()
        System.out.println("\n--- Comparing Objects: == vs equals() ---");
        
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        String str3 = str1;
        
        System.out.println("str1 = " + str1 + ", str2 = " + str2 + ", str3 = str1");
        System.out.println("str1 == str2: " + (str1 == str2));  // false (different objects)
        System.out.println("str1 == str3: " + (str1 == str3));  // true (same object)
        System.out.println("str1.equals(str2): " + str1.equals(str2));  // true (same content)
        
        // String literal interning
        String str4 = "Java";
        String str5 = "Java";
        System.out.println("\nstr4 = \"Java\", str5 = \"Java\"");
        System.out.println("str4 == str5: " + (str4 == str5));  // true (literals are interned)
        
        // Logical Operators
        System.out.println("\n--- Logical Operators ---");
        
        boolean p = true;
        boolean q = false;
        
        System.out.println("p = " + p + ", q = " + q);
        
        // Logical AND (&&)
        System.out.println("p && q: " + (p && q));  // false
        
        // Logical OR (||)
        System.out.println("p || q: " + (p || q));  // true
        
        // Logical NOT (!)
        System.out.println("!p: " + (!p));  // false
        System.out.println("!q: " + (!q));  // true
        
        // Complex logical expressions
        System.out.println("\n--- Complex Logical Expressions ---");
        
        System.out.println("(a > b) && (a == c): " + ((a > b) && (a == c)));  // false
        System.out.println("(a < b) || (a != c): " + ((a < b) || (a != c)));  // true
        System.out.println("!(a > b): " + (!(a > b)));  // true
        
        // Short-circuit evaluation
        System.out.println("\n--- Short-Circuit Evaluation ---");
        
        // With &&: If the first operand is false, the second operand is not evaluated
        int x = 5;
        boolean result1 = (x > 10) && (++x > 5);
        System.out.println("(x > 10) && (++x > 5): " + result1);  // false
        System.out.println("x after && expression: " + x);  // 5 (not incremented because of short-circuit)
        
        // With ||: If the first operand is true, the second operand is not evaluated
        int y = 5;
        boolean result2 = (y > 3) || (++y > 5);
        System.out.println("(y > 3) || (++y > 5): " + result2);  // true
        System.out.println("y after || expression: " + y);  // 5 (not incremented because of short-circuit)
        
        // Demonstrating evaluation of both operands
        int z = 5;
        boolean result3 = (z < 10) && (++z > 5);
        System.out.println("(z < 10) && (++z > 5): " + result3);  // true
        System.out.println("z after both operands evaluated: " + z);  // 6 (incremented)
        
        // Non-short-circuit operators: & and |
        System.out.println("\n--- Non-Short-Circuit Operators: & and | ---");
        
        int m = 5;
        boolean result4 = (m > 10) & (++m > 5);
        System.out.println("(m > 10) & (++m > 5): " + result4);  // false
        System.out.println("m after & expression: " + m);  // 6 (incremented despite first operand being false)
        
        int n = 5;
        boolean result5 = (n > 3) | (++n > 5);
        System.out.println("(n > 3) | (++n > 5): " + result5);  // true
        System.out.println("n after | expression: " + n);  // 6 (incremented despite first operand being true)
        
        // Using logical operators for conditions
        System.out.println("\n--- Practical Examples ---");
        
        int age = 25;
        boolean hasLicense = true;
        
        // Can drive if age >= 18 AND has license
        boolean canDrive = (age >= 18) && hasLicense;
        System.out.println("Age: " + age + ", Has License: " + hasLicense);
        System.out.println("Can drive: " + canDrive);  // true
        
        double temperature = 32.5;
        boolean isRaining = false;
        
        // Good for picnic if temperature > 20 AND not raining
        boolean goodForPicnic = (temperature > 20) && !isRaining;
        System.out.println("Temperature: " + temperature + ", Is Raining: " + isRaining);
        System.out.println("Good for picnic: " + goodForPicnic);  // true
        
        int score = 85;
        
        // Pass if score >= 60
        boolean pass = score >= 60;
        
        // Grade A if score >= 90
        // Grade B if score >= 80 and < 90
        // Grade C if score >= 70 and < 80
        // Grade D if score >= 60 and < 70
        // Grade F if score < 60
        
        char grade;
        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.out.println("Score: " + score);
        System.out.println("Pass: " + pass);
        System.out.println("Grade: " + grade);
    }
}