package java8;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParalleStream {
    public static void main(String[] args) {
        final long n = 1_000;

        final long start1 = System.currentTimeMillis();
        System.out.println("    iterativeSum(n): "+iterativeSum(n));
        System.out.println("                     "+(System.currentTimeMillis() - start1) +" ms\n");

        final long start2 = System.currentTimeMillis();
        System.out.println("   sequentialSum(n): "+sequentialSum(n));
        System.out.println("                     "+(System.currentTimeMillis() - start2) +" ms\n");

        final long start3 = System.currentTimeMillis();
        System.out.println("      paralleSum(n): "+paralleSum(n));
        System.out.println("                     "+(System.currentTimeMillis() - start3) +" ms\n");

        final long start4 = System.currentTimeMillis();
        System.out.println("       rangedSum(n): "+rangedSum(n));
        System.out.println("                     "+(System.currentTimeMillis() - start4) +" ms\n");

        final long start5 = System.currentTimeMillis();
        System.out.println("paralleRangedSum(n): "+paralleRangedSum(n));
        System.out.println("                     "+(System.currentTimeMillis() - start5) +" ms\n");
    }


    private static void slowDown(){
        try {
            TimeUnit.MILLISECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static long iterativeSum(long n){
        long result = 0;
        for (long i = 0; i <= n ; i++) {
            result += i;
            slowDown();
        }
        return result;
    }

    public static long sequentialSum(long n){
        return Stream.iterate(1L, i -> i + 1).limit(n).peek(i -> slowDown()).reduce(Long::sum).get();
    }

    public static long paralleSum(long n){
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().peek(i -> slowDown()).reduce(Long::sum).get();
    }

    public static long rangedSum(long n){
        return LongStream.rangeClosed(1, n).peek(i -> slowDown()).reduce(Long::sum).getAsLong();
    }

    public static long paralleRangedSum(long n){
        return LongStream.rangeClosed(1, n).parallel().peek(i -> slowDown()).reduce(Long::sum).getAsLong();
    }
}
