package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * regur
 * 2020-02-17
 * 오후 3:43
 */
public class CommonCharacterCount {
    public static void main(String[] args) {
        System.out.println(commonCharacterCount("aabcc","adcaa"));
    }

    static int commonCharacterCount(String s1, String s2) {

        List<String> listS1 = new ArrayList<String>();
        List<String> listS2 = new ArrayList<String>();

        for (int i = 0; i < s1.length(); i++) {
            listS1.add(s1.substring(i,i+1));
        }

        for (int i = 0; i < s2.length(); i++) {
            listS2.add(s2.substring(i,i+1));
        }

        int matchCnt = 0;
        for (int i = 0; i < listS1.size(); i++) {
            for (int j = 0; j < listS2.size(); j++) {
                if(listS1.get(i).equals(listS2.get(j))){
                    matchCnt++;
                    listS2.remove(j);
                    break;
                }
            }
        }
        return matchCnt;

    }
}
