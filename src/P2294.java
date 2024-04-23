import java.io.*;

public class P2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);
        int[] money = new int[N];
        for (int n = 0; n < N; n++) {
            money[n] = Integer.parseInt(br.readLine());
        }

        int[] minCount = new int[K + 1];
        for (int k = 1; k <= K; k++) {
            minCount[k] = -1;
        }

        for (int k = 1; k <= K; k++) {
            int min = Integer.MAX_VALUE;
            for (int m : money) {
                int index = k - m;
                if (index >= 0 && minCount[index] != -1) {
                    min = Math.min(min, minCount[index] + 1);
                }
            }
            if (min != Integer.MAX_VALUE) {
                minCount[k] = min;
            }
        }
        System.out.println(minCount[K]);
    }
}
