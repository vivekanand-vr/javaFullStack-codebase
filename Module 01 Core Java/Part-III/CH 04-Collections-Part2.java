/*
 * Understanding Collections Framework in Java - Part 2
 * Focus: Map Interface, Generics, Streams, and Advanced Topics
 */

/*
 * Part 2 covers:
 * - Map interface and its implementations (HashMap, LinkedHashMap, TreeMap, Hashtable)
 * - Generics in Collections (type safety, wildcards, bounds)
 * - Streams API with Collections (Java 8+)
 * - Concurrent Collections (thread-safe alternatives)
 * - Collections Best Practices and Performance considerations
 * - Custom Comparators and Comparable interface
 * 
 * Map Hierarchy (separate from Collection):
 * Map (interface) - key-value pairs, no duplicate keys
 * ├── HashMap - hash table, fastest access, no ordering
 * ├── LinkedHashMap - maintains insertion/access order
 * ├── TreeMap - sorted by keys, natural or custom ordering
 * ├── Hashtable - legacy, synchronized HashMap
 * └── ConcurrentHashMap - thread-safe, high performance
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsPart2 {
    
    public static void main(String[] args) {
        System.out.println("1. Collections Framework - Part 2:");
        
        // 1. Map Interface implementations
        System.out.println("\n=== MAP INTERFACE ===");
        demonstrateHashMap();
        demonstrateLinkedHashMap();
        demonstrateTreeMap();
        demonstrateHashtable();
        compareMapPerformance();
        
        // 2. Generics with Collections
        System.out.println("\n=== GENERICS ===");
        demonstrateGenerics();
        demonstrateWildcards();
        demonstrateBounds();
        
        // 3. Streams API with Collections
        System.out.println("\n=== STREAMS API ===");
        demonstrateBasicStreams();
        demonstrateStreamOperations();
        demonstrateCollectors();
        demonstrateParallelStreams();
        
        // 4. Concurrent Collections
        System.out.println("\n=== CONCURRENT COLLECTIONS ===");
        demonstrateConcurrentCollections();
        
        // 5. Advanced Topics
        System.out.println("\n=== ADVANCED TOPICS ===");
        demonstrateComparators();
        demonstrateCustomCollections();
        demonstrateBestPractices();
    }
    
    // 1. HashMap - Hash table implementation
    public static void demonstrateHashMap() {
        System.out.println("\n1. HashMap Demonstration:");
        
        // Creating HashMap
        Map<String, Integer> studentGrades = new HashMap<>();
        
        // Adding key-value pairs
        studentGrades.put("Alice", 85);
        studentGrades.put("Bob", 92);
        studentGrades.put("Charlie", 78);
        studentGrades.put("Diana", 95);
        System.out.println("Student grades: " + studentGrades);
        
        // Accessing values
        System.out.println("Alice's grade: " + studentGrades.get("Alice"));
        System.out.println("Eve's grade: " + studentGrades.get("Eve")); // null for non-existent key
        
        // Using getOrDefault
        System.out.println("Eve's grade (with default): " + 
                         studentGrades.getOrDefault("Eve", 0));
        
        // Updating values
        studentGrades.put("Alice", 88); // Overwrites existing value
        studentGrades.putIfAbsent("Eve", 82); // Only adds if key doesn't exist
        System.out.println("After updates: " + studentGrades);
        
        // Checking existence
        System.out.println("Contains Alice: " + studentGrades.containsKey("Alice"));
        System.out.println("Contains grade 92: " + studentGrades.containsValue(92));
        
        // Iterating over HashMap
        System.out.println("Iterating over entries:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Java 8+ forEach
        System.out.println("Using forEach (Java 8+):");
        studentGrades.forEach((name, grade) -> 
            System.out.println(name + " scored " + grade));
        
        // Compute methods (Java 8+)
        studentGrades.compute("Alice", (name, grade) -> grade + 5); // Add 5 to Alice's grade
        studentGrades.computeIfAbsent("Frank", name -> 75); // Add Frank if not present
        studentGrades.computeIfPresent("Bob", (name, grade) -> grade - 2); // Subtract 2 from Bob
        System.out.println("After compute operations: " + studentGrades);
        
        // Merge operation
        Map<String, Integer> bonusPoints = Map.of("Alice", 3, "Grace", 8);
        bonusPoints.forEach((name, bonus) -> 
            studentGrades.merge(name, bonus, Integer::sum)); // Add bonus to existing or set new
        System.out.println("After merging bonus points: " + studentGrades);
    }
    
    // 2. LinkedHashMap - Maintains insertion order
    public static void demonstrateLinkedHashMap() {
        System.out.println("\n2. LinkedHashMap Demonstration:");
        
        // Maintains insertion order
        Map<String, String> insertionOrderMap = new LinkedHashMap<>();
        insertionOrderMap.put("Third", "C");
        insertionOrderMap.put("First", "A");
        insertionOrderMap.put("Second", "B");
        System.out.println("Insertion order maintained: " + insertionOrderMap);
        
        // Access-order LinkedHashMap (useful for LRU cache)
        Map<String, String> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put("One", "1");
        accessOrderMap.put("Two", "2");
        accessOrderMap.put("Three", "3");
        System.out.println("Before access: " + accessOrderMap);
        
        accessOrderMap.get("One"); // Access "One"
        System.out.println("After accessing 'One': " + accessOrderMap);
        
        // LRU Cache example
        LRUCache<String, String> lruCache = new LRUCache<>(3);
        lruCache.put("A", "Apple");
        lruCache.put("B", "Banana");
        lruCache.put("C", "Cherry");
        System.out.println("LRU Cache: " + lruCache);
        
        lruCache.get("A"); // Move A to end
        lruCache.put("D", "Date"); // This should evict B
        System.out.println("After adding D: " + lruCache);
    }
    
    // 3. TreeMap - Sorted map implementation
    public static void demonstrateTreeMap() {
        System.out.println("\n3. TreeMap Demonstration:");
        
        // Natural ordering
        Map<String, Double> stockPrices = new TreeMap<>();
        stockPrices.put("GOOGL", 2500.50);
        stockPrices.put("AAPL", 150.75);
        stockPrices.put("MSFT", 300.25);
        stockPrices.put("AMZN", 3200.00);
        System.out.println("Stocks (sorted by symbol): " + stockPrices);
        
        TreeMap<String, Double> treeMap = (TreeMap<String, Double>) stockPrices;
        
        // TreeMap specific methods
        System.out.println("First entry: " + treeMap.firstEntry());
        System.out.println("Last entry: " + treeMap.lastEntry());
        System.out.println("Lower key than 'GOOGL': " + treeMap.lowerKey("GOOGL"));
        System.out.println("Higher key than 'GOOGL': " + treeMap.higherKey("GOOGL"));
        
        // Submap operations
        System.out.println("Stocks from A to M: " + treeMap.subMap("A", "M"));
        System.out.println("Stocks before MSFT: " + treeMap.headMap("MSFT"));
        System.out.println("Stocks from MSFT onward: " + treeMap.tailMap("MSFT"));
        
        // Custom comparator - sort by value (price)
        Map<String, Double> sortedByPrice = stockPrices.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(LinkedHashMap::new,
                    (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                    LinkedHashMap::putAll);
        System.out.println("Stocks sorted by price: " + sortedByPrice);
        
        // TreeMap with custom comparator for keys
        Map<String, Integer> lengthSortedMap = new TreeMap<>(
            Comparator.comparing(String::length).thenComparing(String::compareTo));
        lengthSortedMap.put("Elephant", 8);
        lengthSortedMap.put("Cat", 3);
        lengthSortedMap.put("Dog", 3);
        lengthSortedMap.put("Lion", 4);
        System.out.println("Words sorted by length then alphabetically: " + lengthSortedMap);
    }
    
    // 4. Hashtable - Legacy synchronized map
    public static void demonstrateHashtable() {
        System.out.println("\n4. Hashtable Demonstration:");
        
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        
        hashtable.put("One", 1);
        hashtable.put("Two", 2);
        hashtable.put("Three", 3);
        // hashtable.put(null, 4); // This would throw NullPointerException
        // hashtable.put("Four", null); // This would also throw NullPointerException
        
        System.out.println("Hashtable: " + hashtable);
        System.out.println("Note: Hashtable is synchronized but doesn't allow null keys or values");
        System.out.println("Prefer ConcurrentHashMap for thread-safe operations");
        
        // Properties class extends Hashtable
        Properties props = new Properties();
        props.setProperty("database.url", "jdbc:mysql://localhost:3306/mydb");
        props.setProperty("database.user", "admin");
        props.setProperty("database.password", "secret");
        System.out.println("Properties (extends Hashtable): " + props);
    }
    
    // 5. Map Performance Comparison
    public static void compareMapPerformance() {
        System.out.println("\n5. Map Performance Comparison:");
        
        final int size = 100000;
        
        // HashMap performance
        long start = System.nanoTime();
        Map<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            hashMap.put(i, "Value" + i);
        }
        long hashMapTime = System.nanoTime() - start;
        
        // TreeMap performance
        start = System.nanoTime();
        Map<Integer, String> treeMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            treeMap.put(i, "Value" + i);
        }
        long treeMapTime = System.nanoTime() - start;
        
        System.out.println("Inserting " + size + " elements:");
        System.out.println("HashMap time: " + hashMapTime / 1_000_000.0 + " ms");
        System.out.println("TreeMap time: " + treeMapTime / 1_000_000.0 + " ms");
        System.out.println("TreeMap is ~" + (treeMapTime / hashMapTime) + "x slower for insertion");
        
        // Lookup performance
        Random random = new Random();
        int randomKey = random.nextInt(size);
        
        start = System.nanoTime();
        hashMap.get(randomKey);
        long hashMapLookup = System.nanoTime() - start;
        
        start = System.nanoTime();
        treeMap.get(randomKey);
        long treeMapLookup = System.nanoTime() - start;
        
        System.out.println("\nLookup performance:");
        System.out.println("HashMap lookup: " + hashMapLookup + " ns");
        System.out.println("TreeMap lookup: " + treeMapLookup + " ns");
    }
    
    // 6. Generics Demonstration
    public static void demonstrateGenerics() {
        System.out.println("\n6. Generics Demonstration:");
        
        // Type safety with generics
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        // stringList.add(42); // Compilation error - type safety
        
        System.out.println("String list: " + stringList);
        
        // Generic methods
        String[] stringArray = {"Apple", "Banana", "Cherry"};
        Integer[] intArray = {1, 2, 3, 4, 5};
        
        System.out.println("String array: " + Arrays.toString(stringArray));
        System.out.println("Integer array: " + Arrays.toString(intArray));
        
        // Swapping elements using generic method
        swap(stringArray, 0, 2);
        swap(intArray, 1, 3);
        
        System.out.println("After swapping:");
        System.out.println("String array: " + Arrays.toString(stringArray));
        System.out.println("Integer array: " + Arrays.toString(intArray));
        
        // Generic classes
        Box<String> stringBox = new Box<>("Hello Generics");
        Box<Integer> intBox = new Box<>(42);
        
        System.out.println("String box: " + stringBox.get());
        System.out.println("Integer box: " + intBox.get());
        
        // Diamond operator (Java 7+)
        Map<String, List<Integer>> complexMap = new HashMap<>(); // Type inferred
        complexMap.put("numbers", Arrays.asList(1, 2, 3));
        System.out.println("Complex generic structure: " + complexMap);
    }
    
    // 7. Wildcards in Generics
    public static void demonstrateWildcards() {
        System.out.println("\n7. Wildcards Demonstration:");
        
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        List<String> stringList = Arrays.asList("One", "Two", "Three");
        
        // Upper bounded wildcard (? extends Number)
        double sum = sumNumbers(intList);
        System.out.println("Sum of integers: " + sum);
        
        sum = sumNumbers(doubleList);
        System.out.println("Sum of doubles: " + sum);
        
        // sumNumbers(stringList); // Compilation error - String doesn't extend Number
        
        // Lower bounded wildcard (? super Integer)
        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList);
        System.out.println("Numbers added: " + numberList);
        
        List<Object> objectList = new ArrayList<>();
        addNumbers(objectList);
        System.out.println("Objects added: " + objectList);
        
        // Unbounded wildcard (?)
        printList(intList);
        printList(stringList);
        printList(doubleList);
        
        // PECS rule demonstration (Producer Extends, Consumer Super)
        List<? extends Number> producer = intList; // Can read as Number
        // producer.add(5); // Compilation error - can't add to producer
        Number number = producer.get(0); // Can read
        System.out.println("Read from producer: " + number);
        
        List<? super Integer> consumer = numberList; // Can add Integer
        consumer.add(10); // Can add
        // Integer value = consumer.get(0); // Compilation error - can only read as Object
        Object value = consumer.get(0); // Can only read as Object
        System.out.println("Consumer after adding: " + consumer);
    }
    
    // 8. Bounded Type Parameters
    public static void demonstrateBounds() {
        System.out.println("\n8. Bounded Type Parameters:");
        
        NumberProcessor<Integer> intProcessor = new NumberProcessor<>();
        NumberProcessor<Double> doubleProcessor = new NumberProcessor<>();
        // NumberProcessor<String> stringProcessor = new NumberProcessor<>(); // Compilation error
        
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);
        
        System.out.println("Integer max: " + intProcessor.findMax(integers));
        System.out.println("Double max: " + doubleProcessor.findMax(doubles));
        System.out.println("Integer average: " + intProcessor.calculateAverage(integers));
        System.out.println("Double average: " + doubleProcessor.calculateAverage(doubles));
        
        // Multiple bounds example
        ComparableProcessor<String> stringProcessor = new ComparableProcessor<>();
        List<String> strings = Arrays.asList("banana", "apple", "cherry", "date");
        System.out.println("String max (lexicographically): " + stringProcessor.findMaxComparable(strings));
        
        // Intersection types with multiple bounds
        Processor<String> processor = new Processor<>();
        System.out.println("Processing strings: " + processor.processComparableSerializable(strings));
    }
    
    // 9. Streams API with Collections
    public static void demonstrateBasicStreams() {
        System.out.println("\n9. Basic Streams Demonstration:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter and collect
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        
        // Map transformation
        List<String> numberStrings = numbers.stream()
            .map(n -> "Number: " + n)
            .collect(Collectors.toList());
        System.out.println("Mapped strings: " + numberStrings);
        
        // Reduce operation
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Sum using reduce: " + sum);
        
        // Find operations
        Optional<Integer> firstEven = numbers.stream()
            .filter(n -> n % 2 == 0)
            .findFirst();
        System.out.println("First even number: " + firstEven.orElse(-1));
        
        // Count and statistics
        long evenCount = numbers.stream()
            .filter(n -> n % 2 == 0)
            .count();
        System.out.println("Count of even numbers: " + evenCount);
        
        IntSummaryStatistics stats = numbers.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
        System.out.println("Statistics: " + stats);
    }
    
    // 10. Advanced Stream Operations
    public static void demonstrateStreamOperations() {
        System.out.println("\n10. Advanced Stream Operations:");
        
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig");
        
        // FlatMap example
        List<String> characters = words.stream()
            .flatMap(word -> Arrays.stream(word.split("")))
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Unique characters: " + characters);
        
        // Grouping
        Map<Integer, List<String>> wordsByLength = words.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Words grouped by length: " + wordsByLength);
        
        // Partitioning
        Map<Boolean, List<String>> longWords = words.stream()
            .collect(Collectors.partitioningBy(word -> word.length() > 5));
        System.out.println("Words partitioned by length > 5: " + longWords);
        
        // Custom collector example
        String concatenated = words.stream()
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Concatenated words: " + concatenated);
        
        // Nested grouping
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "Engineering"),
            new Person("Bob", 30, "Marketing"),
            new Person("Charlie", 25, "Engineering"),
            new Person("Diana", 35, "Marketing"),
            new Person("Eve", 28, "Engineering")
        );
        
        Map<String, Map<Integer, List<Person>>> nestedGrouping = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.groupingBy(Person::getAge)
            ));
        System.out.println("People grouped by department then age: " + nestedGrouping);
        
        // Downstream collectors
        Map<String, Double> avgAgeByDept = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.averagingInt(Person::getAge)
            ));
        System.out.println("Average age by department: " + avgAgeByDept);
    }
    
    // 11. Advanced Collectors
    public static void demonstrateCollectors() {
        System.out.println("\n11. Advanced Collectors:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Collecting to different collection types
        Set<Integer> evenSet = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toSet());
        System.out.println("Even numbers set: " + evenSet);
        
        // Collecting to TreeSet for ordering
        TreeSet<Integer> sortedEvens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Sorted even numbers: " + sortedEvens);
        
        // Collecting to Map
        Map<Integer, String> numberMap = numbers.stream()
            .collect(Collectors.toMap(
                n -> n,
                n -> n % 2 == 0 ? "Even" : "Odd"
            ));
        System.out.println("Number to even/odd map: " + numberMap);
        
        // Custom collector using Collector.of()
        List<String> words = Arrays.asList("java", "stream", "collection", "map", "filter");
        
        // Count vowels in all words
        Integer vowelCount = words.stream()
            .collect(Collector.of(
                () -> new int[1], // supplier - mutable container
                (container, word) -> { // accumulator
                    for (char c : word.toCharArray()) {
                        if ("aeiouAEIOU".indexOf(c) >= 0) {
                            container[0]++;
                        }
                    }
                },
                (container1, container2) -> { // combiner for parallel
                    container1[0] += container2[0];
                    return container1;
                },
                container -> container[0] // finisher
            ));
        System.out.println("Total vowels in all words: " + vowelCount);
        
        // Using teeing collector (Java 12+)
        // Commented out as it requires Java 12+
        /*
        Map<String, Object> minMax = numbers.stream()
            .collect(Collectors.teeing(
                Collectors.minBy(Integer::compareTo),
                Collectors.maxBy(Integer::compareTo),
                (min, max) -> Map.of("min", min.orElse(0), "max", max.orElse(0))
            ));
        System.out.println("Min and Max: " + minMax);
        */
    }
    
    // 12. Parallel Streams
    public static void demonstrateParallelStreams() {
        System.out.println("\n12. Parallel Streams:");
        
        List<Integer> largeList = IntStream.rangeClosed(1, 10_000_000)
            .boxed()
            .collect(Collectors.toList());
        
        // Sequential stream
        long start = System.currentTimeMillis();
        long sequentialSum = largeList.stream()
            .mapToLong(Integer::longValue)
            .sum();
        long sequentialTime = System.currentTimeMillis() - start;
        
        // Parallel stream
        start = System.currentTimeMillis();
        long parallelSum = largeList.parallelStream()
            .mapToLong(Integer::longValue)
            .sum();
        long parallelTime = System.currentTimeMillis() - start;
        
        System.out.println("Sequential sum: " + sequentialSum + " (time: " + sequentialTime + "ms)");
        System.out.println("Parallel sum: " + parallelSum + " (time: " + parallelTime + "ms)");
        System.out.println("Speedup: " + (double) sequentialTime / parallelTime + "x");
        
        // Parallel stream considerations
        System.out.println("\nParallel Stream Considerations:");
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        
        // When NOT to use parallel streams
        List<String> shortList = Arrays.asList("a", "b", "c", "d", "e");
        
        start = System.nanoTime();
        shortList.stream().map(String::toUpperCase).collect(Collectors.toList());
        long shortSequential = System.nanoTime() - start;
        
        start = System.nanoTime();
        shortList.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        long shortParallel = System.nanoTime() - start;
        
        System.out.println("Short list - Sequential: " + shortSequential + "ns");
        System.out.println("Short list - Parallel: " + shortParallel + "ns");
        System.out.println("Overhead makes parallel slower for small datasets");
    }
    
    // 13. Concurrent Collections
    public static void demonstrateConcurrentCollections() {
        System.out.println("\n13. Concurrent Collections:");
        
        // ConcurrentHashMap
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        
        // Thread-safe operations
        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);
        concurrentMap.put("C", 3);
        
        // Atomic operations
        concurrentMap.compute("A", (key, value) -> value * 2);
        concurrentMap.putIfAbsent("D", 4);
        concurrentMap.merge("B", 10, Integer::sum);
        
        System.out.println("ConcurrentHashMap: " + concurrentMap);
        
        // Parallel operations on ConcurrentHashMap
        concurrentMap.forEach(1, (key, value) -> 
            System.out.println("Parallel forEach: " + key + " = " + value));
        
        // Search operation
        String result = concurrentMap.search(1, (key, value) -> 
            value > 5 ? key : null);
        System.out.println("First key with value > 5: " + result);
        
        // Reduce operation
        Integer sum = concurrentMap.reduce(1, 
            (key, value) -> value,  // transformer
            0,                      // basis
            Integer::sum);          // reducer
        System.out.println("Sum of all values: " + sum);
        
        // Other concurrent collections
        System.out.println("\nOther Concurrent Collections:");
        System.out.println("- ConcurrentLinkedQueue: Thread-safe queue");
        System.out.println("- ConcurrentLinkedDeque: Thread-safe deque");
        System.out.println("- ConcurrentSkipListMap: Thread-safe sorted map");
        System.out.println("- ConcurrentSkipListSet: Thread-safe sorted set");
        System.out.println("- CopyOnWriteArrayList: Thread-safe list (read-heavy scenarios)");
        System.out.println("- CopyOnWriteArraySet: Thread-safe set (read-heavy scenarios)");
    }
    
    // 14. Custom Comparators
    public static void demonstrateComparators() {
        System.out.println("\n14. Custom Comparators:");
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "Engineering"),
            new Person("Bob", 30, "Marketing"),
            new Person("Charlie", 25, "Engineering"),
            new Person("Diana", 35, "Marketing"),
            new Person("Eve", 28, "Engineering")
        );
        
        System.out.println("Original list: " + people);
        
        // Sort by age
        List<Person> sortedByAge = people.stream()
            .sorted(Comparator.comparing(Person::getAge))
            .collect(Collectors.toList());
        System.out.println("Sorted by age: " + sortedByAge);
        
        // Sort by age descending
        List<Person> sortedByAgeDesc = people.stream()
            .sorted(Comparator.comparing(Person::getAge).reversed())
            .collect(Collectors.toList());
        System.out.println("Sorted by age (descending): " + sortedByAgeDesc);
        
        // Multiple criteria sorting
        List<Person> sortedMultiple = people.stream()
            .sorted(Comparator.comparing(Person::getDepartment)
                    .thenComparing(Person::getAge)
                    .thenComparing(Person::getName))
            .collect(Collectors.toList());
        System.out.println("Sorted by dept, then age, then name: " + sortedMultiple);
        
        // Null-safe comparator
        List<Person> peopleWithNull = new ArrayList<>(people);
        peopleWithNull.add(new Person(null, 40, "Sales"));
        
        List<Person> nullSafeSorted = peopleWithNull.stream()
            .sorted(Comparator.comparing(Person::getName, 
                    Comparator.nullsLast(String::compareTo)))
            .collect(Collectors.toList());
        System.out.println("Null-safe sorted: " + nullSafeSorted);
        
        // Custom comparator with lambda
        Comparator<Person> customComparator = (p1, p2) -> {
            // First compare by department length
            int deptCompare = Integer.compare(p1.getDepartment().length(), p2.getDepartment().length());
            if (deptCompare != 0) return deptCompare;
            
            // Then by age (descending)
            return Integer.compare(p2.getAge(), p1.getAge());
        };
        
        List<Person> customSorted = people.stream()
            .sorted(customComparator)
            .collect(Collectors.toList());
        System.out.println("Custom sorted (dept length, then age desc): " + customSorted);
    }
    
    // 15. Custom Collections and Best Practices
    public static void demonstrateCustomCollections() {
        System.out.println("\n15. Custom Collections:");
        
        // Using Collections utility methods
        List<String> list = new ArrayList<>(Arrays.asList("C", "A", "B", "D"));
        System.out.println("Original: " + list);
        
        Collections.sort(list);
        System.out.println("Sorted: " + list);
        
        Collections.reverse(list);
        System.out.println("Reversed: " + list);
        
        Collections.shuffle(list);
        System.out.println("Shuffled: " + list);
        
        // Binary search (requires sorted list)
        Collections.sort(list);
        int index = Collections.binarySearch(list, "B");
        System.out.println("Index of 'B': " + index);
        
        // Immutable collections
        List<String> immutableList = Collections.unmodifiableList(new ArrayList<>(list));
        System.out.println("Immutable list: " + immutableList);
        
        // Singleton collections
        Set<String> singletonSet = Collections.singleton("OnlyElement");
        System.out.println("Singleton set: " + singletonSet);
        
        // Empty collections
        List<String> emptyList = Collections.emptyList();
        Set<String> emptySet = Collections.emptySet();
        Map<String, String> emptyMap = Collections.emptyMap();
        
        // Synchronized collections
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        System.out.println("Synchronized collections should be manually synchronized during iteration");
        
        // Custom collection example
        CircularBuffer<Integer> circularBuffer = new CircularBuffer<>(3);
        circularBuffer.add(1);
        circularBuffer.add(2);
        circularBuffer.add(3);
        circularBuffer.add(4); // This will overwrite the first element
        System.out.println("Circular buffer: " + circularBuffer);
    }
    
    // 16. Best Practices
    public static void demonstrateBestPractices() {
        System.out.println("\n16. Collections Best Practices:");
        
        System.out.println("1. Choose the right collection type:");
        System.out.println("   - ArrayList for indexed access");
        System.out.println("   - LinkedList for frequent insertions/deletions");
        System.out.println("   - HashMap for fast key-value lookups");
        System.out.println("   - TreeMap for sorted key-value pairs");
        System.out.println("   - HashSet for unique elements with fast access");
        System.out.println("   - TreeSet for unique sorted elements");
        
        System.out.println("\n2. Specify initial capacity when size is known:");
        List<String> list = new ArrayList<>(1000); // Avoids resizing
        Map<String, String> map = new HashMap<>(16, 0.75f); // Custom load factor
        
        System.out.println("\n3. Use interface types for declarations:");
        List<String> goodPractice = new ArrayList<>(); // Good
        // ArrayList<String> badPractice = new ArrayList<>(); // Avoid this
        
        System.out.println("\n4. Prefer immutable collections when possible:");
        List<String> immutableList = List.of("A", "B", "C"); // Java 9+
        Set<String> immutableSet = Set.of("X", "Y", "Z");
        Map<String, Integer> immutableMap = Map.of("One", 1, "Two", 2);
        
        System.out.println("\n5. Use appropriate methods:");
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        
        // Good: use enhanced for loop for simple iteration
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
        
        // Good: use streams for complex operations
        long longWords = words.stream()
            .filter(word -> word.length() > 5)
            .count();
        System.out.println("Long words count: " + longWords);
        
        System.out.println("\n6. Be careful with concurrent access:");
        System.out.println("   - Use ConcurrentHashMap instead of synchronized HashMap");
        System.out.println("   - Use CopyOnWriteArrayList for read-heavy scenarios");
        System.out.println("   - Synchronize iteration over synchronized collections");
        
        System.out.println("\n7. Override equals() and hashCode() for custom objects in Hash collections");
        System.out.println("8. Consider memory usage - LinkedList uses more memory per element");
        System.out.println("9. Use primitive specialized collections (TIntArrayList from Trove) for performance");
        System.out.println("10. Prefer composition over inheritance when creating custom collections");
    }
    
    // Helper method for generics demonstration
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // Helper method for wildcards
    public static double sumNumbers(List<? extends Number> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }
    
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }
    
    public static void printList(List<?> list) {
        System.out.println("List contents: " + list);
    }
    
    // Generic class example
    static class Box<T> {
        private T content;
        
        public Box(T content) {
            this.content = content;
        }
        
        public T get() {
            return content;
        }
        
        public void set(T content) {
            this.content = content;
        }
    }
    
    // Bounded type parameter example
    static class NumberProcessor<T extends Number> {
        public T findMax(List<T> numbers) {
            return numbers.stream()
                .max((a, b) -> Double.compare(a.doubleValue(), b.doubleValue()))
                .orElse(null);
        }
        
        public double calculateAverage(List<T> numbers) {
            return numbers.stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .orElse(0.0);
        }
    }
    
    // Multiple bounds example
    static class ComparableProcessor<T extends Comparable<T>> {
        public T findMaxComparable(List<T> items) {
            return items.stream().max(T::compareTo).orElse(null);
        }
    }
    
    // Intersection types (multiple bounds)
    static class Processor<T extends Comparable<T> & java.io.Serializable> {
        public List<T> processComparableSerializable(List<T> items) {
            return items.stream()
                .sorted()
                .collect(Collectors.toList());
        }
    }
    
    // Person class for examples
    static class Person {
        private String name;
        private int age;
        private String department;
        
        public Person(String name, int age, String department) {
            this.name = name;
            this.age = age;
            this.department = department;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getDepartment() { return department; }
        
        @Override
        public String toString() {
            return name + "(" + age + ", " + department + ")";
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person person = (Person) obj;
            return age == person.age &&
                   Objects.equals(name, person.name) &&
                   Objects.equals(department, person.department);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(name, age, department);
        }
    }
    
    // LRU Cache implementation
    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;
        
        public LRUCache(int capacity) {
            super(16, 0.75f, true); // access-order
            this.capacity = capacity;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }
    
    // Circular Buffer implementation
    static class CircularBuffer<T> {
        private final Object[] buffer;
        private final int capacity;
        private int head = 0;
        private int tail = 0;
        private int size = 0;
        
        public CircularBuffer(int capacity) {
            this.capacity = capacity;
            this.buffer = new Object[capacity];
        }
        
        public void add(T item) {
            buffer[tail] = item;
            tail = (tail + 1) % capacity;
            
            if (size < capacity) {
                size++;
            } else {
                head = (head + 1) % capacity; // Overwrite oldest
            }
        }
        
        @SuppressWarnings("unchecked")
        public T get(int index) {
            if (index >= size) throw new IndexOutOfBoundsException();
            return (T) buffer[(head + index) % capacity];
        }
        
        public int size() {
            return size;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                if (i > 0) sb.append(", ");
                sb.append(get(i));
            }
            sb.append("]");
            return sb.toString();
        }
    }
}

