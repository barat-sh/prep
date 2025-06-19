# Variables and Data Types in Java

Variables are containers for storing data values. In Java, all variables must be declared before they can be used.

## Variable Declaration

The syntax for declaring a variable in Java is:

```java
dataType variableName = value; // Declaration with initialization
dataType variableName;         // Declaration without initialization
```

Examples:
```java
int age = 25;          // Integer variable
double salary = 5000.0; // Double variable
char grade = 'A';       // Character variable
boolean isActive = true; // Boolean variable
String name = "John";   // String variable
```

## Variable Types Based on Location

### Instance Variables (Non-Static Fields)
- Declared inside a class but outside methods
- Each object has its own copy
- Initialized with default values if not explicitly initialized

```java
public class Student {
    String name;   // Instance variable
    int age;       // Instance variable
    double gpa;    // Instance variable
}
```

### Class Variables (Static Fields)
- Declared with the `static` keyword
- Shared among all instances of the class
- Only one copy exists regardless of how many objects are created

```java
public class Counter {
    static int count = 0;  // Class variable
    
    public Counter() {
        count++;
    }
}
```

### Local Variables
- Declared inside methods, constructors, or blocks
- Accessible only within the declared method, constructor, or block
- Must be initialized before use (no default values)

```java
public void calculateArea() {
    int length = 10;  // Local variable
    int width = 5;    // Local variable
    int area = length * width;
    System.out.println("Area: " + area);
}
```

### Parameters
- Variables passed to methods
- Act as local variables within the method

```java
public int add(int a, int b) {  // a and b are parameters
    return a + b;
}
```

## Data Types in Java

Java has two categories of data types:

### 1. Primitive Data Types

These are the most basic data types available in Java. There are 8 primitive data types:

| Data Type | Size    | Range                                                   | Default Value |
|-----------|---------|--------------------------------------------------------|---------------|
| byte      | 8 bits  | -128 to 127                                             | 0             |
| short     | 16 bits | -32,768 to 32,767                                       | 0             |
| int       | 32 bits | -2^31 to 2^31-1                                         | 0             |
| long      | 64 bits | -2^63 to 2^63-1                                         | 0L            |
| float     | 32 bits | ~3.4e-038 to ~3.4e+038                                  | 0.0f          |
| double    | 64 bits | ~1.7e-308 to ~1.7e+308                                  | 0.0d          |
| char      | 16 bits | 0 to 65,535 (represents Unicode characters)             | '\u0000'      |
| boolean   | 1 bit   | true or false                                           | false         |

#### Examples:

```java
byte age = 25;
short distance = 1000;
int count = 1000000;
long population = 7800000000L;  // Note the 'L' suffix
float price = 19.99f;           // Note the 'f' suffix
double pi = 3.14159265359;
char grade = 'A';
boolean isOpen = true;
```

### 2. Reference Data Types

Reference data types refer to objects. Some common reference data types are:

- **Classes**: `String`, user-defined classes
- **Arrays**: Collection of similar data types
- **Interfaces**: Blueprint of a class
- **Enums**: Special type that defines a collection of constants

#### Examples:

```java
String name = "John Doe";       // String class
int[] numbers = {1, 2, 3, 4, 5}; // Array
Student student = new Student(); // User-defined class
List<String> names = new ArrayList<>(); // Interface and implementation
```

## Type Casting in Java

Type casting is the process of converting one data type to another.

### 1. Implicit Casting (Widening)
- Automatically done by Java
- Converting a smaller data type to a larger data type
- No data loss

```java
int myInt = 100;
long myLong = myInt;    // Automatic casting: int to long
float myFloat = myLong;  // Automatic casting: long to float
double myDouble = myFloat; // Automatic casting: float to double
```

### 2. Explicit Casting (Narrowing)
- Manual casting by the programmer
- Converting a larger data type to a smaller data type
- Potential data loss

```java
double myDouble = 9.78;
float myFloat = (float) myDouble;  // Manual casting: double to float
long myLong = (long) myFloat;      // Manual casting: float to long
int myInt = (int) myLong;          // Manual casting: long to int
```

## Wrapper Classes

For each primitive data type, Java provides a corresponding wrapper class that converts the primitive data type into an object.

| Primitive Type | Wrapper Class |
|----------------|---------------|
| byte           | Byte          |
| short          | Short         |
| int            | Integer       |
| long           | Long          |
| float          | Float         |
| double         | Double        |
| char           | Character     |
| boolean        | Boolean       |

### Examples:

```java
// Converting primitive to wrapper (autoboxing)
int primitiveInt = 42;
Integer wrapperInt = primitiveInt;

// Converting wrapper to primitive (unboxing)
Double wrapperDouble = 3.14;
double primitiveDouble = wrapperDouble;

// Utility methods provided by wrapper classes
int maxValue = Integer.MAX_VALUE;
int parsedInt = Integer.parseInt("123");
String binaryString = Integer.toBinaryString(10);
```

## Constants

Constants are variables whose values cannot be changed once assigned. In Java, constants are declared using the `final` keyword.

```java
final double PI = 3.14159;
final int MAX_USERS = 100;
```

Naming convention for constants is to use all uppercase letters with words separated by underscores.

## String Operations

Strings in Java are objects of the `String` class. They are immutable, meaning once created, their values cannot be changed.

```java
// String creation
String str1 = "Hello";  // Using string literal
String str2 = new String("World");  // Using new keyword

// String concatenation
String message = str1 + " " + str2;  // "Hello World"
String anotherMessage = str1.concat(" ").concat(str2);  // "Hello World"

// String methods
int length = message.length();  // 11
char firstChar = message.charAt(0);  // 'H'
String upper = message.toUpperCase();  // "HELLO WORLD"
String lower = message.toLowerCase();  // "hello world"
boolean startsWith = message.startsWith("Hello");  // true
boolean contains = message.contains("World");  // true
String replaced = message.replace("World", "Java");  // "Hello Java"
String substring = message.substring(6);  // "World"
String[] parts = message.split(" ");  // ["Hello", "World"]

// String comparison
boolean equals = str1.equals("Hello");  // true
boolean equalsIgnoreCase = str1.equalsIgnoreCase("hello");  // true
```

## Type Inference with var (Java 10+)

From Java 10, the `var` keyword can be used for local variable type inference. The compiler infers the type from the initialization expression.

```java
var name = "John";  // Inferred as String
var age = 25;       // Inferred as int
var prices = new ArrayList<Double>();  // Inferred as ArrayList<Double>
```

Limitations of `var`:
- Can only be used for local variables
- Must be initialized at declaration
- Cannot be used for fields, method parameters, or return types