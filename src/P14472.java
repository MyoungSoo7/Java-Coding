import java.io.*;

public class P14472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]), D = Integer.parseInt(input[2]);
        int[][] room = new int[N][M];
        for (int n = 0; n < N; n++) {
            String row = br.readLine();
            for (int m = 0; m < M; m++) {
                if (row.charAt(m) == '#') {
                    room[n][m] = 1;
                }
            }
        }

        int answer = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M - D + 1; m++) {
                int wall = 0;
                for (int i = 0; i < D; i++) {
                    wall += room[n][m + i];
                }
                if (wall == 0) {
                    answer++;
                }
            }
        }

        for (int n = 0; n < N - D + 1; n++) {
            for (int m = 0; m < M; m++) {
                int wall = 0;
                for (int i = 0; i < D; i++) {
                    wall += room[n + i][m];
                }
                if (wall == 0) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
