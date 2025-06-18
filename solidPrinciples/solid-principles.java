/* 
 * SOLID Principles in Java - Code Examples
 * This file contains code examples for SOLID principles in Java.
 * 
 * Note: This is a JavaScript file containing Java code examples for reference.
 * These examples are for illustration purposes and are not meant to be executed in a JavaScript environment.
 */

/*
 * 1. Single Responsibility Principle
 * Each class has only one reason to change
 */

// User entity
class User {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
}

// Handles only user storage
class UserRepository {
    public void saveUser(User user) {
        System.out.println("Saving " + user.getName() + " to database");
        // Database logic here
    }
    
    public User getUser(int userId) {
        System.out.println("Getting user with ID: " + userId);
        // Database retrieval logic here
        return new User("Sample", "sample@example.com");
    }
}

// Handles only email validation
class UserValidator {
    public boolean validateEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }
}

// Handles only notification sending
class NotificationService {
    public void sendEmail(User user, String message) {
        System.out.println("Sending email to " + user.getEmail() + ": " + message);
        // Email sending logic here
    }
}

/*
 * 2. Open/Closed Principle
 * Open for extension, closed for modification
 */

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

// New shape added without modifying existing code
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

// Area calculator that doesn't need modification for new shapes
class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}

/*
 * 3. Liskov Substitution Principle
 * Subtypes must be substitutable for their base types
 */

// Bad Example (violates LSP)
class Bird {
    public void fly() {
        System.out.println("Flying high");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        // Problem: Penguins can't fly, but we're forced to implement this method
        throw new UnsupportedOperationException("Cannot fly");
    }
}

// Good Example (follows LSP)
abstract class BetterBird {
    public abstract void move();
}

class FlyingBird extends BetterBird {
    @Override
    public void move() {
        fly();
    }
    
    public void fly() {
        System.out.println("Flying high");
    }
}

class SwimmingBird extends BetterBird {
    @Override
    public void move() {
        swim();
    }
    
    public void swim() {
        System.out.println("Swimming");
    }
}

// This function works with any BetterBird subclass
class BirdMover {
    public void makeBirdMove(BetterBird bird) {
        bird.move();  // Works properly with any subclass
    }
}

/*
 * 4. Interface Segregation Principle
 * Many specific interfaces are better than one general interface
 */

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

// Robot can work but doesn't eat (violates ISP)
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

// Human implements all interfaces it needs
class BetterHuman implements Workable, Eatable, Restable {
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
class BetterRobot implements Workable, Restable {
    @Override
    public void work() {
        System.out.println("Working");
    }
    
    @Override
    public void takeBreak() {
        System.out.println("Charging");
    }
}

/*
 * 5. Dependency Inversion Principle
 * Depend on abstractions, not on concretions
 */

// Bad: Direct dependency on concrete class
class MySQLDatabase {
    public void save(Object data) {
        System.out.println("Saving " + data + " to MySQL database");
    }
    
    public Object get(int id) {
        return "Data from MySQL with id " + id;
    }
}

class UserServiceBad {
    private MySQLDatabase database; // Directly dependent on MySQL implementation
    
    public UserServiceBad() {
        this.database = new MySQLDatabase();
    }
    
    public void saveUser(User user) {
        database.save(user);
    }
    
    public Object getUser(int id) {
        return database.get(id);
    }
}

// Good: Depend on abstraction
interface Database {
    void save(Object data);
    Object get(int id);
}

class MySQLDatabaseImpl implements Database {
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

class MongoDatabaseImpl implements Database {
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

class UserServiceGood {
    private Database database; // Depends on abstraction, not implementation
    
    // Dependency is injected
    public UserServiceGood(Database database) {
        this.database = database;
    }
    
    public void saveUser(User user) {
        database.save(user);
    }
    
    public Object getUser(int id) {
        return database.get(id);
    }
}

// Usage Example
class Main {
    public static void main(String[] args) {
        // Single Responsibility Principle
        User user = new User("John Doe", "john@example.com");
        UserRepository userRepo = new UserRepository();
        UserValidator validator = new UserValidator();
        NotificationService notifier = new NotificationService();
        
        if (validator.validateEmail(user.getEmail())) {
            userRepo.saveUser(user);
            notifier.sendEmail(user, "Welcome to our platform!");
        }
        
        // Open/Closed Principle
        AreaCalculator calculator = new AreaCalculator();
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 8);
        
        System.out.println("Circle area: " + calculator.calculateArea(circle));
        System.out.println("Rectangle area: " + calculator.calculateArea(rectangle));
        System.out.println("Triangle area: " + calculator.calculateArea(triangle));
        
        // Liskov Substitution Principle
        BirdMover birdMover = new BirdMover();
        BetterBird eagle = new FlyingBird();
        BetterBird penguin = new SwimmingBird();
        
        birdMover.makeBirdMove(eagle);    // Works correctly
        birdMover.makeBirdMove(penguin);  // Works correctly
        
        // Interface Segregation Principle
        Workable human = new BetterHuman();
        Workable robot = new BetterRobot();
        
        human.work();  // Both can work
        robot.work();
        
        // Dependency Inversion Principle
        Database mySqlDb = new MySQLDatabaseImpl();
        Database mongoDb = new MongoDatabaseImpl();
        
        UserServiceGood userService1 = new UserServiceGood(mySqlDb);
        userService1.saveUser(user);
        
        UserServiceGood userService2 = new UserServiceGood(mongoDb);
        userService2.saveUser(user);
    }
}