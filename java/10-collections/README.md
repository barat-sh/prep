# Java Collections Framework

The Java Collections Framework provides a set of classes and interfaces for storing, processing, and manipulating groups of objects. It offers data structures and algorithms that operate on collections, allowing developers to work with data more efficiently.

## 1. Collections Framework Overview

The Collections Framework consists of:

- **Interfaces**: Abstract data types representing collections
- **Implementations**: Concrete implementations of the collection interfaces
- **Algorithms**: Methods that perform useful operations on collections

The main interfaces in the Collections Framework hierarchy:

- `Collection`: Root interface with basic methods for all collections
  - `List`: Ordered collection with duplicate elements allowed
  - `Set`: Collection with no duplicate elements
    - `SortedSet`: Set that maintains elements in sorted order
      - `NavigableSet`: SortedSet with navigation methods
  - `Queue`: Collection designed for holding elements before processing
    - `Deque`: Double-ended queue with insertion/removal at both ends
- `Map`: Maps keys to values, with no duplicate keys
  - `SortedMap`: Map that maintains keys in sorted order
    - `NavigableMap`: SortedMap with navigation methods

## 2. List Interface

A `List` is an ordered collection that allows duplicate elements. Elements can be accessed by their index position.

### ArrayList

`ArrayList` is a resizable array implementation of the `List` interface. It provides fast random access but slower insertions and deletions.

```java
// Creating an ArrayList
List<String> arrayList = new ArrayList<>();

// Adding elements
arrayList.add("Apple");
arrayList.add("Banana");
arrayList.add("Cherry");
arrayList.add("Apple");  // Duplicates allowed

// Accessing elements
String firstElement = arrayList.get(0);  // "Apple"

// Modifying elements
arrayList.set(1, "Blueberry");  // Replace "Banana" with "Blueberry"

// Removing elements
arrayList.remove("Cherry");    // Remove by object
arrayList.remove(0);           // Remove by index

// Checking if element exists
boolean containsApple = arrayList.contains("Apple");  // true

// Getting size
int size = arrayList.size();  // 2

// Iterating through elements
for (String fruit : arrayList) {
    System.out.println(fruit);
}
```

### LinkedList

`LinkedList` is a doubly-linked list implementation of the `List` and `Deque` interfaces. It provides efficient insertions and deletions but slower random access.

```java
// Creating a LinkedList
List<String> linkedList = new LinkedList<>();

// Adding elements
linkedList.add("Apple");
linkedList.add("Banana");

// LinkedList specific operations (using LinkedList reference)
LinkedList<String> linkedList2 = new LinkedList<>();
linkedList2.addFirst("Start");    // Add at the beginning
linkedList2.addLast("End");       // Add at the end
String first = linkedList2.getFirst();  // Get first element
String last = linkedList2.getLast();    // Get last element
linkedList2.removeFirst();        // Remove first element
linkedList2.removeLast();         // Remove last element
```

### Differences between ArrayList and LinkedList

| Operation | ArrayList | LinkedList |
|-----------|-----------|------------|
| Access (get) | O(1) | O(n) |
| Insert/Remove at beginning | O(n) | O(1) |
| Insert/Remove at end | O(1) (amortized) | O(1) |
| Insert/Remove in middle | O(n) | O(n) |
| Memory overhead | Low | High |

### Vector and Stack

`Vector` is a legacy class similar to `ArrayList` but synchronized. `Stack` extends `Vector` and adds operations for LIFO (Last-In-First-Out) behavior.

```java
// Creating a Vector
Vector<String> vector = new Vector<>();
vector.add("One");
vector.add("Two");

// Creating a Stack
Stack<String> stack = new Stack<>();
stack.push("One");    // Add to top
stack.push("Two");
String top = stack.peek();  // Look at top element without removing
String popped = stack.pop();  // Remove and return top element
boolean empty = stack.empty();  // Check if stack is empty
```

**Note**: For stack operations, `Deque` is preferred over `Stack`.

## 3. Set Interface

A `Set` is a collection that does not allow duplicate elements.

