import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
    int end;
    int cost;

    public Bus(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus bus) {
        return Integer.compare(this.cost, bus.cost);
    }
}

public class P1916 {
    static List<List<Bus>> buses = new ArrayList<>();

    static void dijkstra(int[] costs, int start) {
        PriorityQueue<Bus> queue = new PriorityQueue<>();
        queue.offer(new Bus(start, 0));
        costs[start] = 0;
        while (!queue.isEmpty()) {
            Bus curBus = queue.poll();

            if (costs[curBus.end] < curBus.cost) {
                continue;
            }
            for (Bus nextBus : buses.get(curBus.end)) {
                int nextCost = costs[curBus.end] + nextBus.cost;
                if (costs[nextBus.end] > nextCost) {
                    costs[nextBus.end] = nextCost;
                    queue.offer(nextBus);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            buses.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            buses.get(start).add(new Bus(end, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start  = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        int[] cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
        dijkstra(cost, start);
        System.out.println(cost[end]);
    }
}
