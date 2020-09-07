package leetcode.array;

import java.util.*;

public class DoubleExist {
    public static void main(String[] args) {
        DoubleExist exist = new DoubleExist();
        System.out.println(exist.checkIfExist(new int []{-2,0,10,-19,4,6,-8}));
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int i : arr) {
            if (seen.contains(2 * i) || i % 2 == 0 && seen.contains(i / 2))
                return true;
            seen.add(i);
        }
        return false;
    }
}
