import java.io.*;

public class P1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        int count = 0;
        while (X.length() != 1) {
            int sum = 0;
            for (char c : X.toCharArray()) {
                sum += c - '0';
            }
            X = String.valueOf(sum);
            count++;
        }
        System.out.println(count);
        System.out.println(Integer.parseInt(X) % 3 == 0 ? "YES" : "NO");
    }
}
