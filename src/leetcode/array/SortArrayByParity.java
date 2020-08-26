package leetcode.array;

public class SortArrayByParity {
    public static void main(String[] args) {
        sortArrayByParity(new int[]{3, 1, 2, 4});
        sortArrayByParity(new int[]{0, 1});
        sortArrayByParity(new int[]{0, 2});
    }

    public static int[] sortArrayByParity(int[] A) {
        int[] arr = new int[A.length];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int number : A) {
            if (number % 2 == 0) {
                arr[evenIndex] = number;
                evenIndex++;
            } else {
                arr[arr.length - 1 - oddIndex] = number;
                oddIndex++;
            }
        }
        return arr;
    }
}
