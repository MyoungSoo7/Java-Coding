import java.io.*;

public class P1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        double X = Double.parseDouble(input[0]), Y = Double.parseDouble(input[1]);

        int target = (int) Math.floor(Y * 100 / X) + 1;
        if (target >= 100) {
            System.out.println(-1);
            return;
        }

        long left = 1, right = Long.MAX_VALUE / 2;
        while (left < right) {
            long mid = (left + right) / 2;
            int percent = (int) (Math.floor((Y + mid) * 100 / (X + mid)));
            if (percent < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(right);
    }
}
