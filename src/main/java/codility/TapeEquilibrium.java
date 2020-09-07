package codility;

public class TapeEquilibrium {
    public static void main(String[] args) {
        /**
         *  A[0] = 9  A[1] = 3  A[2] = 9
         *   A[3] = 3  A[4] = 9  A[5] = 7
         *   A[6] =
         */
        System.out.println(solution(new int[]{3,1,2,4,3}));
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8

        int min = Integer.MAX_VALUE;
        int total = 0;
        int size = A.length;
        int pSum = 0;
        int nSum = 0;
        for (int j : A) {
            total += j;
        }

        for (int i = 1; i < size; i++) {
            pSum += A[i-1];
            nSum = total - pSum;
            min = Math.min(min, Math.abs(pSum-nSum));
        }
        return min;
    }
}
