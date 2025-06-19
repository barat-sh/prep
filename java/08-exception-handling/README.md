# Exception Handling in Java

Exception handling is a mechanism to handle runtime errors in Java programs. It allows you to separate error-handling code from normal code, making your programs more robust and readable.

## 1. Introduction to Exceptions

An exception is an event that disrupts the normal flow of program execution. When an exception occurs, the Java runtime system creates an exception object and tries to find a suitable handler for it.

### Types of Exceptions

In Java, exceptions are organized in a class hierarchy with `Throwable` as the parent class.

1. **Checked Exceptions**:
   - Subclasses of `Exception` (excluding `RuntimeException` and its subclasses)
   - Must be either caught or declared in the method signature using the `throws` clause
   - Represent conditions that a reasonable application might want to catch
   - Examples: `IOException`, `SQLException`, `ClassNotFoundException`

2. **Unchecked Exceptions**:
   - Subclasses of `RuntimeException`
   - Do not need to be explicitly caught or declared
   - Represent programming errors or unexpected conditions
   - Examples: `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`

3. **Errors**:
   - Subclasses of `Error`
   - Represent severe problems that are not intended to be caught or handled by applications
   - Examples: `OutOfMemoryError`, `StackOverflowError`, `VirtualMachineError`

## 2. Exception Hierarchy

```
Throwable
├── Error
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── ...
└── Exception
    ├── IOException
    ├── SQLException
    ├── ClassNotFoundException
    ├── RuntimeException
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   ├── ArithmeticException
    │   └── ...
    └── ...
```

## 3. try-catch Block

The `try-catch` block is used to catch and handle exceptions.

### Basic Syntax

```java
try {
    // Code that might throw an exception
} catch (ExceptionType1 e1) {
    // Handler for ExceptionType1
} catch (ExceptionType2 e2) {
    // Handler for ExceptionType2
} finally {
    // Code that always executes, regardless of whether an exception occurred
}
```

### Example

```java
public void readFile(String filename) {
    FileReader file = null;
    try {
        file = new FileReader(filename);
        // Code to read the file
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
    } finally {
        try {
            if (file != null) {
                file.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing file: " + e.getMessage());
        }
    }
}
```

### Multi-catch Block (Java 7+)

Since Java 7, you can catch multiple exception types in a single catch block.

```java
try {
    // Code that might throw different exceptions
} catch (IOException | SQLException e) {
    // Handler for both IOException and SQLException
    System.err.println("Error: " + e.getMessage());
}
```

## 4. try-with-resources (Java 7+)

Java 7 introduced a new feature called try-with-resources that automatically closes resources (like files, database connections, etc.) when they are no longer needed.

### Syntax

```java
try (Resource1 res1 = new Resource1();
     Resource2 res2 = new Resource2()) {
    // Use the resources
} catch (Exception e) {
    // Handle exceptions
}
```

### Example

```java
public void readFile(String filename) {
    try (FileReader fr = new FileReader(filename);
         BufferedReader br = new BufferedReader(fr)) {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
    // Resources are automatically closed
}
```

## 5. throw Statement

The `throw` statement is used to explicitly throw an exception.

### Syntax

```java
throw new ExceptionType("Error message");
```

### Example

```java
public double divide(int a, int b) {
    if (b == 0) {
        throw new ArithmeticException("Division by zero");
    }
    return (double) a / b;
}
```

## 6. throws Clause

The `throws` clause is used in a method declaration to indicate that the method might throw certain exceptions.

### Syntax

```java
return_type method_name(parameters) throws ExceptionType1, ExceptionType2, ... {
    // Method body
}
```

### Example

```java
public void readFile(String filename) throws IOException {
    FileReader fr = new FileReader(filename); // Might throw FileNotFoundException
    BufferedReader br = new BufferedReader(fr);
    
    String line;
    while ((line = br.readLine()) != null) { // Might throw IOException
        System.out.println(line);
    }
    
    br.close(); // Might throw IOException
    fr.close(); // Might throw IOException
}
```

## 7. Custom Exceptions

You can create your own exception classes by extending `Exception` (for checked exceptions) or `RuntimeException` (for unchecked exceptions).

