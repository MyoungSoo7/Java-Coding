import java.io.*;
import java.util.*;

public class P1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] boxes = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            boxes[n] = Integer.parseInt(st.nextToken());
        }

        int[] maxBoxes = new int[N];
        maxBoxes[0] = 1;
        int answer = 1;
        for (int n = 1; n < N; n++) {
            int max = 1;
            for (int m = 0; m < n; m++) {
                if (boxes[m] < boxes[n]) {
                    max = Math.max(max, maxBoxes[m] + 1);
                }
            }
            maxBoxes[n] = max;
            answer = Math.max(answer, max);
        }
        System.out.println(answer);
    }
}
