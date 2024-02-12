import java.io.*;

public class P1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int x = N / 2, y = N / 2;
        int[][] snail = new int[N][N];
        int num = 1;
        snail[x][y] = num;
        int count = 1;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < count; j++) {
                x--;
                num++;
                snail[x][y] = num;
            }
            for (int j = 0; j < count; j++) {
                y++;
                num++;
                snail[x][y] = num;
            }
            count++;
            for (int j = 0; j < count; j++) {
                x++;
                num++;
                snail[x][y] = num;
            }
            for (int j = 0; j < count; j++) {
                y--;
                num++;
                snail[x][y] = num;
            }
            count++;
        }
        for (int i = 0; i < count - 1; i++) {
            x--;
            num++;
            snail[x][y] = num;
        }
        StringBuilder sb = new StringBuilder();
        int findX = 0, findY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = snail[i][j];
                sb.append(k);
                if (j != N - 1) {
                    sb.append(" ");
                }

                if (k == find) {
                    findX = i;
                    findY = j;
                }
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        System.out.println((findX + 1) + " " + (findY + 1));
    }
}
