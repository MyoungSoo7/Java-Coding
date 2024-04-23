import java.io.*;
import java.util.*;

public class P20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);

        Map<String, Integer> voca = new HashMap<>();
        for (int n = 0; n < N; n++) {
            String word = br.readLine();
            if (word.length() >= M) {
                voca.put(word, voca.getOrDefault(word, 0) + 1);
            }
        }
        List<String> keySet = new ArrayList<>(voca.keySet());

        keySet.sort((s1, s2) -> {
            int s1Count = voca.get(s1), s2Count = voca.get(s2);
            if (s1Count > s2Count) {
                return -1;
            } else if (s1Count < s2Count) {
                return 1;
            }

            if (s1.length() > s2.length()) {
                return -1;
            } else if (s1.length() < s2.length()) {
                return 1;
            }

            return s1.compareTo(s2);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : keySet) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
