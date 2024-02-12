import java.io.*;
import java.util.*;

public class P11559 {
    static final int[] DX = {1, -1, 0, 0};
    static final int[] DY = {0, 0, 1, -1};

    static boolean pop(StringBuilder[] field) {
        boolean isDeleted = false;
        boolean[][] visit = new boolean[12][6];

        for (int x = 0; x < 12; x++) {
            for (int y = 0; y < 6; y++) {
                char c = field[x].charAt(y);
                if (!visit[x][y] && c != '.') {
                    List<int[]> list = new ArrayList<>();
                    Queue<int[]> queue = new LinkedList<>();
                    int[] n1 = new int[]{x, y};
                    queue.add(n1);
                    list.add(n1);
                    visit[x][y] = true;
                    while(!queue.isEmpty()) {
                        int[] pos = queue.remove();
                        for (int i = 0; i < 4; i++) {
                            int dx = pos[0] + DX[i];
                            int dy = pos[1] + DY[i];
                            if (0 <= dx && dx < 12 && 0 <= dy && dy < 6 && !visit[dx][dy] && field[dx].charAt(dy) == c) {
                                int[] n2 = new int[]{dx, dy};
                                queue.add(n2);
                                list.add(n2);
                                visit[dx][dy] = true;
                            }
                        }
                    }
                    if (list.size() >= 4) {
                        isDeleted = true;
                        for (int[] i : list) {
                            field[i[0]].setCharAt(i[1], '.');
                        }
                    }
                }
            }
        }
        return isDeleted;
    }

    static void fall(StringBuilder[] field) {
        for (int x = 11; x >= 0; x--) {
            for (int y = 0; y < 6; y++) {
                char c = field[x].charAt(y);
                if (c != '.') {
                    int nx = x;
                    while ((nx + 1) < 12 && field[nx + 1].charAt(y) == '.') {
                        nx++;
                    }
                    field[x].setCharAt(y, '.');
                    field[nx].setCharAt(y, c);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder[] field = new StringBuilder[12];
        for (int i = 0; i < 12; i++) {
            field[i] = new StringBuilder(br.readLine());
        }
        int chain = 0;
        while (pop(field)) {
            chain++;
            fall(field);
        }
        System.out.println(chain);
    }
}
