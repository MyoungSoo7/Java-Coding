import java.io.*;
import java.util.*;

public class P14889 {
    static void combination(List<List<Integer>> result, boolean[] visit, int s, int r) {
        if (r == 0) {
            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    start.add(i);
                } else {
                    link.add(i);
                }
            }
            result.add(start);
            result.add(link);
            return;
        }

        for (int i = s; i < visit.length; i++) {
            visit[i] = true;
            combination(result, visit, i + 1, r - 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] synergy = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                synergy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visit = new boolean[N];
        List<List<Integer>> combinations = new ArrayList<>();
        combination(combinations, visit, 0, N / 2);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < combinations.size() / 2; i++) {
            List<Integer> start = combinations.get(2 * i);
            List<Integer> link = combinations.get(2 * i + 1);
            int startStat = 0;
            int linkStat = 0;
            for (int j = 0; j < N / 2 - 1; j++) {
                for (int k = j; k < N / 2; k++) {
                    int s1 = start.get(j);
                    int s2 = start.get(k);
                    int l1 = link.get(j);
                    int l2 = link.get(k);
                    startStat += synergy[s1][s2];
                    startStat += synergy[s2][s1];
                    linkStat += synergy[l1][l2];
                    linkStat += synergy[l2][l1];
                }
            }
            min = Math.min(min, Math.abs(startStat - linkStat));
        }
        System.out.println(min);
    }
}
