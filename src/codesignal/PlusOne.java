package codesignal;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }
    public static int[] plusOne(int[] digits){
        int size = digits.length;
        if(digits[size-1] > 8){
            int[] result = new int[size+1];
            for (int i = size-1; i >= 0; i--) {
                System.out.println(i+" : "+digits[i]);
                if(digits[i] > 8){
                    digits[i] = 0;
                } else {
                    digits[i] = digits[i]+1;
                    break;
                }
            }
            if(digits[0] == 0){
                result[0] = 1;
                for (int i = 1; i < size; i++) {
                    result[i+1] = digits[i];
                }
                return result;
            } else {
                return digits;
            }
        } else {
            digits[size-1] = digits[size-1]+1;
            return digits;
        }
    }

}
