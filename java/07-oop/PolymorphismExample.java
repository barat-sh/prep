/**
 * This class demonstrates polymorphism in Java
 */
public class PolymorphismExample {
    public static void main(String[] args) {
        System.out.println("=== Polymorphism in Java ===\n");
        
        // Method Overloading (Compile-time Polymorphism)
        System.out.println("--- Method Overloading (Compile-time Polymorphism) ---");
        
        Calculator calc = new Calculator();
        
        // Calling overloaded methods with different parameter types and counts
        System.out.println("Adding two integers: " + calc.add(5, 3));
        System.out.println("Adding three integers: " + calc.add(5, 3, 2));
        System.out.println("Adding two doubles: " + calc.add(5.5, 3.3));
        System.out.println("Adding a string and an integer: " + calc.add("Value: ", 10));
        
        // Method Overriding (Runtime Polymorphism)
        System.out.println("\n--- Method Overriding (Runtime Polymorphism) ---");
        
        // Create instances of superclass and subclasses
        Shape shape = new Shape();
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        
        // Call the draw() method on each object
        shape.draw();      // Shape's implementation
        circle.draw();     // Circle's implementation (overridden)
        rectangle.draw();  // Rectangle's implementation (overridden)
        triangle.draw();   // Triangle's implementation (overridden)
        
        // Using Polymorphic References
        System.out.println("\n--- Using Polymorphic References ---");
        
        // Array of Shape references holding different subclass objects
        Shape[] shapes = new Shape[4];
        shapes[0] = shape;
        shapes[1] = circle;
        shapes[2] = rectangle;
        shapes[3] = triangle;
        
        // Process all shapes polymorphically
        System.out.println("\nDrawing all shapes in the array:");
        for (Shape s : shapes) {
            s.draw();  // Calls the appropriate overridden method
        }
        
        // Calculate and display areas
        System.out.println("\nCalculating areas of shapes:");
        for (Shape s : shapes) {
            System.out.println("Area: " + s.calculateArea());
        }
        
        // Polymorphism with method parameters
        System.out.println("\n--- Polymorphism with Method Parameters ---");
        
        printShapeInfo(shape);
        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
        
        // Dynamic Method Dispatch
        System.out.println("\n--- Dynamic Method Dispatch ---");
        
        // Assign different objects to the same reference variable
        Shape currentShape = shape;
        currentShape.draw();  // Calls Shape's implementation
        
        currentShape = circle;
        currentShape.draw();  // Calls Circle's implementation
        
        currentShape = rectangle;
        currentShape.draw();  // Calls Rectangle's implementation
        
        // Polymorphism with instanceof operator
        System.out.println("\n--- Using instanceof with Polymorphism ---");
        
        processShape(shape);
        processShape(circle);
        processShape(rectangle);
        processShape(triangle);
        
        // Virtual Methods in Java
        System.out.println("\n--- Virtual Methods in Java ---");
        
        BaseClass baseObj = new BaseClass();
        BaseClass derivedObj = new DerivedClass();
        
        baseObj.display();    // Calls BaseClass's implementation
        derivedObj.display(); // Calls DerivedClass's implementation (virtual method dispatch)
        
        // Polymorphism with constructors
        System.out.println("\n--- Polymorphism with Constructors ---");
        
        System.out.println("Creating a Parent object:");
        Parent parent = new Parent();
        
        System.out.println("\nCreating a Child object:");
        Child child = new Child();
        
        // Polymorphism with static methods (doesn't work as expected)
        System.out.println("\n--- Static Methods and Polymorphism ---");
        
        StaticParent staticParent = new StaticParent();
        StaticParent staticChild = new StaticChild();
        
        staticParent.staticMethod();  // Calls StaticParent's implementation
        staticChild.staticMethod();   // Also calls StaticParent's implementation (no overriding)
        
        // Calling directly through class name
        StaticParent.staticMethod();  // StaticParent's implementation
        StaticChild.staticMethod();   // StaticChild's implementation
        
        // Abstract classes and polymorphism
        System.out.println("\n--- Abstract Classes and Polymorphism ---");
        
        // Cannot instantiate abstract class
        // AbstractShape abstractShape = new AbstractShape();  // Compilation error
        
        AbstractCircle abstractCircle = new AbstractCircle(7.0);
        AbstractRectangle abstractRectangle = new AbstractRectangle(3.0, 8.0);
        
        // Reference of abstract class type
        AbstractShape abstractShape1 = abstractCircle;
        AbstractShape abstractShape2 = abstractRectangle;
        
        abstractShape1.draw();  // Calls AbstractCircle's implementation
        abstractShape2.draw();  // Calls AbstractRectangle's implementation
        
        System.out.println("Abstract Circle area: " + abstractShape1.calculateArea());
        System.out.println("Abstract Rectangle area: " + abstractShape2.calculateArea());
    }
    
