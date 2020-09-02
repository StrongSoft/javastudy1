package codesignal;

/**
 * regur
 * 2020-02-07
 * 오후 2:18
 */
public class MakeArrayConsecutive {
    public static void main(String[] args) {
        makeArrayConsecutive2(new int[]{0,3});
    }
    public static int makeArrayConsecutive2(int[] statues){

        //정렬
        for (int i = 0; i < statues.length; i++) {
            for (int j = i+1; j < statues.length ; j++) {
                int temp;
                if(statues[i] > statues[j]){
                    temp = statues[i];
                    statues[i] = statues[j];
                    statues[j] = temp;
                }
            }
        }

        return ((statues[statues.length-1]-statues[0]) + 1) - statues.length;

    }
}
