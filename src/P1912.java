import java.io.*;
import java.util.*;
import static java.lang.Math.max;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cur = 0;
        int max = -1001;
        for (int n = 0; n < N; n++) {
            cur = max(cur + nums[n], nums[n]);
            max = max(max, cur);
        }
        System.out.println(max);
    }
}
