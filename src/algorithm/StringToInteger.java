package algorithm;

public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger integer = new StringToInteger();
        System.out.println(integer.myAtoi("20000000000000000000"));
    }

    public int myAtoi(String str) {
        if (str.length() < 1) {
            return 0;
        } else {
            str = str.trim();
            boolean isneg = false;
            if (str.startsWith("-")) {
                isneg = true;
                str = str.substring(1);
            } else if (str.startsWith("+")) {
                str = str.substring(1);
            }
            int result = 0;
            for (int i = 0; i < str.length(); i++) {
                System.out.println(result);
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    if (isneg) {
                        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && c > '8')) {
                            return Integer.MIN_VALUE;
                        }
                    } else {
                        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && c > '7')) {
                            return Integer.MAX_VALUE;
                        }
                    }
                    result = result * 10 + (c - '0');
                } else {
                    return isneg ? -1 * result : result;
                }
            }
            return isneg ? -1 * result : result;
        }
    }
}
