package ansync;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ThreadMain {
    public static void main(String[] args) {
        /*Runnable task = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar : " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");*/

        /*ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }*/

        /*Callable<Integer> task = () ->{
          try{
              TimeUnit.SECONDS.sleep(2);
              return 123;
          } catch (InterruptedException e){
              throw new IllegalStateException("task interrupted",e);
          }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future done?" + future.isDone());

        Integer result = null;

        try {
            result = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println("future done?" +future.isDone());
        System.out.println("result : "+result);*/

        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables1 = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        try {
            executor.invokeAll(callables1)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables2 = Arrays.asList(
                callable("a1", 3),
                callable("a2", 1),
                callable("a3", 3)
        );

        String result = null;
        try {
            result = executor.invokeAny(callables2);
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("result : " + result);*/

        /*ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        try {
            TimeUnit.MILLISECONDS.sleep(1337);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms ", remainingDelay);

        int initialDelay = 0;
        int period = 1;
        //executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);

        executor.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.SECONDS);*/

    }

    static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }
}