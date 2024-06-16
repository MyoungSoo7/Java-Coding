import java.io.*;
import java.util.*;

public class P13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]), L = Integer.parseInt(input[1]);

        Map<String, Integer> queue = new HashMap<>();
        for (int l = 0; l < L; l++) {
            String id = br.readLine();
            queue.put(id, l);
        }

        List<String> keySet = new ArrayList<>(queue.keySet());
        keySet.sort(Comparator.comparing(queue::get));
        for (int i = 0; i < Math.min(K, queue.size()); i++) {
            System.out.println(keySet.get(i));
        }
    }
}
