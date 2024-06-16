import java.io.*;
import java.util.*;

public class P1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);
        LinkedList<Integer> person = new LinkedList<>();
        for (int n = 0; n < N; n++) {
            person.offer(n + 1);
        }

        List<Integer> answer = new ArrayList<>(N);
        int remove = K - 1;
        for (int n = 0; n < N; n++) {
            remove %= (N - n);
            answer.add(person.remove(remove));
            remove += K - 1;
        }
        System.out.println(answer.toString().replace('[', '<').replace(']', '>'));
    }
}
