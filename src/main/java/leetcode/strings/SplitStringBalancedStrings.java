package leetcode.strings;

public class SplitStringBalancedStrings {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
        System.out.println(balancedStringSplit("RLLRRRLLLR"));
    }

    public static int balancedStringSplit(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int left = 0, right = 0, score = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L')
                left++;
            else
                right++;
            if (left == right)
                score++;
        }
        return score;
    }
}
