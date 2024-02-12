import java.io.*;

public class P10093 {
    static void print(long n1, long n2) {
        System.out.println(n2 - n1 - 1);
        StringBuilder sb = new StringBuilder();
        for (long i = n1 + 1; i < n2; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        long n1 = Long.parseLong(num[0]), n2 = Long.parseLong(num[1]);
        if (n1 < n2) {
            print(n1, n2);
        } else if (n1 > n2) {
            print(n2, n1);
        } else {
            System.out.println(0);
        }
    }
}
