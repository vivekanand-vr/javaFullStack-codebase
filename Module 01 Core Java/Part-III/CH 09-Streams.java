/*
 * Understanding Java Streams API - Complete Guide
 * Focus: Stream creation, intermediate operations, terminal operations, collectors, and advanced patterns
 */

/*
 * Stream API covers:
 * - Stream creation from various sources (collections, arrays, generators)
 * - Intermediate operations (filter, map, flatMap, sorted, distinct, etc.)
 * - Terminal operations (forEach, collect, reduce, findFirst, etc.)
 * - Collectors and custom collectors
 * - Parallel streams and performance considerations
 * - Optional class integration
 * - Advanced patterns and real-world examples
 * - Stream debugging and best practices
 * 
 * Stream Pipeline Structure:
 * Source -> Intermediate Operations -> Terminal Operation
 * 
 * Key Characteristics:
 * - Lazy evaluation: operations are not executed until terminal operation
 * - Functional approach: immutable operations, no side effects
 * - One-time use: streams are consumed after terminal operation
 * - Parallel processing support
 */

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;
import java.util.stream.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class StreamsAPIComplete {
    
    public static void main(String[] args) {
        System.out.println("Java Streams API - Complete Guide");
        
        // 1. Stream Creation
        System.out.println("\n=== STREAM CREATION ===");
        demonstrateStreamCreation();
        
        // 2. Intermediate Operations
        System.out.println("\n=== INTERMEDIATE OPERATIONS ===");
        demonstrateIntermediateOperations();
        
        // 3. Terminal Operations
        System.out.println("\n=== TERMINAL OPERATIONS ===");
        demonstrateTerminalOperations();
        
        // 4. Collectors
        System.out.println("\n=== COLLECTORS ===");
        demonstrateCollectors();
        
        // 5. Advanced Collectors
        System.out.println("\n=== ADVANCED COLLECTORS ===");
        demonstrateAdvancedCollectors();
        
        // 6. Parallel Streams
        System.out.println("\n=== PARALLEL STREAMS ===");
        demonstrateParallelStreams();
        
        // 7. Optional Integration
        System.out.println("\n=== OPTIONAL INTEGRATION ===");
        demonstrateOptionalIntegration();
        
        // 8. Real-world Examples
        System.out.println("\n=== REAL-WORLD EXAMPLES ===");
        demonstrateRealWorldExamples();
        
        // 9. Stream Debugging
        System.out.println("\n=== STREAM DEBUGGING ===");
        demonstrateStreamDebugging();
        
        // 10. Best Practices and Performance
        System.out.println("\n=== BEST PRACTICES ===");
        demonstrateBestPractices();
    }
    
    // 1. Stream Creation Methods
    public static void demonstrateStreamCreation() {
        System.out.println("\n1. Stream Creation Methods:");
        
        // From Collections
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        Stream<String> fromList = list.stream();
        System.out.println("From List: " + fromList.collect(Collectors.toList()));
        
        // From Arrays
        String[] array = {"dog", "elephant", "fox"};
        Stream<String> fromArray = Arrays.stream(array);
        System.out.println("From Array: " + fromArray.collect(Collectors.toList()));
        
        // From specific range of array
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntStream fromArrayRange = Arrays.stream(numbers, 2, 7); // from index 2 to 6
        System.out.println("From Array Range: " + fromArrayRange.boxed().collect(Collectors.toList()));
        
        // Using Stream.of()
        Stream<Integer> fromOf = Stream.of(1, 2, 3, 4, 5);
        System.out.println("From Stream.of(): " + fromOf.collect(Collectors.toList()));
        
        // Empty Stream
        Stream<String> emptyStream = Stream.empty();
        System.out.println("Empty Stream count: " + emptyStream.count());
        
        // Infinite Streams
        // Stream.generate() - generates infinite stream with supplier
        Stream<Double> randomNumbers = Stream.generate(Math::random).limit(5);
        System.out.println("Random numbers: " + randomNumbers.collect(Collectors.toList()));
        
        // Stream.iterate() - generates infinite stream with seed and function
        Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2).limit(10);
        System.out.println("Even numbers: " + evenNumbers.collect(Collectors.toList()));
        
        // Stream.iterate() with predicate (Java 9+)
        // Stream<Integer> limitedIterate = Stream.iterate(1, n -> n <= 100, n -> n * 2);
        // System.out.println("Powers of 2: " + limitedIterate.collect(Collectors.toList()));
        
        // Primitive Streams
        IntStream intStream = IntStream.range(1, 6); // 1 to 5
        System.out.println("IntStream range: " + intStream.boxed().collect(Collectors.toList()));
        
        IntStream intStreamClosed = IntStream.rangeClosed(1, 5); // 1 to 5 inclusive
        System.out.println("IntStream rangeClosed: " + intStreamClosed.boxed().collect(Collectors.toList()));
        
        LongStream longStream = LongStream.of(1L, 2L, 3L, 4L, 5L);
        System.out.println("LongStream: " + longStream.boxed().collect(Collectors.toList()));
        
        DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5);
        System.out.println("DoubleStream: " + doubleStream.boxed().collect(Collectors.toList()));
        
        // From String characters
        IntStream charStream = "Hello".chars();
        System.out.println("Char codes: " + charStream.boxed().collect(Collectors.toList()));
        
        // From lines (useful for file processing)
        Stream<String> lines = "Line1\nLine2\nLine3".lines();
        System.out.println("Lines: " + lines.collect(Collectors.toList()));
        
        // Builder pattern
        Stream<String> builtStream = Stream.<String>builder()
            .add("Java")
            .add("Python")
            .add("JavaScript")
            .build();
        System.out.println("Built stream: " + builtStream.collect(Collectors.toList()));
    }
    
    // 2. Intermediate Operations
    public static void demonstrateIntermediateOperations() {
        System.out.println("\n2. Intermediate Operations:");
        
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4);
        
        // filter() - filters elements based on predicate
        System.out.println("Words with length > 5: " + 
            words.stream().filter(w -> w.length() > 5).collect(Collectors.toList()));
        
        System.out.println("Even numbers: " + 
            numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList()));
        
        // map() - transforms each element
        System.out.println("Uppercase words: " + 
            words.stream().map(String::toUpperCase).collect(Collectors.toList()));
        
        System.out.println("Squared numbers: " + 
            numbers.stream().map(n -> n * n).collect(Collectors.toList()));
        
        // mapToInt/Long/Double - converts to primitive streams
        System.out.println("Word lengths: " + 
            words.stream().mapToInt(String::length).boxed().collect(Collectors.toList()));
        
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("Average of numbers: " + average);
        
        // flatMap() - flattens nested structures
        List<List<String>> nestedLists = Arrays.asList(
            Arrays.asList("a", "b", "c"),
            Arrays.asList("d", "e", "f"),
            Arrays.asList("g", "h", "i")
        );
        
        System.out.println("Flattened lists: " + 
            nestedLists.stream().flatMap(List::stream).collect(Collectors.toList()));
        
        // flatMap with string splitting
        List<String> sentences = Arrays.asList("Hello world", "Java streams", "Functional programming");
        System.out.println("All words: " + 
            sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList()));
        
        // distinct() - removes duplicates
        System.out.println("Distinct numbers: " + 
            numbers.stream().distinct().collect(Collectors.toList()));
        
        // sorted() - sorts elements
        System.out.println("Sorted words: " + 
            words.stream().sorted().collect(Collectors.toList()));
        
        System.out.println("Sorted by length: " + 
            words.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()));
        
        System.out.println("Reverse sorted: " + 
            numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        
        // peek() - performs action on each element (for debugging)
        System.out.println("Numbers with peek: " + 
            numbers.stream()
                .filter(n -> n > 5)
                .peek(n -> System.out.print("Filtered: " + n + " "))
                .map(n -> n * 2)
                .peek(n -> System.out.print("Mapped: " + n + " "))
                .collect(Collectors.toList()));
        System.out.println();
        
        // limit() - limits stream size
        System.out.println("First 3 words: " + 
            words.stream().limit(3).collect(Collectors.toList()));
        
        // skip() - skips elements
        System.out.println("Skip first 3 words: " + 
            words.stream().skip(3).collect(Collectors.toList()));
        
        // takeWhile() and dropWhile() - Java 9+ (commented for compatibility)
        // System.out.println("Take while length <= 6: " + 
        //     words.stream().takeWhile(w -> w.length() <= 6).collect(Collectors.toList()));
        
        // Chaining operations
        System.out.println("Complex chain - words > 4 chars, uppercase, sorted: " +
            words.stream()
                .filter(w -> w.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList()));
    }
    
    // 3. Terminal Operations
    public static void demonstrateTerminalOperations() {
        System.out.println("\n3. Terminal Operations:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        
        // forEach() - performs action on each element
        System.out.print("Numbers: ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // forEachOrdered() - maintains order in parallel streams
        System.out.print("Ordered parallel: ");
        numbers.parallelStream().forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();
        
        // collect() - collects to various data structures
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Collected even numbers: " + evenNumbers);
        
        // toArray() - converts to array
        String[] wordArray = words.stream()
            .filter(w -> w.length() > 5)
            .toArray(String[]::new);
        System.out.println("Word array: " + Arrays.toString(wordArray));
        
        // reduce() operations
        // reduce with identity
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum using reduce: " + sum);
        
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product using reduce: " + product);
        
        // reduce without identity (returns Optional)
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("Max value: " + max.orElse(0));
        
        Optional<String> concatenated = words.stream().reduce((w1, w2) -> w1 + ", " + w2);
        System.out.println("Concatenated words: " + concatenated.orElse(""));
        
        // Complex reduce example
        Optional<Integer> sumOfSquares = numbers.stream()
            .map(n -> n * n)
            .reduce(Integer::sum);
        System.out.println("Sum of squares: " + sumOfSquares.orElse(0));
        
        // count() - counts elements
        long evenCount = numbers.stream().filter(n -> n % 2 == 0).count();
        System.out.println("Count of even numbers: " + evenCount);
        
        // min() and max()
        Optional<Integer> minNumber = numbers.stream().min(Integer::compareTo);
        Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);
        System.out.println("Min: " + minNumber.orElse(0) + ", Max: " + maxNumber.orElse(0));
        
        Optional<String> longestWord = words.stream().max(Comparator.comparing(String::length));
        System.out.println("Longest word: " + longestWord.orElse(""));
        
        // findFirst() and findAny()
        Optional<Integer> firstEven = numbers.stream().filter(n -> n % 2 == 0).findFirst();
        System.out.println("First even number: " + firstEven.orElse(0));
        
        Optional<Integer> anyOdd = numbers.stream().filter(n -> n % 2 == 1).findAny();
        System.out.println("Any odd number: " + anyOdd.orElse(0));
        
        // anyMatch(), allMatch(), noneMatch()
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Has even numbers: " + hasEven);
        
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("All positive: " + allPositive);
        
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("None negative: " + noneNegative);
        
        // Primitive stream specific operations
        IntSummaryStatistics stats = numbers.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
        System.out.println("Statistics: " + stats);
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin() + ", Max: " + stats.getMax());
    }
    
    // 4. Basic Collectors
    public static void demonstrateCollectors() {
        System.out.println("\n4. Basic Collectors:");
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "Engineering", 75000),
            new Person("Bob", 30, "Marketing", 65000),
            new Person("Charlie", 35, "Engineering", 85000),
            new Person("Diana", 28, "Sales", 60000),
            new Person("Eve", 32, "Marketing", 70000),
            new Person("Frank", 29, "Engineering", 80000)
        );
        
        // toList(), toSet(), toCollection()
        List<String> names = people.stream()
            .map(Person::getName)
            .collect(Collectors.toList());
        System.out.println("Names: " + names);
        
        Set<String> departments = people.stream()
            .map(Person::getDepartment)
            .collect(Collectors.toSet());
        System.out.println("Departments: " + departments);
        
        ArrayList<String> namesList = people.stream()
            .map(Person::getName)
            .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Names ArrayList: " + namesList);
        
        // toMap()
        Map<String, Integer> nameToAge = people.stream()
            .collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println("Name to Age map: " + nameToAge);
        
        // toMap with duplicate key resolver
        Map<String, Double> deptToMaxSalary = people.stream()
            .collect(Collectors.toMap(
                Person::getDepartment,
                Person::getSalary,
                Double::max
            ));
        System.out.println("Department to max salary: " + deptToMaxSalary);
        
        // toMap with custom map type
        LinkedHashMap<String, Integer> orderedMap = people.stream()
            .sorted(Comparator.comparing(Person::getAge))
            .collect(Collectors.toMap(
                Person::getName,
                Person::getAge,
                (existing, replacement) -> existing,
                LinkedHashMap::new
            ));
        System.out.println("Ordered name to age: " + orderedMap);
        
        // joining()
        String allNames = people.stream()
            .map(Person::getName)
            .collect(Collectors.joining());
        System.out.println("All names joined: " + allNames);
        
        String namesWithSeparator = people.stream()
            .map(Person::getName)
            .collect(Collectors.joining(", "));
        System.out.println("Names with comma: " + namesWithSeparator);
        
        String namesWithPrefixSuffix = people.stream()
            .map(Person::getName)
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Names with brackets: " + namesWithPrefixSuffix);
        
        // counting()
        long totalPeople = people.stream().collect(Collectors.counting());
        System.out.println("Total people: " + totalPeople);
        
        // summarizing statistics
        DoubleSummaryStatistics salaryStats = people.stream()
            .collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("Salary statistics: " + salaryStats);
        
        IntSummaryStatistics ageStats = people.stream()
            .collect(Collectors.summarizingInt(Person::getAge));
        System.out.println("Age statistics: " + ageStats);
        
        // averaging
        double avgSalary = people.stream()
            .collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println("Average salary: " + avgSalary);
        
        // summing
        double totalSalary = people.stream()
            .collect(Collectors.summingDouble(Person::getSalary));
        System.out.println("Total salary: " + totalSalary);
        
        // min/max by
        Optional<Person> youngest = people.stream()
            .collect(Collectors.minBy(Comparator.comparing(Person::getAge)));
        System.out.println("Youngest: " + youngest.map(Person::getName).orElse("None"));
        
        Optional<Person> highestPaid = people.stream()
            .collect(Collectors.maxBy(Comparator.comparing(Person::getSalary)));
        System.out.println("Highest paid: " + highestPaid.map(Person::getName).orElse("None"));
    }
    
    // 5. Advanced Collectors
    public static void demonstrateAdvancedCollectors() {
        System.out.println("\n5. Advanced Collectors:");
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "Engineering", 75000),
            new Person("Bob", 30, "Marketing", 65000),
            new Person("Charlie", 35, "Engineering", 85000),
            new Person("Diana", 28, "Sales", 60000),
            new Person("Eve", 32, "Marketing", 70000),
            new Person("Frank", 29, "Engineering", 80000),
            new Person("Grace", 27, "Sales", 62000)
        );
        
        // groupingBy() - simple grouping
        Map<String, List<Person>> byDepartment = people.stream()
            .collect(Collectors.groupingBy(Person::getDepartment));
        System.out.println("Grouped by department: " + byDepartment);
        
        // groupingBy() with downstream collector
        Map<String, Long> countByDepartment = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.counting()
            ));
        System.out.println("Count by department: " + countByDepartment);
        
        Map<String, Double> avgSalaryByDept = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.averagingDouble(Person::getSalary)
            ));
        System.out.println("Average salary by department: " + avgSalaryByDept);
        
        // Multiple level grouping
        Map<String, Map<String, List<Person>>> multiLevelGrouping = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.groupingBy(person -> person.getAge() < 30 ? "Young" : "Senior")
            ));
        System.out.println("Multi-level grouping: " + multiLevelGrouping);
        
        // groupingBy with custom collector
        Map<String, Set<String>> namesByDept = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.mapping(Person::getName, Collectors.toSet())
            ));
        System.out.println("Names by department: " + namesByDept);
        
        // partitioningBy() - splits into two groups based on predicate
        Map<Boolean, List<Person>> partitionByAge = people.stream()
            .collect(Collectors.partitioningBy(person -> person.getAge() > 30));
        System.out.println("Partitioned by age > 30: " + partitionByAge);
        
        Map<Boolean, Double> avgSalaryByAgeGroup = people.stream()
            .collect(Collectors.partitioningBy(
                person -> person.getAge() > 30,
                Collectors.averagingDouble(Person::getSalary)
            ));
        System.out.println("Average salary by age group: " + avgSalaryByAgeGroup);
        
        // filtering() collector (Java 9+ - using alternative approach)
        Map<String, List<Person>> seniorsByDept = people.stream()
            .filter(person -> person.getAge() > 30)
            .collect(Collectors.groupingBy(Person::getDepartment));
        System.out.println("Seniors by department: " + seniorsByDept);
        
        // collectingAndThen() - applies transformation to collected result
        List<Person> immutablePeople = people.stream()
            .collect(Collectors.collectingAndThen(
                Collectors.toList(),
                Collections::unmodifiableList
            ));
        System.out.println("Immutable list size: " + immutablePeople.size());
        
        String summary = people.stream()
            .collect(Collectors.collectingAndThen(
                Collectors.groupingBy(Person::getDepartment, Collectors.counting()),
                map -> "Departments: " + map.size() + ", Total people: " + map.values().stream().mapToLong(Long::longValue).sum()
            ));
        System.out.println("Summary: " + summary);
        
        // Custom collector example - collecting to custom data structure
        Map<String, PersonSummary> summaryByDept = people.stream()
            .collect(Collectors.groupingBy(
                Person::getDepartment,
                Collector.of(
                    PersonSummary::new,
                    PersonSummary::accept,
                    PersonSummary::combine,
                    Function.identity()
                )
            ));
        System.out.println("Person summary by department: " + summaryByDept);
    }
    
    // 6. Parallel Streams
    public static void demonstrateParallelStreams() {
        System.out.println("\n6. Parallel Streams:");
        
        List<Integer> largeList = IntStream.rangeClosed(1, 10_000_000)
            .boxed()
            .collect(Collectors.toList());
        
        // Sequential vs Parallel processing
        long startTime = System.currentTimeMillis();
        long sequentialSum = largeList.stream()
            .mapToLong(Integer::longValue)
            .sum();
        long sequentialTime = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        long parallelSum = largeList.parallelStream()
            .mapToLong(Integer::longValue)
            .sum();
        long parallelTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Sequential sum: " + sequentialSum + " (Time: " + sequentialTime + "ms)");
        System.out.println("Parallel sum: " + parallelSum + " (Time: " + parallelTime + "ms)");
        System.out.println("Speedup: " + (double) sequentialTime / parallelTime + "x");
        
        // Complex computation example
        startTime = System.currentTimeMillis();
        double sequentialResult = IntStream.rangeClosed(1, 1_000_000)
            .mapToDouble(i -> Math.sqrt(i) * Math.sin(i))
            .sum();
        long complexSequentialTime = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        double parallelResult = IntStream.rangeClosed(1, 1_000_000)
            .parallel()
            .mapToDouble(i -> Math.sqrt(i) * Math.sin(i))
            .sum();
        long complexParallelTime = System.currentTimeMillis() - startTime;
        
        System.out.println("\nComplex computation:");
        System.out.println("Sequential result: " + sequentialResult + " (Time: " + complexSequentialTime + "ms)");
        System.out.println("Parallel result: " + parallelResult + " (Time: " + complexParallelTime + "ms)");
        System.out.println("Complex speedup: " + (double) complexSequentialTime / complexParallelTime + "x");
        
        // Parallel stream characteristics
        System.out.println("\nParallel stream info:");
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        
        // Converting between sequential and parallel
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        
        List<String> upperCase = words.stream()
            .parallel()          // Make parallel
            .map(String::toUpperCase)
            .sequential()        // Back to sequential
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Converted stream result: " + upperCase);
        
        // Parallel reduction considerations
        System.out.println("\nParallel reduction considerations:");
        
        // Good for parallel - associative operation
        String concatenated = words.parallelStream()
            .reduce("", (a, b) -> a + b);
        System.out.println("Parallel concatenation: " + concatenated);
        
        // Better approach for concatenation in parallel
        String betterConcatenated = words.parallelStream()
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
        System.out.println("Better parallel concatenation: " + betterConcatenated);
        
        // Thread safety concerns
        // Avoid: List<Integer> results = new ArrayList<>(); // Not thread-safe
        // Better: Use collect() or thread-safe collections
        
        List<Integer> threadSafeResults = IntStream.rangeClosed(1, 100)
            .parallel()
            .filter(i -> i % 2 == 0)
            .boxed()
            .collect(Collectors.toList());
        System.out.println("Thread-safe parallel results size: " + threadSafeResults.size());
    }
    
    // 7. Optional Integration
    public static void demonstrateOptionalIntegration() {
        System.out.println("\n7. Optional Integration:");
        
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> emptyList = Arrays.asList();
        
        // findFirst() and findAny() return Optional
        Optional<String> firstLongWord = words.stream()
            .filter(w -> w.length() > 6)
            .findFirst();
        
        System.out.println("First long word: " + firstLongWord.orElse("None found"));
        
        // Using Optional methods
        firstLongWord.ifPresent(word -> System.out.println("Found long word: " + word));
        
        String result = firstLongWord
            .map(String::toUpperCase)
            .orElse("DEFAULT");
        System.out.println("Mapped result: " + result);
        
        // flatMap with Optional
        Optional<String> firstWordFirstChar = words.stream()
            .findFirst()
            .filter(w -> !w.isEmpty())
            .map(w -> w.substring(0, 1));
        System.out.println("First character of first word: " + firstWordFirstChar.orElse(""));
        
        // reduce() returns Optional when no identity provided
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);
        sum.ifPresentOrElse(
            s -> System.out.println("Sum: " + s),
            () -> System.out.println("Empty stream")
        );
        
        // Optional with empty streams
        Optional<String> emptyResult = emptyList.stream()
            .filter(w -> w.length() > 3)
            .findFirst();
        System.out.println("Empty stream result: " + emptyResult.orElse("Nothing found"));
        
        // Chaining Optional operations
        Optional<Integer> chainedResult = words.stream()
            .filter(w -> w.startsWith("a"))
            .findFirst()
            .map(String::length)
            .filter(length -> length > 4);
        
        chainedResult.ifPresentOrElse(
            length -> System.out.println("Length of first 'a' word > 4: " + length),
            () -> System.out.println("No 'a' word with length > 4")
        );
        
        // Optional in stream processing
        List<Optional<Integer>> optionalNumbers = Arrays.asList(
            Optional.of(1), Optional.empty(), Optional.of(3), Optional.empty(), Optional.of(5)
        );
        
        List<Integer> presentNumbers = optionalNumbers.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
        System.out.println("Present numbers: " + presentNumbers);
        
        // Better approach using flatMap
        List<Integer> flatMappedNumbers = optionalNumbers.stream()
            .flatMap(Optional::stream) // Java 9+ feature
            .collect(Collectors.toList());
        // For Java 8 compatibility:
        List<Integer> java8Approach = optionalNumbers.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
        System.out.println("FlatMapped numbers: " + java8Approach);
    }
    
    // 8. Real-world Examples
    public static void demonstrateRealWorldExamples() {
        System.out.println("\n8. Real-world Examples:");
        
        // Example 1: E-commerce Order Processing
        List<Order> orders = Arrays.asList(
            new Order("ORD001", "Alice", LocalDate.of(2024, 1, 15), 150.0, "COMPLETED"),
            new Order("ORD002", "Bob", LocalDate.of(2024, 1, 16), 75.0, "PENDING"),
            new Order("ORD003", "Charlie", LocalDate.of(2024, 1, 17), 200.0, "COMPLETED"),
            new Order("ORD004", "Alice", LocalDate.of(2024, 1, 18), 50.0, "CANCELLED"),
            new Order("ORD005", "Diana", LocalDate.of(2024, 1, 19), 300.0, "COMPLETED"),
            new Order("ORD006", "Bob", LocalDate.of(2024, 1, 20), 125.0, "COMPLETED")
        );
        
        System.out.println("=== E-commerce Order Analysis ===");
        
        // Total revenue from completed orders
        double totalRevenue = orders.stream()
            .filter(order -> "COMPLETED".equals(order.getStatus()))
            .mapToDouble(Order::getAmount)
            .sum();
        System.out.println("Total revenue: $" + totalRevenue);
        
        // Top customers by total order amount
        Map<String, Double> customerTotals = orders.stream()
            .filter(order -> "COMPLETED".equals(order.getStatus()))
            .collect(Collectors.groupingBy(
                Order::getCustomer,
                Collectors.summingDouble(Order::getAmount)
            ));
        
        customerTotals.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .limit(3)
            .forEach(entry -> System.out.println("Customer: " + entry.getKey() + 
                ", Total: $" + entry.getValue()));
        
        // Orders by month
        Map<Month, Long> ordersByMonth = orders.stream()
            .collect(Collectors.groupingBy(
                order -> order.getOrderDate().getMonth(),
                Collectors.counting()
            ));
        System.out.println("Orders by month: " + ordersByMonth);
        
        // Average order value by status
        Map<String, Double> avgByStatus = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getStatus,
                Collectors.averagingDouble(Order::getAmount)
            ));
        System.out.println("Average order value by status: " + avgByStatus);
        
        // Example 2: Log Analysis
        System.out.println("\n=== Log Analysis ===");
        List<LogEntry> logs = Arrays.asList(
            new LogEntry("2024-01-15 10:30:00", "INFO", "User login successful", "user123"),
            new LogEntry("2024-01-15 10:31:15", "ERROR", "Database connection failed", "system"),
            new LogEntry("2024-01-15 10:32:30", "WARN", "High memory usage detected", "system"),
            new LogEntry("2024-01-15 10:33:45", "INFO", "Order processed", "user456"),
            new LogEntry("2024-01-15 10:34:60", "ERROR", "Payment processing failed", "user789"),
            new LogEntry("2024-01-15 10:35:15", "INFO", "User logout", "user123")
        );
        
        // Error rate analysis
        Map<String, Long> logCounts = logs.stream()
            .collect(Collectors.groupingBy(LogEntry::getLevel, Collectors.counting()));
        
        double errorRate = logCounts.getOrDefault("ERROR", 0L) * 100.0 / logs.size();
        System.out.println("Error rate: " + String.format("%.2f%%", errorRate));
        
        // Most active users
        Map<String, Long> userActivity = logs.stream()
            .filter(log -> !"system".equals(log.getUser()))
            .collect(Collectors.groupingBy(LogEntry::getUser, Collectors.counting()));
        
        userActivity.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(entry -> System.out.println("User: " + entry.getKey() + 
                ", Activity: " + entry.getValue()));
        
        // Critical errors (ERROR level system messages)
        List<String> criticalErrors = logs.stream()
            .filter(log -> "ERROR".equals(log.getLevel()) && "system".equals(log.getUser()))
            .map(LogEntry::getMessage)
            .collect(Collectors.toList());
        System.out.println("Critical errors: " + criticalErrors);
        
        // Example 3: Student Grade Analysis
        System.out.println("\n=== Student Grade Analysis ===");
        List<Student> students = Arrays.asList(
            new Student("Alice", "Computer Science", Arrays.asList(85, 92, 78, 96)),
            new Student("Bob", "Mathematics", Arrays.asList(78, 84, 91, 87)),
            new Student("Charlie", "Physics", Arrays.asList(92, 89, 94, 88)),
            new Student("Diana", "Computer Science", Arrays.asList(76, 82, 79, 85)),
            new Student("Eve", "Mathematics", Arrays.asList(94, 97, 93, 91))
        );
        
        // Calculate GPA for each student
        Map<String, Double> studentGPAs = students.stream()
            .collect(Collectors.toMap(
                Student::getName,
                student -> student.getGrades().stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0)
            ));
        
        System.out.println("Student GPAs:");
        studentGPAs.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> System.out.println(entry.getKey() + ": " + 
                String.format("%.2f", entry.getValue())));
        
        // Department statistics
        Map<String, DoubleSummaryStatistics> deptStats = students.stream()
            .collect(Collectors.groupingBy(
                Student::getMajor,
                Collectors.summarizingDouble(student -> 
                    student.getGrades().stream().mapToInt(Integer::intValue).average().orElse(0.0))
            ));
        
        deptStats.forEach((dept, stats) -> 
            System.out.println(dept + " - Avg: " + String.format("%.2f", stats.getAverage()) +
                ", Min: " + String.format("%.2f", stats.getMin()) +
                ", Max: " + String.format("%.2f", stats.getMax())));
        
        // Honor roll (GPA > 90)
        List<String> honorRoll = students.stream()
            .filter(student -> student.getGrades().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0) > 90)
            .map(Student::getName)
            .collect(Collectors.toList());
        System.out.println("Honor roll: " + honorRoll);
    }
    
    // 9. Stream Debugging
    public static void demonstrateStreamDebugging() {
        System.out.println("\n9. Stream Debugging:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("=== Using peek() for debugging ===");
        List<Integer> result = numbers.stream()
            .peek(n -> System.out.println("Original: " + n))
            .filter(n -> n % 2 == 0)
            .peek(n -> System.out.println("After filter: " + n))
            .map(n -> n * n)
            .peek(n -> System.out.println("After map: " + n))
            .collect(Collectors.toList());
        
        System.out.println("Final result: " + result);
        
        System.out.println("\n=== Debugging with custom methods ===");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        
        List<String> debugResult = words.stream()
            .filter(debug("Filtering", w -> w.length() > 4))
            .map(debug("Mapping", String::toUpperCase))
            .collect(Collectors.toList());
        
        System.out.println("Debug result: " + debugResult);
        
        System.out.println("\n=== Stream execution order ===");
        // Demonstrating lazy evaluation
        System.out.println("Stream operations are lazy - watch the execution order:");
        
        Optional<String> lazyResult = Stream.of("apple", "banana", "cherry", "date", "elderberry")
            .peek(s -> System.out.println("peek 1: " + s))
            .filter(s -> {
                System.out.println("filter: " + s);
                return s.length() > 5;
            })
            .peek(s -> System.out.println("peek 2: " + s))
            .map(s -> {
                System.out.println("map: " + s);
                return s.toUpperCase();
            })
            .findFirst(); // Terminal operation - this triggers the pipeline
        
        System.out.println("Lazy result: " + lazyResult.orElse("Not found"));
        
        System.out.println("\n=== Performance debugging ===");
        // Timing stream operations
        List<Integer> largeList = IntStream.rangeClosed(1, 1_000_000)
            .boxed()
            .collect(Collectors.toList());
        
        long startTime = System.nanoTime();
        long count = largeList.stream()
            .filter(n -> n % 2 == 0)
            .filter(n -> n % 3 == 0)
            .count();
        long duration = System.nanoTime() - startTime;
        
        System.out.println("Count: " + count + ", Time: " + duration / 1_000_000.0 + " ms");
        
        // Compare with parallel stream
        startTime = System.nanoTime();
        long parallelCount = largeList.parallelStream()
            .filter(n -> n % 2 == 0)
            .filter(n -> n % 3 == 0)
            .count();
        long parallelDuration = System.nanoTime() - startTime;
        
        System.out.println("Parallel count: " + parallelCount + 
            ", Time: " + parallelDuration / 1_000_000.0 + " ms");
    }
    
    // 10. Best Practices and Performance
    public static void demonstrateBestPractices() {
        System.out.println("\n10. Best Practices and Performance:");
        
        List<Integer> numbers = IntStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList());
        
        System.out.println("=== Performance Best Practices ===");
        
        // 1. Prefer primitive streams when working with numbers
        long startTime = System.nanoTime();
        double average1 = numbers.stream()
            .mapToInt(Integer::intValue) // Convert to IntStream
            .average()
            .orElse(0.0);
        long duration1 = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        double average2 = numbers.stream()
            .collect(Collectors.averagingInt(Integer::intValue)); // Using collector
        long duration2 = System.nanoTime() - startTime;
        
        System.out.println("Primitive stream average: " + average1 + 
            " (Time: " + duration1 / 1000.0 + " μs)");
        System.out.println("Collector average: " + average2 + 
            " (Time: " + duration2 / 1000.0 + " μs)");
        
        // 2. Filter early in the pipeline
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        
        // Good: Filter first
        List<String> good = words.stream()
            .filter(w -> w.length() > 4)  // Filter early
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());
        
        // Less efficient: Filter later
        List<String> lessEfficient = words.stream()
            .map(String::toUpperCase)    // Process all elements first
            .sorted()
            .filter(w -> w.length() > 4) // Filter after processing
            .collect(Collectors.toList());
        
        System.out.println("Both approaches give same result: " + good.equals(lessEfficient));
        
        // 3. Use appropriate terminal operations
        // For existence checking
        boolean hasLongWord = words.stream().anyMatch(w -> w.length() > 8);
        System.out.println("Has long word (efficient): " + hasLongWord);
        
        // Avoid: collecting just to check
        // boolean inefficient = words.stream().filter(w -> w.length() > 8).collect(Collectors.toList()).size() > 0;
        
        // 4. Reuse streams vs recreate
        System.out.println("\n=== Stream Reuse Patterns ===");
        
        // Cannot reuse streams
        Stream<String> wordStream = words.stream();
        wordStream.filter(w -> w.length() > 4).forEach(System.out::println);
        // wordStream.count(); // This would throw IllegalStateException
        
        // Pattern: Use supplier for reusable stream logic
        Supplier<Stream<String>> wordStreamSupplier = () -> words.stream();
        
        long longWordCount = wordStreamSupplier.get()
            .filter(w -> w.length() > 4)
            .count();
        
        List<String> upperCaseWords = wordStreamSupplier.get()
            .filter(w -> w.length() > 4)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        
        System.out.println("Long word count: " + longWordCount);
        System.out.println("Uppercase long words: " + upperCaseWords);
        
        // 5. Parallel stream considerations
        System.out.println("\n=== Parallel Stream Guidelines ===");
        
        System.out.println("Use parallel streams when:");
        System.out.println("- Large datasets (typically > 10,000 elements)");
        System.out.println("- CPU-intensive operations");
        System.out.println("- Independent operations (no shared state)");
        System.out.println("- Operations can be decomposed");
        
        System.out.println("\nAvoid parallel streams when:");
        System.out.println("- Small datasets");
        System.out.println("- I/O operations (file, network)");
        System.out.println("- Operations with side effects");
        System.out.println("- Order matters (unless using forEachOrdered)");
        
        // 6. Memory considerations
        System.out.println("\n=== Memory Considerations ===");
        
        // Avoid collecting large intermediate results
        // Good: Process in pipeline
        long evenSum = IntStream.rangeClosed(1, 1_000_000)
            .filter(n -> n % 2 == 0)
            .mapToLong(n -> n)
            .sum();
        
        // Less memory efficient: Collect intermediate results
        // List<Integer> evens = IntStream.rangeClosed(1, 1_000_000)
        //     .filter(n -> n % 2 == 0)
        //     .boxed()
        //     .collect(Collectors.toList());
        // long sum = evens.stream().mapToLong(Integer::longValue).sum();
        
        System.out.println("Even sum (memory efficient): " + evenSum);
        
        System.out.println("\n=== Common Anti-patterns to Avoid ===");
        System.out.println("1. Don't use streams for simple iterations");
        System.out.println("2. Don't use peek() for business logic (only for debugging)");
        System.out.println("3. Avoid stateful operations in parallel streams");
        System.out.println("4. Don't ignore return values (use collect() properly)");
        System.out.println("5. Avoid complex nested streams (consider breaking into methods)");
        
        System.out.println("\n=== When NOT to use Streams ===");
        System.out.println("- Simple index-based loops");
        System.out.println("- When you need to break/continue based on complex conditions");
        System.out.println("- When working with checked exceptions extensively");
        System.out.println("- When the traditional loop is significantly more readable");
        
        // Example of when traditional loop might be better
        List<String> items = Arrays.asList("apple", "banana", "cherry");
        
        // Simple case - traditional loop is fine
        System.out.print("Traditional: ");
        for (String item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
        
        // Stream version (not necessarily better for this simple case)
        System.out.print("Stream: ");
        items.stream().forEach(item -> System.out.print(item + " "));
        System.out.println();
    }
    
    // Utility method for debugging
    public static <T> Predicate<T> debug(String label, Predicate<T> predicate) {
        return item -> {
            boolean result = predicate.test(item);
            System.out.println(label + " " + item + " -> " + result);
            return result;
        };
    }
    
    public static <T, R> Function<T, R> debug(String label, Function<T, R> function) {
        return item -> {
            R result = function.apply(item);
            System.out.println(label + " " + item + " -> " + result);
            return result;
        };
    }
    
    // Supporting classes
    static class Person {
        private String name;
        private int age;
        private String department;
        private double salary;
        
        public Person(String name, int age, String department, double salary) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }
        
        // Getters
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }
        
        @Override
        public String toString() {
            return name + "(" + age + ", " + department + ", $" + salary + ")";
        }
    }
    
    static class Order {
        private String orderId;
        private String customer;
        private LocalDate orderDate;
        private double amount;
        private String status;
        
        public Order(String orderId, String customer, LocalDate orderDate, double amount, String status) {
            this.orderId = orderId;
            this.customer = customer;
            this.orderDate = orderDate;
            this.amount = amount;
            this.status = status;
        }
        
        public String getOrderId() { return orderId; }
        public String getCustomer() { return customer; }
        public LocalDate getOrderDate() { return orderDate; }
        public double getAmount() { return amount; }
        public String getStatus() { return status; }
        
        @Override
        public String toString() {
            return orderId + " (" + customer + ", " + amount + ", " + status + ")";
        }
    }
    
    static class LogEntry {
        private String timestamp;
        private String level;
        private String message;
        private String user;
        
        public LogEntry(String timestamp, String level, String message, String user) {
            this.timestamp = timestamp;
            this.level = level;
            this.message = message;
            this.user = user;
        }
        
        public String getTimestamp() { return timestamp; }
        public String getLevel() { return level; }
        public String getMessage() { return message; }
        public String getUser() { return user; }
    }
    
    static class Student {
        private String name;
        private String major;
        private List<Integer> grades;
        
        public Student(String name, String major, List<Integer> grades) {
            this.name = name;
            this.major = major;
            this.grades = grades;
        }
        
        public String getName() { return name; }
        public String getMajor() { return major; }
        public List<Integer> getGrades() { return grades; }
    }
    
    static class PersonSummary {
        private int count = 0;
        private double totalSalary = 0.0;
        private int totalAge = 0;
        
        public void accept(Person person) {
            count++;
            totalSalary += person.getSalary();
            totalAge += person.getAge();
        }
        
        public PersonSummary combine(PersonSummary other) {
            this.count += other.count;
            this.totalSalary += other.totalSalary;
            this.totalAge += other.totalAge;
            return this;
        }
        
        public double getAverageSalary() {
            return count > 0 ? totalSalary / count : 0.0;
        }
        
        public double getAverageAge() {
            return count > 0 ? (double) totalAge / count : 0.0;
        }
        
        @Override
        public String toString() {
            return String.format("PersonSummary{count=%d, avgSalary=%.2f, avgAge=%.1f}", 
                count, getAverageSalary(), getAverageAge());
        }
    }
}

