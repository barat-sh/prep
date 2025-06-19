# Introduction to Java

## What is Java?

Java is a high-level, class-based, object-oriented programming language that was developed by Sun Microsystems (now owned by Oracle) in 1995. It was designed to have as few implementation dependencies as possible, allowing developers to "write once, run anywhere" (WORA).

## Key Features of Java

1. **Platform Independence**: Java code compiles into bytecode that can run on any device with a Java Virtual Machine (JVM).

2. **Object-Oriented**: Java follows object-oriented programming principles, organizing code into classes and objects.

3. **Simple and Familiar**: Java syntax is derived from C/C++ but eliminates complex features like pointers and operator overloading.

4. **Robust and Secure**: Java's strong memory management, exception handling, and security features make it reliable.

5. **Multithreaded**: Java supports concurrent programming with built-in multithreading capabilities.

6. **Dynamic**: Java adapts to an evolving environment by loading classes as needed.

## Java Architecture

### JDK (Java Development Kit)
The JDK is a software development environment used for developing Java applications. It includes:
- JRE (Java Runtime Environment)
- Development tools (compiler, debugger, etc.)
- Java API libraries

### JRE (Java Runtime Environment)
The JRE provides the libraries, JVM, and other components necessary to run Java applications.

### JVM (Java Virtual Machine)
The JVM is the heart of Java's "write once, run anywhere" principle. It:
- Loads, verifies, and executes Java bytecode
- Provides a runtime environment for Java applications
- Is platform-specific but executes platform-independent bytecode

## How Java Works

1. Developers write Java code in `.java` files
2. The Java compiler (`javac`) compiles the code into bytecode (`.class` files)
3. The JVM executes the bytecode
4. The program runs on the host machine

## Installation

### Installing Java on Windows
1. Download the JDK installer from [Oracle's website](https://www.oracle.com/java/technologies/downloads/)
2. Run the installer and follow the on-screen instructions
3. Set up environment variables:
   - Set `JAVA_HOME` to the JDK installation directory
   - Add `%JAVA_HOME%\bin` to the `Path` variable

### Installing Java on macOS
1. Download the JDK installer for macOS
2. Run the installer
3. Verify installation: Open Terminal and type `java -version`

### Installing Java on Linux
```bash
# For Ubuntu/Debian
sudo apt update
sudo apt install openjdk-11-jdk

# For Fedora/Red Hat
sudo dnf install java-11-openjdk-devel
```

## First Java Program

Let's create a simple "Hello, World!" program:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Understanding the Code

- `public class HelloWorld`: Defines a class named HelloWorld
- `public static void main(String[] args)`: The main method where program execution begins
- `System.out.println("Hello, World!")`: Prints text to the console

### Compiling and Running

```bash
# Compile the Java file
javac HelloWorld.java

# Run the compiled class file
java HelloWorld
```

## Java Versions

Java has evolved significantly since its inception:

- **Java 8 (LTS)**: Introduced lambda expressions, stream API, and functional interfaces
- **Java 11 (LTS)**: Added local variable syntax for lambda parameters, HTTP client
- **Java 17 (LTS)**: Latest long-term support release with sealed classes, pattern matching
- **Java 21**: Current latest release with enhanced pattern matching, virtual threads

## Applications of Java

- **Enterprise Applications**: Large-scale business applications
- **Android Development**: Primary language for Android app development
- **Web Applications**: Server-side applications using technologies like Spring, JSP
- **Scientific Applications**: Used in research and numerical computing
- **Big Data Technologies**: Hadoop, Spark, and other big data tools use Java