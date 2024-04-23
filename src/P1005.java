import java.io.*;
import java.util.*;

public class P1005 {
    static class Building {
        int time;
        int prevCount;
        List<Building> prev = new ArrayList<>();
        List<Building> next = new ArrayList<>();

        public Building(int time) {
            this.time = time;
        }

        List<Building> updateTime() {
            int max = 0;
            for (Building b : prev) {
                max = Math.max(max, b.time);
            }
            this.time += max;

            List<Building> result = new ArrayList<>();
            for (Building b : next) {
               if (--b.prevCount == 0) {
                    result.add(b);
               }
            }
            return result;
        }
    }

    static int solve(BufferedReader br) throws IOException {
        StringTokenizer st;
        Building[] buildingList;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        buildingList = new Building[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            buildingList[n] = new Building(Integer.parseInt(st.nextToken()));
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            buildingList[u].next.add(buildingList[v]);
            buildingList[v].prev.add(buildingList[u]);
            buildingList[v].prevCount++;
        }

        int W = Integer.parseInt(br.readLine());

        Queue<Building> queue = new LinkedList<>();
        for (int n = 1; n <= N; n++) {
            if (buildingList[n].prevCount == 0) {
                queue.offer(buildingList[n]);
            }
        }

        while (!queue.isEmpty()) {
            Building cur = queue.poll();
            List<Building> next = cur.updateTime();
            for (Building b : next) {
                queue.offer(b);
            }
        }
        return buildingList[W].time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            System.out.println(solve(br));
        }
    }
}