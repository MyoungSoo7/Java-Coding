import java.io.*;

public class P2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = N; i > 0; i--) {
            System.out.println("*".repeat(i));
        }
    }
}
