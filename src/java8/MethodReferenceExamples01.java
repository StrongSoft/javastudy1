package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExamples01 {
    public static void main(String[] args) {
        /* First Class Function */
        /*
         * Function can be passed as a parameter to another function.
         */
        /* Using Lambda Expression
         */
        System.out.println(testFirstClassFunction1(3, i -> String.valueOf(i*2)));

        /* Using Method Reference
         */
        System.out.println(testFirstClassFunction1(3, MethodReferenceExamples01::doubleThenToString));

        System.out.println("\n-------------------------------------------");


        /*
         * Function can be passed as a result to another function.
         */
        /* Using Lambda Expression
         */
        final Function<Integer, String> fl = getDoubleThenToStringUsingLambdaExpression();
        final String resultFromFl = fl.apply(3);
        System.out.println("The result is " + resultFromFl);

        /* Using Method Reference
         */
        final Function<Integer, String> fmr = getDoubleThenToStringUsingMethodReference();
        final String resultFromFmr = fmr.apply(3);
        System.out.println("The result is " + resultFromFmr);

        System.out.println("\n-------------------------------------------");


        /*
         * A Function can be stored in the data structure.
         */
        /* Using Lambda Expression
         */
        final List<Function<Integer, String>> fsL = Arrays.asList(i -> String.valueOf(i * 2));
        for (final Function<Integer, String> f : fsL){
            final String result = f.apply(3);
            System.out.println("The result is " + result);
        }

        /* Using Method Reference
         */
        final List<Function<Integer, String>> fdMr = Arrays.asList(MethodReferenceExamples01::doubleThenToString);
        for (final Function<Integer, String> f : fsL){
            final String result = f.apply(3);
            System.out.println("The result is " + result);
        }

        System.out.println("\n-------------------------------------------");

        /*
         * Function can be passed as a value assign.
         */
        /* Using Lambda Expression
         */
        final Function<Integer, String> fl2 = i -> String.valueOf(i * 2);
        final String resultFl2 = fl2.apply(5);
        System.out.println("The result is " + resultFl2);

        /* Using Method Reference
         */
        final Function<Integer, String> fmr2 = MethodReferenceExamples01::doubleThenToString;
        final String resultFmr2 = fmr2.apply(5);
        System.out.println("The result is " + resultFmr2);

        System.out.println("\n-------------------------------------------");

        /*
         * Both Lambda Expression and Method Reference
         */
        final List<Function<Integer, String>> fsBoth = Arrays.asList(i -> String.valueOf(i * 2),
                MethodReferenceExamples01::doubleThenToString,
                MethodReferenceExamples01::addhashPrefix);
        for (final Function<Integer, String> f : fsBoth){
            final String result = f.apply(7);
            System.out.println("The result is " + result);
        }
    }

    private static Function<Integer, String> getDoubleThenToStringUsingMethodReference() {
        return MethodReferenceExamples01::doubleThenToString;
    }

    private static String doubleThenToString(int i){
        return String.valueOf(i*2);
    }

    private static String addhashPrefix(int number){
        return "#" + number;
    }

    private static String testFirstClassFunction1(int n, Function<Integer, String> f){
        return "The result is " + f.apply(n);
    }

    private static Function<Integer, String> getDoubleThenToStringUsingLambdaExpression(){
        return i -> String.valueOf(i * 2);
    }
}
