import java.io.*;
import java.util.*;

public class P2573 {
    static final int[] DX = {1, -1, 0 ,0};
    static final int[] DY = {0, 0, 1 ,-1};

    static int N;
    static int M;
    static int[][] iceberg;

    static boolean melting() {
        int count = 0;
        boolean[][] isEmpty = new boolean[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (iceberg[x][y] == 0) {
                    isEmpty[x][y] = true;
                }
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (!isEmpty[x][y]) {
                    count++;
                    for (int i = 0; i < 4; i++) {
                        int dx = x + DX[i];
                        int dy = y + DY[i];
                        if (
                                iceberg[x][y] > 0 &&
                                0 <= dx && dx < N &&
                                0 <= dy && dy < M &&
                                isEmpty[dx][dy]) {
                            iceberg[x][y]--;
                        }
                    }
                }
            }
        }
        if (count > 0) {
            return true;
        }
        return false;
    }

    static int getCount() {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (iceberg[x][y] > 0 && !visit[x][y]) {
                    count++;
                    queue.add(new int[]{x, y});
                    visit[x][y] = true;
                    while (!queue.isEmpty()) {
                        int[] pos = queue.remove();
                        for (int i = 0; i < 4; i++) {
                            int dx = pos[0] + DX[i];
                            int dy = pos[1] + DY[i];
                            if (
                                    0 <= dx && dx < N &&
                                    0 <= dy && dy < M &&
                                    iceberg[dx][dy] > 0 &&
                                    !visit[dx][dy]) {
                                queue.add(new int[]{dx, dy});
                                visit[dx][dy] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        iceberg = new int[N][M];

        for (int x = 0; x < N; x++) {
            String[] s = br.readLine().split(" ");
            for (int y = 0; y < M; y++) {
                iceberg[x][y] = Integer.parseInt(s[y]);
            }
        }

        int time = 0;
        while (melting()) {
            time++;
            if (getCount() > 1) {
                System.out.println(time);
                return;
            }
        }
        System.out.println(0);
    }
}
