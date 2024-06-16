import java.io.*;
import java.util.*;

public class P2636 {
    static final int[] DR = new int[]{1, -1, 0, 0};
    static final int[] DC = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        boolean[][] cheese = new boolean[R][C];
        int remain = 0;
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                if (st.nextToken().equals("1")) {
                    cheese[r][c] = true;
                    remain++;
                }
            }
        }

        Set<String> air = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0 0");
        air.add("0 0");

        int before = 0, time = 0;
        while (remain != 0) {
            time++;
            List<String> melt = new ArrayList<>();
            while(!queue.isEmpty()) {
                st = new StringTokenizer(queue.poll());
                int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
                for (int i = 0; i < 4; i++) {
                    int dr = r + DR[i];
                    int dc = c + DC[i];
                    if (0 <= dr && dr < R && 0 <= dc && dc < C) {
                        String coor = String.format("%d %d", dr, dc);

                        if (air.contains(coor)) {
                            continue;
                        }

                        if (cheese[dr][dc]) {
                            melt.add(coor);
                            air.add(coor);
                            continue;
                        }

                        air.add(coor);
                        queue.add(coor);
                    }
                }
            }

            before = remain;
            for (String s : melt) {
                st = new StringTokenizer(s);
                cheese[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
                remain--;
                queue.offer(s);
            }
        }
        System.out.println(time);
        System.out.println(before);
    }
}
