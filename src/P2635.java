import java.io.*;
import java.util.*;

public class P2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int n = 0; n <= N; n++) {
            List<Integer> tmp = new ArrayList<>();
            int n1 = N, n2 = n;
            tmp.add(n1);
            tmp.add(n2);
            while (n1 >= n2) {
                int next = n1 - n2;
                n1 = n2;
                n2 = next;
                tmp.add(next);
            }

            if (max < tmp.size()) {
                max = tmp.size();
                list = tmp;
            }
        }
        System.out.println(max);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
