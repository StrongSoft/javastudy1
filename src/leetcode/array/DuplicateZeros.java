package leetcode.array;

import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros zeros = new DuplicateZeros();
        //zeros.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        //[0,0,1,7,6,0,0,2]
        zeros.duplicateZeros(new int[]{0,1,7,6,0,2,0,7});
    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i+1; j--) {
                    arr[j] = arr[j-1];
                }
                arr[i+1] = 0;
                i++;
            }
            System.out.println("arr[i] : "+arr[i]+" : "+Arrays.toString(arr));
        }
    }
}
