# Object-Oriented Programming in Java

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects" that contain data and methods. Java is an object-oriented language that implements the major OOP concepts: encapsulation, inheritance, polymorphism, and abstraction.

## 1. Classes and Objects

### Classes

A class is a blueprint or template for creating objects. It defines the properties (fields) and behaviors (methods) that objects of that class will have.

**Class Declaration:**
```java
[access_modifier] class ClassName {
    // Fields (instance variables)
    [access_modifier] dataType fieldName;
    
    // Constructors
    [access_modifier] ClassName([parameters]) {
        // Constructor body
    }
    
    // Methods
    [access_modifier] returnType methodName([parameters]) {
        // Method body
    }
}
```

**Example:**
```java
public class Person {
    // Fields
    private String name;
    private int age;
    
    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Methods
    public void introduce() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
    
    // Getters and setters
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
}
```

### Objects

An object is an instance of a class. When a class is instantiated, an object is created with its own set of field values.

**Creating Objects:**
```java
ClassName objectName = new ClassName([arguments]);
```

**Example:**
```java
Person person1 = new Person("John", 30);
Person person2 = new Person("Jane", 25);

person1.introduce(); // Output: Hello, my name is John and I am 30 years old.
person2.introduce(); // Output: Hello, my name is Jane and I am 25 years old.
```

## 2. Constructors

Constructors are special methods used to initialize objects. They have the same name as the class and no return type.

### Default Constructor

If no constructor is defined, Java provides a default no-argument constructor. However, once you define any constructor, the default is no longer provided automatically.

```java
public class Box {
    int width;
    int height;
    
    // This class has a default constructor if no other constructors are defined
}
```

### Parameterized Constructor

```java
public class Box {
    int width;
    int height;
    
    // Parameterized constructor
    public Box(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
```

### Constructor Overloading

Multiple constructors can be defined with different parameter lists.

```java
public class Box {
    int width;
    int height;
    
    // No-argument constructor
    public Box() {
        this.width = 0;
        this.height = 0;
    }
    
    // Single-argument constructor
    public Box(int size) {
        this.width = size;
        this.height = size;
    }
    
    // Two-argument constructor
    public Box(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
```

### Constructor Chaining

Constructors can call other constructors using `this()`.

```java
public class Box {
    int width;
    int height;
    String color;
    
    public Box() {
        this(0, 0); // Calls the two-argument constructor
    }
    
    public Box(int size) {
        this(size, size); // Calls the two-argument constructor
    }
    
    public Box(int width, int height) {
        this(width, height, "White"); // Calls the three-argument constructor
    }
    
    public Box(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }
}
```

## 3. Access Modifiers

Access modifiers control the accessibility of classes, methods, and fields.

| Modifier | Class | Package | Subclass | World |
|----------|-------|---------|----------|-------|
| public | ✓ | ✓ | ✓ | ✓ |
| protected | ✓ | ✓ | ✓ | ✗ |
| default (no modifier) | ✓ | ✓ | ✗ | ✗ |
| private | ✓ | ✗ | ✗ | ✗ |

- **public**: Accessible from anywhere.
- **protected**: Accessible within the same package and subclasses.
- **default (no modifier)**: Accessible only within the same package.
- **private**: Accessible only within the same class.

**Example:**
```java
public class AccessModifiersExample {
    public int publicField;         // Accessible from anywhere
    protected int protectedField;   // Accessible in the same package and subclasses
    int defaultField;               // Accessible in the same package
    private int privateField;       // Accessible only in this class
    
    public void publicMethod() { }
    protected void protectedMethod() { }
    void defaultMethod() { }
    private void privateMethod() { }
}
```

## 4. Encapsulation

Encapsulation is the mechanism of wrapping data (variables) and code acting on the data (methods) together as a single unit. It hides the internal state and requires all interaction to be performed through an object's methods.

**Benefits of Encapsulation:**
- Data hiding
- Increased flexibility
- Reusability
- Maintainability

