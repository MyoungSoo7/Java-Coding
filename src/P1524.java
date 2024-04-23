import java.io.*;
import java.util.*;

public class P1524 {
    static char solve(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        StringTokenizer st;

        int[] sPower = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            sPower[n] = Integer.parseInt(st.nextToken());
        }

        int[] bPower = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            bPower[m] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sPower);
        Arrays.sort(bPower);
        int n = 0, m = 0;
        while (n < N && m < M) {
            if (sPower[n] < bPower[m]) {
                n++;
            } else {
                m++;
            }
        }
        return n == N ? 'B' : 'S';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            br.readLine();
            System.out.println(solve(br));
        }
    }
}
