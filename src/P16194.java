
import java.io.*;
import java.util.*;

public class P16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] price = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] minPrices = new int[N];
        for (int n = 0; n < N; n++) {
            int min = price[n];
            for (int i = n - 1; i >= 0; i--) {
                min = Math.min(min, minPrices[i] + price[n - i - 1]);
            }
            minPrices[n] = min;
        }
        System.out.println(minPrices[N - 1]);
    }
}