**Example:**
```java
public class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
    }
}
```

## 5. Inheritance

Inheritance is a mechanism where a new class inherits properties and behaviors from an existing class. The existing class is called the parent or superclass, and the new class is called the child or subclass.

**Syntax:**
```java
[access_modifier] class SubClass extends SuperClass {
    // Subclass members
}
```

**Example:**
```java
// Superclass
public class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void eat() {
        System.out.println(name + " is eating.");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

// Subclass
public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, String breed) {
        super(name); // Call the superclass constructor
        this.breed = breed;
    }
    
    public void bark() {
        System.out.println(name + " is barking.");
    }
    
    public String getBreed() {
        return breed;
    }
}
```

**Usage:**
```java
Dog dog = new Dog("Rex", "German Shepherd");
dog.eat();   // Inherited from Animal
dog.sleep(); // Inherited from Animal
dog.bark();  // Defined in Dog
```

### Types of Inheritance

- **Single Inheritance**: A subclass inherits from one superclass.
- **Multilevel Inheritance**: A class inherits from a subclass (chain of inheritance).
- **Hierarchical Inheritance**: Multiple classes inherit from one superclass.

Java does not support multiple inheritance through classes (a class cannot inherit from multiple classes directly). However, it supports multiple inheritance through interfaces.

### The `super` Keyword

The `super` keyword is used to:
- Call the superclass constructor: `super(parameters)`
- Access superclass methods: `super.methodName(parameters)`
- Access superclass fields: `super.fieldName`

### Method Overriding

Method overriding occurs when a subclass provides a specific implementation of a method that is already defined in its superclass.

**Rules for Method Overriding:**
- The method must have the same name as in the superclass.
- The method must have the same parameter list.
- The return type must be the same or a subtype of the return type in the superclass.
- The access level cannot be more restrictive than the overridden method.
- The method cannot throw new or broader checked exceptions.

**Example:**
```java
public class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

public class Dog extends Animal {
    @Override // Annotation to indicate that this method overrides a superclass method
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
```

### The `final` Keyword

- **final class**: Cannot be subclassed.
- **final method**: Cannot be overridden.
- **final variable**: Cannot be reassigned after initialization.

```java
public final class FinalClass { } // Cannot be extended

public class ParentClass {
    public final void finalMethod() { } // Cannot be overridden
}
```

## 6. Polymorphism

Polymorphism allows objects to be treated as instances of their parent class rather than their actual class. It enables a single interface to represent different underlying forms.

### Method Overloading (Compile-time Polymorphism)

Method overloading occurs when multiple methods in the same class have the same name but different parameter lists.

```java
public class Calculator {
    // Method with two int parameters
    public int add(int a, int b) {
        return a + b;
    }
    
    // Method with three int parameters
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Method with two double parameters
    public double add(double a, double b) {
        return a + b;
    }
}
```

### Method Overriding (Runtime Polymorphism)

Method overriding occurs when a subclass provides a specific implementation of a method that is already defined in its superclass.

```java
// Usage of method overriding (runtime polymorphism)
Animal animal1 = new Animal("Generic Animal");
Animal animal2 = new Dog("Rex", "German Shepherd"); // Upcasting

animal1.makeSound(); // Output: Animal makes a sound
animal2.makeSound(); // Output: Dog barks (Dog's implementation is called)
```

## 7. Abstraction

Abstraction is the concept of hiding complex implementation details and showing only the necessary features of an object.

### Abstract Classes

An abstract class is a class that cannot be instantiated and may contain abstract methods (methods without a body).

**Syntax:**
```java
abstract class AbstractClassName {
    // Regular fields and methods
    
    // Abstract method (no body)
    abstract returnType abstractMethodName(parameters);
}
```

**Example:**
```java
abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Regular method
    public String getColor() {
        return color;
    }
    
    // Abstract method (no implementation)
    public abstract double calculateArea();
    
    // Abstract method (no implementation)
    public abstract double calculatePerimeter();
}

class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
```

