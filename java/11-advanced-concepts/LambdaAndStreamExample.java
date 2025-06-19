package advanced;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class LambdaAndStreamExample {

    public static void main(String[] args) {
        // Functional interfaces and lambda expressions
        functionalInterfacesExample();
        
        // Method references
        methodReferencesExample();
        
        // Stream API examples
        streamApiBasics();
        streamOperations();
        streamCollectors();
        parallelStreams();
        
        // Optional examples
        optionalExample();
    }
    
    // Functional interfaces and lambda expressions
    private static void functionalInterfacesExample() {
        System.out.println("\n=== Functional Interfaces and Lambda Expressions ===");
        
        // Runnable (no parameters, no return value)
        Runnable runnable = () -> System.out.println("Running in a separate thread");
        runnable.run();
        
        // Predicate (takes one parameter, returns boolean)
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 7 even? " + isEven.test(7));
        
        // Function (takes one parameter, returns a value)
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        
        // Consumer (takes one parameter, returns no value)
        Consumer<String> printer = s -> System.out.println("Consuming: " + s);
        printer.accept("Hello World");
        
        // Supplier (takes no parameters, returns a value)
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Random value: " + randomValue.get());
        
        // BiFunction (takes two parameters, returns a value)
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.apply(5, 3));
        
        // Custom functional interface
        MathOperation multiply = (a, b) -> a * b;
        System.out.println("5 * 3 = " + operate(5, 3, multiply));
    }
    
    // Method references examples
    private static void methodReferencesExample() {
        System.out.println("\n=== Method References ===");
        
        // Static method reference
        Function<String, Integer> stringToInt = Integer::parseInt;
        System.out.println("String to int: " + stringToInt.apply("123"));
        
        // Instance method reference of a particular object
        String greeting = "Hello";
        Supplier<String> toUpperCase = greeting::toUpperCase;
        System.out.println("Uppercase: " + toUpperCase.get());
        
        // Instance method reference of an arbitrary object of a particular type
        Function<String, String> toLowerCase = String::toLowerCase;
        System.out.println("Lowercase: " + toLowerCase.apply("JAVA PROGRAMMING"));
        
        // Constructor reference
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> list = listSupplier.get();
        list.add("Item");
        System.out.println("List created with constructor reference: " + list);
    }
    
    // Stream API basics
    private static void streamApiBasics() {
        System.out.println("\n=== Stream API Basics ===");
        
        // Creating streams
        
        // From collection
        List<String> names = Arrays.asList("John", "Mary", "Bob", "Alice");
        Stream<String> streamFromCollection = names.stream();
        
        // From array
        String[] array = {"a", "b", "c"};
        Stream<String> streamFromArray = Arrays.stream(array);
        
        // Using Stream.of
        Stream<Integer> streamOfValues = Stream.of(1, 2, 3, 4, 5);
        
        // Generate infinite stream (limited to 5)
        Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
        System.out.println("Random numbers: " + randomStream.collect(Collectors.toList()));
        
        // Iterate to create a sequence
        Stream<Integer> sequenceStream = Stream.iterate(0, n -> n + 2).limit(5);
        System.out.println("Even numbers: " + sequenceStream.collect(Collectors.toList()));
    }
    
    // Stream operations
    private static void streamOperations() {
        System.out.println("\n=== Stream Operations ===");
        
        List<String> names = Arrays.asList("John", "Mary", "Bob", "Alice", "John");
        
        // Intermediate operations
        
        // Filter
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());
        System.out.println("Names longer than 3 chars: " + filteredNames);
        
        // Map
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Name lengths: " + nameLengths);
        
        // FlatMap (for flattening streams of streams)
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2), 
                Arrays.asList(3, 4, 5)
        );
        
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened list: " + flattenedList);
        
        // Distinct
        List<String> distinctNames = names.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct names: " + distinctNames);
        
        // Sorted
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames);
        
        // Custom sorting
        List<String> customSortedNames = names.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println("Names sorted by length (desc): " + customSortedNames);
        
        // Peek (for debugging)
        names.stream()
                .filter(name -> name.startsWith("J"))
                .peek(name -> System.out.println("Filtered: " + name))
                .map(String::toUpperCase)
                .peek(name -> System.out.println("Mapped: " + name))
                .collect(Collectors.toList());
        
        // Terminal operations
        
        // forEach
        System.out.print("forEach: ");
        names.stream().forEach(name -> System.out.print(name + " "));
        System.out.println();
        
        // count
        long count = names.stream()
                .filter(name -> name.contains("a"))
                .count();
        System.out.println("Count of names containing 'a': " + count);
        
        // findFirst, findAny
        Optional<String> first = names.stream()
                .filter(name -> name.length() > 4)
                .findFirst();
        System.out.println("First name longer than 4 chars: " + first.orElse("None"));
        
        // anyMatch, allMatch, noneMatch
        boolean anyMatch = names.stream().anyMatch(name -> name.startsWith("B"));
        boolean allMatch = names.stream().allMatch(name -> name.length() >= 3);
        boolean noneMatch = names.stream().noneMatch(name -> name.contains("z"));
        
        System.out.println("Any name starts with B: " + anyMatch);
        System.out.println("All names have length >= 3: " + allMatch);
        System.out.println("No name contains 'z': " + noneMatch);
        
        // reduce
        Optional<String> concatenated = names.stream()
                .distinct()
                .reduce((a, b) -> a + ", " + b);
        System.out.println("Concatenated names: " + concatenated.orElse(""));
    }
    
    // Stream collectors
    private static void streamCollectors() {
        System.out.println("\n=== Stream Collectors ===");
        
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35),
                new Person("David", 25),
                new Person("Eve", 30)
        );
        
        // toList, toSet
        List<String> nameList = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("Names as list: " + nameList);
        
        Set<Integer> ageSet = people.stream()
                .map(Person::getAge)
                .collect(Collectors.toSet());
        System.out.println("Unique ages: " + ageSet);
        
        // toMap
        Map<String, Integer> nameToAgeMap = people.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println("Name to age map: " + nameToAgeMap);
        
        // joining
        String joinedNames = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Names: [", "]"));
        System.out.println(joinedNames);
        
        // groupingBy
        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("People grouped by age: " + peopleByAge);
        
        // partitioningBy
        Map<Boolean, List<Person>> partitioned = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 28));
        System.out.println("People older than 28: " + partitioned.get(true));
        System.out.println("People 28 or younger: " + partitioned.get(false));
        
        // summarizingInt
        IntSummaryStatistics ageStats = people.stream()
                .collect(Collectors.summarizingInt(Person::getAge));
        System.out.println("Age statistics: " + ageStats);
    }
    
    // Parallel streams
    private static void parallelStreams() {
        System.out.println("\n=== Parallel Streams ===");
        
        List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000)
                .boxed()
                .collect(Collectors.toList());
        
        // Sequential processing
        long start = System.currentTimeMillis();
        long sequentialSum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToLong(Integer::longValue)
                .sum();
        long sequentialTime = System.currentTimeMillis() - start;
        
        // Parallel processing
        start = System.currentTimeMillis();
        long parallelSum = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToLong(Integer::longValue)
                .sum();
        long parallelTime = System.currentTimeMillis() - start;
        
        System.out.println("Sequential sum: " + sequentialSum + " in " + sequentialTime + "ms");
        System.out.println("Parallel sum: " + parallelSum + " in " + parallelTime + "ms");
    }
    
    // Optional examples
    private static void optionalExample() {
        System.out.println("\n=== Optional Class ===");
        
        // Creating Optionals
        Optional<String> empty = Optional.empty();
        Optional<String> value = Optional.of("Hello");
        Optional<String> nullable = Optional.ofNullable(null); // Creates empty Optional
        
        // Checking if present
        System.out.println("Empty is present: " + empty.isPresent());
        System.out.println("Value is present: " + value.isPresent());
        
        // ifPresent
        value.ifPresent(s -> System.out.println("Value is: " + s));
        
        // orElse
        String result1 = empty.orElse("Default");
        System.out.println("Empty orElse: " + result1);
        
        // orElseGet (supplier is only called if Optional is empty)
        String result2 = empty.orElseGet(() -> "Generated default");
        System.out.println("Empty orElseGet: " + result2);
        
        // orElseThrow
        try {
            empty.orElseThrow(() -> new NoSuchElementException("No value present"));
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // map
        Optional<String> mapped = value.map(String::toUpperCase);
        System.out.println("Mapped value: " + mapped.orElse(""));
        
        // filter
        Optional<String> filtered = value.filter(s -> s.length() > 10);
        System.out.println("Filtered value present: " + filtered.isPresent());
        
        // flatMap
        Optional<String> flatMapped = value.flatMap(s -> Optional.of(s + " World"));
        System.out.println("FlatMapped value: " + flatMapped.orElse(""));
    }
    
    // Custom functional interface
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }
    
    // Helper method to use custom functional interface
    private static int operate(int a, int b, MathOperation operation) {
        return operation.operate(a, b);
    }
    
    // Person class for collector examples
    static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
        
        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
}