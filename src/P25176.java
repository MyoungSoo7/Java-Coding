import java.io.*;

public class P25176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(factorial(N));
    }

    public static int factorial(int n) {
        return n == 1 ? 1 : n * factorial(n - 1);
    }
}
