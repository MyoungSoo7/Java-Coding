import java.io.*;
import java.util.*;

public class P1520 {
    static final int[] DR = new int[]{1, -1, 0, 0};
    static final int[] DC = new int[]{0, 0, 1, -1};

    static int dfs(int[][] height, int[][] dp, int r, int c) {
        if (r == height.length && c == height[0].length) {
            return 1;
        }

        if (dp[r][c] >= 0 && !(r == 0 && c == 0)) {
            return dp[r][c];
        }

        for (int i = 0; i < 4; i++) {
            int dr = r + DR[i];
            int dc = c + DC[i];
            if (0 <= dr && dr < height.length && 0 <= dc && dc < height[0].length && height[r][c] > height[dr][dc]) {
                dp[r][c] += dfs(height, dp, dr, dc);
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] height = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                height[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                dp[n][m] = -1;
            }
        }
        dp[0][0] = 1;
        dfs(height, dp, 0, 0);
    }
}
