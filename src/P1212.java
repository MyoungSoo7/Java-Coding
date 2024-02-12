import java.io.*;
import java.math.BigInteger;

public class P1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger octal = new BigInteger(br.readLine(), 8);
        System.out.println(octal.toString(2));
    }
}
