# Advanced Java Concepts

This section covers advanced features and concepts in Java programming that help develop more efficient, robust, and maintainable applications.

## 1. Multithreading

Multithreading allows concurrent execution of two or more parts of a program for maximum utilization of CPU resources.

### Creating and Starting Threads

There are two ways to create a thread:

1. **Extending the Thread class**

```java
class MyThread extends Thread {
    @Override
    public void run() {
        // Code to be executed in this thread
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
}

// Usage
MyThread thread = new MyThread();
thread.start();  // Starts the thread
```

2. **Implementing the Runnable interface**

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Code to be executed in this thread
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
}

// Usage
Thread thread = new Thread(new MyRunnable());
thread.start();  // Starts the thread

// Or using lambda expression (Java 8+)
Thread lambdaThread = new Thread(() -> {
    System.out.println("Lambda thread is running: " + Thread.currentThread().getName());
});
lambdaThread.start();
```

### Thread States

A thread can be in one of the following states:

- **NEW**: Thread has been created but not started
- **RUNNABLE**: Thread is executing or ready to execute
- **BLOCKED**: Thread is blocked waiting for a monitor lock
- **WAITING**: Thread is waiting indefinitely for another thread
- **TIMED_WAITING**: Thread is waiting for a specified amount of time
- **TERMINATED**: Thread has completed execution

### Thread Methods

- `start()`: Starts the thread
- `run()`: Contains the code to be executed in the thread
- `sleep(long millis)`: Pauses the thread for a specified time
- `join()`: Waits for this thread to die
- `interrupt()`: Interrupts this thread
- `isAlive()`: Tests if this thread is alive
- `yield()`: Temporarily pauses to allow other threads to execute
- `setPriority(int priority)`: Sets this thread's priority
- `setName(String name)`: Sets this thread's name

### Thread Synchronization

Synchronization is used to prevent thread interference and memory consistency errors.

#### Synchronized Methods

```java
public synchronized void synchronizedMethod() {
    // Only one thread can execute this method at a time
    // for the same object instance
}
```

#### Synchronized Blocks

```java
public void method() {
    // Non-synchronized code
    
    synchronized(this) {
        // Synchronized code block
    }
    
    // More non-synchronized code
}
```

#### Object Level Lock vs Class Level Lock

```java
// Object level lock - locks on the instance
synchronized(this) {
    // Critical section
}

// Class level lock - locks on the class
synchronized(MyClass.class) {
    // Critical section
}
```

### Inter-thread Communication

Threads can communicate with each other using `wait()`, `notify()`, and `notifyAll()` methods.

```java
class SharedResource {
    private boolean condition = false;
    
    public synchronized void produce() throws InterruptedException {
        while (condition) {
            wait();  // Wait until consumer consumes
        }
        
        // Produce a resource
        condition = true;
        System.out.println("Produced");
        
        notify();  // Notify consumer
    }
    
    public synchronized void consume() throws InterruptedException {
        while (!condition) {
            wait();  // Wait until producer produces
        }
        
        // Consume the resource
        condition = false;
        System.out.println("Consumed");
        
        notify();  // Notify producer
    }
}
```

### Deadlocks

A deadlock occurs when two or more threads are blocked forever, waiting for each other.

```java
// Potential deadlock scenario
public void method1() {
    synchronized(lockA) {
        // Do something
        synchronized(lockB) {
            // Do something else
        }
    }
}

public void method2() {
    synchronized(lockB) {
        // Do something
        synchronized(lockA) {
            // Do something else
        }
    }
}
```

### Thread Pools

Thread pools manage a pool of worker threads to execute tasks.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Create a fixed size thread pool
ExecutorService executor = Executors.newFixedThreadPool(5);

// Submit tasks to the executor
for (int i = 0; i < 10; i++) {
    executor.submit(() -> {
        System.out.println("Task executed by " + Thread.currentThread().getName());
    });
}

// Shutdown the executor
executor.shutdown();
```

### Concurrent Collections

Java provides thread-safe collection classes:

- `ConcurrentHashMap`: A thread-safe version of HashMap
- `CopyOnWriteArrayList`: A thread-safe variant of ArrayList
- `CopyOnWriteArraySet`: A thread-safe variant of Set
- `BlockingQueue`: Interface that blocks when trying to dequeue from an empty queue

### Atomic Variables

Atomic variables provide atomic operations without using locks:

