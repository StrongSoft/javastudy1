package ansync;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class PriceFinder {
    private final List<Shop> shops = Arrays.asList(
            new Shop("CoolPang"),
            new Shop("HMarket"),
            new Shop("12th Street"),
            new Shop("YouMakePrice"),
            new Shop("FBay"));

    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s 가격은 %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> parallelFindPrices(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s 가격은 %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> completableFindPrices(String product) {
        List<CompletableFuture<String>> priceFutures = (List<CompletableFuture<String>>) shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s 가격은 %.2f", shop.getName(), shop.getPrice(product))))
                .collect(Collectors.toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

    }
    public List<String> executorFindPrices(String product){
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s 가격은 %.2f", shop.getName(), shop.getPrice(product)), executor))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public List<String> blockFindPrices(String product){
        return shops.stream()
                .map(shop -> shop.getPriceString(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public List<String> mixFindPrices(String product){
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceString(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}