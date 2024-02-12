import java.io.*;
import java.util.*;

public class P11425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), true);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (map.containsKey(br.readLine())) count++;
        }
        System.out.println(count);
    }
}