/*
 * Key Points - Part 2:
 * 
 * MAP INTERFACE:
 * 1. HashMap: O(1) access, no ordering, allows one null key and multiple null values
 * 2. LinkedHashMap: Maintains insertion/access order, slightly slower than HashMap
 * 3. TreeMap: O(log n) access, sorted by keys, no null keys allowed
 * 4. Hashtable: Legacy, synchronized, no null keys/values, use ConcurrentHashMap instead
 * 5. Use compute(), merge(), putIfAbsent() for atomic operations in concurrent scenarios
 * 
 * GENERICS:
 * 1. Provide compile-time type safety and eliminate casting
 * 2. Use wildcards: ? extends T (producer), ? super T (consumer), ? (unknown type)
 * 3. PECS rule: Producer Extends, Consumer Super
 * 4. Bounded type parameters: <T extends Number> restricts type parameter
 * 5. Type erasure removes generic type info at runtime, use with caution
 * 
 * STREAMS API:
 * 1. Functional approach to processing collections with filter, map, reduce operations
 * 2. Lazy evaluation: operations are not executed until terminal operation is called
 * 3. Parallel streams can improve performance for large datasets and CPU-intensive operations
 * 4. Use collectors for advanced reduction operations and grouping
 * 5. Avoid parallel streams for small datasets due to overhead
 * 
 * CONCURRENT COLLECTIONS:
 * 1. ConcurrentHashMap: Thread-safe, high performance, allows null values but not keys
 * 2. ConcurrentLinkedQueue: Lock-free thread-safe queue implementation
 * 3. CopyOnWriteArrayList: Best for read-heavy scenarios with infrequent modifications
 * 4. Use concurrent collections over synchronized collections for better performance
 * 5. Avoid blocking operations in highly concurrent environments
 * 
 * PERFORMANCE CONSIDERATIONS:
 * 1. ArrayList: O(1) access, O(n) insertion/deletion in middle, better cache locality
 * 2. LinkedList: O(n) access, O(1) insertion/deletion at known positions
 * 3. HashMap vs TreeMap: O(1) vs O(log n), use HashMap unless sorting is required
 * 4. HashSet vs TreeSet: O(1) vs O(log n), same trade-off as maps
 * 5. Specify initial capacity for ArrayList and HashMap when size is predictable
 * 
 * BEST PRACTICES:
 * 1. Program to interfaces (List, Set, Map) not implementations
 * 2. Use immutable collections (List.of(), Set.of(), Map.of()) when possible
 * 3. Override equals() and hashCode() for objects used as keys in hash-based collections
 * 4. Use appropriate collection type based on access patterns and requirements
 * 5. Prefer streams for complex data processing, enhanced for-loops for simple iteration
 * 6. Consider memory usage: primitive collections for better performance with large datasets
 * 7. Use Collections utility methods for common operations (sort, reverse, shuffle)
 * 8. Be aware of fail-fast iterators and concurrent modification exceptions
 * 9. Use try-with-resources for collections that implement AutoCloseable
 * 10. Consider using specialized libraries (Guava, Eclipse Collections) for advanced use cases
 */