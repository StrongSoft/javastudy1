package codility;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        /*try {
            Class cls = Class.forName("Constructor2");
            Class partypes[] = new Class[2];
            partypes[0] =  Integer.TYPE;
            partypes[1] =  Integer.TYPE;
            Constructor ct = cls.getConstructor(partypes);
            Object arglist[] = new Object[2];
            arglist[0] = new Integer(37);
            arglist[1] = new Integer(47);
            Object retObj = ct.newInstance(arglist);
        } catch (Throwable e) {
            System.out.println(e);
        }*/


        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6},3)));
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4},4)));
    }

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if(A.length == K){
            return A;
        } else if(A.length < 1) {
            return A;
        } else {
            int size = A.length;
            while(K>0){
                int temp = A[size-1];
                for (int i = size-1;  i > 0; i--) {
                    A[i] = A[i-1];
                }
                A[0] = temp;
                K--;
            }
            return A;
        }
    }
}
