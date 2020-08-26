package leetcode.array;

import java.util.Comparator;
import java.util.stream.IntStream;

public class PeakIndexinaMountainArray {
    public static void main(String[] args) {
        peakIndexInMountainArray(new int[]{0, 1, 0});
        peakIndexInMountainArray(new int[]{0, 2, 1, 0});
        System.out.println(peakIndexInMountainArray(new int[]{3, 4, 5, 4, 6, 1}));
    }

    public static int peakIndexInMountainArray(int[] A) {

        //java8
        return IntStream.range(0,A.length)
                .boxed()
                .max(Comparator.comparing(i -> A[i]))
                .get();

        /*int maxValue = A[0];
        int peakIndex = 0;

        for (int i = 1; i < A.length; i++) {
            if (maxValue < A[i]) {
                maxValue = A[i];
                peakIndex = i;
            } else {
                break;
            }
        }

        return peakIndex;*/
    }
}
