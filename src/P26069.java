import java.io.*;
import java.util.*;

public class P26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Boolean> dancer = new HashMap<>();
        dancer.put("ChongChong", true);
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p1 = st.nextToken(), p2 = st.nextToken();
            if (dancer.getOrDefault(p1, false)) {
                dancer.put(p2, true);
            } else if (dancer.getOrDefault(p2, false)) {
                dancer.put(p1, true);
            }
        }
        System.out.println(dancer.size());
    }
}
