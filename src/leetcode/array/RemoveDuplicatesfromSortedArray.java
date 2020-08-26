package leetcode.array;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray array = new RemoveDuplicatesfromSortedArray();
        array.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    public int removeDuplicates(int[] nums) {
        int temp = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (temp != nums[i]) {
                index++;
                nums[index] = nums[i];
                temp = nums[i];
            }
        }
        return index;
    }
}