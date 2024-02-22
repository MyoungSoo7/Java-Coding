import java.io.*;
import java.util.*;

public class P11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] max = new int[N];
        int answer = 0;
        for (int n = 0; n < N; n++) {
            for (int i = n - 1; i >= 0; i--) {
                if (A[n] > A[i] && max[n] < 1 + max[i]) {
                    max[n] = 1 + max[i];
                }
            }
            if (max[n] == 0) {
                max[n] = 1;
            }
            answer = Math.max(max[n], answer);
        }
        System.out.println(answer);
    }
}
