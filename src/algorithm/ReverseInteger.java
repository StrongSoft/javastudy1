package algorithm;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
        System.out.println(reverseInteger.reverse(-123));
        System.out.println(reverseInteger.reverse(120));
    }
    public int reverse(int x) {
        try{
            return Integer.reverse(x);
        } catch (NumberFormatException e){
            return 0;
        }
    }
}