### HashSet

`HashSet` is a hash table implementation of the `Set` interface. It offers constant time performance for basic operations but does not guarantee element order.

```java
// Creating a HashSet
Set<String> hashSet = new HashSet<>();

// Adding elements
hashSet.add("Apple");
hashSet.add("Banana");
hashSet.add("Cherry");
hashSet.add("Apple");  // Duplicate not added

// Checking if element exists
boolean containsApple = hashSet.contains("Apple");  // true

// Removing elements
hashSet.remove("Cherry");

// Getting size
int size = hashSet.size();  // 2

// Iterating through elements
for (String fruit : hashSet) {
    System.out.println(fruit);  // Order not guaranteed
}
```

### LinkedHashSet

`LinkedHashSet` maintains insertion order while providing the performance of `HashSet`.

```java
// Creating a LinkedHashSet
Set<String> linkedHashSet = new LinkedHashSet<>();

// Adding elements
linkedHashSet.add("Apple");
linkedHashSet.add("Banana");
linkedHashSet.add("Cherry");

// Iterating (elements appear in insertion order)
for (String fruit : linkedHashSet) {
    System.out.println(fruit);  // Prints in insertion order
}
```

### TreeSet

`TreeSet` is a `NavigableSet` implementation backed by a tree. Elements are ordered using natural ordering or a comparator.

```java
// Creating a TreeSet with natural ordering
Set<String> treeSet = new TreeSet<>();

// Adding elements
treeSet.add("Cherry");
treeSet.add("Apple");
treeSet.add("Banana");

// Iterating (elements appear in sorted order)
for (String fruit : treeSet) {
    System.out.println(fruit);  // Prints in sorted order: Apple, Banana, Cherry
}

// TreeSet with a custom comparator (reverse order)
Set<String> reverseTreeSet = new TreeSet<>(Comparator.reverseOrder());
reverseTreeSet.addAll(Arrays.asList("Apple", "Banana", "Cherry"));

for (String fruit : reverseTreeSet) {
    System.out.println(fruit);  // Prints in reverse order: Cherry, Banana, Apple
}

// NavigableSet features
NavigableSet<String> navigableSet = new TreeSet<>(treeSet);
String lower = navigableSet.lower("Banana");  // Highest element < "Banana": "Apple"
String ceiling = navigableSet.ceiling("B");   // Lowest element >= "B": "Banana"
```

### EnumSet

`EnumSet` is a specialized `Set` implementation for enum types.

```java
enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

// Creating an EnumSet
EnumSet<Day> weekdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);

// Operations
EnumSet<Day> allDays = EnumSet.allOf(Day.class);
EnumSet<Day> noDays = EnumSet.noneOf(Day.class);
```

## 4. Map Interface

A `Map` maps keys to values, with no duplicate keys allowed.

### HashMap

`HashMap` is a hash table implementation of the `Map` interface. It offers constant time performance for basic operations but does not guarantee key order.

```java
// Creating a HashMap
Map<String, Integer> hashMap = new HashMap<>();

// Adding key-value pairs
hashMap.put("Apple", 10);
hashMap.put("Banana", 5);
hashMap.put("Cherry", 15);

// Accessing values
Integer appleCount = hashMap.get("Apple");  // 10
Integer orangeCount = hashMap.get("Orange");  // null (key not present)
Integer defaultCount = hashMap.getOrDefault("Orange", 0);  // 0 (default value)

// Checking if key or value exists
boolean containsApple = hashMap.containsKey("Apple");  // true
boolean containsCount15 = hashMap.containsValue(15);  // true

// Removing key-value pairs
hashMap.remove("Cherry");

// Getting size
int size = hashMap.size();  // 2

// Iterating through keys
for (String key : hashMap.keySet()) {
    System.out.println(key + ": " + hashMap.get(key));
}

// Iterating through entries
for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// Iterating through values
for (Integer value : hashMap.values()) {
    System.out.println(value);
}
```

### LinkedHashMap

`LinkedHashMap` maintains insertion order (or access order) while providing the performance of `HashMap`.

