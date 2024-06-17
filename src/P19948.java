import java.io.*;
import java.util.*;

public class P19948 {
    static class Poem {
        String title;
        int countSpace = 0;
        int[] countLatin = new int[26];

        Poem(String content) {
            setCountLatin(content);

            StringTokenizer st = new StringTokenizer(content);
            StringBuilder sb = new StringBuilder();
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                sb.append(token.charAt(0));
            }

            this.title = sb.toString();

            setCountLatin(title);
        }

        private void setCountLatin(String str) {
            char before = '/';
            for (char c : str.toUpperCase().toCharArray()) {
                if (c == before) {
                    continue;
                }

                if (c == ' ') {
                    countSpace++;
                } else {
                    countLatin[c - 'A']++;
                }
                before = c;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String content = br.readLine().toUpperCase();
        int space = Integer.parseInt(br.readLine());
        int[] latin = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Poem poem = new Poem(content);

        if (space < poem.countSpace) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (latin[i] < poem.countLatin[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(poem.title);
    }
}
