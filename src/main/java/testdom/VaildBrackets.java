package testdom;

import java.util.Arrays;
import java.util.List;

public class VaildBrackets {

    public static boolean isValid(String brackets) {
        List<String> openStrings = Arrays.asList("(", "{", "[");
        List<String> closeStrings = Arrays.asList(")", "}", "]");

        int half = brackets.length() / 2;
        for (int i = 0; i < half; i++) {
            int index = openStrings.indexOf(String.valueOf(brackets.charAt(half - 1 - i)));
            String target = closeStrings.get(index);
            if (target.charAt(0) != brackets.charAt(half + i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(VaildBrackets.isValid("[{()}]"));
        System.out.println(VaildBrackets.isValid("()"));
        System.out.println(VaildBrackets.isValid("([])"));
        System.out.println(VaildBrackets.isValid("{}"));
        System.out.println(VaildBrackets.isValid("[{"));
        System.out.println(VaildBrackets.isValid("[{]}"));
    }
}
