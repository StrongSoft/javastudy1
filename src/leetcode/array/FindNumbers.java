package leetcode.array;

public class FindNumbers {
    public static void main(String[] args) {
        FindNumbers findNumbers = new FindNumbers();
        System.out.println(findNumbers.findNumbers(new int[]{12,345,2,6,7896}));
    }
    public int findNumbers(int[] nums) {
        int max = 0;
        for(int n  : nums){ if(String.valueOf(n).length()%2 == 0) max++; }
        return max;
    }


}
