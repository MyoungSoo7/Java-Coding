import java.io.*;
import java.math.BigInteger;

public class P1247 {
    final static char[] result = new char[]{'-', '0', '+'};

    static char solve(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        BigInteger sum = new BigInteger("0");
        for (int n = 0; n < N; n++) {
            sum = sum.add(new BigInteger(br.readLine()));
        }
        return result[sum.compareTo(BigInteger.ZERO) + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            System.out.println(solve(br));
        }
    }
}
