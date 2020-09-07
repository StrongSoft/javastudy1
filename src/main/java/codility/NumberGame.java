package codility;

import java.util.ArrayList;
import java.util.Collections;

public class NumberGame {

    public static void main(String[] args) {
        NumberGame game = new NumberGame();
        System.out.println(game.solution(new int[]{7, 5, 8, 10, 6, 9, 5}));
    }

    public int solution(int[] paper) {
        ArrayList newList = new ArrayList();
        //먼저 0값은 계산에 사용되지 않으므로, 이를 제거

        for (int i = 0; i < paper.length; i++) {
            if (paper[i] != 0) {
                newList.add(paper[i]);
            }
        }

        //먼저 역순으로 정렬
        Collections.sort(newList);
        System.out.println(newList);
        Collections.reverse(newList);
        System.out.println(newList);

        int gVal = 0; //
        int gNum = 0; //g의 최대값
        for (int k = 0; k < newList.size(); k++) {
            gVal += (int) newList.get(k);
            int checkNum = (k + 1) * (k + 1);
            System.out.println(gVal+" : "+checkNum);
            if (gVal < checkNum) {
                gNum = k - 1;
                break;
            }
            if (k == newList.size() - 1) {
                gNum = newList.size();
            }
        }
        System.out.println("k ==" + gNum);
        return gNum;
    }
}
