package leetcode.array;

public class MonotonicArray {
    public static void main(String[] args) {
        //System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));
        //System.out.println(isMonotonic(new int[]{6, 5, 4, 4}));
        //System.out.println(isMonotonic(new int[]{1, 3, 2}));
        System.out.println(onePass(new int[]{-5,-5,-5,-5,-2,-2,-2,-1,-1,-1,0}));
        //System.out.println(isMonotonic(new int[]{1, 1, 1}));
    }

    public static boolean isMonotonic(int[] A) {
        return increasing(A) || decreasing(A);
    }

    private static boolean increasing(int[] A){
        for (int i = 0; i < A.length-1; i++)
            if(A[i] > A[i+1]) return false;
        return true;
    }

    private static boolean decreasing(int[] A){
        for (int i = 0; i < A.length-1; i++)
            if(A[i] < A[i+1]) return false;
        return true;
    }

    public static boolean onePass(int[] A){
        int store = 0;
        for (int i = 0; i < A.length-1; i++) {
            int c = Integer.compare(A[i],A[i+1]);
            if(c != 0){
                if(c != store && store !=0  )
                    return false;
                store = c;
            }
        }
        return true;
    }
}
