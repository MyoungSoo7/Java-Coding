import java.io.*;
import java.util.*;

public class P30592 {
    static final int[] DR = {1, -1, 0, 0};
    static final int[] DC = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        boolean[][] isWall = new boolean[N][M];
        boolean[][] visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                isWall[i][j] = (row.charAt(j) == '#');
            }
        }

        int[] start = input(br);
        visit[start[0]][start[1]] = true;
        int[] end = input(br);

        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> visitedCell = new LinkedList<>();
        q.offer(start);
        while (true) {
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (Arrays.equals(cur, end)) {
                    System.out.println("YES");
                    return;
                }
                visitedCell.offer(cur);

                for (int i = 0; i < 4; i++) {
                    int nr = cur[0] + DR[i];
                    int nc = cur[1] + DC[i];
                    int[] newCell = new int[]{nr, nc};

                    if (isValid(newCell, N, M, isWall, visit)) {
                        visit[nr][nc] = true;
                        q.offer(newCell);
                    }
                }
            }

            if (K == 0) break;
            K--;

            while (!visitedCell.isEmpty()) {
                int[] cur = visitedCell.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = cur[0] + DR[i] * 2;
                    int nc = cur[1] + DC[i] * 2;
                    int[] newCell = new int[]{nr, nc};

                    if (isValid(newCell, N, M, isWall, visit)) {
                        visit[nr][nc] = true;
                        q.offer(newCell);
                    }
                }
            }
        }

        System.out.println("NO");
    }

    private static int[] input(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        return Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .map((e) -> e - 1)
                .toArray();
    }

    private static boolean isValid(int[] cell, int N, int M, boolean[][] isWall, boolean[][] visit) {
        return 0 <= cell[0] && cell[0] < N && 0 <= cell[1] && cell[1] < M && !visit[cell[0]][cell[1]] && !isWall[cell[0]][cell[1]];
    }
}
