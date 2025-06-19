/**
 * This class demonstrates abstraction and interfaces in Java
 */
public class AbstractionAndInterfaces {
    public static void main(String[] args) {
        System.out.println("=== Abstraction and Interfaces in Java ===\n");
        
        // Abstract Classes
        System.out.println("--- Abstract Classes ---");
        
        // Cannot instantiate abstract class
        // Vehicle vehicle = new Vehicle();  // Compilation error
        
        // Create instances of concrete subclasses
        Car car = new Car("Toyota", "Camry", 4);
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR500R", false);
        
        // Call abstract and non-abstract methods
        System.out.println("Car Details:");
        car.start();  // Implementation of abstract method
        car.stop();   // Implementation of abstract method
        car.displayInfo();  // Inherited non-abstract method
        System.out.println("Number of doors: " + car.getNumberOfDoors());
        
        System.out.println("\nMotorcycle Details:");
        motorcycle.start();  // Implementation of abstract method
        motorcycle.stop();   // Implementation of abstract method
        motorcycle.displayInfo();  // Inherited non-abstract method
        System.out.println("Has sidecar: " + motorcycle.hasSidecar());
        
        // Using abstract class as a reference type
        System.out.println("\nUsing abstract class as reference type:");
        Vehicle vehicle1 = car;
        Vehicle vehicle2 = motorcycle;
        
        vehicle1.start();  // Calls Car's implementation
        vehicle2.start();  // Calls Motorcycle's implementation
        
        // Interfaces
        System.out.println("\n--- Interfaces ---");
        
        // Create objects implementing interfaces
        ElectricCar electricCar = new ElectricCar("Tesla", "Model 3", 4, 75.0);
        Boat boat = new Boat("Yamaha", 150.0);
        Drone drone = new Drone("DJI", "Mavic", 20.0);
        
        // Call interface methods
        System.out.println("\nElectric Car:");
        electricCar.start();
        electricCar.stop();
        electricCar.charge();  // From Chargeable interface
        
        System.out.println("\nBoat:");
        boat.sail();  // From Sailable interface
        
        System.out.println("\nDrone:");
        drone.fly();   // From Flyable interface
        drone.land();  // From Flyable interface
        
        // Implementing multiple interfaces
        System.out.println("\n--- Implementing Multiple Interfaces ---");
        
        AmphibiousVehicle amphibiousVehicle = new AmphibiousVehicle("WaterCar", "Panther");
        
        System.out.println("\nAmphibious Vehicle:");
        amphibiousVehicle.start();  // From Vehicle (abstract class)
        amphibiousVehicle.drive();  // From Drivable interface
        amphibiousVehicle.sail();   // From Sailable interface
        amphibiousVehicle.stop();   // From Vehicle (abstract class)
        
        // Interface as reference type
        System.out.println("\n--- Interface as Reference Type ---");
        
        Drivable drivable1 = car;
        Drivable drivable2 = electricCar;
        Drivable drivable3 = amphibiousVehicle;
        
        drivable1.drive();  // Car's implementation
        drivable2.drive();  // ElectricCar's implementation
        drivable3.drive();  // AmphibiousVehicle's implementation
        
        // Default methods in interfaces (Java 8+)
        System.out.println("\n--- Default Methods in Interfaces ---");
        
        System.out.println("\nCalling default method on ElectricCar:");
        electricCar.turnOnHeadlights();  // Default method from Drivable
        
        System.out.println("\nOverridden default method on AmphibiousVehicle:");
        amphibiousVehicle.turnOnHeadlights();  // Overridden default method
        
        // Static methods in interfaces (Java 8+)
        System.out.println("\n--- Static Methods in Interfaces ---");
        
        double kphSpeed = 100.0;
        double mphSpeed = Drivable.convertKphToMph(kphSpeed);
        System.out.println(kphSpeed + " km/h = " + mphSpeed + " mph");
        
        // Constant fields in interfaces
        System.out.println("\n--- Constant Fields in Interfaces ---");
        
        System.out.println("Maximum speed limit (from Drivable): " + Drivable.MAX_SPEED_LIMIT_KPH + " km/h");
        System.out.println("Maximum altitude (from Flyable): " + Flyable.MAX_ALTITUDE_METERS + " meters");
        
        // Functional interface with lambda (Java 8+)
        System.out.println("\n--- Functional Interfaces with Lambda ---");
        
        // Lambda expression implementing the functional interface
        Startable carStarter = () -> System.out.println("Starting with key fob remote");
        
        // Using the lambda
        System.out.println("Using lambda to start a vehicle:");
        carStarter.start();
        
        // Pass the lambda to a method
        testStartable(carStarter);
        
        // Anonymous inner class vs lambda
        System.out.println("\nAnonymous inner class:");
        Startable anonymousStarter = new Startable() {
            @Override
            public void start() {
                System.out.println("Starting with an anonymous inner class");
            }
        };
        anonymousStarter.start();
        
        System.out.println("\nLambda expression:");
        Startable lambdaStarter = () -> System.out.println("Starting with a lambda expression");
        lambdaStarter.start();
        
        // Private methods in interfaces (Java 9+)
        System.out.println("\n--- Private Methods in Interfaces (Java 9+) ---");
        System.out.println("Note: Modern interfaces can have private methods for code reuse");
        System.out.println("This feature is available in Java 9 and later");
        
        // Interface inheritance
        System.out.println("\n--- Interface Inheritance ---");
        
        FlyingCar flyingCar = new FlyingCar("Terrafugia", "Transition");
        
        System.out.println("\nFlying Car:");
        flyingCar.drive();  // From Drivable
        flyingCar.fly();    // From Flyable
        flyingCar.land();   // From Flyable
    }
    
