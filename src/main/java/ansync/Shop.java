package ansync;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) + name.charAt(1) + name.charAt(2));
    }

/*    public Future<Double> getPrice(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }*/

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPriceString(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }

    //가격 계산 비동기
    public Future<Double> getAsyncPrice(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(
                () -> {
                    try {
                        double price = calculatePrice(product);
                        futurePrice.complete(price);
                    } catch (Exception e) {
                        futurePrice.completeExceptionally(e);
                    }
                }
        ).start();
        return futurePrice;
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public String getName() {
        return name;
    }

    private static void delay() {
        int delay = 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
