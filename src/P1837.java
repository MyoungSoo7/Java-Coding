import java.io.*;
import java.math.BigInteger;

public class P1837 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        BigInteger P = new BigInteger(s[0]);

        boolean result = false;
        int prime = 0;
        BigInteger num = new BigInteger(s[1]);
        for (BigInteger i = new BigInteger("2"); i.compareTo(num) < 0; i = i.add(BigInteger.ONE)) {
            if (P.mod(i).equals(BigInteger.ZERO)) {
                prime = i.intValue();
                result = true;
                break;
            }
        }

        if (result) {
            System.out.printf("BAD %d", prime);
        } else {
            System.out.println("GOOD");
        }
    }
}