### Interfaces

An interface is a completely abstract class that contains only abstract methods and constants. All methods in an interface are implicitly public and abstract.

**Syntax:**
```java
interface InterfaceName {
    // Constants (implicitly public, static, final)
    type CONSTANT_NAME = value;
    
    // Abstract methods (implicitly public and abstract)
    returnType methodName(parameters);
}
```

**Example:**
```java
interface Drawable {
    void draw(); // Implicitly public and abstract
}

interface Resizable {
    void resize(int percentage);
}

class Square implements Drawable, Resizable {
    private int side;
    
    public Square(int side) {
        this.side = side;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a square with side: " + side);
    }
    
    @Override
    public void resize(int percentage) {
        side = side * percentage / 100;
        System.out.println("Resized square. New side: " + side);
    }
}
```

### Default and Static Methods in Interfaces (Java 8+)

Since Java 8, interfaces can have default and static methods with implementations.

```java
interface Vehicle {
    void start();
    
    // Default method (has implementation)
    default void honk() {
        System.out.println("Honk honk!");
    }
    
    // Static method (has implementation)
    static int getWheels() {
        return 4;
    }
}
```

### Functional Interfaces (Java 8+)

A functional interface is an interface with exactly one abstract method. They can be used with lambda expressions.

```java
@FunctionalInterface
interface Greeting {
    void greet(String name);
}

public class Main {
    public static void main(String[] args) {
        // Using a lambda expression with a functional interface
        Greeting greeting = name -> System.out.println("Hello, " + name + "!");
        greeting.greet("John"); // Output: Hello, John!
    }
}
```

## 8. Object Class Methods

Every class in Java implicitly extends the `Object` class, which provides several methods that can be overridden:

- **toString()**: Returns a string representation of the object.
- **equals(Object obj)**: Compares objects for equality.
- **hashCode()**: Returns a hash code value for the object.
- **getClass()**: Returns the runtime class of the object.
- **clone()**: Creates and returns a copy of the object.
- **finalize()**: Called by the garbage collector before object destruction.
- **wait()**, **notify()**, **notifyAll()**: Used for thread synchronization.

**Example of overriding Object methods:**
```java
public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Person person = (Person) obj;
        return age == person.age && 
               (name == null ? person.name == null : name.equals(person.name));
    }
    
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
```

## 9. Static Members

Static members belong to the class rather than to any instance of the class.

### Static Variables

Static variables are shared among all instances of a class.

```java
public class Counter {
    private static int count = 0; // Static variable
    private int instanceCount;    // Instance variable
    
    public Counter() {
        count++;
        instanceCount = count;
    }
    
    public static int getCount() {
        return count;
    }
    
    public int getInstanceCount() {
        return instanceCount;
    }
}
```

### Static Methods

Static methods belong to the class and can be called without creating an instance of the class.

```java
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
}

// Usage
int result = MathUtils.add(5, 3); // No need to create an instance
```

### Static Blocks

Static blocks are executed when the class is loaded, before any static methods are called and before any instances are created.

```java
public class StaticBlockExample {
    static {
        System.out.println("Static block is executed when the class is loaded");
    }
    
    public StaticBlockExample() {
        System.out.println("Constructor is executed when an instance is created");
    }
}
```

## 10. Nested Classes

Java allows defining a class within another class, known as a nested class.

### Inner Classes

Non-static nested classes, also known as inner classes, have access to the fields and methods of the enclosing class.

```java
public class OuterClass {
    private int outerField = 10;
    
    // Inner class
    public class InnerClass {
        public void display() {
            System.out.println("OuterField value: " + outerField);
        }
    }
    
    public void createInner() {
        InnerClass inner = new InnerClass();
        inner.display();
    }
}

// Usage
OuterClass outer = new OuterClass();
OuterClass.InnerClass inner = outer.new InnerClass();
inner.display();
```

