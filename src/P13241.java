import java.io.*;
import java.util.*;

public class P13241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]), B = Long.parseLong(input[1]);

        long mul = A * B;
        while (A % B != 0) {
            long remain = A % B;
            A = B;
            B = remain;
        }
        System.out.println(mul / B);
    }
}

