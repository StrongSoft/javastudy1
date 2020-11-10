package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5)));
        System.out.println(Arrays.toString(solution(new int[]{2, 36, 1, 3}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 6}, 10)));
    }

    public static int[] solution(int[] arr, int divisor) {
        List<Integer> temp = new ArrayList<>();
        for (int number : arr) {
            if (number % divisor == 0) {
                temp.add(number);
            }
        }

        if (temp.size() == 0) {
            return new int[]{-1};
        }

        Collections.sort(temp);

        int[] resultArr = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            resultArr[i] = temp.get(i);
        }

        return resultArr;
    }
}
