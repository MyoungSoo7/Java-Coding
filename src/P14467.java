import java.io.*;
import java.util.*;

public class P14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cows = new HashMap<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String[] result = br.readLine().split(" ");
            int num = Integer.parseInt(result[0]);
            int pos = Integer.parseInt(result[1]);
            if (cows.containsKey(num) && cows.get(num) != pos) {
                count++;
            }
            cows.put(num, pos);
        }
        System.out.println(count);
    }
}
