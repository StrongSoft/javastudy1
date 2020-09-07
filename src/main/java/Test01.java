import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        System.out.println(solution(8,0));
        System.out.println(solution(18,2));
        System.out.println(solution(10,10));
    }
    public static int solution(int N, int K) {
        // write your code in Java SE 8
        int chip = N;
        int round = 0;
        while (chip!=1){ //chip이 1(초기값) 까지 loop
            System.out.println("chip : "+chip);
            if(K > 0 && chip%2 == 0){ //N이 짝수일때 올
                chip = chip/2;
                K = K -1; //all-in 사
            } else { //all-in 이 아닐때는 1씩 차
                chip = chip-1;
            }
            round += 1;
        }
        System.out.println("N : "+ N + " round : "+round);
        return round;
    }
}