```java
import java.util.concurrent.atomic.AtomicInteger;

AtomicInteger counter = new AtomicInteger(0);
counter.incrementAndGet();  // Atomic increment
counter.compareAndSet(1, 2);  // Atomic compare and set
```

### Java Memory Model and Volatile

The `volatile` keyword ensures that a variable is read from and written to main memory, not from thread cache.

```java
private volatile boolean flag = false;

// Thread 1
public void method1() {
    flag = true;
}

// Thread 2
public void method2() {
    while (!flag) {
        // Do something
    }
}
```

### CompletableFuture (Java 8+)

`CompletableFuture` provides an extensive API for asynchronous programming.

```java
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
    // Long running task
    return "Result";
});

future.thenAccept(result -> System.out.println("Got result: " + result));
```

## 2. Lambda Expressions (Java 8+)

Lambda expressions provide a concise way to express instances of single-method interfaces (functional interfaces).

### Basic Syntax

```java
// Basic lambda expression
(parameters) -> expression

// Lambda with block of code
(parameters) -> {
    // Code block
    return result;
}
```

### Examples

```java
// Lambda with no parameters
Runnable runnable = () -> System.out.println("Hello, World!");

// Lambda with one parameter (parentheses optional for single parameter)
Consumer<String> consumer = s -> System.out.println(s);

// Lambda with multiple parameters
Comparator<Integer> comparator = (a, b) -> a.compareTo(b);

// Lambda with block of code
Function<Integer, Integer> square = n -> {
    int result = n * n;
    return result;
};
```

### Functional Interfaces

A functional interface has exactly one abstract method.

Java 8 provides many built-in functional interfaces:

- `Function<T, R>`: Takes a parameter of type T and returns a value of type R
- `Consumer<T>`: Takes a parameter of type T and returns nothing
- `Supplier<T>`: Takes no parameters but returns a value of type T
- `Predicate<T>`: Takes a parameter of type T and returns a boolean
- `BiFunction<T, U, R>`: Takes parameters of type T and U and returns a value of type R
- `BiConsumer<T, U>`: Takes parameters of type T and U and returns nothing
- `BiPredicate<T, U>`: Takes parameters of type T and U and returns a boolean

### Method References

Method references provide a shorthand notation for lambda expressions that call a specific method.

```java
// Static method reference
Function<String, Integer> parseInt = Integer::parseInt;

// Instance method reference
String str = "hello";
Supplier<Integer> length = str::length;

// Constructor reference
Supplier<List<String>> listSupplier = ArrayList::new;
```

## 3. Stream API (Java 8+)

The Stream API provides a functional approach to processing collections of objects.

### Creating Streams

```java
// From a collection
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();

// From an array
String[] array = {"a", "b", "c"};
Stream<String> stream2 = Arrays.stream(array);

// Using Stream.of
Stream<String> stream3 = Stream.of("a", "b", "c");

// Generate infinite stream
Stream<Double> randomStream = Stream.generate(Math::random);

// Iterate to create infinite stream
Stream<Integer> iterateStream = Stream.iterate(0, n -> n + 2);
```

### Intermediate Operations

These operations transform a stream into another stream:

```java
// Filter elements
stream.filter(s -> s.startsWith("a"));

// Map elements to different values
stream.map(String::toUpperCase);

// FlatMap for flattening nested collections
stream.flatMap(s -> Arrays.stream(s.split("")));

// Limit the number of elements
stream.limit(10);

// Skip elements
stream.skip(5);

// Sort elements
stream.sorted();
stream.sorted(Comparator.reverseOrder());

// Remove duplicates
stream.distinct();

// Peek at elements (for debugging)
stream.peek(System.out::println);
```

### Terminal Operations

These operations produce a result or a side-effect:

```java
// Convert to collection
List<String> list = stream.collect(Collectors.toList());
Set<String> set = stream.collect(Collectors.toSet());
Map<String, Integer> map = stream.collect(Collectors.toMap(s -> s, String::length));

// Count elements
long count = stream.count();

// Find elements
Optional<String> any = stream.findAny();
Optional<String> first = stream.findFirst();

// Check if elements match a predicate
boolean allMatch = stream.allMatch(s -> s.length() > 0);
boolean anyMatch = stream.anyMatch(s -> s.startsWith("a"));
boolean noneMatch = stream.noneMatch(s -> s.isEmpty());

// Reduce to a single value
Optional<String> reduced = stream.reduce((s1, s2) -> s1 + s2);
String concatenated = stream.reduce("", (s1, s2) -> s1 + s2);

// ForEach for side effects
stream.forEach(System.out::println);

// Min/Max by comparator
Optional<String> min = stream.min(Comparator.naturalOrder());
Optional<String> max = stream.max(Comparator.naturalOrder());

// ToArray
String[] array = stream.toArray(String[]::new);
```

