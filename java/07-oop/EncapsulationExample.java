/**
 * This class demonstrates encapsulation in Java
 */
public class EncapsulationExample {
    public static void main(String[] args) {
        System.out.println("=== Encapsulation in Java ===\n");
        
        // Creating a BankAccount object
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.00);
        
        System.out.println("Initial Account State:");
        System.out.println(account);
        
        // Trying to access private fields directly would cause compilation error
        // System.out.println(account.balance);  // Error: balance has private access
        
        // Using getters to access private fields
        System.out.println("\nUsing getters:");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Balance: $" + account.getBalance());
        
        // Using methods to modify state
        System.out.println("\nPerforming transactions:");
        
        // Deposit some money
        account.deposit(500.00);
        System.out.println("After depositing $500: $" + account.getBalance());
        
        // Withdraw some money
        account.withdraw(200.00);
        System.out.println("After withdrawing $200: $" + account.getBalance());
        
        // Try to withdraw more than the balance
        System.out.println("\nTrying to withdraw more than the balance:");
        boolean success = account.withdraw(2000.00);
        System.out.println("Withdrawal successful? " + success);
        System.out.println("Balance after attempted withdrawal: $" + account.getBalance());
        
        // Using setter to change account holder
        System.out.println("\nChanging account holder:");
        System.out.println("Before: " + account.getAccountHolder());
        account.setAccountHolder("Jane Doe");
        System.out.println("After: " + account.getAccountHolder());
        
        // Trying to set an invalid value
        System.out.println("\nTrying to set negative interest rate:");
        account.setInterestRate(-2.5);
        System.out.println("Interest rate: " + account.getInterestRate() + "%");
        
        // Setting a valid value
        account.setInterestRate(2.5);
        System.out.println("Interest rate after valid update: " + account.getInterestRate() + "%");
        
        // Apply interest
        account.applyInterest();
        System.out.println("Balance after applying interest: $" + account.getBalance());
        
        // Creating a Student object
        System.out.println("\n--- Student Class Example ---");
        
        Student student = new Student("S12345", "Alice Johnson", 20);
        
        System.out.println("Initial Student State:");
        System.out.println(student);
        
        // Add some grades
        student.addGrade("Math", 85);
        student.addGrade("English", 90);
        student.addGrade("Science", 78);
        
        // View student information
        System.out.println("\nStudent Details:");
        System.out.println("ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("GPA: " + student.calculateGPA());
        System.out.println("Grades: " + student.getGrades());
        
        // Try to modify age with invalid value
        System.out.println("\nTrying to set invalid age:");
        student.setAge(-5);
        System.out.println("Age after invalid update: " + student.getAge());
        
        // Immutable objects example
        System.out.println("\n--- Immutable Objects Example ---");
        
        ImmutablePoint point1 = new ImmutablePoint(5, 10);
        System.out.println("Point 1: " + point1);
        
        // Cannot modify an immutable object
        // point1.x = 20;  // Error: x has private access
        
        // Instead, create a new object
        ImmutablePoint point2 = point1.translate(3, 4);
        System.out.println("Point 1 (original): " + point1);
        System.out.println("Point 2 (translated): " + point2);
        
        // Complex object with encapsulation
        System.out.println("\n--- Complex Object Example ---");
        
        Address address = new Address("123 Main St", "Anytown", "State", "12345");
        Employee employee = new Employee("E001", "Bob Smith", address, 50000.00);
        
        System.out.println("Employee: " + employee);
        
        // Modify the address
        Address newAddress = new Address("456 Oak Ave", "Newtown", "State", "67890");
        employee.setAddress(newAddress);
        
        System.out.println("Employee after address change: " + employee);
        
        // Demonstrating defensive copying
        System.out.println("\n--- Defensive Copying Example ---");
        
        // Get the employee's address
        Address employeeAddress = employee.getAddress();
        System.out.println("Original address: " + employeeAddress);
        
        // Try to modify the address obtained from getter
        employeeAddress.setStreet("789 Pine Blvd");
        
        // Check if the change affected the employee's address
        System.out.println("Employee address after external modification: " + employee.getAddress());
        System.out.println("Note: If defensive copying is implemented, the employee's address should not change");
    }
}

/**
 * BankAccount class demonstrating encapsulation
 */
