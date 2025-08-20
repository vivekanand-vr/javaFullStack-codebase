/*
 * Understanding Collections Framework in Java - Part 1
 * Focus: List, Set, and Queue Interfaces
 */

/*
 * The Java Collections Framework provides a unified architecture for storing
 * and manipulating groups of objects. It consists of interfaces, implementations,
 * and algorithms that work together to provide efficient data structures.
 * 
 * Collection Hierarchy:
 * Collection (interface)
 * ├── List (interface) - ordered, allows duplicates
 * │   ├── ArrayList - resizable array, fast random access
 * │   ├── LinkedList - doubly-linked list, fast insertion/deletion
 * │   └── Vector - synchronized ArrayList (legacy)
 * ├── Set (interface) - no duplicates allowed
 * │   ├── HashSet - hash table, no ordering
 * │   ├── LinkedHashSet - maintains insertion order
 * │   └── TreeSet - sorted set, natural or custom ordering
 * └── Queue (interface) - FIFO operations
 *     ├── PriorityQueue - heap-based priority queue
 *     ├── ArrayDeque - resizable array deque
 *     └── LinkedList - also implements Queue
 */

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class CollectionsPart1 {
    
    public static void main(String[] args) {
        System.out.println("1. Collections Framework - Part 1:");
        
        // 1. List Interface implementations
        System.out.println("\n=== LIST INTERFACE ===");
        demonstrateArrayList();
        demonstrateLinkedList();
        demonstrateVector();
        compareListPerformance();
        
        // 2. Set Interface implementations
        System.out.println("\n=== SET INTERFACE ===");
        demonstrateHashSet();
        demonstrateLinkedHashSet();
        demonstrateTreeSet();
        compareSetOperations();
        
        // 3. Queue Interface implementations
        System.out.println("\n=== QUEUE INTERFACE ===");
        demonstratePriorityQueue();
        demonstrateArrayDeque();
        demonstrateLinkedListAsQueue();
        
        // 4. Common operations and best practices
        System.out.println("\n=== COMMON OPERATIONS ===");
        demonstrateCommonOperations();
        demonstrateIterators();
        demonstrateCollectionsUtility();
    }
    
    // 1. ArrayList - Dynamic array implementation
    public static void demonstrateArrayList() {
        System.out.println("\n1. ArrayList Demonstration:");
        
        // Creating ArrayList
        List<String> fruits = new ArrayList<>();
        
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicates allowed
        System.out.println("Initial list: " + fruits);
        
        // Adding at specific index
        fruits.add(1, "Mango");
        System.out.println("After adding Mango at index 1: " + fruits);
        
        // Accessing elements
        System.out.println("Element at index 2: " + fruits.get(2));
        System.out.println("Index of Apple: " + fruits.indexOf("Apple"));
        System.out.println("Last index of Apple: " + fruits.lastIndexOf("Apple"));
        
        // Modifying elements
        fruits.set(0, "Grapes");
        System.out.println("After replacing Apple with Grapes: " + fruits);
        
        // Removing elements
        fruits.remove("Banana");
        fruits.remove(2); // Remove by index
        System.out.println("After removals: " + fruits);
        
        // Size and capacity
        System.out.println("Size: " + fruits.size());
        System.out.println("Is empty: " + fruits.isEmpty());
        
        // ArrayList with initial capacity
        List<Integer> numbers = new ArrayList<>(20);
        for (int i = 1; i <= 5; i++) {
            numbers.add(i * 10);
        }
        System.out.println("Numbers: " + numbers);
    }
    
    // 2. LinkedList - Doubly linked list implementation
    public static void demonstrateLinkedList() {
        System.out.println("\n2. LinkedList Demonstration:");
        
        LinkedList<String> animals = new LinkedList<>();
        
        // Adding elements
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Elephant");
        System.out.println("Initial LinkedList: " + animals);
        
        // LinkedList specific methods
        animals.addFirst("Lion");
        animals.addLast("Tiger");
        System.out.println("After adding first and last: " + animals);
        
        // Accessing first and last elements
        System.out.println("First element: " + animals.getFirst());
        System.out.println("Last element: " + animals.getLast());
        
        // Removing first and last elements
        System.out.println("Removed first: " + animals.removeFirst());
        System.out.println("Removed last: " + animals.removeLast());
        System.out.println("After removals: " + animals);
        
        // Using as a stack (LIFO)
        System.out.println("\nUsing LinkedList as Stack:");
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Final stack: " + stack);
    }
    
    // 3. Vector - Legacy synchronized list
    public static void demonstrateVector() {
        System.out.println("\n3. Vector Demonstration:");
        
        Vector<String> colors = new Vector<>();
        
        // Adding elements
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        System.out.println("Vector: " + colors);
        
        // Vector specific methods
        colors.insertElementAt("Yellow", 1);
        System.out.println("After insertion: " + colors);
        
        // Capacity management
        System.out.println("Size: " + colors.size());
        System.out.println("Capacity: " + colors.capacity());
        
        // Enumeration (legacy way to iterate)
        System.out.print("Using Enumeration: ");
        Enumeration<String> enumeration = colors.elements();
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();
        
        System.out.println("Note: Vector is synchronized but ArrayList is preferred for single-threaded apps");
    }
    
    // 4. List Performance Comparison
    public static void compareListPerformance() {
        System.out.println("\n4. List Performance Characteristics:");
        
        final int size = 10000;
        
        // ArrayList performance
        long start = System.nanoTime();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long arrayListTime = System.nanoTime() - start;
        
        // LinkedList performance
        start = System.nanoTime();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long linkedListTime = System.nanoTime() - start;
        
        System.out.println("Adding " + size + " elements:");
        System.out.println("ArrayList time: " + arrayListTime / 1_000_000.0 + " ms");
        System.out.println("LinkedList time: " + linkedListTime / 1_000_000.0 + " ms");
        
        // Random access performance
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        
        start = System.nanoTime();
        arrayList.get(randomIndex);
        long arrayListAccess = System.nanoTime() - start;
        
        start = System.nanoTime();
        linkedList.get(randomIndex);
        long linkedListAccess = System.nanoTime() - start;
        
        System.out.println("\nRandom access at index " + randomIndex + ":");
        System.out.println("ArrayList access time: " + arrayListAccess + " ns");
        System.out.println("LinkedList access time: " + linkedListAccess + " ns");
    }
    
    // 5. HashSet - Hash table based set
    public static void demonstrateHashSet() {
        System.out.println("\n5. HashSet Demonstration:");
        
        Set<String> uniqueNames = new HashSet<>();
        
        // Adding elements
        uniqueNames.add("Alice");
        uniqueNames.add("Bob");
        uniqueNames.add("Charlie");
        uniqueNames.add("Alice"); // Duplicate - won't be added
        System.out.println("HashSet: " + uniqueNames);
        System.out.println("Size: " + uniqueNames.size());
        
        // Checking membership
        System.out.println("Contains Alice: " + uniqueNames.contains("Alice"));
        System.out.println("Contains David: " + uniqueNames.contains("David"));
        
        // Removing elements
        uniqueNames.remove("Bob");
        System.out.println("After removing Bob: " + uniqueNames);
        
        // HashSet with numbers
        Set<Integer> numbers = new HashSet<>();
        numbers.addAll(Arrays.asList(5, 2, 8, 1, 9, 2, 5));
        System.out.println("Number set (duplicates removed): " + numbers);
        System.out.println("Note: HashSet doesn't maintain insertion order");
    }
    
    // 6. LinkedHashSet - Maintains insertion order
    public static void demonstrateLinkedHashSet() {
        System.out.println("\n6. LinkedHashSet Demonstration:");
        
        Set<String> orderedSet = new LinkedHashSet<>();
        
        orderedSet.add("First");
        orderedSet.add("Second");
        orderedSet.add("Third");
        orderedSet.add("Second"); // Duplicate
        System.out.println("LinkedHashSet: " + orderedSet);
        System.out.println("Note: Maintains insertion order while ensuring uniqueness");
        
        // Comparing with HashSet
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        
        for (int i : Arrays.asList(5, 1, 3, 7, 2)) {
            hashSet.add(i);
            linkedHashSet.add(i);
        }
        
        System.out.println("HashSet order: " + hashSet);
        System.out.println("LinkedHashSet order: " + linkedHashSet);
    }
    
    // 7. TreeSet - Sorted set implementation
    public static void demonstrateTreeSet() {
        System.out.println("\n7. TreeSet Demonstration:");
        
        Set<Integer> sortedNumbers = new TreeSet<>();
        
        // Adding elements
        sortedNumbers.addAll(Arrays.asList(5, 1, 9, 3, 7, 1));
        System.out.println("TreeSet (sorted): " + sortedNumbers);
        
        TreeSet<Integer> treeSet = (TreeSet<Integer>) sortedNumbers;
        
        // TreeSet specific methods
        System.out.println("First (smallest): " + treeSet.first());
        System.out.println("Last (largest): " + treeSet.last());
        System.out.println("Lower than 5: " + treeSet.lower(5));
        System.out.println("Higher than 5: " + treeSet.higher(5));
        
        // Subset operations
        System.out.println("Elements < 7: " + treeSet.headSet(7));
        System.out.println("Elements >= 3: " + treeSet.tailSet(3));
        System.out.println("Elements 3 to 7: " + treeSet.subSet(3, 7));
        
        // Custom comparator
        Set<String> reverseOrderSet = new TreeSet<>(Collections.reverseOrder());
        reverseOrderSet.addAll(Arrays.asList("Zebra", "Apple", "Monkey", "Cat"));
        System.out.println("Reverse order TreeSet: " + reverseOrderSet);
    }
    
    // 8. Set Operations Comparison
    public static void compareSetOperations() {
        System.out.println("\n8. Set Operations Comparison:");
        
        Set<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        Set<String> set2 = new HashSet<>(Arrays.asList("C", "D", "E", "F"));
        
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        
        // Union
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);
        
        // Intersection
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
        
        // Difference
        Set<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Set1 - Set2: " + difference);
        
        // Symmetric difference
        Set<String> symmetricDiff = new HashSet<>(union);
        symmetricDiff.removeAll(intersection);
        System.out.println("Symmetric difference: " + symmetricDiff);
    }
    
    // 9. PriorityQueue - Heap-based priority queue
    public static void demonstratePriorityQueue() {
        System.out.println("\n9. PriorityQueue Demonstration:");
        
        // Natural ordering (min-heap)
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        
        priorityQueue.addAll(Arrays.asList(5, 2, 8, 1, 9, 3));
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Note: Internal array representation, not sorted display");
        
        // Polling elements (always returns smallest)
        System.out.print("Polling elements in order: ");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println();
        
        // Custom comparator (max-heap)
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(5, 2, 8, 1, 9, 3));
        
        System.out.print("Max heap polling: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
        
        // Priority queue with custom objects
        Queue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.add(new Task("Low priority task", 3));
        taskQueue.add(new Task("High priority task", 1));
        taskQueue.add(new Task("Medium priority task", 2));
        
        System.out.println("Task execution order:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
    
    // 10. ArrayDeque - Resizable array deque
    public static void demonstrateArrayDeque() {
        System.out.println("\n10. ArrayDeque Demonstration:");
        
        Deque<String> deque = new ArrayDeque<>();
        
        // Adding elements at both ends
        deque.addFirst("Middle");
        deque.addFirst("First");
        deque.addLast("Last");
        System.out.println("Deque: " + deque);
        
        // Accessing elements
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());
        
        // Using as stack (LIFO)
        System.out.println("\nUsing as Stack:");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        
        // Using as queue (FIFO)
        System.out.println("\nUsing as Queue:");
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("Queue: " + queue);
        System.out.println("Poll: " + queue.poll());
        System.out.println("Remaining: " + queue);
    }
    
    // 11. LinkedList as Queue
    public static void demonstrateLinkedListAsQueue() {
        System.out.println("\n11. LinkedList as Queue:");
        
        Queue<String> queue = new LinkedList<>();
        
        // Queue operations
        queue.offer("Customer 1");
        queue.offer("Customer 2");
        queue.offer("Customer 3");
        System.out.println("Queue: " + queue);
        
        // Process customers (FIFO)
        while (!queue.isEmpty()) {
            String customer = queue.poll();
            System.out.println("Serving: " + customer);
        }
        
        System.out.println("All customers served");
    }
    
    // 12. Common Collection Operations
    public static void demonstrateCommonOperations() {
        System.out.println("\n12. Common Collection Operations:");
        
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        
        // Converting between collection types
        Set<String> set = new HashSet<>(list);
        Queue<String> queue = new ArrayDeque<>(set);
        
        System.out.println("Original list: " + list);
        System.out.println("Converted to set: " + set);
        System.out.println("Converted to queue: " + queue);
        
        // Bulk operations
        List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));
        List<String> moreFruits = Arrays.asList("Mango", "Grape");
        
        fruits.addAll(moreFruits);
        System.out.println("After addAll: " + fruits);
        
        fruits.removeAll(Arrays.asList("Apple", "Grape"));
        System.out.println("After removeAll: " + fruits);
        
        // Collection queries
        System.out.println("Contains Banana: " + fruits.contains("Banana"));
        System.out.println("Contains all [Banana, Orange]: " + 
                         fruits.containsAll(Arrays.asList("Banana", "Orange")));
        
        // Converting to array
        String[] fruitsArray = fruits.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(fruitsArray));
    }
    
    // 13. Iterators
    public static void demonstrateIterators() {
        System.out.println("\n13. Iterator Demonstration:");
        
        List<String> languages = new ArrayList<>(Arrays.asList("Java", "Python", "C++", "JavaScript"));
        
        // Basic Iterator
        System.out.println("Using Iterator:");
        Iterator<String> iterator = languages.iterator();
        while (iterator.hasNext()) {
            String language = iterator.next();
            System.out.print(language + " ");
            if (language.equals("Python")) {
                iterator.remove(); // Safe removal during iteration
            }
        }
        System.out.println("\nAfter removing Python: " + languages);
        
        // ListIterator (bidirectional)
        System.out.println("\nUsing ListIterator:");
        ListIterator<String> listIterator = languages.listIterator();
        
        // Forward iteration
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        
        // Backward iteration
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        
        // Enhanced for-each loop (recommended for read-only)
        System.out.println("Using enhanced for-each:");
        for (String language : languages) {
            System.out.print(language + " ");
        }
        System.out.println();
    }
    
    // 14. Collections Utility Class
    public static void demonstrateCollectionsUtility() {
        System.out.println("\n14. Collections Utility Methods:");
        
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3));
        System.out.println("Original list: " + numbers);
        
        // Sorting
        Collections.sort(numbers);
        System.out.println("After sort: " + numbers);
        
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Reverse sort: " + numbers);
        
        // Shuffling
        Collections.shuffle(numbers);
        System.out.println("After shuffle: " + numbers);
        
        // Searching
        Collections.sort(numbers); // Must be sorted for binary search
        int index = Collections.binarySearch(numbers, 5);
        System.out.println("Binary search for 5: index " + index);
        
        // Min and Max
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Max: " + Collections.max(numbers));
        
        // Frequency
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "apple");
        System.out.println("Frequency of 'apple': " + Collections.frequency(words, "apple"));
        
        // Reversing
        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);
        
        // Creating immutable collections
        List<String> immutableList = Collections.unmodifiableList(
            new ArrayList<>(Arrays.asList("Read", "Only", "List")));
        System.out.println("Immutable list: " + immutableList);
        
        // Synchronized collections
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        System.out.println("Created synchronized list for thread safety");
        
        // Empty collections
        List<String> emptyList = Collections.emptyList();
        Set<String> emptySet = Collections.emptySet();
        System.out.println("Empty collections created: " + emptyList.size() + ", " + emptySet.size());
    }
}

