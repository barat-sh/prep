package advanced;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadingExample {
    
    public static void main(String[] args) throws Exception {
        // Basic thread creation
        basicThreads();
        
        // Thread synchronization
        synchronization();
        
        // Executor framework
        executorFramework();
        
        // Concurrent collections
        concurrentCollections();
        
        // Atomic variables
        atomicVariables();
        
        // CompletableFuture example
        completableFutureExample();
        
        // Virtual threads (Java 19+)
        if (Runtime.version().feature() >= 19) {
            virtualThreads();
        }
    }
    
    // Basic thread creation using Thread class and Runnable interface
    private static void basicThreads() throws InterruptedException {
        System.out.println("\n=== Basic Thread Creation ===");
        
        // Extending Thread class
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Running thread created by extending Thread class");
            }
        };
        
        // Using Runnable interface
        Thread thread2 = new Thread(() -> {
            System.out.println("Running thread created with Runnable lambda");
        });
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
    }
    
    // Thread synchronization example
    private static void synchronization() throws InterruptedException {
        System.out.println("\n=== Thread Synchronization ===");
        
        Counter counter = new Counter();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("Counter value: " + counter.getCount());
    }
    
    // Executor framework example
    private static void executorFramework() throws InterruptedException {
        System.out.println("\n=== Executor Framework ===");
        
        // Fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + 
                                   Thread.currentThread().getName());
                try {
                    Thread.sleep(100); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return "Task " + taskId + " result";
            });
        }
        
        // Shutdown the executor
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
    
    // Concurrent collections example
    private static void concurrentCollections() {
        System.out.println("\n=== Concurrent Collections ===");
        
        // ConcurrentHashMap example
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        
        // Thread-safe update
        map.compute("one", (k, v) -> v == null ? 1 : v + 10);
        
        System.out.println("ConcurrentHashMap: " + map);
        
        // CopyOnWriteArrayList example
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        
        // Thread-safe iteration (snapshot)
        for (String item : list) {
            System.out.println("Item: " + item);
            // Modifications during iteration are allowed but not reflected in current iteration
            list.add("new item"); // This won't cause ConcurrentModificationException
            break; // Adding just one to avoid infinite loop
        }
        
        System.out.println("CopyOnWriteArrayList size: " + list.size());
    }
    
    // Atomic variables example
    private static void atomicVariables() throws InterruptedException {
        System.out.println("\n=== Atomic Variables ===");
        
        AtomicInteger atomicCounter = new AtomicInteger(0);
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet();
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        System.out.println("AtomicInteger value: " + atomicCounter.get());
    }
    
    // CompletableFuture example
    private static void completableFutureExample() throws ExecutionException, InterruptedException {
        System.out.println("\n=== CompletableFuture Example ===");
        
        // Create and complete a future
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100); // Simulate async work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result from async operation";
        });
        
        // Chain operations
        CompletableFuture<String> transformedFuture = future
            .thenApply(result -> result + " - transformed")
            .thenApply(result -> result + " - again");
        
        // Get the result
        System.out.println(transformedFuture.get());
        
        // Combining futures
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "First");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Second");
        
        CompletableFuture<String> combined = future1.thenCombine(future2, (f1, f2) -> f1 + " + " + f2);
        
        System.out.println("Combined result: " + combined.get());
    }
    
    // Virtual threads example (Java 19+)
    private static void virtualThreads() throws InterruptedException {
        System.out.println("\n=== Virtual Threads (Java 19+) ===");
        
        // Create and start many virtual threads
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Launch a million virtual threads (would be impractical with platform threads)
            int threadCount = 100; // Reduced for demonstration
            CountDownLatch latch = new CountDownLatch(threadCount);
            
            for (int i = 0; i < threadCount; i++) {
                final int id = i;
                executor.submit(() -> {
                    try {
                        Thread.sleep(10); // Simulate some work
                        if (id < 5) { // Only print a few to avoid excessive output
                            System.out.println("Virtual thread " + id + " executed");
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        latch.countDown();
                    }
                });
            }
            
            latch.await(5, TimeUnit.SECONDS);
            System.out.println("Completed " + threadCount + " virtual threads");
        }
    }
    
    // Example class for synchronization
    static class Counter {
        private int count = 0;
        
        // Synchronized method
        public synchronized void increment() {
            count++;
        }
        
        public int getCount() {
            return count;
        }
    }
}