/*
 * Understanding Multithreading in Java
 */

/*
 * Multithreading in Java allows concurrent execution of multiple threads within
 * a single program. A thread is a lightweight sub-process that can run independently
 * and share resources with other threads in the same process.
 * 
 * Key concepts:
 * - Thread creation (extending Thread class or implementing Runnable)
 * - Thread lifecycle (NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED)
 * - Thread synchronization (synchronized keyword, locks)
 * - Thread communication (wait, notify, notifyAll)
 * - Executor framework for better thread management
 * - Thread safety and concurrent collections
 */

import java.util.concurrent.*;
import java.util.*;

public class Multithreading {
    
    // Shared resource for synchronization examples
    private static int sharedCounter = 0;
    private static final Object lock = new Object();
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1. Multithreading Examples:");
        System.out.println("Main thread: " + Thread.currentThread().getName());
        
        // 1. Creating threads by extending Thread class
        System.out.println("\n1. Extending Thread Class:");
        createThreadsByExtending();
        
        // 2. Creating threads by implementing Runnable
        System.out.println("\n2. Implementing Runnable Interface:");
        createThreadsByRunnable();
        
        // 3. Thread lifecycle and states
        System.out.println("\n3. Thread Lifecycle:");
        demonstrateThreadLifecycle();
        
        // 4. Thread synchronization
        System.out.println("\n4. Thread Synchronization:");
        demonstrateSynchronization();
        
        // 5. Producer-Consumer problem
        System.out.println("\n5. Producer-Consumer Example:");
        demonstrateProducerConsumer();
        
        // 6. Executor framework
        System.out.println("\n6. Executor Framework:");
        demonstrateExecutorFramework();
        
        // 7. Callable and Future
        System.out.println("\n7. Callable and Future:");
        demonstrateCallableAndFuture();
        
        // 8. Thread-safe collections
        System.out.println("\n8. Thread-Safe Collections:");
        demonstrateThreadSafeCollections();
    }
    
    // 1. Creating Threads by Extending Thread Class
    public static void createThreadsByExtending() throws InterruptedException {
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");
        
        thread1.start();
        thread2.start();
        
        // Wait for threads to complete
        thread1.join();
        thread2.join();
        
        System.out.println("Both threads completed");
    }
    
    // 2. Creating Threads by Implementing Runnable
    public static void createThreadsByRunnable() throws InterruptedException {
        // Using Runnable interface
        MyRunnable task = new MyRunnable("Task-A");
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(new MyRunnable("Task-B"));
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        // Using lambda expression (Java 8+)
        Thread lambdaThread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Lambda thread: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        lambdaThread.start();
        lambdaThread.join();
        
        System.out.println("All Runnable threads completed");
    }
    
    // 3. Thread Lifecycle Demonstration
    public static void demonstrateThreadLifecycle() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Thread is RUNNING");
                Thread.sleep(1000); // TIMED_WAITING state
                System.out.println("Thread woke up from sleep");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
                Thread.currentThread().interrupt();
            }
        });
        
        System.out.println("Thread state: " + thread.getState()); // NEW
        thread.start();
        System.out.println("Thread state after start: " + thread.getState()); // RUNNABLE
        
        Thread.sleep(500);
        System.out.println("Thread state during sleep: " + thread.getState()); // TIMED_WAITING
        
        thread.join();
        System.out.println("Thread state after completion: " + thread.getState()); // TERMINATED
    }
    
    // 4. Thread Synchronization
    public static void demonstrateSynchronization() throws InterruptedException {
        System.out.println("Testing without synchronization:");
        sharedCounter = 0;
        
        // Without synchronization - may produce incorrect results
        Thread t1 = new Thread(new UnsafeCounter("Thread-1"));
        Thread t2 = new Thread(new UnsafeCounter("Thread-2"));
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("Final counter value (unsafe): " + sharedCounter);
        
        System.out.println("\nTesting with synchronization:");
        sharedCounter = 0;
        
        // With synchronization - produces correct results
        Thread t3 = new Thread(new SafeCounter("Thread-3"));
        Thread t4 = new Thread(new SafeCounter("Thread-4"));
        
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        
        System.out.println("Final counter value (safe): " + sharedCounter);
    }
    
    // 5. Producer-Consumer Problem
    public static void demonstrateProducerConsumer() throws InterruptedException {
        Buffer buffer = new Buffer(5);
        
        Thread producer = new Thread(new Producer(buffer), "Producer");
        Thread consumer1 = new Thread(new Consumer(buffer), "Consumer-1");
        Thread consumer2 = new Thread(new Consumer(buffer), "Consumer-2");
        
        producer.start();
        consumer1.start();
        consumer2.start();
        
        Thread.sleep(3000); // Let them run for 3 seconds
        
        producer.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();
        
        producer.join();
        consumer1.join();
        consumer2.join();
        
        System.out.println("Producer-Consumer demo completed");
    }
    
    // 6. Executor Framework
    public static void demonstrateExecutorFramework() throws InterruptedException {
        // Fixed thread pool
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        
        System.out.println("Using Fixed Thread Pool:");
        for (int i = 1; i <= 6; i++) {
            final int taskNumber = i;
            fixedPool.submit(() -> {
                System.out.println("Task " + taskNumber + " executed by " + 
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        fixedPool.shutdown();
        fixedPool.awaitTermination(5, TimeUnit.SECONDS);
        
        // Cached thread pool
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        
        System.out.println("\nUsing Cached Thread Pool:");
        for (int i = 1; i <= 4; i++) {
            final int taskNumber = i;
            cachedPool.submit(() -> {
                System.out.println("Cached task " + taskNumber + " by " + 
                                 Thread.currentThread().getName());
            });
        }
        
        cachedPool.shutdown();
        cachedPool.awaitTermination(2, TimeUnit.SECONDS);
        
        // Scheduled thread pool
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        
        System.out.println("\nUsing Scheduled Thread Pool:");
        scheduledPool.schedule(() -> {
            System.out.println("Delayed task executed after 1 second");
        }, 1, TimeUnit.SECONDS);
        
        scheduledPool.scheduleAtFixedRate(() -> {
            System.out.println("Repeated task: " + new Date());
        }, 0, 500, TimeUnit.MILLISECONDS);
        
        Thread.sleep(2000);
        scheduledPool.shutdown();
    }
    
    // 7. Callable and Future
    public static void demonstrateCallableAndFuture() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Submit Callable tasks
        List<Future<Integer>> futures = new ArrayList<>();
        
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            Callable<Integer> task = () -> {
                Thread.sleep(1000);
                int result = taskId * taskId;
                System.out.println("Task " + taskId + " computed result: " + result);
                return result;
            };
            
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }
        
        // Collect results
        int sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get(); // This blocks until result is available
        }
        
        System.out.println("Sum of all results: " + sum);
        
        // CompletableFuture example (Java 8+)
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(500); } catch (InterruptedException e) { }
            return "Hello";
        });
        
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(300); } catch (InterruptedException e) { }
            return "World";
        });
        
        CompletableFuture<String> combined = future1.thenCombine(future2, 
            (result1, result2) -> result1 + " " + result2 + "!");
        
        System.out.println("Combined result: " + combined.get());
        
        executor.shutdown();
    }
    
    // 8. Thread-Safe Collections
    public static void demonstrateThreadSafeCollections() throws InterruptedException {
        // ConcurrentHashMap
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        
        // Multiple threads modifying the map
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    String key = "Thread" + threadId + "-Item" + j;
                    concurrentMap.put(key, j);
                }
            });
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
        
        System.out.println("ConcurrentHashMap size: " + concurrentMap.size());
        
        // BlockingQueue
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
        
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    queue.put("Item-" + i);
                    System.out.println("Produced: Item-" + i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    String item = queue.take();
                    System.out.println("Consumed: " + item);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        
        System.out.println("Thread-safe collections demo completed");
    }
}

