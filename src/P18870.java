import java.io.*;
import java.util.*;

public class P18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(s[i]);
        }
        Set<Integer> set = new TreeSet<>();
        for (int i : ints) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(ints[i])).append(" ");
        }
        System.out.println(sb);
    }
}
