import java.io.*;
import java.util.*;

public class P9610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[4];
        int axis = 0;
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) {
                axis++;
                continue;
            }
            result[(x > 0 ? 0 : 1) + (y > 0 ? 0 : 1) * 2]++;
        }

        int index = 1;
        for (int i : new int[]{0, 1, 3, 2}) {
            System.out.printf("Q%d: %d%n", index++, result[i]);
        }
        System.out.printf("AXIS: %d%n", axis);
    }
}
