import java.io.*;
import java.util.*;

public class P10844 {
    static final int[][] INDEX = {{1}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {5, 7}, {6, 8}, {7, 9}, {8}};
    static final int MOD = 1_000_000_000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] stair = new long[10];
        Arrays.fill(stair, 1);
        stair[0] = 0;
        for (int i = 0; i < N - 1; i++) {
            long[] temp = new long[10];
            for (int j = 0; j < 10; j++) {
                for (int k : INDEX[j]) {
                    temp[j] += stair[k] % MOD;
                }
            }
            stair = temp;
        }
        long sum = 0;
        for (long l : stair) {
            sum += l;
        }
        System.out.println(sum % MOD);
    }
}
