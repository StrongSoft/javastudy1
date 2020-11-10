package ansync;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Synchronized01 {
    private static int count = 0;

    public static void main(String[] args) {
        testSyncIncrement();
    }

    public static void testSyncIncrement(){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(Synchronized01::increment));

        ConcurrentUtils.stop(executor);

        System.out.println(count);
    }

    private static void increment() {
        count = count + 1;
    }

}
