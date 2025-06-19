/**
 * This class demonstrates inheritance in Java
 */
public class InheritanceExample {
    public static void main(String[] args) {
        System.out.println("=== Inheritance in Java ===\n");
        
        // Creating an instance of the superclass
        Animal animal = new Animal("Generic Animal", 5);
        animal.eat();
        animal.sleep();
        
        System.out.println("\n--- Dog (Subclass of Animal) ---");
        
        // Creating an instance of a subclass
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        dog.eat();        // Inherited from Animal
        dog.sleep();      // Inherited from Animal
        dog.bark();       // Defined in Dog
        dog.fetch();      // Defined in Dog
        System.out.println("Breed: " + dog.getBreed());
        
        System.out.println("\n--- Cat (Subclass of Animal) ---");
        
        // Another subclass of Animal
        Cat cat = new Cat("Whiskers", 2, 9);
        cat.eat();        // Inherited from Animal
        cat.sleep();      // Overridden in Cat
        cat.meow();       // Defined in Cat
        cat.purr();       // Defined in Cat
        System.out.println("Lives left: " + cat.getLivesLeft());
        
        System.out.println("\n--- Method Overriding ---");
        
        animal.makeSound();  // Animal implementation
        dog.makeSound();     // Dog implementation (overridden)
        cat.makeSound();     // Cat implementation (overridden)
        
        System.out.println("\n--- Polymorphism with Inheritance ---");
        
        // Polymorphism: treating subclass objects as superclass type
        Animal dogAsAnimal = new Dog("Rex", 4, "German Shepherd");
        Animal catAsAnimal = new Cat("Felix", 3, 7);
        
        System.out.println("Using superclass reference to call makeSound():");
        dogAsAnimal.makeSound();  // Calls Dog's implementation
        catAsAnimal.makeSound();  // Calls Cat's implementation
        
        // Cannot access subclass-specific methods directly through superclass reference
        // dogAsAnimal.bark();  // Error: bark() is not defined in Animal
        
        // Type casting to access subclass-specific methods
        System.out.println("\nDowncasting to access subclass methods:");
        if (dogAsAnimal instanceof Dog) {
            Dog castedDog = (Dog) dogAsAnimal;
            castedDog.bark();
            System.out.println("Breed: " + castedDog.getBreed());
        }
        
        if (catAsAnimal instanceof Cat) {
            ((Cat) catAsAnimal).meow();  // Inline casting
            System.out.println("Lives left: " + ((Cat) catAsAnimal).getLivesLeft());
        }
        
        System.out.println("\n--- Multilevel Inheritance ---");
        
        // Multilevel inheritance
        Puppy puppy = new Puppy("Max", 1, "Labrador", "Playful");
        puppy.eat();        // From Animal (grand-superclass)
        puppy.bark();       // From Dog (superclass)
        puppy.play();       // From Puppy
        System.out.println("Temperament: " + puppy.getTemperament());
        
        System.out.println("\n--- Using super Keyword ---");
        
        // Creating a Wolf object that uses super to call methods
        Wolf wolf = new Wolf("Alpha", 6, "Gray");
        wolf.eat();         // Calls overridden method that uses super
        wolf.makeSound();   // Calls overridden method
        
        System.out.println("\n--- The Object Class ---");
        
        // Every class inherits from Object
        Object animalObj = animal;
        Object dogObj = dog;
        Object catObj = cat;
        
        // Using toString method (inherited from Object and overridden)
        System.out.println("animal.toString(): " + animalObj.toString());
        System.out.println("dog.toString(): " + dogObj.toString());
        System.out.println("cat.toString(): " + catObj.toString());
        
        System.out.println("\n--- final Class, Method, and Variable ---");
        
        // Bird is a final class (cannot be extended)
        Bird bird = new Bird("Tweety", 1);
        bird.eat();
        bird.fly();  // final method
        
        System.out.println("\n--- Using protected Members ---");
        
        // Protected members are accessible in subclasses
        System.out.println("Dog accessing protected name: " + dog.getNameFromSuperclass());
        System.out.println("Cat accessing protected name: " + cat.getNameFromSuperclass());
    }
}

