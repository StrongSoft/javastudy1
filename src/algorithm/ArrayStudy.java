package algorithm;

/**
 * regur
 * 2020-04-16
 * 오후 2:16
 */
public class ArrayStudy {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result^= nums[i];
        }
        return result;
    }
}