// Thread class by extending Thread
class MyThread extends Thread {
    private String threadName;
    
    public MyThread(String name) {
        this.threadName = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println(threadName + " completed");
    }
}

// Runnable implementation
class MyRunnable implements Runnable {
    private String taskName;
    
    public MyRunnable(String name) {
        this.taskName = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " - Iteration: " + i);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println(taskName + " finished");
    }
}

// Unsafe counter (without synchronization)
class UnsafeCounter implements Runnable {
    private String name;
    
    public UnsafeCounter(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Multithreading.sharedCounter++; // Race condition
        }
        System.out.println(name + " finished counting");
    }
}

// Safe counter (with synchronization)
class SafeCounter implements Runnable {
    private String name;
    
    public SafeCounter(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (Multithreading.lock) {
                Multithreading.sharedCounter++; // Thread-safe
            }
        }
        System.out.println(name + " finished counting safely");
    }
}

// Producer-Consumer classes
class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;
    
    public Buffer(int capacity) {
        this.capacity = capacity;
    }
    
    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait if buffer is full
        }
        queue.offer(item);
        System.out.println("Produced: " + item + " (Buffer size: " + queue.size() + ")");
        notifyAll(); // Notify consumers
    }
    
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if buffer is empty
        }
        int item = queue.poll();
        System.out.println("Consumed: " + item + " (Buffer size: " + queue.size() + ")");
        notifyAll(); // Notify producers
        return item;
    }
}

class Producer implements Runnable {
    private final Buffer buffer;
    
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        try {
            int item = 1;
            while (!Thread.currentThread().isInterrupted()) {
                buffer.produce(item++);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Producer stopped");
    }
}

class Consumer implements Runnable {
    private final Buffer buffer;
    
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }
    
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                buffer.consume();
                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " stopped");
    }
}

/*
 * Key Points:
 * 1. Two ways to create threads: extend Thread class or implement Runnable interface
 * 2. Runnable is preferred as it allows class to extend other classes
 * 3. Thread states: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED
 * 4. start() method creates new thread and calls run(), calling run() directly doesn't create new thread
 * 5. synchronized keyword ensures thread safety for critical sections
 * 6. wait(), notify(), and notifyAll() methods are used for thread communication
 * 7. join() method waits for thread to complete before proceeding
 * 8. Executor framework provides better thread management than manual thread creation
 * 9. Callable interface allows threads to return values and throw checked exceptions
 * 10. Future represents result of asynchronous computation
 * 11. Thread-safe collections like ConcurrentHashMap, BlockingQueue avoid manual synchronization
 * 12. Always handle InterruptedException properly
 * 
 * Thread Safety Guidelines:
 * - Use synchronized blocks/methods for shared mutable data
 * - Prefer concurrent collections over synchronized collections
 * - Use thread-local variables when appropriate
 * - Avoid calling synchronized methods from within synchronized blocks
 * - Use volatile keyword for simple flags and status variables
 * 
 * Best Practices:
 * - Use thread pools instead of creating threads manually
 * - Keep synchronized blocks as small as possible
 * - Prefer immutable objects for thread safety
 * - Use atomic classes (AtomicInteger, AtomicBoolean) for simple operations
 * - Always properly handle thread interruption
 * - Use CompletableFuture for complex asynchronous operations
 * - Avoid blocking operations in GUI threads
 */