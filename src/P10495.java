import java.io.*;
import java.util.*;

public class P10495 {
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            Integer[] cards = Arrays.stream(input.split(" "))
                    .skip(1)
                    .map(Integer::valueOf)
                    .sorted(Collections.reverseOrder())
                    .toArray(Integer[]::new);
            loop:
            for (int i = 0; i < cards.length; i++) {
                int cur = cards[i];
                for (int j = 0; j < cards.length; j++) {
                    if (i != j && gcd(cur, cards[j]) != 1) {
                        continue loop;
                    }
                }
                System.out.println(cur);
                break;
            }
        }
    }
}
