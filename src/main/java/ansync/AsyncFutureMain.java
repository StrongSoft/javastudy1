package ansync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncFutureMain {
    public static void main(String[] args) {
        Shop shop = new Shop("Jay Shop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getAsyncPrice("Jay's Mac");
        //Future<Double> futurePrice = shop.getPrice("Jay's Mac");
        
        doSomethingElse();

        try{
            System.out.println("Price is " + futurePrice.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doSomethingElse() {
        System.out.println("What ??");
    }
}
