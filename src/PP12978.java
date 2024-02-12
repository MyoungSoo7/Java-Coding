import java.util.*;

class Main2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }
}

class Road implements Comparable<Road> {
    int end;
    int cost;

    public Road(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road r) {
        return Integer.compare(this.cost, r.cost);
    }
}

class Solution2 {

    public int solution(int N, int[][] road, int K) {
        Map<Integer, List<Road>> costs = new HashMap<>();
        for (int i = 0; i < N + 1; i++) {
            costs.put(i, new ArrayList<>());
        }
        for (int[] r : road) {
            costs.get(r[0]).add(new Road(r[1], r[2]));
            costs.get(r[1]).add(new Road(r[0], r[2]));
        }

        int[] dijkstra = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dijkstra[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(1, 0));
        dijkstra[1] = 0;
        while (!pq.isEmpty()) {
            Road cur = pq.poll();

            if (dijkstra[cur.end] < cur.cost) {
                continue;
            }
            for (Road r : costs.get(cur.end)) {
                int nextCost = dijkstra[cur.end] + r.cost;
                if (nextCost < dijkstra[r.end]) {
                    dijkstra[r.end] = nextCost;
                    pq.offer(r);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dijkstra[i] <= K) answer++;
        }
        return answer;
    }
}