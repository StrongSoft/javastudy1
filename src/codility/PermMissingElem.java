package codility;

import java.util.Arrays;

public class PermMissingElem {
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

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if(i+1 != A[i]) return i+1;
        }
        return A.length+1;
    }
}
