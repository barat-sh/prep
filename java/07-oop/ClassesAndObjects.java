/**
 * This class demonstrates the basics of classes and objects in Java
 */
public class ClassesAndObjects {
    public static void main(String[] args) {
        System.out.println("=== Classes and Objects in Java ===\n");
        
        // Creating objects using constructors
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);
        
        // Accessing object methods
        System.out.println("Person 1:");
        person1.introduce();
        
        System.out.println("\nPerson 2:");
        person2.introduce();
        
        // Accessing object properties using getters
        System.out.println("\nUsing getters:");
        System.out.println("Person 1's name: " + person1.getName());
        System.out.println("Person 2's age: " + person2.getAge());
        
        // Modifying object properties using setters
        System.out.println("\nModifying person1's properties:");
        System.out.println("Before: " + person1.getName() + ", " + person1.getAge());
        
        person1.setName("Alicia");
        person1.setAge(26);
        
        System.out.println("After: " + person1.getName() + ", " + person1.getAge());
        
        // Creating an object with a no-arg constructor
        Rectangle rect1 = new Rectangle();
        System.out.println("\nDefault Rectangle: width=" + rect1.getWidth() + ", height=" + rect1.getHeight());
        
        // Creating objects with different constructors
        Rectangle rect2 = new Rectangle(5.0, 3.0);
        Rectangle rect3 = new Rectangle(4.0); // Square (width = height)
        
        System.out.println("Rectangle 2: width=" + rect2.getWidth() + ", height=" + rect2.getHeight());
        System.out.println("Rectangle 3 (square): width=" + rect3.getWidth() + ", height=" + rect3.getHeight());
        
        // Using instance methods
        System.out.println("\nRectangle areas:");
        System.out.println("Rectangle 1 area: " + rect1.calculateArea());
        System.out.println("Rectangle 2 area: " + rect2.calculateArea());
        System.out.println("Rectangle 3 area: " + rect3.calculateArea());
        
        // Using static methods
        System.out.println("\nUsing static methods:");
        System.out.println("Number of Person objects created: " + Person.getCount());
        
        // Creating another Person object
        Person person3 = new Person("Charlie", 35);
        System.out.println("After creating person3, count: " + Person.getCount());
        
        // Using toString method
        System.out.println("\nUsing toString method:");
        System.out.println("person1: " + person1);
        System.out.println("person2: " + person2);
        System.out.println("person3: " + person3);
        
        // Demonstrating object equality
        System.out.println("\nObject equality:");
        
        Person personA = new Person("David", 40);
        Person personB = new Person("David", 40);
        Person personC = personA;
        
        System.out.println("personA == personB: " + (personA == personB)); // Reference comparison (false)
        System.out.println("personA == personC: " + (personA == personC)); // Reference comparison (true)
        System.out.println("personA.equals(personB): " + personA.equals(personB)); // Content comparison (true if equals is overridden)
        
        // Demonstrating garbage collection
        System.out.println("\nDemonstrating garbage collection:");
        
        // Create objects without any references
        for (int i = 0; i < 1000; i++) {
            new Person("Temporary", i);
        }
        
        System.out.println("Created 1000 temporary Person objects");
        System.out.println("Total Person objects created: " + Person.getCount());
        
        // Request garbage collection (Note: this is just a request, not a guarantee)
        System.gc();
        System.out.println("Requested garbage collection");
        
        // Demonstrating finalize method behavior
        System.out.println("\nNote: finalize is deprecated in newer Java versions");
        System.out.println("Objects may be garbage collected, but finalize may not be called immediately");
    }
}

/**
 * Person class to demonstrate the basics of class creation, fields, and methods
 */
class Person {
    // Static field (shared among all instances)
    private static int count = 0;
    
    // Instance fields (each object has its own copy)
    private String name;
    private int age;
    
    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++; // Increment the counter each time a Person is created
    }
    
    // Instance method
    public void introduce() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
    
    // Static method
    public static int getCount() {
        return count;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative");
        }
    }
    
    // Overriding toString method from Object class
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
    
    // Overriding equals method from Object class
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Person person = (Person) obj;
        return age == person.age && 
               (name == null ? person.name == null : name.equals(person.name));
    }
    
    // Overriding hashCode method from Object class
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
    
    // Finalize method (called by garbage collector)
    // Note: finalize is deprecated in newer Java versions
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Finalizing " + name);
            count--;
        } finally {
            super.finalize();
        }
    }
}

/**
 * Rectangle class to demonstrate constructor overloading and method implementation
 */
class Rectangle {
    private double width;
    private double height;
    
    // No-argument constructor
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }
    
    // Constructor with one parameter (creates a square)
    public Rectangle(double size) {
        this.width = size;
        this.height = size;
    }
    
    // Constructor with two parameters
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    // Getter methods
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    // Setter methods
    public void setWidth(double width) {
        if (width >= 0) {
            this.width = width;
        }
    }
    
    public void setHeight(double height) {
        if (height >= 0) {
            this.height = height;
        }
    }
    
    // Instance method to calculate area
    public double calculateArea() {
        return width * height;
    }
    
    // Instance method to calculate perimeter
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    // Overriding toString method
    @Override
    public String toString() {
        return "Rectangle{width=" + width + ", height=" + height + "}";
    }
}