### Stream Pipeline Example

```java
List<String> filtered = persons.stream()
    .filter(p -> p.getAge() > 20)              // Intermediate operation
    .map(Person::getName)                      // Intermediate operation
    .filter(name -> name.startsWith("A"))      // Intermediate operation
    .collect(Collectors.toList());             // Terminal operation
```

### Parallel Streams

Parallel streams can perform operations in parallel using multiple threads.

```java
// Convert sequential stream to parallel
Stream<String> parallelStream = list.parallelStream();
Stream<String> parallelStream2 = stream.parallel();

// Example of parallel processing
long count = list.parallelStream()
    .filter(s -> s.startsWith("a"))
    .count();
```

## 4. Optional Class (Java 8+)

`Optional` is a container object that may or may not contain a value, helping to prevent `NullPointerException`.

### Creating Optional Objects

```java
// Empty Optional
Optional<String> empty = Optional.empty();

// Optional with a non-null value
Optional<String> opt = Optional.of("value");

// Optional that may contain a null value
Optional<String> nullable = Optional.ofNullable(possiblyNullValue);
```

### Using Optional

```java
// Check if value is present
if (opt.isPresent()) {
    // Use the value
    String value = opt.get();
}

// Execute if value is present
opt.ifPresent(value -> System.out.println("Value: " + value));

// Get value or default
String value = opt.orElse("default");

// Get value or compute default
String value2 = opt.orElseGet(() -> computeDefault());

// Get value or throw exception
String value3 = opt.orElseThrow(() -> new NoSuchElementException());

// Filter values
Optional<String> filtered = opt.filter(value -> value.length() > 5);

// Map values
Optional<Integer> mapped = opt.map(String::length);

// FlatMap for when the mapping function returns an Optional
Optional<String> flatMapped = opt.flatMap(this::findInDatabase);
```

## 5. Date and Time API (Java 8+)

Java 8 introduced a new date and time API in the `java.time` package.

### Key Classes

- `LocalDate`: A date without a time zone
- `LocalTime`: A time without a time zone
- `LocalDateTime`: A date and time without a time zone
- `ZonedDateTime`: A date and time with a time zone
- `Instant`: A point in time
- `Duration`: A time-based amount of time
- `Period`: A date-based amount of time

### Examples

```java
// Current date and time
LocalDate today = LocalDate.now();
LocalTime now = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
ZonedDateTime zonedDateTime = ZonedDateTime.now();
Instant instant = Instant.now();

// Creating from values
LocalDate date = LocalDate.of(2023, Month.JANUARY, 20);
LocalTime time = LocalTime.of(13, 45, 20);
LocalDateTime dateTime2 = LocalDateTime.of(date, time);

// Parsing from string
LocalDate parsedDate = LocalDate.parse("2023-01-20");
LocalTime parsedTime = LocalTime.parse("13:45:20");

// Formatting
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String formattedDate = date.format(formatter);

// Date calculations
LocalDate tomorrow = today.plusDays(1);
LocalDate lastMonth = today.minusMonths(1);
LocalDate firstDayOfMonth = today.withDayOfMonth(1);

// Time calculations
LocalTime twoHoursLater = now.plusHours(2);
LocalTime tenMinutesEarlier = now.minusMinutes(10);

// Period and Duration
Period period = Period.between(date, tomorrow);
Duration duration = Duration.between(time, twoHoursLater);

// Comparing dates and times
boolean isBefore = date.isBefore(tomorrow);
boolean isAfter = time.isAfter(twoHoursLater);
```

## 6. Annotations

Annotations provide metadata about code.

### Built-in Annotations

- `@Override`: Indicates that a method overrides a superclass method
- `@Deprecated`: Indicates that a method is deprecated
- `@SuppressWarnings`: Suppresses compiler warnings
- `@FunctionalInterface`: Indicates that an interface is a functional interface
- `@SafeVarargs`: Suppresses unchecked warnings for varargs parameters

### Custom Annotations

