package leetcode.array;

public class ArrangingCoins {
    public static void main(String[] args) {
        arrangeCoins(11);
    }
    public static int arrangeCoins(int n) {
        if (n <= 0) return 0;
        if (n == Integer.MAX_VALUE) return 65535;

        int total = 0, level = 0;
        while (total < n) {
            level++;
            total += level;
            System.out.println("total : "+total+ " level : "+level);
        }

        return total == n ? level : level - 1;
    }
}
