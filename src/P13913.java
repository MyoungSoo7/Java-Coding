import java.io.*;
import java.util.*;

public class P13913 {
    static final int MAX_POS = 200001;

    static class Subin {
        int pos;
        int time;
        List<Integer> trace;

        public Subin(int pos, int time, List<Integer> trace) {
            this.pos = pos;
            this.time = time;
            this.trace = trace;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);

        if (N > K) {
            System.out.println(N - K);
            for (int i = N; i >= K; i--) {
                System.out.print(i + " ");
            }
            return;
        }

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Subin> queue = new LinkedList<>();
        int[] visit = new int[MAX_POS];
        Arrays.fill(visit, Integer.MAX_VALUE);
        queue.offer(new Subin(N, 0, new ArrayList<>()));
        visit[N] = 0;
        while (!queue.isEmpty()) {
            Subin cur = queue.poll();
            cur.trace.add(cur.pos);

            if (cur.pos == K) {
                System.out.println(cur.time);
                for (int i : cur.trace) {
                    System.out.print(i + " ");
                }
                break;
            }

            if (cur.pos - 1 >= 0 && cur.time + 1 < visit[cur.pos - 1]) {
                queue.offer(new Subin(cur.pos - 1, cur.time + 1, new ArrayList<>(cur.trace)));
                visit[cur.pos - 1] = cur.time + 1;
            }
            if (cur.pos + 1 < MAX_POS && cur.time + 1 < visit[cur.pos + 1]) {
                queue.offer(new Subin(cur.pos + 1, cur.time + 1, new ArrayList<>(cur.trace)));
                visit[cur.pos + 1] = cur.time + 1;
            }
            if (cur.pos * 2 < MAX_POS && cur.time + 1 < visit[cur.pos * 2]) {
                queue.offer(new Subin(cur.pos * 2, cur.time + 1, new ArrayList<>(cur.trace)));
                visit[cur.pos * 2] = cur.time + 1;
            }
        }
    }
}
