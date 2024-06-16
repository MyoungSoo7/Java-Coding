import java.io.*;
import java.util.*;

public class P14502 {
    static final int[] DR = new int[]{1, -1, 0, 0};
    static final int[] DC = new int[]{0, 0, 1, -1};

    static int getSafePlace(boolean[][] wall, List<int[]> virus, boolean[][] newWall) {
        boolean[][] infected = new boolean[wall.length][wall[0].length];
        for (int[] v : virus) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(v);
            infected[v[0]][v[1]] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int dr = cur[0] + DR[i];
                    int dc = cur[1] + DC[i];
                    if (0 <= dr && dr < wall.length && 0 <= dc && dc < wall[0].length && !wall[dr][dc] && !infected[dr][dc] && !newWall[dr][dc]) {
                        infected[dr][dc] = true;
                        q.offer(new int[]{dr, dc});
                    }
                }
            }
        }

        int safePlace = 0;
        for (int r = 0; r < wall.length; r++) {
            for (int c = 0; c < wall[0].length; c++) {
                if (!wall[r][c] && !infected[r][c] && !newWall[r][c]) {
                    safePlace++;
                }
            }
        }
        return safePlace;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        boolean[][] wall = new boolean[N][M];
        List<int[]> virus = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                switch (st.nextToken()) {
                    case "2":
                        virus.add(new int[]{r, c});
                    case "1":
                        wall[r][c] = true;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N * M - 2; i++) {
            for (int j = i + 1; j < N * M - 1; j++) {
                loop : for (int k = j + 1; k < N * M; k++) {
                    boolean[][] newWall = new boolean[N][M];
                    int[] pos = new int[]{i, j, k};
                    for (int p : pos) {
                        int r = p / M, c = p % M;
                        if (wall[r][c]) {
                            continue loop;
                        }
                        newWall[r][c] = true;
                    }
                    max = Math.max(max, getSafePlace(wall, virus, newWall));
                }
            }
        }
        System.out.println(max);
    }
}