    /**
     * Method that accepts a Startable parameter
     */
    public static void testStartable(Startable startable) {
        System.out.println("\nTesting a Startable object:");
        startable.start();
    }
}

/**
 * Abstract class representing a vehicle
 */
abstract class Vehicle {
    protected String make;
    protected String model;
    
    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }
    
    // Abstract methods (must be implemented by subclasses)
    public abstract void start();
    public abstract void stop();
    
    // Non-abstract method (inherited by subclasses)
    public void displayInfo() {
        System.out.println("Vehicle: " + make + " " + model);
    }
    
    // Getters
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
}

/**
 * Concrete class extending the abstract Vehicle class
 */
class Car extends Vehicle implements Drivable {
    private int numberOfDoors;
    
    public Car(String make, String model, int numberOfDoors) {
        super(make, model);
        this.numberOfDoors = numberOfDoors;
    }
    
    // Implementation of abstract methods
    @Override
    public void start() {
        System.out.println("Car starting: Turn key in ignition");
    }
    
    @Override
    public void stop() {
        System.out.println("Car stopping: Apply brakes and turn off ignition");
    }
    
    // Implementation of interface method
    @Override
    public void drive() {
        System.out.println("Car driving on the road");
    }
    
    // Additional method specific to Car
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}

/**
 * Another concrete class extending the abstract Vehicle class
 */
class Motorcycle extends Vehicle implements Drivable {
    private boolean hasSidecar;
    
    public Motorcycle(String make, String model, boolean hasSidecar) {
        super(make, model);
        this.hasSidecar = hasSidecar;
    }
    
    // Implementation of abstract methods
    @Override
    public void start() {
        System.out.println("Motorcycle starting: Press starter button");
    }
    
    @Override
    public void stop() {
        System.out.println("Motorcycle stopping: Apply brakes and turn off engine");
    }
    
    // Implementation of interface method
    @Override
    public void drive() {
        System.out.println("Motorcycle riding on the road");
    }
    
    // Additional method specific to Motorcycle
    public boolean hasSidecar() {
        return hasSidecar;
    }
}

/**
 * Functional interface with a single abstract method
 */
@FunctionalInterface
interface Startable {
    // Single abstract method
    void start();
}

/**
 * Interface for objects that can be driven
 */
interface Drivable {
    // Constant field (implicitly public, static, final)
    double MAX_SPEED_LIMIT_KPH = 120.0;
    
    // Abstract method (implicitly public)
    void drive();
    
    // Default method (Java 8+)
    default void turnOnHeadlights() {
        System.out.println("Turning on standard headlights");
    }
    
    // Static method (Java 8+)
    static double convertKphToMph(double kph) {
        return kph * 0.621371;
    }
    
