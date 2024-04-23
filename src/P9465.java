import java.io.*;
import java.util.*;

public class P9465 {
    static int solve(int size, int[][] sticker) {
        if (size == 1) {
            return Math.max(sticker[0][0], sticker[1][0]);
        }
        int[][] max = new int[2][size];
        max[0][0] = sticker[0][0];
        max[1][0] = sticker[1][0];
        max[0][1] = max[1][0] + sticker[0][1];
        max[1][1] = max[0][0] + sticker[1][1];

        for (int s = 2; s < size; s++) {
            max[0][s] = Math.max(max[1][s - 2], max[1][s - 1]) + sticker[0][s];
            max[1][s] = Math.max(max[0][s - 2], max[0][s - 1]) + sticker[1][s];
        }
        return Math.max(max[0][size - 1], max[1][size - 1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int size = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][size];
            for (int i = 0; i < 2; i++) {
                int[] line = sticker[i];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int s = 0; s < size; s++) {
                    line[s] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(solve(size, sticker));
        }
    }
}
