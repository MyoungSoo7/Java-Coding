import java.io.*;

public class P30053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int max = -1000000, min = 1000000;
            int N = Integer.parseInt(br.readLine());
            String[] nums = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(nums[j]);
                if (num > max) {
                    max = num;
                }
                if (num < min) {
                    min = num;
                }
            }
            System.out.println(min + " " + max);
        }
    }
}
