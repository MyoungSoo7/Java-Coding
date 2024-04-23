import java.io.*;

public class P8892 {
    static String solve(int k, String[] words) {
        for (int i = 0; i < k - 1; i++) {
            String str1 = words[i];
            for (int j = i + 1; j < k; j++) {
                String str2 = words[j];
                StringBuilder word = new StringBuilder();
                word.append(str1).append(str2);
                if (word.toString().contentEquals(word.reverse())) {
                    return word.toString();
                }
                word = new StringBuilder();
                word.append(str2).append(str1);
                if (word.toString().contentEquals(word.reverse())) {
                    return word.toString();
                }
            }
        }
        return "0";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            String[] words = new String[k];
            for (int i = 0; i < k; i++) {
                words[i] = br.readLine();
            }
            System.out.println(solve(k, words));
        }
    }
}
