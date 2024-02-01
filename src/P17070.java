import java.io.*;
import java.util.*;

public class P17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][][] grid = new int[N][N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    grid[i][j][0] = -1;
                }
            }
        }
        grid[0][1][0] = 1;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (grid[x][y][0] == -1) {
                    continue;
                }
                if (y - 1 >= 0 && grid[x][y - 1][0] > -1) {
                    grid[x][y][0] += grid[x][y - 1][0] + grid[x][y - 1][1];
                }
                if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y][0] > -1 && grid[x][y - 1][0] > -1 && grid[x - 1][y - 1][0] > -1) {
                    grid[x][y][1] += grid[x - 1][y -1][0] + grid[x - 1][y - 1][1] + grid[x - 1][y - 1][2];
                }
                if (x - 1 >= 0 && grid[x - 1][y][0] > -1) {
                    grid[x][y][2] += grid[x - 1][y][1] + grid[x - 1][y][2];
                }
            }
        }

        if (grid[N - 1][N - 1][0] == -1) {
            System.out.println(0);
        } else {
            int sum = 0;
            for (int i : grid[N - 1][N - 1]) {
                sum += i;
            }
            System.out.println(sum);
        }
    }
}
