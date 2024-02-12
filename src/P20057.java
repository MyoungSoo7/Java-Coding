import java.io.*;
import java.util.*;

public class P20057 {
    static final int[] DX = new int[]{0, 1, 0, -1};
    static final int[] DY = new int[]{-1, 0, 1, 0};
    static final int[][] SDX = new int[][]{
            {-2, -1, -1, -1, 0, 1, 1, 1, 2},
            {0, 1, 0, -1, 2, 1, 0, -1, 0},
            {-2, -1, -1, -1, 0, 1, 1, 1, 2},
            {0, -1, 0, 1, -2, -1, 0, 1, 0}};
    static final int[][] SDY = new int[][] {
            {0, -1, 0, 1, -2, -1, 0, 1, 0},
            {-2, -1, -1, -1,  0, 1, 1, 1, 2},
            {0, 1, 0, -1, 2, 1, 0, -1, 0},
            {2, 1, 1, 1, 0, -1, -1, -1, -2}};
    static final double[] RATIO = new double[]{0.02, 0.1, 0.07, 0.01, 0.05, 0.1, 0.07, 0.01, 0.02};

    static int N;
    static int x, y;
    static int direction = 0;
    static int[][] grid;
    static int answer = 0;

    static void changeDirection() {
        if (direction == 3) {
            direction = 0;
        } else {
            direction++;
        }
    }

    static void scatter() {
        int sand = grid[x][y];
        for (int i = 0; i < 9; i++) {
            int dx = x + SDX[direction][i];
            int dy = y + SDY[direction][i];
            int remove = (int) (sand * RATIO[i]);
            if (0 <= dx && dx < N && 0 <= dy && dy < N) {
                grid[dx][dy] += remove;
            } else {
                answer += remove;
            }
            grid[x][y] -= remove;
        }
        int dx = x + DX[direction];
        int dy = y + DY[direction];
        if (0 <= dx && dx < N && 0 <= dy && dy < N) {
            grid[dx][dy] += grid[x][y];
        } else {
            answer += grid[x][y];
        }
        grid[x][y] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        grid = new int[N][N];
        StringTokenizer st;
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                grid[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        x = N / 2;
        y = N / 2;
        for (int i = 0; i < (N - 1) * 2; i++) {
            for (int j = 0; j < i / 2 + 1; j++) {
                x = x + DX[direction];
                y = y + DY[direction];
                scatter();
            }
            changeDirection();
        }

        for (int i = 0; i < N - 1; i++) {
            x = x + DX[direction];
            y = y + DY[direction];
            scatter();
        }
        System.out.println(answer);
    }
}
