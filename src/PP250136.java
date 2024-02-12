import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
    }
}

class Solution {
    final int[] DX = new int[]{1, -1, 0, 0};
    final int[] DY = new int[]{0, 0, 1, -1};

    public int solution(int[][] land) {
        int N = land.length;
        int M = land[0].length;
        Map<Integer, Integer> oil = new HashMap<>();

        for (int i = 0; i < M; i++) {
            oil.put(i, 0);
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (land[x][y] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    Set<Integer> ySet = new HashSet<>();
                    q.offer(new int[]{x, y});
                    ySet.add(y);
                    land[x][y] = 0;
                    int size = 1;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int i = 0; i < 4; i++) {
                            int dx = cur[0] + DX[i];
                            int dy = cur[1] + DY[i];
                            if (0 <= dx && dx < N && 0 <= dy && dy < M && land[dx][dy] == 1) {
                                size++;
                                q.offer(new int[]{dx, dy});
                                ySet.add(dy);
                                land[dx][dy] = 0;
                            }
                        }
                    }

                    for (int i : ySet) {
                        oil.put(i, oil.get(i) + size);
                    }
                }
            }
        }

        int max = 0;
        for (int i : oil.keySet()) {
            if (oil.get(i) > max) max = oil.get(i);
        }
        return max;
    }
}