```java
// Creating a LinkedHashMap with insertion order (default)
Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

// Adding key-value pairs
linkedHashMap.put("Cherry", 15);
linkedHashMap.put("Apple", 10);
linkedHashMap.put("Banana", 5);

// Iterating (entries appear in insertion order)
for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
    // Prints in insertion order: Cherry: 15, Apple: 10, Banana: 5
}

// Creating a LinkedHashMap with access order
Map<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
accessOrderMap.put("A", 1);
accessOrderMap.put("B", 2);
accessOrderMap.put("C", 3);

// Access some entries
accessOrderMap.get("A");
accessOrderMap.get("C");

// Iterating (entries appear in access order)
for (String key : accessOrderMap.keySet()) {
    System.out.println(key);  // Prints: B, A, C (B wasn't accessed, A and C were)
}
```

### TreeMap

`TreeMap` is a `NavigableMap` implementation backed by a tree. Keys are ordered using natural ordering or a comparator.

```java
// Creating a TreeMap with natural ordering
Map<String, Integer> treeMap = new TreeMap<>();

// Adding key-value pairs
treeMap.put("Cherry", 15);
treeMap.put("Apple", 10);
treeMap.put("Banana", 5);

// Iterating (keys appear in sorted order)
for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
    // Prints in sorted order by key: Apple: 10, Banana: 5, Cherry: 15
}

// NavigableMap features
NavigableMap<String, Integer> navigableMap = new TreeMap<>(treeMap);
Map.Entry<String, Integer> lowerEntry = navigableMap.lowerEntry("Banana");
// Entry with highest key < "Banana": Apple=10
```

### Hashtable

`Hashtable` is a legacy class similar to `HashMap` but synchronized.

```java
// Creating a Hashtable
Hashtable<String, Integer> hashtable = new Hashtable<>();
hashtable.put("One", 1);
hashtable.put("Two", 2);
// hashtable.put(null, 3);  // Throws NullPointerException (null keys/values not allowed)
```

### EnumMap

`EnumMap` is a specialized `Map` implementation for enum type keys.

```java
enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

// Creating an EnumMap
EnumMap<Day, String> daySchedule = new EnumMap<>(Day.class);
daySchedule.put(Day.MONDAY, "Work");
daySchedule.put(Day.SATURDAY, "Relax");
```

## 5. Queue Interface

A `Queue` is a collection designed for holding elements before processing.

### LinkedList as Queue

`LinkedList` implements both `List` and `Queue` interfaces.

```java
// Creating a Queue using LinkedList
Queue<String> queue = new LinkedList<>();

// Adding elements
queue.offer("First");   // Adds to the end (returns false if full)
queue.add("Second");    // Adds to the end (throws exception if full)

// Examining elements
String head = queue.peek();  // Get head element without removing (returns null if empty)
String element = queue.element();  // Get head element without removing (throws exception if empty)

// Removing elements
String removed = queue.poll();  // Remove and return head element (returns null if empty)
String removedElement = queue.remove();  // Remove and return head element (throws exception if empty)

// Size and emptiness
int size = queue.size();
boolean isEmpty = queue.isEmpty();
```

### PriorityQueue

`PriorityQueue` orders elements according to natural ordering or a comparator.

```java
// Creating a PriorityQueue with natural ordering
Queue<Integer> priorityQueue = new PriorityQueue<>();

// Adding elements
priorityQueue.offer(3);
priorityQueue.offer(1);
priorityQueue.offer(2);

// Elements are retrieved in priority order
while (!priorityQueue.isEmpty()) {
    System.out.println(priorityQueue.poll());  // Prints: 1, 2, 3
}

// Creating a PriorityQueue with custom comparator (reverse order)
Queue<String> reversePriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
reversePriorityQueue.addAll(Arrays.asList("Apple", "Banana", "Cherry"));

while (!reversePriorityQueue.isEmpty()) {
    System.out.println(reversePriorityQueue.poll());  // Prints: Cherry, Banana, Apple
}
```

