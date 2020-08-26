package algorithm;

import java.util.Arrays;

import static java.util.stream.Collectors.*;

public class ClothesHash {
    public static void main(String[] args) {
        ClothesHash clothesHash = new ClothesHash();
        System.out.println(clothesHash.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
    public int solution(String[][] clothes) {
        /*int answer = 1;
        Map<String,Integer> clothesMap = new HashMap<>();
        for (String[] c:clothes) {
            clothesMap.put(c[1], clothesMap.getOrDefault(c[1],0)+1);
        }
        for (String key : clothesMap.keySet()) {
            answer *= clothesMap.get(key)+1;
        }
        answer--;

        return answer;*/
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x,y) -> x * (y+1))).intValue() -1;
    }
}
