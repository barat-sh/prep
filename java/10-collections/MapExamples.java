import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class demonstrates the usage of Map implementations in Java
 */
public class MapExamples {
    public static void main(String[] args) {
        System.out.println("=== Map Implementations in Java ===\n");
        
        // 1. HashMap Examples
        System.out.println("1. HashMap Examples:");
        hashMapExamples();
        
        // 2. LinkedHashMap Examples
        System.out.println("\n2. LinkedHashMap Examples:");
        linkedHashMapExamples();
        
        // 3. TreeMap Examples
        System.out.println("\n3. TreeMap Examples:");
        treeMapExamples();
        
        // 4. Hashtable Examples (legacy synchronized Map)
        System.out.println("\n4. Hashtable Examples:");
        hashtableExamples();
        
        // 5. EnumMap Examples
        System.out.println("\n5. EnumMap Examples:");
        enumMapExamples();
        
        // 6. Common Map Operations
        System.out.println("\n6. Common Map Operations:");
        commonMapOperations();
        
        // 7. Iterating through Maps
        System.out.println("\n7. Iterating through Maps:");
        iteratingThroughMaps();
        
        // 8. Immutable Maps
        System.out.println("\n8. Immutable Maps:");
        immutableMaps();
        
        // 9. Java 8+ Map Features
        System.out.println("\n9. Java 8+ Map Features:");
        java8MapFeatures();
        
        // 10. Thread-Safe Maps
        System.out.println("\n10. Thread-Safe Maps:");
        threadSafeMaps();
    }
    
    /**
     * Demonstrates HashMap operations
     */
    private static void hashMapExamples() {
        // Creating a HashMap
        Map<String, Integer> studentScores = new HashMap<>();
        
        // Adding key-value pairs
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 85);
        studentScores.put("Charlie", 90);
        System.out.println("After adding entries: " + studentScores);
        
        // HashMap allows null keys and values
        studentScores.put(null, 0);
        studentScores.put("David", null);
        System.out.println("After adding null key and value: " + studentScores);
        
        // Accessing values
        Integer bobScore = studentScores.get("Bob");
        System.out.println("Bob's score: " + bobScore);
        
        // Accessing non-existent key
        Integer eveScore = studentScores.get("Eve");
        System.out.println("Eve's score: " + eveScore);  // null
        
        // Using getOrDefault
        Integer frankScore = studentScores.getOrDefault("Frank", 0);
        System.out.println("Frank's score (with default): " + frankScore);  // 0
        
        // Checking if key exists
        boolean hasAlice = studentScores.containsKey("Alice");
        System.out.println("Contains Alice? " + hasAlice);
        
        // Checking if value exists
        boolean has90 = studentScores.containsValue(90);
        System.out.println("Contains score 90? " + has90);
        
        // Getting the size
        int size = studentScores.size();
        System.out.println("Size of the map: " + size);
        
        // Removing entries
        Integer removedScore = studentScores.remove("Bob");
        System.out.println("Removed Bob's score: " + removedScore);
        System.out.println("After removing Bob: " + studentScores);
        
        // Creating HashMap with initial capacity and load factor
        Map<String, String> options = new HashMap<>(16, 0.75f);
        System.out.println("Created HashMap with initial capacity 16, load factor 0.75");
        
        // Creating HashMap from another Map
        Map<String, Integer> moreScores = new HashMap<>(studentScores);
        System.out.println("Created HashMap from existing map: " + moreScores);
        
