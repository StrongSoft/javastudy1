package algorithm;

import java.util.HashMap;

public class FirstUniqChar {
    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s){
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}