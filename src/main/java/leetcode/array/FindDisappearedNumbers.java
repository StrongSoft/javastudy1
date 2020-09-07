package leetcode.array;

import java.util.*;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        findDisappearedNumbers(new int[]{});
        findDisappearedNumbers(new int[]{1,1});
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        //check edge case
        if(nums.length == 0){
            return resultList;
        }

        //중복 제거
        for (int number:nums) {
            set.add(number);
        }

        //정렬
        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)){
                resultList.add(i);
            }
        }

        return resultList;
    }
}
