import java.io.*;

public class P2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N > 1 ? N + 1 : 3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int n = 3; n <= N; n++) {
            for (int i = n - 2; i >= 0; i--) {
                dp[n] += dp[i];
            }
        }
        System.out.println(dp[N]);
    }
}