### Static Nested Classes

Static nested classes do not have access to the instance variables and methods of the outer class.

```java
public class OuterClass {
    private static int staticOuterField = 10;
    private int instanceOuterField = 20;
    
    // Static nested class
    public static class StaticNestedClass {
        public void display() {
            System.out.println("StaticOuterField: " + staticOuterField);
            // Cannot access instanceOuterField
        }
    }
}

// Usage
OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
nested.display();
```

### Local Classes

Classes defined within a method.

```java
public class OuterClass {
    public void method() {
        final int localVariable = 10;
        
        // Local class
        class LocalClass {
            public void display() {
                System.out.println("Local variable: " + localVariable);
            }
        }
        
        LocalClass local = new LocalClass();
        local.display();
    }
}
```

### Anonymous Classes

Anonymous classes are expressions that create unnamed class instances.

```java
interface Greeting {
    void greet();
}

public class Main {
    public static void main(String[] args) {
        // Anonymous class
        Greeting greeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello, world!");
            }
        };
        
        greeting.greet();
    }
}
```

## 11. Packages

Packages are used to organize classes and interfaces into namespaces, preventing naming conflicts.

### Defining a Package

To define a package, use the `package` statement at the beginning of the source file.

```java
package com.example.myapp;

public class MyClass {
    // Class definition
}
```

### Importing Classes

To use a class from another package, you need to import it.

```java
// Import a specific class
import com.example.myapp.MyClass;

// Import all classes from a package
import com.example.myapp.*;
```

### Static Imports

Static imports allow importing static members (fields and methods) directly.

```java
// Import static members
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        double radius = 5.0;
        double area = PI * radius * radius;
        double diagonal = sqrt(50.0);
        
        System.out.println("Area: " + area);
        System.out.println("Diagonal: " + diagonal);
    }
}
```

## 12. Generics

Generics enable classes, interfaces, and methods to operate on objects of various types while providing compile-time type safety.

### Generic Classes

```java
// Generic class with type parameter T
public class Box<T> {
    private T content;
    
    public Box(T content) {
        this.content = content;
    }
    
    public T getContent() {
        return content;
    }
    
    public void setContent(T content) {
        this.content = content;
    }
}

// Usage
Box<Integer> intBox = new Box<>(10);
Box<String> stringBox = new Box<>("Hello");

Integer intValue = intBox.getContent();
String stringValue = stringBox.getContent();
```

### Generic Methods

```java
public class Utils {
    // Generic method
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

// Usage
Integer[] intArray = {1, 2, 3, 4, 5};
String[] stringArray = {"Hello", "World"};

Utils.printArray(intArray);
Utils.printArray(stringArray);
```

### Bounded Type Parameters

You can restrict the types that can be used as type arguments in a parameterized type.

```java
// T must be a subtype of Number
public class MathBox<T extends Number> {
    private T value;
    
    public MathBox(T value) {
        this.value = value;
    }
    
    public double sqrt() {
        return Math.sqrt(value.doubleValue());
    }
}

// Usage
MathBox<Integer> intMathBox = new MathBox<>(16);
System.out.println(intMathBox.sqrt()); // Output: 4.0

// Error: String is not a subtype of Number
// MathBox<String> stringMathBox = new MathBox<>("Hello");
```

### Wildcards

Wildcards represent an unknown type in generics.

```java
// Upper bounded wildcard: ? extends Type
public static double sumOfList(List<? extends Number> list) {
    double sum = 0.0;
    for (Number n : list) {
        sum += n.doubleValue();
    }
    return sum;
}

// Lower bounded wildcard: ? super Type
public static void addNumbers(List<? super Integer> list) {
    for (int i = 1; i <= 5; i++) {
        list.add(i);
    }
}

// Unbounded wildcard: ?
public static void printList(List<?> list) {
    for (Object elem : list) {
        System.out.print(elem + " ");
    }
    System.out.println();
}
```