```java
// Define custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    String description() default "";
    boolean enabled() default true;
}

// Use custom annotation
@Test(description = "Test method", enabled = true)
public void testMethod() {
    // Test code
}
```

### Annotation Processing

```java
// Process annotations at runtime using reflection
Method[] methods = MyClass.class.getDeclaredMethods();
for (Method method : methods) {
    if (method.isAnnotationPresent(Test.class)) {
        Test annotation = method.getAnnotation(Test.class);
        if (annotation.enabled()) {
            System.out.println("Running test: " + annotation.description());
            method.invoke(instance);
        }
    }
}
```

## 7. Reflection

Reflection allows you to inspect and manipulate classes, interfaces, fields, methods, and constructors at runtime.

### Class Information

```java
// Get Class object
Class<?> clazz = MyClass.class;
Class<?> clazz2 = object.getClass();
Class<?> clazz3 = Class.forName("com.example.MyClass");

// Get class information
String className = clazz.getName();
Package packageObj = clazz.getPackage();
Class<?> superClass = clazz.getSuperclass();
Class<?>[] interfaces = clazz.getInterfaces();
int modifiers = clazz.getModifiers();
boolean isPublic = Modifier.isPublic(modifiers);
```

### Fields, Methods, and Constructors

```java
// Get fields
Field[] fields = clazz.getDeclaredFields();
Field field = clazz.getDeclaredField("fieldName");

// Access field value
field.setAccessible(true);  // Make private field accessible
Object value = field.get(object);
field.set(object, newValue);

// Get methods
Method[] methods = clazz.getDeclaredMethods();
Method method = clazz.getDeclaredMethod("methodName", paramTypes);

// Invoke method
method.setAccessible(true);  // Make private method accessible
Object result = method.invoke(object, args);

// Get constructors
Constructor<?>[] constructors = clazz.getDeclaredConstructors();
Constructor<?> constructor = clazz.getDeclaredConstructor(paramTypes);

// Create instance
constructor.setAccessible(true);  // Make private constructor accessible
Object newInstance = constructor.newInstance(args);
```

### Dynamic Proxy

```java
// Create dynamic proxy
InvocationHandler handler = new InvocationHandler() {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object result = method.invoke(realObject, args);
        System.out.println("After method: " + method.getName());
        return result;
    }
};

Interface proxy = (Interface) Proxy.newProxyInstance(
    Interface.class.getClassLoader(),
    new Class<?>[] { Interface.class },
    handler
);
```

## 8. Generics

Generics enable classes, interfaces, and methods to operate on objects of various types while providing compile-time type safety.

### Generic Classes

```java
// Define generic class
public class Box<T> {
    private T content;
    
    public Box(T content) {
        this.content = content;
    }
    
    public T getContent() {
        return content;
    }
    
    public void setContent(T content) {
        this.content = content;
    }
}

// Use generic class
Box<String> stringBox = new Box<>("Hello");
Box<Integer> intBox = new Box<>(123);
```

### Generic Methods

```java
// Define generic method
public <T> T findFirst(List<T> list) {
    if (list.isEmpty()) {
        return null;
    }
    return list.get(0);
}

// Use generic method
String first = findFirst(Arrays.asList("a", "b", "c"));
Integer firstInt = findFirst(Arrays.asList(1, 2, 3));
```

### Bounded Type Parameters

```java
// Upper bound (T must be a subtype of Number)
public <T extends Number> double sum(List<T> list) {
    double sum = 0.0;
    for (T element : list) {
        sum += element.doubleValue();
    }
    return sum;
}

// Multiple bounds (T must be a subtype of A and implement B)
public <T extends A & B> void process(T element) {
    // Process element
}
```

### Wildcards

```java
// Unbounded wildcard (any type)
void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}

// Upper bounded wildcard (any subtype of Number)
double sumOfList(List<? extends Number> list) {
    double sum = 0.0;
    for (Number n : list) {
        sum += n.doubleValue();
    }
    return sum;
}

// Lower bounded wildcard (any supertype of Integer)
void addNumbers(List<? super Integer> list) {
    for (int i = 1; i <= 10; i++) {
        list.add(i);
    }
}
```

### Type Erasure

Due to type erasure, generic type information is removed at runtime.

```java
// These are equivalent at runtime
Box<String> stringBox = new Box<>("Hello");
Box<Integer> intBox = new Box<>(123);

// Type checking at compile time
String s = stringBox.getContent();  // OK
Integer i = intBox.getContent();    // OK
```

