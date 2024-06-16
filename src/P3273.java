import java.io.*;
import java.util.*;

public class P3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> seq = List.copyOf(set);
        int x = Integer.parseInt(br.readLine());
        int left = 0, right = n - 1;
        int answer = 0;
        while (left < right) {
            int add = seq.get(left) + seq.get(right);
            if (add < x) {
                left++;
            } else if (add > x) {
                right--;
            } else {
                answer++;
                left++;
                right--;
            }
        }
        System.out.println(answer);
    }
}
