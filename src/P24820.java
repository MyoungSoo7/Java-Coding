import java.io.*;
import java.util.*;

public class P24820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letterList = br.readLine();
        Set<Character> letterSet = new HashSet<>();
        char middleLetter = letterList.charAt(0);
        for (char c : letterList.toCharArray()) {
            letterSet.add(c);
        }

        int n = Integer.parseInt(br.readLine());
        loop : for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < 4) {
                continue;
            }

            boolean isValid = false;
            for (char c : word.toCharArray()) {
                if (!letterSet.contains(c)) {
                    continue loop;
                }
                if (c == middleLetter) {
                    isValid = true;
                }
            }

            if (isValid) {
                System.out.println(word);
            }
        }
    }
}
