# SOLID Principles

SOLID is an acronym for five design principles intended to make software designs more understandable, flexible, and maintainable.

## 1. Single Responsibility Principle (SRP)

**Definition**: A class should have only one reason to change, meaning it should have only one responsibility.

**Example**:

```java
// Bad: Class with multiple responsibilities
class UserManager {
    private User user;
    
    public UserManager(User user) {
        this.user = user;
    }
    
    public void saveUser() {
        // Database logic to save user
        System.out.println("Saving " + user.getName() + " to database");
    }
    
    public boolean validateEmail() {
        // Email validation logic
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return user.getEmail().matches(emailRegex);
    }
    
    public void sendEmail() {
        // Email sending logic
        System.out.println("Sending email to " + user.getEmail());
    }
}

// Good: Separated responsibilities
class UserRepository {
    public void saveUser(User user) {
        // Database logic only
        System.out.println("Saving " + user.getName() + " to database");
    }
}

class UserValidator {
    public boolean validateEmail(String email) {
        // Validation logic only
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }
}

class EmailService {
    public void sendEmail(String email, String message) {
        // Email sending logic only
        System.out.println("Sending email to " + email);
    }
}
```

## 2. Open/Closed Principle (OCP)

**Definition**: Software entities should be open for extension but closed for modification.

**Example**:

```java
// Bad: Need to modify class to add new shape
class AreaCalculator {
    public double calculateArea(Object shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getWidth() * rectangle.getHeight();
        }
        return 0; // Need to modify this class to add new shapes
    }
}

// Good: Open for extension
abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Can add new shapes without modifying existing code
class Triangle extends Shape {
    private double base;
    private double height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }
}

// Using the shapes
class AreaPrinter {
    public void printArea(Shape shape) {
        System.out.println("Area: " + shape.calculateArea());
    }
}
```

## 3. Liskov Substitution Principle (LSP)

**Definition**: Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

**Example**:

```java
// Bad: Violates LSP
class Bird {
    public void fly() {
        System.out.println("Flying high");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Cannot fly"); // Breaks the expected behavior
    }
}

// Good: Adheres to LSP
abstract class Bird {
    public abstract void move();
}

class FlyingBird extends Bird {
    @Override
    public void move() {
        fly();
    }
    
    public void fly() {
        System.out.println("Flying high");
    }
}

class SwimmingBird extends Bird {
    @Override
    public void move() {
        swim();
    }
    
    public void swim() {
        System.out.println("Swimming");
    }
}

// Any Bird can be used here
class BirdMover {
    public void makeBirdMove(Bird bird) {
        bird.move();
    }
}
```

## 4. Interface Segregation Principle (ISP)

**Definition**: Clients should not be forced to depend on interfaces they do not use.

**Example**:

```java
// Bad: Fat interface
interface Worker {
    void work();
    void eat();
    void takeBreak();
}

class Human implements Worker {
    @Override
    public void work() {
        System.out.println("Working");
    }
    
    @Override
    public void eat() {
        System.out.println("Eating lunch");
    }
    
    @Override
    public void takeBreak() {
        System.out.println("Taking break");
    }
}

// Robot can work but doesn't eat
class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Working");
    }
    
    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robots do not eat");
    }
    
    @Override
    public void takeBreak() {
        System.out.println("Charging");
    }
}

// Good: Segregated interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Restable {
    void takeBreak();
}

// Human implements all interfaces
class Human implements Workable, Eatable, Restable {
    @Override
    public void work() {
        System.out.println("Working");
    }
    
    @Override
    public void eat() {
        System.out.println("Eating lunch");
    }
    
    @Override
    public void takeBreak() {
        System.out.println("Taking break");
    }
}

// Robot only implements interfaces it needs
class Robot implements Workable, Restable {
    @Override
    public void work() {
        System.out.println("Working");
    }
    
    @Override
    public void takeBreak() {
        System.out.println("Charging");
    }
}
```

## 5. Dependency Inversion Principle (DIP)

**Definition**: High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

**Example**:

```java
// Bad: High-level module depends on low-level module
class MySQLDatabase {
    public void save(Object data) {
        System.out.println("Saving " + data + " to MySQL database");
    }
}

class UserService {
    private MySQLDatabase database;
    
    public UserService() {
        this.database = new MySQLDatabase(); // Direct dependency on concrete class
    }
    
    public void saveUser(User user) {
        database.save(user);
    }
}

// Good: Dependency Inversion
interface Database {
    void save(Object data);
    Object get(int id);
}

class MySQLDatabase implements Database {
    @Override
    public void save(Object data) {
        System.out.println("Saving " + data + " to MySQL database");
    }
    
    @Override
    public Object get(int id) {
        System.out.println("Getting record with id " + id + " from MySQL database");
        return new Object();
    }
}

class MongoDatabase implements Database {
    @Override
    public void save(Object data) {
        System.out.println("Saving " + data + " to MongoDB database");
    }
    
    @Override
    public Object get(int id) {
        System.out.println("Getting document with id " + id + " from MongoDB database");
        return new Object();
    }
}

class UserService {
    private Database database;
    
    // Dependency is injected
    public UserService(Database database) {
        this.database = database;
    }
    
    public void saveUser(User user) {
        database.save(user);
    }
    
    public User getUser(int id) {
        return (User) database.get(id);
    }
}

// Usage
class Main {
    public static void main(String[] args) {
        // Can easily switch databases
        Database mySqlDb = new MySQLDatabase();
        UserService userService1 = new UserService(mySqlDb);
        userService1.saveUser(new User("John"));
        
        Database mongoDb = new MongoDatabase();
        UserService userService2 = new UserService(mongoDb);
        userService2.saveUser(new User("Jane"));
    }
}
```

## Real-World Benefits of SOLID Principles

1. **Maintainability**: Easier to change and maintain code without breaking other parts
2. **Extensibility**: Can add new features without modifying existing code
3. **Testability**: Easier to write unit tests for isolated components
4. **Reusability**: Components can be reused in different contexts
5. **Reduced coupling**: Components are less dependent on each other

## Interview Tips

- Understand the intent behind each principle rather than just memorizing definitions
- Be prepared to identify SOLID violations in code examples
- Practice refactoring non-SOLID code to follow SOLID principles
- Know that these principles are guidelines, not strict rules - sometimes pragmatism is needed
- Discuss trade-offs: implementing SOLID principles might increase initial development time but pays off in the long term
- Connect SOLID principles to design patterns (many design patterns help implement SOLID principles)
- Emphasize how SOLID principles improve team collaboration in larger codebases
- Mention real-world experiences where applying SOLID principles solved problems