### ArrayDeque

`ArrayDeque` is a resizable array implementation of the `Deque` interface, providing a double-ended queue.

```java
// Creating an ArrayDeque
Deque<String> deque = new ArrayDeque<>();

// Adding elements
deque.addFirst("First");    // Add to front
deque.addLast("Last");      // Add to end
deque.offerFirst("New First");  // Add to front, returns false if full
deque.offerLast("New Last");    // Add to end, returns false if full

// Examining elements
String first = deque.peekFirst();  // Get front element without removing
String last = deque.peekLast();    // Get last element without removing

// Removing elements
String removedFirst = deque.pollFirst();  // Remove and return front element
String removedLast = deque.pollLast();    // Remove and return last element

// Using as a stack (LIFO)
deque.push("Stack Top");    // Add to front
String popped = deque.pop();  // Remove and return front element
```

## 6. Collections Utility Class

The `Collections` class provides static methods for operating on collections.

### Sorting

```java
// Sorting a List
List<String> list = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry"));
Collections.sort(list);  // Sorts in natural order: [Apple, Banana, Cherry]

// Sorting with a comparator
Collections.sort(list, Comparator.reverseOrder());  // [Cherry, Banana, Apple]
```

### Searching

```java
// Binary search (list must be sorted in ascending order)
List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
int index = Collections.binarySearch(numbers, 5);  // 2
int notFoundIndex = Collections.binarySearch(numbers, 4);  // -3 (insertion point: -3-1 = 2)
```

### Min/Max

```java
// Finding minimum and maximum elements
List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
int min = Collections.min(numbers);  // 1
int max = Collections.max(numbers);  // 9

// With a comparator
String shortest = Collections.min(Arrays.asList("apple", "banana", "kiwi"), 
                                 Comparator.comparing(String::length));  // "kiwi"
```

### Frequency and Disjoint

```java
// Counting occurrences
List<String> fruits = Arrays.asList("apple", "banana", "apple", "cherry");
int frequency = Collections.frequency(fruits, "apple");  // 2

// Checking if collections are disjoint (have no elements in common)
boolean disjoint = Collections.disjoint(
    Arrays.asList(1, 2, 3),
    Arrays.asList(4, 5, 6)
);  // true
```

### Unmodifiable Collections

```java
// Creating unmodifiable collections
List<String> original = new ArrayList<>(Arrays.asList("one", "two", "three"));
List<String> unmodifiableList = Collections.unmodifiableList(original);

// This will throw UnsupportedOperationException
// unmodifiableList.add("four");

// Other unmodifiable collection methods
Set<String> unmodifiableSet = Collections.unmodifiableSet(new HashSet<>(original));
Map<String, Integer> originalMap = new HashMap<>();
originalMap.put("one", 1);
Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(originalMap);
```

### Synchronized Collections

```java
// Creating synchronized collections (thread-safe)
List<String> syncList = Collections.synchronizedList(new ArrayList<>());
Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());

// When iterating a synchronized collection, external synchronization is needed
synchronized (syncList) {
    Iterator<String> iterator = syncList.iterator();
    while (iterator.hasNext()) {
        String element = iterator.next();
        // Process element
    }
}
```

### Singleton Collections

```java
// Creating singleton collections (immutable collections with a single element)
Set<Integer> singletonSet = Collections.singleton(42);
List<String> singletonList = Collections.singletonList("only element");
Map<String, Integer> singletonMap = Collections.singletonMap("key", 42);
```

## 7. Comparable and Comparator

### Comparable

`Comparable` is an interface that allows objects to define their "natural ordering".

```java
// Class implementing Comparable
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    
    // Constructor, getters, and setters
    
    @Override
    public int compareTo(Person other) {
        // Compare by age
        return Integer.compare(this.age, other.age);
    }
}

// Using Comparable for sorting
List<Person> people = new ArrayList<>();
people.add(new Person("Alice", 30));
people.add(new Person("Bob", 25));
people.add(new Person("Charlie", 35));

Collections.sort(people);  // Sorts by age (natural ordering)
```

