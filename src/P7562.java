import java.io.*;
import java.util.*;

public class P7562 {
    static final int[] DX = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] DY = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int L = Integer.parseInt(br.readLine());
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visit = new boolean[L][L];
            String[] s = br.readLine().split(" ");
            String[] e = br.readLine().split(" ");
            int sx = Integer.parseInt(s[0]), sy = Integer.parseInt(s[1]);
            int ex = Integer.parseInt(e[0]), ey = Integer.parseInt(e[1]);
            queue.offer(new int[]{sx, sy, 0});
            visit[sx][sy] = true;
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                if (pos[0] == ex && pos[1] == ey) {
                    System.out.println(pos[2]);
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    int dx = pos[0] + DX[j];
                    int dy = pos[1] + DY[j];
                    if (0 <= dx && dx < L && 0 <= dy && dy < L && !visit[dx][dy]) {
                        queue.offer(new int[]{dx, dy, pos[2] + 1});
                        visit[dx][dy] = true;
                    }
                }
            }
        }
    }
}