### Example: Checked Custom Exception

```java
public class InsufficientFundsException extends Exception {
    private double amount;
    
    public InsufficientFundsException(double amount) {
        super("Insufficient funds: Trying to withdraw $" + amount);
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
}

public class BankAccount {
    private double balance;
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }
        balance -= amount;
    }
}
```

### Example: Unchecked Custom Exception

```java
public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Person {
    private int age;
    
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age: " + age);
        }
        this.age = age;
    }
}
```

## 8. Exception Chaining

Exception chaining allows you to associate one exception with another. This is useful when you want to throw a new exception while preserving information about the original cause.

```java
try {
    // Code that might throw an exception
} catch (Exception e) {
    throw new CustomException("A custom message", e); // Chaining the exception
}
```

## 9. Common Exceptions

### Checked Exceptions
- `IOException`: Signals a problem with I/O operations
- `SQLException`: Signals a problem with database access
- `ClassNotFoundException`: Thrown when an application tries to load a class through its string name
- `InterruptedException`: Thrown when a thread is interrupted

### Unchecked Exceptions
- `NullPointerException`: Thrown when attempting to use `null` where an object is required
- `ArrayIndexOutOfBoundsException`: Thrown when attempting to access an array element with an invalid index
- `ArithmeticException`: Thrown for arithmetic errors, such as division by zero
- `IllegalArgumentException`: Thrown when a method receives an inappropriate argument
- `NumberFormatException`: Thrown when attempting to convert a string to a numeric type, but the string doesn't have the appropriate format

## 10. Best Practices for Exception Handling

1. **Use Specific Exceptions**: Catch the most specific exception first, followed by more general ones.

2. **Don't Catch and Ignore Exceptions**: Always handle the exception or rethrow it. Don't catch exceptions and do nothing with them.

3. **Log Exceptions**: Always log exceptions with enough context to understand what happened.

4. **Clean up Resources**: Use `finally` block or try-with-resources to clean up resources.

5. **Use Unchecked Exceptions for Programming Errors**: Use unchecked exceptions for errors that cannot be reasonably recovered from.

6. **Use Checked Exceptions for Recoverable Conditions**: Use checked exceptions for conditions that a reasonable application might want to catch.

7. **Include Meaningful Error Messages**: Always include meaningful error messages in your exceptions.

8. **Wrap Exceptions When Necessary**: Use exception chaining to preserve the original cause.

9. **Don't Use Exceptions for Control Flow**: Exceptions should be used for exceptional conditions, not for normal program flow.

10. **Throw Early, Catch Late**: Validate parameters early and catch exceptions as late as possible.

## 11. Java 7+ Exception Handling Features

### Multi-catch Block

```java
try {
    // Code that might throw different exceptions
} catch (IOException | SQLException e) {
    // Handle both IOException and SQLException
}
```

### Try-with-resources

```java
try (FileReader fr = new FileReader(file);
     BufferedReader br = new BufferedReader(fr)) {
    // Use the resources
}
```

### Improved Exception Rethrowing

In Java 7+, you can rethrow an exception and the compiler will track the possible exception types through type analysis.

```java
public void rethrowException(String exceptionType) throws IOException, SQLException {
    try {
        if (exceptionType.equals("IOException")) {
            throw new IOException();
        } else {
            throw new SQLException();
        }
    } catch (Exception e) {
        // In Java 7+, the compiler knows that 'e' can only be
        // IOException or SQLException
        throw e;
    }
}
```

## 12. Exception Suppression (Java 7+)

In try-with-resources, if both the try block and the automatic resource closing throw exceptions, the exception from the try block is thrown and the exception from the closing is suppressed. The suppressed exceptions can be retrieved using the `getSuppressed()` method.

```java
try (AutoCloseable resource = new ResourceThatThrowsException()) {
    throw new Exception("Try block exception");
} catch (Exception e) {
    System.out.println("Main exception: " + e.getMessage());
    for (Throwable suppressed : e.getSuppressed()) {
        System.out.println("Suppressed: " + suppressed.getMessage());
    }
}
```