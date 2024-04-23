import java.io.*;
import java.util.*;

public class P1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            array[n] = new int[]{Integer.parseInt(st.nextToken()), n};
        }

        Arrays.sort(array, (n1, n2) -> {
            int compare = Integer.compare(n1[0], n2[0]);
            if (compare == 0) {
                return Integer.compare(n1[1], n2[1]);
            } else {
                return compare;
            }
        });

        int[] answer = new int[N];
        for (int n = 0; n < N; n++) {
            answer[array[n][1]] = n;
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