/**
 * Superclass (parent class)
 */
class Animal {
    // Protected member (accessible in subclasses)
    protected String name;
    
    // Private member (not inherited by subclasses)
    private int age;
    
    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal constructor called for " + name);
    }
    
    // Methods
    public void eat() {
        System.out.println(name + " is eating.");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
    
    public void makeSound() {
        System.out.println(name + " makes a generic sound.");
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // toString method override
    @Override
    public String toString() {
        return "Animal{name='" + name + "', age=" + age + "}";
    }
}

/**
 * Subclass of Animal
 */
class Dog extends Animal {
    // Subclass field
    private String breed;
    
    // Constructor
    public Dog(String name, int age, String breed) {
        // Call superclass constructor
        super(name, age);
        this.breed = breed;
        System.out.println("Dog constructor called for " + name);
    }
    
    // Subclass methods
    public void bark() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    public void fetch() {
        System.out.println(name + " fetches the ball.");
    }
    
    // Method overriding
    @Override
    public void makeSound() {
        System.out.println(name + " barks loudly.");
    }
    
    // Getters and setters
    public String getBreed() {
        return breed;
    }
    
    // Demonstrate accessing protected member from superclass
    public String getNameFromSuperclass() {
        return "Dog's access to protected name: " + name;
    }
    
    // toString method override
    @Override
    public String toString() {
        return "Dog{name='" + name + "', age=" + getAge() + ", breed='" + breed + "'}";
    }
}

/**
 * Another subclass of Animal
 */
class Cat extends Animal {
    // Subclass field
    private int livesLeft;
    
    // Constructor
    public Cat(String name, int age, int livesLeft) {
        super(name, age);
        this.livesLeft = livesLeft;
        System.out.println("Cat constructor called for " + name);
    }
    
    // Subclass methods
    public void meow() {
        System.out.println(name + " meows: Meow!");
    }
    
    public void purr() {
        System.out.println(name + " purrs contentedly.");
    }
    
    // Method overriding
    @Override
    public void sleep() {
        System.out.println(name + " is sleeping curled up in a ball.");
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows softly.");
    }
    
    // Getters and setters
    public int getLivesLeft() {
        return livesLeft;
    }
    
    // Demonstrate accessing protected member from superclass
    public String getNameFromSuperclass() {
        return "Cat's access to protected name: " + name;
    }
    
    // toString method override
    @Override
    public String toString() {
        return "Cat{name='" + name + "', age=" + getAge() + ", livesLeft=" + livesLeft + "}";
    }
}

/**
 * Multilevel inheritance: Puppy extends Dog which extends Animal
 */
class Puppy extends Dog {
    private String temperament;
    
    public Puppy(String name, int age, String breed, String temperament) {
        super(name, age, breed);
        this.temperament = temperament;
        System.out.println("Puppy constructor called for " + name);
    }
    
    public void play() {
        System.out.println(name + " plays around excitedly.");
    }
    
    @Override
    public void bark() {
        System.out.println(name + " barks: Yip! Yip!");
    }
    
    public String getTemperament() {
        return temperament;
    }
}

/**
 * Using super to call superclass methods
 */
class Wolf extends Animal {
    private String furColor;
    
    public Wolf(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
    }
    
    @Override
    public void eat() {
        // Call the superclass's eat() method
        super.eat();
        System.out.println(name + " tears meat with sharp teeth.");
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " howls at the moon: Awoooo!");
    }
    
    public String getFurColor() {
        return furColor;
    }
}

/**
 * Final class - cannot be extended
 */
final class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }
    
    // Final method - cannot be overridden in subclasses
    public final void fly() {
        System.out.println(name + " is flying in the sky.");
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
}