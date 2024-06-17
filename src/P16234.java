import java.io.*;
import java.util.*;

public class P16234 {
    static class Land {
        final int[] DX = new int[]{1, -1, 0, 0};
        final int[] DY = new int[]{0, 0, 1, -1};

        int[][] pop;
        int N;
        int L;
        int R;

        Land(int[][] pop, int l, int r) {
            this.pop = pop;
            this.N = pop.length;
            this.L = l;
            this.R = r;
        }

        boolean migrate() {
            boolean result = false;
            boolean[][] visit = new boolean[this.N][this.N];
            int[][] change = new int[this.N][this.N];
            Queue<int[]> queue = new LinkedList<>();
            for (int x = 0; x < this.N; x++) {
                for (int y = 0; y < this.N; y++) {
                    // BFS
                    if (!visit[x][y]) {
                        List<int[]> list = new ArrayList<>();
                        int[] first = new int[]{x, y};
                        queue.offer(first);
                        list.add(first);
                        visit[x][y] = true;
                        int count = 1;
                        int sum = this.pop[x][y];
                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            for (int i = 0; i < 4; i++) {
                                int dx = cur[0] + DX[i];
                                int dy = cur[1] + DY[i];
                                if (dx < 0 || dx >= this.N || dy < 0 || dy >= this.N || visit[dx][dy]) {
                                    continue;
                                }
                                int diff = Math.abs(this.pop[cur[0]][cur[1]] - this.pop[dx][dy]);
                                if (L <= diff && diff <= R) {
                                    int[] add = new int[]{dx, dy};
                                    queue.offer(add);
                                    list.add(add);
                                    visit[dx][dy] = true;
                                    sum += this.pop[dx][dy];
                                    count++;
                                }
                            }
                        }
                        if (count > 1) {
                            result = true;
                        }
                        int newPop = sum / count;
                        for (int[] cur : list) {
                            change[cur[0]][cur[1]] = newPop;
                        }
                    }
                }
            }
            if (result) {
                apply(change);
            }
            return result;
        }

        void apply(int[][] change) {
            for (int x = 0; x < this.N; x++) {
                for (int y = 0; y < this.N; y++) {
                    this.pop[x][y] = change[x][y];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] pop = new int[N][N];
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                pop[x][y] = Integer.parseInt(st.nextToken());
            }
        }
        Land land = new Land(pop, L, R);
        int count = 0;
        while(land.migrate()) {
            count++;
        }
        System.out.println(count);
    }
}
