import java.io.*;

public class P6930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int n = 1; n < m; n++) {
            if ((x * n) % m == 1) {
                System.out.println(n);
                return;
            }
        }
        System.out.println("No such integer exists.");
    }
}
