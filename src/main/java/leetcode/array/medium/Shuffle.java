package leetcode.array.medium;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shuffle {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,2,3});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
    }

    static class Solution {
        private int[] arr;

        public Solution(int[] nums) {
            //this.arr = new int[nums.length];
            this.arr = nums.clone();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return arr;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
            Collections.shuffle(list, ThreadLocalRandom.current());
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
