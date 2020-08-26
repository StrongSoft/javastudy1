package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * regur
 * 2020-02-18
 * 오후 8:28
 */
public class FirstDuplicate {
    public static void main(String[] args) {

    }

    int test(int[] a){
        int min = a.length;
        for (int i = 0; i < a.length; i++) {
            int min2 = 0;
            for (int j = 0; j < a.length; j++) {
                if(a[i] == a[j]){
                    min2 = j;
                    break;
                }
                min = (min2 != 0) && (min > min2)?min2:min;
            }
        }
        return (min ==a.length)?-1:a[min];
    }
}
