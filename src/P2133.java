import java.io.*;

public class P2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] tiling = new int[31];
        tiling[0] = 1;
        tiling[2] = 3;
        for (int i = 4; i <= 30; i += 2) {
            tiling[i] = tiling[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                tiling[i] += tiling[j] * 2;
            }
        }
        System.out.println(tiling[N]);
    }
}
