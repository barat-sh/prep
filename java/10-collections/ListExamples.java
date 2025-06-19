import java.util.*;

/**
 * This class demonstrates the usage of List implementations in Java
 */
public class ListExamples {
    public static void main(String[] args) {
        System.out.println("=== List Implementations in Java ===\n");
        
        // 1. ArrayList Examples
        System.out.println("1. ArrayList Examples:");
        arrayListExamples();
        
        // 2. LinkedList Examples
        System.out.println("\n2. LinkedList Examples:");
        linkedListExamples();
        
        // 3. ArrayList vs LinkedList Performance
        System.out.println("\n3. ArrayList vs LinkedList Performance:");
        compareListPerformance();
        
        // 4. Vector Examples (legacy synchronized List)
        System.out.println("\n4. Vector Examples:");
        vectorExamples();
        
        // 5. Stack Examples (legacy LIFO structure)
        System.out.println("\n5. Stack Examples:");
        stackExamples();
        
        // 6. Common List Operations
        System.out.println("\n6. Common List Operations:");
        commonListOperations();
        
        // 7. Sorting Lists
        System.out.println("\n7. Sorting Lists:");
        sortingLists();
        
        // 8. Searching in Lists
        System.out.println("\n8. Searching in Lists:");
        searchingInLists();
        
        // 9. Immutable Lists
        System.out.println("\n9. Immutable Lists:");
        immutableLists();
        
        // 10. Java 8+ List Features
        System.out.println("\n10. Java 8+ List Features:");
        java8ListFeatures();
    }
    
    /**
     * Demonstrates ArrayList operations
     */
    private static void arrayListExamples() {
        // Creating an ArrayList
        List<String> fruits = new ArrayList<>();
        
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("After adding elements: " + fruits);
        
        // Adding element at specific index
        fruits.add(1, "Blueberry");
        System.out.println("After adding Blueberry at index 1: " + fruits);
        
        // Accessing elements
        String firstFruit = fruits.get(0);
        System.out.println("First fruit: " + firstFruit);
        
        // Updating elements
        fruits.set(0, "Apricot");
        System.out.println("After updating index 0: " + fruits);
        
        // Removing elements
        fruits.remove("Banana");  // Remove by object
        System.out.println("After removing Banana: " + fruits);
        
        fruits.remove(0);  // Remove by index
        System.out.println("After removing element at index 0: " + fruits);
        
        // Checking if element exists
        boolean containsCherry = fruits.contains("Cherry");
        System.out.println("Contains Cherry? " + containsCherry);
        
        // Getting the size
        int size = fruits.size();
        System.out.println("Size of the list: " + size);
        
        // Iterating through elements
        System.out.println("Iterating through elements:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
        
        // Creating ArrayList with initial capacity
        List<Integer> numbers = new ArrayList<>(20);
        System.out.println("Created ArrayList with initial capacity of 20");
        
        // Creating ArrayList from another collection
        List<String> moreFruits = new ArrayList<>(fruits);
        System.out.println("Created ArrayList from existing collection: " + moreFruits);
        
        // Clearing the list
        fruits.clear();
        System.out.println("After clearing the list: " + fruits);
        System.out.println("Is the list empty? " + fruits.isEmpty());
    }
    
    /**
     * Demonstrates LinkedList operations
     */
    private static void linkedListExamples() {
        // Creating a LinkedList
        LinkedList<String> animals = new LinkedList<>();
        
        // Adding elements
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Elephant");
        System.out.println("After adding elements: " + animals);
        
        // LinkedList specific operations
        animals.addFirst("Lion");  // Add at the beginning
        animals.addLast("Tiger");  // Add at the end
        System.out.println("After adding at beginning and end: " + animals);
        
        // Getting first and last elements
        String firstAnimal = animals.getFirst();
        String lastAnimal = animals.getLast();
        System.out.println("First animal: " + firstAnimal);
        System.out.println("Last animal: " + lastAnimal);
        
        // Removing first and last elements
        String removedFirst = animals.removeFirst();
        String removedLast = animals.removeLast();
        System.out.println("Removed first animal: " + removedFirst);
        System.out.println("Removed last animal: " + removedLast);
        System.out.println("After removing first and last: " + animals);
        
        // Using LinkedList as a Queue (FIFO)
        System.out.println("\nUsing LinkedList as a Queue:");
        LinkedList<String> queue = new LinkedList<>();
        
        // Enqueue operations
        queue.offer("First");  // Add to end
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("Queue after adding elements: " + queue);
        
        // Dequeue operations
        String dequeued = queue.poll();  // Remove from front
        System.out.println("Dequeued element: " + dequeued);
        System.out.println("Queue after dequeuing: " + queue);
        
        // Peek operation (view the head without removing)
        String head = queue.peek();
        System.out.println("Head of the queue: " + head);
        
        // Using LinkedList as a Stack (LIFO)
        System.out.println("\nUsing LinkedList as a Stack:");
        LinkedList<String> stack = new LinkedList<>();
        
        // Push operations
        stack.push("Bottom");  // Add to front
        stack.push("Middle");
        stack.push("Top");
        System.out.println("Stack after pushing elements: " + stack);
        
        // Pop operations
        String popped = stack.pop();  // Remove from front
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after popping: " + stack);
        
        // Peek operation
        String top = stack.peek();
        System.out.println("Top of the stack: " + top);
    }
    
    /**
     * Compares performance of ArrayList and LinkedList
     */
    private static void compareListPerformance() {
        // Creating lists for comparison
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        
        // Number of operations
        int operations = 100000;
        
        // Testing add at the end
        long startTime = System.nanoTime();
        for (int i = 0; i < operations; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long arrayListAddTime = endTime - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < operations; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        long linkedListAddTime = endTime - startTime;
        
        System.out.println("Adding " + operations + " elements at the end:");
        System.out.println("ArrayList: " + arrayListAddTime / 1000000 + " ms");
        System.out.println("LinkedList: " + linkedListAddTime / 1000000 + " ms");
        
        // Reset lists
        arrayList.clear();
        linkedList.clear();
        
        // Pre-populate lists for insertion test
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        
        // Testing add at the beginning
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(0, i);
        }
        endTime = System.nanoTime();
        long arrayListInsertTime = endTime - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(0, i);
        }
        endTime = System.nanoTime();
        long linkedListInsertTime = endTime - startTime;
        
        System.out.println("\nAdding 1000 elements at the beginning:");
        System.out.println("ArrayList: " + arrayListInsertTime / 1000000 + " ms");
        System.out.println("LinkedList: " + linkedListInsertTime / 1000000 + " ms");
        
        // Testing random access
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        long arrayListAccessTime = endTime - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        long linkedListAccessTime = endTime - startTime;
        
        System.out.println("\nAccessing 10000 elements by index:");
        System.out.println("ArrayList: " + arrayListAccessTime / 1000000 + " ms");
        System.out.println("LinkedList: " + linkedListAccessTime / 1000000 + " ms");
        
        // Recommendations
        System.out.println("\nPerformance Recommendations:");
        System.out.println("- Use ArrayList for random access and when insertions are mostly at the end");
        System.out.println("- Use LinkedList for frequent insertions and deletions at any position");
        System.out.println("- ArrayList generally uses less memory than LinkedList");
    }
    
