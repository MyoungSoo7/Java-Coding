import java.io.*;

public class P4134 {
    static boolean isPrime(long n) {
        for (long i = 3; i < (long) Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine());
            if (n <= 2) {
                System.out.println(2);
                continue;
            }

            if (n % 2 == 0) {
                n++;
            }

            while (!isPrime(n)) {
                n += 2;
            }
            System.out.println(n);
        }
    }
}
