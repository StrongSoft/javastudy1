package codesignal;

import java.util.ArrayList;
import java.util.Arrays;

public class TestEx {
    public static void main(String[] args) {
        TestEx testEx = new TestEx();
        System.out.println(Arrays.toString(testEx.solution(new int[]{1, 3, 2, 4, 2})));
    }
    public int[] solution(int[] answers) {
        int[] answer = new int[5];
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;

        //각 사용자별 정답수를 집계
        for (int i = 0; i < answer.length; i++) {
            if(a[i%a.length] == answers[i]){
                aCnt++;
            }
            if(b[i%b.length] == answers[i]){
                bCnt++;
            }
            if(c[i%c.length] == answers[i]){
                cCnt++;
            }
        }

        //최대갑 구하기
        int maxScore = Math.max(aCnt,Math.max(bCnt,cCnt));

        //정답 갯수가 max랑 같은 사용자를 찾어 리스트에 넣는다.
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(maxScore == aCnt) {arrayList.add(1);}
        if(maxScore == bCnt) {arrayList.add(2);}
        if(maxScore == cCnt) {arrayList.add(3);}

        //정렬 및 배열로 교환
        return arrayList.stream().mapToInt(i -> i.intValue()).toArray();
    }
}