        // Clearing the map
        studentScores.clear();
        System.out.println("After clearing the map: " + studentScores);
        System.out.println("Is the map empty? " + studentScores.isEmpty());
    }
    
    /**
     * Demonstrates LinkedHashMap operations
     */
    private static void linkedHashMapExamples() {
        // Creating a LinkedHashMap (maintains insertion order)
        Map<String, Integer> studentScores = new LinkedHashMap<>();
        
        // Adding key-value pairs
        studentScores.put("Charlie", 90);
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 85);
        
        System.out.println("LinkedHashMap entries (insertion order preserved):");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Creating a LinkedHashMap with access order
        System.out.println("\nLinkedHashMap with access order:");
        
        Map<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put("Charlie", 90);
        accessOrderMap.put("Alice", 95);
        accessOrderMap.put("Bob", 85);
        
        System.out.println("Initial order:");
        printMap(accessOrderMap);
        
        // Access some entries
        accessOrderMap.get("Alice");
        accessOrderMap.get("Charlie");
        
        System.out.println("Order after accessing Alice and Charlie:");
        printMap(accessOrderMap);  // Bob (not accessed), Alice, Charlie
        
        // Implementing a simple LRU cache using LinkedHashMap
        System.out.println("\nImplementing a simple LRU cache:");
        
        // Anonymous subclass of LinkedHashMap that implements an LRU cache
        Map<String, String> lruCache = new LinkedHashMap<String, String>(16, 0.75f, true) {
            private static final int MAX_ENTRIES = 3;
            
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > MAX_ENTRIES;
            }
        };
        
        // Add entries to the cache
        lruCache.put("key1", "value1");
        lruCache.put("key2", "value2");
        lruCache.put("key3", "value3");
        
        System.out.println("Cache after adding 3 entries:");
        printMap(lruCache);
        
        // Access key1 (makes it most recently used)
        lruCache.get("key1");
        
        // Add a new entry (should evict the eldest entry, which is key2)
        lruCache.put("key4", "value4");
        
        System.out.println("Cache after adding key4 (key2 should be evicted):");
        printMap(lruCache);
    }
    
    /**
     * Demonstrates TreeMap operations
     */
    private static void treeMapExamples() {
        // Creating a TreeMap (sorts keys by natural ordering)
        Map<String, Integer> studentScores = new TreeMap<>();
        
        // Adding key-value pairs
        studentScores.put("Charlie", 90);
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 85);
        
        System.out.println("TreeMap entries (sorted by key):");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Creating a TreeMap with custom comparator (reverse order)
        Map<String, Integer> reverseMap = new TreeMap<>(Comparator.reverseOrder());
        reverseMap.putAll(studentScores);
        
        System.out.println("\nTreeMap with reverse ordering:");
        printMap(reverseMap);
        
        // Using NavigableMap methods
        System.out.println("\nUsing NavigableMap methods:");
        
        NavigableMap<String, Integer> navigableMap = new TreeMap<>(studentScores);
        
        // Find entries based on keys
        Map.Entry<String, Integer> firstEntry = navigableMap.firstEntry();
        Map.Entry<String, Integer> lastEntry = navigableMap.lastEntry();
        
        System.out.println("First entry: " + firstEntry.getKey() + " = " + firstEntry.getValue());
        System.out.println("Last entry: " + lastEntry.getKey() + " = " + lastEntry.getValue());
        
        // Finding closest matches
        Map.Entry<String, Integer> ceilingEntry = navigableMap.ceilingEntry("B");  // Smallest key >= "B"
        Map.Entry<String, Integer> floorEntry = navigableMap.floorEntry("B");      // Largest key <= "B"
        Map.Entry<String, Integer> higherEntry = navigableMap.higherEntry("B");    // Smallest key > "B"
        Map.Entry<String, Integer> lowerEntry = navigableMap.lowerEntry("B");      // Largest key < "B"
        
        System.out.println("Ceiling entry for 'B': " + 
                          (ceilingEntry != null ? ceilingEntry.getKey() : "none"));
        System.out.println("Floor entry for 'B': " + 
                          (floorEntry != null ? floorEntry.getKey() : "none"));
        System.out.println("Higher entry for 'B': " + 
                          (higherEntry != null ? higherEntry.getKey() : "none"));
        System.out.println("Lower entry for 'B': " + 
                          (lowerEntry != null ? lowerEntry.getKey() : "none"));
        
        // Getting submap views
        NavigableMap<String, Integer> headMap = navigableMap.headMap("Bob", true);  // Keys < "Bob" (inclusive)
        NavigableMap<String, Integer> tailMap = navigableMap.tailMap("Bob", true);  // Keys >= "Bob" (inclusive)
        NavigableMap<String, Integer> subMap = navigableMap.subMap("Alice", true, "Charlie", true);  // Keys between
        
        System.out.println("\nHead map (up to and including 'Bob'):");
        printMap(headMap);
        
        System.out.println("\nTail map (from 'Bob' onwards):");
        printMap(tailMap);
        
        System.out.println("\nSub map (from 'Alice' to 'Charlie', inclusive):");
        printMap(subMap);
        
        // Descending map view
        NavigableMap<String, Integer> descendingMap = navigableMap.descendingMap();
        System.out.println("\nDescending map view:");
        printMap(descendingMap);
    }
    
    /**
     * Demonstrates Hashtable operations
     */
    private static void hashtableExamples() {
        // Creating a Hashtable
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        
        // Adding key-value pairs
        hashtable.put("One", 1);
        hashtable.put("Two", 2);
        hashtable.put("Three", 3);
        
        System.out.println("Hashtable entries: " + hashtable);
        
        // Hashtable doesn't allow null keys or values
        try {
            hashtable.put(null, 4);
        } catch (NullPointerException e) {
            System.out.println("Cannot put null key in Hashtable");
        }
        
        try {
            hashtable.put("Four", null);
        } catch (NullPointerException e) {
            System.out.println("Cannot put null value in Hashtable");
        }
        
        // Legacy methods
        Enumeration<String> keys = hashtable.keys();
        System.out.println("\nEnumerating keys (legacy method):");
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(key + ": " + hashtable.get(key));
        }
        
        // Modern alternative to Hashtable
        System.out.println("\nModern alternative to Hashtable:");
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("One", 1);
        concurrentMap.put("Two", 2);
        System.out.println("ConcurrentHashMap: " + concurrentMap);
    }
    
    /**
     * Demonstrates EnumMap operations
     */
    private static void enumMapExamples() {
        // Creating an EnumMap
        EnumMap<Day, String> dayActivities = new EnumMap<>(Day.class);
        
        // Adding key-value pairs
        dayActivities.put(Day.MONDAY, "Work");
        dayActivities.put(Day.TUESDAY, "Study");
        dayActivities.put(Day.WEDNESDAY, "Gym");
        dayActivities.put(Day.THURSDAY, "Meeting");
        dayActivities.put(Day.FRIDAY, "Social");
        dayActivities.put(Day.SATURDAY, "Hiking");
        dayActivities.put(Day.SUNDAY, "Rest");
        
        System.out.println("EnumMap entries:");
        for (Map.Entry<Day, String> entry : dayActivities.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Checking if all enum constants are present
        boolean allDaysPresent = dayActivities.size() == Day.values().length;
        System.out.println("\nAll days present in the map? " + allDaysPresent);
        
        // Getting activity for a specific day
        String mondayActivity = dayActivities.get(Day.MONDAY);
        System.out.println("Monday activity: " + mondayActivity);
        
        // Creating a Map to track working days
        EnumMap<Day, Boolean> workingDays = new EnumMap<>(Day.class);
        
        for (Day day : Day.values()) {
            workingDays.put(day, day.isWeekday());
        }
        
        System.out.println("\nWorking days:");
        for (Map.Entry<Day, Boolean> entry : workingDays.entrySet()) {
            System.out.println(entry.getKey() + ": " + (entry.getValue() ? "Working day" : "Weekend"));
        }
        
        // Benefits of EnumMap
        System.out.println("\nBenefits of EnumMap:");
        System.out.println("- Very efficient (array-based)");
        System.out.println("- Keys are always enum constants");
        System.out.println("- Iteration order is the order of enum declaration");
    }
    
    /**
     * Demonstrates common Map operations
     */
    private static void commonMapOperations() {
        Map<String, String> capitals = new HashMap<>();
        
        // Put if absent (only adds if key doesn't exist)
        capitals.put("USA", "Washington D.C.");
        capitals.putIfAbsent("USA", "New York");  // Won't change the value
        capitals.putIfAbsent("UK", "London");     // Will add the entry
        
        System.out.println("Map after putIfAbsent: " + capitals);
        
        // Replace methods
        capitals.replace("USA", "Washington D.C.", "Washington, D.C.");  // Conditional replace
        capitals.replace("UK", "London City");  // Unconditional replace
        
        System.out.println("Map after replace: " + capitals);
        
        // Remove with key and value (conditional)
        boolean removed = capitals.remove("UK", "London");  // Won't remove (value doesn't match)
        System.out.println("UK removed? " + removed);
        System.out.println("Map after conditional remove: " + capitals);
        
        // Compute methods
        // compute: Compute a new value for the specified key
        capitals.compute("USA", (key, oldValue) -> oldValue + " (Capital)");
        
        // computeIfAbsent: Compute a value if the key is absent
        capitals.computeIfAbsent("Canada", key -> "Ottawa");
        
        // computeIfPresent: Compute a new value if the key is present
        capitals.computeIfPresent("UK", (key, oldValue) -> oldValue + " (Capital of England)");
        
        System.out.println("Map after compute methods: " + capitals);
        
        // Merge: Merge the given value with the existing value
        capitals.merge("France", "Paris", (oldValue, value) -> oldValue + " / " + value);  // Key doesn't exist
        capitals.merge("USA", " - Federal District", (oldValue, value) -> oldValue + value);  // Key exists
        
        System.out.println("Map after merge: " + capitals);
        
        // Get entries, keys, and values as collections
        Set<Map.Entry<String, String>> entries = capitals.entrySet();
        Set<String> keys = capitals.keySet();
        Collection<String> values = capitals.values();
        
        System.out.println("\nEntries: " + entries);
        System.out.println("Keys: " + keys);
        System.out.println("Values: " + values);
        
        // Note: These collections are backed by the map
        // Removing from the keySet or entrySet removes from the map
        keys.remove("France");
        System.out.println("Map after removing 'France' from keySet: " + capitals);
    }
    
    /**
     * Demonstrates different ways to iterate through Maps
     */
    private static void iteratingThroughMaps() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 85);
        scores.put("Charlie", 90);
        
        // 1. Iterating through entrySet (most efficient)
        System.out.println("Iterating through entrySet:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 2. Iterating through keySet and getting values
        System.out.println("\nIterating through keySet:");
        for (String key : scores.keySet()) {
            System.out.println(key + ": " + scores.get(key));
        }
        
        // 3. Iterating through values only
        System.out.println("\nIterating through values:");
        for (Integer value : scores.values()) {
            System.out.println("Score: " + value);
        }
        
        // 4. Using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<Map.Entry<String, Integer>> iterator = scores.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // 5. Using forEach (Java 8+)
        System.out.println("\nUsing forEach (Java 8+):");
        scores.forEach((key, value) -> System.out.println(key + ": " + value));
        
        // Modifying while iterating (using Iterator)
        System.out.println("\nModifying while iterating:");
        
        Map<String, Integer> mutableScores = new HashMap<>(scores);
        Iterator<Map.Entry<String, Integer>> mutableIterator = mutableScores.entrySet().iterator();
        
        while (mutableIterator.hasNext()) {
            Map.Entry<String, Integer> entry = mutableIterator.next();
            if (entry.getValue() < 90) {
                mutableIterator.remove();  // Safe way to remove during iteration
            }
        }
        
        System.out.println("After removing scores < 90: " + mutableScores);
    }
    
    /**
     * Demonstrates immutable Maps
     */
    private static void immutableMaps() {
        // Collections.unmodifiableMap
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("One", 1);
        originalMap.put("Two", 2);
        originalMap.put("Three", 3);
        
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(originalMap);
        System.out.println("Unmodifiable map: " + unmodifiableMap);
        
        // Try to modify the unmodifiable map (would throw UnsupportedOperationException)
        // unmodifiableMap.put("Four", 4);  // Uncommenting this would cause an exception
        
        // Modifying the original map affects the unmodifiable view
        originalMap.put("Four", 4);
        System.out.println("Unmodifiable map after modifying original: " + unmodifiableMap);
        
        // Collections.singletonMap (immutable map with exactly one entry)
        Map<String, Integer> singletonMap = Collections.singletonMap("Only Key", 100);
        System.out.println("\nSingleton map: " + singletonMap);
        
        // Collections.emptyMap (immutable empty map)
        Map<String, Integer> emptyMap = Collections.emptyMap();
        System.out.println("Empty map: " + emptyMap);
        
        // Java 9+ Map.of and Map.ofEntries (immutable maps)
        try {
            // This will work in Java 9+
            Map<String, Integer> smallMap = Map.of(
                "One", 1,
                "Two", 2,
                "Three", 3
            );
            System.out.println("\nImmutable map created with Map.of(): " + smallMap);
            
            // For more than 10 entries, use ofEntries
            /*
            Map<String, Integer> largeMap = Map.ofEntries(
                Map.entry("One", 1),
                Map.entry("Two", 2),
                Map.entry("Three", 3)
                // ... more entries
            );
            */
            
            // Try to modify (would throw UnsupportedOperationException)
            // smallMap.put("Four", 4);  // Uncommenting this would cause an exception
        } catch (NoSuchMethodError e) {
            System.out.println("\nMap.of() is not available (requires Java 9+)");
        }
    }
    
    /**
     * Demonstrates Java 8+ Map features
     */
    private static void java8MapFeatures() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 85);
        scores.put("Charlie", 90);
        
        System.out.println("Original map: " + scores);
        
        // getOrDefault
        int davidScore = scores.getOrDefault("David", 0);
        System.out.println("\nDavid's score (default): " + davidScore);
        
        // putIfAbsent
        scores.putIfAbsent("David", 80);  // Adds David
        scores.putIfAbsent("Alice", 100);  // Won't change Alice's score
        System.out.println("After putIfAbsent: " + scores);
        
        // forEach
        System.out.println("\nUsing forEach:");
        scores.forEach((name, score) -> System.out.println(name + " scored " + score));
        
        // compute
        scores.compute("Alice", (key, value) -> value + 5);
        System.out.println("\nAfter incrementing Alice's score: " + scores);
        
        // computeIfAbsent
        scores.computeIfAbsent("Eve", k -> 75);
        System.out.println("After computeIfAbsent for Eve: " + scores);
        
        // computeIfPresent
        scores.computeIfPresent("Bob", (key, value) -> value + 10);
        System.out.println("After incrementing Bob's score: " + scores);
        
        // remove that takes both key and value
        boolean removed = scores.remove("David", 85);  // Won't remove (value doesn't match)
        System.out.println("\nDavid removed? " + removed);
        
        removed = scores.remove("David", 80);  // Will remove (value matches)
        System.out.println("David removed now? " + removed);
        System.out.println("After conditional remove: " + scores);
        
        // replace
        scores.replace("Charlie", 92);
        System.out.println("\nAfter replacing Charlie's score: " + scores);
        
        // Conditional replace
        boolean replaced = scores.replace("Eve", 70, 80);  // Won't replace (old value doesn't match)
        System.out.println("Eve's score replaced? " + replaced);
        
        replaced = scores.replace("Eve", 75, 80);  // Will replace (old value matches)
        System.out.println("Eve's score replaced now? " + replaced);
        System.out.println("After conditional replace: " + scores);
        
        // merge
        scores.merge("Frank", 88, (oldValue, value) -> oldValue + value);  // Add Frank with 88
        scores.merge("Alice", 3, (oldValue, value) -> oldValue + value);   // Add 3 to Alice's score
        System.out.println("\nAfter merge: " + scores);
        
        // Using merge to implement a word counter
        String text = "the quick brown fox jumps over the lazy dog";
        Map<String, Integer> wordCounts = new HashMap<>();
        
        for (String word : text.split(" ")) {
            wordCounts.merge(word, 1, Integer::sum);
        }
        
        System.out.println("\nWord counts: " + wordCounts);
    }
    
    /**
     * Demonstrates thread-safe Map implementations
     */
    private static void threadSafeMaps() {
        // ConcurrentHashMap (modern thread-safe map)
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        
        concurrentMap.put("One", 1);
        concurrentMap.put("Two", 2);
        concurrentMap.put("Three", 3);
        
        System.out.println("ConcurrentHashMap: " + concurrentMap);
        
        // ConcurrentHashMap features
        System.out.println("\nConcurrentHashMap features:");
        System.out.println("- Thread-safe without blocking reads");
        System.out.println("- High concurrency for reads and updates");
        System.out.println("- Does not allow null keys or values");
        System.out.println("- Iteration doesn't throw ConcurrentModificationException");
        
        // ConcurrentHashMap atomic operations
        concurrentMap.putIfAbsent("Four", 4);  // Atomic operation
        
        // Get old value or compute new one atomically
        concurrentMap.computeIfAbsent("Five", k -> k.length());  // Atomic
        
        // Replace only if value matches (atomic)
        concurrentMap.replace("One", 1, 10);
        
        System.out.println("After atomic operations: " + concurrentMap);
        
        // ConcurrentHashMap parallel operations (Java 8+)
        System.out.println("\nParallel operations on ConcurrentHashMap:");
        
        ConcurrentHashMap<String, Integer> bigMap = new ConcurrentHashMap<>();
        // Populate the map
        for (char c = 'A'; c <= 'Z'; c++) {
            bigMap.put(String.valueOf(c), c - 'A' + 1);
        }
        
        // Parallel forEach
        System.out.println("Parallel forEach (entries with values > 20):");
        bigMap.forEach(4, (key, value) -> value > 20, 
                      (key, value) -> System.out.println(key + ": " + value));
        
        // Parallel search
        String result = bigMap.search(4, (key, value) -> value == 5 ? key : null);
        System.out.println("\nKey with value 5: " + result);
        
        // Synchronized Collections (legacy thread-safe collections)
        System.out.println("\nSynchronized Collections (legacy):");
        
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        synchronizedMap.put("One", 1);
        synchronizedMap.put("Two", 2);
        
        System.out.println("Synchronized Map: " + synchronizedMap);
        
        // Iterating safely over synchronized collections
        System.out.println("\nSafe iteration over synchronized collections:");
        synchronized (synchronizedMap) {
            for (Map.Entry<String, Integer> entry : synchronizedMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    
    /**
     * Helper method to print map entries
     */
    private static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    /**
     * Enum for day of week
     */
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        
        public boolean isWeekday() {
            return this != SATURDAY && this != SUNDAY;
        }
    }
}