import java.io.*;
import java.math.*;

public class P1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        BigDecimal[] mean = new BigDecimal[N];
        for (int n = 0; n < N; n++) {
            mean[n] = new BigDecimal(br.readLine());
        }

        loop : for (int person = 1; person <= 1000; person++) {
            BigDecimal p = new BigDecimal(person);
            for (BigDecimal m : mean) {
                BigDecimal sum = m.multiply(p);
                if (sum.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) > 0) {
                    BigDecimal sumToInt = new BigDecimal(sum.toBigInteger().add(BigInteger.ONE));
                    if (!sumToInt.divide(p, 3, RoundingMode.DOWN).equals(m)) {
                        continue loop;
                    }
                }
            }
            System.out.println(person);
            break;
        }
    }
}
