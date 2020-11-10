package ansync;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class PriceFinder {
    private final List<Shop> shops = Arrays.asList(
            new Shop("CoolPang"),
            new Shop("HMarket"),
            new Shop("12th Street"),
            new Shop("YouMakePrice"),
            new Shop("FBay"));

    //병렬 쓰레드 만들기
    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    //블로킹 호출
    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s 가격은 %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    //병렬 스트림 요청
    public List<String> parallelFindPrices(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s 가격은 %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    //CompletableFuture 비동기 요청
    public List<String> completableFindPrices(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s 가격은 %.2f", shop.getName(), shop.getPrice(product))))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

    }

    //Executor 로 CompletableFuture 를 최적화
    public List<String> executorFindPrices(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s 가격은 %.2f", shop.getName(), shop.getPrice(product)), executor))
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    //블로킹 호출
    public List<String> blockFindPrices(String product) {
        return shops.stream()
                .map(shop -> shop.getPriceString(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    //동기와 비동기 작업 조합
    public List<String> mixFindPrices(String product) {
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