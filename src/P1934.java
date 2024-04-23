import java.io.*;

public class P1934 {
    static int solve(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int mul = A * B;

        while (A % B != 0) {
            int remain = A % B;
            A = B;
            B = remain;
        }
        return mul / B;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            System.out.println(solve(br));
        }
    }
}
