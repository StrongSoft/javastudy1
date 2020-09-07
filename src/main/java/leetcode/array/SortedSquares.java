package leetcode.array;

import java.util.Arrays;

public class SortedSquares {
    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        System.out.println(Arrays.toString(sortedSquares.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

    public int[] sortedSquares(int[] A) {
        int[] arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i]*A[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}
