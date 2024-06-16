import java.io.*;

public class P2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[][] drink = new int[n][2];
        if (n == 1) {
            System.out.println(wine[0]);
        } else {
            drink[0] = new int[]{wine[0], wine[0]};
            drink[1] = new int[]{wine[1], wine[0] + wine[1]};
            for (int i = 2; i < n; i++) {
                drink[i][0] = Math.max(wine[i] + Math.max(drink[i - 2][0], drink[i - 2][1]), Math.max(drink[i - 1][0], drink[i - 1][1]));
                drink[i][1] = wine[i] + drink[i - 1][0];
            }

            int max = 0;
            for (int[] i : drink) {
                max = Math.max(max, Math.max(i[0], i[1]));
            }
            System.out.println(max);
        }
    }
}
