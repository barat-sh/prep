package advanced;

import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.*;
import java.util.regex.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.net.*;
import java.net.http.*;

public class ModernJavaFeaturesExample {

    public static void main(String[] args) throws Exception {
        // Date and Time API (Java 8)
        dateTimeApiExample();
        
        // Annotations and Reflection
        annotationsAndReflectionExample();
        
        // Generics
        genericsExample();
        
        // Regular Expressions
        regexExample();
        
        // HTTP Client (Java 11)
        if (Runtime.version().feature() >= 11) {
            httpClientExample();
        }
        
        // Pattern Matching (Java 16+)
        if (Runtime.version().feature() >= 16) {
            patternMatchingExample();
        }
        
        // Records (Java 16+)
        if (Runtime.version().feature() >= 16) {
            recordsExample();
        }
        
        // Sealed Classes (Java 17+)
        if (Runtime.version().feature() >= 17) {
            sealedClassesExample();
        }
    }
    
    // Date and Time API (Java 8)
    private static void dateTimeApiExample() {
        System.out.println("\n=== Date and Time API ===");
        
        // LocalDate - date without time or timezone
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2023, Month.JANUARY, 1);
        LocalDate parsedDate = LocalDate.parse("2023-01-01");
        
        System.out.println("Today: " + today);
        System.out.println("First day of 2023: " + specificDate);
        System.out.println("Days between: " + ChronoUnit.DAYS.between(specificDate, today));
        
        // LocalTime - time without date or timezone
        LocalTime now = LocalTime.now();
        LocalTime specificTime = LocalTime.of(13, 30, 0);
        
        System.out.println("Current time: " + now);
        System.out.println("Specific time: " + specificTime);
        
