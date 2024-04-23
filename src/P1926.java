import java.io.*;
import java.util.*;

public class P1926 {
    static final int[] DR = new int[]{1, -1, 0, 0};
    static final int[] DC = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = size[0], M = size[1];
        int[][] painting = new int[N][M];
        for (int r = 0; r < N; r++) {
            painting[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int count = 0;
        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (painting[r][c] == 1) {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c});
                    painting[r][c] = 0;
                    int pSize = 1;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int i = 0; i < 4; i++) {
                            int dr = cur[0] + DR[i];
                            int dc = cur[1] + DC[i];
                            if (0 <= dr && dr < N && 0 <= dc && dc < M && painting[dr][dc] == 1) {
                                pSize++;
                                queue.offer(new int[]{dr, dc});
                                painting[dr][dc] = 0;
                            }
                        }
                    }
                    if (max < pSize) {
                        max = pSize;
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}
