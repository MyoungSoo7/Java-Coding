import java.io.*;

public class P19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);
        StringBuilder table = new StringBuilder(br.readLine());
        int eat = 0;
        loop : for (int n = 0; n < N; n++) {
            if (table.charAt(n) == 'P') {
                for (int i = -K; i <= K; i++) {
                    int index = i + n;
                    if (0 <= index && index < N && table.charAt(index) == 'H') {
                        table.setCharAt(index, 'E');
                        eat++;
                        continue loop;
                    }
                }
            }
        }
        System.out.println(eat);
    }
}
