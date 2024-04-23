import java.io.*;

public class P1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        final String N = String.valueOf(num);

        for (int i = 1; i < N.length(); i++) {
            int s1 = 1;
            int s2 = 1;
            for (int j = 0; j < N.length(); j++) {
                if (j < i) {
                    s1 *= N.charAt(j) - '0';
                } else {
                    s2 *= N.charAt(j) - '0';
                }
            }

            if (s1 == s2) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
