# Operators in Java

Operators are special symbols that perform operations on variables and values. Java provides a rich set of operators to manipulate variables and values.

## 1. Arithmetic Operators

Used to perform common mathematical operations.

| Operator | Description | Example |
|----------|-------------|---------|
| `+`      | Addition    | `a + b` |
| `-`      | Subtraction | `a - b` |
| `*`      | Multiplication | `a * b` |
| `/`      | Division    | `a / b` |
| `%`      | Modulus (remainder) | `a % b` |
| `++`     | Increment   | `a++` or `++a` |
| `--`     | Decrement   | `a--` or `--a` |

### Examples:

```java
int a = 10;
int b = 3;

int sum = a + b;       // 13
int difference = a - b; // 7
int product = a * b;    // 30
int quotient = a / b;   // 3 (integer division)
int remainder = a % b;  // 1

// Increment/decrement
int c = 5;
c++;                  // c is now 6
int d = ++c;          // d is 7, c is 7 (pre-increment)
int e = c++;          // e is 7, c is 8 (post-increment)
```

**Note:** When using `/` with integers, the result is an integer (fractional part is truncated). To get a decimal result, at least one of the operands must be a floating-point type.

```java
double result1 = 10 / 3;      // 3.0 (integer division)
double result2 = 10.0 / 3;    // 3.3333... (floating-point division)
```

## 2. Relational Operators

Used to compare two values.

| Operator | Description | Example |
|----------|-------------|---------|
| `==`     | Equal to    | `a == b` |
| `!=`     | Not equal to | `a != b` |
| `>`      | Greater than | `a > b` |
| `<`      | Less than   | `a < b` |
| `>=`     | Greater than or equal to | `a >= b` |
| `<=`     | Less than or equal to | `a <= b` |

### Examples:

```java
int a = 10;
int b = 20;

boolean isEqual = (a == b);       // false
boolean isNotEqual = (a != b);    // true
boolean isGreater = (a > b);      // false
boolean isLess = (a < b);         // true
boolean isGreaterOrEqual = (a >= b); // false
boolean isLessOrEqual = (a <= b);    // true
```

**Important Note:** For objects, `==` compares references (if they point to the same object), not the content. Use the `equals()` method to compare object contents.

```java
String str1 = new String("Hello");
String str2 = new String("Hello");

boolean refEqual = (str1 == str2);           // false (different objects)
boolean contentEqual = str1.equals(str2);    // true (same content)
```

## 3. Logical Operators

Used to combine multiple conditions.

| Operator | Description | Example |
|----------|-------------|---------|
| `&&`     | Logical AND | `a && b` |
| `\|\|`   | Logical OR  | `a \|\| b` |
| `!`      | Logical NOT | `!a` |

### Examples:

```java
boolean a = true;
boolean b = false;

boolean andResult = a && b;    // false
boolean orResult = a || b;     // true
boolean notResult = !a;        // false
```

**Short-circuit Evaluation:**
- `&&`: If the left operand is `false`, the right operand is not evaluated
- `||`: If the left operand is `true`, the right operand is not evaluated

```java
// Short-circuit example
int x = 10;
boolean result = (x > 20) && (x++ > 0);  // x++ is not evaluated
System.out.println(x);  // Still 10
```

## 4. Bitwise Operators

Perform operations on individual bits of integer types.

| Operator | Description | Example |
|----------|-------------|---------|
| `&`      | Bitwise AND | `a & b` |
| `\|`     | Bitwise OR  | `a \| b` |
| `^`      | Bitwise XOR | `a ^ b` |
| `~`      | Bitwise NOT | `~a` |
| `<<`     | Left shift  | `a << b` |
| `>>`     | Right shift | `a >> b` |
| `>>>`    | Unsigned right shift | `a >>> b` |

### Examples:

```java
int a = 5;  // 0101 in binary
int b = 3;  // 0011 in binary

int andResult = a & b;   // 0001 (1 in decimal)
int orResult = a | b;    // 0111 (7 in decimal)
int xorResult = a ^ b;   // 0110 (6 in decimal)
int notResult = ~a;      // 1010 (-6 in decimal due to two's complement)

int leftShift = a << 1;  // 1010 (10 in decimal)
int rightShift = a >> 1; // 0010 (2 in decimal)
```

**Bit Shift Examples:**
- Left shift (`<<`) multiplies the number by 2 for each shift position
- Right shift (`>>`) divides the number by 2 for each shift position (preserving sign)
- Unsigned right shift (`>>>`) divides the number by 2 for each shift position (always filling with 0)

```java
int x = 8;     // 1000 in binary
System.out.println(x << 1);  // 16 (10000)
System.out.println(x >> 1);  // 4 (0100)

int negative = -8;  // 11111111111111111111111111111000 in binary (32-bit)
System.out.println(negative >> 1);   // -4 (sign bit preserved)
System.out.println(negative >>> 1);  // Large positive number (sign bit not preserved)
```

