import java.io.*;
import java.util.*;

public class P11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] price = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] maxPrices = new int[N];
        for (int n = 0; n < N; n++) {
            int max = price[n];
            for (int i = n - 1; i >= 0; i--) {
                max = Math.max(max, maxPrices[i] + price[n - i - 1]);
            }
            maxPrices[n] = max;
        }
        System.out.println(maxPrices[N - 1]);
    }
}
