package codility;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,3,9,3,9,7,9}));
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> strMap = new HashMap<>();
        for(int number : A){
            strMap.put(number,strMap.getOrDefault(number,0)+1);
        }
        for(Map.Entry<Integer, Integer> map : strMap.entrySet()){
            if(!(map.getValue() % 2 == 0)){
                return map.getKey();
            }
        }
        return 0;
    }
}
