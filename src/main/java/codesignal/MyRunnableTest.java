package codesignal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

class MyRunnableTest {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
        new Product(1L, "A", new BigDecimal("10.00")),
        new Product(2L, "B", new BigDecimal("55.50")),
        new Product(3L, "C", new BigDecimal("17.45")),
        new Product(4L, "D", new BigDecimal("23.00")),
        new Product(5L, "E", new BigDecimal("110.99")));

        Function<Integer, String> f = i -> String.valueOf(i);
        System.out.println(f.apply(10));

        final BigDecimal twenty = new BigDecimal("20");
        List<Product> productList = filter(products, product -> product.getPrice().compareTo(twenty) >= 0);
        System.out.println(filter(productList, product -> product.getPrice().compareTo(new BigDecimal("50")) < 0));
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        final List<T> result = new ArrayList<>();
        for(final T t : list){
            if(predicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    static class Product{
        private Long id;
        private String name;
        private BigDecimal price;

        public Product() {
        }

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

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return Objects.equals(id, product.id) &&
                    Objects.equals(name, product.name) &&
                    Objects.equals(price, product.price);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, price);
        }
    }
}