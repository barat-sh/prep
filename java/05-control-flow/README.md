# Control Flow in Java

Control flow statements in Java determine the order in which statements are executed in a program. They allow you to make decisions, perform iterations, and branch to different parts of your code based on conditions.

## 1. Decision Making Statements

### 1.1 if Statement

The `if` statement executes a block of code if a specified condition is `true`.

**Syntax:**
```java
if (condition) {
    // code to be executed if condition is true
}
```

**Example:**
```java
int age = 20;

if (age >= 18) {
    System.out.println("You are an adult.");
}
```

### 1.2 if-else Statement

The `if-else` statement executes one block of code if a condition is `true` and another block if the condition is `false`.

**Syntax:**
```java
if (condition) {
    // code to be executed if condition is true
} else {
    // code to be executed if condition is false
}
```

**Example:**
```java
int age = 16;

if (age >= 18) {
    System.out.println("You are an adult.");
} else {
    System.out.println("You are a minor.");
}
```

### 1.3 if-else-if Ladder

The `if-else-if` ladder checks multiple conditions in sequence.

**Syntax:**
```java
if (condition1) {
    // code to be executed if condition1 is true
} else if (condition2) {
    // code to be executed if condition2 is true
} else if (condition3) {
    // code to be executed if condition3 is true
} else {
    // code to be executed if all conditions are false
}
```

**Example:**
```java
int score = 85;

if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else if (score >= 70) {
    System.out.println("Grade: C");
} else if (score >= 60) {
    System.out.println("Grade: D");
} else {
    System.out.println("Grade: F");
}
```

### 1.4 Nested if Statements

You can place `if` statements inside other `if` or `else` blocks.

**Example:**
```java
int age = 25;
boolean hasLicense = true;

if (age >= 18) {
    if (hasLicense) {
        System.out.println("You can drive.");
    } else {
        System.out.println("You need a license to drive.");
    }
} else {
    System.out.println("You are too young to drive.");
}
```

### 1.5 switch Statement

The `switch` statement tests a variable against multiple values.

**Syntax:**
```java
switch (expression) {
    case value1:
        // code to be executed if expression equals value1
        break;
    case value2:
        // code to be executed if expression equals value2
        break;
    ...
    default:
        // code to be executed if expression doesn't equal any values
}
```

**Example:**
```java
int day = 3;
String dayName;

switch (day) {
    case 1:
        dayName = "Monday";
        break;
    case 2:
        dayName = "Tuesday";
        break;
    case 3:
        dayName = "Wednesday";
        break;
    case 4:
        dayName = "Thursday";
        break;
    case 5:
        dayName = "Friday";
        break;
    case 6:
        dayName = "Saturday";
        break;
    case 7:
        dayName = "Sunday";
        break;
    default:
        dayName = "Invalid day";
}

System.out.println("Day: " + dayName);
```

#### Switch Statement with Fall-Through

If you omit the `break` statement, execution will "fall through" to the next case.

**Example:**
```java
int month = 2;
String season;

switch (month) {
    case 12:
    case 1:
    case 2:
        season = "Winter";
        break;
    case 3:
    case 4:
    case 5:
        season = "Spring";
        break;
    case 6:
    case 7:
    case 8:
        season = "Summer";
        break;
    case 9:
    case 10:
    case 11:
        season = "Fall";
        break;
    default:
        season = "Invalid month";
}

System.out.println("Season: " + season);
```

#### Enhanced Switch (Java 12+)

Java 12 introduced an enhanced `switch` expression that is more concise and avoids the need for explicit `break` statements.

**Example:**
```java
int day = 3;
String dayName = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    case 4 -> "Thursday";
    case 5 -> "Friday";
    case 6 -> "Saturday";
    case 7 -> "Sunday";
    default -> "Invalid day";
};

System.out.println("Day: " + dayName);
```

## 2. Looping Statements

### 2.1 for Loop

The `for` loop executes a block of code a specified number of times.

**Syntax:**
```java
for (initialization; condition; update) {
    // code to be executed
}
```

