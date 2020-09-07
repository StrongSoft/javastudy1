package codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxCounters {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5,new int[]{3,4,4,6,1,4,4})));;
    }
    public static int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] result = new int[N];
        int nextMax = 0;
        int curMax = 0;
        for(int i = 0 ; i < A.length ; i++){
            int counterNumber = A[i];
            int counterIndex = counterNumber - 1;

            if(counterNumber < N+1){
                if(result[counterIndex] <= curMax){
                    result[counterIndex] = curMax;
                }
                result[counterIndex]++;
                nextMax = Math.max(nextMax, result[counterIndex]);
            }
            else{
                curMax = nextMax;
            }
        }

        for(int i = 0 ; i < result.length ; i++){
            if(result[i] < curMax){
                result[i] = curMax;
            }
        }
        return result;
    }
}
