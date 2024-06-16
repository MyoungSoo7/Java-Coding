import java.io.*;
import java.util.*;

public class P5558 {
    static final int[] DH = {1, -1, 0, 0};
    static final int[] DW = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int H = Integer.parseInt(input[0]), W = Integer.parseInt(input[1]), N = Integer.parseInt(input[2]);
        boolean[][] wall = new boolean[H][W];
        int[][] cheese = new int[N][2];
        int[] mouse = new int[3];

        for (int h = 0; h < H; h++) {
            String row = br.readLine();
            for (int w = 0; w < W; w++) {
                switch (row.charAt(w)) {
                    case 'X':
                        wall[h][w] = true;
                        break;
                    case 'S':
                        mouse[0] = h;
                        mouse[1] = w;
                        break;
                    case '.':
                        break;
                    default:
                        cheese[row.charAt(w) - '1'] = new int[]{h, w};
                }
            }
        }

        for (int[] next : cheese) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visit = new boolean[H][W];
            queue.offer(mouse);
            visit[mouse[0]][mouse[1]] = true;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (cur[0] == next[0] && cur[1] == next[1]) {
                    mouse = cur;
                    break;
                }

                int h = cur[0];
                int w = cur[1];
                int time = cur[2];
                for (int i = 0; i < 4; i++) {
                    int dh = h + DH[i];
                    int dw = w + DW[i];
                    if (0 <= dh && dh < H && 0 <= dw && dw < W && !wall[dh][dw] && !visit[dh][dw]) {
                        visit[dh][dw] = true;
                        queue.offer(new int[]{dh, dw, time + 1});
                    }
                }
            }
        }
        System.out.println(mouse[2]);
    }
}
