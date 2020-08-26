package modenjava;

public class StreamApi03 {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            if(getRotto() ==  500){
                System.out.println("1등~~~ "+i);
                break;
            }
        }
    }

    private static int getRotto() {
        int[] factor = new int[]{500,300,100,50,10,1};
        int result = 1;
        for (int number : factor) {
            int rotto = (int) (Math.random() * number + 1);
            if (rotto == 1) {
                //System.out.println(number+"번째 당첨");
                result = number;
                break;
            }
        }
        return result;
    }
}
