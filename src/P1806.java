import java.io.*;
import java.util.*;

public class P1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        int[] val = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            val[n] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, min = Integer.MAX_VALUE, sum = 0;
        while (right <= N) {
            if (S <= sum) {
                min = Math.min(min, right - left);
                sum -= val[left++];
            } else {
                sum += val[right++];
            }
        }

        if (min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }
}
