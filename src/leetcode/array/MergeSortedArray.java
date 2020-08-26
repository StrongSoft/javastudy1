package leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6}, 3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length == m+n){
            for (int i = 0; i < n; i++) {
                nums1[m+i] = nums2[i];
            }
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
