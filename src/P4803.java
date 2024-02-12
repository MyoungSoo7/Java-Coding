import java.io.*;
import java.util.*;

public class P4803 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = 1;
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }
            String[] s = input.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            List<Integer>[] edges = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                edges[i] = new ArrayList<>();
            }

            StringTokenizer st;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int e1 = Integer.parseInt(st.nextToken());
                int e2 = Integer.parseInt(st.nextToken());
                edges[e1].add(e2);
                edges[e2].add(e1);
            }

            boolean[] visit = new boolean[n + 1];
            int[] parent = new int[n + 1];
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (visit[i]) {
                    continue;
                }
                boolean isTree = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visit[i] = true;
                loop : while (!queue.isEmpty()) {
                    int curVertex = queue.poll();
                    for (int next : edges[curVertex]) {
                        if (!visit[next]) {
                            queue.offer(next);
                            visit[next] = true;
                            parent[next] = curVertex;
                        } else {
                            if (parent[curVertex] == next) {
                                continue;
                            }
                            isTree = false;
                            break loop;
                        }
                    }
                }

                if (isTree) {
                    count++;
                }
            }

            switch (count) {
                case 0:
                    System.out.printf("Case %d: No trees.\n", testCase);
                    break;
                case 1:
                    System.out.printf("Case %d: There is one tree.\n", testCase);
                    break;
                default:
                    System.out.printf("Case %d: A forest of %d trees.\n", testCase, count);
            }
            testCase++;
        }
    }
}