class BankAccount {
    // Private fields (data hiding)
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private double interestRate;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        
        // Validate initial balance
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Warning: Initial balance cannot be negative. Set to 0.");
        }
        
        this.interestRate = 1.0; // Default interest rate of 1%
    }
    
    // Getters (accessor methods)
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    // Setters (mutator methods) with validation
    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        } else {
            System.out.println("Error: Account holder name cannot be empty.");
        }
    }
    
    public void setInterestRate(double interestRate) {
        if (interestRate >= 0) {
            this.interestRate = interestRate;
        } else {
            System.out.println("Error: Interest rate cannot be negative.");
        }
    }
    
    // Business methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        }
        
        if (amount > balance) {
            System.out.println("Error: Insufficient funds.");
            return false;
        }
        
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
        return true;
    }
    
    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest applied: $" + interest);
    }
    
    // Override toString method for better representation
    @Override
    public String toString() {
        return "BankAccount[" +
               "accountNumber='" + accountNumber + "', " +
               "accountHolder='" + accountHolder + "', " +
               "balance=$" + balance + ", " +
               "interestRate=" + interestRate + "%]";
    }
}

/**
 * Student class demonstrating encapsulation
 */
class Student {
    // Private fields
    private String studentId;
    private String name;
    private int age;
    private java.util.Map<String, Integer> grades;
    
    // Constructor
    public Student(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        
        // Validate age
        if (age > 0) {
            this.age = age;
        } else {
            this.age = 18; // Default age
            System.out.println("Warning: Age must be positive. Set to default (18).");
        }
        
        this.grades = new java.util.HashMap<>();
    }
    
    // Getters
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Return a copy of the grades to prevent direct modification
    public java.util.Map<String, Integer> getGrades() {
        return new java.util.HashMap<>(grades);
    }
    
    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Name cannot be empty.");
        }
    }
    
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Error: Age must be positive.");
        }
    }
    
    // Business methods
    public void addGrade(String subject, int score) {
        if (score >= 0 && score <= 100) {
            grades.put(subject, score);
        } else {
            System.out.println("Error: Score must be between 0 and 100.");
        }
    }
    
    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        
        int total = 0;
        for (int score : grades.values()) {
            total += score;
        }
        
        return (double) total / grades.size();
    }
    
    // Override toString method
    @Override
    public String toString() {
        return "Student[" +
               "studentId='" + studentId + "', " +
               "name='" + name + "', " +
               "age=" + age + ", " +
               "grades=" + grades + "]";
    }
}

/**
 * ImmutablePoint class demonstrating immutability as a form of encapsulation
 */
final class ImmutablePoint {
    // Final private fields
    private final int x;
    private final int y;
    
    // Constructor
    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Getters (no setters because the object is immutable)
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    // Instead of modifying this object, create and return a new object
    public ImmutablePoint translate(int dx, int dy) {
        return new ImmutablePoint(x + dx, y + dy);
    }
    
    // Override toString method
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
    
    // Override equals and hashCode for proper value comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        ImmutablePoint other = (ImmutablePoint) obj;
        return x == other.x && y == other.y;
    }
    
    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}

/**
 * Address class to demonstrate encapsulation in nested objects
 */
class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    // Copy constructor for defensive copying
    public Address(Address other) {
        this.street = other.street;
        this.city = other.city;
        this.state = other.state;
        this.zipCode = other.zipCode;
    }
    
    // Getters and setters
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zipCode;
    }
}

/**
 * Employee class demonstrating encapsulation with nested objects
 */
class Employee {
    private String id;
    private String name;
    private Address address;  // Nested object
    private double salary;
    
    public Employee(String id, String name, Address address, double salary) {
        this.id = id;
        this.name = name;
        // Defensive copy to prevent the caller from holding a reference to the internal object
        this.address = new Address(address);
        this.salary = salary;
    }
    
    // Getters
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    // Return a defensive copy to prevent the caller from modifying the internal object
    public Address getAddress() {
        return new Address(address);
    }
    
    public double getSalary() {
        return salary;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(Address address) {
        // Defensive copy
        this.address = new Address(address);
    }
    
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Error: Salary cannot be negative.");
        }
    }
    
    @Override
    public String toString() {
        return "Employee[" +
               "id='" + id + "', " +
               "name='" + name + "', " +
               "address=" + address + ", " +
               "salary=$" + salary + "]";
    }
}