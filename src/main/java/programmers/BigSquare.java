package programmers;

public class BigSquare {
    private static final int[][] test = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};

    public static void main(String[] args) {
        solution(test);
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int[][] tempArr = new int[1001][1001];
        int row = board.length;
        int col = board[0].length;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (board[i - 1][j - 1] != 0) {
                    tempArr[i][j] = Math.min(tempArr[i][j - 1], Math.min(tempArr[i - 1][j], tempArr[i - 1][j - 1])) + 1;
                    answer = Math.max(answer, tempArr[i][j]);
                }
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("answer : " + answer);

        return answer * answer;
    }

}