## 9. Regular Expressions

Regular expressions provide a powerful way to search and manipulate text.

### Basic Pattern Matching

```java
// Check if a string matches a pattern
boolean isMatch = Pattern.matches("a.*b", "axxxb");  // true

// Create a Pattern
Pattern pattern = Pattern.compile("a(.*?)b");

// Create a Matcher
Matcher matcher = pattern.matcher("axxxb");

// Check if the pattern matches the entire input
boolean matches = matcher.matches();  // true

// Find the first occurrence
boolean found = matcher.find();  // true

// Get the matched group
String group = matcher.group(1);  // "xxx"
```

### Common Regular Expression Patterns

- `.` - Any character
- `^` - Start of line
- `$` - End of line
- `*` - Zero or more occurrences
- `+` - One or more occurrences
- `?` - Zero or one occurrence
- `{n}` - Exactly n occurrences
- `{n,}` - At least n occurrences
- `{n,m}` - Between n and m occurrences
- `[abc]` - Any of a, b, or c
- `[^abc]` - Any character except a, b, or c
- `\d` - Digit
- `\D` - Non-digit
- `\s` - Whitespace
- `\S` - Non-whitespace
- `\w` - Word character
- `\W` - Non-word character

### String Methods with Regex

```java
// Split string by regex
String[] parts = "one,two;three".split("[,;]");  // ["one", "two", "three"]

// Replace all occurrences
String replaced = "one,two;three".replaceAll("[,;]", "-");  // "one-two-three"

// Replace first occurrence
String replacedFirst = "one,two;three".replaceFirst("[,;]", "-");  // "one-two;three"

// Check if string matches pattern
boolean matches = "12345".matches("\\d+");  // true
```

### Capturing Groups

```java
Pattern pattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})");
Matcher matcher = pattern.matcher("123-456-7890");

if (matcher.matches()) {
    String areaCode = matcher.group(1);  // "123"
    String prefix = matcher.group(2);    // "456"
    String lineNumber = matcher.group(3);  // "7890"
}
```

### Find and Replace

```java
Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
Matcher matcher = pattern.matcher("Hello World");
StringBuffer result = new StringBuffer();

while (matcher.find()) {
    matcher.appendReplacement(result, matcher.group(1).toUpperCase());
}
matcher.appendTail(result);

System.out.println(result.toString());  // "HELLO WORLD"
```

## 10. IO/NIO (Networking)

Java provides APIs for network programming through `java.net` and `java.nio` packages.

### Socket Programming

#### Server

```java
// Create a server socket
ServerSocket serverSocket = new ServerSocket(8080);
System.out.println("Server started, waiting for clients...");

// Accept client connection
Socket clientSocket = serverSocket.accept();
System.out.println("Client connected: " + clientSocket.getInetAddress());

// Create input/output streams
BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

// Read data from client
String message = in.readLine();
System.out.println("Received from client: " + message);

// Send data to client
out.println("Hello from server!");

// Close resources
in.close();
out.close();
clientSocket.close();
serverSocket.close();
```

#### Client

```java
// Connect to server
Socket socket = new Socket("localhost", 8080);
System.out.println("Connected to server");

// Create input/output streams
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

// Send data to server
out.println("Hello from client!");

// Read data from server
String response = in.readLine();
System.out.println("Received from server: " + response);

// Close resources
in.close();
out.close();
socket.close();
```

### URL Connection

```java
// Create URL
URL url = new URL("https://www.example.com");

// Open connection
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");

// Set connection properties
connection.setConnectTimeout(5000);
connection.setReadTimeout(5000);
connection.setRequestProperty("Content-Type", "application/json");

// Send request
int responseCode = connection.getResponseCode();
System.out.println("Response Code: " + responseCode);

// Read response
try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(connection.getInputStream()))) {
    String line;
    StringBuilder response = new StringBuilder();
    while ((line = reader.readLine()) != null) {
        response.append(line);
    }
    System.out.println("Response: " + response.toString());
}

// Disconnect
connection.disconnect();
```

### NIO Channels and Buffers

