/**
 * This class demonstrates the use of primitive data types in Java
 */
public class PrimitiveDataTypes {
    public static void main(String[] args) {
        // Integer types
        byte byteVar = 127;                  // 8 bits, -128 to 127
        short shortVar = 32767;              // 16 bits, -32,768 to 32,767
        int intVar = 2147483647;             // 32 bits, -2^31 to 2^31-1
        long longVar = 9223372036854775807L; // 64 bits, -2^63 to 2^63-1, note the 'L' suffix
        
        // Floating-point types
        float floatVar = 3.14159f;           // 32 bits, note the 'f' suffix
        double doubleVar = 3.14159265359;    // 64 bits, more precision than float
        
        // Character type
        char charVar = 'A';                  // 16 bits, stores a single Unicode character
        
        // Boolean type
        boolean booleanVar = true;           // 1 bit, can be true or false
        
        // Print values
        System.out.println("=== Primitive Data Types in Java ===");
        System.out.println("byte value: " + byteVar);
        System.out.println("short value: " + shortVar);
        System.out.println("int value: " + intVar);
        System.out.println("long value: " + longVar);
        System.out.println("float value: " + floatVar);
        System.out.println("double value: " + doubleVar);
        System.out.println("char value: " + charVar);
        System.out.println("boolean value: " + booleanVar);
        
        // Size of primitive types in bytes
        System.out.println("\n=== Size of Primitive Data Types ===");
        System.out.println("byte: " + Byte.SIZE / 8 + " bytes");
        System.out.println("short: " + Short.SIZE / 8 + " bytes");
        System.out.println("int: " + Integer.SIZE / 8 + " bytes");
        System.out.println("long: " + Long.SIZE / 8 + " bytes");
        System.out.println("float: " + Float.SIZE / 8 + " bytes");
        System.out.println("double: " + Double.SIZE / 8 + " bytes");
        System.out.println("char: " + Character.SIZE / 8 + " bytes");
        
        // Min and Max values
        System.out.println("\n=== Min and Max Values ===");
        System.out.println("byte min: " + Byte.MIN_VALUE + ", max: " + Byte.MAX_VALUE);
        System.out.println("short min: " + Short.MIN_VALUE + ", max: " + Short.MAX_VALUE);
        System.out.println("int min: " + Integer.MIN_VALUE + ", max: " + Integer.MAX_VALUE);
        System.out.println("long min: " + Long.MIN_VALUE + ", max: " + Long.MAX_VALUE);
        System.out.println("float min: " + Float.MIN_VALUE + ", max: " + Float.MAX_VALUE);
        System.out.println("double min: " + Double.MIN_VALUE + ", max: " + Double.MAX_VALUE);
        
        // Special values for floating-point types
        System.out.println("\n=== Special Floating-Point Values ===");
        System.out.println("Positive infinity: " + Double.POSITIVE_INFINITY);
        System.out.println("Negative infinity: " + Double.NEGATIVE_INFINITY);
        System.out.println("Not a Number (NaN): " + Double.NaN);
        
        // Default values (when declared as class fields)
        DefaultValues defaults = new DefaultValues();
        System.out.println("\n=== Default Values ===");
        System.out.println("Default byte: " + defaults.defaultByte);
        System.out.println("Default short: " + defaults.defaultShort);
        System.out.println("Default int: " + defaults.defaultInt);
        System.out.println("Default long: " + defaults.defaultLong);
        System.out.println("Default float: " + defaults.defaultFloat);
        System.out.println("Default double: " + defaults.defaultDouble);
        System.out.println("Default char: '" + defaults.defaultChar + "' (ASCII value: " + (int)defaults.defaultChar + ")");
        System.out.println("Default boolean: " + defaults.defaultBoolean);
    }
}

/**
 * This class demonstrates default values of primitive data types
 */
class DefaultValues {
    // These will be initialized to their default values
    byte defaultByte;
    short defaultShort;
    int defaultInt;
    long defaultLong;
    float defaultFloat;
    double defaultDouble;
    char defaultChar;
    boolean defaultBoolean;
}