package programmers;

public class Test01 {
    public static void main(String[] args) {
        System.out.println(solution("abcde"));
        System.out.println(solution("qwer"));
    }

    public static String solution(String s) {
        int helf = s.length() / 2;
        if (s.length() % 2 == 0) {
            return s.substring(helf - 1, helf - 1 + 2);
        } else {
            return s.substring(helf, helf + 1);
        }
    }
}