        // LocalDateTime - date and time without timezone
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + dateTime);
        
        // Formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm a");
        System.out.println("Formatted: " + dateTime.format(formatter));
        
        // ZonedDateTime - date and time with timezone
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        
        System.out.println("Current time with zone: " + zonedDateTime);
        System.out.println("New York time: " + newYorkTime);
        
        // Period - date-based amount of time
        Period period = Period.between(specificDate, today);
        System.out.println("Period since 2023-01-01: " + 
                           period.getYears() + " years, " + 
                           period.getMonths() + " months, " + 
                           period.getDays() + " days");
        
        // Duration - time-based amount of time
        Duration duration = Duration.between(LocalTime.of(9, 0), LocalTime.of(17, 30));
        System.out.println("Work day duration: " + duration.toHours() + " hours, " + 
                           (duration.toMinutes() % 60) + " minutes");
        
        // Operations on dates
        System.out.println("Tomorrow: " + today.plusDays(1));
        System.out.println("Last month: " + today.minusMonths(1));
        System.out.println("Is leap year? " + today.isLeapYear());
    }
    
    // Annotations and Reflection
    private static void annotationsAndReflectionExample() throws Exception {
        System.out.println("\n=== Annotations and Reflection ===");
        
        // Get class information
        Class<?> clazz = SampleClass.class;
        System.out.println("Class name: " + clazz.getName());
        System.out.println("Is interface? " + clazz.isInterface());
        
        // Get annotations
        System.out.println("Class annotations:");
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println("  " + annotation);
        }
        
        // Get fields
        System.out.println("Fields:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("  " + field.getType().getSimpleName() + " " + field.getName());
            
            // Check field annotations
            for (Annotation annotation : field.getAnnotations()) {
                System.out.println("    @" + annotation.annotationType().getSimpleName());
            }
        }
        
        // Get methods
        System.out.println("Methods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("  " + method.getReturnType().getSimpleName() + " " + method.getName() + "()");
            
            // Check method annotations
            for (Annotation annotation : method.getAnnotations()) {
                System.out.println("    @" + annotation.annotationType().getSimpleName());
            }
        }
        
        // Create instance using reflection
        SampleClass instance = (SampleClass) clazz.getDeclaredConstructor().newInstance();
        
        // Access private field using reflection
        Field privateField = clazz.getDeclaredField("privateValue");
        privateField.setAccessible(true);
        privateField.set(instance, 100);
        
        // Invoke method using reflection
        Method method = clazz.getDeclaredMethod("getPrivateValue");
        method.setAccessible(true);
        int value = (int) method.invoke(instance);
        System.out.println("Invoked method returned: " + value);
    }
    
    // Generics
    private static void genericsExample() {
        System.out.println("\n=== Generics ===");
        
        // Generic class
        Box<String> stringBox = new Box<>("Hello Generics");
        Box<Integer> intBox = new Box<>(123);
        
        System.out.println("String box value: " + stringBox.getValue());
        System.out.println("Integer box value: " + intBox.getValue());
        
        // Generic method
        List<String> strings = Arrays.asList("one", "two", "three");
        List<Integer> integers = Arrays.asList(1, 2, 3);
        
        printList(strings);
        printList(integers);
        
        // Bounded type parameters
        printNumbers(integers);
        // printNumbers(strings); // Won't compile
        
        // Wildcard
        List<? extends Number> numbers = new ArrayList<Integer>();
        // numbers.add(10); // Won't compile - can't add to a list with an unknown type
        
        // Lower bounded wildcard
        List<? super Integer> superIntegers = new ArrayList<Number>();
        superIntegers.add(10); // This works
        
        // Type erasure - both Map<String, Integer> and Map<Integer, String> have same runtime class
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        System.out.println("Type erasure example - both maps have same runtime class: " + 
                          (map1.getClass() == map2.getClass()));
    }
    
    // Regular Expressions
    private static void regexExample() {
        System.out.println("\n=== Regular Expressions ===");
        
        String text = "John Doe's phone numbers are 555-123-4567 and (555) 987-6543.";
        
        // Simple pattern matching
        Pattern pattern = Pattern.compile("\\d{3}[-\\s]?\\d{3}[-\\s]?\\d{4}|\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(text);
        
        System.out.println("Phone numbers found:");
        while (matcher.find()) {
            System.out.println("  " + matcher.group());
        }
        
        // Replacing
        String replaced = text.replaceAll("\\d", "X");
        System.out.println("After replacing digits: " + replaced);
        
        // Splitting
        String csvLine = "John,Doe,42,New York,Engineer";
        String[] parts = csvLine.split(",");
        System.out.println("CSV parts: " + Arrays.toString(parts));
        
        // Pattern flags
        Pattern caseInsensitive = Pattern.compile("john", Pattern.CASE_INSENSITIVE);
        Matcher caseInsensitiveMatcher = caseInsensitive.matcher(text);
        System.out.println("Case insensitive match for 'john': " + caseInsensitiveMatcher.find());
        
        // Capturing groups
        Pattern namePattern = Pattern.compile("(\\w+)\\s(\\w+)");
        Matcher nameMatcher = namePattern.matcher(text);
        if (nameMatcher.find()) {
            System.out.println("First name: " + nameMatcher.group(1));
            System.out.println("Last name: " + nameMatcher.group(2));
        }
    }
    
    // HTTP Client (Java 11)
    private static void httpClientExample() throws Exception {
        System.out.println("\n=== HTTP Client (Java 11+) ===");
        
        // Create HTTP Client
        HttpClient client = HttpClient.newHttpClient();
        
        // Build request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .GET()
                .build();
        
        // Synchronous send
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Response status code: " + response.statusCode());
        System.out.println("Response headers: " + response.headers());
        System.out.println("Response body: " + response.body());
        
        // Asynchronous example
        CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(
                HttpRequest.newBuilder()
                        .uri(URI.create("https://jsonplaceholder.typicode.com/todos/2"))
                        .GET()
                        .build(),
                HttpResponse.BodyHandlers.ofString());
        
        // Process when complete
        futureResponse.thenAccept(resp -> 
            System.out.println("Async response received with status: " + resp.statusCode())
        );
        
        // Wait for async request to complete
        futureResponse.join();
    }
    
    // Pattern Matching (Java 16+)
    private static void patternMatchingExample() {
        System.out.println("\n=== Pattern Matching (Java 16+) ===");
        
        // Pattern matching with instanceof
        Object obj = "Hello, pattern matching!";
        
        // Traditional way
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("Traditional length: " + s.length());
        }
        
        // Pattern matching way
        if (obj instanceof String s) {
            System.out.println("Pattern matching length: " + s.length());
        }
        
        // Pattern matching in switch (Java 17+ preview feature)
        if (Runtime.version().feature() >= 17) {
            printObjectType(obj);
            printObjectType(42);
            printObjectType(3.14);
            printObjectType(List.of("a", "b", "c"));
        }
    }
    
    // Records (Java 16+)
    private static void recordsExample() {
        System.out.println("\n=== Records (Java 16+) ===");
        
        // Create a record instance
        Person person = new Person("John Doe", 30);
        
        // Automatic getters
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
        
        // Automatic toString
        System.out.println("ToString: " + person);
        
        // Automatic equals and hashCode
        Person person2 = new Person("John Doe", 30);
        Person person3 = new Person("Jane Doe", 28);
        
        System.out.println("person equals person2: " + person.equals(person2));
        System.out.println("person equals person3: " + person.equals(person3));
        
        // Record with a custom constructor
        Person person4 = new Person("Bob Smith", -5); // Age will be set to 0
        System.out.println("Person with custom constructor: " + person4);
    }
    
    // Sealed Classes (Java 17+)
    private static void sealedClassesExample() {
        System.out.println("\n=== Sealed Classes (Java 17+) ===");
        
        // Using sealed class hierarchy
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        Shape square = new Square(3.0);
        
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Square area: " + square.area());
        
        // Pattern matching with sealed classes (would be even better with switch pattern matching)
        printShapeDescription(circle);
        printShapeDescription(rectangle);
        printShapeDescription(square);
    }
    
    // Pattern matching in switch (Java 17+ preview, simulated here)
    private static void printObjectType(Object obj) {
        // In Java 17+, this could use the preview switch pattern matching
        if (obj instanceof String s) {
            System.out.println("String of length " + s.length());
        } else if (obj instanceof Integer i) {
            System.out.println("Integer with value " + i);
        } else if (obj instanceof Double d) {
            System.out.println("Double with value " + d);
        } else if (obj instanceof List<?> list) {
            System.out.println("List with " + list.size() + " elements");
        } else {
            System.out.println("Unknown type");
        }
    }
    
    // Pattern matching with sealed classes
    private static void printShapeDescription(Shape shape) {
        if (shape instanceof Circle circle) {
            System.out.println("Circle with radius " + circle.radius());
        } else if (shape instanceof Rectangle rectangle) {
            System.out.println("Rectangle with width " + rectangle.width() + 
                               " and height " + rectangle.height());
        } else if (shape instanceof Square square) {
            System.out.println("Square with side " + square.side());
        }
    }
    
    // Sample class for reflection example
    @Deprecated
    @SuppressWarnings("unused")
    static class SampleClass {
        public String publicValue;
        
        @Deprecated
        private int privateValue;
        
        @Override
        public String toString() {
            return "SampleClass instance";
        }
        
        private int getPrivateValue() {
            return privateValue;
        }
    }
    
    // Generic class example
    static class Box<T> {
        private T value;
        
        public Box(T value) {
            this.value = value;
        }
        
        public T getValue() {
            return value;
        }
        
        public void setValue(T value) {
            this.value = value;
        }
    }
    
    // Generic method example
    private static <T> void printList(List<T> list) {
        System.out.println("List contents: " + list);
    }
    
    // Bounded type parameter example
    private static <T extends Number> void printNumbers(List<T> list) {
        double sum = 0;
        for (T number : list) {
            sum += number.doubleValue();
        }
        System.out.println("Sum of numbers: " + sum);
    }
    
    // Record example (Java 16+)
    static record Person(String name, int age) {
        // Compact constructor for validation
        public Person {
            if (age < 0) {
                age = 0; // Normalize age
            }
        }
    }
    
    // Sealed class example (Java 17+)
    static sealed abstract class Shape permits Circle, Rectangle, Square {
        public abstract double area();
    }
    
    static final class Circle extends Shape {
        private final double radius;
        
        public Circle(double radius) {
            this.radius = radius;
        }
        
        public double radius() {
            return radius;
        }
        
        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }
    
    static non-sealed class Rectangle extends Shape {
        private final double width;
        private final double height;
        
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        
        public double width() {
            return width;
        }
        
        public double height() {
            return height;
        }
        
        @Override
        public double area() {
            return width * height;
        }
    }
    
    static final class Square extends Shape {
        private final double side;
        
        public Square(double side) {
            this.side = side;
        }
        
        public double side() {
            return side;
        }
        
        @Override
        public double area() {
            return side * side;
        }
    }
}