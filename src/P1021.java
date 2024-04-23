import java.io.*;
import java.util.*;

public class P1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        for (int n = 1; n <= N; n++) {
            list.add(n);
        }

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            int find = Integer.parseInt(st.nextToken());
            if (list.getFirst() == find) {
                list.pollFirst();
                continue;
            }
            int index = list.indexOf(find);
            if (index <= list.size() / 2) {
                answer += index;
                for (int i = 0; i < index; i++) {
                    int temp = list.pollFirst();
                    list.offerLast(temp);
                }
            } else {
                answer += list.size() - index;
                for (int i = 0; i < list.size() - index; i++) {
                    int temp = list.pollLast();
                    list.offerFirst(temp);
                }
            }
            list.pollFirst();
        }
        System.out.println(answer);
    }
}