    /**
     * Method that accepts a Shape parameter (demonstrates polymorphism)
     */
    public static void printShapeInfo(Shape shape) {
        System.out.println("Shape type: " + shape.getClass().getSimpleName());
        shape.draw();
        System.out.println("Area: " + shape.calculateArea());
    }
    
    /**
     * Method that uses instanceof to determine the specific type
     */
    public static void processShape(Shape shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            System.out.println("Processing a Circle with radius: " + circle.getRadius());
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            System.out.println("Processing a Rectangle with width: " + rectangle.getWidth() + 
                              " and height: " + rectangle.getHeight());
        } else if (shape instanceof Triangle) {
            Triangle triangle = (Triangle) shape;
            System.out.println("Processing a Triangle with sides: " + 
                              triangle.getSideA() + ", " + triangle.getSideB() + ", " + triangle.getSideC());
        } else {
            System.out.println("Processing a generic Shape");
        }
    }
}

/**
 * Calculator class to demonstrate method overloading
 */
class Calculator {
    // Method overloading: same method name but different parameter types/counts
    
    // Version with two integers
    public int add(int a, int b) {
        return a + b;
    }
    
    // Version with three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Version with two doubles
    public double add(double a, double b) {
        return a + b;
    }
    
    // Version with a String and an integer
    public String add(String s, int a) {
        return s + a;
    }
}

/**
 * Base Shape class to demonstrate method overriding
 */
class Shape {
    // Method to be overridden by subclasses
    public void draw() {
        System.out.println("Drawing a generic shape");
    }
    
    // Method to calculate area
    public double calculateArea() {
        System.out.println("Cannot calculate area of a generic shape");
        return 0.0;
    }
}

/**
 * Circle subclass
 */
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Method overriding
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    // Getter
    public double getRadius() {
        return radius;
    }
}

/**
 * Rectangle subclass
 */
class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    // Method overriding
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with width " + width + " and height " + height);
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    // Getters
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
}

/**
 * Triangle subclass
 */
class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    // Method overriding
    @Override
    public void draw() {
        System.out.println("Drawing a triangle with sides " + sideA + ", " + sideB + ", " + sideC);
    }
    
    @Override
    public double calculateArea() {
        // Using Heron's formula
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    // Getters
    public double getSideA() {
        return sideA;
    }
    
    public double getSideB() {
        return sideB;
    }
    
    public double getSideC() {
        return sideC;
    }
}

/**
 * Classes to demonstrate virtual method invocation
 */
class BaseClass {
    public void display() {
        System.out.println("Display method in BaseClass");
    }
}

class DerivedClass extends BaseClass {
    @Override
    public void display() {
        System.out.println("Display method in DerivedClass (overridden)");
    }
}

/**
 * Classes to demonstrate polymorphism with constructors
 */
class Parent {
    public Parent() {
        System.out.println("Parent constructor called");
        printInfo();
    }
    
    public void printInfo() {
        System.out.println("printInfo in Parent");
    }
}

class Child extends Parent {
    private int childField = 10;
    
    public Child() {
        System.out.println("Child constructor called");
        printInfo();
    }
    
    @Override
    public void printInfo() {
        System.out.println("printInfo in Child, childField = " + childField);
    }
}

/**
 * Classes to demonstrate static method behavior with inheritance
 */
class StaticParent {
    public static void staticMethod() {
        System.out.println("Static method in StaticParent");
    }
}

class StaticChild extends StaticParent {
    // Static methods cannot be overridden, only hidden
    public static void staticMethod() {
        System.out.println("Static method in StaticChild");
    }
}

/**
 * Abstract class example
 */
abstract class AbstractShape {
    // Abstract method (no implementation)
    public abstract void draw();
    
    // Abstract method
    public abstract double calculateArea();
    
    // Concrete method
    public void displayInfo() {
        System.out.println("This is a shape");
    }
}

/**
 * Concrete implementation of AbstractShape
 */
class AbstractCircle extends AbstractShape {
    private double radius;
    
    public AbstractCircle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing an abstract circle with radius " + radius);
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

/**
 * Another concrete implementation of AbstractShape
 */
class AbstractRectangle extends AbstractShape {
    private double width;
    private double height;
    
    public AbstractRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing an abstract rectangle with width " + width + " and height " + height);
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}