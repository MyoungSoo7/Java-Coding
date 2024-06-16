import java.io.*;
import java.util.*;

public class P14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] consult = new int[N][2];
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            consult[n][0] = Integer.parseInt(st.nextToken());
            consult[n][1] = Integer.parseInt(st.nextToken());
        }

        int[] maxPay = new int[N];
        int answer = 0;
        for (int n = 0; n < N; n++) {
            if (consult[n][0] + n > N) {
                continue;
            }

            int max = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (consult[i][0] <= n - i) {
                    max = Math.max(max, maxPay[i]);
                }
            }
            maxPay[n] = max + consult[n][1];
            answer = Math.max(answer, maxPay[n]);
        }
        System.out.println(answer);
    }
}
