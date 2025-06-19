/**
 * This class demonstrates custom exceptions in Java
 */
public class CustomExceptions {
    public static void main(String[] args) {
        System.out.println("=== Custom Exceptions in Java ===\n");
        
        // Creating a bank account
        BankAccount account = new BankAccount("123456", 1000.0);
        System.out.println("Created a bank account with balance: $" + account.getBalance());
        
        // 1. Using a custom checked exception
        System.out.println("\n1. Custom Checked Exception Example:");
        try {
            // Try to withdraw more than the balance
            account.withdraw(1500.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Deficit amount: $" + e.getDeficit());
        }
        
        // 2. Using a custom unchecked exception
        System.out.println("\n2. Custom Unchecked Exception Example:");
        try {
            // Try to set a negative age
            Person person = new Person("John");
            person.setAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // 3. Custom exception with chaining
        System.out.println("\n3. Exception Chaining Example:");
        try {
            // Try to process an invalid transaction
            processTransaction("ABC123", -100.0);
        } catch (TransactionException e) {
            System.out.println("Transaction error: " + e.getMessage());
            
            // Get and print the cause of this exception
            Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println("Caused by: " + cause.getClass().getSimpleName() + ": " + cause.getMessage());
            }
        }
        
        // 4. Custom exception with additional data
        System.out.println("\n4. Custom Exception with Additional Data:");
        try {
            // Try to validate a user with invalid credentials
            validateUser("user123", "");
        } catch (AuthenticationException e) {
            System.out.println("Authentication error: " + e.getMessage());
            System.out.println("User ID: " + e.getUserId());
            System.out.println("Error code: " + e.getErrorCode());
            System.out.println("Timestamp: " + e.getTimestamp());
        }
        
        // 5. Handling multiple custom exceptions
        System.out.println("\n5. Handling Multiple Custom Exceptions:");
        try {
            // Create a file with invalid path
            FileManager fileManager = new FileManager();
            fileManager.createFile("/invalid/path", "test.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path error: " + e.getMessage());
        } catch (FileAlreadyExistsException e) {
            System.out.println("File error: " + e.getMessage());
            System.out.println("Existing file path: " + e.getFilePath());
        } catch (FileOperationException e) {
            System.out.println("General file operation error: " + e.getMessage());
        }
        
        // 6. Rethrowing exceptions with custom wrappers
        System.out.println("\n6. Rethrowing Exceptions with Custom Wrappers:");
        try {
            processWithRethrowing("invalid data");
        } catch (ProcessingException e) {
            System.out.println("Processing error: " + e.getMessage());
            System.out.println("Original cause: " + e.getCause().getMessage());
        }
        
        System.out.println("\nEnd of custom exceptions demonstration.");
    }
    
    /**
     * Method that uses custom exception for transaction processing
     */
    public static void processTransaction(String transactionId, double amount) throws TransactionException {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Transaction amount must be positive");
            }
            
            // Process the transaction...
            System.out.println("Processing transaction: " + transactionId + " for $" + amount);
            
        } catch (IllegalArgumentException e) {
            // Wrap the original exception in a custom exception
            throw new TransactionException("Invalid transaction amount", e);
        }
    }
    
    /**
     * Method that throws a custom exception with additional data
     */
    public static void validateUser(String userId, String password) throws AuthenticationException {
        if (userId == null || userId.isEmpty()) {
            throw new AuthenticationException("User ID cannot be empty", userId, 1001);
        }
        
        if (password == null || password.isEmpty()) {
            throw new AuthenticationException("Password cannot be empty", userId, 1002);
        }
        
        // Authenticate user...
        System.out.println("User validated successfully: " + userId);
    }
    
    /**
     * Method that demonstrates rethrowing with custom wrappers
     */
    public static void processWithRethrowing(String data) throws ProcessingException {
        try {
            // Attempt to process the data
            if (data.equals("invalid data")) {
                throw new IllegalArgumentException("Invalid data format");
            }
            
            System.out.println("Data processed successfully");
            
        } catch (Exception e) {
            // Rethrow as a custom exception
            throw new ProcessingException("Error processing data", e);
        }
    }
}

/**
 * Custom checked exception for insufficient funds in a bank account
 */
class InsufficientFundsException extends Exception {
    private double deficit;
    
    public InsufficientFundsException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }
    
    public double getDeficit() {
        return deficit;
    }
}

/**
 * Bank account class that uses the custom exception
 */
class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    /**
     * Withdraw money from the account
     * 
     * @throws InsufficientFundsException if there is not enough money in the account
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double deficit = amount - balance;
            throw new InsufficientFundsException(
                "Not enough money in account to withdraw $" + amount, deficit);
        }
        
        balance -= amount;
        System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
    }
}

/**
 * Custom unchecked exception for invalid age
 */
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

/**
 * Person class that uses the custom unchecked exception
 */
class Person {
    private String name;
    private int age;
    
    public Person(String name) {
        this.name = name;
        this.age = 0; // Default age
    }
    
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Invalid age value: " + age);
        }
        
        this.age = age;
        System.out.println("Age set to " + age);
    }
}

/**
 * Custom exception that supports exception chaining
 */
class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
    
    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}

/**
 * Custom exception with additional data fields
 */
class AuthenticationException extends Exception {
    private String userId;
    private int errorCode;
    private long timestamp;
    
    public AuthenticationException(String message, String userId, int errorCode) {
        super(message);
        this.userId = userId;
        this.errorCode = errorCode;
        this.timestamp = System.currentTimeMillis();
    }
    
    public String getUserId() {
        return userId;
    }
    
    public int getErrorCode() {
        return errorCode;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
}

/**
 * Custom exceptions for file operations
 */
class FileOperationException extends Exception {
    public FileOperationException(String message) {
        super(message);
    }
    
    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}

class InvalidPathException extends FileOperationException {
    public InvalidPathException(String message) {
        super(message);
    }
}

class FileAlreadyExistsException extends FileOperationException {
    private String filePath;
    
    public FileAlreadyExistsException(String message, String filePath) {
        super(message);
        this.filePath = filePath;
    }
    
    public String getFilePath() {
        return filePath;
    }
}

/**
 * File manager class that uses custom exceptions
 */
class FileManager {
    public void createFile(String directory, String fileName) throws FileOperationException {
        // Validate directory path
        if (directory == null || directory.isEmpty()) {
            throw new InvalidPathException("Directory path cannot be empty");
        }
        
        // Check if the path starts with '/'
        if (!directory.startsWith("/")) {
            throw new InvalidPathException("Directory path must be absolute (start with '/')");
        }
        
        // Check if file already exists (simulation)
        if (directory.equals("/existing") && fileName.equals("test.txt")) {
            throw new FileAlreadyExistsException(
                "File already exists: " + fileName, directory + "/" + fileName);
        }
        
        // Simulate other errors
        if (directory.equals("/invalid/path")) {
            throw new FileOperationException("Cannot create file in non-existent directory");
        }
        
        // File created successfully
        System.out.println("File created: " + directory + "/" + fileName);
    }
}

/**
 * Custom exception for general processing errors
 */
class ProcessingException extends Exception {
    public ProcessingException(String message) {
        super(message);
    }
    
    public ProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}