import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {
    static class Tetromino {
        int[][] shape;

        Tetromino(int[][] shape) {
            this.shape = shape;
        }

        static Tetromino[] getTetrominos() {
            Tetromino[] tetrominos = new Tetromino[19];
            tetrominos[0] = new Tetromino(new int[][]{{1, 1, 1 ,1}});
            tetrominos[1] = new Tetromino(new int[][]{{1}, {1}, {1}, {1}});
            tetrominos[2] = new Tetromino(new int[][]{{1, 1}, {1, 1}});
            tetrominos[3] = new Tetromino(new int[][]{{1, 1, 1}, {0, 1, 0}});
            tetrominos[4] = new Tetromino(new int[][]{{0, 1}, {1, 1}, {0, 1}});
            tetrominos[5] = new Tetromino(new int[][]{{0, 1, 0}, {1, 1, 1}});
            tetrominos[6] = new Tetromino(new int[][]{{1, 0}, {1, 1}, {1, 0}});
            tetrominos[7] = new Tetromino(new int[][]{{1, 0}, {1, 1}, {0, 1}});
            tetrominos[8] = new Tetromino(new int[][]{{0, 1, 1}, {1, 1, 0}});
            tetrominos[9] = new Tetromino(new int[][]{{0, 1}, {1, 1}, {1, 0}});
            tetrominos[10] = new Tetromino(new int[][]{{1, 1, 0}, {0, 1, 1}});
            tetrominos[11] = new Tetromino(new int[][]{{1, 0}, {1, 0}, {1, 1}});
            tetrominos[12] = new Tetromino(new int[][]{{1, 1, 1}, {1, 0, 0}});
            tetrominos[13] = new Tetromino(new int[][]{{1, 1}, {0, 1}, {0, 1}});
            tetrominos[14] = new Tetromino(new int[][]{{0, 0, 1}, {1, 1, 1}});
            tetrominos[15] = new Tetromino(new int[][]{{0, 1}, {0, 1}, {1, 1}});
            tetrominos[16] = new Tetromino(new int[][]{{1, 0, 0}, {1, 1, 1}});
            tetrominos[17] = new Tetromino(new int[][]{{1, 1}, {1, 0}, {1, 0}});
            tetrominos[18] = new Tetromino(new int[][]{{1, 1, 1}, {0, 0, 1}});

            return tetrominos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Tetromino[] tetrominos = Tetromino.getTetrominos();
        int answer = 0;
        for (Tetromino tetromino : tetrominos) {
            int rMax = tetromino.shape.length - 1;
            int cMax = tetromino.shape[0].length - 1;

            for (int r = 0; r < N - rMax; r++) {
                for (int c = 0; c < M - cMax; c++) {
                    int sum = 0;
                    for (int x = 0; x <= rMax; x++) {
                        for (int y = 0; y <= cMax; y++) {
                            sum += grid[r + x][c + y] * tetromino.shape[x][y];
                        }
                    }
                    answer = Math.max(answer, sum);
                }
            }
        }
        System.out.println(answer);
    }
}
