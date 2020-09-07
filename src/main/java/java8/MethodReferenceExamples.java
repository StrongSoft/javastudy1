package java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReferenceExamples {
    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5)
                .forEach(System.out::println);

        System.out.println(Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                .stream()
                //.sorted((a1,b1) -> a1.compareTo(b1))
                //.sorted(BigDecimalUtils::compare)
                .sorted(BigDecimal::compareTo)
                .collect(Collectors.toList()));

        final String targetString = "c";

        System.out.println(
                Arrays.asList("a", "b", "c", "d")
                        .stream()
                        //.anyMatch(x -> x.equals("c"))
                        .anyMatch(targetString::equals)
        );

        int[] arr = {4, 2, 3, 1, 5};
        System.out.println(IntStream.of(arr)
                .boxed()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList()));

    }
}

class BigDecimalUtils {
    public static int compare(BigDecimal bd1, BigDecimal bd2) {
        return bd1.compareTo(bd2);
    }
}