## 5. Assignment Operators

Used to assign values to variables.

| Operator | Description | Example | Equivalent |
|----------|-------------|---------|------------|
| `=`      | Assignment  | `a = b` | `a = b` |
| `+=`     | Add and assign | `a += b` | `a = a + b` |
| `-=`     | Subtract and assign | `a -= b` | `a = a - b` |
| `*=`     | Multiply and assign | `a *= b` | `a = a * b` |
| `/=`     | Divide and assign | `a /= b` | `a = a / b` |
| `%=`     | Modulus and assign | `a %= b` | `a = a % b` |
| `&=`     | Bitwise AND and assign | `a &= b` | `a = a & b` |
| `\|=`    | Bitwise OR and assign | `a \|= b` | `a = a \| b` |
| `^=`     | Bitwise XOR and assign | `a ^= b` | `a = a ^ b` |
| `<<=`    | Left shift and assign | `a <<= b` | `a = a << b` |
| `>>=`    | Right shift and assign | `a >>= b` | `a = a >> b` |
| `>>>=`   | Unsigned right shift and assign | `a >>>= b` | `a = a >>> b` |

### Examples:

```java
int a = 10;
a += 5;  // a is now 15 (equivalent to a = a + 5)
a -= 3;  // a is now 12 (equivalent to a = a - 3)
a *= 2;  // a is now 24 (equivalent to a = a * 2)
a /= 6;  // a is now 4 (equivalent to a = a / 6)
a %= 3;  // a is now 1 (equivalent to a = a % 3)

int b = 5;
b &= 3;  // b is now 1 (equivalent to b = b & 3)
b |= 4;  // b is now 5 (equivalent to b = b | 4)
b ^= 3;  // b is now 6 (equivalent to b = b ^ 3)
b <<= 1; // b is now 12 (equivalent to b = b << 1)
b >>= 1; // b is now 6 (equivalent to b = b >> 1)
```

## 6. Ternary Operator

The conditional operator (? :) is a shorthand for the if-then-else statement.

**Syntax:**
```java
variable = (condition) ? expressionIfTrue : expressionIfFalse;
```

### Examples:

```java
int a = 10;
int b = 20;
int max = (a > b) ? a : b;  // max is 20

String status = (age >= 18) ? "Adult" : "Minor";
```

Nested ternary operators are possible but can reduce readability:

```java
int x = 5;
String result = (x > 10) ? "Greater than 10" : 
                (x > 5) ? "Between 6 and 10" : 
                (x > 0) ? "Between 1 and 5" : "Less than or equal to 0";
```

## 7. instanceof Operator

Used to test if an object is an instance of a specific class or interface.

**Syntax:**
```java
(object) instanceof (class/interface)
```

### Examples:

```java
String str = "Hello";
boolean isString = str instanceof String;  // true

Object obj = new String("Test");
boolean isObject = obj instanceof Object;  // true
boolean isString2 = obj instanceof String; // true

// With inheritance
class Animal {}
class Dog extends Animal {}

Dog dog = new Dog();
boolean isDog = dog instanceof Dog;      // true
boolean isAnimal = dog instanceof Animal; // true
```

## Operator Precedence

When multiple operators appear in an expression, the order of evaluation is determined by operator precedence.

| Operator Category | Operators | Associativity |
|-------------------|-----------|---------------|
| Postfix | `expr++` `expr--` | Left to right |
| Unary | `++expr` `--expr` `+expr` `-expr` `~` `!` | Right to left |
| Multiplicative | `*` `/` `%` | Left to right |
| Additive | `+` `-` | Left to right |
| Shift | `<<` `>>` `>>>` | Left to right |
| Relational | `<` `>` `<=` `>=` `instanceof` | Left to right |
| Equality | `==` `!=` | Left to right |
| Bitwise AND | `&` | Left to right |
| Bitwise XOR | `^` | Left to right |
| Bitwise OR | `\|` | Left to right |
| Logical AND | `&&` | Left to right |
| Logical OR | `\|\|` | Left to right |
| Conditional | `? :` | Right to left |
| Assignment | `=` `+=` `-=` `*=` `/=` `%=` `&=` `^=` `\|=` `<<=` `>>=` `>>>=` | Right to left |

### Example with Precedence:

```java
int result = 10 + 5 * 2;  // 20, not 30 (multiplication has higher precedence)
int result2 = (10 + 5) * 2;  // 30 (parentheses override precedence)

boolean logic = true || false && false;  // true (&& has higher precedence than ||)
boolean logic2 = (true || false) && false;  // false (with parentheses)
```

**Best Practice:** Use parentheses to make your code more readable, even when they are not strictly necessary.