import java.io.*;
import java.util.*;

public class P1240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.get(u).add(new int[]{v, c});
            edges.get(v).add(new int[]{u, c});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            boolean[] visit = new boolean[N + 1];
            queue.offer(new int[]{start, 0});
            visit[start] = true;

            while (!queue.isEmpty()) {
                int[] u = queue.poll();
                if (u[0] == end) {
                    sb.append(u[1]).append("\n");
                    break;
                }
                for (int[] v : edges.get(u[0])) {
                    if (!visit[v[0]]) {
                        queue.offer(new int[]{v[0], u[1] + v[1]});
                        visit[v[0]] = true;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
