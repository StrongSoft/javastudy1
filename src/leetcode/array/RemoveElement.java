package leetcode.array;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement element = new RemoveElement();
        element.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int num: nums){
            if(num != val){
                nums[index++] = num;
            }
        }
        return index;
    }
}
