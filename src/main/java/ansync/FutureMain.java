package ansync;

import java.util.concurrent.*;

public class FutureMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(FutureMain::someLongComputation);

        doSomethingElse();

        try{
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println("result : "+result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static void doSomethingElse() {
        System.out.println("What ??");
    }

    private static Double someLongComputation() {
        return 1d;
    }
}
