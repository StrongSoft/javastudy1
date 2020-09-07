package leetcode.array;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

    public static int[] sortedSquares(int[] A) {
        //제곱
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }

        Arrays.sort(A);

        return A;
    }
}