// Helper class for PriorityQueue example
class Task implements Comparable<Task> {
    private String description;
    private int priority;
    
    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }
    
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority); // Lower number = higher priority
    }
    
    @Override
    public String toString() {
        return description + " (Priority: " + priority + ")";
    }
}

/*
 * Key Points - Part 1:
 * 
 * LIST INTERFACE:
 * 1. ArrayList: Best for frequent random access, not for frequent insertions/deletions in middle
 * 2. LinkedList: Best for frequent insertions/deletions, poor for random access
 * 3. Vector: Legacy, synchronized, use ArrayList with Collections.synchronizedList() instead
 * 4. Lists maintain insertion order and allow duplicates
 * 5. ArrayList has better memory usage, LinkedList has no capacity restrictions
 * 
 * SET INTERFACE:
 * 1. HashSet: Fastest access, no ordering guarantees, allows one null
 * 2. LinkedHashSet: Maintains insertion order, slightly slower than HashSet
 * 3. TreeSet: Sorted order (natural or custom), no null elements, log(n) operations
 * 4. Sets automatically handle uniqueness, no duplicate elements allowed
 * 5. Override equals() and hashCode() for custom objects in HashSet
 * 
 * QUEUE INTERFACE:
 * 1. PriorityQueue: Heap-based, elements ordered by priority, not thread-safe
 * 2. ArrayDeque: Fastest queue/stack implementation, no capacity restrictions
 * 3. LinkedList: Implements both List and Queue, good for queue operations
 * 4. Queue operations: offer/add (insert), poll/remove (extract), peek/element (examine)
 * 5. Deque provides operations at both ends (double-ended queue)
 * 
 * GENERAL PRINCIPLES:
 * - Choose ArrayList for most List use cases
 * - Choose HashSet for most Set use cases
 * - Choose ArrayDeque for queue/stack operations
 * - Use TreeSet/TreeMap when you need sorted order
 * - Use LinkedHashSet/LinkedHashMap when you need predictable iteration order
 * - Always use interface types (List, Set, Queue) for declarations
 * - Consider thread safety requirements (Collections.synchronizedXxx or concurrent collections)
 * 
 * Performance Guidelines:
 * - ArrayList: O(1) access, O(n) insertion/deletion in middle
 * - LinkedList: O(n) access, O(1) insertion/deletion at ends
 * - HashSet: O(1) average for basic operations
 * - TreeSet: O(log n) for basic operations
 * - PriorityQueue: O(log n) for insertion/removal, O(1) for peek
 */