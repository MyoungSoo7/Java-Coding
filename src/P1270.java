import java.io.*;
import java.util.*;

public class P1270 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        land : for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            Map<String, Integer> military = new HashMap<>();
            for (int t = 0; t < T; t++) {
                String num = st.nextToken();
                military.put(num, military.getOrDefault(num, 0) + 1);
            }

            for (String i : military.keySet()) {
                if (military.get(i) > T / 2) {
                    System.out.println(i);
                    continue land;
                }
            }
            System.out.println("SYJKGW");
        }
    }
}
