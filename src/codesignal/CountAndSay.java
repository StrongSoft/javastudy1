package codesignal;

public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
    }

    public String countAndSay(int n) {
        int count = 1, i = 1;
        if (n == 1) return "1";

        String prev = "1";
        StringBuilder sb = new StringBuilder();

        while (i < n){
            for (int j = 0; j < prev.length()-1; j++) {
                if(prev.charAt(j) != prev.charAt(j+1)){
                    sb.append(count).append(prev.charAt(j));
                } else {
                    count++;
                }
            }

            sb.append(count).append(prev.charAt(prev.length()-1));

            prev = sb.toString();
            sb.setLength(0);

            count = 1;
            i++;
        }
        return prev;
    }


}