    // Private method for internal use (Java 9+)
    // private void internalHelperMethod() {
    //     System.out.println("This is a helper method for internal use only");
    // }
}

/**
 * Interface for objects that can fly
 */
interface Flyable {
    // Constant
    double MAX_ALTITUDE_METERS = 10000.0;
    
    // Abstract methods
    void fly();
    void land();
}

/**
 * Interface for objects that can sail on water
 */
interface Sailable {
    void sail();
}

/**
 * Interface for objects that can be charged
 */
interface Chargeable {
    void charge();
}

/**
 * Interface that extends other interfaces
 */
interface AirAndGroundVehicle extends Drivable, Flyable {
    void switchMode();
}

/**
 * Class implementing multiple interfaces
 */
class ElectricCar extends Car implements Chargeable {
    private double batteryCapacity; // kWh
    
    public ElectricCar(String make, String model, int numberOfDoors, double batteryCapacity) {
        super(make, model, numberOfDoors);
        this.batteryCapacity = batteryCapacity;
    }
    
    @Override
    public void start() {
        System.out.println("Electric car starting: Press start button");
    }
    
    @Override
    public void drive() {
        System.out.println("Electric car driving silently on the road");
    }
    
    @Override
    public void charge() {
        System.out.println("Electric car charging: Connect to charging station");
    }
    
    public double getBatteryCapacity() {
        return batteryCapacity;
    }
}

/**
 * Class implementing the Sailable interface
 */
class Boat implements Sailable {
    private String manufacturer;
    private double horsePower;
    
    public Boat(String manufacturer, double horsePower) {
        this.manufacturer = manufacturer;
        this.horsePower = horsePower;
    }
    
    @Override
    public void sail() {
        System.out.println("Boat sailing on water");
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public double getHorsePower() {
        return horsePower;
    }
}

/**
 * Class implementing the Flyable interface
 */
class Drone implements Flyable {
    private String manufacturer;
    private String model;
    private double maxFlightTime; // minutes
    
    public Drone(String manufacturer, String model, double maxFlightTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxFlightTime = maxFlightTime;
    }
    
    @Override
    public void fly() {
        System.out.println("Drone flying in the air");
    }
    
    @Override
    public void land() {
        System.out.println("Drone landing on the ground");
    }
    
    public double getMaxFlightTime() {
        return maxFlightTime;
    }
}

/**
 * Class extending an abstract class and implementing multiple interfaces
 */
class AmphibiousVehicle extends Vehicle implements Drivable, Sailable {
    public AmphibiousVehicle(String make, String model) {
        super(make, model);
    }
    
    @Override
    public void start() {
        System.out.println("Amphibious vehicle starting: Starting dual engines");
    }
    
    @Override
    public void stop() {
        System.out.println("Amphibious vehicle stopping: Shutting down all systems");
    }
    
    @Override
    public void drive() {
        System.out.println("Amphibious vehicle driving on land");
    }
    
    @Override
    public void sail() {
        System.out.println("Amphibious vehicle sailing on water");
    }
    
    // Override the default method from Drivable
    @Override
    public void turnOnHeadlights() {
        System.out.println("Turning on amphibious vehicle's special headlights (works on land and water)");
    }
}

/**
 * Class implementing an interface that extends multiple interfaces
 */
class FlyingCar implements AirAndGroundVehicle {
    private String manufacturer;
    private String model;
    private boolean isFlying;
    
    public FlyingCar(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.isFlying = false;
    }
    
    @Override
    public void drive() {
        if (!isFlying) {
            System.out.println("Flying car driving on the road");
        } else {
            System.out.println("Cannot drive while flying");
        }
    }
    
    @Override
    public void fly() {
        if (!isFlying) {
            isFlying = true;
            System.out.println("Flying car taking off and flying");
        } else {
            System.out.println("Already flying");
        }
    }
    
    @Override
    public void land() {
        if (isFlying) {
            isFlying = false;
            System.out.println("Flying car landing");
        } else {
            System.out.println("Already on the ground");
        }
    }
    
    @Override
    public void switchMode() {
        if (isFlying) {
            System.out.println("Switching to driving mode");
            isFlying = false;
        } else {
            System.out.println("Switching to flying mode");
            isFlying = true;
        }
    }
}