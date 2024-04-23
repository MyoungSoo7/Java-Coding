import java.io.*;
import java.util.*;

public class P5063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            int compare = Integer.compare(r, e - c);
            switch (compare) {
                case -1:
                    System.out.println("advertise");
                    break;
                case 0:
                    System.out.println("does not matter");
                    break;
                case 1:
                    System.out.println("do not advertise");
            }
        }
    }
}
