import java.io.*;
import java.util.*;

public class P1260 {
    static class Node implements Comparable<Node> {
        int num;
        Set<Node> next;

        Node(int num) {
            this.num = num;
            next = new TreeSet<>();
        }

        void addNextNode(Node node) {
            next.add(node);
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.num, node.num);
        }
    }

    static void dfs(Node[] graph, boolean[] visit, int start) {
        System.out.print(start + " ");
        visit[start] = true;

        for (Node node : graph[start].next) {
            if (visit[node.num]) {
                continue;
            }

            visit[node.num] = true;
            dfs(graph, visit, node.num);
        }
    }

    static void bfs(Node[] graph, boolean[] visit, int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(graph[start]);
        visit[start] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.num + " ");

            for (Node node : cur.next) {
                if (visit[node.num]) {
                    continue;
                }

                visit[node.num] = true;
                queue.offer(node);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());

        Node[] graph = new Node[N + 1];
        for (int n = 1; n <= N; n++) {
            graph[n] = new Node(n);
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            Node p = graph[Integer.parseInt(st.nextToken())], q = graph[Integer.parseInt(st.nextToken())];
            p.addNextNode(q);
            q.addNextNode(p);
        }

        boolean[] visit = new boolean[N + 1];
        dfs(graph, visit, V);
        System.out.println();

        visit = new boolean[N + 1];
        bfs(graph, visit, V);
    }
}
