import java.io.*;
import java.util.*;

public class P1747 {
    static List<Integer> primes = new ArrayList<>();

    static boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);
        boolean isPrime = true;
        for (int prime : primes) {
            if (sqrt < prime) {
                break;
            }
            if (n % prime == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            primes.add(n);
        }
        return isPrime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            N = 2;
        }
        primes.add(2);

        for (int i = 3; i < N; i++) {
            isPrime(i);
        }

        for (int i = N;;i++) {
            if (isPrime(i)) {
                StringBuilder sb = new StringBuilder(String.valueOf(i));
                String origin = sb.toString();
                String reversed = sb.reverse().toString();
                if (origin.equals(reversed)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
