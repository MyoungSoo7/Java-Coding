import java.io.*;
import java.util.*;

public class P1197 {
    static class Vertex implements Comparable<Vertex> {
        int u, v;
        int cost;

        public Vertex(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex v) {
            return Integer.compare(this.cost, v.cost);
        }
    }

    static int getParent(int[] root, int u) {
        int result = u;
        while (root[result] != result) {
            result = root[result];
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Vertex> vertices = new PriorityQueue<>();
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            vertices.offer(new Vertex(u, v, c));
        }

        int[] root = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            root[i] = i;
        }

        int cost = 0;
        int count = 0;
        while (!vertices.isEmpty()) {
            Vertex cur = vertices.poll();
            if (getParent(root, cur.u) != getParent(root, cur.v)) {
                root[getParent(root, cur.v)] = getParent(root, cur.u);
                cost += cur.cost;
                count++;
            }
            if (count == V - 1) {
                break;
            }
        }
        System.out.println(cost);
    }
}
