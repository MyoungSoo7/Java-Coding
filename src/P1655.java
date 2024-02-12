import java.io.*;
import java.util.*;

public class P1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        min.offer(Integer.parseInt(br.readLine()));
        sb.append(min.peek()).append("\n");
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            min.offer(num);
            if (i % 2 == 1) {
                max.offer(min.poll());
            }

            if (min.peek() < max.peek()) {
                int temp = min.poll();
                min.offer(max.poll());
                max.offer(temp);
            }

            if (i % 2 == 1) {
                sb.append(max.peek()).append("\n");
            } else {
                sb.append(min.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
