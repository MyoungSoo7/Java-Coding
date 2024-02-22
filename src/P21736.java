import java.io.*;
import java.util.*;

public class P21736 {
    static final int[] DX = new int[]{1, -1, 0, 0};
    static final int[] DY = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0], M = input[1];
        String[] campus = new String[N];
        int[] I = new int[2];
        for (int x = 0; x < N; x++) {
            campus[x] = br.readLine();
            int index = campus[x].indexOf('I');
            if (index != -1) {
                I[0] = x;
                I[1] = index;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        queue.offer(I);
        visit[I[0]][I[1]] = true;
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (campus[cur[0]].charAt(cur[1]) == 'P') {
                answer++;
            }

            for (int i = 0; i < 4; i++) {
                int dx = cur[0] + DX[i];
                int dy = cur[1] + DY[i];
                if (0 <= dx && dx < N && 0 <= dy && dy < M && !visit[dx][dy] && campus[dx].charAt(dy) != 'X') {
                    queue.offer(new int[]{dx, dy});
                    visit[dx][dy] = true;
                }
            }
        }
        System.out.println(answer == 0 ? "TT" : answer);
    }
}
