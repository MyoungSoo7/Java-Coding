import java.io.*;
import java.util.*;

class Vertex {
    int v;
    int weight;

    public Vertex(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}

public class P1167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        List<List<Vertex>> tree = new ArrayList<>();
        tree.add(null);
        for (int v = 0; v < V; v++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            List<Vertex> u = tree.get(Integer.parseInt(st.nextToken()));
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                u.add(new Vertex(v, cost));
            }
        }

        boolean[] visit = new boolean[V + 1];
        int[] maxDistance = new int[]{1, 0};
        getDiameter(tree, visit, 1, 0, maxDistance);
        visit = new boolean[V + 1];
        getDiameter(tree, visit, maxDistance[0], 0, maxDistance);
        System.out.println(maxDistance[1]);
    }

    static void getDiameter(List<List<Vertex>> tree, boolean[] visit, int u, int weight, int[] maxDistance) {
        visit[u] = true;

        if (weight > maxDistance[1]) {
            maxDistance[0] = u;
            maxDistance[1] = weight;
        }

        for (Vertex vertex : tree.get(u)) {
            if (!visit[vertex.v]) {
                getDiameter(tree, visit, vertex.v, weight + vertex.weight, maxDistance);
            }
        }
    }
}
