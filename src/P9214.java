import java.io.*;

public class P9214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1;; t++) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }

            while (num.length() % 2 == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < num.length() / 2; i++) {
                    char times = num.charAt(2 * i);
                    char val = num.charAt(2 * i + 1);
                    sb.append(String.valueOf(val).repeat(times - '0'));
                }

                if (sb.toString().equals(num)) {
                    break;
                }
                num = sb.toString();
            }
            System.out.printf("Test %d: %s%n", t, num);
        }
    }
}
