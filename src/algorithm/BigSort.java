package algorithm;

public class BigSort {
    public static void main(String[] args) {
        BigSort sort = new BigSort();
        System.out.println(sort.solution(new int[]{6, 10, 2}));
    }

    public String solution(int[] numbers) {
        String answer = "";
        String maxstr = "0";
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String startStr = String.valueOf(numbers[i]).substring(0,1);
            if(Integer.parseInt(maxstr) < Integer.parseInt(startStr)){
                maxstr = startStr;
            }
            for (int j = i+1; j < numbers.length; j++) {
                if(i != j){
                    String secoundStr = String.valueOf(numbers[j]).substring(0,1);
                    System.out.println("startStr : "+startStr+" secoundStr : "+secoundStr+" maxstr : "+maxstr);
                    if (Integer.parseInt(maxstr) < Integer.parseInt(secoundStr)){
                        maxstr = secoundStr;
                    }
                }
            }
        }

        return answer;
    }
}
