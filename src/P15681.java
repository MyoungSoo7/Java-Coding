import java.io.*;
import java.util.*;

public class P15681 {
    static void dfs(int node, List<List<Integer>> edges, boolean[] visit, int[] subtree) {
        int count = 0;
        for (int next : edges.get(node)) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(next, edges, visit, subtree);
                count += subtree[next];
            }
        }
        subtree[node] = count + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(null);
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            edges.get(U).add(V);
            edges.get(V).add(U);
        }

        int[] subtree = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        visit[R] = true;
        dfs(R, edges, visit, subtree);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(subtree[query]).append("\n");
        }
        System.out.println(sb);
    }
}
