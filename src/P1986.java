import java.io.*;
import java.util.*;

public class P1986 {
    static final int[] QUEEN_DR = new int[]{1, -1, 0, 0, 1, 1, -1, -1}, QUEEN_DC = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
    static final int[] KNIGHT_DR = new int[]{-1, -2, -2, -1, 1, 2, 2, 1}, KNIGHT_DC = new int[]{-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] chess = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int queen = Integer.parseInt(st.nextToken());
        for (int i = 0; i < queen; i++) {
            chess[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int knight = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knight; i++) {
            chess[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2;
        }

        st = new StringTokenizer(br.readLine());
        int pawn = Integer.parseInt(st.nextToken());
        for (int i = 0; i < pawn; i++) {
            chess[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 3;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                switch (chess[r][c]) {
                    case 1:
                        for (int i = 0; i < 8; i++) {
                            int dr = r, dc = c;
                            while (true) {
                                dr += QUEEN_DR[i];
                                dc += QUEEN_DC[i];
                                if (0 <= dr && dr < N && 0 <= dc && dc < M && chess[dr][dc] <= 0) {
                                    chess[dr][dc] = -1;
                                    continue;
                                }
                                break;
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < 8; i++) {
                            int dr = r + KNIGHT_DR[i];
                            int dc = c + KNIGHT_DC[i];
                            if (0 <= dr && dr < N && 0 <= dc && dc < M && chess[dr][dc] <= 0) {
                                chess[dr][dc] = -1;
                            }
                        }
                        break;
                }
            }
        }

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (chess[r][c] == 0) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
