import java.io.*;
import java.util.*;

public class P2589 {
    static final int[] DX = new int[]{1, -1, 0, 0};
    static final int[] DY = new int[]{0, 0, 1, -1};

    static int getMaxDistance(int x, int y, String[] map) {
        if (map[x].charAt(y) == 'W') {
            return -1;
        }
        int N = map.length;
        int M = map[0].length();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        q.offer(new int[]{x, y, 0});
        visit[x][y] = true;
        int moveMax = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[2] > moveMax) {
                moveMax = cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int dx = cur[0] + DX[i];
                int dy = cur[1] + DY[i];
                if (0 <= dx && dx < N && 0 <= dy && dy < M && !visit[dx][dy] && map[dx].charAt(dy) == 'L') {
                    q.offer(new int[]{dx, dy, cur[2] + 1});
                    visit[dx][dy] = true;
                }
            }
        }
        return moveMax;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] map = new String[N];
        for (int x = 0; x < N; x++) {
            map[x] = br.readLine();
        }

        int answer = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                answer = Math.max(answer, getMaxDistance(x, y, map));
            }
        }
        System.out.println(answer);
    }
}
