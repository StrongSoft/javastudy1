package codesignal;

/**
 * regur
 * 2020-02-19
 * 오후 2:11
 */
public class FirstNotRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(notRepeating("abacabad"));
    }

    static char notRepeating(String s){
        String result = "_";
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() ; j++) {
                if(i!=j && s.charAt(i) == s.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return s.charAt(i);
            }
        }
        return "_".charAt(0);
    }
}
