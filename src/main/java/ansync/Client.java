package ansync;

public class Client {
    public static void main(String[] args) {
        PriceFinder priceFinder = new PriceFinder();
        long start1 = System.nanoTime();
        System.out.println(priceFinder.findPrices("Mac"));
        long duration = (System.nanoTime() - start1) / 1_000_000;
        System.out.println("완료 시간: " + duration + " msecs");

        long start2 = System.nanoTime();
        System.out.println(priceFinder.parallelFindPrices("Mac"));
        long duration2 = (System.nanoTime() - start2) / 1_000_000;
        System.out.println("완료 시간: " + duration2 + " msecs");

        long start3 = System.nanoTime();
        System.out.println(priceFinder.completableFindPrices("Mac"));
        long duration3 = (System.nanoTime() - start3) / 1_000_000;
        System.out.println("완료 시간: " + duration3 + " msecs");

        long start4 = System.nanoTime();
        System.out.println(priceFinder.executorFindPrices("Mac"));
        long duration4 = (System.nanoTime() - start4) / 1_000_000;
        System.out.println("완료 시간: " + duration4 + " msecs");

        long start5 = System.nanoTime();
        System.out.println(priceFinder.blockFindPrices("Mac"));
        long duration5 = (System.nanoTime() - start5) / 1_000_000;
        System.out.println("완료 시간: " + duration5 + " msecs");

        long start6 = System.nanoTime();
        System.out.println(priceFinder.mixFindPrices("Mac"));
        long duration6 = (System.nanoTime() - start6) / 1_000_000;
        System.out.println("완료 시간: " + duration6 + " msecs");

    }
}
