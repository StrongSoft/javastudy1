package testdom;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> setStr = new HashSet<String>();

        Collections.addAll(setStr, names1);
        Collections.addAll(setStr, names2);

        String[] result = new String[setStr.size()];
        int index = 0;
        for(String str: setStr){
            result[index] = str;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}