package codesignal;

import java.util.*;

public class BestAlbumHash {
    public static void main(String[] args) {
        BestAlbumHash albumHash = new BestAlbumHash();
        albumHash.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }

    public int[] solution(String[] genres, int[] plays) {
        Vector<Integer> answer = new Vector<>();
        Map<String, Integer> stst = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            stst.put(genres[i], stst.getOrDefault(genres[i], 0) + plays[i]);
        }
        int renk = 2;
        ArrayList<Integer> fIndex = new ArrayList<Integer>();
        for (String key : stst.keySet()) {
            if (renk > 0) {
                Vector temp = new Vector();
                for (int i = 0; i < genres.length; i++) {
                    if (genres[i].equals(key)) {
                        temp.add(plays[i]);
                    }
                }
                Collections.sort(temp);
                System.out.println(temp.toString());
                for (int i = temp.size() - 1; i >= temp.size() - 2; i--) {
                    for (int j = 0; j < plays.length; j++) {
                        if (Integer.parseInt(temp.get(i).toString()) == plays[j]) {
                            answer.add(j);
                        }
                    }
                }
                renk--;
            }
        }

        return null;
    }
}
