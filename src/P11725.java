import java.io.*;
import java.util.*;

public class P11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < N; i++) {
            tree.put(i, new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken()) - 1;
            tree.get(j).add(k);
            tree.get(k).add(j);
        }

        int[] answer = new int[N];
        Queue<Integer> queue= new LinkedList<>();
        queue.offer(0);
        boolean[] visit = new boolean[N];
        visit[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : tree.get(node)) {
                if (!visit[i]) {
                    answer[i] = node;
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
        for (int i = 1; i < N; i++) {
            System.out.println(answer[i] + 1);
        }
    }
}
