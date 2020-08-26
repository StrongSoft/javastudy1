package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Greedy {
    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        System.out.println(greedy.solution(3, new int[]{2, 3}, new int[]{1}));
        System.out.println(greedy.solution(18, new int[]{7, 8, 11, 12}, new int[]{1, 6, 8, 10}));
        System.out.println(greedy.solution(24, new int[]{12, 13, 16, 17, 19, 20, 21, 22}, new int[]{1, 22, 16, 18, 9, 10}));
    }

    public int solution(int n, int[] lost, int[] reserve) {

        List<Integer> lostList = new ArrayList<>();
        for (int lostStudy : lost) {
            lostList.add(lostStudy);
        }

        List<Integer> reserveList = new ArrayList<>();
        for (int reserveStudy : reserve) {
            reserveList.add(reserveStudy);
        }

        for (int r : reserve) {
            int index = lostList.indexOf(r);
            if (index > -1) {
                lostList.remove(lostList.indexOf(r));
                reserveList.remove(reserveList.indexOf(r));
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!lostList.contains(i)) {
                resultList.add(i);
            } else {
                if(i == 1){
                    if (reserveList.contains(i+1)){
                        resultList.add(i);
                        reserveList.remove(reserveList.indexOf(i+1));
                    }
                } else if(i == n){
                    if (reserveList.contains(i-1)){
                        resultList.add(i);
                        reserveList.remove(reserveList.indexOf(i-1));
                    }
                } else {
                    if (reserveList.contains(i+1)){
                        resultList.add(i);
                        reserveList.remove(reserveList.indexOf(i+1));
                    } else if (reserveList.contains(i-1)){
                        resultList.add(i);
                        reserveList.remove(reserveList.indexOf(i-1));
                    }
                }
            }
        }
        int answer = resultList.size();

        return answer;
    }
}