```java
// Create a channel
FileChannel channel = FileChannel.open(Paths.get("file.txt"), StandardOpenOption.READ);

// Create a buffer
ByteBuffer buffer = ByteBuffer.allocate(1024);

// Read from channel into buffer
int bytesRead = channel.read(buffer);

// Prepare buffer for reading
buffer.flip();

// Read from buffer
while (buffer.hasRemaining()) {
    byte b = buffer.get();
    // Process byte
}

// Clear buffer for reuse
buffer.clear();

// Close channel
channel.close();
```

### Non-blocking IO with Selector

```java
// Create a selector
Selector selector = Selector.open();

// Create a server socket channel
ServerSocketChannel serverChannel = ServerSocketChannel.open();
serverChannel.configureBlocking(false);
serverChannel.socket().bind(new InetSocketAddress(8080));

// Register channel with selector for accept events
serverChannel.register(selector, SelectionKey.OP_ACCEPT);

while (true) {
    // Wait for events
    selector.select();
    
    // Process selected keys
    Set<SelectionKey> selectedKeys = selector.selectedKeys();
    Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
    
    while (keyIterator.hasNext()) {
        SelectionKey key = keyIterator.next();
        keyIterator.remove();
        
        if (key.isAcceptable()) {
            // Handle accept event
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            // Handle read event
            SocketChannel client = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            client.read(buffer);
            // Process data
        }
    }
}
```

## 11. Advanced Topics

### Virtual Threads (Java 19+ Preview, 21 GA)

Virtual threads are lightweight threads that significantly reduce the overhead of thread creation and management.

```java
// Create and start a virtual thread
Thread vThread = Thread.ofVirtual().start(() -> {
    System.out.println("Running in a virtual thread");
});

// Join the thread
vThread.join();

// Create many virtual threads
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    IntStream.range(0, 10000).forEach(i -> {
        executor.submit(() -> {
            Thread.sleep(Duration.ofMillis(100));
            return i;
        });
    });
}
```

### Records (Java 16+)

Records provide a concise syntax for declaring classes that are transparent holders for shallowly immutable data.

```java
// Define a record
public record Person(String name, int age) {
    // Compact constructor
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
    
    // Additional methods
    public boolean isAdult() {
        return age >= 18;
    }
}

// Use a record
Person person = new Person("John", 30);
String name = person.name();
int age = person.age();
```

### Sealed Classes (Java 17+)

Sealed classes restrict which other classes may extend or implement them.

```java
// Define a sealed class
public sealed class Shape permits Circle, Rectangle, Triangle {
    // Common shape methods
}

// Permitted subclasses
public final class Circle extends Shape {
    private double radius;
    // Circle methods
}

public final class Rectangle extends Shape {
    private double width;
    private double height;
    // Rectangle methods
}

public final class Triangle extends Shape {
    private double a, b, c;
    // Triangle methods
}
```

### Pattern Matching (Java 17+ Preview)

Pattern matching for `instanceof` simplifies type checking and casting.

```java
// Traditional approach
if (obj instanceof String) {
    String s = (String) obj;
    // Use s
}

// Pattern matching for instanceof
if (obj instanceof String s) {
    // Use s directly
}

// Pattern matching in switch (preview feature)
String result = switch (obj) {
    case Integer i -> "Integer: " + i;
    case String s -> "String: " + s;
    case List<?> l -> "List of size: " + l.size();
    case null -> "null";
    default -> "Unknown: " + obj.toString();
};
```

### Text Blocks (Java 15+)

Text blocks provide a way to write multi-line string literals with improved readability.

```java
String html = """
              <html>
                  <body>
                      <h1>Hello, World!</h1>
                  </body>
              </html>
              """;
```

### Reactive Programming (with Project Reactor or RxJava)

Reactive programming is a paradigm for building asynchronous, non-blocking, event-driven applications.

```java
// Example with Project Reactor
Flux<String> flux = Flux.just("A", "B", "C")
    .map(String::toLowerCase)
    .filter(s -> !s.equals("b"))
    .flatMap(s -> Flux.just(s + "1", s + "2"));

flux.subscribe(
    value -> System.out.println("Received: " + value),
    error -> System.err.println("Error: " + error),
    () -> System.out.println("Completed")
);
```

### Module System (Java 9+)

The Java Platform Module System (JPMS) allows you to create modular applications.

```java
// module-info.java
module com.example.myapp {
    requires java.base;
    requires java.logging;
    
    exports com.example.myapp.api;
    provides com.example.myapp.api.Service with com.example.myapp.internal.ServiceImpl;
    uses com.example.service.ExternalService;
}
```