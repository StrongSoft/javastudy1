package algorithm;

import java.util.*;

public class CharacterCenter {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        CharacterCenter characterCenter = new CharacterCenter();
        System.out.println(Arrays.toString(characterCenter.solution(array, commands)));
    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;
        for (int[] command : commands) {
            Vector<Integer> tempInt = new Vector<>();
            for (int i = command[0]-1; i < command[1]; i++) {
                tempInt.add(array[i]);
            }
            Collections.sort(tempInt);
            answer[answerIndex] = tempInt.get(command[2]-1);
            answerIndex++;
        }
        return answer;
    }
}
