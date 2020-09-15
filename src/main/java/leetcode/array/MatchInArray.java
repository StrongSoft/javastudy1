package leetcode.array;

import java.util.*;

public class MatchInArray {
    public static void main(String[] args) {
        stringMatching(new String[]{"mass","as","hero","superhero"});
    }

    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int size = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length)); //정렬
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if(words[j].contains(words[i])){
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