/*
 * Key Points - Streams API:
 * 
 * STREAM CREATION:
 * 1. From collections: list.stream(), set.parallelStream()
 * 2. From arrays: Arrays.stream(array), Arrays.stream(array, start, end)
 * 3. Direct creation: Stream.of(elements), Stream.empty()
 * 4. Infinite streams: Stream.generate(supplier), Stream.iterate(seed, function)
 * 5. Primitive streams: IntStream.range(), LongStream.of(), DoubleStream.of()
 * 6. From strings: string.chars(), string.lines()
 * 
 * INTERMEDIATE OPERATIONS (LAZY):
 * 1. filter(): Filters elements based on predicate
 * 2. map(): Transforms elements one-to-one
 * 3. flatMap(): Transforms and flattens nested structures
 * 4. distinct(): Removes duplicate elements
 * 5. sorted(): Sorts elements (natural or custom order)
 * 6. peek(): Performs action for debugging (side-effect operation)
 * 7. limit(n): Takes first n elements
 * 8. skip(n): Skips first n elements
 * 
 * TERMINAL OPERATIONS (EAGER):
 * 1. collect(): Collects to collections or custom containers
 * 2. forEach(): Performs action on each element
 * 3. reduce(): Reduces stream to single value
 * 4. count(): Counts elements
 * 5. anyMatch/allMatch/noneMatch(): Boolean tests
 * 6. findFirst/findAny(): Returns Optional<T>
 * 7. min/max(): Returns Optional<T> with comparator
 * 8. toArray(): Converts to array
 * 
 * COLLECTORS:
 * 1. Basic: toList(), toSet(), toMap(), joining()
 * 2. Summarizing: counting(), summarizing(), averaging()
 * 3. Grouping: groupingBy() with downstream collectors
 * 4. Partitioning: partitioningBy() splits into true/false groups
 * 5. Custom: Collector.of() for custom reduction logic
 * 6. Composition: collectingAndThen() applies function to result
 * 
 * PARALLEL STREAMS:
 * 1. Use for large datasets (>10,000 elements) with CPU-intensive operations
 * 2. Avoid for I/O operations, side effects, or order-dependent operations
 * 3. ForkJoinPool used by default, can be customized
 * 4. Convert: stream.parallel() or collection.parallelStream()
 * 5. Back to sequential: parallelStream.sequential()
 * 
 * PERFORMANCE BEST PRACTICES:
 * 1. Use primitive streams (IntStream, LongStream, DoubleStream) for numbers
 * 2. Filter early in the pipeline to reduce subsequent operations
 * 3. Use appropriate terminal operations (anyMatch vs collect then check)
 * 4. Avoid collecting intermediate results unnecessarily
 * 5. Consider parallel processing for large datasets and complex operations
 * 6. Profile and measure performance - streams aren't always faster
 * 
 * INTEGRATION WITH OPTIONAL:
 * 1. findFirst(), findAny(), min(), max() return Optional<T>
 * 2. reduce() without identity returns Optional<T>
 * 3. Chain Optional operations: filter(), map(), flatMap()
 * 4. Handle empty results: orElse(), orElseGet(), ifPresent()
 * 
 * DEBUGGING TECHNIQUES:
 * 1. Use peek() to observe values at different stages
 * 2. Break complex streams into smaller methods
 * 3. Use logging in lambda expressions for debugging
 * 4. Understand lazy evaluation - operations execute only on terminal operation
 * 5. Time different approaches for performance comparison
 * 
 * WHEN TO AVOID STREAMS:
 * 1. Simple iterations where enhanced for-loop is clearer
 * 2. When you need to break/continue with complex conditions
 * 3. Heavy use of checked exceptions in operations
 * 4. When traditional imperative code is significantly more readable
 * 5. Very small datasets where overhead exceeds benefits
 * 
 * COMMON ANTI-PATTERNS:
 * 1. Using peek() for business logic instead of debugging
 * 2. Ignoring return values from stream operations
 * 3. Stateful operations in parallel streams
 * 4. Overusing streams for simple cases
 * 5. Creating overly complex nested stream operations
 */