import java.io.*;

public class P11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tiling = new int[N == 1 ? 3 : N + 1];
        tiling[1] = 1;
        tiling[2] = 3;
        for (int n = 3; n <= N; n++) {
            tiling[n] = (tiling[n - 2] * 2 + tiling[n - 1]) % 10007;
        }
        System.out.println(tiling[N]);
    }
}
