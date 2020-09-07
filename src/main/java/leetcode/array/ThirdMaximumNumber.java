package leetcode.array;

import java.util.Arrays;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3, 2, 1}));
        System.out.println(thirdMax(new int[]{2, 1}));
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    }
    public static int thirdMax(int[] nums) {
        int result = 0;
        //check edge case
        if(nums.length == 1){
            return nums[0];
        } else if (nums.length < 3) {
            if(nums[0] < nums[1]){
                result = nums[1];
                return result;
            } else {
                result = nums[0];
                return result;
            }
        } else {
            //내림차순 정렬
            Arrays.sort(nums);

            int third = 2;
            int temp = nums[nums.length-1];
            for (int i = nums.length-2; i >= 0 ; i--) {
                if (temp > nums[i]){
                    third--;
                    temp = nums[i];
                }
                if(third == 0){
                    result =  nums[i];
                    return result;
                }
            }

            //third number exist
            if(third > 0){
                result = nums[nums.length-1];
                return result;
            }
        }

        return result;
    }
}
