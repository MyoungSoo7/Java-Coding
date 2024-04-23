import java.io.*;
import java.util.*;

public class P1679 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] numList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            numList[n] = Integer.parseInt(st.nextToken());
        }
        int maxUse = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while (true) {
            int cur = list.size();
            int minUse = Integer.MAX_VALUE;
            for (int num : numList) {
                int index = cur - num;
                if (index >= 0 && list.get(index) < maxUse) {
                    minUse = Math.min(minUse, list.get(index) + 1);
                }
            }

            if (minUse == Integer.MAX_VALUE) {
                break;
            } else {
                list.add(minUse);
            }
        }

        String winner = "hol";
        if (list.size() % 2 == 1) {
            winner = "jjak";
        }
        System.out.println(winner + "soon win at " + (list.size()));
    }
}
