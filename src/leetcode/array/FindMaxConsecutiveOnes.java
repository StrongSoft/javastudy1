package leetcode.array;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        FindMaxConsecutiveOnes linkedList = new FindMaxConsecutiveOnes();
        System.out.println(linkedList.findMaxConsecutiveOnes(new int[]{1,0}));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
            } else {
                count = 0;
            }
            if(max < count){
                max = count;
            }
        }
        return max;
    }

}
