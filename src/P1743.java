import java.io.*;
import java.util.*;

public class P1743 {
    static final int[] DR = {1, -1, 0, 0}, DC = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        boolean[][] corridor = new boolean[N][M];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            corridor[r - 1][c - 1] = true;
        }

        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (corridor[r][c]) {
                    Queue<int[]> q = new LinkedList<>();
                    int count = 1;
                    q.offer(new int[]{r, c});
                    corridor[r][c] = false;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int i = 0; i < 4; i++) {
                            int dr = DR[i] + cur[0], dc = DC[i]+ cur[1];
                            if (0 <= dr && dr < N && 0 <= dc && dc < M && corridor[dr][dc]) {
                                count++;
                                q.offer(new int[]{dr, dc});
                                corridor[dr][dc] = false;
                            }
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(max);
    }
}
