import java.io.*;
import java.util.*;

public class P24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(st2.nextToken());
            if (st1.nextToken().equals("0")) {
                deque.offerLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st1 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < M; m++) {
            int num = Integer.parseInt(st1.nextToken());
            deque.offerFirst(num);
            sb.append(deque.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}
