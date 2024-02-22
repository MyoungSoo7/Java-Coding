import java.io.*;

public class P1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        boolean[][] A = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < M; c++) {
                if (input.charAt(c) == '1') {
                    A[r][c] = true;
                }
            }
        }

        boolean[][] B = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < M; c++) {
                if (input.charAt(c) == '1') {
                    B[r][c] = true;
                }
            }
        }

        int answer = 0;
        for (int r = 0; r < N - 2; r++) {
            for (int c = 0; c < M - 2; c++) {
                if (A[r][c] ^ B[r][c]) {
                    answer++;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            A[r + i][c + j] = !A[r + i][c + j];
                        }
                    }
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (A[r][c] ^ B[r][c]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }
}
