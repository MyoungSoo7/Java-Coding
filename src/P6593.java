import java.io.*;
import java.util.*;

public class P6593 {
    static final int[] DL = new int[]{1, -1, 0, 0, 0, 0};
    static final int[] DR = new int[]{0, 0, 1, -1, 0, 0};
    static final int[] DC = new int[]{0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testcase : while (true) {
            String[] s = br.readLine().split(" ");
            int L = Integer.parseInt(s[0]);
            int R = Integer.parseInt(s[1]);
            int C = Integer.parseInt(s[2]);
            if (L + R + C == 0) {
                break;
            }

            String[][] building = new String[L][R];
            int sl = 0, sr = 0, sc = 0;
            int el = 0, er = 0, ec = 0;
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    building[l][r] = br.readLine();
                    for (int c = 0; c < C; c++) {
                        char cur = building[l][r].charAt(c);
                        if (cur == 'S') {
                            sl = l;
                            sr = r;
                            sc = c;
                        } else if (cur == 'E') {
                            el = l;
                            er = r;
                            ec = c;
                        }
                    }
                }
                br.readLine();
            }

            Queue<int[]> queue = new LinkedList<>();
            boolean[][][] visit = new boolean[L][R][C];
            queue.offer(new int[]{sl, sr, sc, 0});
            visit[sl][sr][sc] = true;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (cur[0] == el && cur[1] == er && cur[2] == ec) {
                    sb.append(String.format("Escaped in %d minute(s).\n", cur[3]));
                    continue testcase;
                }
                for (int i = 0; i < 6; i++) {
                    int dl = cur[0] + DL[i];
                    int dr = cur[1] + DR[i];
                    int dc = cur[2] + DC[i];
                    if (
                            0 <= dl && dl < L
                            && 0 <= dr && dr < R
                            && 0 <= dc && dc < C
                            && !visit[dl][dr][dc]
                            && building[dl][dr].charAt(dc) != '#'
                    ) {
                        queue.offer(new int[]{dl, dr, dc, cur[3] + 1});
                        visit[dl][dr][dc] = true;
                    }
                }
            }
            sb.append("Trapped!\n");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
