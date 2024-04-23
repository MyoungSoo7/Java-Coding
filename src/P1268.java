import java.io.*;
import java.util.*;

public class P1268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] classNum = new int[N][N];
        StringTokenizer st;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int g = 0; g < 5; g++) {
                classNum[n][g] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0, answer = 0;
        for (int n = 0; n < N; n++) {
            int[] student = classNum[n];
            Set<Integer> set = new HashSet<>();
            for (int g = 0; g < 5; g++) {
                for (int m = 0; m < N; m++) {
                    if (student[g] == classNum[m][g]) {
                        set.add(m);
                    }
                }
            }
            if (max < set.size()) {
                max = set.size();
                answer = n + 1;
            }
        }
        System.out.println(answer);
    }
}
