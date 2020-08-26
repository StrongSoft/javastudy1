package algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
    public static void moveZeroes(int[] nums) {
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            if(nums[i] != 0){
                nums[index] =  nums[i];
                index++;
            } else {
                count++;
            }
        }
        for (int i = 0; i < count ; i++) {
            nums[nums.length-(1+i)] = 0;
        }
    }
}
