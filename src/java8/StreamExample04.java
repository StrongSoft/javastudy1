package java8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamExample04 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};

        System.out.println(Arrays.toString(IntStream.of(arr)
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .distinct()
                .toArray()));


    }
}
