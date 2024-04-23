import java.io.*;

public class P1236 {
    static class Castle {
        boolean[][] isSecure;
        int N, M;

        Castle(int N, int M) {
            this.N = N;
            this.M = M;
            isSecure = new boolean[N][M];
        }

        void setSecurity(int n, int m) {
            isSecure[n][m] = true;
        }

        int getAdditionalSecurity() {
            int maxRow = 0, maxCol = 0;
            for (int n = 0; n < N; n++) {
                boolean result = false;
                for (int m = 0; m < M; m++) {
                    if (isSecure[n][m]) {
                        result = true;
                        break;
                    }
                }
                if (!result) {
                    maxRow++;
                }
            }

            for (int m = 0; m < M; m++) {
                boolean result = false;
                for (int n = 0; n < N; n++) {
                    if (isSecure[n][m]) {
                        result = true;
                        break;
                    }
                }
                if (!result) {
                    maxCol++;
                }
            }
            return Math.max(maxRow, maxCol);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]), M = Integer.parseInt(size[1]);
        Castle castle = new Castle(N, M);

        for (int n = 0; n < N; n++) {
            String row = br.readLine();
            for (int m = 0; m < M; m++) {
                if (row.charAt(m) == 'X') {
                    castle.setSecurity(n, m);
                }
            }
        }
        System.out.println(castle.getAdditionalSecurity());
    }
}
