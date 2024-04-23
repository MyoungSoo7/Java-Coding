import java.io.*;
import java.util.*;

class Unit {
    int x, y;

    public Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Chess {
    static Map<String, int[]> moveSet;

    Unit king, stone;

    public Chess(int kx, int ky, int sx, int sy) {
        king = new Unit(kx, ky);
        stone = new Unit(sx, sy);

        moveSet = new HashMap<>();
        moveSet.put("R", new int[]{0, 1});
        moveSet.put("L", new int[]{0, -1});
        moveSet.put("B", new int[]{-1, 0});
        moveSet.put("T", new int[]{1, 0});
        moveSet.put("RT", new int[]{1, 1});
        moveSet.put("LT", new int[]{1, -1});
        moveSet.put("RB", new int[]{-1, 1});
        moveSet.put("LB", new int[]{-1, -1});
    }

    void move(String m) {
        int[] move = moveSet.get(m);
        int kx = king.x + move[0];
        int ky = king.y + move[1];
        int sx = stone.x + move[0];
        int sy = stone.y + move[1];
        boolean moveStone = false;
        if (stone.x == kx && stone.y == ky) {
            moveStone = true;
        }

        if ((0 <= kx && kx < 8 && 0 <= ky && ky < 8) && (!moveStone || 0 <= sx && sx < 8 && 0 <= sy && sy < 8)) {
            king.x = kx;
            king.y = ky;
            if (moveStone) {
                stone.x = sx;
                stone.y = sy;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (king.y + 'A')).append(king.x + 1).append("\n").append((char) (stone.y + 'A')).append(stone.x + 1);
        return sb.toString();
    }
}

public class P1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int kx = input[0].charAt(1) - '1', ky = input[0].charAt(0) - 'A';
        int sx = input[1].charAt(1) - '1', sy = input[1].charAt(0) - 'A';
        int N = Integer.parseInt(input[2]);
        Chess chess = new Chess(kx, ky, sx, sy);
        for (int n = 0; n < N; n++) {
            chess.move(br.readLine());
        }

        System.out.println(chess);
    }
}
