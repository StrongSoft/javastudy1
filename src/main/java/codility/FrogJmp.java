package codility;

public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(10,85, 30));
    }
    public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        return (int) Math.ceil((Y-X)/(double)D);
    }
}
