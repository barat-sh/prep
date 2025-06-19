# Java Syntax and Fundamentals

## Basic Syntax

Java programs are structured around classes and methods. The basic syntax rules include:

1. **Case Sensitivity**: Java is case-sensitive, meaning `Hello` and `hello` are different identifiers.

2. **Class Names**: Class names should start with an uppercase letter and follow CamelCase convention (e.g., `MyFirstJavaClass`).

3. **Method Names**: Method names should start with a lowercase letter and follow camelCase convention (e.g., `calculateTotal`).

4. **File Names**: The source file name must match the class name if the class is declared as `public`. For example, if a class is named `HelloWorld`, the file must be named `HelloWorld.java`.

5. **Main Method**: The entry point of a Java program is the `main` method with the signature:
   ```java
   public static void main(String[] args)
   ```

## Program Structure

A basic Java program consists of:

```java
// Optional package declaration
package com.example;

// Optional import statements
import java.util.Scanner;

// Class declaration
public class MyClass {
    // Class variables and methods
    private int number;
    
    // Main method (program entry point)
    public static void main(String[] args) {
        // Code statements
        System.out.println("Hello, World!");
    }
    
    // Other methods
    public void doSomething() {
        // Method body
    }
}
```

## Keywords and Identifiers

### Keywords
Java has reserved words that have special meaning and cannot be used as identifiers:

- **Control Flow**: `if`, `else`, `switch`, `case`, `default`, `for`, `while`, `do`, `break`, `continue`, `return`
- **Access Modifiers**: `public`, `private`, `protected`
- **Class-related**: `class`, `interface`, `extends`, `implements`, `enum`
- **Object-related**: `new`, `this`, `super`, `instanceof`
- **Exception Handling**: `try`, `catch`, `finally`, `throw`, `throws`
- **Primitive Types**: `boolean`, `byte`, `char`, `short`, `int`, `long`, `float`, `double`
- **Others**: `void`, `static`, `final`, `abstract`, `synchronized`, etc.

### Identifiers
Identifiers are names given to variables, classes, methods, etc. Rules for identifiers:

- Must start with a letter, dollar sign ($), or underscore (_)
- Cannot start with a digit
- Can contain letters, digits, dollar signs, and underscores
- Cannot be a keyword
- Cannot be `true`, `false`, or `null` (these are literals, not keywords)

## Comments

Java supports three types of comments:

```java
// Single-line comment

/*
 * Multi-line comment
 * spanning multiple lines
 */

/**
 * Documentation comment (Javadoc)
 * Used for generating documentation
 * @author Your Name
 */
```

## Packages

Packages are used to organize classes and avoid naming conflicts. They provide a namespace for classes, interfaces, and sub-packages.

```java
// Declaring a package
package com.example.myapp;

// Importing classes from packages
import java.util.ArrayList;
import java.util.Scanner;
// Import all classes from a package
import java.util.*;
```

### Package Naming Conventions
- Use lowercase letters
- Use reverse domain name notation (e.g., `com.company.project`)
- Avoid using Java's predefined package names

## Classes and Objects

### Class Definition
A class is a blueprint for objects that defines properties and behaviors:

```java
public class Person {
    // Fields (properties)
    private String name;
    private int age;
    
    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Methods (behaviors)
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

### Object Creation
Objects are instances of classes created using the `new` keyword:

```java
// Create a Person object
Person person1 = new Person("John", 25);

// Access methods
person1.introduce();

// Access and modify properties using getters and setters
String name = person1.getName();
person1.setAge(26);
```

## Access Modifiers

Java has four access modifiers that determine the visibility of classes, methods, and fields:

1. **public**: Accessible from any class
2. **protected**: Accessible within the same package and subclasses
3. **default** (no modifier): Accessible only within the same package
4. **private**: Accessible only within the same class

## Java Programming Conventions

1. **Classes**: Start with uppercase letter, use CamelCase (e.g., `BankAccount`)
2. **Methods and Variables**: Start with lowercase letter, use camelCase (e.g., `calculateInterest`)
3. **Constants**: All uppercase with underscores (e.g., `MAX_VALUE`)
4. **Packages**: All lowercase, using reverse domain name (e.g., `com.example.project`)
5. **Indentation**: Use 4 spaces or 1 tab for each level
6. **Braces**: Opening brace on the same line, closing brace on a new line
7. **Line Length**: Generally try to keep lines under 80-100 characters