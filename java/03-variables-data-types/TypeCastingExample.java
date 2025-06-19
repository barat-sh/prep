/**
 * This class demonstrates type casting in Java
 */
public class TypeCastingExample {
    public static void main(String[] args) {
        System.out.println("=== Type Casting in Java ===\n");
        
        // Implicit Casting (Widening)
        // Converting smaller data type to larger data type
        System.out.println("--- Implicit Casting (Widening) ---");
        
        byte byteValue = 100;
        short shortValue = byteValue;       // byte to short
        int intValue = shortValue;          // short to int
        long longValue = intValue;          // int to long
        float floatValue = longValue;       // long to float
        double doubleValue = floatValue;    // float to double
        
        System.out.println("byte value: " + byteValue);
        System.out.println("short value (from byte): " + shortValue);
        System.out.println("int value (from short): " + intValue);
        System.out.println("long value (from int): " + longValue);
        System.out.println("float value (from long): " + floatValue);
        System.out.println("double value (from float): " + doubleValue);
        
        // Character to int (ASCII value)
        char charValue = 'A';
        int asciiValue = charValue;
        System.out.println("char '" + charValue + "' to int: " + asciiValue);
        
        // Explicit Casting (Narrowing)
        // Converting larger data type to smaller data type
        System.out.println("\n--- Explicit Casting (Narrowing) ---");
        
        double largeDouble = 123.456;
        float largeFloat = (float) largeDouble;      // double to float
        long largeLong = (long) largeFloat;          // float to long
        int largeInt = (int) largeLong;              // long to int
        short largeShort = (short) largeInt;         // int to short
        byte largeByte = (byte) largeShort;          // short to byte
        
        System.out.println("double value: " + largeDouble);
        System.out.println("float value (from double): " + largeFloat);
        System.out.println("long value (from float): " + largeLong);
        System.out.println("int value (from long): " + largeInt);
        System.out.println("short value (from int): " + largeShort);
        System.out.println("byte value (from short): " + largeByte);
        
        // Potential data loss with explicit casting
        System.out.println("\n--- Potential Data Loss Examples ---");
        
        // Integer overflow
        int bigInt = 130;
        byte smallByte = (byte) bigInt;  // Value outside byte range (-128 to 127)
        System.out.println("int " + bigInt + " cast to byte: " + smallByte + " (data loss due to overflow)");
        
        // Truncation of decimal part
        double piValue = 3.14159;
        int truncatedPi = (int) piValue;
        System.out.println("double " + piValue + " cast to int: " + truncatedPi + " (decimal part truncated)");
        
        // Type casting with expressions
        System.out.println("\n--- Type Casting in Expressions ---");
        
        byte num1 = 10;
        byte num2 = 20;
        
        // In expressions, byte and short are automatically promoted to int
        // byte result = num1 + num2;  // This would cause a compilation error
        byte result = (byte) (num1 + num2);  // Explicit cast needed
        System.out.println("byte result of " + num1 + " + " + num2 + " = " + result);
        
        int intNum = 5;
        double doubleNum = 2.5;
        
        // Mixed type expressions get promoted to the highest type
        double mixedResult = intNum * doubleNum;  // Result is double
        System.out.println("int " + intNum + " * double " + doubleNum + " = " + mixedResult);
        
        // Character to number and vice versa
        System.out.println("\n--- Character and Number Conversions ---");
        
        char letter = 'Z';
        int letterCode = letter;
        System.out.println("Character '" + letter + "' to int: " + letterCode);
        
        int digitCode = 51;  // ASCII code for '3'
        char digit = (char) digitCode;
        System.out.println("Int " + digitCode + " to character: '" + digit + "'");
        
        // Converting a digit character to its numeric value
        char digitChar = '7';
        int numericValue = digitChar - '0';  // Subtract ASCII value of '0'
        System.out.println("Numeric value of '" + digitChar + "': " + numericValue);
        
        // String to primitive types
        System.out.println("\n--- String to Primitive Conversions ---");
        
        String intString = "123";
        String doubleString = "123.456";
        String boolString = "true";
        
        int parsedInt = Integer.parseInt(intString);
        double parsedDouble = Double.parseDouble(doubleString);
        boolean parsedBool = Boolean.parseBoolean(boolString);
        
        System.out.println("String \"" + intString + "\" to int: " + parsedInt);
        System.out.println("String \"" + doubleString + "\" to double: " + parsedDouble);
        System.out.println("String \"" + boolString + "\" to boolean: " + parsedBool);
        
        // Primitive types to String
        int numberToConvert = 456;
        double piToConvert = 3.14159;
        boolean flagToConvert = false;
        
        String numberString = Integer.toString(numberToConvert);  // Using wrapper class
        String piString = Double.toString(piToConvert);
        String flagString = Boolean.toString(flagToConvert);
        
        // Alternative way using String concatenation
        String anotherNumberString = "" + numberToConvert;
        
        System.out.println("int " + numberToConvert + " to String: \"" + numberString + "\"");
        System.out.println("double " + piToConvert + " to String: \"" + piString + "\"");
        System.out.println("boolean " + flagToConvert + " to String: \"" + flagString + "\"");
    }
}