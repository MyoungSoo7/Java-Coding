import java.io.*;
import java.util.*;

import static java.lang.Math.pow;

public class P20058 {
    static final int[] DX = new int[]{1, -1, 0, 0};
    static final int[] DY = new int[]{0, 0, 1, -1};

    static int N;
    static int[][] grid;
    static int length;

    static void rotate(int q) {
        int move = (int) pow(2, q);
        for (int x = 0; x < length; x += move) {
            for (int y = 0; y < length; y += move) {
                rotateUnit(x, y, (int) pow(2, q));
            }
        }
    }

    static void rotateUnit(int x, int y, int size) {
        if (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                int temp = grid[x][y + i];
                grid[x][y + i] = grid[size - 1 + x - i][y];
                grid[size - 1 + x - i][y] = grid[size - 1 + x][size - 1 + y - i];
                grid[size - 1 + x][size - 1 + y - i] = grid[x + i][size - 1 + y];
                grid[x + i][size - 1 + y] = temp;
            }
            rotateUnit(x + 1, y + 1, size - 2);
        }
    }

    static void melt() {
        boolean[][] isMelt = new boolean[length][length];
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                int count = 0;
                if (grid[x][y] == 0) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int dx = x + DX[i];
                    int dy = y + DY[i];
                    if (0 <= dx && dx < length && 0 <= dy && dy < length && grid[dx][dy] != 0) {
                        count++;
                    }
                }
                if (count < 3) {
                    isMelt[x][y] = true;
                }
            }
        }

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                if (isMelt[x][y]) {
                    grid[x][y]--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        length = (int) pow(2, N);
        int Q = Integer.parseInt(st.nextToken());

        grid = new int[length][length];
        for (int x = 0; x < length; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < length; y++) {
                grid[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] L = new int[Q];
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        for (int q : L) {
            rotate(q);
            melt();
        }

        int sum = 0;
        for (int[] i : grid) {
            for (int j : i) {
                sum += j;
            }
        }
        System.out.println(sum);

        int maxSize = 0;
        boolean[][] visit = new boolean[length][length];
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                if (grid[x][y] > 0 && !visit[x][y]) {
                    int size = 1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{x, y});
                    visit[x][y] = true;
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        for (int i = 0; i < 4; i++) {
                            int dx = now[0] + DX[i];
                            int dy = now[1] + DY[i];
                            if (0 <= dx && dx < length && 0 <= dy && dy < length && grid[dx][dy] != 0 && !visit[dx][dy]) {
                                size++;
                                queue.offer(new int[]{dx, dy});
                                visit[dx][dy] = true;
                            }
                        }
                    }
                    if (size > maxSize) {
                        maxSize = size;
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}
