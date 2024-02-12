import java.io.*;
import java.util.*;

public class P21610 {
    static final int[] DX = new int[]{0, 0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] DY = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1};

    static int[][] bucket;
    static boolean[][] cloud;
    static int N;
    static boolean[][] disappear;

    static void command(int d, int s) {
        boolean[][] newCloud = new boolean[N][N];
        s %= N;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (cloud[x][y]) {
                    int dx = adjust(x + DX[d] * s);
                    int dy = adjust(y + DY[d] * s);
                    newCloud[dx][dy] = true;
                    cloud[x][y] = false;
                }
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (newCloud[x][y]) {
                    cloud[x][y] = true;
                }
            }
        }
        rain();
        bug();
    }

    static int adjust(int c) {
        if (c < 0) {
            return c + N;
        }
        if (c >= N) {
            return c - N;
        }
        return c;
    }

    static void rain() {
        disappear = new boolean[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (cloud[x][y]) {
                    bucket[x][y]++;
                    disappear[x][y] = true;
                }
            }
        }
    }

    static void bug() {
        int[][] result = new int[N][N];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (cloud[x][y]) {
                    cloud[x][y] = false;
                    int count = 0;
                    for (int i = 2; i <= 8; i += 2) {
                        int dx = x + DX[i];
                        int dy = y + DY[i];
                        if (0 <= dx && dx < N && 0 <= dy && dy < N && bucket[dx][dy] > 0) {
                            count++;
                        }
                    }
                    result[x][y] = count;
                }
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                bucket[x][y] += result[x][y];
                if (!disappear[x][y] && bucket[x][y] >= 2) {
                    bucket[x][y] -= 2;
                    cloud[x][y] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bucket = new int[N][N];
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                bucket[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        cloud = new boolean[N][N];
        cloud[N - 1][0] = true;
        cloud[N - 1][1] = true;
        cloud[N - 2][0] = true;
        cloud[N - 2][1] = true;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            command(d, s);
        }

        int sum = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sum += bucket[x][y];
            }
        }
        System.out.println(sum);
    }
}
