import java.io.*;
import java.util.*;

public class P1778 {
    static boolean solve(BufferedReader br, int caseNum) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        if (N + M == 0) {
            return false;
        }
        List<List<Integer>> relations = new ArrayList<>();
        relations.add(null);
        for (int n = 0; n < N; n++) {
            relations.add(new ArrayList<>());
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            relations.get(u).add(v);
            relations.get(v).add(u);
        }

        int count = 0;
        boolean[] visit = new boolean[N + 1];
        for (int n = 1; n <= N; n++) {
            if (!visit[n]) {
                count++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(n);
                visit[n] = true;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    List<Integer> relation = relations.get(cur);
                    for (int next : relation) {
                        if (!visit[next]) {
                            q.offer(next);
                            visit[next] = true;
                        }
                    }
                }
            }
        }
        System.out.printf("Case %d: %d%n", caseNum, count);
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = 1;
        while (solve(br, caseNum)) {
            caseNum++;
        }
    }
}
