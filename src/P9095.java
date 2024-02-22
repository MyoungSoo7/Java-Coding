import java.io.*;

public class P9095 {
    static final int[] DATA = new int[]{0, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            System.out.println(DATA[Integer.parseInt(br.readLine())]);
        }
    }
}