### Comparator

`Comparator` is an interface that allows defining custom ordering for objects.

```java
// Creating a Comparator
Comparator<Person> nameComparator = new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
};

// Using a Comparator for sorting
Collections.sort(people, nameComparator);  // Sorts by name

// Using lambda expression (Java 8+)
Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));

// Using method reference (Java 8+)
Collections.sort(people, Comparator.comparing(Person::getName));

// Chained comparators (Java 8+)
Collections.sort(people, Comparator.comparing(Person::getAge)
                                  .thenComparing(Person::getName));
```

## 8. Legacy Collections

The Java Collections Framework includes legacy classes that predate the framework:

- `Vector`: A synchronized version of `ArrayList`
- `Hashtable`: A synchronized version of `HashMap`
- `Stack`: A subclass of `Vector` for LIFO operations
- `Enumeration`: An interface superseded by `Iterator`
- `Properties`: A subclass of `Hashtable` for working with property files

## 9. Collection Algorithms

The Collections Framework provides various algorithms for collections:

```java
List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9));

// Shuffling
Collections.shuffle(list);  // Randomly shuffles the list

// Reversing
Collections.reverse(list);  // Reverses the order of elements

// Rotating
Collections.rotate(list, 2);  // Rotates the list by 2 positions

// Swapping
Collections.swap(list, 0, 1);  // Swaps elements at indices 0 and 1

// Filling
Collections.fill(list, 0);  // Fills the list with 0

// Copying
List<Integer> dest = Arrays.asList(new Integer[list.size()]);
Collections.copy(dest, list);  // Copies list to dest

// Replacing all occurrences
Collections.replaceAll(list, 0, 42);  // Replaces all 0s with 42
```

## 10. Java 8+ Collection Enhancements

Java 8 introduced several improvements to the Collections Framework:

### Stream API

Streams provide a functional approach to processing collections.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Filtering elements
List<String> filtered = names.stream()
                              .filter(name -> name.startsWith("A"))
                              .collect(Collectors.toList());  // [Alice]

// Mapping elements
List<Integer> lengths = names.stream()
                              .map(String::length)
                              .collect(Collectors.toList());  // [5, 3, 7, 5]

// Sorting elements
List<String> sorted = names.stream()
                            .sorted()
                            .collect(Collectors.toList());  // [Alice, Bob, Charlie, David]

// Finding elements
Optional<String> any = names.stream()
                              .filter(name -> name.length() > 5)
                              .findAny();  // Optional[Charlie]

// Reducing elements
Optional<String> concatenated = names.stream()
                                      .reduce((s1, s2) -> s1 + ", " + s2);  
// Optional[Alice, Bob, Charlie, David]
```

### Collection Factory Methods (Java 9+)

Java 9 introduced convenient factory methods for creating small, immutable collections.

```java
// Immutable lists
List<String> list = List.of("one", "two", "three");

// Immutable sets
Set<String> set = Set.of("one", "two", "three");

// Immutable maps
Map<String, Integer> map = Map.of("one", 1, "two", 2, "three", 3);
Map<String, Integer> largerMap = Map.ofEntries(
    Map.entry("one", 1),
    Map.entry("two", 2),
    Map.entry("three", 3)
);
```

### Collection Default Methods (Java 8+)

Java 8 added default methods to collection interfaces.

```java
// List.forEach
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(name -> System.out.println(name));

// List.removeIf
List<String> mutableNames = new ArrayList<>(names);
mutableNames.removeIf(name -> name.startsWith("A"));  // Removes "Alice"

// List.replaceAll
mutableNames.replaceAll(String::toUpperCase);  // [BOB, CHARLIE]

// Map.forEach
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 95);
scores.put("Bob", 85);
scores.forEach((name, score) -> System.out.println(name + ": " + score));

// Map.getOrDefault
int score = scores.getOrDefault("Charlie", 0);  // 0 (default value)

// Map.putIfAbsent
scores.putIfAbsent("Charlie", 90);  // Adds only if key not present

