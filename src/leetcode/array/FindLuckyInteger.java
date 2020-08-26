package leetcode.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindLuckyInteger {

    public static void main(String[] args) {
        findLucky(new int[]{5,4,7,8,4,8,8,3,7,7,6,3,7,6,5,6,8,4,5,7,4,7,7,5,2,5,6,6,8,1,6,8,8,8,9,3,2,9});
        findLucky(new int[]{1,2,2,3,3,3});
        findLucky(new int[]{2,2,2,3,3});
        findLucky(new int[]{5});
        findLucky(new int[]{7,7,7,7,7,7,7});
    }

    public static int findLucky(int[] arr) {
        //stream
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey() == entry.getValue().intValue())
                .map(entry -> entry.getKey())
                .max(Integer::compare)
                .orElse(-1);

        //map
        /*Map<Integer, Integer> arrList = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arrList.put(arr[i], arrList.getOrDefault(arr[i],0)+1);
        }

        Iterator<Integer> keys = arrList.keySet().iterator();
        int result = -1;
        while (keys.hasNext()){
            Integer key = keys.next();
            if(key == arrList.get(key)){
                if(result < key){
                    result = key;
                }
            }
        }
        //System.out.println(result);
        return result;*/

        //array
        /*int result = -1;
        for(int number:arr){
            int dupCnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if(number == arr[i]){
                    dupCnt++;
                }
            }
            if(number == dupCnt && result < number){
                result = number;
            }
        }
        System.out.println("result : "+result);
        return result;*/
    }
}
