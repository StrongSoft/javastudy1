package codesignal;

/**
 * regur
 * 2020-02-10
 * 오후 5:10
 */
public class AlmostIncreasingSequence {
    public static void main(String[] args) {
        almostIncreasingSequenceMain(new int[]{1,3,2});
    }

    public static boolean almostIncreasingSequenceMain(int[] sequence){

        int successCount = 0;

        for (int i = 0; i < sequence.length; i++) {
            int max = 0;
            int failCount = 0;
            for (int j = 0; j < sequence.length; j++) {
                if(j == 0){
                    if(i==j){
                        max = sequence[j+1];
                    } else {
                        max = sequence[j];
                    }
                } else {
                    if(i != j){
                        if(max < sequence[j]){
                            max = sequence[j];
                        } else {
                            failCount++;
                            break;
                        }
                    }

                }
            }
            if(failCount == 0){
                successCount++;
            }

        }

        if(successCount > 0){
            return true;
        } else {
            return false;
        }


    }
}
