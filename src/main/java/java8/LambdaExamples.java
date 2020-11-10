package java8;

public class LambdaExamples {
    public static void main(String[] args) {
        /*List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, Comparator.reverseOrder());

        System.out.println(names.toString());*/

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        
        Integer converted = converter.convert("123");
        System.out.println(converted);

    }
}