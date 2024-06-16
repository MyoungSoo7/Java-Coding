import java.io.*;
import java.util.*;

public class P4580 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            int prev = 0;
            for (int i = 0; i < k; i++) {
                int data = Integer.parseInt(st.nextToken());
                for (int j = 0; j < data - prev; j++) {
                    System.out.print((i + 1) + " ");
                }
                prev = data;
            }
            System.out.println();
        }
    }
}
