package java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExamples5ParallePerformancePractical {

    private static final String[] priceStrings = {"1.0", "100.99", "35.75", "21.30", "88.00"};
    private static final BigDecimal[] targetPrices = {new BigDecimal("30"),new BigDecimal("20"),new BigDecimal("31")};
    private static final Random random = new Random(123);
    private static final Random targetRandom = new Random(111);

    private static final List<Product> products;

    static {
        final int length = 8_000_000;
        final Product[] list = new Product[length];

        for (int i = 1; i <= length; i++) {
            list[i - 1] = new Product((long) i, "Product" + i, new BigDecimal(priceStrings[random.nextInt(5)]));
        }
        products = Arrays.asList(list);
    }

    private static BigDecimal imperativeSum(final List<Product> products, final Predicate<Product> predicate) {
        BigDecimal sum = BigDecimal.ZERO;
        for (final Product product : products) {
            sum = sum.add(product.getPrice());
        }
        return sum;
    }

    private static BigDecimal streamSum(final Stream<Product> stream, final Predicate<Product> predicate) {
        return stream.filter(predicate).map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static void imperativeTest(BigDecimal targetPrice) {
        System.out.println("==============================");
        System.out.println("\nImperative Sum\n-------------------------------------------------");
        final long start = System.currentTimeMillis();
        System.out.println("Sum: " + imperativeSum(products, product -> product.getPrice().compareTo(targetPrice) >= 0));
        System.out.println("It took " + (System.currentTimeMillis() - start) + " ms.");
    }

    private static void streamSumTest(BigDecimal targetPrice) {
        System.out.println("==============================");
        System.out.println("\nStream Sum\n-------------------------------------------------");
        final long start = System.currentTimeMillis();
        System.out.println("Sum: " + streamSum(products.stream(), product -> product.getPrice().compareTo(targetPrice) >= 0));
        System.out.println("It took " + (System.currentTimeMillis() - start) + " ms.");
    }

    private static void ParallelStreamSumTest(BigDecimal targetPrice) {
        System.out.println("==============================");
        System.out.println("\nParallel Stream Sum\n-------------------------------------------------");
        final long start = System.currentTimeMillis();
        System.out.println("Sum: " + streamSum(products.parallelStream(), product -> product.getPrice().compareTo(targetPrice) >= 0));
        System.out.println("It took " + (System.currentTimeMillis() - start) + " ms.");
    }

    public static void main(String[] args) {
        final BigDecimal targetPrice = new BigDecimal("30");
        imperativeTest(targetPrice);
        streamSumTest(targetPrice);
        ParallelStreamSumTest(targetPrice);

        System.out.println("\nIgnore Tests Above\n===========================>");
        System.out.println("start");

        for (int i = 0; i < 5; i++) {
            BigDecimal price = targetPrices[targetRandom.nextInt(3)];
            imperativeTest(price);
            streamSumTest(price);
            ParallelStreamSumTest(price);
        }
    }

}

class Product {
    private Long id;
    private String name;
    private BigDecimal price;

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
