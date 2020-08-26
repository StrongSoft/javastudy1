package leetcode.array;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {
        //0의 개수를 먼저 탐색
        int zeros = 0;
        int index = 0;
        for (int num : nums) {
            if(num != 0){
                nums[index] = num;
                index++;
            } else{
                zeros++;
            }
        }
        for (int i = zeros; i > 0 ; i--) {
            nums[nums.length-i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
