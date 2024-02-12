import java.io.*;
import java.util.*;

class Cleaner {
    final int[] DX = new int[]{-1, 0, 1 ,0};
    final int[] DY = new int[]{0, 1, 0, -1};

    int x, y;
    int direction;
    int cleaned;

    public Cleaner(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.cleaned = 0;
    }

    void clean(int[][] room) {
        if (room[this.x][this.y] == 0) {
            this.cleaned++;
            room[this.x][this.y] = 2;
            clean(room);
        }
        for (int i = 0; i < 4; i++) {
            rotate();
            int dx = this.x + this.DX[this.direction];
            int dy = this.y + this.DY[this.direction];
            if (room[dx][dy] == 0) {
                this.x = dx;
                this.y = dy;
                clean(room);
                return;
            }
        }
        int dx = x - this.DX[this.direction];
        int dy = y - this.DY[this.direction];

        if (room[dx][dy] == 1) {
            return;
        }
        this.x = dx;
        this.y = dy;
        clean(room);
    }

    void rotate() {
        if (this.direction != 0) {
            this.direction--;
        } else {
            this.direction = 3;
        }
    }
}

public class P14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Cleaner cleaner = new Cleaner(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int[][] room = new int[N][M];
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                room[x][y] = Integer.parseInt(st.nextToken());
            }
        }
        cleaner.clean(room);
        System.out.println(cleaner.cleaned);
    }
}
