package codility;

public class BinaryGap {
    public int solution(int N) {
        String biStr = Integer.toBinaryString(N);
        int firstOneIndex = getNextOneIndex(biStr, 0);

        if (firstOneIndex < 0) {
            return 0;
        }

        int maxGap = 0;

        while (true) {
            int nextOneIndex = getNextOneIndex(biStr, firstOneIndex + 1);

            if (nextOneIndex < 0) {
                break;
            }

            int gap = nextOneIndex - firstOneIndex - 1;

            if (gap > maxGap) {
                maxGap = gap;
            }

            firstOneIndex = nextOneIndex;
        }

        return maxGap;
    }

    private int getNextOneIndex(String biStr, int startIndex) {
        int nextOneIndex = -1;

        for (int i = startIndex; i < biStr.length(); i++) {
            char c = biStr.charAt(i);

            if (c == '1') {
                nextOneIndex = i;
                break;
            }
        }

        return nextOneIndex;
    }
}
