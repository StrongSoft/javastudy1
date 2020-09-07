package leetcode.array;

import java.util.Arrays;

public class InPlaceArray {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
        removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
    public static int[] replaceElements(int[] arr) {
        /**
         * 1 <= arr.length <= 10^4
         * 1 <= arr[i] <= 10^5
         */
        // Check for edge cases.
        if(arr == null || arr.length == 0){
            return arr;
        }

        int max = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0 ; i--) {
            int current = arr[i];
            if(current > max){
                arr[i] = max;
                max = current;
            } else {
                arr[i] = max;
            }
        }
        arr[arr.length-1] = -1;

        return arr;
    }

    public static int removeDuplicates(int[] nums) {

        //check edge case
        if(nums.length == 0){
            return nums.length;
        }

        int temp = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (temp != nums[i]) {
                index++;
                nums[index] = nums[i];
                temp = nums[i];
            }
        }
        index++;
        System.out.println(Arrays.toString(nums));
        System.out.println(index);
        return index;
    }
}