// Map.compute, computeIfAbsent, computeIfPresent
scores.compute("Alice", (key, value) -> value + 5);  // Updates Alice's score to 100
scores.computeIfAbsent("David", key -> 80);  // Adds David only if not present
scores.computeIfPresent("Bob", (key, value) -> value + 10);  // Updates Bob's score to 95

// Map.merge
scores.merge("Alice", 10, Integer::sum);  // Adds 10 to Alice's score (110)
```

## 11. Thread-Safe Collections

Java provides several thread-safe collection implementations:

### ConcurrentHashMap

```java
ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
concurrentMap.put("one", 1);
concurrentMap.put("two", 2);

// Thread-safe operations
concurrentMap.putIfAbsent("three", 3);
concurrentMap.replace("one", 1, 10);
```

### CopyOnWriteArrayList and CopyOnWriteArraySet

```java
CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>();
copyOnWriteList.add("one");
copyOnWriteList.add("two");

// Thread-safe iteration (no ConcurrentModificationException)
for (String element : copyOnWriteList) {
    System.out.println(element);
    copyOnWriteList.add("three");  // Won't affect the current iteration
}
```

### ConcurrentSkipListMap and ConcurrentSkipListSet

```java
ConcurrentSkipListMap<String, Integer> skipListMap = new ConcurrentSkipListMap<>();
skipListMap.put("one", 1);
skipListMap.put("two", 2);

// Thread-safe and sorted
for (Map.Entry<String, Integer> entry : skipListMap.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### BlockingQueue Implementations

```java
BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
blockingQueue.offer("one");
blockingQueue.offer("two", 1, TimeUnit.SECONDS);  // Wait up to 1 second

String element = blockingQueue.poll(1, TimeUnit.SECONDS);  // Wait up to 1 second
```

## 12. Performance Considerations

When choosing a collection, consider the following performance characteristics:

| Collection | Get/Contains | Add/Remove | Notes |
|------------|--------------|------------|-------|
| ArrayList | O(1) | O(n) | Fast access, slow insertion/deletion in the middle |
| LinkedList | O(n) | O(1) | Slow access, fast insertion/deletion |
| HashSet | O(1) | O(1) | Fastest for add/remove/contains, no order |
| LinkedHashSet | O(1) | O(1) | Slightly slower than HashSet, keeps insertion order |
| TreeSet | O(log n) | O(log n) | Slower than HashSet, keeps elements sorted |
| HashMap | O(1) | O(1) | Fastest for put/get/remove, no key order |
| LinkedHashMap | O(1) | O(1) | Slightly slower than HashMap, keeps insertion order |
| TreeMap | O(log n) | O(log n) | Slower than HashMap, keeps keys sorted |

## 13. Best Practices

1. **Choose the Right Collection**: Select based on your specific requirements (ordering, uniqueness, access patterns).

2. **Use Generics**: Always specify the type parameter for type safety.

3. **Use the Interface Type**: Declare variables using interface types for flexibility.
   ```java
   List<String> list = new ArrayList<>();  // Not ArrayList<String>
   Map<String, Integer> map = new HashMap<>();  // Not HashMap<String, Integer>
   ```

4. **Use Factory Methods**: For small, immutable collections, use factory methods.
   ```java
   List<String> list = List.of("a", "b", "c");
   ```

5. **Use Enhanced For Loop**: For iterating through collections.
   ```java
   for (String element : collection) {
       // Process element
   }
   ```

6. **Use Stream API**: For functional-style operations on collections.
   ```java
   List<String> filtered = list.stream()
                                .filter(s -> s.length() > 3)
                                .collect(Collectors.toList());
   ```

7. **Consider Immutability**: Use unmodifiable collections when appropriate.
   ```java
   List<String> immutableList = Collections.unmodifiableList(originalList);
   ```

8. **Use Thread-Safe Collections**: For concurrent access.
   ```java
   Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
   ```

9. **Avoid Premature Optimization**: Choose the simplest collection that meets your needs, then optimize if necessary.

10. **Consider Memory Usage**: Some collections use more memory than others.