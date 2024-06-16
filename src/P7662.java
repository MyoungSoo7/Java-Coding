import java.io.*;
import java.util.*;

public class P7662 {
    static String solve(BufferedReader br) throws IOException {
        int k = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> asc = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer, Integer> des = new TreeMap<>();
        for (int t = 0; t < k; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case "I":
                    des.put(num, des.getOrDefault(num, 0) + 1);
                    asc.put(num, asc.getOrDefault(num, 0) + 1);
                    break;
                case "D":
                    Integer key;
                    if (des.isEmpty()) {
                        continue;
                    }

                    if (num == -1) {
                        key = des.firstKey();
                    } else {
                        key = asc.firstKey();
                    }

                    des.put(key, des.get(key) - 1);
                    asc.put(key, asc.get(key) - 1);
                    if (des.get(key) == 0) {
                        des.remove(key);
                        asc.remove(key);
                    }
            }
        }

        if (des.isEmpty()) {
            return "EMPTY";
        }
        return asc.firstKey() + " " + des.firstKey();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            System.out.println(solve(br));
        }
    }
}