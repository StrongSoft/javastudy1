package modenjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamApi02 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(map(numbers, null));
    }
    private static <T, R> List<R> map(final List<T> list, final Function<T, R> mapper){
         final List<R> result;
         if(mapper != null){
             result = new ArrayList<>();
         } else {
             result = new ArrayList<>((List<R>)list);
         }
         if (result.isEmpty()){
             for(final T t : list){
                 result.add(mapper.apply(t));
             }
         }
         return result;
    }
}