    /**
     * Demonstrates Vector operations
     */
    private static void vectorExamples() {
        // Creating a Vector
        Vector<String> vector = new Vector<>();
        
        // Vector has synchronized methods (thread-safe)
        vector.add("One");
        vector.add("Two");
        vector.add("Three");
        
        System.out.println("Vector elements: " + vector);
        
        // Vector specific methods
        vector.addElement("Four");  // Same as add
        System.out.println("After adding Fourth element: " + vector);
        
        // Accessing elements
        String firstElement = vector.firstElement();
        String lastElement = vector.lastElement();
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
        
        // Vector with initial capacity and capacity increment
        Vector<Integer> numbers = new Vector<>(5, 10);  // Initial capacity 5, increment by 10
        System.out.println("Created Vector with initial capacity 5, increment 10");
        
        // Add elements and observe capacity changes
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
            System.out.println("Size: " + numbers.size() + ", Capacity: " + numbers.capacity());
        }
    }
    
    /**
     * Demonstrates Stack operations
     */
    private static void stackExamples() {
        // Creating a Stack (extends Vector)
        Stack<String> stack = new Stack<>();
        
        // Push elements onto the stack
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");
        
        System.out.println("Stack: " + stack);
        
        // Peek at the top element
        String topElement = stack.peek();
        System.out.println("Top element (peek): " + topElement);
        
        // Pop elements from the stack
        String poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after pop: " + stack);
        
        // Check if stack is empty
        boolean isEmpty = stack.empty();
        System.out.println("Is stack empty? " + isEmpty);
        
        // Search for an element (returns 1-based position from the top)
        int position = stack.search("Bottom");
        System.out.println("Position of 'Bottom' from top: " + position);
        
        // Note: Deque is the preferred interface for stack operations
        System.out.println("\nUsing Deque for stack operations (modern approach):");
        Deque<String> modernStack = new ArrayDeque<>();
        modernStack.push("Bottom");
        modernStack.push("Middle");
        modernStack.push("Top");
        
        System.out.println("Stack using Deque: " + modernStack);
        System.out.println("Popped from Deque: " + modernStack.pop());
    }
    
    /**
     * Demonstrates common List operations
     */
    private static void commonListOperations() {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        
        System.out.println("Original list: " + colors);
        
        // Adding multiple elements
        colors.addAll(Arrays.asList("Yellow", "Purple"));
        System.out.println("After adding multiple elements: " + colors);
        
        // Adding multiple elements at a specific position
        colors.addAll(2, Arrays.asList("Orange", "Pink"));
        System.out.println("After adding multiple elements at index 2: " + colors);
        
        // Getting a sublist (view of the original list)
        List<String> subList = colors.subList(1, 4);  // From index 1 (inclusive) to 4 (exclusive)
        System.out.println("Sublist (elements 1-3): " + subList);
        
        // Modifying the sublist affects the original list
        subList.set(0, "Lime");  // Change "Green" to "Lime"
        System.out.println("Original list after modifying sublist: " + colors);
        
        // Finding the index of an element
        int blueIndex = colors.indexOf("Blue");
        System.out.println("Index of 'Blue': " + blueIndex);
        
        // Finding the last occurrence index
        colors.add("Blue");  // Add a duplicate
        int lastBlueIndex = colors.lastIndexOf("Blue");
        System.out.println("Last index of 'Blue': " + lastBlueIndex);
        
        // Removing all occurrences of an element
        colors.removeAll(Collections.singleton("Blue"));
        System.out.println("After removing all 'Blue': " + colors);
        
        // Retaining only certain elements
        colors.retainAll(Arrays.asList("Red", "Lime", "Yellow"));
        System.out.println("After retaining only Red, Lime, Yellow: " + colors);
        
        // Converting list to array
        String[] colorsArray = colors.toArray(new String[0]);
        System.out.println("Converted to array: " + Arrays.toString(colorsArray));
        
        // Creating list from array
        List<String> newColors = Arrays.asList(colorsArray);
        System.out.println("Created from array: " + newColors);
        
        // Note: Arrays.asList returns a fixed-size list backed by the array
        // To get a modifiable ArrayList:
        List<String> modifiableList = new ArrayList<>(Arrays.asList(colorsArray));
        System.out.println("Modifiable list from array: " + modifiableList);
    }
    
    /**
     * Demonstrates sorting Lists
     */
    private static void sortingLists() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("Cherry");
        
        System.out.println("Original list: " + fruits);
        
        // Natural ordering (alphabetical)
        Collections.sort(fruits);
        System.out.println("Naturally sorted: " + fruits);
        
        // Custom ordering with Comparator (by length)
        Collections.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println("Sorted by length: " + fruits);
        
        // Using lambda expression (Java 8+)
        Collections.sort(fruits, (s1, s2) -> s2.compareTo(s1));  // Reverse alphabetical
        System.out.println("Reverse alphabetical (lambda): " + fruits);
        
        // Using Comparator methods (Java 8+)
        fruits.sort(Comparator.naturalOrder());
        System.out.println("Natural order (Comparator method): " + fruits);
        
        fruits.sort(Comparator.reverseOrder());
        System.out.println("Reverse order (Comparator method): " + fruits);
        
        fruits.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
        System.out.println("Sorted by length, then alphabetically: " + fruits);
        
        // Sorting a list of custom objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));
        people.add(new Person("Alice", 28));
        
        // Sort by name
        people.sort(Comparator.comparing(Person::getName));
        System.out.println("\nPeople sorted by name:");
        for (Person person : people) {
            System.out.println(person);
        }
        
        // Sort by age
        people.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("\nPeople sorted by age:");
        for (Person person : people) {
            System.out.println(person);
        }
        
        // Sort by name then age
        people.sort(Comparator.comparing(Person::getName).thenComparingInt(Person::getAge));
        System.out.println("\nPeople sorted by name then age:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
    
    /**
     * Demonstrates searching in Lists
     */
    private static void searchingInLists() {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Purple");
        
        System.out.println("List: " + colors);
        
        // Linear search (indexOf)
        int redIndex = colors.indexOf("Red");
        System.out.println("Index of 'Red': " + redIndex);
        
        int orangeIndex = colors.indexOf("Orange");
        System.out.println("Index of 'Orange' (not in list): " + orangeIndex);  // -1
        
        // Binary search (requires sorted list)
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        
        System.out.println("\nSorted list: " + numbers);
        
        int index30 = Collections.binarySearch(numbers, 30);
        System.out.println("Binary search for 30: " + index30);
        
        int index35 = Collections.binarySearch(numbers, 35);
        System.out.println("Binary search for 35 (not in list): " + index35);  // Negative value
        
        // Calculate insertion point from negative result
        int insertionPoint = -index35 - 1;
        System.out.println("Insertion point for 35: " + insertionPoint);
        
        // Binary search with custom comparator
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));
        people.add(new Person("David", 40));
        
        // Sort by age for binary search
        people.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("\nPeople sorted by age:");
        for (Person person : people) {
            System.out.println(person);
        }
        
        // Binary search for person with age 35
        int personIndex = Collections.binarySearch(people, 
                                                 new Person("Unknown", 35), 
                                                 Comparator.comparingInt(Person::getAge));
        System.out.println("Binary search for person with age 35: " + personIndex);
        
        if (personIndex >= 0) {
            System.out.println("Found: " + people.get(personIndex));
        }
    }
    
    /**
     * Demonstrates immutable Lists
     */
    private static void immutableLists() {
        // Collections.unmodifiableList
        List<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Cherry");
        
        List<String> unmodifiableList = Collections.unmodifiableList(originalList);
        System.out.println("Unmodifiable list: " + unmodifiableList);
        
        // Try to modify the unmodifiable list (would throw UnsupportedOperationException)
        // unmodifiableList.add("Date");  // Uncommenting this would cause an exception
        
        // Modifying the original list affects the unmodifiable view
        originalList.add("Date");
        System.out.println("Unmodifiable list after modifying original: " + unmodifiableList);
        
        // Collections.singletonList (immutable list with exactly one element)
        List<String> singletonList = Collections.singletonList("Only Element");
        System.out.println("\nSingleton list: " + singletonList);
        
        // Collections.emptyList (immutable empty list)
        List<String> emptyList = Collections.emptyList();
        System.out.println("Empty list: " + emptyList);
        
        // Java 9+ List.of (immutable list)
        try {
            // This will work in Java 9+
            List<String> immutableList = List.of("One", "Two", "Three");
            System.out.println("\nImmutable list created with List.of(): " + immutableList);
            
            // Try to modify (would throw UnsupportedOperationException)
            // immutableList.add("Four");  // Uncommenting this would cause an exception
        } catch (NoSuchMethodError e) {
            System.out.println("\nList.of() is not available (requires Java 9+)");
        }
    }
    
    /**
     * Demonstrates Java 8+ List features
     */
    private static void java8ListFeatures() {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        
        System.out.println("Original list: " + colors);
        
        // forEach method
        System.out.println("\nUsing forEach:");
        colors.forEach(color -> System.out.println("Color: " + color));
        
        // removeIf method
        List<String> mutableColors = new ArrayList<>(colors);
        mutableColors.removeIf(color -> color.startsWith("R"));
        System.out.println("\nAfter removing colors starting with 'R': " + mutableColors);
        
        // replaceAll method
        mutableColors.replaceAll(String::toUpperCase);
        System.out.println("After converting to uppercase: " + mutableColors);
        
        // Stream API with lists
        System.out.println("\nUsing Stream API:");
        
        // Filtering
        List<String> filtered = colors.stream()
                                      .filter(color -> color.length() > 3)
                                      .toList();  // or .collect(Collectors.toList()) in older Java versions
        System.out.println("Filtered (length > 3): " + filtered);
        
        // Mapping
        List<Integer> lengths = colors.stream()
                                      .map(String::length)
                                      .toList();
        System.out.println("Mapped to lengths: " + lengths);
        
        // Sorting
        List<String> sorted = colors.stream()
                                     .sorted(Comparator.reverseOrder())
                                     .toList();
        System.out.println("Sorted in reverse: " + sorted);
        
        // Reducing
        String joined = colors.stream()
                               .reduce((s1, s2) -> s1 + ", " + s2)
                               .orElse("");
        System.out.println("Joined: " + joined);
    }
    
    /**
     * Person class for demonstrating sorting and searching custom objects
     */
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
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
}