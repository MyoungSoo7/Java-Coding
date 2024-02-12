import java.io.*;
import java.util.*;

public class P2583 {
    static final int[] DX = {1, -1, 0, 0};
    static final int[] DY = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]), M = Integer.parseInt(s[1]), K = Integer.parseInt(s[2]);

        boolean[][] grid = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            s = br.readLine().split(" ");
            for (int j = Integer.parseInt(s[1]); j < Integer.parseInt(s[3]); j++) {
                for (int k = Integer.parseInt(s[0]); k < Integer.parseInt(s[2]); k++) {
                    grid[j][k] = true;
                }
            }
        }

        List<Integer> area = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (!grid[x][y]) {
                    queue.add(new int[]{x, y});
                    grid[x][y] = true;
                    int size = 1;

                    while (!queue.isEmpty()) {
                        int[] now = queue.remove();
                        for (int i = 0; i < 4; i++) {
                            int dx = now[0] + DX[i];
                            int dy = now[1] + DY[i];
                            if (0 <= dx && dx < N && 0 <= dy && dy < M && !grid[dx][dy]) {
                               queue.add(new int[]{dx, dy});
                               grid[dx][dy] = true;
                               size++;
                            }
                        }
                    }
                    area.add(size);
                }
            }
        }
        Collections.sort(area);
        System.out.println(area.size());
        for (int i : area) {
            System.out.print(i + " ");
        }
    }
}
