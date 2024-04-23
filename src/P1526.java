import java.io.*;

public class P1526 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        loop : for (int n = N; n >= 4; n--) {
            String num = String.valueOf(n);
            for (char c : num.toCharArray()) {
                if (!(c == '4' || c == '7')) {
                    continue loop;
                }
            }
            System.out.println(n);
            break;
        }
    }
}
