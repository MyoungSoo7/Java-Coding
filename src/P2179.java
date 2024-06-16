import java.io.*;
import java.util.*;

public class P2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> prefixes = new HashMap<>();
        String[] words = new String[N];
        for (int n = 0; n < N; n++) {
            words[n] = br.readLine();
        }

        int ans1 = N;
        int ans2 = N;
        String prefix = "";
        for (int n = 0; n < N; n++) {
            for (int i = 1; i <= words[n].length(); i++) {
                String substr = words[n].substring(0, i);
                if (prefixes.containsKey(substr)) {
                    if (i > prefix.length()) {
                        ans1 = prefixes.get(substr);
                        ans2 = n;
                        prefix = substr;
                    } else if (i == prefix.length()) {
                        if (ans1 > prefixes.get(substr) || (ans1 == prefixes.get(substr) && ans2 > n)) {
                            ans1 = prefixes.get(substr);
                            ans2 = n;
                            prefix = substr;
                        }
                    }
                } else {
                    prefixes.put(substr, n);
                }
            }
        }

        System.out.println(words[ans1] + "\n" + words[ans2]);
    }
}
