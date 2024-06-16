import java.io.*;

public class P2485 {
    static int gcd(int a, int b) {
        while (a % b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] tree = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int gcd = tree[1] - tree[0];
        for (int i = 1; i < N - 1; i++) {
            gcd = gcd(gcd, tree[i + 1] - tree[i]);
        }

        int pos = tree[0];
        int index = 0;
        int answer = 0;
        while (index != N) {
            if (pos == tree[index]) {
                index++;
            } else {
                answer++;
            }
            pos += gcd;
        }
        System.out.println(answer);
    }
}
