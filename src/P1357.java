import java.io.*;
import java.util.*;

public class P1357 {
    static int rev(int n) {
        int result = 0;
        int pos = 1;
        for (char c : String.valueOf(n).toCharArray()) {
            result += pos * (c - '0');
            pos *= 10;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        final int X = Integer.parseInt(input[0]);
        final int Y = Integer.parseInt(input[1]);
        System.out.println(rev(rev(X) + rev(Y)));
    }
}
