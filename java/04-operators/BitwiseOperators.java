/**
 * This class demonstrates the use of bitwise operators in Java
 */
public class BitwiseOperators {
    public static void main(String[] args) {
        System.out.println("=== Bitwise Operators in Java ===\n");
        
        // Working with binary values
        int a = 5;  // binary: 0000 0101
        int b = 3;  // binary: 0000 0011
        
        System.out.println("a = " + a + " (binary: " + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + " (binary: " + Integer.toBinaryString(b) + ")");
        
        // Bitwise AND (&)
        int andResult = a & b;  // 0000 0001 (1 in decimal)
        System.out.println("\n--- Bitwise AND (&) ---");
        System.out.println("a & b = " + andResult + " (binary: " + Integer.toBinaryString(andResult) + ")");
        /*
         * 0101 (a)
         * 0011 (b)
         * ---- (&)
         * 0001 (result)
         */
        
        // Bitwise OR (|)
        int orResult = a | b;  // 0000 0111 (7 in decimal)
        System.out.println("\n--- Bitwise OR (|) ---");
        System.out.println("a | b = " + orResult + " (binary: " + Integer.toBinaryString(orResult) + ")");
        /*
         * 0101 (a)
         * 0011 (b)
         * ---- (|)
         * 0111 (result)
         */
        
        // Bitwise XOR (^)
        int xorResult = a ^ b;  // 0000 0110 (6 in decimal)
        System.out.println("\n--- Bitwise XOR (^) ---");
        System.out.println("a ^ b = " + xorResult + " (binary: " + Integer.toBinaryString(xorResult) + ")");
        /*
         * 0101 (a)
         * 0011 (b)
         * ---- (^)
         * 0110 (result)
         */
        
        // Bitwise NOT (~)
        int notA = ~a;  // 1111 1010 (-6 in decimal due to two's complement)
        System.out.println("\n--- Bitwise NOT (~) ---");
        System.out.println("~a = " + notA + " (binary: " + Integer.toBinaryString(notA) + ")");
        /*
         * 0101 (a)
         * ---- (~)
         * 1010 (result, but Java represents this as 11111111111111111111111111111010 due to 32-bit int)
         */
        
        // Left Shift (<<)
        int leftShift = a << 1;  // 0000 1010 (10 in decimal)
        System.out.println("\n--- Left Shift (<<) ---");
        System.out.println("a << 1 = " + leftShift + " (binary: " + Integer.toBinaryString(leftShift) + ")");
        /*
         * 0101 (a)
         * ---- (<<1)
         * 1010 (result)
         */
        
        // Right Shift (>>)
        int rightShift = a >> 1;  // 0000 0010 (2 in decimal)
        System.out.println("\n--- Right Shift (>>) ---");
        System.out.println("a >> 1 = " + rightShift + " (binary: " + Integer.toBinaryString(rightShift) + ")");
        /*
         * 0101 (a)
         * ---- (>>1)
         * 0010 (result)
         */
        
        // Multiple bit shifts
        System.out.println("\n--- Multiple Bit Shifts ---");
        System.out.println("a << 2 = " + (a << 2) + " (binary: " + Integer.toBinaryString(a << 2) + ")");  // 20
        System.out.println("a >> 2 = " + (a >> 2) + " (binary: " + Integer.toBinaryString(a >> 2) + ")");  // 1
        
        // Unsigned Right Shift (>>>)
        int positiveNum = 5;   // 0000 0101
        int negativeNum = -5;  // 1111 1011 (in two's complement)
        
        System.out.println("\n--- Unsigned Right Shift (>>>) ---");
        
        System.out.println("positiveNum = " + positiveNum + " (binary: " + Integer.toBinaryString(positiveNum) + ")");
        System.out.println("negativeNum = " + negativeNum + " (binary: " + Integer.toBinaryString(negativeNum) + ")");
        
        // Right shift with sign extension
        System.out.println("positiveNum >> 1 = " + (positiveNum >> 1) + " (binary: " + Integer.toBinaryString(positiveNum >> 1) + ")");
        System.out.println("negativeNum >> 1 = " + (negativeNum >> 1) + " (binary: " + Integer.toBinaryString(negativeNum >> 1) + ")");
        
        // Unsigned right shift (always fills with 0)
        System.out.println("positiveNum >>> 1 = " + (positiveNum >>> 1) + " (binary: " + Integer.toBinaryString(positiveNum >>> 1) + ")");
        System.out.println("negativeNum >>> 1 = " + (negativeNum >>> 1) + " (binary: " + Integer.toBinaryString(negativeNum >>> 1) + ")");
        
        // Practical applications of bitwise operators
        System.out.println("\n=== Practical Applications ===");
        
        // 1. Check if a number is even or odd using bitwise AND
        System.out.println("\n--- Checking for Even/Odd ---");
        for (int i = 0; i <= 5; i++) {
            boolean isEven = (i & 1) == 0;
            System.out.println(i + " is " + (isEven ? "even" : "odd"));
        }
        
        // 2. Multiply by 2 using left shift
        System.out.println("\n--- Multiplying by Powers of 2 ---");
        int num = 10;
        System.out.println(num + " * 2 = " + (num << 1));    // 20
        System.out.println(num + " * 4 = " + (num << 2));    // 40
        System.out.println(num + " * 8 = " + (num << 3));    // 80
        
        // 3. Divide by 2 using right shift
        System.out.println("\n--- Dividing by Powers of 2 ---");
        int divNum = 100;
        System.out.println(divNum + " / 2 = " + (divNum >> 1));    // 50
        System.out.println(divNum + " / 4 = " + (divNum >> 2));    // 25
        System.out.println(divNum + " / 8 = " + (divNum >> 3));    // 12 (integer division truncates)
        
        // 4. Swapping numbers using XOR
        System.out.println("\n--- Swapping Numbers Using XOR ---");
        int x = 10;
        int y = 20;
        System.out.println("Before swap: x = " + x + ", y = " + y);
        
        // Swapping without a temporary variable
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        
        System.out.println("After swap: x = " + x + ", y = " + y);
        
        // 5. Using bitmasks for setting, clearing, and toggling bits
        System.out.println("\n--- Bit Manipulation with Masks ---");
        
        int flags = 0;  // all bits are 0
        System.out.println("Initial flags: " + Integer.toBinaryString(flags));
        
        // Set bit at position 0 (right-most bit)
        flags |= (1 << 0);  // set first bit
        System.out.println("After setting bit 0: " + Integer.toBinaryString(flags));
        
        // Set bit at position 2
        flags |= (1 << 2);  // set third bit
        System.out.println("After setting bit 2: " + Integer.toBinaryString(flags));
        
        // Check if a bit is set
        boolean isBit1Set = (flags & (1 << 1)) != 0;  // check second bit
        boolean isBit2Set = (flags & (1 << 2)) != 0;  // check third bit
        System.out.println("Is bit 1 set? " + isBit1Set);
        System.out.println("Is bit 2 set? " + isBit2Set);
        
        // Clear bit at position 0
        flags &= ~(1 << 0);  // clear first bit
        System.out.println("After clearing bit 0: " + Integer.toBinaryString(flags));
        
        // Toggle bit at position 2
        flags ^= (1 << 2);  // toggle third bit
        System.out.println("After toggling bit 2: " + Integer.toBinaryString(flags));
        flags ^= (1 << 2);  // toggle third bit again
        System.out.println("After toggling bit 2 again: " + Integer.toBinaryString(flags));
    }
}