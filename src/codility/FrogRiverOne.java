package codility;

import java.util.HashMap;
import java.util.Map;

public class FrogRiverOne {
    public static void main(String[] args) {
        /**
         *  A[0] = 9  A[1] = 3  A[2] = 9
         *   A[3] = 3  A[4] = 9  A[5] = 7
         *   A[6] =
         */
        System.out.println(solution(5,new int[]{1,3,1,4,2,3,5,4}));
        System.out.println(solution(2,new int[]{2, 2, 2, 2, 2}));
    }
    public static int solution(int X, int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if(A[i] <= X){
                numMap.put(A[i],A[i]);
            }
            if(numMap.size() == X){
                return i;
            }
        }
        return -1;
    }
}
