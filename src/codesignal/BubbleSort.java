package codesignal;

import java.util.Arrays;

/**
 * regur
 * 2020-02-03
 * 오후 5:46
 */
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{2, 7, 8, 6, 4, 1, 3})));
    }

    public static int[] bubbleSort(int[] n){
        for (int i = 0; i < n.length; i++) {
            for (int j = i+1; j < n.length; j++) {
                int temp = n[i];
                if(n[i] > n[j]){
                    n[i] = n[j];
                    n[j] = temp;
                }
            }
        }
        return n;
    }
}
