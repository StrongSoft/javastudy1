package leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeightChecker {
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1,1,4,2,1,3}));
        System.out.println(heightChecker(new int[]{5,1,2,3,4}));
        System.out.println(heightChecker(new int[]{1,2,3,4,5}));
    }
    public static int heightChecker(int[] heights) {

        // clone
        int[] targetArr = heights.clone();
        // sort asc
        Arrays.sort(targetArr);

        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != targetArr[i]){
                result++;
            }
        }

        List<Integer> list = Arrays.stream(heights).boxed().collect(Collectors.toList());

        return result;
    }
}
