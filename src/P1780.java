import java.io.*;

public class P1780 {
    static void cutting(String[][] paper, int len, int x, int y, int[] count) {
        String first = paper[x][y];
        boolean isSame = true;
        loop : for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (!paper[i][j].equals(first)) {
                    isSame = false;
                    break loop;
                }
            }
        }

        if (isSame) {
            count[Integer.parseInt(first) + 1]++;
        } else {
            int splited = len / 3;
            for (int i = x; i < x + len; i += splited) {
                for (int j = y; j < y + len; j += splited) {
                    cutting(paper, splited, i, j, count);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] paper = new String[N][N];
        for (int i = 0; i < N; i++) {
            paper[i] = br.readLine().split(" ");
        }

        int[] count = new int[3];
        cutting(paper, N, 0, 0, count);
        for (int i : count) {
            System.out.println(i);
        }
    }
}
