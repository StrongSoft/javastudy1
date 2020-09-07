package codesignal;

public class RotateImage {
    public static void main(String[] args) {
        rotateImage(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        rotateImage(new int[][]{{1}});
        rotateImage(new int[][]{{10, 9, 6, 3, 7}, {6, 10, 2, 9, 7}, {7, 6, 3, 8, 2}, {8, 9, 7, 9, 9}, {6, 8, 6, 8, 2}});
    }

    static int[][] rotateImage(int[][] a) {
        int size = a.length;
        int[][] result = new int[size][size];
        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                result[j][k] = a[size - 1 - k][j];
            }
        }
        return result;
    }
}