**Example:**
```java
for (int i = 0; i < 5; i++) {
    System.out.println("Count: " + i);
}
```

#### Enhanced for Loop (for-each)

The enhanced `for` loop simplifies iterating over arrays and collections.

**Syntax:**
```java
for (elementType element : array/collection) {
    // code to be executed
}
```

**Example:**
```java
int[] numbers = {1, 2, 3, 4, 5};

for (int num : numbers) {
    System.out.println("Number: " + num);
}
```

### 2.2 while Loop

The `while` loop executes a block of code as long as a condition is `true`.

**Syntax:**
```java
while (condition) {
    // code to be executed
}
```

**Example:**
```java
int count = 0;

while (count < 5) {
    System.out.println("Count: " + count);
    count++;
}
```

### 2.3 do-while Loop

The `do-while` loop is similar to the `while` loop, but it executes the code block at least once before checking the condition.

**Syntax:**
```java
do {
    // code to be executed
} while (condition);
```

**Example:**
```java
int count = 0;

do {
    System.out.println("Count: " + count);
    count++;
} while (count < 5);
```

## 3. Branching Statements

### 3.1 break Statement

The `break` statement terminates the loop or switch statement and transfers execution to the statement immediately following the loop or switch.

**Example:**
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break; // Exit the loop when i equals 5
    }
    System.out.println("Count: " + i);
}
```

### 3.2 continue Statement

The `continue` statement skips the current iteration of a loop and continues with the next iteration.

**Example:**
```java
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue; // Skip even numbers
    }
    System.out.println("Odd Number: " + i);
}
```

### 3.3 labeled Statements

Labels can be used with `break` and `continue` statements to control nested loops.

**Example:**
```java
outerLoop: for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
            break outerLoop; // Break out of both loops
        }
        System.out.println("i = " + i + ", j = " + j);
    }
}
```

### 3.4 return Statement

The `return` statement exits from a method, optionally returning a value.

**Example:**
```java
public static int findMax(int[] numbers) {
    if (numbers.length == 0) {
        return -1; // Return early for empty array
    }
    
    int max = numbers[0];
    for (int num : numbers) {
        if (num > max) {
            max = num;
        }
    }
    return max;
}
```

## 4. Exception Handling

Exception handling is also a form of control flow in Java. It allows you to handle runtime errors and exceptions.

**Example:**
```java
try {
    int result = 10 / 0; // This will cause an ArithmeticException
    System.out.println("Result: " + result);
} catch (ArithmeticException e) {
    System.out.println("Error: Division by zero");
} finally {
    System.out.println("This code always executes");
}
```

## 5. Java 17 Pattern Matching for switch (Preview)

Java 17 introduced a preview feature that allows pattern matching in switch expressions and statements.

**Example:**
```java
Object obj = "Hello";

String result = switch (obj) {
    case Integer i -> "An integer: " + i;
    case String s -> "A string: " + s;
    case null -> "A null value";
    default -> "Something else";
};

System.out.println(result);
```

## Best Practices for Control Flow

1. **Keep it Simple**: Avoid deeply nested control structures (more than 2-3 levels) as they reduce readability.

2. **Use Braces**: Always use braces `{}` even for single-statement blocks to avoid errors when adding more statements later.

3. **Prefer for-each**: Use enhanced for loops (for-each) when iterating over collections or arrays when possible.

4. **Exit Early**: Return early from methods when preconditions are not met to avoid deep nesting.

5. **Use Meaningful Names**: Choose descriptive variable names for loop counters and conditions.

6. **Limit Switch Complexity**: Keep switch statements focused on a single concern.

7. **Handle Exceptions Properly**: Catch specific exceptions rather than generic Exception class.

8. **Prefer Positive Conditions**: Write conditions that check for positive cases (what should happen) rather than negative cases.

9. **Avoid Endless Loops**: Ensure that loops have a terminating condition that will eventually be reached.

10. **Be Careful with Floating-Point Comparisons**: Avoid using `==` for floating-point comparisons; use a small delta value instead.